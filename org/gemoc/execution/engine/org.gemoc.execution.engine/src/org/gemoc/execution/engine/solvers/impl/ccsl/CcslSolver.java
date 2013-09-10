package org.gemoc.execution.engine.solvers.impl.ccsl;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.console.MessageConsoleStream;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.solvers.Solver;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public class CcslSolver implements Solver {

    CCSLKernelSolverWrapper solverWrapper;
    Logger logger;

    public CcslSolver(String parentLoggerName, Resource ccslResource) throws IOException, UnfoldingException,
            SolverException {
        this.logger = Logger.getLogger(parentLoggerName + "." + this.getClass().getName());

        this.solverWrapper = new CCSLKernelSolverWrapper();
        this.solverWrapper.getSolver().loadModel(ccslResource);
        this.solverWrapper.getSolver().initSimulation();
    }

    @Override
    public void forceEventNonOccurrence(DomainSpecificEvent event) {
        this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(event.getAction().getTarget()));
    }

    @Override
    public void forceEventOccurrence(DomainSpecificEvent event) {
        this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(event.getAction().getTarget()));
    }

    @Override
    public Step getNextStep() {
        try {
            return new CcslStep(this.solverWrapper.getSolver().doOneSimulationStep());
        } catch (SolverException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.solverWrapper.toString() + "]";
    }

}
