/**
 * 
 */
package org.gemoc.gemoc_language_workbench.api.dsa;

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
	 * Returns a fully qualified name of the method concerned by this DSA, name
	 * which should be sufficient to retrieve the designed Method, EOperation or
	 * whatever is need to actually be executed.
	 * 
	 * @return the fully qualified name of the method to execute.
	 */
	public String getMethodQualifiedName();

	/**
	 * Returns a fully qualified name of the object target by this DSA, name
	 * which should be sufficient to retrieve the Object, EObject or whatever
	 * data structure used to represent the Domain Specific Concept on which the
	 * DSA needs to be applied.
	 * 
	 * @return the fully qualified name of the target (Object on which the
	 *         Domain Specific Action must be executed).
	 */
	public String getTargetQualifiedName();
}
