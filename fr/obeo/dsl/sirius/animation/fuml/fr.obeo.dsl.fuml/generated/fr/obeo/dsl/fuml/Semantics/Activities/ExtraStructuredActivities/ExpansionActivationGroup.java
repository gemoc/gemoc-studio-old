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
package fr.obeo.dsl.fuml.Semantics.Activities.ExtraStructuredActivities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExpansionRegion;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.OutputPinActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityExecution;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivationGroup;

public class ExpansionActivationGroup extends ActivityNodeActivationGroup {

	/*
	 * Output pin activations corresponding, in order, to the input pins of the
	 * expansion region of this activation group.
	 */
	public List<OutputPinActivation> regionInputs = new ArrayList<OutputPinActivation>();

	/*
	 * Output pin activations corresponding, in order, to the input expansion
	 * nodes of the expansion region of this activation group.
	 */
	public List<OutputPinActivation> groupInputs = new ArrayList<OutputPinActivation>();

	/*
	 * The expansion region activation this activation group is for.
	 */
	public ExpansionRegionActivation regionActivation;

	/*
	 * Output pin activations corresponding, in order, to the output expansion
	 * nodes of the expansion region of this activation group.
	 */
	public List<OutputPinActivation> groupOutputs = new ArrayList<OutputPinActivation>();

	/*
	 * The index (starting at 1) of this activation group in the list held by
	 * the expansion region activation.
	 */
	public Integer index;

	public ActivityNodeActivation getNodeActivation(ActivityNode node) {
		// If the given node is an input pin of the expansion region, then
		// return the corresponding region-input output-pin activation.
		// If the given node is an input expansion node of the expansion region,
		// then return the corresponding group-input output-pin activation.
		// If the given node is an output expansion node of the expansion
		// region, then return the corresponding group-output output-pin
		// activation.
		// Otherwise return the node activation from the activation group, as
		// usual.
		ExpansionRegion region = (ExpansionRegion)(this.regionActivation.node);
		// List<InputPin> inputs = region.getInputs();
		ActivityNodeActivation activation = null;
		int i = 1;
		while(activation == null & i <= region.getInputs().size()) {
			if(node == region.getInputs().get(i - 1)) {
				activation = this.regionInputs.get(i - 1);
			}
			i = i + 1;
		}
		int j = 1;
		while(activation == null & j <= region.getInputElements().size()) {
			if(node == region.getInputElements().get(j - 1)) {
				activation = this.groupInputs.get(j - 1);
			}
			j = j + 1;
		}
		int k = 1;
		while(activation == null & k <= region.getOutputElements().size()) {
			if(node == region.getOutputElements().get(k - 1)) {
				activation = this.groupOutputs.get(k - 1);
			}
			k = k + 1;
		}
		if(activation == null) {
			activation = super.getNodeActivation(node);
		}
		return activation;
	}

	public ActivityExecution getActivityExecution() {
		// Get the activity execution that contains the expansion region
		// activation for this activation group.
		return this.regionActivation.getActivityExecution();
	}

	public void suspend(ActivityNodeActivation activation) {
		// Suspend the given activation in this activation group. If this is
		// the only suspended activation, then suspend the associated region
		// activation.
		if(!this.isSuspended()) {
			this.regionActivation.suspend();
		}
		super.suspend(activation);
	}

	public void resume(ActivityNodeActivation activation) {
		// Resume the given activation in this activation group. If this is the
		// last suspended activation, then resume the associated region
		// activation.
		super.resume(activation);
		if(!this.isSuspended()) {
			this.regionActivation.resume(this);
		}
	}
}
