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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Pin;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities.StructuredActivityNodeActivation;
import fr.obeo.dsl.fuml.debug.Debug;

public class ActivityNodeActivationGroup {

	/*
	 * The set of activity edge instances for this group.
	 */
	public List<ActivityEdgeInstance> edgeInstances = new ArrayList<ActivityEdgeInstance>();

	/*
	 * The set of activity node executions for this group.
	 */
	public List<ActivityNodeActivation> nodeActivations = new ArrayList<ActivityNodeActivation>();

	/*
	 * The activity execution to which this group belongs. (This will be empty
	 * if the group is for a structured activity node activation.)
	 */
	public ActivityExecution activityExecution;

	/*
	 * The structured activity node activation to which this group belongs.
	 * (This will be empty if the group is for an activity execution.)
	 */
	public StructuredActivityNodeActivation containingNodeActivation;

	/*
	 * Activity node activations in this activation group that are suspended
	 * waiting for an event occurrence. If an activation group has a containing
	 * node activation and any suspended activations, then the containing node
	 * activation will also be suspended.
	 */
	public List<ActivityNodeActivation> suspendedActivations = new ArrayList<ActivityNodeActivation>();

	public void run(List<ActivityNodeActivation> activations) {
		// Run the given node activations and then (concurrently) send an offer
		// to all activations for nodes with no incoming edges within the given
		// set.
		for(int i = 0; i < activations.size(); i++) {
			ActivityNodeActivation activation = activations.get(i);
			activation.run();
		}
		Debug.println("[run] Checking for enabled nodes...");
		List<ActivityNodeActivation> enabledActivations = new ArrayList<ActivityNodeActivation>();
		for(int i = 0; i < activations.size(); i++) {
			ActivityNodeActivation activation = activations.get(i);
			Debug.println("[run] Checking node " + activation.node.getName() + "...");
			if(activation instanceof ActionActivation | activation instanceof ControlNodeActivation | activation instanceof ActivityParameterNodeActivation) {
				boolean isEnabled = this.checkIncomingEdges(activation.incomingEdges, activations);
				// For an action activation, also consider incoming edges to
				// input pins
				if(isEnabled & activation instanceof ActionActivation) {
					List<InputPin> inputPins = ((Action)activation.node).getInputs();
					int j = 1;
					while(j <= inputPins.size() & isEnabled) {
						InputPin inputPin = inputPins.get(j - 1);
						List<ActivityEdgeInstance> inputEdges = ((ActionActivation)activation).getPinActivation(inputPin).incomingEdges;
						isEnabled = this.checkIncomingEdges(inputEdges, activations);
						j = j + 1;
					}
				}
				if(isEnabled) {
					Debug.println("[run] Node " + activation.node.getName() + " is enabled.");
					enabledActivations.add(activation);
				}
			}
		}
		// Debug.println("[run] " + enabledActivations.size() +
		// " node(s) are enabled.");
		// *** Send offers to all enabled nodes concurrently. ***
		for(Iterator<ActivityNodeActivation> i = enabledActivations.iterator(); i.hasNext();) {
			ActivityNodeActivation activation = i.next();
			Debug.println("[run] Sending offer to node " + activation.node.getName() + ".");
			activation.receiveOffer();
		}
	}

	public Boolean checkIncomingEdges(List<ActivityEdgeInstance> incomingEdges, List<ActivityNodeActivation> activations) {
		// Check if any incoming edges have a source in a given set of
		// activations.
		int j = 1;
		boolean notFound = true;
		while(j <= incomingEdges.size() & notFound) {
			int k = 1;
			while(k <= activations.size() & notFound) {
				if(activations.get(k - 1).isSourceFor(incomingEdges.get(j - 1))) {
					notFound = false;
				}
				k = k + 1;
			}
			j = j + 1;
		}
		return notFound;
	}

	public void runNodes(List<ActivityNode> nodes) {
		// Run the node activations associated with the given nodes in this
		// activation group.
		List<ActivityNodeActivation> nodeActivations = new ArrayList<ActivityNodeActivation>();
		for(int i = 0; i < nodes.size(); i++) {
			ActivityNode node = nodes.get(i);
			ActivityNodeActivation nodeActivation = this.getNodeActivation(node);
			if(nodeActivation != null) {
				nodeActivations.add(nodeActivation);
			}
		}
		this.run(nodeActivations);
	}

	public void activate(List<ActivityNode> nodes, List<ActivityEdge> edges) {
		// Activate and run the given set of nodes with the given set of edges,
		// within this activation group.
		this.createNodeActivations(nodes);
		this.createEdgeInstances(edges);
		this.run(this.nodeActivations);
		// Debug.println("[activate] Exiting.");
	}

	public void terminateAll() {
		// Terminate all node activations in the group.
		Debug.println("[terminateAll] Terminating activation group for " + (this.activityExecution != null ? "activity " + this.activityExecution.getTypes().get(0).getName() : this.containingNodeActivation != null ? "node " + this.containingNodeActivation.node.getName() : "expansion region") + ".");
		List<ActivityNodeActivation> nodeActivations = this.nodeActivations;
		for(int i = 0; i < nodeActivations.size(); i++) {
			ActivityNodeActivation nodeActivation = nodeActivations.get(i);
			nodeActivation.terminate();
		}
		this.suspendedActivations.clear();
	}

	public void createNodeActivations(List<ActivityNode> nodes) {
		// Add activity node activations for the given set of nodes to this
		// group and create edge instances between them.
		for(int i = 0; i < nodes.size(); i++) {
			ActivityNode node = nodes.get(i);
			Debug.println("[createNodeActivations] Creating a node activation for " + node.getName() + "...");
			this.createNodeActivation(node);
		}
	}

	public ActivityNodeActivation createNodeActivation(ActivityNode node) {
		// Create an activity node activation for a given activity node in this
		// activity node activation group.
		ActivityNodeActivation activation = (ActivityNodeActivation)(this.getActivityExecution().locus.factory.instantiateVisitor(node));
		activation.node = node;
		activation.running = false;
		this.addNodeActivation(activation);
		activation.createNodeActivations();
		return activation;
	}

	public void addNodeActivation(ActivityNodeActivation activation) {
		// Add the given node activation to this group.
		activation.group = this;
		this.nodeActivations.add(activation);
	}

	public ActivityNodeActivation getNodeActivation(ActivityNode node) {
		// Return the node activation (if any) in this group,
		// or any nested group, corresponding to the given activity node.
		// If this is a group for a structured activity node activation,
		// also include the pin activations for that node activation.
		ActivityNodeActivation activation = null;
		if(this.containingNodeActivation != null && node instanceof Pin) {
			activation = this.containingNodeActivation.getPinActivation((Pin)node);
		}
		if(activation == null) {
			int i = 1;
			while(activation == null & i <= this.nodeActivations.size()) {
				activation = this.nodeActivations.get(i - 1).getNodeActivation(node);
				i = i + 1;
			}
		}
		return activation;
	}

	public void createEdgeInstances(List<ActivityEdge> edges) {
		// Create instance edges for the given activity edges, as well as for
		// edge instances within any nodes activated in this group.
		for(int i = 0; i < edges.size(); i++) {
			ActivityEdge edge = edges.get(i);
			Debug.println("[createEdgeInstances] Creating an edge instance from " + edge.getSource().getName() + " to " + edge.getTarget().getName() + ".");
			ActivityEdgeInstance edgeInstance = new ActivityEdgeInstance();
			edgeInstance.edge = edge;
			this.addEdgeInstance(edgeInstance);
			this.getNodeActivation(edge.getSource()).addOutgoingEdge(edgeInstance);
			this.getNodeActivation(edge.getTarget()).addIncomingEdge(edgeInstance);
			// Debug.println("[createEdgeInstances] Edge instance created...");
		}
		List<ActivityNodeActivation> nodeActivations = this.nodeActivations;
		for(int i = 0; i < nodeActivations.size(); i++) {
			ActivityNodeActivation nodeActivation = nodeActivations.get(i);
			nodeActivation.createEdgeInstances();
		}
		// Debug.println("[createEdgeInstances] Done creating edge instances.");
	}

	public void addEdgeInstance(ActivityEdgeInstance instance) {
		// Add the given edge instance to this group.
		instance.group = this;
		this.edgeInstances.add(instance);
	}

	public ActivityExecution getActivityExecution() {
		// Return the activity execution to which this group belongs, directly
		// or indirectly.
		ActivityExecution activityExecution = this.activityExecution;
		if(activityExecution == null) {
			activityExecution = this.containingNodeActivation.group.getActivityExecution();
		}
		// Debug.println("[getActivityExecution] activityExecution = " +
		// activityExecution);
		return activityExecution;
	}

	public List<ActivityParameterNodeActivation> getOutputParameterNodeActivations() {
		// Return the set of all activations in this group of activity parameter
		// nodes for output (inout, out and return) parameters.
		List<ActivityParameterNodeActivation> parameterNodeActivations = new ArrayList<ActivityParameterNodeActivation>();
		List<ActivityNodeActivation> nodeActivations = this.nodeActivations;
		for(int i = 0; i < nodeActivations.size(); i++) {
			ActivityNodeActivation activation = nodeActivations.get(i);
			if(activation instanceof ActivityParameterNodeActivation) {
				if(activation.incomingEdges.size() > 0) {
					parameterNodeActivations.add((ActivityParameterNodeActivation)activation);
				}
			}
		}
		return parameterNodeActivations;
	}

	public Boolean hasSourceFor(ActivityEdgeInstance edgeInstance) {
		// Returns true if this activation group has a node activation
		// corresponding to the source of the given edge instance.
		boolean hasSource = false;
		List<ActivityNodeActivation> activations = this.nodeActivations;
		int i = 1;
		while(!hasSource & i <= activations.size()) {
			hasSource = activations.get(i - 1).isSourceFor(edgeInstance);
			i = i + 1;
		}
		return hasSource;
	}

	public Boolean isSuspended() {
		// Check if this activitation group has any suspended activations and
		// is,
		// therefore, itself suspended.
		return this.suspendedActivations.size() > 0;
	}

	public void suspend(ActivityNodeActivation activation) {
		// Suspend the given activation in this activation group. If this is
		// the only suspended activation, and the activation group has a
		// containing node activation, then suspend that containing activation.
		Debug.println("[suspend] node=" + (activation.node == null ? "null" : activation.node.getName()));
		if(!this.isSuspended()) {
			StructuredActivityNodeActivation containingNodeActivation = this.containingNodeActivation;
			if(containingNodeActivation != null) {
				containingNodeActivation.suspend();
			}
		}
		this.suspendedActivations.add(activation);
	}

	public void resume(ActivityNodeActivation activation) {
		// Resume the given activation by removing it from the suspended
		// activation list for this activation group. If this is the last
		// suspended activation, and the activation group has a containing
		// node activation, then resume that containing activation.
		Debug.println("[resume] node=" + (activation.node == null ? "null" : activation.node.getName()));
		boolean found = false;
		int i = 1;
		while(!found & i <= this.suspendedActivations.size()) {
			if(this.suspendedActivations.get(i - 1) == activation) {
				this.suspendedActivations.remove(i - 1);
				found = true;
			}
			i = i + 1;
		}
		if(!this.isSuspended()) {
			StructuredActivityNodeActivation containingNodeActivation = this.containingNodeActivation;
			if(containingNodeActivation != null) {
				containingNodeActivation.resume();
			}
		}
	}
}
