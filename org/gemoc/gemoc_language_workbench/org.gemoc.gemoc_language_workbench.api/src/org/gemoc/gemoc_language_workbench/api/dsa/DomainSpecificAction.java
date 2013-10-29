/**
 * 
 */
package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypeParameter;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;

/**
 * A Domain-Specific Action (DSA) is a language-level data structure
 * representing a method call in EMF. It has enough information for a competent
 * EventExecutor to compute the actual Object and Method which will serve during
 * the invokation of the DSA.
 * 
 * @author flatombe
 * 
 */
public interface DomainSpecificAction {
	/**
	 * 
	 * @return the EOperation which corresponds to the method of this action.
	 */
	public EOperation getOperation();

	/**
	 * 
	 * @return the target of this action, which is the EObject on which the
	 *         operation must be called.
	 * 
	 */
	public EClass getTargetClass();

	/**
	 * 
	 * @return a copy of the list of parameters for this action.
	 */
	public List<ETypeParameter> getParameterTypes();

	/**
	 * 
	 * @return the Domain Specific Event that owns this DSA.
	 */
	public DomainSpecificEvent getOwningEvent();

	/**
	 * 
	 */
	public void setOwningEvent(DomainSpecificEvent event);
}
