/**
 * 
 */
package org.gemoc.execution.engine.actions.impl.methodref;

import java.lang.reflect.Method;

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
    private Method method;

    private EObject target;

    public MethodReferenceAction(EObject target, String methodName) {
        this.target = target;
        try {
            this.method = target.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public EObject getTarget() {
        return this.target;
    }
}
