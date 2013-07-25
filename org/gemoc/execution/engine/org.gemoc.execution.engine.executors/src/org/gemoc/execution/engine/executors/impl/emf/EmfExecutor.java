package org.gemoc.execution.engine.executors.impl.emf;

import java.lang.reflect.InvocationTargetException;

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

    @Override
    public FeedbackData execute(DomainSpecificAction dsa) {
        try {
            return (FeedbackData) dsa.getMethod().invoke(dsa.getTarget());
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.executors.Executor#execute(org.gemoc.execution
     * .engine.executors.DomainSpecificEvent)
     */
    @Override
    public FeedbackData execute(DomainSpecificEvent dse) {
        return this.execute(dse.getAction());
    }

}
