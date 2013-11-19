package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.Collection;
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

	/**
	 * An EventExecutor needs to have a model against which it will look for the
	 * actual object(s) and operation(s) designated by the Domain Specific
	 * Action(s) to execute.
	 * 
	 * @param modelResource
	 */
	public void setModel(Resource modelResource);

	/**
	 * Retrieve the sentinels used by this executor.
	 * 
	 * @return
	 */
	public Collection<BytecodeSentinel> getSentinels();

	/**
	 * Add a new sentinel to this executor.
	 * 
	 * @param sentinel
	 */
	public void addSentinel(BytecodeSentinel sentinel);

}
