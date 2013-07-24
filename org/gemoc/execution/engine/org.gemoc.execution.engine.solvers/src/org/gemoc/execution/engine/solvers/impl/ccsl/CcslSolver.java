package org.gemoc.execution.engine.solvers.impl.ccsl;

import org.gemoc.execution.engine.solvers.Solver;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public class CcslSolver implements Solver {

    CCSLKernelSolverWrapper solver;

    public CcslSolver() {
        // TODO délégation du constructeur au constructeur du wrapper
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gemoc.execution.engine.solver.Solver#getNextStep()
     */
    @Override
    public Step getNextStep() {
        // TODO Auto-generated method stub
        return null;
    }

}
