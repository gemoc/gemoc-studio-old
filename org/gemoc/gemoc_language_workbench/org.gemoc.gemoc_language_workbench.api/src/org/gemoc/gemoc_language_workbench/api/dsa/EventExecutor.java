package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * An EventExecutor is responsible for executing the Domain-Specific Action(s)
 * referenced by Domain-Specific Event(s). In particular, it is responsible for
 * identifying the Object and Method referenced by the Domain-Specific Action(s)
 * in the bytecode.
 * 
 * @author flatombe
 */
public interface EventExecutor {
	/**
	 * A rather optional method that is used to instanciate the languages
	 * managed by this EventExecutor... if they need to be. Most of the time it
	 * will probably perform nothing.
	 */
	public void initialize();

	/**
	 * Executes the Domain-Specific Action.
	 * 
	 * @param msa
	 * @return
	 */
	public FeedbackData execute(ModelSpecificAction msa);

	/**
	 * Executes the Domain-Specific Action(s) referenced by the given
	 * Domain-Specific Event.
	 * 
	 * TODO : What happens when a DSE refers to several DSAs ?
	 * 
	 * @param dse
	 * @return the results of the Domain-Specific Actions wrapped in appropriate
	 *         FeedbackData objects.
	 */
	public List<FeedbackData> execute(ModelSpecificEvent dse);

}
