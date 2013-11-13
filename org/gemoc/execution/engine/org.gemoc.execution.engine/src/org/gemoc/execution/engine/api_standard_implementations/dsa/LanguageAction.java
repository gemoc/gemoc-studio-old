/**
 * 
 */
package org.gemoc.execution.engine.api_standard_implementations.dsa;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypeParameter;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;

/**
 * Basic implementation of DomainSpecificAction, contains the EObject,
 * EOperation and the EObjects (parameters) for this action.
 * 
 * 
 * @author flatombe
 * 
 */
public class LanguageAction implements DomainSpecificAction {
	private EOperation operation;
	private EClass targetClass;
	private List<ETypeParameter> parameterTypes;
	private DomainSpecificEvent owningEvent;

	public LanguageAction(EClass targetClass, EOperation operation) {
		this.operation = operation;
		this.targetClass = targetClass;
		this.parameterTypes = operation.getETypeParameters();
	}

	@Override
	public EOperation getOperation() {
		return this.operation;
	}

	@Override
	public EClass getTargetClass() {
		return this.targetClass;
	}

	@Override
	public List<ETypeParameter> getParameterTypes() {
		return new ArrayList<ETypeParameter>(this.parameterTypes);
	}

	@Override
	public DomainSpecificEvent getOwningEvent() {
		return this.owningEvent;
	}

	@Override
	public void setOwningEvent(DomainSpecificEvent event) {
		this.owningEvent = event;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "@["
				+ this.targetClass.toString() + " ; "
				+ this.operation.toString() + " ; "
				+ this.parameterTypes.toString() + " ; "
				+ this.owningEvent.getName().toString() + "]";
	}
}
