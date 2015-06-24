package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.execution.engine.commons.RunConfiguration;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.PlainK3ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.extensions.k3.K3Solver;
import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocDebuggerServices;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.GemocModelDebugger;
import org.kermeta.utils.provisionner4eclipse.Provisionner;
import org.osgi.framework.Bundle;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

public class Launcher extends fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI
{

	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.launcher";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private IExecutionEngine _executionEngine;

	@Override
	public void launch(ILaunchConfiguration configuration,final String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException
	{
		try
		{
			final RunConfiguration runConfiguration = new RunConfiguration(configuration);
			debug("About to initialize and run the GEMOC Execution Engine...");

			ExecutionMode executionMode = null;
			if (ILaunchManager.DEBUG_MODE.equals(mode))
			// && runConfiguration.getAnimatorURI() != null)
			{
				executionMode = ExecutionMode.Animation;
			} else
			{
				executionMode = ExecutionMode.Run;
			}
			if( isEngineAlreadyRunning(runConfiguration.getExecutedModelURI())){
				return;
			}
			final ModelExecutionContext executionContext = new ModelExecutionContext(runConfiguration, executionMode);

			// hack to find out if execution involves a solver
			if (!(executionContext.getExecutionPlatform().getSolver() instanceof K3Solver))
			{
				_executionEngine = new ExecutionEngine(executionContext);
				// delegate for debug mode
				if (ILaunchManager.DEBUG_MODE.equals(mode))
				{
					IEngineAddon animator = AbstractGemocAnimatorServices.getAnimator();
					_executionEngine.getExecutionContext().getExecutionPlatform().addEngineAddon(animator);
					super.launch(configuration, mode, launch, monitor);
				} else
				{
					Job job = new Job(getDebugJobName(configuration, getFirstInstruction(configuration))) {

						@Override
						protected IStatus run(IProgressMonitor monitor)
						{
							_executionEngine.start();
							return new Status(IStatus.OK, getPluginID(), "Execution was successfull");
						}
					};
					job.schedule();
				}
			} else
			{				
				Job job = new Job(getDebugJobName(configuration,
						getFirstInstruction(configuration))+" (running in plainK3 mode)")
				{

					@Override
					protected IStatus run(IProgressMonitor monitor)
					{

						String className = executionContext.getRunConfiguration().getExecutionEntryPoint();
						SearchPattern pattern = SearchPattern.createPattern(className, IJavaSearchConstants.CLASS,
								IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH);
						IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
						DefaultSearchRequestor requestor = new DefaultSearchRequestor();
						SearchEngine engine = new SearchEngine();
						try
						{
							engine.search(pattern,
									new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope,
									requestor, null);
						} catch (CoreException e)
						{
							return new Status(IStatus.ERROR, getPluginID(), "Execution was not successfull");
						}

						IPackageFragmentRoot packageFragmentRoot = (IPackageFragmentRoot) requestor._binaryType
								.getPackageFragment().getParent();

						ArrayList<Object> parameters = new ArrayList<>();
						parameters.add(executionContext.getResourceModel().getContents().get(0));
						String bundleName = null;

						bundleName = packageFragmentRoot.getPath().removeLastSegments(1).lastSegment().toString();

						Class<?> c;

						// First we try to look into an already loaded bundle
						Bundle bundle = Platform.getBundle(bundleName);

						// If this doesn't work, we use the provisioner to load
						// the corresponding project
						if (bundle == null)
						{

							String projectName = requestor._binaryType.getJavaProject().getElementName();
							IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
							if (project != null && project.exists()
									&& !project.getFullPath().equals(executionContext.getWorkspace().getProjectPath()))
							{
								Provisionner p = new Provisionner();
								IStatus status = p.provisionFromProject(project, monitor);
								if (!status.isOK())
								{
									return status;
								}
							}
							bundleName = project.getName();
							bundle = Platform.getBundle(bundleName);

							// If is still doesn't work, it's nowhere to be
							// found, and we have an error
							if (bundle == null)
								return new Status(IStatus.ERROR, getPluginID(), "Could not find bundle " + bundleName
										+ ".");
						}

						try
						{
							c = bundle.loadClass(executionContext.getRunConfiguration().getExecutionEntryPoint());
						} catch (ClassNotFoundException e)
						{
							e.printStackTrace();
							return new Status(IStatus.ERROR, getPluginID(), "Could not find class "
									+ executionContext.getRunConfiguration().getExecutionEntryPoint() + " in bundle "
									+ bundleName + ".");
						}
						Method method;
						try
						{
							method = c.getMethod("main", parameters.get(0).getClass().getInterfaces()[0]);
						} catch (Exception e)
						{
							e.printStackTrace();
							return new Status(IStatus.ERROR, getPluginID(),
									"Could not find method main with correct parameters.");
						}
						Object o;
						try
						{
							o = c.newInstance();
						} catch (Exception e)
						{
							e.printStackTrace();
							return new Status(IStatus.ERROR, getPluginID(), "Could not instanciate class "
									+ executionContext.getRunConfiguration().getExecutionEntryPoint() + ".");
						}
						
						_executionEngine = new PlainK3ExecutionEngine(executionContext, o, method, parameters);
						if (ILaunchManager.DEBUG_MODE.equals(mode))
						{
							IEngineAddon animator = AbstractGemocAnimatorServices.getAnimator();
							_executionEngine.getExecutionContext().getExecutionPlatform().addEngineAddon(animator);
						}
						_executionEngine.start();
						return new Status(IStatus.OK, getPluginID(), "Execution was launched successfully");
					}

				};
				job.schedule();
			}
		} catch (Exception e)
		{
			String message = "Error occured when starting execution engine: " + e.getMessage()
					+ " (see inner exception).";
			// error(message);
			e.printStackTrace();
			throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
		}
	}

	private boolean isEngineAlreadyRunning(URI launchedModelURI) throws CoreException
	{
		// make sure there is no other running engine on this model
		Collection<IExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry
				.getRunningEngines().values();
		for (IExecutionEngine engine : engines)
		{
			AbstractExecutionEngine observable = (AbstractExecutionEngine) engine;
			if (observable.getRunningStatus() != RunStatus.Stopped
					&& observable
							.getExecutionContext()
							.getResourceModel()
							.getURI()
							.equals(launchedModelURI))
			{
				String message = "An engine is already running on this model, please stop it first";
				warn(message);				
				return true;
			}
		}
		return false;
	}
	
	private void debug(String message)
	{
		getMessagingSystem().debug(message, getPluginID());
	}

	private void info(String message)
	{
		getMessagingSystem().info(message, getPluginID());
	}

	private void warn(final String message)
	{
		getMessagingSystem().warn(message, getPluginID());
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
		    public void run() {
		    	MessageDialog.openWarning(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"GEMOC Engine Launcher",
						message);
		    }
		});
	}

	private void error(final String message)
	{
		getMessagingSystem().error(message, getPluginID());
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
		    public void run() {
		    	MessageDialog.openError(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"GEMOC Engine Launcher",
						message);
		    }
		});
	}

	private MessagingSystem getMessagingSystem()
	{
		return Activator.getDefault().getMessaggingSystem();
	}

	@Override
	protected String getLaunchConfigurationTypeID()
	{
		return TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(ISelection selection)
	{
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(IEditorPart editor)
	{
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(ILaunchConfiguration configuration)
	{
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected IDSLDebugger getDebugger(ILaunchConfiguration configuration, DSLDebugEventDispatcher dispatcher,
			EObject firstInstruction, IProgressMonitor monitor)
	{
		GemocModelDebugger res = new GemocModelDebugger(dispatcher, _executionEngine);
		_executionEngine.getExecutionContext().getExecutionPlatform().addEngineAddon(res);
		return res;
	}

	@Override
	protected String getDebugTargetName(ILaunchConfiguration configuration, EObject firstInstruction)
	{
		return "Gemoc debug target";
	}

	@Override
	protected List<IDSLCurrentInstructionListener> getCurrentInstructionListeners()
	{
		List<IDSLCurrentInstructionListener> result = super.getCurrentInstructionListeners();
		result.add(AbstractGemocDebuggerServices.LISTENER);
		return result;
	}

	@Override
	protected String getDebugJobName(ILaunchConfiguration configuration, EObject firstInstruction)
	{
		return "Gemoc debug job";
	}

	@Override
	protected String getPluginID()
	{
		return Activator.PLUGIN_ID;
	}

	@Override
	protected String getModelIdentifier()
	{
		return MODEL_ID;
	}

	class DefaultSearchRequestor extends SearchRequestor
	{

		public IType _binaryType;

		@Override
		public void acceptSearchMatch(SearchMatch match) throws CoreException
		{
			_binaryType = (IType) match.getElement();
			System.out.println(match.getElement());
		}

	}

	
	@Override
	protected ILaunchConfiguration[] createLaunchConfiguration(IResource file,
			EObject firstInstruction, String mode) throws CoreException {
		ILaunchConfiguration[] launchConfigs = super.createLaunchConfiguration(file, firstInstruction, mode);
		
		if(launchConfigs.length == 1){
			// open configuration for further editing
			if(launchConfigs[0] instanceof ILaunchConfigurationWorkingCopy){
				ILaunchConfigurationWorkingCopy configuration = (ILaunchConfigurationWorkingCopy)launchConfigs[0];
				
				String selectedLanguage = configuration.getAttribute(RunConfiguration.LAUNCH_SELECTED_LANGUAGE, "");
				if(selectedLanguage.equals("")){
				
					// TODO try to infer possible language and other attribute from project content and environment
					configuration.setAttribute(
							RunConfiguration.LAUNCH_SELECTED_DECIDER,
							RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP);
					final ILaunchGroup group = DebugUITools.getLaunchGroup(configuration, mode);
					if (group != null) {
						ILaunchConfiguration savedLaunchConfig = configuration.doSave();
						// open configuration for user validation and inputs
						DebugUITools.openLaunchConfigurationDialogOnGroup(PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell(),
								new StructuredSelection(savedLaunchConfig), group.getIdentifier(), null);
						//DebugUITools.openLaunchConfigurationDialog(PlatformUI.getWorkbench()
						//		.getActiveWorkbenchWindow().getShell(), savedLaunchConfig, group.getIdentifier(), null);
					}
				}
			}
		}
		return launchConfigs;
		
	}
	
}
