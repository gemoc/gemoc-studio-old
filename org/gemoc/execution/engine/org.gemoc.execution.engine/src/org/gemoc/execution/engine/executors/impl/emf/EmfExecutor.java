package org.gemoc.execution.engine.executors.impl.emf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.Executor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * An executor that can call methods contained in compiled EMF code (like
 * Kermeta's).
 * 
 * @author flatombe
 */
public class EmfExecutor implements Executor {

    public EmfExecutor() {
    }

    public FeedbackData execute(EObject eo, String methodFullName) {
        Activator.getMessagingSystem().info("Executing method " + methodFullName + " on eobject " + eo.toString(),
                Activator.PLUGIN_ID);
        try {
            Method method = this.getMethod(eo, methodFullName);
            return (FeedbackData) method.invoke(eo);
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException when trying to invoke a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (InvocationTargetException e) {
            try {
                Method method = this.getMethodEmfHack(eo, methodFullName);
                return (FeedbackData) method.invoke(eo);
            } catch (IllegalArgumentException e1) {
                String errorMessage = "IllegalArgumentException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            } catch (IllegalAccessException e1) {
                String errorMessage = "IllegalAccessException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            } catch (InvocationTargetException e1) {
                String errorMessage = "InvocationTargetException when trying to invoke a Domain Specific Action";
                Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
                Activator.error(errorMessage, e1);
                return null;
            }
        }
    }

    @Override
    public FeedbackData execute(DomainSpecificAction dsa) {

        Activator.getMessagingSystem().debug(
                "Executing Domain Specific Action : " + dsa.getTarget().getClass().getName() + "."
                        + dsa.getMethodFullName(), Activator.PLUGIN_ID);
        return this.execute(dsa.getTarget(), dsa.getMethodFullName());
    }

    public Method getMethod(EObject eo, String methodFullName) {
        Method method = null;
        try {
            method = eo.getClass().getMethod(methodFullName);
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException when trying to retrieve method from its full name : "
                    + eo.toString() + "." + methodFullName;
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException when trying to retrieve method from its full name" + eo.toString()
                    + "." + methodFullName;
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        }
        return method;
    }

    public Method getMethodEmfHack(EObject eo, String methodFullName) {
        return this.getMethod(eo, "EMFRENAME" + methodFullName);
    }

    @Override
    public FeedbackData execute(DomainSpecificEvent dse) {
        return this.execute(dse.getAction());
    }

    public String toString() {
        return this.getClass().getName() + "@[]";
    }

}
