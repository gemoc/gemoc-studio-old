package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;

import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeModel;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLSimulationEngine;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLStepExecutionEngine;
import fr.inria.aoste.timesquare.simulationpolicy.random.RandomSimulationPolicy;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.TraceFactory;

public class TFSMSolver implements ISolver{

	private AbstractRuntimeModel _solverModel;
	private CCSLSimulationEngine _solverEngine;
	private CCSLStepExecutionEngine _executionStep;
	
	public TFSMSolver() {
		_solverModel = new TrafficControlModel();
		init();
	}
	
	private void init() 
	{
        _solverEngine = new CCSLSimulationEngine(_solverModel);
        _solverEngine.setSimulationPolicy(new RandomSimulationPolicy());
		try {
	        _solverEngine.initSimulation();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        _executionStep = new CCSLStepExecutionEngine(_solverEngine);
	}

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
	public List<LogicalStep> computeAndGetPossibleLogicalSteps() 
	{
		try {
			_executionStep.executeStep();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		Set<RuntimeClock> firedClocks = _executionStep.getFiredClocks();
		List<LogicalStep> result = new ArrayList<LogicalStep>();
		for (RuntimeClock rc : firedClocks)
		{
			LogicalStep ls = TraceFactory.eINSTANCE.createLogicalStep();
			result.add(ls);
		}
		return result;
	}

	@Override
	public List<LogicalStep> updatePossibleLogicalSteps() 
	{
		return null;
	}

	@Override
	public int proposeLogicalStepByIndex() 
	{
		return 0;
	}

	@Override
	public void applyLogicalStepByIndex(int indexOfStepToApply) 
	{
		return;
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
