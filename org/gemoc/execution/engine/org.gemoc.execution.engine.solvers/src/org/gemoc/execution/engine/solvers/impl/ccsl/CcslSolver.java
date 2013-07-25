package org.gemoc.execution.engine.solvers.impl.ccsl;

import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.solvers.Solver;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.timesquare.utils.timedsystem.TimedSystem;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public class CcslSolver implements Solver {

    CCSLKernelSolverWrapper solverWrapper;

    public CcslSolver() {
        this.solverWrapper = new CCSLKernelSolverWrapper();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.solvers.Solver#forceEventNonOccurrence(org
     * .gemoc.execution.engine.events.DomainSpecificEvent)
     */
    @Override
    public void forceEventNonOccurrence(DomainSpecificEvent event) {
        this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(event.getTarget()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.solvers.Solver#forceEventOccurrence(org.gemoc
     * .execution.engine.events.DomainSpecificEvent)
     */
    @Override
    public void forceEventOccurrence(DomainSpecificEvent event) {
        this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(event.getTarget()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.gemoc.execution.engine.solver.Solver#getNextStep()
     */
    @Override
    public Step getNextStep() {
        // TODO : Est-ce qu'on a besoin de TimedSystem dans l'API ? Il ne sert à
        // rien dans le corps de la méthode ...

        return new CcslStep(this.solverWrapper.solveNextSimulationStep(new TimedSystem()));
    }

}
