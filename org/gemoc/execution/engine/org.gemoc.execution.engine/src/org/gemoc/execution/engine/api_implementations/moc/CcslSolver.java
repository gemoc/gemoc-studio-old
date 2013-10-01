package org.gemoc.execution.engine.api_implementations.moc;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.dsa.EmfAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.trace.util.HelperFactory;
import fr.inria.aoste.trace.LogicalStep;

/**
 * The interface of the CCSLKernelSolver as seen by the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public class CcslSolver implements Solver {

	CCSLKernelSolverWrapper solverWrapper = null;

	public CcslSolver() {
	}

	@Override
	public void forbidEventOccurrence(DomainSpecificEvent event) {
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
	public LogicalStep getNextStep() {
		try {
			return this.solverWrapper.getSolver().doOneSimulationStep();
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

	@Override
	public void setModelOfExecutionFile(String modelOfExecutionURI) {
		try {
			URI uri = URI.createPlatformResourceURI(modelOfExecutionURI, false);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource ccslResource = resourceSet.getResource(uri, true);
			ccslResource.load(null);
			EcoreUtil.resolveAll(resourceSet);
			this.solverWrapper = new CCSLKernelSolverWrapper();
			this.solverWrapper.getSolver().loadModel(ccslResource);
			this.solverWrapper.getSolver().initSimulation();
		} catch (IOException e) {
			String errorMessage = "IOException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (UnfoldingException e) {
			String errorMessage = "UnfoldingException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (SolverException e) {
			String errorMessage = "SolverException while instantiating the CcslSolver";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}

	}

}
