package org.gemoc.execution.engine.io.views;

import org.eclipse.swt.graphics.Image;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class ExecutionTraceModelWrapper {

	private int _leftBlankCounter;
	private Choice _choice;
	private RunStatus _engineStatus;
	
	public ExecutionTraceModelWrapper(Choice choice, RunStatus engineStatus) {
		_choice = choice;
		_engineStatus = engineStatus;
	}
	
	public void setLeftBlankCounter(int number) {
		_leftBlankCounter = number;
	}
	
	public Image getColumnImage(int index) {
		if (index < _leftBlankCounter)
			return null;
		int choiceIndex = getChosenLogicalStepIndex();
		int shiftedIndex = index - _leftBlankCounter;
		if (choiceIndex == -1) {
			if (isEngineNotRunning()) {
				if (choiceIndex == shiftedIndex)
					return SharedIcons.getSharedImage(SharedIcons.PAST_CHOSEN_LOGICALSTEP_ICON);		
				else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
					return SharedIcons.getSharedImage(SharedIcons.PAST_POSSIBLE_LOGICALSTEP_ICON);								
			} else if (isEngineWaiting()) {
				if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
					return SharedIcons.getSharedImage(SharedIcons.FUTUR_POSSIBLE_LOGICALSTEP_ICON);								
			}
		} else {
			if (isEngineRunning()) {
				if( _choice.getNextChoices().size() > 0) {
					if (choiceIndex == shiftedIndex)
						return SharedIcons.getSharedImage(SharedIcons.PRESENT_CHOSEN_LOGICALSTEP_ICON);		
					else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
						return SharedIcons.getSharedImage(SharedIcons.PRESENT_POSSIBLE_LOGICALSTEP_ICON);		
				}
			}
			if (choiceIndex == shiftedIndex)
				return SharedIcons.getSharedImage(SharedIcons.PAST_CHOSEN_LOGICALSTEP_ICON);		
			else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
				return SharedIcons.getSharedImage(SharedIcons.PAST_POSSIBLE_LOGICALSTEP_ICON);				
		}
		return null;
	}

	private boolean isEngineNotRunning() {
		return _engineStatus.equals(RunStatus.Stopped);
	}
	private boolean isEngineRunning() {
		return _engineStatus.equals(RunStatus.Running);
	}
	private boolean isEngineWaiting() {
		return _engineStatus.equals(RunStatus.WaitingLogicalStepSelection);
	}

	public Choice getChoice() {
		return _choice;
	}
	
	public int getChosenLogicalStepIndex() {
		return _choice.getPossibleLogicalSteps().indexOf(_choice.getChosenLogicalStep());
	}

	public String getToolTipText(int index) {
		if (index < _leftBlankCounter)
			return null;
		int shiftedIndex = index - _leftBlankCounter;
		if (shiftedIndex < _choice.getPossibleLogicalSteps().size()) {
			StringBuilder builder = new StringBuilder();
			LogicalStep ls = _choice.getPossibleLogicalSteps().get(shiftedIndex);
			for(MSEOccurrence mseOccurrence : ls.getMseOccurrences()) 
			{
				appendToolTipTextToBuilder(builder, mseOccurrence.getMse());
				builder.append(System.getProperty("line.separator"));
			}
			return builder.toString();						
		}
		return null;
	}

	private void appendToolTipTextToBuilder(StringBuilder builder, ModelSpecificEvent mse) {
		if (mse.getCaller() != null
			&& mse.getAction() != null)
		{
			String s = String.format("%-50s%s", mse.getName(), ViewUtils.eventToString(mse));
			builder.append(s);
		}
	}
	
}
