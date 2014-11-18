package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.internal.registry.osgi.OSGIUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchResultCollector;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.ISearchPattern;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.internal.core.ResolvedBinaryType;
import org.eclipse.jdt.internal.ui.search.JavaSearchScopeFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.commons.CCSLExecutionEngine;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.execution.engine.commons.RunConfiguration;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.GemocModelDebugger;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
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

	private ObservableBasicExecutionEngine _engine;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {	
		try 
		{
			RunConfiguration runConfiguration = new RunConfiguration(configuration);
			debug("About to initialize and run the GEMOC Execution Engine...");			

			ExecutionMode executionMode = null;
			if (ILaunchManager.DEBUG_MODE.equals(mode)
				&& runConfiguration.getAnimatorURI() != null) 
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
				launchEngine(_engine);
				// delegate for debug mode
				if (ILaunchManager.DEBUG_MODE.equals(mode)) {
					IEngineHook animator = AbstractGemocAnimatorServices.getAnimator();
					_engine.getExecutionContext().getExecutionPlatform().getHooks().add(animator);
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
//						String className =  executionContext.getRunConfiguration().getExecutionEntryPoint();
//						SearchPattern pattern = SearchPattern.createPattern(className,
//						IJavaSearchConstants.CLASS, 
//						IJavaSearchConstants.DECLARATIONS,
//						SearchPattern.R_EXACT_MATCH);
//							IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
//							ResolvedBinaryType type = null;
//							DefaultSearchRequestor requestor = new DefaultSearchRequestor();				
//							SearchEngine engine = new SearchEngine();
//						try {
//							engine.search(pattern, 
//							new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, 
//							scope, 
//							requestor,
//							null);
//							Class c = MyClassLoader.getClass(requestor._binaryType);
//							return null;
//						} catch (CoreException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}

						
						ActionCall call = FeedbackFactory.eINSTANCE.createActionCall();
						ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
						call.setTriggeringEvent(mse);
						mse.setCaller(executionContext.getResourceModel().getContents().get(0));
//						executionContext.getExecutionPlatform().getCodeExecutor().execute(call);
						ArrayList<Object> parameters = new ArrayList<>();
						parameters.add(executionContext.getResourceModel().getContents().get(0));
						try {
							executionContext.getExecutionPlatform().getCodeExecutor().execute(
																						executionContext.getRunConfiguration().getExecutionEntryPoint(), 
																						"main", 
																						parameters);
							return new Status(IStatus.OK, getPluginID(), "Execution was successfull");
						} catch (CodeExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return new Status(IStatus.ERROR, getPluginID(), "Execution was not successfull");
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

	private void launchEngine(ObservableBasicExecutionEngine _engine2) {
		// TODO Auto-generated method stub
		
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
		Collection<GemocExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values();
		for (GemocExecutionEngine engine : engines)
		{
			ObservableBasicExecutionEngine observable = (ObservableBasicExecutionEngine) engine;
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
		_engine.getExecutionContext().getExecutionPlatform().getHooks().add(res);
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
		
		public ResolvedBinaryType _binaryType;

		@Override
		public void acceptSearchMatch(SearchMatch match) throws CoreException {
			_binaryType = (ResolvedBinaryType)match.getElement();
			System.out.println(match.getElement());
		}
		
	}
}
