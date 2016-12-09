package org.gemoc.sample.legacyfsm.xsfsm.design.services;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition;

/** TFSM services.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 * 
 */
public class XFSMServices {

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
			res.append("when ");
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
	
	public String getTypeString(EObject o) {
		return o.getClass().toString();
	}
	
	/* for use in legacy models */ 
	public String getClockLabel(org.gemoc.sample.legacyfsm.fsm.FSMClock fsmclock){
		return fsmclock.getName() + " : <N/A>";
	}
	/* for use with executable models */
	public String getClockLabel(FSMClock fsmclock){
		return fsmclock.getName() + " : " +fsmclock.getNumberOfTicks();
	}
	
	
	public boolean isCurrentState(EObject o){
		if(o instanceof State){
			return ((State)o).getOwningFSM().getCurrentState() == o;
		} else {
			return false;
		}
	}

}
