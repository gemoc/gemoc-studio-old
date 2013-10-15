package org.gemoc.gemoc_language_workbench.api.dsa;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * An Executor is responsible for executing the Domain-Specific Action(s)
 * referenced by Domain-Specific Event(s). In particular, it is responsible for
 * identifying the Object and Method required to actually execute the Domain
 * Specific Action only thanks to their respective fully qualified name.
 * 
 * @author flatombe
 */
public interface Executor {
	/**
	 * Executes the Domain-Specific Action.
	 * 
	 * @param dsa
	 * @return the result of the Domain-Specific Action wrapped in an
	 *         appropriate FeedbackData object.
	 */
	public FeedbackData execute(DomainSpecificAction dsa);

	/**
	 * Executes the Domain-Specific Action(s) referenced by the given
	 * Domain-Specific Event.
	 * 
	 * TODO : What happens when a DSE refers to several DSAs ?
	 * 
	 * @param dse
	 * @return the result(s) of the Domain-Specific Action(s) wrapped in an
	 *         appropriate FeedbackData object.
	 */
	public FeedbackData execute(DomainSpecificEvent dse);

	/**
	 * An Executor needs to have a model against which it will look for the
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
