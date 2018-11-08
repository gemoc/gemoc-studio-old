/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.concurrent.design.services;

import org.gemoc.sample.tfsm.concurrent.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.concurrent.tfsm.EventGuard;
import org.gemoc.sample.tfsm.concurrent.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.concurrent.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.concurrent.tfsm.Transition;

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
