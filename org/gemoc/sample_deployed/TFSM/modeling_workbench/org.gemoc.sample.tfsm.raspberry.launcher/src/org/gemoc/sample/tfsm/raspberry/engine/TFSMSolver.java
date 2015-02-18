package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeModel;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLSimulationEngine;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLStepExecutionEngine;
import fr.inria.aoste.timesquare.simulationpolicy.random.RandomSimulationPolicy;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class TFSMSolver implements ISolver{

	private AbstractRuntimeModel _solverModel;
	private CCSLSimulationEngine _solverEngine;
	private CCSLStepExecutionEngine _executionStep;
	private ClockConstraintSystem _timeModel;

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

	private ArrayList<LogicalStep> _logicalSteps;
	
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
		_logicalSteps = new ArrayList<LogicalStep>();

		if (firedClocks.size() > 0)
		{
			LogicalStep ls = Gemoc_execution_traceFactory.eINSTANCE.createLogicalStep();
			_logicalSteps.add(ls);
			for (RuntimeClock rc : firedClocks)
			{
				for (Element element : _timeModel.getSubBlock().get(0).getElements())
				{
					if (element instanceof Clock)
					{
						Clock clock = (Clock)element;
						if (clock.getName().equals(rc.getName()))
						{
							EventOccurrence eo = TraceFactory.eINSTANCE.createEventOccurrence();
							ls.getEventOccurrences().add(eo);	
							ModelElementReference mer = TraceFactory.eINSTANCE.createModelElementReference();
							mer.getElementRef().add(clock);
							eo.setReferedElement(mer);
						}
					}
				}
			}			
		}
		return _logicalSteps;
	}

	@Override
	public List<LogicalStep> updatePossibleLogicalSteps() 
	{
		return _logicalSteps;
	}

	@Override
	public int proposeLogicalStepByIndex() 
	{
		return 0;
	}

	@Override
	public void applyLogicalStepByIndex(int indexOfStepToApply) 
	{
		try {
			_executionStep.applyLogicalStepByIndex(indexOfStepToApply);
		} catch (SimulationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public URI prepareSolverInputFileForUserModel(URI userModelURI) 
	{
		return null;
	}

	@Override
	public boolean isSolverInputFileReadyForUserModel(URI userModelURI) 
	{
		return false;
	}

	@Override
	public void setSolverInputFile(ResourceSet rs, URI solverInputURI) 
	{
		_timeModel = (ClockConstraintSystem)rs.getResources().get(0).getContents().get(0);
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
