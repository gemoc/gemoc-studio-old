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
package fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Trigger;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.Token;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import fr.obeo.dsl.fuml.debug.Debug;

public class AcceptEventActionActivation extends ActionActivation {

	/*
	 * If the accept event action activation is waiting for an event, then this
	 * is the accepter it has registered for the event.
	 */
	public AcceptEventActionEventAccepter eventAccepter;

	public Boolean waiting;

	public void run() {
		// Create an event accepter and initialize waiting to false.
		super.run();
		this.eventAccepter = new AcceptEventActionEventAccepter();
		this.eventAccepter.actionActivation = this;
		this.waiting = false;
	}

	public void fire(List<Token> incomingTokens) {
		// Register the event accepter for this accept event action activation
		// with the context object of the enclosing activity execution
		// and wait for an event to be accepted.
		Debug.println("[fire] Action " + this.node.getName() + "...");
		this.getExecutionContext().register(this.eventAccepter);
		this.waiting = true;
		this.firing = false;
		this.suspend();
	}

	public Boolean isReady() {
		// An accept event action activiation is ready to fire only if it is not
		// already waiting for an event.
		boolean ready;
		if(this.isWaiting()) { // CHANGED "this.waiting" to "this.isWaiting()".
			ready = false;
		} else {
			ready = super.isReady();
		}
		return ready;
	}
	
	// ADDED:
	public Boolean isWaiting() {
		return this.waiting == null? false: this.waiting;
	}
	//

	public void doAction() {
		// Do nothing. [This will never be called.]
		return;
	}

	public void accept(SignalInstance signalInstance) {
		// Accept a signal occurance for the given signal instance.
		// If the action does not unmarshall, then place the signal instance on
		// the result pin, if any.
		// If the action does unmarshall, then get the feature values of the
		// signal instance, and place the values for each feature on the
		// corresponding output pin.
		// Concurrently fire all output pins while offering a single control
		// token.
		// If there are no incoming edges, then re-register this accept event
		// action execution with the context object.
		AcceptEventAction action = (AcceptEventAction)(this.node);
		List<OutputPin> resultPins = action.getResults();
		Debug.println("[accept] action = " + action.getName() + ", signalinstance = " + signalInstance);
		if(this.running) {
			if(!action.isUnmarshall()) {
				List<Value> result = new ArrayList<Value>();
				result.add(signalInstance);
				if(resultPins.size() > 0) {
					this.putTokens(resultPins.get(0), result);
				}
			} else {
				List<FeatureValue> featureValues = signalInstance.getFeatureValues();
				for(int i = 0; i < featureValues.size(); i++) {
					FeatureValue featureValue = featureValues.get(i);
					OutputPin resultPin = resultPins.get(i);
					this.putTokens(resultPin, featureValue.values);
				}
			}
			this.sendOffers();
			this.waiting = false;
			Debug.println("[fire] Checking if " + this.node.getName() + " should fire again...");
			this.receiveOffer();
			this.resume();
		}
	}

	public Boolean match(SignalInstance signalInstance) {
		// Return true if the given signal instance matches a trigger of the
		// accept action of this activation.
		AcceptEventAction action = (AcceptEventAction)(this.node);
		List<Trigger> triggers = action.getTriggers();
		Signal signal = signalInstance.type;
		boolean matches = false;
		int i = 1;
		while(!matches & i <= triggers.size()) {
			matches = ((SignalEvent)(triggers.get(i - 1).getEvent())).getSignal() == signal;
			i = i + 1;
		}
		return matches;
	}

	public void terminate() {
		// Terminate this action and unregister its event accepter.
		super.terminate();
		if(this.isWaiting()) { // CHANGED "this.waiting" to "this.isWaiting()".
			this.getExecutionContext().unregister(this.eventAccepter);
			this.waiting = false;
		}
	}
}
