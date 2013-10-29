package org.gemoc.execution.engine.api_standard_implementations.dse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.api_standard_implementations.dsa.LanguageAction;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;

/**
 * Reference implementation for DomainSpecificEvent.
 * 
 * @author flatombe
 */
public class LanguageEvent implements DomainSpecificEvent {
	private List<DomainSpecificAction> actions;
	private String name;

	public LanguageEvent(String name, EClass targetClass, EOperation operation) {
		this(name, new LanguageAction(targetClass, operation));
	}

	public LanguageEvent(String name, DomainSpecificAction action) {
		this.actions = new ArrayList<DomainSpecificAction>();
		actions.add(action);
		this.setAsOwningEvent(actions);
	}

	private void setAsOwningEvent(List<DomainSpecificAction> actions) {
		for (DomainSpecificAction action : actions) {
			action.setOwningEvent(this);
		}
	}

	@Override
	public List<DomainSpecificAction> getActions() {
		return this.actions;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "@[" + this.name.toString()
				+ " ; " + this.actions.toString() + "]";
	}

}
