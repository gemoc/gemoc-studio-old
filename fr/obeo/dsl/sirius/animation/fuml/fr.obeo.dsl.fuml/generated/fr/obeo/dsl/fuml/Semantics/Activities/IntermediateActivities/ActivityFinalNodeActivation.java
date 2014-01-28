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


import fr.obeo.dsl.fuml.Semantics.Activities.ExtraStructuredActivities.ExpansionActivationGroup;
import fr.obeo.dsl.fuml.debug.Debug;

public class ActivityFinalNodeActivation extends ControlNodeActivation {

	public void fire(List<Token> incomingTokens) {
		// Terminate the activity execution or structured node activation
		// containing this activation.
		Debug.println("[fire] Activity final node " + this.node.getName() + "...");
		if(incomingTokens.size() > 0 | this.incomingEdges.size() == 0) {
			if(this.group.activityExecution != null) {
				this.group.activityExecution.terminate();
			} else if(this.group.containingNodeActivation != null) {
				this.group.containingNodeActivation.terminateAll();
			} else if(this.group instanceof ExpansionActivationGroup) {
				((ExpansionActivationGroup)this.group).regionActivation.terminate();
			}
		}
	}
}
