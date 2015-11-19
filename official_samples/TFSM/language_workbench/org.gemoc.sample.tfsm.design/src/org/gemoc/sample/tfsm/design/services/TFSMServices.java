package org.gemoc.sample.tfsm.design.services;

import org.gemoc.sample.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.EventGuard;
import org.gemoc.sample.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.Transition;

/** TFSM services.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 * 
 */
public class TFSMServices {

	/**
	 * Gets the label for the given {@link Transition}.
	 * 
	 * @param transition
	 *            the {@link Transition}
	 * @return the label for the given {@link Transition}
	 */
	public String getLabel(Transition transition) {
		final StringBuilder res = new StringBuilder();

		if (transition.getOwnedGuard() instanceof EventGuard) {
			res.append("when ");
			res.append(((EventGuard) transition.getOwnedGuard())
					.getTriggeringEvent().getName());
		} else if (transition.getOwnedGuard() instanceof TemporalGuard) {
			res.append("after ");
			res.append(((TemporalGuard) transition.getOwnedGuard())
					.getAfterDuration());
			res.append(" on ");
			res.append(((TemporalGuard) transition.getOwnedGuard())
					.getOnClock().getName());
		} else if (transition.getOwnedGuard() instanceof EvaluateGuard) {
			res.append("if ");
			res.append(((EvaluateGuard) transition.getOwnedGuard())
					.getCondition());
		}
		res.append("\n / \n");
		res.append(transition.getAction());
		res.append("\n");
		for (FSMEvent event : transition.getGeneratedEvents()) {
			res.append("  !");
			res.append(event.getName());
			res.append(";");
		}

		return res.toString();
	}


}
