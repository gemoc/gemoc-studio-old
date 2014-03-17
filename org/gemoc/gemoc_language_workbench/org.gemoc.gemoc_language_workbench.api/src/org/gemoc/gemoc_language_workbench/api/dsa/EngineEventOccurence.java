package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * Simple class to capture the EventOccurence in the engine
 * 
 */
public class EngineEventOccurence {
	
	protected EObject targetObject;
	protected EOperation targetOperation;
	protected List<Object> parameters = new ArrayList<Object>();
	

	public EngineEventOccurence(EObject targetObject, EOperation targetOperation) {
		super();
		this.targetObject = targetObject;
		this.targetOperation = targetOperation;
	}
	
		
	
	public EObject getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(EObject targetObject) {
		this.targetObject = targetObject;
	}
	public EOperation getTargetOperation() {
		return targetOperation;
	}
	public void setTargetOperation(EOperation targetOperation) {
		this.targetOperation = targetOperation;
	}
	public List<Object> getParameters() {
		return parameters;
	}
	public void setParameters(List<Object> parameters) {
		this.parameters = parameters;
	}
	
}
