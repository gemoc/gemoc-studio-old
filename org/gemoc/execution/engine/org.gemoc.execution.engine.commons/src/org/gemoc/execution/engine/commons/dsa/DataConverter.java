/**
 * 
 */
package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.feedback.ObjectFeedbackData;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * Sort of a helper that translates the return of a DSA into a proper
 * FeedbackData object...
 * 
 * @author flatombe
 * 
 */
public class DataConverter {

	public static FeedbackData convertToFeedbackData(Object o,
			ModelSpecificAction msa) {
		FeedbackData feedback = null;
		Activator.getMessagingSystem().debug(
				"Trying to convert the following object into feedbackdata: "
						+ o.toString(), Activator.PLUGIN_ID);
		try {
			String s = (String) o;
			Activator.getMessagingSystem().debug("It seems to be a string",
					Activator.PLUGIN_ID);
			feedback = new ObjectFeedbackData((Object) s);
		} catch (ClassCastException e) {
			try {
				Boolean b = (Boolean) o;
				Activator.getMessagingSystem().debug(
						"It seems to be a boolean", Activator.PLUGIN_ID);
				feedback = new ObjectFeedbackData((Object) b);
			} catch (ClassCastException e1) {
				String errorMessage = "Cannot comprehend the return type of the dsa.";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e1);
			}
		}

		feedback.setCausalAction(msa);

		return feedback;
	}

}
