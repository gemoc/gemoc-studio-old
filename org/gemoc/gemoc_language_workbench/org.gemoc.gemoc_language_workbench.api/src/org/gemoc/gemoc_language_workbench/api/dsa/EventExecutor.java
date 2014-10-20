package org.gemoc.gemoc_language_workbench.api.dsa;



import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

/**
 * An EventExecutor is responsible for executing the action in EngineEventOccurence
 * referenced by Domain-Specific Event(s). In particular, it is responsible for
 * identifying the Object and Method referenced by the Domain-Specific Action(s)
 * in the bytecode.
 * 
 * @author flatombe
 */
public interface EventExecutor {
	/**
	 * A rather optional method that is used to instantiate the languages
	 * managed by this EventExecutor... if they need to be. Most of the time it
	 * will probably perform nothing.
	 */
	public void initialize();

	/**
	 * Executes the Action associated to the EventOccurence. Typically, will delegate to its
	 * CodeExecutor the task to locate in the bytecode the method corresponding
	 * to the referenced EOperation and its invocation. Then the result is
	 * converted into a FeedbackData that can be interpreted by the
	 * FeedbackPolicy.
	 * 
	 * @param mse
	 *            the ModelSpecificAction to execute.
	 * @exception EventExecutionException
	 *                if there has been any problem locating the method or the
	 *                object or during the execution of the method. The source
	 *                exception is wrapped.
	 * @return the FeedbackData representing the result of the
	 *         ModelSpecificAction execution.
	 */
	public Object execute(ActionCall call)
			throws EventExecutionException;


}
