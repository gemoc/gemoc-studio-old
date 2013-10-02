package org.gemoc.execution.engine.example.test;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.api_implementations.dsa.EmfExecutor;
import org.gemoc.execution.engine.api_implementations.feedback.SimpleFeedbackPolicy;
import org.gemoc.execution.engine.api_implementations.moc.CcslSolver;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

public class Test {
	public static void main(String[] args) {
		LanguageInitializer languageInitializer = null;
		ModelLoader modelLoader = null;
		String eclFilePath = null;
		Solver solver = new CcslSolver();
		Executor executor = new EmfExecutor();
		FeedbackPolicy feedbackPolicy = new SimpleFeedbackPolicy();
		
		ExecutionEngine engine;
		try {
			engine = new GemocExecutionEngine(languageInitializer, modelLoader, eclFilePath, solver, executor, feedbackPolicy);

			engine.initialize("toto");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
