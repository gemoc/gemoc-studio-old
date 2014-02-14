package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.io.backends.ConsoleBackend;
import org.gemoc.execution.engine.io.core.Backend;
import org.gemoc.execution.engine.io.core.EngineManager;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.frontends.controlpanels.ExampleGUIControlPanel;
import org.gemoc.execution.engine.io.frontends.scenariobuilders.ExampleScenarioBuilder;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class GemocReflectiveModelLauncher implements
		ILaunchConfigurationDelegate {

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
				GemocModelLauncherConfigurationConstants.LAUNCH_MODEL_PATH, "");

		String languageName = configuration
				.getAttribute(
						GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE,
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
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
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

			// TODO: REMOVE the try/catch
			try {
				final Object oDomainSpecificEventsResource = confElement
						.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_ATT);
				if (oDomainSpecificEventsResource instanceof Resource) {
					domainSpecificEventsResource = (Resource) oDomainSpecificEventsResource;
				}
			} catch (CoreException e) {
				domainSpecificEventsResource = null;
			}
			
			try {
				final Object oMocEventsResource = confElement
						.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MOCEVENTS_RESOURCE_ATT);
				if (oMocEventsResource instanceof Resource) {
					mocEventsResource = (Resource) oMocEventsResource;
				}
			} catch (CoreException e) {
				mocEventsResource = null;
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
		}

		// Ugly calls to check if all the elements have been provided as
		// required.
		this.reactToNull(solver, "Solver");
		this.reactToNull(executor, "Executor");
		this.reactToNull(feedbackPolicy, "Feedback Policy");
		this.reactToNull(domainSpecificEventsResource,
				"Domain Specific Events Resource");
		this.reactToNull(mocEventsResource,
				"MoC Events Resource");
		this.reactToNull(modelLoader, "Model Loader");

		// TODO : Hard-coded Frontends and Backends... It should be selectable
		// in the launch configuration etc.
		Frontend controlPanel = new ExampleGUIControlPanel();
		Frontend scenarioBuilder = new ExampleScenarioBuilder();
		List<Frontend> frontends = new ArrayList<Frontend>();
		frontends.add(controlPanel);
		frontends.add(scenarioBuilder);

		List<Backend> backends = new ArrayList<Backend>();
		backends.add(new ConsoleBackend());
		EngineManager manager = new EngineManager(mocEventsResource, domainSpecificEventsResource,
				solver, executor, feedbackPolicy, modelPath, modelLoader,
				frontends, backends);
	}

	private void reactToNull(Object o, String name) {
		if (o == null) {
			Activator.getDefault().getMessaggingSystem()
					.warn("WARNING: " + name + " is null !", "");
			Activator.warn(name + " is null", new NullPointerException(name));
		}
	}
}
