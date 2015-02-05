package org.gemoc.execution.engine.io.views.timeline;

import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingAddon;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.obeo.timeline.view.AbstractTimelineProvider;

public class TimelineProvider extends AbstractTimelineProvider implements IEngineAddon, IDisposable {

	private AbstractExecutionEngine _engine;
	
	public TimelineProvider(AbstractExecutionEngine engine) {
		_engine = engine;
		_engine.getExecutionContext().getExecutionPlatform().addEngineAddon(this);
	}
	
	private ExecutionTraceModel getExecutionTrace() {
		ExecutionTraceModel traceModel = null;;
		if (_engine.hasCapability(ModelExecutionTracingAddon.class))
		{
			traceModel = _engine.getCapability(ModelExecutionTracingAddon.class).getExecutionTrace();			
		}
		else
		{
			traceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();
		}
		return traceModel;
	}

	@Override
	public int getNumberOfBranches() {
		return 1;
	}
	
	@Override
	public int getStart(int branch) {
		return 0;
	}

	@Override
	public int getEnd(int branch) {
		int numberOfChoices = getExecutionTrace().getChoices().size();
		return numberOfChoices;
	}

	@Override
	public int getNumberOfPossibleStepsAt(int branch, int index) {
		int numberOfPossibleSteps = getExecutionTrace().getChoices().get(index).getPossibleLogicalSteps().size();
		return numberOfPossibleSteps;
	}

	@Override
	public String getTextAt(int branch) {
		return "Current execution";
	}
	
	@Override
	public String getTextAt(int branch, int index) {
		return String.valueOf(index);
	}

	@Override
	public Object getAt(int branch, int index, int choice) {
		return getExecutionTrace().getChoices().get(index).getPossibleLogicalSteps().get(choice);
	}

	@Override
	public Object getAt(int branch, int index) {
		return getExecutionTrace().getChoices().get(index);
	}

	@Override
	public String getTextAt(int branch, int index, int choice) 
	{
		StringBuilder builder = new StringBuilder();
		LogicalStep ls = (LogicalStep)getAt(branch, index, choice);
		for(MSEExecutionContext context : ls.getEventExecutionContexts())
		{
			appendToolTipTextToBuilder(builder, context);
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}

	private void appendToolTipTextToBuilder(StringBuilder builder, MSEExecutionContext context) {
		String s = String.format("%-50s%s", context.getMse().getName(), ViewUtils.eventToString(context.getMse()));
		builder.append(s);
	}
	
	@Override
	public int[][] getFollowings(int branch, int index, int choice) {
		int result = -1;
		if (index < getEnd(branch))
		{
			Choice gemocChoice = getExecutionTrace().getChoices().get(index);
			int chosenLogicalStepIndex = gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep());
			if (chosenLogicalStepIndex == choice
				&& gemocChoice.getNextChoice() != null)
			{
				Choice nextChoice = gemocChoice.getNextChoice();
				result = nextChoice.getPossibleLogicalSteps().indexOf(nextChoice.getChosenLogicalStep());
			}			
		}
		final int[][] res = {{branch, result } };
		return res;
	}

	@Override
	public int[][] getPrecedings(int branch, int index, int choice) {
		int result = -1;
		if (index < getEnd(branch))
		{
			Choice gemocChoice = getExecutionTrace().getChoices().get(index);
			int chosenLogicalStepIndex = gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep());
			if (chosenLogicalStepIndex == choice
				&& index > 0)
			{
				Choice lastChoice = getExecutionTrace().getChoices().get(index-1);
				result = lastChoice.getPossibleLogicalSteps().indexOf(lastChoice.getChosenLogicalStep());
			}			
		}
		final int[][] res = {{branch, result } };
		return res;
	}


	private int _numberOfChoices = 0;
	private int _numberOfSteps = 0;
	
	private void update(IExecutionEngine engine) 
	{
		if (engine == _engine)
		{
			if (getExecutionTrace().getChoices().size() > 0)
			{
				boolean mustNotify = false;

				Choice gemocChoice = getExecutionTrace().getChoices().get(getExecutionTrace().getChoices().size() - 1);
				if (gemocChoice.getPossibleLogicalSteps().size() != _numberOfSteps)
				{
					_numberOfSteps = gemocChoice.getPossibleLogicalSteps().size();
					mustNotify = true;
				}
				
				if (getExecutionTrace().getChoices().size() != _numberOfChoices)
				{
					_numberOfChoices = getExecutionTrace().getChoices().size();
					mustNotify = true;
				}
				
				if (mustNotify)
				{
					notifyIsSelectedChanged(0, getExecutionTrace().getChoices().size() - 1, gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep()), true);				
					notifyEndChanged(0, getExecutionTrace().getChoices().size());			
				}
			}
		}
	}

	@Override
	public int getSelectedPossibleStep(int branch, int index) {
		Choice gemocChoice = getExecutionTrace().getChoices().get(index);
		return gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep());
	}

	@Override
	public void dispose() 
	{
		if (_engine != null)
		{
			_engine.getExecutionContext().getExecutionPlatform().removeEngineAddon(this);
		}
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) 
	{
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) 
	{
	}


	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
	}

	@Override
	public void aboutToExecuteMSE(IExecutionEngine executionEngine, ModelSpecificEvent mse) 
	{
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStopped(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine) 
	{
		update(engine);
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) 
	{
		update(engine);
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine,
			LogicalStep logicalStepExecuted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mseExecuted(IExecutionEngine engine, ModelSpecificEvent mse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engine, RunStatus newStatus) {
		// TODO Auto-generated method stub
		
	}


}
