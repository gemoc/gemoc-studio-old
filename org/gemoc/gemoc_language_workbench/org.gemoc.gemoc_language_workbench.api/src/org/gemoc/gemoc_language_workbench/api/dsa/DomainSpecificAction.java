/**
 * 
 */
package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

/**
 * A DomainSpecificAction (DSA) captures references sufficient enough for the
 * Executor to compute the actual Object and Method that are concerned by this
 * action. For now we will use the qualified names of the target (object on
 * which to apply the method) and of the method (method to apply on the target)
 * to uniquely identify a Domain Specific Action.
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
	public EObject getTarget();

	/**
	 * 
	 * @return a copy of the list of parameters for this action.
	 */
	public List<EParameter> getParameters();
}
