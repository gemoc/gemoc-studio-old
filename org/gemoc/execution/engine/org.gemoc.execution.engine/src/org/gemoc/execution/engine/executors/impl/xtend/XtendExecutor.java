/**
 * 
 */
package org.gemoc.execution.engine.executors.impl.xtend;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.Executor;
import org.gemoc.execution.engine.executors.impl.DataConverter;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * @author flatombe
 * 
 */
public class XtendExecutor implements Executor {

    private DomainSpecificAction lastExecutedAction;

    public XtendExecutor() {
        this.lastExecutedAction = null;
    }

    @Override
    public FeedbackData execute(DomainSpecificAction dsa) {
        Activator.getMessagingSystem().debug("Executing action : " + dsa.toString(), Activator.PLUGIN_ID);

        String methodFullName = dsa.getMethodFullName();
        EObject eo = dsa.getTarget();

        try {
            Method method = null;

            // 
            // Here fill in K3 specific methodology to retrieve a method from
            // its name.
            //
            
            FeedbackData feedback = DataConverter.convertToFeedbackData(method.invoke(eo));
            this.lastExecutedAction = dsa;
            return feedback;
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException when trying to execute (K3) a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException when trying to execute (K3) a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            return null;
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException when trying to execute (K3) a Domain Specific Action";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            Activator.error("Exception within the InvocationTargetException : " + e.getCause().getMessage(),
                    e.getCause());
            return null;
        }
    }

    @Override
    public FeedbackData execute(DomainSpecificEvent dse) {
        return this.execute(dse.getAction());
    }

    public String toString() {
        return this.getClass().getName() + "@[lastExecutedAction=" + lastExecutedAction.toString() + "]";
    }

}
