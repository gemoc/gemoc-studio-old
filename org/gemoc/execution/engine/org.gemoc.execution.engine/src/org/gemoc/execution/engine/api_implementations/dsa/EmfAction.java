/**
 * 
 */
package org.gemoc.execution.engine.api_implementations.dsa;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

/**
 * Basic implementation of DomainSpecificAction, contains the EObject,
 * EOperation and the EObjects (parameters) for this action.
 * 
 * 
 * @author flatombe
 * 
 */
public class EmfAction implements DomainSpecificAction {
	private EOperation operation;
	private EObject target;
	private List<EParameter> parameters;

	public EmfAction(EObject target, EOperation operation) {
		this.operation = operation;
		this.target = target;
		this.parameters = operation.getEParameters();
	}

	@Override
	public EOperation getOperation() {
		return this.operation;
	}

	@Override
	public EObject getTarget() {
		return this.target;
	}

	@Override
	public List<EParameter> getParameters() {
		return new ArrayList<EParameter>(this.parameters);
	}

	public String toString() {
		return this.getClass().getName() + "@[" + this.target.toString() + " ; " + this.operation.toString() + "]";
	}
}
