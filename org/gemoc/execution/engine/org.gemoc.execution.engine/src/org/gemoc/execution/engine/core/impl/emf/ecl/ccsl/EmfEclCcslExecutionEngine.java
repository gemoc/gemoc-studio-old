package org.gemoc.execution.engine.core.impl.emf.ecl.ccsl;

import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;

/**
 * An implementation of the engine using the EMF Executor, the ECL events and
 * the CCSL solver.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

    public EmfEclCcslExecutionEngine() {
        this.solver = new CcslSolver();
        this.executor = new EmfExecutor();
    }
}
