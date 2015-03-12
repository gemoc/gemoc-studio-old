package org.gemoc.sample.tfsm.raspberry.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.impl.CCSLModelPackageImpl;
import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeModel;
import fr.inria.aoste.timesquare.ccslkernel.runtime.elements.RuntimeClock;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLSimulationEngine;
import fr.inria.aoste.timesquare.ccslkernel.runtime.simulation.CCSLStepExecutionEngine;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.simulationpolicy.random.RandomSimulationPolicy;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;

public class TFSMSolver implements ISolver{

	private AbstractRuntimeModel _solverModel;
	private CCSLSimulationEngine _solverEngine;
	private CCSLStepExecutionEngine _executionStep;
	private ClockConstraintSystem _timeModel;
	private ActionModel _feedbackModel;

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
				for (ModelSpecificEvent mse : _feedbackModel.getEvents())
				{
					if (mse.getName().equals("MSE_" + rc.getName()))
					{
						MSEOccurrence occurrence = Gemoc_execution_traceFactory.eINSTANCE.createMSEOccurrence();
						occurrence.setMse(mse);
						ls.getMseOccurrences().add(occurrence);
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
	public LogicalStep proposeLogicalStep() 
	{
		if (_logicalSteps.size() < 1)
		{
			return null;
		}
		return _logicalSteps.get(0);
	}

	@Override
	public void applyLogicalStep(LogicalStep logicalStep) 
	{
		int index = _logicalSteps.indexOf(logicalStep);
		try {
			_executionStep.applyLogicalStepByIndex(index);
		} catch (SimulationException e) {
			e.printStackTrace();
		}
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
	public void setUp(IExecutionContext context) 
	{
		ResourceSet rs = context.getResourceModel().getResourceSet();
		CCSLModelPackageImpl.init();
		URI timeModelURI = URI.createPlatformPluginURI(context.getWorkspace().getMoCPath().toString(), true);
		Resource r = rs.getResource(timeModelURI, true);
		_timeModel = (ClockConstraintSystem)r.getContents().get(0);
		URI feedbackURI = URI.createPlatformPluginURI(context.getWorkspace().getFeedbackModelPath().toString(), true);
		Resource resource = rs.getResource(feedbackURI, true);
		_feedbackModel = (ActionModel)resource.getContents().get(0);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ModelElementReference> getAllDiscreteClocks() {
		// TODO Auto-generated method stub
		return null;
	}

}
