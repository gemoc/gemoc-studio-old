package org.gemoc.execution.engine.solvers.impl.ccsl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.MessageConsoleStream;
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

    public CcslSolver(Resource resource, MessageConsoleStream out) {

        this.solverWrapper = new CCSLKernelSolverWrapper();
        try {
            this.solverWrapper.getSolver().loadModel(resource);
            out.println("Creating: " + this.toString());
        } catch (Exception e) {
            out.println("\t" + e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                out.println("\t" + element.toString());
            }

        }

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

    public String toString() {
        return "CcslSolver@[" + this.solverWrapper.toString() + "]";
    }

}
