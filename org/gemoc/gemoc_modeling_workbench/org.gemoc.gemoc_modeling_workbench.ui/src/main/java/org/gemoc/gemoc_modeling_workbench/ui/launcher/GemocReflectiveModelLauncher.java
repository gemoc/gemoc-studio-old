package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.dsa.executors.Kermeta3EventExecutor;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.ModelOfExecutionBuilder;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
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
		LanguageInitializer languageInitializer = null;
		ModelLoader modelLoader = null;
		Solver solver = null;
		EventExecutor executor = null;
		IDSAExecutor tempExecutor = null;
		FeedbackPolicy feedbackPolicy = null;
		Resource domainSpecificEventsResource = null;
		ModelOfExecutionBuilder modelOfExecutionBuilder = null;

		// get the extension objects
		if (confElement != null) {
			Activator
					.getDefault()
					.getMessaggingSystem()
					.debug("Starting to retrieve components from the configuration...",
							Activator.PLUGIN_ID);
			final Object oinitializer = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT);
			if (oinitializer instanceof LanguageInitializer) {
				languageInitializer = (LanguageInitializer) oinitializer;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("Language Initializer : " + languageInitializer.toString(), Activator.PLUGIN_ID);

			final Object omodelLoader = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
			if (omodelLoader instanceof ModelLoader) {
				modelLoader = (ModelLoader) omodelLoader;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("ModelLoader : " + modelLoader.toString(), Activator.PLUGIN_ID);

			final Object oSolver = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
			if (oSolver instanceof Solver) {
				solver = (Solver) oSolver;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("Solver : " + solver.toString(), Activator.PLUGIN_ID);

			final Object oexecutor = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
			if (oexecutor instanceof IDSAExecutor) {
				tempExecutor = (IDSAExecutor) oexecutor;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("EventExecutor : " + tempExecutor.toString(), Activator.PLUGIN_ID);

			final Object oFeedbackPolicy = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_FEEDBACKPOLICY_ATT);
			if (oFeedbackPolicy instanceof FeedbackPolicy) {
				feedbackPolicy = (FeedbackPolicy) oFeedbackPolicy;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("Feedback Policy : " + feedbackPolicy.toString(), Activator.PLUGIN_ID);

			try{
			final Object oDomainSpecificEventsResource = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_DSE_RESOURCE_ATT);
			if (oDomainSpecificEventsResource instanceof Resource) {
				domainSpecificEventsResource = (Resource) oDomainSpecificEventsResource;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("DomainSpecificEventsResource : " + domainSpecificEventsResource.toString(), Activator.PLUGIN_ID);
			} catch(CoreException e){
				Activator.getDefault().getMessaggingSystem()
				.debug("No DSE for you!", Activator.PLUGIN_ID);
			}

			try{
			final Object oModelOfExecutionBuilder = confElement
					.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_MODEL_OF_EXECUTION_BUILDER_ATT);
			if (oModelOfExecutionBuilder instanceof ModelOfExecutionBuilder) {
				modelOfExecutionBuilder = (ModelOfExecutionBuilder) oModelOfExecutionBuilder;
			}
			Activator.getDefault().getMessaggingSystem()
			.debug("Model of Execution Builder : " + modelOfExecutionBuilder.toString(), Activator.PLUGIN_ID);
			} catch(CoreException e){
				Activator.getDefault().getMessaggingSystem()
				.debug("No MoEb for you!", Activator.PLUGIN_ID);
			}
		}

		// Ugly calls to check if all the elements have been provided as
		// required.
		this.reactToNull(languageInitializer, "Language Initializer");
		this.reactToNull(modelLoader, "Model Loader");
		this.reactToNull(solver, "Solver");
		this.reactToNull(tempExecutor, "Executor");
		this.reactToNull(feedbackPolicy, "Feedback Policy");
		this.reactToNull(domainSpecificEventsResource,
				"Domain Specific Events Resource");
		this.reactToNull(modelOfExecutionBuilder, "Model Of Execution Builder");

		try {
			executor = new Kermeta3EventExecutor(null, "",
					tempExecutor);
			// Language-level instanciation of the engine
			ExecutionEngine engine = new GemocExecutionEngine(
					languageInitializer, modelLoader,
					domainSpecificEventsResource, modelOfExecutionBuilder,
					solver, executor, feedbackPolicy);

			// Model-level initialization of the engine
			engine.initialize(modelPath);

			// Run the engine for just one step...
			engine.run(1);

		} catch (Throwable e) {
			Activator.error("Exception in the initialization of the engine", e);
		}
	}

	private void reactToNull(Object o, String name) {
		if (o == null) {
			Activator.getDefault().getMessaggingSystem()
					.warn("WARNING: " + name + " is null !", "");
			Activator.warn(name + " is null", new NullPointerException(name));
		}
	}
}
