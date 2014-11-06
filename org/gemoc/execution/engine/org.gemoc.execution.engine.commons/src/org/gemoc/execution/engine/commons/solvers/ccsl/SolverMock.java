package org.gemoc.execution.engine.commons.solvers.ccsl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;

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
	public LogicalStep getNextStep() {
		// TODO Auto-generated method stub
		return null;
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
	public int proposeLogicalStepByIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void applyLogicalStepByIndex(int indexOfStepToApply) {
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
