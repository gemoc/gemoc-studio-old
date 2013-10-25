package org.gemoc.execution.engine.api_standard_implementations.dse;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.api_standard_implementations.dsa.EmfAction;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;

/**
 * 
 * 
 * @author flatombe
 */
public class EclEvent implements DomainSpecificEvent {
	private DomainSpecificAction action;
	private String name;

	public EclEvent(String name, EObject target, EOperation operation) {
		this(name, new EmfAction(target, operation));
	}

	public EclEvent(String name, DomainSpecificAction action) {
		this.action = action;
	}

	@Override
	public DomainSpecificAction getAction() {
		return this.action;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.getClass().getName() + "@[" + "name=" + this.name
				+ " ; action=" + this.action.toString() + "]";
	}

}
