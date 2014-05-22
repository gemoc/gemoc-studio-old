package org.gemoc.execution.engine.capabilitites;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.execution.engine.commons.Activator;
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
	public void backToPast(Choice choice) throws ModelExecutionTracingException {
		int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index == (_engine.getExecutionTrace().getChoices().size()-1)
			|| index == (_engine.getExecutionTrace().getChoices().size()-2))
			return;
		try {
			backInTraceModelTo(choice);
			_backToPastHappened = true;
			if (_engine.getLogicalStepDecider() != null) 
			{
				_engine.getLogicalStepDecider().preempt();
			}
		} catch (IOException e) {
			throw new ModelExecutionTracingException(e);
		}
	}

	private void backInTraceModelTo(Choice choice) throws IOException {
		int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index != -1
			&& index != _engine.getExecutionTrace().getChoices().size()) {
			_engine.getExecutionTrace().getChoices().subList(index+1, _engine.getExecutionTrace().getChoices().size()).clear();
			choice.setNextChoice(null);
			//			List<Choice> choicesToKeep = 
//			_executionTraceModel.getChoices().clear();
//			_executionTraceModel.getChoices().addAll(new ArrayList<Choice>(choicesToKeep));
			resetContext(choice);
		}
	}

	private void resetContext(Choice choice) throws IOException {
		restoreModelState(choice);
		restoreSolverState(choice);
	}

	private void restoreModelState(Choice choice) throws IOException {
		Resource modelCopyResource = choice.getContextState().getModelState().getModel().eResource();
		EList<EObject> modelContent = loadModel(modelCopyResource.getURI());
		Resource resource = _engine.getModelUnderExecutionResource();
		resource.getContents().clear();
		resource.getContents().addAll(modelContent);
	}

	private void restoreSolverState(Choice choice) {
		_engine.getSolver().getPossibleLogicalSteps();

		Activator.debug("restoring solver state:" + choice.getContextState().getSolverState().getSerializableModel());
		_engine.getSolver().setState(choice.getContextState().getSolverState().getSerializableModel());
		Arrays.equals(_engine.getSolver().getState(), choice.getContextState().getSolverState().getSerializableModel());
		_engine.getSolver().getPossibleLogicalSteps();

		Arrays.equals(_engine.getSolver().getState(), choice.getContextState().getSolverState().getSerializableModel());
		int selectedChoiceIndex = choice.getPossibleLogicalSteps().indexOf(choice.getChosenLogicalStep());
		_engine.getSolver().applyLogicalStepByIndex(selectedChoiceIndex);
		Arrays.equals(_engine.getSolver().getState(), choice.getContextState().getSolverState().getSerializableModel());
	}

	private EList<EObject> loadModel(URI uri) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(uri);
		r.load(null);
		return r.getContents();
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}
	
}
