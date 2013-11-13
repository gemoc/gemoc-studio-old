package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;

/**
 * A Model-Specific Action is the instanciation of a Domain-Specific Action for
 * the model-level. Instead of referencing an EClass it references an EObject,
 * and instead of referencing a list of ETypeParameters it references a list of
 * EParameters.
 * 
 * TODO : Somehow it feels like it should be done with models and static
 * semantics...
 * 
 * @author flatombe
 * 
 */
public interface ModelSpecificAction {
	/**
	 * 
	 * @return the EOperation which corresponds to the method of this action.
	 */
	public EOperation getOperation();

	/**
	 * 
	 * @return the EObject on which the method needs to be called.
	 */
	public EObject getTarget();

	/**
	 * TODO : not working yet.
	 * 
	 * @return the parameters for this method call.
	 */
	public List<EParameter> getParameters();

	/**
	 * 
	 * @return the generalization of this action to the language-level.
	 */
	public DomainSpecificAction getReification();

	/**
	 * 
	 * @return the Model Specific Event that owns this MSA.
	 */
	public ModelSpecificEvent getOwningEvent();
	
	/**
	 * 
	 */
	public void setOwningEvent(ModelSpecificEvent event);
}
