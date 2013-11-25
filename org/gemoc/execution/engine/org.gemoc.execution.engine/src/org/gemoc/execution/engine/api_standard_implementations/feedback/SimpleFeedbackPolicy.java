package org.gemoc.execution.engine.api_standard_implementations.feedback;

import java.lang.reflect.InvocationTargetException;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.commons.feedback.ObjectFeedbackData;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;

/**
 * A simple interpretation of all the Java primitive types...
 * 
 * @author flatombe
 */
public class SimpleFeedbackPolicy implements FeedbackPolicy {

	public SimpleFeedbackPolicy() {
	}

	@Override
	public void processFeedback(FeedbackData feedbackData,
			ExecutionEngine engine) {

		Object o = feedbackData.getContent();
		if (o instanceof Byte) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Byte in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Short) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Short in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Integer) {
			Activator.getMessagingSystem().warn(
					"Please don't return an Integer in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Long) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Long in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Float) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Float in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Double) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Double in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof Boolean) {
			Activator.getMessagingSystem().debug(
					"Caught a Boolean as feedback from event: "
							+ feedbackData.getCausalEvent().toString(),
					Activator.PLUGIN_ID);
			//
			// if
			// (causalEvent.getAction().getTargetQualifiedName().equals("guardIsDay")
			// &
			// causalEvent.getAction().getMethodQualifiedName().equals("evaluate"))
			// {
			// EObject targetToForce =
			// getEObjectFromQualifiedName("guardIsDay_evaluatedFalse");
			// Boolean b = (Boolean) o;
			// if (b) {
			// solver.forceEventOccurrenceReferencing(targetToForce);
			// } else {
			// solver.forbidEventOccurrenceReferencing(targetToForce);
			// }
			// }


		} else if (o instanceof Character) {
			Activator.getMessagingSystem().warn(
					"Please don't return a Character in your DSA",
					Activator.PLUGIN_ID);
		} else if (o instanceof String) {
			Activator.getMessagingSystem().info("[DSA]" + (String) o,
					Activator.PLUGIN_ID);
		} else if (o instanceof Object) {
			Activator.getMessagingSystem().warn(
					"Please don't return a non-primitive type in your DSA",
					Activator.PLUGIN_ID);
		}

	}

	@Override
	public ObjectFeedbackData convertToFeedbackDataImplementation(Object o,
			ModelSpecificAction msa) throws IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {

		ObjectFeedbackData feedback = new ObjectFeedbackData(o, msa);

		return feedback;
	}

	public String toString() {
		return this.getClass().getName() + "@[]";
	}
}
