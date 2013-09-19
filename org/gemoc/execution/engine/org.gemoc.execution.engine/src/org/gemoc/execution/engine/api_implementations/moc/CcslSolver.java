package org.gemoc.execution.engine.api_implementations.moc;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.dsa.EmfAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.moc.Step;

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

	public CcslSolver(Resource ccslResource) throws IOException, UnfoldingException, SolverException {

		this.solverWrapper = new CCSLKernelSolverWrapper();
		this.solverWrapper.getSolver().loadModel(ccslResource);
		this.solverWrapper.getSolver().initSimulation();
	}

	@Override
	public void forceEventNonOccurrence(DomainSpecificEvent event) {
		try {
			EmfAction action = (EmfAction) event.getAction();
			this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(action.getTarget()));
		} catch (ClassCastException e) {
			String errorMessage = "ClassCastException while trying to force an event non occurrence. You should use EmfActions.";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}
	}

	@Override
	public void forceEventOccurrence(DomainSpecificEvent event) {
		try {
			EmfAction action = (EmfAction) event.getAction();
			this.solverWrapper.forceClockAbsence(HelperFactory.createModelElementReference(action.getTarget()));
		} catch (ClassCastException e) {
			String errorMessage = "ClassCastException while trying to force an event non occurrence. You should use EmfActions.";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}
	}

	@Override
	public Step getNextStep() {
		try {
			return new CcslStep(this.solverWrapper.getSolver().doOneSimulationStep());
		} catch (SolverException e) {
			String errorMessage = "SolverException while trying to get next Ccsl step";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	public String toString() {
		return this.getClass().getName() + "@[" + this.solverWrapper.toString() + "]";
	}

}
