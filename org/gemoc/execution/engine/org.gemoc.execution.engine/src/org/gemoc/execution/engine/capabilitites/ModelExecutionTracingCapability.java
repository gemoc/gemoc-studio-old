package org.gemoc.execution.engine.capabilitites;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;

public class ModelExecutionTracingCapability implements IExecutionEngineCapability {

	private GemocExecutionEngine _engine;
	
	@Override
	public void initialize(GemocExecutionEngine engine) {
		_engine = engine;
	}

	private boolean _backToPastHappened = false;
	public void backToPast(Choice choice) {
		backInTraceModelTo(choice);
//		resetSolverContext(choice);
		_backToPastHappened = true;
		if (_engine.getLogicalStepDecider() != null) 
		{
			_engine.getLogicalStepDecider().preempt();
		}
	}

	private void backInTraceModelTo(Choice choice) {
		int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index != -1
			&& index != _engine.getExecutionTrace().getChoices().size()) {
			_engine.getExecutionTrace().getChoices().subList(index+1, _engine.getExecutionTrace().getChoices().size()).clear();
			choice.setNextChoice(null);
			//			List<Choice> choicesToKeep = 
//			_executionTraceModel.getChoices().clear();
//			_executionTraceModel.getChoices().addAll(new ArrayList<Choice>(choicesToKeep));
		}
	}

	private void resetSolverContext(Choice choice) {
//		// overwrite current state of the executable model with the memento
//		ResourceSet rs = modelUnderExecutionResource.getResourceSet();
//		choice.getContextState().getModelState().getModel().eResource();
//		solver.setSolverInputFile(rs, solverInputURI);
//		// overwrite the current state of the solver state model with the memento
//		// apply the chosen logical step
//		doLogicalStep(choice.getChosenLogicalStep());
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}
	
}
