package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.commons.CCSLExecutionEngine;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.execution.engine.commons.RunConfiguration;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.GemocModelDebugger;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;
import org.kermeta.utils.provisionner4eclipse.Provisionner;
import org.osgi.framework.Bundle;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

public class Launcher
		extends
		fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI 
{
	
	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.GemocReflectiveModelLauncherID";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private AbstractExecutionEngine _engine;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {	
		try 
		{
			final RunConfiguration runConfiguration = new RunConfiguration(configuration);
			debug("About to initialize and run the GEMOC Execution Engine...");			

			ExecutionMode executionMode = null;
			if (ILaunchManager.DEBUG_MODE.equals(mode))
				//&& runConfiguration.getAnimatorURI() != null) 
			{
				executionMode = ExecutionMode.Animation;			
			}
			else
			{
				executionMode = ExecutionMode.Run;
			}
			final ModelExecutionContext executionContext = new ModelExecutionContext(runConfiguration, executionMode);			
			throwExceptionIfEngineAlreadyRunning(executionContext);

			if (executionContext.getFeedbackModel() != null) // hack to find out if execution involves a solver
			{
				_engine = new CCSLExecutionEngine(executionContext);				
				// delegate for debug mode
				if (ILaunchManager.DEBUG_MODE.equals(mode)) {
					IEngineAddon animator = AbstractGemocAnimatorServices.getAnimator();
					_engine.getExecutionContext().getExecutionPlatform().addEngineAddon(animator);
					super.launch(configuration, mode, launch, monitor);
				} else {
					Job job = new Job(getDebugJobName(configuration,
							getFirstInstruction(configuration))) {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							_engine.start();
							return new Status(IStatus.OK, getPluginID(),
									"Execution was successfull");
						}
					};
					job.schedule();
				}
			}
			else
			{
				Job job = new Job("exec")
				{

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						
						String className =  executionContext.getRunConfiguration().getExecutionEntryPoint();
						SearchPattern pattern = SearchPattern.createPattern(className,
						IJavaSearchConstants.CLASS, 
						IJavaSearchConstants.DECLARATIONS,
						SearchPattern.R_EXACT_MATCH);
						IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
						DefaultSearchRequestor requestor = new DefaultSearchRequestor();				
						SearchEngine engine = new SearchEngine();
						try {
							engine.search(pattern, 
							new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, 
							scope, 
							requestor,
							null);
						} catch (CoreException e) {
							return new Status(IStatus.ERROR, getPluginID(), "Execution was not successfull");
						}
						
//						requestor._binaryType.getJavaProject().getAllPackageFragmentRoots().contains(requestor._binaryType.getPackageFragment())

						
						IPackageFragmentRoot packageFragmentRoot = (IPackageFragmentRoot)requestor._binaryType.getPackageFragment().getParent();
						
						String projectName = requestor._binaryType.getJavaProject().getElementName();
						IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
						boolean shouldLookInBundle = true;
						if (project != null
							&& project.exists()
							&& !project.getFullPath().equals(executionContext.getWorkspace().getProjectPath()))
						{
							Provisionner p = new Provisionner();
							IStatus status = p.provisionFromProject(project, monitor);
							if (!status.isOK())
							{
								return status;
							}
							shouldLookInBundle = false;
						}
						
//						try {
							ArrayList<Object> parameters = new ArrayList<>();
							parameters.add(executionContext.getResourceModel().getContents().get(0));
							String bundleName = null;
							if (shouldLookInBundle)
							{
								bundleName = packageFragmentRoot.getPath().removeLastSegments(1).lastSegment().toString();
							}
							else
							{
								bundleName = project.getName();
							}
							Class<?> c;

							Bundle bundle = Platform.getBundle(bundleName);
							if (bundle == null)
							{
								return new Status(IStatus.ERROR, getPluginID(), "Could not find bundle " + bundleName + ".");								
							}
							
							try {
								c = bundle.loadClass(executionContext.getRunConfiguration().getExecutionEntryPoint());
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
								return new Status(IStatus.ERROR, getPluginID(), "Could not find class " + executionContext.getRunConfiguration().getExecutionEntryPoint() + " in bundle " + bundleName + ".");
							}
							Method method;
							try {
								method = c.getMethod("main", parameters.get(0).getClass().getInterfaces()[0]);
							} catch (Exception e) {
								e.printStackTrace();
								return new Status(IStatus.ERROR, getPluginID(), "Could not find method main with correct parameters.");
							}
							Object o;
							try {
								o = c.newInstance();
							} catch (Exception e) {
								e.printStackTrace();
								return new Status(IStatus.ERROR, getPluginID(), "Could not instanciate class " + executionContext.getRunConfiguration().getExecutionEntryPoint() + ".");
							} 
							try {
								method.invoke(o, parameters.get(0));
							} catch (Exception e) {
								e.printStackTrace();
								return new Status(IStatus.ERROR, getPluginID(), "Invokation of method main failed.");
							} 
//						} catch (Exception e1) {
//							e1.printStackTrace();
//							return new Status(IStatus.ERROR, getPluginID(), "Execution was not successfull");
//						}
						


						
//						ActionCall call = FeedbackFactory.eINSTANCE.createActionCall();
//						ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
//						call.setTriggeringEvent(mse);
//						mse.setCaller(executionContext.getResourceModel().getContents().get(0));
////						executionContext.getExecutionPlatform().getCodeExecutor().execute(call);
//						ArrayList<Object> parameters = new ArrayList<>();
//						parameters.add(executionContext.getResourceModel().getContents().get(0));
//						try {
//							executionContext.getExecutionPlatform().getCodeExecutor().execute(
//																						executionContext.getRunConfiguration().getExecutionEntryPoint(), 
//																						"main", 
//																						parameters);
//							return new Status(IStatus.OK, getPluginID(), "Execution was successfull");
//						} catch (CodeExecutionException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						return new Status(IStatus.OK, getPluginID(), "Execution was successfull");
					}
					
				};
				job.schedule();
//				String className =  executionContext.getRunConfiguration().getExecutionEntryPoint();
//				//IProject project = ResourcesPlugin.getWorkspace().ge;
//
//				List<IResource> resources = new ArrayList<>();
//				IPath path = executionContext.getWorkspace().getProjectPath();
//				resources.add(ResourcesPlugin.getWorkspace().getRoot().getProject(path.toString()));
//				
//				SearchPattern pattern = SearchPattern.createPattern(className,
//																	IJavaSearchConstants.CLASS, 
//																	IJavaSearchConstants.DECLARATIONS,
//																	SearchPattern.R_EXACT_MATCH);
//				IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
//				ResolvedBinaryType type = null;
//				DefaultSearchRequestor requestor = new DefaultSearchRequestor();				
//				SearchEngine engine = new SearchEngine();
//				engine.search(pattern, 
//							new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, 
//							scope, 
//							requestor,
//							null);
				
//				IMethod constructor = null;
//				IMethod main = null;
//				Class.forName(requestor._binaryType.);
//				for (IMethod m : requestor._binaryType.getMethods())
//				{
////					if (m.get)
//				}
				
				
//				IJavaSearchScope searchScope = JavaSearchScopeFactory.getInstance().createJavaSearchScope(resources.toArray(new IResource[resources.size()]), true);
//				ISearchPattern searchPattern = SearchEngine.createSearchPattern(className, IJavaSearchConstants.CLASS, IJavaSearchConstants.DECLARATIONS, false);
//				IJavaSearchResultCollector resultCollector = new IJavaSearchResultCollector() {
//					
//					@Override
//					public IProgressMonitor getProgressMonitor() {
//						// TODO Auto-generated method stub
//						return null;
//					}
//					
//					@Override
//					public void done() {
//						return;
//					}
//					
//					@Override
//					public void accept(IResource resource, int start, int end,
//							IJavaElement enclosingElement, int accuracy) throws CoreException {
//						return;
//					}
//					
//					@Override
//					public void aboutToStart() {
//						return;
//					}
//				};
//				new SearchEngine().search(ResourcesPlugin.getWorkspace(),
//		                   				searchPattern,
//		                   				searchScope,
//		                   				resultCollector);
				
//				String bundleName = executionContext.getWorkspace().getProjectPath().toString().replace("/", "");
//				Platform.getBundle(bundleName);
//				Class modelRootClass = OSGIUtils.getDefault().getBundle(bundleName).loadClass(className);
//				Object o = modelRootClass.newInstance();
				
//				Object o = executionContext.getRunConfiguration().instanciateJavaEntryPoint();
//				Class modelRootClass = executionContext.getResourceModel().getContents().get(0).getClass();
//				Method m = o.getClass().getMethod("main", modelRootClass);
//				m.invoke(o, executionContext.getResourceModel().getContents().get(0));
			}
		} 
		catch (Exception e)
		{
			String message = "Error occured when starting execution engine: " + e.getMessage() +  " (see inner exception).";
		  	//error(message);
			e.printStackTrace();
		  	throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
		}
	}

//	private Session openNewSiriusSession(URI sessionResourceURI, final IProgressMonitor monitor) throws CoreException {
//		final ResourceSet set = ResourceSetFactory.createFactory().createResourceSet(sessionResourceURI);
//		set.getURIConverter().getURIHandlers().add(0, new DebugURIHandler());
//		final Session session = DebugSessionFactory.INSTANCE.createSession(set, sessionResourceURI);
//		session.open(monitor);
//		for (DView view : session.getSelectedViews())
//		{
//			for (DRepresentation representation : view.getOwnedRepresentations())
//			{
//				final DSemanticDiagramSpec diagram = (DSemanticDiagramSpec)representation;
//				DialectUIManager.INSTANCE.openEditor(session, representation, monitor);
//
//				final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
//				final CommandStack commandStack = editingDomain.getCommandStack();
//				commandStack.execute(new RecordingCommand(editingDomain) {
//					@Override
//					protected void doExecute() {
//						for(Layer l : diagram.getDescription().getAdditionalLayers())
//						{
//							boolean mustBeActive = l.getName().toUpperCase().contains("DEBUG")
//									|| l.getName().toUpperCase().contains("ANIMATION");
//							if (mustBeActive
//									&& !diagram.getActivatedLayers().contains(l))
//							{
//								ChangeLayerActivationCommand c = new ChangeLayerActivationCommand(
//										editingDomain, 
//										diagram, 
//										l, 
//										monitor);
//								c.execute();															
//							}
//						}
//					}
//				});
//			}
//		}
//
//		return session;
//	}

//	private void killPreviousSiriusSession(URI sessionResourceURI, IProgressMonitor monitor) {
//		Session session = SessionManager.INSTANCE.getExistingSession(sessionResourceURI);
//		if (session != null) {
//			session.close(monitor);
//			SessionManager.INSTANCE.remove(session);			
//		}
//	}


	private void throwExceptionIfEngineAlreadyRunning(ModelExecutionContext executionContext) throws CoreException 
	{
		// make sure there is no other running engine on this model
		Collection<IExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values();
		for (IExecutionEngine engine : engines)
		{
			AbstractExecutionEngine observable = (AbstractExecutionEngine) engine;
  		  	if (observable.getEngineStatus().getRunningStatus() != RunStatus.Stopped 
  		  		&&  observable.getExecutionContext().getResourceModel().getURI().equals(URI.createPlatformResourceURI(executionContext.getWorkspace().getModelPath().toString(), true)))
  		  	{
  		  		String message = "An engine is already running on this model, please stop it first";
  		  		warn(message);
  		  		throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
  		  	}
		}
	}

	private void debug(String message) {
		getMessagingSystem().debug(message, getPluginID());
	}

	private void info(String message) {
		getMessagingSystem().info(message, getPluginID());
	}

	private void warn(String message) {
		getMessagingSystem().warn(message, getPluginID());
	}

	private void error(String message) {
		getMessagingSystem().error(message, getPluginID());
	}

	private MessagingSystem getMessagingSystem() {
		return Activator
				.getDefault()
				.getMessaggingSystem();	
	}
	
	@Override
	protected String getLaunchConfigurationTypeID() {
		return TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(ISelection selection) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(IEditorPart editor) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(ILaunchConfiguration configuration) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected IDSLDebugger getDebugger(ILaunchConfiguration configuration,
			DSLDebugEventDispatcher dispatcher, EObject firstInstruction,
			IProgressMonitor monitor) {
		GemocModelDebugger res = new GemocModelDebugger(dispatcher, _engine);
		_engine.getExecutionContext().getExecutionPlatform().addEngineAddon(res);
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
		public void acceptSearchMatch(SearchMatch match) throws CoreException {
			_binaryType = (IType)match.getElement();
			System.out.println(match.getElement());
		}
		
	}
}
