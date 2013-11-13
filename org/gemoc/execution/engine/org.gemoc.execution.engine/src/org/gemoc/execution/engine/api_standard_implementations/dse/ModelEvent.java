package org.gemoc.execution.engine.api_standard_implementations.dse;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;

/**
 * Reference implementation for ModelSpecificEvent.
 * 
 * @author flatombe
 * 
 */
public class ModelEvent implements ModelSpecificEvent {
	private List<ModelSpecificAction> actions;
	private DomainSpecificEvent reification;
	private String name;

	public ModelEvent(String name, DomainSpecificEvent reification) {
		this.name = name;
		this.reification = reification;
		this.actions = new ArrayList<ModelSpecificAction>();
	}

	public ModelEvent(String name, ModelSpecificAction action,
			DomainSpecificEvent reification) {
		this(name, reification);
		this.actions = new ArrayList<ModelSpecificAction>();
		actions.add(action);
		this.setAsOwningEvent(actions);
	}

	public ModelEvent(String name, List<ModelSpecificAction> actions,
			DomainSpecificEvent reification) {
		this(name, reification);
		this.actions = actions;
		this.setAsOwningEvent(actions);
	}

	private void setAsOwningEvent(List<ModelSpecificAction> actions) {
		for (ModelSpecificAction msa : actions) {
			msa.setOwningEvent(this);
		}
	}

	@Override
	public List<ModelSpecificAction> getActions() {
		return this.actions;
	}

	@Override
	public DomainSpecificEvent getReification() {
		return this.reification;
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
