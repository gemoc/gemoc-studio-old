/**
 * 
 */
package org.gemoc.execution.engine.actions;

import org.eclipse.emf.ecore.EObject;

/**
 * DomainSpecificAction is what a DomainSpecificEvent references. Its
 * implementation should contain information so as to call a real method (like
 * EMF bytecode). A DomainSpecificAction is executed by an Executor.
 * 
 * @author flatombe
 * 
 */
public interface DomainSpecificAction {
    public String getMethodFullName();

    public EObject getTarget();
}
