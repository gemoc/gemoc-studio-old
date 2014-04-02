package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.gemoc.execution.engine.commons.deciders.CcslSolverDecider;
import org.gemoc.execution.engine.commons.deciders.RandomDecider;
import org.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.execution.engine.io.backends.ConsoleBackend;
import org.gemoc.execution.engine.io.core.Backend;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.views.UserDecider;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;

import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;
import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;

public class GemocReflectiveModelLauncher
		extends
		fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI {
	// ILaunchConfigurationDelegate {

	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.GemocReflectiveModelLauncherID";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private ObservableBasicExecutionEngine engine;
	
	
	


	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {

		Activator.getDefault().getMessaggingSystem().showConsole();
		Activator
				.getDefault()
				.getMessaggingSystem()
				.warn("About to initialize and run the GEMOC Execution Engine...",
						"");

		String modelPath = configuration.getAttribute(
				AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI, "");

		String languageName = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE,
						"");
		String deciderName = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_DECIDER,
						"");
		final String extendedCCSLFilePath = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_EXTENDEDCCSL_FILE_PATH,
						"");
		final String modelOfExecutionFilePath = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_MODELOFEXECUTION_GLML_PATH,
						"");

		
		
		IConfigurationElement confElement = null;
		IConfigurationElement[] confElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						"org.gemoc.gemoc_language_workbench.xdsml");
		// retrieve the extension for the chosen language
		for (int i = 0; i < confElements.length; i++) {
			if (confElements[i].getAttribute("name").equals(languageName)) {
				confElement = confElements[i];
			}
		}

		// All these elements are required to construct the engine. They are
		// retrieved from the Extension Points of the xDSML.
		Solver solver = null;
		EventExecutor executor = null;
		FeedbackPolicy feedbackPolicy = null;
		Resource domainSpecificEventsResource = null;
		ModelLoader modelLoader = null;
		Resource mocEventsResource = null;

		// get the extension objects
		if (confElement != null) {
			Activator
					.getDefault()
					.getMessaggingSystem()
					.debug("Starting to retrieve components from the configuration...",
							Activator.PLUGIN_ID);

			final Object oSolver = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
			if (oSolver instanceof Solver) {
				solver = (Solver) oSolver;
			}

			final Object oexecutor = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EVENTEXECUTOR_ATT);
			if (oexecutor instanceof EventExecutor) {
				executor = (EventExecutor) oexecutor;
			}

			try {
				final Object oFeedbackPolicy = confElement
						.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_FEEDBACKPOLICY_ATT);
				if (oFeedbackPolicy instanceof FeedbackPolicy) {
					feedbackPolicy = (FeedbackPolicy) oFeedbackPolicy;
				}
			} catch (CoreException e) {
				Activator
						.getDefault()
						.getMessaggingSystem()
						.warn("WARNING : your xDSML does not have a FeedbackPolicy",
								Activator.PLUGIN_ID);
			}

			String dseResourcePath = confElement
					.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_PATH_ATT);
			

			String mocEventResourcePath = confElement
					.getAttribute(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT);
			if (mocEventResourcePath != null) {
				ResourceSet resSet = new ResourceSetImpl();
				if(mocEventResourcePath.startsWith("/")){
					mocEventsResource = resSet.getResource(
							URI.createPlatformPluginURI(mocEventResourcePath, true), true);
					
				} else {
					mocEventsResource = resSet.getResource(
						URI.createURI(mocEventResourcePath), true);
				}
			} else {
				Activator
						.getDefault()
						.getMessaggingSystem()
						.warn(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_PATH_ATT
								+ " isn't set", Activator.PLUGIN_ID);
			}

			// If there is a custom ModelLoader then we will use this,
			// else we should rely on some default XMI ModelLoader.
			try {
				final Object oModelLoader = confElement
						.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
				if (oModelLoader instanceof ModelLoader) {
					modelLoader = (ModelLoader) oModelLoader;
				}
			} catch (CoreException e) {
				// TODO : revert to some default generic xmi loader
				Activator
						.getDefault()
						.getMessaggingSystem()
						.warn("TODO XMI ModelLoader by default",
								Activator.PLUGIN_ID);
			}
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
			Activator
			.getDefault()
			.getMessaggingSystem()
			.error("Cannot find xdsml definition for the language "+languageName+", please verify that is is correctly deployed.", Activator.PLUGIN_ID);
			Activator.error("Cannot find xdsml definition for the language "+languageName+", please verify that is is correctly deployed", new NullPointerException("Cannot find xdsml definition for the language "));
		}

		// Ugly calls to check if all the elements have been provided as
		// required.
		this.reactToNull(solver, "Solver");
		this.reactToNull(executor, "Executor");
		this.reactToNull(feedbackPolicy, "Feedback Policy");
		//this.reactToNull(domainSpecificEventsResource,
		//		"Domain Specific Events Resource");
		//this.reactToNull(mocEventsResource, "MoC Events Resource");
		this.reactToNull(modelLoader, "Model Loader");
		// TODO will probably be replaced by an internal map in the engine,
		// created form the domainSpecificEventsResource)
		this.reactToNull(modelOfExecutionFilePath, "modelOfExecutionFilePath");

		if (extendedCCSLFilePath != null && !extendedCCSLFilePath.isEmpty()) {
			Activator
					.getDefault()
					.getMessaggingSystem()
					.warn("forcing the solverInput to user defined extendedCCSL "
							+ extendedCCSLFilePath, Activator.PLUGIN_ID);			
			// initialize solver
			solver.setSolverInputFile(URI.createPlatformResourceURI(
					extendedCCSLFilePath, true));
		} else {
			// TODO complement this step by a pre-run action that will build the
			// extended-ccsl from the model using the qvto transformation
			Activator
					.getDefault()
					.getMessaggingSystem()
					.error("automatic call to qvto transformation  not implemented yet. Please specify a manually generated extendedCCSL file.",
							Activator.PLUGIN_ID);
			URI solverInputFileURI = solver.prepareSolverInputFileForUserModel(URI.createPlatformResourceURI(modelPath, true));
			solver.setSolverInputFile(solverInputFileURI);
			return;
		}

		// create decider
		ILogicalStepDecider decider;
		if (deciderName
				.equals(GemocModelLauncherConfigurationConstants.DECIDER_RANDOM)) {
			decider = new RandomDecider();
		} else if (deciderName
				.equals(GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER)) {
			// use random as the only compatible decider
			decider = new UserDecider(false);
			
		} else if (deciderName
				.equals(GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER_STEP_BY_STEP)) {
			// use random as the only compatible decider
			decider = new UserDecider(true);
			
		} else 	{
			if (solver instanceof CcslSolver) {
				// use solver proposition
				decider = new CcslSolverDecider((CcslSolver) solver);
			} else {
				// use random as the only compatible decider
				decider = new RandomDecider();
			}
		}

		// Create required Frontends
		// TODO : Hard-coded Frontends and Backends... It should be selectable
		// in the launch configuration etc.
		// Frontend controlPanel = new ExampleGUIControlPanel();
		// Frontend scenarioBuilder = new ExampleScenarioBuilder();
		List<Frontend> frontends = new ArrayList<Frontend>();
		// frontends.add(controlPanel);
		// frontends.add(scenarioBuilder);

		// Create required Backends
		List<Backend> backends = new ArrayList<Backend>();
		backends.add(new ConsoleBackend());

		// Create and initialize engine
		engine = new ObservableBasicExecutionEngine(solver, executor,
				feedbackPolicy, decider);
		engine.initialize(modelPath, modelLoader);
		// engine.
		// configure altogether
		configureEngine(engine, mocEventsResource,
				domainSpecificEventsResource, solver, executor, feedbackPolicy,
				modelPath, modelLoader, frontends, backends);

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

	private void reactToNull(Object o, String name) {
		if (o == null) {
			Activator.getDefault().getMessaggingSystem()
					.warn("WARNING: " + name + " is null !", "");
			Activator.warn(name + " is null", new NullPointerException(name));
		}
	}

	protected void configureEngine(GemocExecutionEngine engine,
			Resource mocEventsResource, Resource domainSpecificEventsResource,
			Solver solver, EventExecutor executor,
			FeedbackPolicy feedbackPolicy, String modelPath,
			ModelLoader modelLoader, List<Frontend> frontends,
			List<Backend> backends) {

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
