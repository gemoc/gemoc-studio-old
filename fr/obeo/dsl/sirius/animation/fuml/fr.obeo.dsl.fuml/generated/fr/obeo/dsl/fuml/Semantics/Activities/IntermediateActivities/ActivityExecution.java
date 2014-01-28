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

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityParameterNode;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.debug.Debug;

public class ActivityExecution extends Execution {

	/*
	 * The group of activations of the activity nodes of the activity.
	 */
	public ActivityNodeActivationGroup activationGroup;

	public void execute() {
		// Execute the activity for this execution by creating an activity node
		// activation group and activating all the activity nodes in the
		// activity.
		// When this is complete, copy the values on the tokens offered by
		// output parameter nodes to the corresponding output parameters.
		Activity activity = (Activity)(this.getTypes().get(0));
		Debug.println("[execute] Activity " + activity.getName() + "...");
		// Debug.println("[execute] context = " + this.context.objectId());
		Debug.println("[event] Execute activity=" + activity.getName());
		this.activationGroup = new ActivityNodeActivationGroup();
		this.activationGroup.activityExecution = this;
		this.activationGroup.activate(activity.getNodes(), activity.getEdges());
		// Debug.println("[execute] Getting output parameter node activations...");
		List<ActivityParameterNodeActivation> outputActivations = this.activationGroup.getOutputParameterNodeActivations();
		// Debug.println("[execute] There are " + outputActivations.size() +
		// " output parameter node activations.");
		for(int i = 0; i < outputActivations.size(); i++) {
			ActivityParameterNodeActivation outputActivation = outputActivations.get(i);
			ParameterValue parameterValue = new ParameterValue();
			parameterValue.parameter = ((ActivityParameterNode)(outputActivation.node)).getParameter();
			List<Token> tokens = outputActivation.getTokens();
			for(int j = 0; j < tokens.size(); j++) {
				Token token = tokens.get(j);
				Value value = ((ObjectToken)token).value;
				if(value != null) {
					parameterValue.values.add(value);
					Debug.println("[event] Output activity=" + activity.getName() + " parameter=" + parameterValue.parameter.getName() + " value=" + value);
				}
			}
			this.setParameterValue(parameterValue);
		}
		Debug.println("[execute] Activity " + activity.getName() + " completed.");
	}

	public Value copy() {
		// Create a new activity execution that is a copy of this execution.
		// [Note: This currently just returns a non-executing execution for the
		// same activity as this execution.]
		return super.copy();
	}

	public Value new_() {
		// Create a new activity execution with empty properties.
		return new ActivityExecution();
	}

	public void terminate() {
		// Terminate all node activations (which will ultimately result in the
		// activity execution completing).
		if (this.activationGroup != null) {
			this.activationGroup.terminateAll();
		}
	}
}
