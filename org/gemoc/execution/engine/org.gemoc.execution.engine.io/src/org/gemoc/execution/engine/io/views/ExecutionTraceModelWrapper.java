package org.gemoc.execution.engine.io.views;

import org.eclipse.swt.graphics.Image;
import org.gemoc.execution.engine.io.SharedIcons;

import GemocExecutionEngineTrace.Choice;

public class ExecutionTraceModelWrapper {

	private int _leftBlankCounter;
	private Choice _choice;

	
	public ExecutionTraceModelWrapper(Choice choice) {
		_choice = choice;
	}
	
	public void setLeftBlankCounter(int number) {
		_leftBlankCounter = number;
	}
	
	public Image getColumnImage(int index) {
		if (index < _leftBlankCounter)
			return null;
		int choiceIndex = getChosenLogicalStepIndex();
		int shiftedIndex = index - _leftBlankCounter;
		if (choiceIndex == shiftedIndex)
			return SharedIcons.getSharedImage(SharedIcons.CHOSEN_LOGICALSTEP_ICON);		
		else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
			return SharedIcons.getSharedImage(SharedIcons.POSSIBLE_LOGICALSTEP_ICON);
		return null;
	}

	public Choice getChoice() {
		return _choice;
	}
	
	public int getChosenLogicalStepIndex() {
		return _choice.getPossibleLogicalSteps().indexOf(_choice.getChosenLogicalStep());
	}
	
}
