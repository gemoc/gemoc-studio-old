/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package fr.obeo.dsl.fuml.Semantics.Actions.BasicActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Pin;

import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ObjectNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.Token;
import fr.obeo.dsl.fuml.debug.Debug;

public abstract class PinActivation extends ObjectNodeActivation {

	/*
	 * The activation of the action that owns the pin for this pin activation.
	 */
	public ActionActivation actionActivation;

	public void fire(List<Token> incomingTokens) {
		// Add all incoming tokens to the pin.
		Debug.println("[fire] Pin " + (this.node == null ? "" : this.node.getName() + "..."));
		this.addTokens(incomingTokens);
	}

	public List<Token> takeOfferedTokens() {
		// Take only a number of tokens only up to the limit allowed by
		// the multiplicity upper bound of the pin for this activation.
		int count = this.countUnofferedTokens();
		int upper = -1;
		// Note: A pin activation used in an expansion activation group
		// will have this.node == null.
		if(this.node != null) {
			upper = ((Pin)(this.node)).getUpper();
		}
		List<Token> tokens = new ArrayList<Token>();
		// Note: upper < 0 indicates an unbounded upper multiplicity.
		if(upper < 0 | count < upper) {
			List<ActivityEdgeInstance> incomingEdges = this.incomingEdges;
			for(int i = 0; i < incomingEdges.size(); i++) {
				ActivityEdgeInstance edge = incomingEdges.get(i);
				int incomingCount = edge.countOfferedValues();
				List<Token> incomingTokens = new ArrayList<Token>();
				if(upper < 0 | incomingCount < upper - count) {
					incomingTokens = edge.takeOfferedTokens();
					count = count + incomingCount;
				} else if(count < upper) {
					incomingTokens = edge.takeOfferedTokens(upper - count);
					count = upper;
				}
				for(int j = 0; j < incomingTokens.size(); j++) {
					Token token = incomingTokens.get(j);
					tokens.add(token);
				}
			}
		}
		return tokens;
	}
}
