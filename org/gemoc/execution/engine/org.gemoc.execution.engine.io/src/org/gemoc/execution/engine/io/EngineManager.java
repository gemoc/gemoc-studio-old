package org.gemoc.execution.engine.io;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;

import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

/**
 * An entity which builds an ExecutionEngine and connects it to a ControlPanel
 * and n Backends.
 * 
 * @author flatombe
 * 
 */
public class EngineManager {
	private ExecutionEngine engine;

	public EngineManager(Resource domainSpecificEventsResource, Solver solver,
			EventExecutor executor, FeedbackPolicy feedbackPolicy,
			String modelPath, ModelLoader modelLoader,
			ControlPanel controlPanel, List<Backend> backends) {
	
		// Initialization of the Execution Engine
		this.engine = new GemocExecutionEngine(domainSpecificEventsResource,
				solver, executor, feedbackPolicy);
		this.engine.initialize(modelPath, modelLoader);

		// Links the Execution Engine to the Control Panel
		controlPanel.initialize(this.engine);

		// Configures all the backends and links the Execution Engine to the
		// Backends
		for (Backend backend : backends) {
			backend.configure();
			((Observable) this.engine).addObserver((Observer) backend);
		}

	}

}
