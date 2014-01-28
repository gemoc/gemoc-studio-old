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
package fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities;

import java.util.List;

import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Parameter;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.debug.Debug;

public class ActivityParameterNodeActivation extends ObjectNodeActivation {

	public void fire(List<Token> incomingTokens) {
		// If there are no incoming edges, this is an activation of an input
		// activity parameter node.
		// Get the values from the input parameter indicated by the activity
		// parameter node and offer those values as object tokens.
		if(this.node.getIncomings().size() == 0) {
			Debug.println("[fire] Input activity parameter node " + this.node.getName() + "...");
			Parameter parameter = ((ActivityParameterNode)(this.node)).getParameter();
			ParameterValue parameterValue = this.getActivityExecution().getParameterValue(parameter);
			// Debug.println("[fire] parameter = " + parameter.name);
			if(parameterValue != null) {
				Debug.println("[fire] Parameter has " + parameterValue.values.size() + " value(s).");
				// List<Token> tokens = new ArrayList<Token>();
				List<Value> values = parameterValue.values;
				for(int i = 0; i < values.size(); i++) {
					Value value = values.get(i);
					ObjectToken token = new ObjectToken();
					token.value = value;
					this.addToken(token);
				}
				this.sendUnofferedTokens();
			}
		}
		// If there are one or more incoming edges, this is an activation of an
		// output activity parameter node.
		// Take the tokens offered on incoming edges and add them to the set of
		// tokens being offered.
		// [Note that an output activity parameter node may fire multiple times,
		// accumulating tokens offered to it.]
		else {
			Debug.println("[fire] Output activity parameter node " + this.node.getName() + "...");
			this.addTokens(incomingTokens);
		}
	}

	public void clearTokens() {
		// Clear all held tokens only if this is an input parameter node.
		if(this.node.getIncomings().size() == 0) {
			super.clearTokens();
		}
	}
}
