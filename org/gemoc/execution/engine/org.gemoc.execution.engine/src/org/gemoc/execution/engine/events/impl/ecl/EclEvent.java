package org.gemoc.execution.engine.events.impl.ecl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.actions.impl.method.EmfAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;

/**
 * 
 * 
 * @author flatombe
 */
public class EclEvent implements DomainSpecificEvent {
    private DomainSpecificAction action;

    public EclEvent(EObject target, EOperation operation) {
        this(new EmfAction(target, operation));
    }

    private String retrieveMethodName(EObject eObjectMethod) throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method method = eObjectMethod.getClass().getMethod("getName");
        Object res = method.invoke(eObjectMethod);
        if (res instanceof String) {
            return (String) res;
        } else {
            return null;
        }

    }

    public EclEvent(DomainSpecificAction action) {
        this.action = action;
    }

    @Override
    public DomainSpecificAction getAction() {
        return this.action;
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.action.toString() + "]";
    }

}
