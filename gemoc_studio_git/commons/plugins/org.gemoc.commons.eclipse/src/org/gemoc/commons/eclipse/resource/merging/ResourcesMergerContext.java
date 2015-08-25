package org.gemoc.commons.eclipse.resource.merging;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;

public class ResourcesMergerContext {

	private IFile _inputFile;
	public void setInputFile(IFile inputFile) {
		_inputFile = inputFile;
	}
	public IFile getInputFile() {
		return _inputFile;
	}

	private IFile _outputFile;
	public void setOutputFile(IFile outputFile) {
		_outputFile = outputFile;
	}
	public IFile getOutputFile() {
		return _outputFile;
	}

	private ArrayList<IBeforeSavingAction> _beforeSavingActions = new ArrayList<IBeforeSavingAction>();
	public void addBeforeSavingActions(IBeforeSavingAction action) {
		_beforeSavingActions.add(action);
	}
	public ArrayList<IBeforeSavingAction> getBeforeSavingActions() {
		return _beforeSavingActions;
	}

	
}
