package org.gemoc.sample.legacyfsm.xsfsm.design.services;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition;

/** FSM services.
 * 
* @author <a href="mailto:didier.vojtisek@inria.fr">Didier Vojtisek</a>
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

		res.append(transition.getName());
		res.append("\n");	
		res.append("");
		res.append(transition.getInput());
		res.append(" / ");
		res.append(transition.getOutput());	
		return res.toString();
	}
	
	public String getTypeString(EObject o) {
		return o.getClass().toString();
	}
	
	
	
	public boolean isCurrentState(EObject o){
		if(o instanceof State){
			return ((State)o).getOwningFSM().getCurrentState() == o;
		} else {
			return false;
		}
	}

}
