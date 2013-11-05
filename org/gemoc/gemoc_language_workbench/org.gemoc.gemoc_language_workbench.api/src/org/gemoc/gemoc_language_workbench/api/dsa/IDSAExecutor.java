package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.ArrayList;


/**
 * An Executor is responsible for executing the Domain-Specific Action(s)
 *  In particular, it is responsible for
 * identifying the  Method required to actually execute the Domain
 * Specific Action  thanks to their  name.
 * 
 */
public interface IDSAExecutor {

    public Object execute(Object target, String methodName, ArrayList<Object> parameters);

    /**
     * return weither the current executor can execute the method
     * It is usefull in order to implement a chain of responsability of executors using fall back
     * @param target
     * @param methodName
     * @param parameters
     * @return
     */
    public IDSAExecutorCommand getCommand(Object target, String methodName, ArrayList<Object> parameters);


}
