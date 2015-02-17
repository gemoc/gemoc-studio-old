package org.gemoc.execution.engine.io.views.timeline;

import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingAddon;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Branch;
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

	private IExecutionEngine _engine;
	private ModelExecutionTracingAddon _tracingAddon;
	
	public TimelineProvider(IExecutionEngine engine) {
		_engine = engine;
		_engine.getExecutionContext().getExecutionPlatform().addEngineAddon(this);
	}
	
	private ExecutionTraceModel getExecutionTrace() {
		ExecutionTraceModel traceModel = null;;
		if (_engine.hasCapability(ModelExecutionTracingAddon.class))
		{
			_tracingAddon = _engine.getCapability(ModelExecutionTracingAddon.class);
			traceModel = _tracingAddon.getExecutionTrace();			
		}
		else
		{
			traceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();
		}
		return traceModel;
	}

	private Branch getBranchAt(int branchIndex)
	{
		Branch result = null;
		if (getExecutionTrace() != null
			&& getExecutionTrace().getBranches().size() >= branchIndex)
		{
			result = getExecutionTrace().getBranches().get(branchIndex);			
		}
		return result;
	}
	
	public Choice getChoiceAt(int branchIndex, int executionStepIndex) 
	{
		Choice result = null;
		Branch branch = getBranchAt(branchIndex);
		if (branch != null
			&& (branch.getStartIndex() + branch.getChoices().size()) >= executionStepIndex)
		{
			int choiceIndex = executionStepIndex - branch.getStartIndex();
			if (choiceIndex >= 0)
			{
				result = branch.getChoices().get(choiceIndex);
			}
		}
		return result;
	}
	
	@Override
	public int getNumberOfBranches() 
	{
		int result = 0;
		if (getExecutionTrace() != null)
		{
			result = getExecutionTrace().getBranches().size();			
		}
		return result;
	}
	
	@Override
	public int getStart(int branchIndex) 
	{
		int result = 0;
		Branch branch = getBranchAt(branchIndex);
		if (branch != null)
		{
			result = branch.getStartIndex();
		}
		return result;
	}

	@Override
	public int getEnd(int branchIndex) 
	{
		int result = 0;
		Branch branch = getBranchAt(branchIndex);
		if (branch != null)
		{
			result = branch.getStartIndex() + branch.getChoices().size();
		}
		return result;
	}

	@Override
	public int getNumberOfPossibleStepsAt(int branchIndex, int executionStepIndex) {
		int numberOfPossibleSteps = 0;
		Choice choice = getChoiceAt(branchIndex, executionStepIndex);
		if (choice != null)
		{
			numberOfPossibleSteps = choice.getPossibleLogicalSteps().size();				
		}
		return numberOfPossibleSteps;
	}

	@Override
	public String getTextAt(int branchIndex) {
		return "Current execution";
	}
	
	@Override
	public String getTextAt(int branchIndex, int index) {
		return String.valueOf(index);
	}

	@Override
	public Object getAt(int branchIndex, int executionStepIndex, int logicalStepIndex) 
	{
		Object result = null;
		Choice choice = getChoiceAt(branchIndex, executionStepIndex);
		if (choice != null)
		{
			if (choice.getPossibleLogicalSteps().size() >= logicalStepIndex)
			{
				result = choice.getPossibleLogicalSteps().get(logicalStepIndex);
			}
		}
		return result;
	}

	@Override
	public Object getAt(int branchIndex, int executionStepIndex) 
	{
		Choice choice = getChoiceAt(branchIndex, executionStepIndex);
		return choice;
	}

	@Override
	public String getTextAt(int branchIndex, int choiceIndex, int logicalStepIndex) 
	{
		StringBuilder builder = new StringBuilder();
		LogicalStep ls = (LogicalStep)getAt(branchIndex, choiceIndex, logicalStepIndex);
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
	public int[][] getFollowings(int branchIndex, int executionStepIndex, int logicalStepIndex) {
		int[][] res = {{branchIndex, -1}};
		Choice choice = getChoiceAt(branchIndex, executionStepIndex);
		if (choice != null
			&& !choice.getNextChoices().isEmpty())
		{
			res = new int[choice.getNextChoices().size()][1];
			for (int i=0; i<choice.getNextChoices().size(); i++)
			{
				Choice next = choice.getNextChoices().get(i);
				Branch nextBranch = next.getBranch();
				int nextBranchNumber = getExecutionTrace().getBranches().indexOf(nextBranch);
				if (next.getChosenLogicalStep() != null)
				{
					int nextLogicalStepindex = next.getPossibleLogicalSteps().indexOf(next.getChosenLogicalStep());
					int content[] = {nextBranchNumber, nextLogicalStepindex};
					res[i] = content;						
				}
				else
				{
					int content[] = {nextBranchNumber, -1};
					res[i] = content;												
				}
			}			
		}	
		return res;
	}

	@Override
	public int[][] getPrecedings(int branchIndex, int executionStepIndex, int logicalStepIndex) {
		int[][] res = {{branchIndex, -1}};
		Choice choice = getChoiceAt(branchIndex, executionStepIndex);
		if (choice != null
			&& choice.getPreviousChoice() != null)
		{
			Choice previous = choice.getPreviousChoice();
			Branch previousBranch = previous.getBranch();
			int previousBranchNumber = getExecutionTrace().getBranches().indexOf(previousBranch);

			if (previous.getChosenLogicalStep() != null)
			{
				int previousLogicalStepindex = previous.getPossibleLogicalSteps().indexOf(previous.getChosenLogicalStep());
				int content[] = {previousBranchNumber, previousLogicalStepindex};
				res[0] = content;						
			}
			else
			{
				int content[] = {previousBranchNumber, -1};
				res[0] = content;												
			}
		}	
		return res;
	}


	private int _numberOfChoices = 0;
	private int _numberOfSteps = 0;
	
	private void update(IExecutionEngine engine) 
	{
		if (engine == _engine
			&& _tracingAddon.getCurrentBranch() != null)		
		{
			Branch branch = _tracingAddon.getCurrentBranch();
			if (branch.getChoices().size() > 0)
			{
				int branchIndex = getExecutionTrace().getBranches().indexOf(branch);
				boolean mustNotify = false;

				Choice gemocChoice = branch.getChoices().get(branch.getChoices().size() - 1);
				if (gemocChoice.getPossibleLogicalSteps().size() != _numberOfSteps)
				{
					_numberOfSteps = gemocChoice.getPossibleLogicalSteps().size();
					mustNotify = true;
				}
				
				if (branch.getChoices().size() != _numberOfChoices)
				{
					_numberOfChoices = branch.getChoices().size();
					mustNotify = true;
				}
				
				mustNotify = true;
				
				if (mustNotify)
				{
					int stepIndex = branch.getStartIndex() + branch.getChoices().size();
					boolean isSelected = gemocChoice.getChosenLogicalStep() != null;
					notifyIsSelectedChanged(branchIndex,
							stepIndex,
							gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep()), 
							isSelected);				
					notifyEndChanged(branchIndex, stepIndex);
					notifyStartChanged(branchIndex, branch.getStartIndex());					
				}
			}
		}
	}

	@Override
	public int getSelectedPossibleStep(int branchIndex, int executionStepIndex) 
	{
		int result = -1;
		Branch branch = getBranchAt(branchIndex);
		if (branch != null)
		{
			int choiceIndex = executionStepIndex - branch.getStartIndex();
			if (branch.getChoices().size() >= choiceIndex)
			{
				Choice choice = branch.getChoices().get(choiceIndex);
				if (choice.getSelectedNextChoice() != null)
				{
					result = choice.getPossibleLogicalSteps().indexOf(choice.getChosenLogicalStep());
				}
			}
		}
		return result;
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
