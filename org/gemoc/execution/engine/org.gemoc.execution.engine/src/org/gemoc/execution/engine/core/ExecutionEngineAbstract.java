package org.gemoc.execution.engine.core;

import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManager;
import fr.inria.aoste.timesquare.ccslkernel.solver.CCSLKernelSolver;

abstract public class ExecutionEngineAbstract implements Runnable {
	private String eclInterpreter; // L'interpréteur ECL qui doit venir des
									// sources ECL ...
	private BehaviorManager backend; // Le backend EMF executor
	private CCSLKernelSolver solver; // Le solver CCSL

	abstract public void run();

	public String getEclInterpreter() {
		return eclInterpreter;
	}

	public BehaviorManager getBackend() {
		return backend;
	}

	public CCSLKernelSolver getSolver() {
		return solver;
	}
}
