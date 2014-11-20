package org.gemoc.execution.engine.io.views.timeline;

import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingHook;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.obeo.timeline.view.AbstractTimelineProvider;

public class TimelineProvider extends AbstractTimelineProvider implements IEngineHook, IDisposable {

	private AbstractExecutionEngine _engine;
	
	public TimelineProvider(AbstractExecutionEngine engine) {
		_engine = engine;
		_engine.getExecutionContext().getExecutionPlatform().addHook(this);
	}
	
	private ExecutionTraceModel getExecutionTrace() {
		ExecutionTraceModel traceModel = null;;
		if (_engine.hasCapability(ModelExecutionTracingHook.class))
		{
			traceModel = _engine.getCapability(ModelExecutionTracingHook.class).getExecutionTrace();			
		}
		else
		{
			traceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();
		}
		return traceModel;
	}

	@Override
	public int getNumberOfChoices() {
		int numberOfChoices = getExecutionTrace().getChoices().size();
		return numberOfChoices;
	}

	@Override
	public int getNumberOfPossibleStepsAt(int index) {
		int numberOfPossibleSteps = getExecutionTrace().getChoices().get(index).getPossibleLogicalSteps().size();
		return numberOfPossibleSteps;
	}

	@Override
	public String getTextAt(int index) {
		return String.valueOf(index);
	}

	@Override
	public Object getAt(int index, int choice) {
		return getExecutionTrace().getChoices().get(index).getPossibleLogicalSteps().get(choice);
	}

	@Override
	public Object getAt(int index) {
		return getExecutionTrace().getChoices().get(index);
	}

	@Override
	public String getTextAt(int index, int choice) 
	{
		StringBuilder builder = new StringBuilder();
		LogicalStep ls = (LogicalStep)getAt(index, choice);
		for(EventOccurrence eventOccurrence : ls.getEventOccurrences()) {
			if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
				ModelElementReference reference = (ModelElementReference)eventOccurrence.getReferedElement();
				AppendToolTipTextToBuilder(builder, reference);
				builder.append(System.getProperty("line.separator"));
			}
		}
		return builder.toString();
	}

	private void AppendToolTipTextToBuilder(StringBuilder builder, ModelElementReference reference) {
		int numberOfElements = reference.getElementRef().size();
		switch(numberOfElements) {
			case 1:
				throw new UnsupportedOperationException();
			case 2:
				throw new UnsupportedOperationException();
			case 3:
				// element 0 is ClockConstraintSystemImpl
				// element 1 is BlockImpl
				// element 2 is ClockImpl
				Clock clock = (Clock)reference.getElementRef().get(2);
				Event event = clock.getTickingEvent();
				String s = String.format("%-50s%s", event.getName(), ViewUtils.eventToString(event));
				builder.append(s);
				break;
			case 4:
				break;
			default:
				throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public int getFollowing(int index, int choice) {
		int result = -1;
		if (index < getNumberOfChoices())
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
		return result;
	}

	@Override
	public int getPreceding(int index, int choice) {
		int result = -1;
		if (index < getNumberOfChoices())
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
		return result;
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
				
				if (getExecutionTrace().getChoices().size() > _numberOfChoices)
				{
					_numberOfChoices = getExecutionTrace().getChoices().size();
					mustNotify = true;
				}
				
				if (mustNotify)
				{
					notifyIsSelectedChanged(getExecutionTrace().getChoices().size() - 1, gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep()), true);				
					notifyNumberOfChoicesChanged(getExecutionTrace().getChoices().size());			
				}
			}
		}
	}

	@Override
	public int getSelectedPossibleStep(int index) {
		Choice gemocChoice = getExecutionTrace().getChoices().get(index);
		return gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep());
	}

	@Override
	public void dispose() 
	{
		if (_engine != null)
		{
			_engine.getExecutionContext().getExecutionPlatform().removeHook(this);
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
	public void preLogicalStepSelection(IExecutionEngine engine) 
	{
		update(engine);
	}

	@Override
	public void postLogicalStepSelection(IExecutionEngine engine) 
	{
	}

	@Override
	public void postStopEngine(IExecutionEngine engine) 
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
	public void engineStatusHasChanged(IExecutionEngine engineRunnable, RunStatus newStatus) 
	{
	}

}
