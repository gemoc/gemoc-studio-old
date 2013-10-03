package org.gemoc.execution.engine.api_implementations.moc;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.Activator;
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
	String modelOfExecutionURI = "";

	public CcslSolver() {
	}

	@Override
	public void forbidEventOccurrenceReferencing(EObject target) {
		// TODO: Julien complete the code so as to force the correct clocks.
		this.solverWrapper.forceClockAbsence(HelperFactory.createModelElementReference(target));
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target) {
		// TODO: Julien complete the code so as to force the correct clocks.
		this.solverWrapper.forceClockPresence(HelperFactory.createModelElementReference(target));
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
		return this.getClass().getName() + "@[modelOfExecutionURI=" + this.modelOfExecutionURI + "]";
	}

	@Override
	public void setModelOfExecutionFile(String modelOfExecutionURI) {
		this.modelOfExecutionURI = modelOfExecutionURI;
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
