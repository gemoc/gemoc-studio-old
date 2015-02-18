package org.gemoc.execution.engine.commons.solvers.ccsl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.trace.EventOccurrence;

public class SolverMock implements ISolver {

	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LogicalStep> computeAndGetPossibleLogicalSteps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogicalStep> updatePossibleLogicalSteps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalStep proposeLogicalStep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyLogicalStep(LogicalStep logicalStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URI prepareSolverInputFileForUserModel(URI userModelURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSolverInputFileReadyForUserModel(URI userModelURI) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSolverInputFile(ResourceSet rs, URI solverInputURI) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(byte[] serializableModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revertForceClockEffect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUp(IExecutionContext context) {
		// TODO Auto-generated method stub
		
	}

}
