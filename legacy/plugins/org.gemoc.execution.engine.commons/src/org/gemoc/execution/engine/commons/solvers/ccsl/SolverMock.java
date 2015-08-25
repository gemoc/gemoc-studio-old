package org.gemoc.execution.engine.commons.solvers.ccsl;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionContext;
import org.gemoc.executionengine.ccsljava.api.moc.ISolver;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;

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
	public void setUp(IConcurrentExecutionContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ModelElementReference> getAllDiscreteClocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
