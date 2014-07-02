package org.gemoc.execution.engine.commons.feedback;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
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
			GemocExecutionEngine engine) {

		Object o = feedbackData.getData();
		if (o instanceof Byte) {
			Activator.getDefault().warn("Please don't return a Byte in your DSA");
		} else if (o instanceof Short) {
			Activator.getDefault().warn("Please don't return a Short in your DSA");
		} else if (o instanceof Integer) {
			Activator.getDefault().warn("Please don't return an Integer in your DSA");
		} else if (o instanceof Long) {
			Activator.getDefault().warn("Please don't return a Long in your DSA");
		} else if (o instanceof Float) {
			Activator.getDefault().warn("Please don't return a Float in your DSA");
		} else if (o instanceof Double) {
			Activator.getDefault().warn("Please don't return a Double in your DSA");
		} else if (o instanceof Boolean) {
			Activator.getDefault().debug("Caught a Boolean as feedback from event: "
							+ feedbackData.getContextEngineEventOccurence().toString());
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
			Activator.getDefault().warn("Please don't return a Character in your DSA");
		} else if (o instanceof String) {
			Activator.getDefault().info("[DSA]" + (String) o);
		} else if (o instanceof Object) {
			Activator.getDefault().warn("Please don't return a non-primitive type in your DSA");
		}

	}

	public String toString() {
		return this.getClass().getName() + "@[]";
	}
}
