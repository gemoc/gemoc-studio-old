package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.commons.dsa.IAliveClockController;
import org.gemoc.execution.engine.core.ModelExecutionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.execution.engine.io.backends.ConsoleBackend;
import org.gemoc.execution.engine.io.core.Backend;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.frontends.PrepareViewFrontend;
import org.gemoc.execution.engine.io.views.obeo.InstructionRevealer;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;
import org.gemoc.gemoc_language_workbench.api.extension.LanguageDefinition;
import org.gemoc.gemoc_language_workbench.api.extension.LanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;
import org.kermeta.utils.systemservices.eclipse.api.EclipseMessagingSystem;

import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;
import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;

public class GemocReflectiveModelLauncher
		extends
		fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI {
	// ILaunchConfigurationDelegate {
	
	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.GemocReflectiveModelLauncherID";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private ILaunchConfiguration _launchConfiguration;
	
	private ObservableBasicExecutionEngine engine;

	private ModelExecutionContext _executionContext;
	
	private String getModelPathAsString() {
		return _executionContext.getModelPath().toString();
	}

	private String getDebuggerViewPathAsString() {
		return _executionContext.getDebuggerViewModelPath().toString();
	}

	private String getMoCPathAsString() {
		return _executionContext.getMoCPath().toString();
	}

	private String getLanguageName() throws CoreException {
		return _launchConfiguration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE, "");
	}

	private String getLaunchAttribute(String attributeName) throws CoreException {
		return _launchConfiguration.getAttribute(attributeName, "");
	}

	
	private void createModelExecutionContext()
			throws CoreException {
		_executionContext = new ModelExecutionContext(
									_launchConfiguration.getFile().getParent().getParent().getFullPath(), 
									new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI)),
									new Path(getLaunchAttribute(AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI)));
	}

	
	
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		_siriusSession = null;
		engine = null;
		_executionContext = null;
		
		_launchConfiguration = configuration;		
		createModelExecutionContext();
				
		getMessagingSystem().showConsole();
		debug("About to initialize and run the GEMOC Execution Engine...");

		//String sessionPath = configuration.getAttribute(SIRIUS_RESOURCE_URI, "");
		//String modelPath = configuration.getAttribute(AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");
		
		// make sure there is no other running engine on this model
		for( GemocExecutionEngine engine :org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values()){
  		  ObservableBasicExecutionEngine observable = (ObservableBasicExecutionEngine) engine;
  		  if(observable.getEngineStatus().getRunningStatus() != RunStatus.Stopped &&  observable.getModelUnderExecutionResource().getURI().equals(URI.createPlatformResourceURI(getModelPathAsString(), true))){
  			  warn("An engine is already running on this model, please stop it first");
  			return;
  		  }
		}
		
		boolean animate = Boolean.parseBoolean(configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_ANIMATE, "false"));
		int delay = 0;
		if (animate) {
			delay=Integer.parseInt(configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_DELAY, "0"));
		}
		boolean isTraceActive = Boolean.parseBoolean(configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_ACTIVE_TRACE, "false"));

		String deciderName = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_DECIDER,
						"");
//		final String modelOfExecutionFilePath = configuration
//				.getAttribute(
//						GemocModelLauncherConfigurationConstants.LAUNCH_MODELOFEXECUTION_GLML_PATH,
//						"");

		//IConfigurationElement confElement = LanguageDefinitionExtension.findDefinition(getLanguageName());
		LanguageDefinition languageDefinition = LanguageDefinitionExtension.findDefinition(getLanguageName());

		// All these elements are required to construct the engine. They are
		// retrieved from the Extension Points of the xDSML.
		Solver solver = null;
		EventExecutor eventExecutor = null;
		CodeExecutor codeExecutor = null;
		FeedbackPolicy feedbackPolicy = null;
//		ModelLoader modelLoader = null;
		
		Collection<IEngineHook> engineHooks = languageDefinition.instanciateEngineHooks();
		Collection<IClockController> clockControllers = languageDefinition.instanciateClockControllers();
		
		// get the extension objects
		if (languageDefinition != null) {
			debug("Starting to retrieve components from the configuration...");
			try {
				solver = languageDefinition.instanciateSolver();
				eventExecutor = languageDefinition.instanciateEventExecutor();
				codeExecutor = languageDefinition.instanciateCodeExecutor();
				feedbackPolicy = languageDefinition.instanciateFeedbackPolicy();
//				modelLoader = instanciateModelLoader(confElement);
			} catch (CoreException e) {
				warn(e.getMessage());
			}

//			String dseResourcePath = confElement
//					.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT);
			
			
			// [FT] To disappear?
//			String mocEventResourcePath = confElement.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT);
//			if (mocEventResourcePath != null) {
//				ResourceSet resSet = new ResourceSetImpl();
//				if(mocEventResourcePath.startsWith("/")) {
//					mocEventsResource = resSet.getResource(URI.createPlatformPluginURI(mocEventResourcePath, true), true);
//					
//				} else {
//					mocEventsResource = resSet.getResource(URI.createURI(mocEventResourcePath), true);
//				}
//			} else {
//				warn(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT
//								+ " isn't set");
//			}

			// If there is a custom ModelLoader then we will use this,
			// else we should rely on some default XMI ModelLoader.
			/*if (dseResourcePath != null) {
				
				//com.google.inject.Injector injector = fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ui.internal.ExtendedCCSLActivator.getInstance().getInjector("extendedCCSL");
				//injector.
				//IFile modelIFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelPath));
				//modelIFile.getProject();
				//ResourceSet resourceSet = resourceSetProvider.get(modelIFile.getProject());
				
				/*com.google.inject.Injector injector = fr.inria.aoste.timesquare.ccslkernel.parser.xtext.ui.internal.ExtendedCCSLActivator.getInstance().getInjector("extendedCCSL");
				
				//com.google.inject.Injector injector = new ExtendedCCSLStandaloneSetup().createInjector();
				XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
				resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
				Resource modelRes = modelLoader.loadModel(modelPath);
				
				resourceSet.getResources().add(modelRes);
				
				ECLPackage.eINSTANCE.eClass();
				TimeModelPackage.eINSTANCE.eClass(); // force registration of ccsl
				//ResourceSet resSet = modelRes.getResourceSet(); // use same resource set as model
				Resource eclResource =  resourceSet.getResource(URI.createURI("platform:/plugin/org.gemoc.sample.tfsm.eclmoc2as/ecl/TFSM.ecl",true), true);
				if(dseResourcePath.startsWith("/")){
					domainSpecificEventsResource = resourceSet.getResource(
						URI.createPlatformPluginURI(dseResourcePath, true), true);
				}
				else{
					domainSpecificEventsResource = resourceSet.getResource(
							URI.createURI(dseResourcePath, true), true);
				}
				EcoreUtil.resolveAll(resourceSet);
				Map<EObject, Collection<Setting>>  unresolvedProxies = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
				if(unresolvedProxies.size() != 0){
					Activator
					.getDefault()
					.getMessaggingSystem()
					.warn("There are unresolved proxies in "+dseResourcePath+ ", the first is "+unresolvedProxies.entrySet().toArray()[0], Activator.PLUGIN_ID);
					
				}
				*/
		/*	} else {
				Activator
						.getDefault()
						.getMessaggingSystem()
						.warn(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT
								+ " isn't set", Activator.PLUGIN_ID);
			}*/
		}
		else{
			error("Cannot find xdsml definition for the language " + getLanguageName() + ", please verify that is is correctly deployed.");
			Activator.error("Cannot find xdsml definition for the language " + getLanguageName() + ", please verify that is is correctly deployed", new NullPointerException("Cannot find xdsml definition for the language "));
		}

		// Ugly calls to check if all the elements have been provided as
		// required.
		this.reactToNull(solver, "Solver");
		this.reactToNull(eventExecutor, "Executor");
		this.reactToNull(feedbackPolicy, "Feedback Policy");
		//this.reactToNull(domainSpecificEventsResource,
		//		"Domain Specific Events Resource");
		//this.reactToNull(mocEventsResource, "MoC Events Resource");
//		this.reactToNull(modelLoader, "Model Loader");
		// TODO will probably be replaced by an internal map in the engine,
		// created form the domainSpecificEventsResource)
		//this.reactToNull(modelOfExecutionFilePath, "modelOfExecutionFilePath");
		
		ResourceSet resourceSet = getResourceSet(animate, getDebuggerViewPathAsString());
		
		String transformationPath = languageDefinition.getQVTOPath();
		_executionContext.generateMoC(transformationPath);
		URI mocURI = URI.createPlatformResourceURI(_executionContext.getMoCPath().toString(), true);
		solver.setSolverInputFile(resourceSet, mocURI);
		
		Resource modelResource = getModelResource(resourceSet, getModelPathAsString());
	//	TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		if (animate) {
			// [FT] do not use the editing domain from sirius for now
			// editingDomain = attachSiriusIfNecessary();
		}
		
//		if (mocPath != null && !mocPath.isEmpty()) {
//			info("forcing the solverInput to user defined extendedCCSL " + mocPath);			
//			// initialize solver
//			solver.setSolverInputFile(URI.createPlatformResourceURI(mocPath, true));
//		} else {
//			
//			// TODO complement this step by a pre-run action that will build the
//			// extended-ccsl from the model using the qvto transformation
//			error("automatic call to qvto transformation  not implemented yet. Please specify a manually generated extendedCCSL file.");
//			URI solverInputFileURI = solver.prepareSolverInputFileForUserModel(URI.createPlatformResourceURI(mocPath, true));
//			solver.setSolverInputFile(solverInputFileURI);
//			return;
//		}

		// create decider
		ILogicalStepDecider decider = LogicalStepDeciderFactory.CreateDecider(deciderName, solver);

		// Create required Frontends
		// TODO : Hard-coded Frontends and Backends... It should be selectable
		// in the launch configuration etc.
		// Frontend controlPanel = new ExampleGUIControlPanel();
		// Frontend scenarioBuilder = new ExampleScenarioBuilder();
		List<Frontend> frontends = new ArrayList<Frontend>();
		frontends.add(new PrepareViewFrontend());
		// frontends.add(controlPanel);
		// frontends.add(scenarioBuilder);

		// Create required Backends
		List<Backend> backends = new ArrayList<Backend>();
		backends.add(new ConsoleBackend());

		// Create and initialize engine
		engine = new ObservableBasicExecutionEngine(solver, eventExecutor, codeExecutor, feedbackPolicy, decider, _executionContext);
		engine.setSiriusSession(_siriusSession);
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		if (_siriusSession != null)
			editingDomain = _siriusSession.getTransactionalEditingDomain();

		for(IClockController clockController: clockControllers){
			if (clockController instanceof IAliveClockController)
				engine.addClockController((IAliveClockController)clockController);
		}

		engine.initialize(modelResource, editingDomain);

		if (isTraceActive)
			engine.activateTrace();
		
		for(IEngineHook engineHook : engineHooks){
			engine.addEngineHook(engineHook);
		}
		
		// engine.
		// configure altogether
		configureEngine(engine, frontends, backends, delay);
		engine.setInstructionRevealer(new InstructionRevealer(_executionContext.getDebuggerViewModelPath()));

//		if (animate) {
//			DSLDebugModelPresentation p = new DSLDebugModelPresentation();
//			p.getEditorInput(engine.getModelUnderExecutionResource().getContents().get(0));
//			engine.showInstruction(engine.getModelUnderExecutionResource().getContents().get(0));
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		// delegate for debug mode
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			super.launch(configuration, mode, launch, monitor);
		} else {
			Job job = new Job(getDebugJobName(configuration,
					getFirstInstruction(configuration))) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					engine.start();
					return new Status(IStatus.OK, getPluginID(),
							"Execution was successfull");
				}
			};
			job.schedule();
		}
	}

//	private TransactionalEditingDomain attachSiriusIfNecessary() {
//		URI uri = URI.createPlatformResourceURI(getDebuggerViewPathAsString(), true);
//		Session session = SessionManager.INSTANCE.getSession(uri, new NullProgressMonitor());
//		TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
//		return editingDomain; 
//	}


	
//	private ModelLoader instanciateModelLoader(IConfigurationElement confElement) throws CoreException {
//		final Object oModelLoader = confElement.createExecutableExtension(LanguageDefinitionExtension.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
//		if (oModelLoader instanceof ModelLoader) {
//			return (ModelLoader) oModelLoader;
//		}
//		return null;
//	}



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

	private EclipseMessagingSystem getMessagingSystem() {
		return Activator
				.getDefault()
				.getMessaggingSystem();	
	}

	private Session _siriusSession;
	private ResourceSet getResourceSet(boolean animate, String sessionPath) {
		if (animate) {
			URI uri = URI.createPlatformResourceURI(sessionPath, true);
			_siriusSession = SessionManager.INSTANCE.getSession(uri, new NullProgressMonitor());
			return _siriusSession.getTransactionalEditingDomain().getResourceSet();
		} else {
			return new ResourceSetImpl();
		}
//		return new ResourceSetImpl();
	}
	
	protected Resource getModelResource(ResourceSet resourceSet, String modelPath) throws CoreException {		
		return resourceSet.getResource(URI.createPlatformResourceURI(modelPath, true), true);
	}

	private void reactToNull(Object o, String name) {
		if (o == null) {
			warn("WARNING: " + name + " is null !");
			Activator.warn(name + " is null", new NullPointerException(name));
		}
	}

	protected void configureEngine(
						GemocExecutionEngine engine,
						List<Frontend> frontends,
						List<Backend> backends, 
						int delay) {
		engine.setDelay(delay);		
		// Links the Execution Engine to the Frontends
		for (Frontend frontend : frontends) {
			frontend.initialize(engine);
		}
		// Configures all the backends and links the Execution Engine to the
		// Backends
		for (Backend backend : backends) {
			backend.configure();
			((Observable) engine).addObserver((Observer) backend);
		}
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
		GemocModelDebugger res = new GemocModelDebugger(dispatcher, engine);
		engine.setDebugger(res);
		return res;
	}

	@Override
	protected String getDebugTargetName(ILaunchConfiguration configuration,
			EObject firstInstruction) {
		// TODO Auto-generated method stub
		return "Gemoc debug target";
	}

	@Override
	protected List<IDSLCurrentInstructionListener> getCurrentInstructionListeners() {

		List<IDSLCurrentInstructionListener> result = super.getCurrentInstructionListeners();
		result.add(AbstractGemocDebuggerServices.LISTENER);
		return result;
	}

	@Override
	protected String getDebugJobName(ILaunchConfiguration configuration,
			EObject firstInstruction) {
		return "Gemoc debug job";
	}

	@Override
	protected String getPluginID() {
		return Activator.PLUGIN_ID;
	}

	@Override
	protected String getModelIdentifier() {
		return MODEL_ID;
	}
}
