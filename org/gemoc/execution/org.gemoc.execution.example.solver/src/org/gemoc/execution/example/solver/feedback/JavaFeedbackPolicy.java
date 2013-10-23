package org.gemoc.execution.example.solver.feedback;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.example.solver.Activator;
import org.gemoc.execution.engine.commons.feedback.ObjectFeedbackData;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.Transition;

public class JavaFeedbackPolicy implements FeedbackPolicy {

	public JavaFeedbackPolicy() {
	}

	@Override
	public void processFeedback(FeedbackData feedbackData,
			DomainSpecificEvent causalEvent, Solver solver) {
		// Activator.getMessagingSystem().warn("You need to complete processFeedback",
		// Activator.PLUGIN_ID);
		try {
			ObjectFeedbackData objectFeedbackData = (ObjectFeedbackData) feedbackData;
			Object o = objectFeedbackData.getObject();
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
								+ causalEvent.toString(), Activator.PLUGIN_ID);

				// Cas d'une Evaluate Guard
				if (causalEvent.getAction().getTarget() instanceof EvaluateGuard) {
					Boolean b = (Boolean) o;
					EvaluateGuard guard = (EvaluateGuard) causalEvent
							.getAction().getTarget();
					// Alors on force la Transition dans un sens ou dans l'autre
					// selon le résultat de l'éval.
					if (b) {
						Activator.getMessagingSystem().debug(
								"Boolean was true, adding a bunch of events for the next step..."
										, Activator.PLUGIN_ID);
						solver.forceEventOccurrenceReferencing(
								((Transition) guard.eContainer()).getSource(),
								eOperationFromTargetAndMethodName(
										((Transition) guard.eContainer())
												.getSource(), "onLeave"));
						solver.forceEventOccurrenceReferencing(
								guard.eContainer(),
								eOperationFromTargetAndMethodName(
										guard.eContainer(), "fire"));
						solver.forceEventOccurrenceReferencing(
								((Transition) guard.eContainer()).getTarget(),
								eOperationFromTargetAndMethodName(
										((Transition) guard.eContainer())
												.getSource(), "onEnter"));
					} else {
						Activator.getMessagingSystem().debug(
								"Boolean was false, forbidding a bunch of events for the next step..."
										, Activator.PLUGIN_ID);
						solver.forbidEventOccurrenceReferencing(
								((Transition) guard.eContainer()).getSource(),
								eOperationFromTargetAndMethodName(
										((Transition) guard.eContainer())
												.getSource(), "onLeave"));
						solver.forbidEventOccurrenceReferencing(
								guard.eContainer(),
								eOperationFromTargetAndMethodName(
										guard.eContainer(), "fire"));
						solver.forbidEventOccurrenceReferencing(
								((Transition) guard.eContainer()).getSource(),
								eOperationFromTargetAndMethodName(
										((Transition) guard.eContainer())
												.getSource(), "onEnter"));
					}
				}

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

		} catch (ClassCastException e) {
			Activator
					.getMessagingSystem()
					.warn("Feedback received was not of type ObjectFeedbackData, what type did you use instead ? Update the Feedback Policy.",
							Activator.PLUGIN_ID);
		}
	}

	private EOperation eOperationFromTargetAndMethodName(EObject target,
			String methodName) {
		for (EOperation operation : target.eClass().getEAllOperations()) {
			if (operation.getName().equals(methodName)) {
				return operation;
			}
		}
		return null;
	}

	public String toString() {
		return this.getClass().getName() + "@[]";
	}

}
