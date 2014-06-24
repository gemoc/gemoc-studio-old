package org.gemoc.execution.engine.io.views.obeo;

import java.util.Observable;
import java.util.Observer;

import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;

import fr.obeo.timeline.view.AbstractTimelineProvider;

public class TimelineProvider extends AbstractTimelineProvider implements Observer {

	private ObservableBasicExecutionEngine _engine;
	
	public TimelineProvider(ObservableBasicExecutionEngine engine) {
		_engine = engine;
		_engine.addObserver(this);
	}
	
	private ExecutionTraceModel getExecutionTrace() {
		return _engine.getExecutionTrace();
	}

	@Override
	public int getNumberOfTicks() {
		int numberOfChoices = getExecutionTrace().getChoices().size();
		return numberOfChoices;
	}

	@Override
	public int getNumberOfchoicesAt(int index) {
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
	public String getTextAt(int index, int choice) {
		return "titi";
	}

	@Override
	public int getFollowing(int index, int choice) {
		int result = -1;
		if (index < getNumberOfTicks())
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
		if (index < getNumberOfTicks())
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

	@Override
	public void update(Observable arg0, Object arg1) {
		notifyNumberOfticksChanged(getExecutionTrace().getChoices().size());
	}

	@Override
	public int getSelectedChoice(int index) {
		Choice gemocChoice = getExecutionTrace().getChoices().get(index);
		return gemocChoice.getPossibleLogicalSteps().indexOf(gemocChoice.getChosenLogicalStep());
	}

}
