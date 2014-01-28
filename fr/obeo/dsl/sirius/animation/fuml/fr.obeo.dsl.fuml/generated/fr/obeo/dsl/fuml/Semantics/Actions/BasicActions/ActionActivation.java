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
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.UMLFactory;

import fr.obeo.dsl.fuml.FUMLExecutionEngine;
import fr.obeo.dsl.fuml.FUMLExecutionEngineForDSL;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityEdgeInstance;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ControlToken;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ForkNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ObjectToken;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.Token;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.BooleanValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.debug.Debug;

public abstract class ActionActivation extends ActivityNodeActivation {

	/*
	 * The activations of the pins owned by the action of this action
	 * activation.
	 */
	public List<PinActivation> pinActivations = new ArrayList<PinActivation>();

	/*
	 * Whether this action activation is already firing. This attribute is only
	 * used if the action for this action activation has isLocallyReentrant =
	 * false (the default). If isLocallyReentrant=true, then firing always just
	 * remains false.
	 */
	public Boolean firing;

	public void run() {
		// Run this action activation and any outoging fork node attached to it.
		super.run();
		if(this.outgoingEdges.size() > 0) {
			this.outgoingEdges.get(0).target.run();
		}
		this.firing = false;
	}

	public List<Token> takeOfferedTokens() {
		// If the action is not locally reentrant, then mark this activation as
		// firing.
		// Take any incoming offers of control tokens, then concurrently fire
		// all input pin activations.
		// Note: This is included here to happen in the same isolation scope as
		// the isReady test.
		this.firing = !((Action)this.node).isLocallyReentrant();
		List<Token> offeredTokens = new ArrayList<Token>();
		List<ActivityEdgeInstance> incomingEdges = this.incomingEdges;
		for(int i = 0; i < incomingEdges.size(); i++) {
			ActivityEdgeInstance incomingEdge = incomingEdges.get(i);
			List<Token> tokens = incomingEdge.takeOfferedTokens();
			for(int j = 0; j < tokens.size(); j++) {
				Token token = tokens.get(j);
				token.withdraw();
				offeredTokens.add(token);
			}
		}
		Action action = (Action)(this.node);
		// *** Fire all input pins concurrently. ***
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for(Iterator<InputPin> i = inputPins.iterator(); i.hasNext();) {
			InputPin pin = i.next();
			PinActivation pinActivation = this.getPinActivation(pin);
			List<Token> tokens = pinActivation.takeOfferedTokens();
			// FIXME need to check is the debugger is stepping.
			if (FUMLExecutionEngine.eInstance.getDebugger() != null && FUMLExecutionEngine.eInstance.getDebugger().control(Thread.currentThread().getName(), pinActivation)) // Added for connection with debug API
				pinActivation.fire(tokens);
			for(int j = 0; j < tokens.size(); j++) {
				Token token = tokens.get(j);
				offeredTokens.add(token);
			}
		}
		return offeredTokens;
	}

	public void fire(List<Token> incomingTokens) {
		// Do the main action behavior then concurrently fire all output pin
		// activations
		// and offer a single control token. Then activate the action again,
		// if it is still ready to fire and has at least one token actually
		// being
		// offered to it.
		do {
			Debug.println("[fire] Action " + this.node.getName() + "...");
			Debug.println("[event] Fire activity=" + this.getActivityExecution().getBehavior().getName() + " action=" + this.node.getName());
			this.doAction();
			incomingTokens = this.completeAction();
		} while(incomingTokens.size() > 0);
	}

	public void terminate() {
		// Terminate this action activation and any outgoing fork node attached
		// to it.
		super.terminate();
		if(this.outgoingEdges.size() > 0) {
			this.outgoingEdges.get(0).target.terminate();
		}
	}

	public List<Token> completeAction() {
		// Concurrently fire all output pin activations and offer a single
		// control token. Then check if the action should fire again
		// and, if so, return additional incoming tokens for this.
		this.sendOffers();
		Debug.println("[fire] Checking if " + this.node.getName() + " should fire again...");
		_beginIsolation();
		List<Token> incomingTokens = new ArrayList<Token>();
		this.firing = false;
		if(this.isReady()) {
			incomingTokens = this.takeOfferedTokens();
			this.firing = this.isFiring() & incomingTokens.size() > 0;
		}
		_endIsolation();
		return incomingTokens;
	}

	public Boolean isReady() {
		// In addition to the default condition, check that, if the action has
		// isLocallyReentrant=false, then the activation is not currently
		// firing,
		// and that the sources of all incoming edges (control flows) have
		// offers and all input pin activations are ready.
		// [This assumes that all edges directly incoming to the action are
		// control flows.]
		boolean ready = super.isReady() & (((Action)this.node).isLocallyReentrant() | !this.isFiring());
		int i = 1;
		while(ready & i <= this.incomingEdges.size()) {
			ready = this.incomingEdges.get(i - 1).hasOffer();
			i = i + 1;
		}
		List<InputPin> inputPins = getInputs((Action)this.node); // CHANGED from: ((Action)(this.node)).getInputs();
		int j = 1;
		while(ready & j <= inputPins.size()) {
			ready = this.getPinActivation(inputPins.get(j - 1)).isReady();
			j = j + 1;
		}
		return ready;
	}

	public Boolean isFiring() {
		// Indicate whether this action activation is currently firing or not.
		return this.firing == null? false: this.firing; // ADDED check for null
	}

	public abstract void doAction();

	public void sendOffers() {
		// Fire all output pins and send offers on all outgoing control flows.
		Action action = (Action)(this.node);
		// *** Send offers from all output pins concurrently. ***
		List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
		for(Iterator<OutputPin> i = outputPins.iterator(); i.hasNext();) {
			OutputPin outputPin = i.next();
			PinActivation pinActivation = this.getPinActivation(outputPin);
			pinActivation.sendUnofferedTokens();
		}
		// Send offers on all outgoing control flows.
		if(this.outgoingEdges.size() > 0) {
			List<Token> tokens = new ArrayList<Token>();
			tokens.add(new ControlToken());
			this.addTokens(tokens);
			this.outgoingEdges.get(0).sendOffer(tokens);
		}
	}

	public void createNodeActivations() {
		// Create node activations for the input and output pins of the action
		// for this activation.
		// [Note: Pins are owned by their actions, not by the enclosing activity
		// (or group), so they must be activated through the action activation.]
		Action action = (Action)(this.node);
		List<ActivityNode> inputPinNodes = new ArrayList<ActivityNode>();
		List<InputPin> inputPins = getInputs(action); // CHANGED from: action.getInputs();
		for(int i = 0; i < inputPins.size(); i++) {
			InputPin inputPin = inputPins.get(i);
			inputPinNodes.add(inputPin);
		}
		this.group.createNodeActivations(inputPinNodes);
		for(int i = 0; i < inputPinNodes.size(); i++) {
			ActivityNode node = inputPinNodes.get(i);
			this.addPinActivation((PinActivation)(this.group.getNodeActivation(node)));
		}
		List<ActivityNode> outputPinNodes = new ArrayList<ActivityNode>();
		List<OutputPin> outputPins = getOutputs(action); // CHANGED from: action.getOutputs();
		for(int i = 0; i < outputPins.size(); i++) {
			OutputPin outputPin = outputPins.get(i);
			outputPinNodes.add(outputPin);
		}
		this.group.createNodeActivations(outputPinNodes);
		for(int i = 0; i < outputPinNodes.size(); i++) {
			ActivityNode node = outputPinNodes.get(i);
			this.addPinActivation((PinActivation)(this.group.getNodeActivation(node)));
		}
	}

	public void addOutgoingEdge(ActivityEdgeInstance edge) {
		// If there are no outgoing activity edge instances, create a single
		// activity edge instance with a fork node execution at the other end.
		// Add the give edge to the fork node execution that is the target of
		// the activity edge instance out of this action execution.
		// [This assumes that all edges directly outgoing from the action are
		// control flows, with an implicit fork for offers out of the action.]
		ActivityNodeActivation forkNodeActivation;
		if(this.outgoingEdges.size() == 0) {
			forkNodeActivation = new ForkNodeActivation();
			forkNodeActivation.running = false; // ADDED
			ActivityEdgeInstance newEdge = new ActivityEdgeInstance();
			super.addOutgoingEdge(newEdge);
			forkNodeActivation.addIncomingEdge(newEdge);
		} else {
			forkNodeActivation = this.outgoingEdges.get(0).target;
		}
		forkNodeActivation.addOutgoingEdge(edge);
	}

	public void addPinActivation(PinActivation pinActivation) {
		// Add a pin activation to this action activation.
		this.pinActivations.add(pinActivation);
		pinActivation.actionActivation = this;
	}

	public PinActivation getPinActivation(Pin pin) {
		// Precondition: The given pin is owned by the action of the action
		// activation.
		// Return the pin activation corresponding to the given pin.
		PinActivation pinActivation = null;
		int i = 1;
		while(pinActivation == null & i <= this.pinActivations.size()) {
			PinActivation thisPinActivation = this.pinActivations.get(i - 1);
			if(thisPinActivation.node == pin) {
				pinActivation = thisPinActivation;
			}
			i = i + 1;
		}
		return pinActivation;
	}

	public void putToken(OutputPin pin, Value value) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Place a token for the given value on the pin activation corresponding
		// to the given output pin.
		Debug.println("[putToken] node = " + this.node.getName());
		ObjectToken token = new ObjectToken();
		token.value = value;
		PinActivation pinActivation = this.getPinActivation(pin);
		pinActivation.addToken(token);
	}

	public void putTokens(OutputPin pin, List<Value> values) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Place tokens for the given values on the pin activation corresponding
		// to the given output pin.
		// Debug.println("[putTokens] node = " + this.node.getName());
		for(int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			this.putToken(pin, value);
		}
	}

	public List<Value> getTokens(InputPin pin) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Get any tokens held by the pin activation corresponding to the given
		// input pin and return them
		// (but leave the tokens on the pin).
		Debug.println("[getTokens] node = " + this.node.getName() + ", pin = " + pin.getName());
		PinActivation pinActivation = this.getPinActivation(pin);
		List<Token> tokens = pinActivation.getUnofferedTokens();
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

	public List<Value> takeTokens(InputPin pin) {
		// Precondition: The action execution has fired and the given pin is
		// owned by the action of the action execution.
		// Take any tokens held by the pin activation corresponding to the given
		// input pin and return them.
		Debug.println("[takeTokens] node = " + this.node.getName() + ", pin = " + pin.getName());
		PinActivation pinActivation = this.getPinActivation(pin);
		List<Token> tokens = pinActivation.takeUnofferedTokens();
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

	public Boolean isSourceFor(ActivityEdgeInstance edgeInstance) {
		// If this action has an outgoing fork node, check that the fork node is
		// the source of the given edge instance.
		boolean isSource = false;
		if(this.outgoingEdges.size() > 0) {
			isSource = this.outgoingEdges.get(0).target.isSourceFor(edgeInstance);
		}
		return isSource;
	}

	public Boolean valueParticipatesInLink(Value value, Link link) {
		// Test if the given value participates in the given link.
		List<FeatureValue> linkFeatureValues = link.getFeatureValues();
		boolean participates = false;
		int i = 1;
		while(!participates & i <= linkFeatureValues.size()) {
			participates = linkFeatureValues.get(i - 1).values.get(0).equals(value);
			i = i + 1;
		}
		return participates;
	}

	public BooleanValue makeBooleanValue(Boolean value) {
		// Make a Boolean value using the built-in Boolean primitive type.
		// [This ensures that Boolean values created internally are the same as
		// the default used for evaluating Boolean literals.]
		LiteralBoolean booleanLiteral = UMLFactory.eINSTANCE.createLiteralBoolean();
		booleanLiteral.setValue(value);
		return (BooleanValue)(this.getExecutionLocus().executor.evaluate(booleanLiteral));
	}
	
	// ADDED:
	protected static List<InputPin> getInputs(Action action) {
		return action instanceof LoopNode? ((LoopNode)action).getLoopVariableInputs():
			   action.getInputs();
	}
	
	protected static List<OutputPin> getOutputs(Action action) {
		return action instanceof LoopNode? ((LoopNode)action).getResults():
			   action instanceof ConditionalNode? ((ConditionalNode)action).getResults():
			   action.getOutputs();
	}
	//
}
