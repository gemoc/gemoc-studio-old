/**
 * 
 */
package org.gemoc.execution.engine.actions.impl.simple;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.actions.DomainSpecificAction;

/**
 * Basic implementation of DomainSpecificAction, contains the EObject and a
 * Method to apply on the EObject.
 * 
 * TODO : change name of the class it's terrible
 * 
 * @author flatombe
 * 
 */
public class MethodReferenceAction implements DomainSpecificAction {
    private String methodFullName;

    private EObject target;

    public MethodReferenceAction(EObject target, String methodFullName) {
        this.target = target;
        this.methodFullName = methodFullName;
    }

    @Override
    public String getMethodFullName() {
        return this.methodFullName;
    }

    @Override
    public EObject getTarget() {
        return this.target;
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.target.toString() + " ; " + this.methodFullName + "]";
    }
}
