package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.CoreException;
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
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

public class GemocReflectiveModelLauncher
		extends
		fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI {
	// ILaunchConfigurationDelegate {
	
	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.GemocReflectiveModelLauncherID";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private ILaunchConfiguration _launchConfiguration;
	
	private ObservableBasicExecutionEngine _engine;

	private ModelExecutionContext _executionContext;
	
	private String getModelPathAsString() {
		return _executionContext.getModelPath().toString();
	}

	private String getDebuggerViewPathAsString() {
		return _executionContext.getDebuggerViewModelPath().toString();
	}

	private void createModelExecutionContext()
			throws CoreException {
		_executionContext = new ModelExecutionContext(
									_launchConfiguration.getFile().getParent().getParent().getFullPath(), 
									new Path(_runConfiguration.getModelURIAsString()),
									new Path(_runConfiguration.getAnimatorURIAsString()));
	}

	
	private RunConfiguration _runConfiguration;
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		_runConfiguration = null;
		_siriusSession = null;
		_engine = null;
		_executionContext = null;		
		_launchConfiguration = configuration;		
		_runConfiguration = new RunConfiguration(configuration);
		createModelExecutionContext();
				
		//getMessagingSystem().showConsole();
		debug("About to initialize and run the GEMOC Execution Engine...");
	
		throwExceptionIfEngineAlreadyRunning();
		
		LanguageDefinition languageDefinition = LanguageDefinitionExtension.findDefinition(_runConfiguration.getLanguageName());
		throwExceptionIfLanguageDefinitionNull(languageDefinition);
				
		// All these elements are required to construct the engine. They are
		// retrieved from the Extension Points of the xDSML.
		Solver solver = null;
		EventExecutor eventExecutor = null;
		CodeExecutor codeExecutor = null;
		FeedbackPolicy feedbackPolicy = null;
		
		Collection<IEngineHook> engineHooks = null;
		Collection<IClockController> clockControllers = null;
		
		// get the extension objects
		debug("Starting to retrieve components from the configuration...");
		try {
			engineHooks = languageDefinition.instanciateEngineHooks();
			clockControllers = languageDefinition.instanciateClockControllers();
			solver = languageDefinition.instanciateSolver();
			eventExecutor = languageDefinition.instanciateEventExecutor();
			codeExecutor = languageDefinition.instanciateCodeExecutor();
			feedbackPolicy = languageDefinition.instanciateFeedbackPolicy();
//			modelLoader = instanciateModelLoader(confElement);
		} catch (CoreException e) {
			warn(e.getMessage());
			throw e;
		}
		
		ResourceSet resourceSet = getResourceSet(getDebuggerViewPathAsString());
		
		String transformationPath = languageDefinition.getQVTOPath();
		_executionContext.generateMoC(transformationPath);
		URI mocURI = URI.createPlatformResourceURI(_executionContext.getMoCPath().toString(), true);
		solver.setSolverInputFile(resourceSet, mocURI);
		
		Resource modelResource = getModelResource(resourceSet, getModelPathAsString());
		ILogicalStepDecider decider = LogicalStepDeciderFactory.createDecider(_runConfiguration.getDeciderName(), solver);

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
		_engine = new ObservableBasicExecutionEngine(solver, eventExecutor, codeExecutor, feedbackPolicy, decider, _executionContext, _runConfiguration);
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		if (_siriusSession != null)
			editingDomain = _siriusSession.getTransactionalEditingDomain();

		for(IClockController clockController: clockControllers){
			if (clockController instanceof IAliveClockController)
				_engine.addClockController((IAliveClockController)clockController);
		}

		_engine.initialize(modelResource, editingDomain);

		if (_runConfiguration.isTraceActive())
			_engine.activateTrace();
		
		for(IEngineHook engineHook : engineHooks){
			_engine.addEngineHook(engineHook);
		}
		
		// engine.
		// configure altogether
		configureEngine(_engine, frontends, backends);
		
		if (_runConfiguration.isAnimationActive()) 
		{
			_engine.setAnimator(AbstractGemocAnimatorServices.getAnimator());
		}
		
		// delegate for debug mode
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
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

	private void throwExceptionIfLanguageDefinitionNull(
			LanguageDefinition languageDefinition) throws CoreException {
		if (languageDefinition == null)
		{			
			String message = "Cannot find xdsml definition for the language " + _runConfiguration.getLanguageName() + ", please verify that is is correctly deployed.";
			error(message);
			CoreException exception = new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
			Activator.error(message, exception);
			throw exception;
		}
	}

	private void throwExceptionIfEngineAlreadyRunning() throws CoreException 
	{
		// make sure there is no other running engine on this model
		Collection<GemocExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values();
		for (GemocExecutionEngine engine : engines)
		{
			ObservableBasicExecutionEngine observable = (ObservableBasicExecutionEngine) engine;
  		  	if (observable.getEngineStatus().getRunningStatus() != RunStatus.Stopped 
  		  		&&  observable.getModelUnderExecutionResource().getURI().equals(URI.createPlatformResourceURI(getModelPathAsString(), true)))
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

	private Session _siriusSession;
	private ResourceSet getResourceSet(String sessionPath) 
	{
		if (_runConfiguration.isAnimationActive()) 
		{
			URI uri = URI.createPlatformResourceURI(sessionPath, true);
			_siriusSession = SessionManager.INSTANCE.getSession(uri, new NullProgressMonitor());
			return _siriusSession.getTransactionalEditingDomain().getResourceSet();
		} 
		return new ResourceSetImpl();
	}
	
	protected Resource getModelResource(ResourceSet resourceSet, String modelPath) throws CoreException {		
		return resourceSet.getResource(URI.createPlatformResourceURI(modelPath, true), true);
	}

	protected void configureEngine(
						GemocExecutionEngine engine,
						List<Frontend> frontends,
						List<Backend> backends) {
		// Links the Execution Engine to the Frontends
		for (Frontend frontend : frontends) {
			frontend.initialize(engine);
		}
		// Configures all the backends and links the Execution Engine to the
		// Backends
		for (Backend backend : backends) {
			backend.configure();
			((Observable) engine).addObserver(backend);
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
		GemocModelDebugger res = new GemocModelDebugger(dispatcher, _engine);
		_engine.setDebugger(res);
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
