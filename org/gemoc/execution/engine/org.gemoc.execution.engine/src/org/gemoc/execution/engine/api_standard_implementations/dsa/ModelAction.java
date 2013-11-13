package org.gemoc.execution.engine.api_standard_implementations.dsa;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;

/**
 * Reference implementation for ModelSpecificAction.
 * 
 * @author flatombe
 * 
 */
public class ModelAction implements ModelSpecificAction {

	private EOperation operation;
	private EObject target;
	private List<EParameter> parameters;
	private DomainSpecificAction reification;
	private ModelSpecificEvent owningEvent;

	public ModelAction(EObject target, EOperation operation,
			DomainSpecificAction reification) {
		this.target = target;
		this.operation = operation;
		this.parameters = operation.getEParameters();
		this.reification = reification;
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
		return this.parameters;
	}

	@Override
	public DomainSpecificAction getReification() {
		return this.reification;
	}

	@Override
	public ModelSpecificEvent getOwningEvent() {
		return this.owningEvent;
	}

	@Override
	public void setOwningEvent(ModelSpecificEvent event) {
		this.owningEvent = event;
	}

	public String toString() {
		return this.getClass().getSimpleName() + "@[" + this.target.toString()
				+ " ; " + this.operation.toString() + " ; "
				+ this.parameters.toString() + " ; "
				+ this.owningEvent.getName().toString() + "]";
	}

}
