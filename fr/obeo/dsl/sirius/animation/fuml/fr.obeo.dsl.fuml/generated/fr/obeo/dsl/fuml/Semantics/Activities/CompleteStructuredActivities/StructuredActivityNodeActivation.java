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
package fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;

import fr.obeo.dsl.fuml.FUMLExecutionEngine;
import fr.obeo.dsl.fuml.FUMLExecutionEngineForDSL;
import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.PinActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivationGroup;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ObjectToken;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.Token;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class StructuredActivityNodeActivation extends ActionActivation {

	/*
	 * The group of activations of the activity nodes contained in the
	 * structured activity node.
	 */
	public ActivityNodeActivationGroup activationGroup;

	public void doAction() {
		// If the structured activity node has mustIsolate=true, then carry out
		// its behavior with isolation.
		// Otherwise just activate it normally.
		if(((StructuredActivityNode)(this.node)).isMustIsolate()) {
			_beginIsolation();
			this.doStructuredActivity();
			_endIsolation();
		} else {
			this.doStructuredActivity();
		}
	}

	public void doStructuredActivity() {
		// Run all activations of contained nodes. When this is complete,
		// return.
		// (This is the default behavior for a structured activity node used
		// simply as a group. It is overridden for the execution of conditional
		// and loop nodes.)
		Action action = (Action)(this.node);
		// *** Concurrently send offers from all input pins. ***
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for(Iterator<InputPin> i = inputPins.iterator(); i.hasNext();) {
			InputPin inputPin = i.next();
			PinActivation pinActivation = this.getPinActivation(inputPin);
			pinActivation.sendUnofferedTokens();
		}
		this.activationGroup.run(this.activationGroup.nodeActivations);
	}

	public void terminate() {
		// Terminate the execution of all contained node activations (which
		// completes the performance of the structured activity node
		// activation), and then terminate this node itself.
		this.terminateAll();
		super.terminate();
	}

	public ActivityNodeActivation getNodeActivation(ActivityNode node) {
		// If this structured activity node activation is not for the given
		// node, then check if there is an activation for the node in the
		// activation group.
		ActivityNodeActivation thisActivation = super.getNodeActivation(node);
		ActivityNodeActivation activation = null;
		if(thisActivation != null) {
			activation = thisActivation;
		} else if(this.activationGroup != null) {
			activation = this.activationGroup.getNodeActivation(node);
		}
		return activation;
	}

	public List<ActivityNode> makeActivityNodeList(List<ExecutableNode> nodes) {
		// Return an activity node list containing the given list of executable
		// nodes
		// and any pins that they own.
		List<ActivityNode> activityNodes = new ArrayList<ActivityNode>();
		for(int i = 0; i < nodes.size(); i++) {
			ActivityNode node = nodes.get(i);
			activityNodes.add(node);
			if(node instanceof Action) {
				Action action = (Action)node;
				List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
				for(int j = 0; j < inputPins.size(); j++) {
					InputPin inputPin = inputPins.get(j);
					activityNodes.add(inputPin);
				}
				List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
				for(int j = 0; j < outputPins.size(); j++) {
					OutputPin outputPin = outputPins.get(j);
					activityNodes.add(outputPin);
				}
			}
		}
		return activityNodes;
	}

	public List<Value> getPinValues(OutputPin pin) {
		// Return the values of the tokens on the pin activation corresponding
		// to the given pin in the internal activation group for this node
		// activation.
		PinActivation pinActivation = (PinActivation)(this.activationGroup.getNodeActivation(pin));
		List<Token> tokens = pinActivation.getTokens();
		List<Value> values = new ArrayList<Value>();
		for(int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			Value value = ((ObjectToken)token).value;
			if(value != null) {
				values.add(value);
			}
		}
		return values;
	}

	public void putPinValues(OutputPin pin, List<Value> values) {
		// Place tokens for the given values on the pin activation corresponding
		// to the given output pin on the internal activation group for this
		// node activation.
		PinActivation pinActivation = (PinActivation)(this.activationGroup.getNodeActivation(pin));
		for(int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			ObjectToken token = new ObjectToken();
			token.value = value;
			pinActivation.addToken(token);
		}
	}

	public void createNodeActivations() {
		// Create an activation group and create node activations for all the
		// nodes within the structured activity node.
		super.createNodeActivations();

		this.activationGroup = new ActivityNodeActivationGroup();
		this.activationGroup.containingNodeActivation = this;
		this.activationGroup.createNodeActivations(((StructuredActivityNode)(this.node)).getNodes());
	}

	public void createEdgeInstances() {
		// Create instances for all edges owned by this node.
		this.activationGroup.createEdgeInstances(((StructuredActivityNode)(this.node)).getEdges());
	}

	public Boolean isSourceFor(ActivityEdgeInstance edgeInstance) {
		// Returns true if this node is either the source for the given
		// edgeInstance itself or if it contains the source in its
		// activation group.
		boolean isSource = super.isSourceFor(edgeInstance);
		if(!isSource) {
			isSource = this.activationGroup.hasSourceFor(edgeInstance);
		}
		return isSource;
	}

	public void terminateAll() {
		// Terminate the execution of all contained node activations (which
		// completes the performance of the structured activity node
		// activation).
		this.activationGroup.terminateAll();
	}

	public Boolean isSuspended() {
		// Check if the activation group for this node is suspended.
		return this.activationGroup.isSuspended();
	}

	public List<Token> completeAction() {
		// Only actually complete this structured activity node if it is not
		// suspended.
		List<Token> incomingTokens = new ArrayList<Token>();
		if(!this.isSuspended()) {
			incomingTokens = super.completeAction();
		}
		return incomingTokens;
	}

	public void resume() {
		// When this structured activity node is resumed after being suspended,
		// then complete its prior firing and, if there are more incoming
		// tokens, fire it again. If, after that, the node is not suspended,
		// then finish its resumption.
		List<Token> incomingTokens = super.completeAction();
		if(incomingTokens.size() > 0) {
			// FIXME need to check is the debugger is stepping.
			if (FUMLExecutionEngine.eInstance.getDebugger() != null && FUMLExecutionEngine.eInstance.getDebugger().control(Thread.currentThread().getName(), this)) // Added for connection with debug API
				this.fire(incomingTokens);
		}
		if(!this.isSuspended()) {
			super.resume();
		}
	}
}
