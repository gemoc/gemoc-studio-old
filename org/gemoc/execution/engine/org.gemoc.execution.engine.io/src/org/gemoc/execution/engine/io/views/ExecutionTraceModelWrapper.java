package org.gemoc.execution.engine.io.views;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.swt.graphics.Image;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;

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
			if (isEngineRunning()
				&& shiftedIndex < _choice.getPossibleLogicalSteps().size()) {
				return SharedIcons.getSharedImage(SharedIcons.FUTUR_POSSIBLE_LOGICALSTEP_ICON);		
			} else {
				if (choiceIndex == shiftedIndex)
					return SharedIcons.getSharedImage(SharedIcons.PAST_CHOSEN_LOGICALSTEP_ICON);		
				else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
					return SharedIcons.getSharedImage(SharedIcons.PAST_POSSIBLE_LOGICALSTEP_ICON);				
			}				
		} else if (choiceIndex == shiftedIndex)
			return SharedIcons.getSharedImage(SharedIcons.PAST_CHOSEN_LOGICALSTEP_ICON);		
		else if (shiftedIndex < _choice.getPossibleLogicalSteps().size())
			return SharedIcons.getSharedImage(SharedIcons.PAST_POSSIBLE_LOGICALSTEP_ICON);
		return null;
	}

	private boolean isEngineRunning() {
		return _engineStatus.equals(RunStatus.Running) || _engineStatus.equals(RunStatus.WaitingLogicalStepSelection);
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
			for(EventOccurrence eventOccurrence : ls.getEventOccurrences()) {
				if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
					ModelElementReference reference = (ModelElementReference)eventOccurrence.getReferedElement();
					AppendToolTipTextToBuilder(builder, reference);
					builder.append(System.getProperty("line.separator"));
				}
			}
			return builder.toString();						
		}
		return null;
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
	
}
