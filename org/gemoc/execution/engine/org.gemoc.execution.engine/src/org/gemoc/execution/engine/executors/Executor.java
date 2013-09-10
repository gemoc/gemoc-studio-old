package org.gemoc.execution.engine.executors;

import java.lang.reflect.Method;

import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * An Executor is responsible for executing the Domain-Specific Action(s)
 * referenced by Domain-Specific Event(s).
 * 
 * @author flatombe
 */
public interface Executor {
    /**
     * Executes the Domain-Specific Action.
     * 
     * @param dsa
     * @return
     */
    public FeedbackData execute(DomainSpecificAction dsa);

    /**
     * Executes the Domain-Specific Action(s) referenced by the given
     * Domain-Specific Event.
     */
    public FeedbackData execute(DomainSpecificEvent dse);

}
