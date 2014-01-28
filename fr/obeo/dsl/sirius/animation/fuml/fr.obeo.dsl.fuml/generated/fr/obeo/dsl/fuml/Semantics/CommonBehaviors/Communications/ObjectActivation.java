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
package fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import fr.obeo.dsl.fuml.debug.Debug;

public class ObjectActivation {

	/*
	 * The executing classifier behaviors for this object activation.
	 */
	public List<ClassifierBehaviorExecution> classifierBehaviorExecutions = new ArrayList<ClassifierBehaviorExecution>();

	/*
	 * The set of event accepters waiting for signals to be received by the
	 * object of this object activation.
	 */
	public List<EventAccepter> waitingEventAccepters = new ArrayList<EventAccepter>();

	/*
	 * The pool of signals sent to the object of this object activation, pending
	 * dispatching as events. (All the data values in the pool must be signal
	 * instances -- that is, they must have a single type that is a signal.)
	 */
	public List<SignalInstance> eventPool = new ArrayList<SignalInstance>();

	/*
	 * The object whose active behavior is being handled by this active object.
	 */
	public Object_ object;

	public void stop() {
		// Stop this object activation by terminating all classifier behavior
		// executions.
		List<ClassifierBehaviorExecution> classifierBehaviorExecutions = this.classifierBehaviorExecutions;
		for(int i = 0; i < classifierBehaviorExecutions.size(); i++) {
			ClassifierBehaviorExecution classifierBehaviorExecution = classifierBehaviorExecutions.get(i);
			classifierBehaviorExecution.terminate();
		}
	}

	public void register(EventAccepter accepter) {
		// Register the given event accepter to wait for a dispatched signal
		// event.
		Debug.println("[register] object = " + this.object);
		Debug.println("[register] accepter = " + accepter);
		this.waitingEventAccepters.add(accepter);
	}

	public void unregister(EventAccepter accepter) {
		// Remove the given event accepter for the list of waiting event
		// accepters.
		Debug.println("[unregister] object = " + this.object);
		Debug.println("[unregister] accepter = " + accepter);
		boolean notFound = true;
		int i = 1;
		while(notFound & i <= this.waitingEventAccepters.size()) {
			if(this.waitingEventAccepters.get(i - 1) == accepter) {
				this.waitingEventAccepters.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
	}

	public void dispatchNextEvent() {
		// Get the next signal instance out of the event pool.
		// If there is one or more waiting event accepters with triggers that
		// match the signal instance, then dispatch it to exactly one of those
		// waiting accepters.
		if(this.eventPool.size() > 0) {
			SignalInstance signalInstance = this.getNextEvent();
			Debug.println("[dispatchNextEvent] signalInstance = " + signalInstance);
			List<Integer> matchingEventAccepterIndexes = new ArrayList<Integer>();
			List<EventAccepter> waitingEventAccepters = this.waitingEventAccepters;
			for(int i = 0; i < waitingEventAccepters.size(); i++) {
				EventAccepter eventAccepter = waitingEventAccepters.get(i);
				if(eventAccepter.match(signalInstance)) {
					matchingEventAccepterIndexes.add(i);
				}
			}
			if(matchingEventAccepterIndexes.size() > 0) {
				// *** Choose one matching event accepter non-deterministically.
				// ***
				int j = ((ChoiceStrategy)this.object.locus.factory.getStrategy("choice")).choose(matchingEventAccepterIndexes.size());
				EventAccepter selectedEventAccepter = this.waitingEventAccepters.get(matchingEventAccepterIndexes.get(j - 1));
				this.waitingEventAccepters.remove(j - 1);
				selectedEventAccepter.accept(signalInstance);
			}
		}
	}

	public SignalInstance getNextEvent() {
		// Get the next event from the event pool, using a get next event
		// strategy.
		return ((GetNextEventStrategy)this.object.locus.factory.getStrategy("getNextEvent")).getNextEvent(this);
	}

	public void send(SignalInstance signalInstance) {
		// Add the given signal instance to the event pool and signal that a new
		// signal instance has arrived.
		this.eventPool.add((SignalInstance)(signalInstance.copy()));
		_send(new ArrivalSignal());
	}

	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// Start the event dispatch loop for this object activation (if it has
		// not already been started).
		// If a classifier is given that is a type of the object of this object
		// activation and there is not already a classifier behavior execution
		// for it,
		// then create a classifier behavior execution for it.
		// Otherwise, create a classifier behavior execution for each of the
		// types of the object of this object activation which has a classifier
		// behavior or which is a behavior itself
		// and for which there is not currently a classifier behavior execution.
		// Start EventDispatchLoop
		_startObjectBehavior();
		if(classifier == null) {
			Debug.println("[startBehavior] Starting behavior for all classifiers...");
			// *** Start all classifier behaviors concurrently. ***
			List<Class> types = this.object.types;
			for(Iterator<Class> i = types.iterator(); i.hasNext();) {
				Class type = i.next();
				if(type instanceof Behavior | type.getClassifierBehavior() != null) {
					this.startBehavior(type, new ArrayList<ParameterValue>());
				}
			}
		} else {
			Debug.println("[startBehavior] Starting behavior for " + classifier.getName() + "...");
			boolean notYetStarted = true;
			int i = 1;
			while(notYetStarted & i <= this.classifierBehaviorExecutions.size()) {
				notYetStarted = (this.classifierBehaviorExecutions.get(i - 1).classifier != classifier);
				i = i + 1;
			}
			if(notYetStarted) {
				ClassifierBehaviorExecution newExecution = new ClassifierBehaviorExecution();
				newExecution.objectActivation = this;
				this.classifierBehaviorExecutions.add(newExecution);
				newExecution.execute(classifier, inputs);
			}
		}
	}

	
	int signalCount = 0;
	public void _startObjectBehavior() {
		// *** This should start the EventDispatchLoop ***

		while (this.signalCount > 0) {
			this.dispatchNextEvent();
			signalCount = signalCount - 1;
		}
	} // _startObjectBehavior

	public void _send(ArrivalSignal signal) {
		// Signal the arrival of a new signal instance in the event pool.
		// *** This should send an ArrivalSignal to the EventDispatchLoop. ***
		
		this.signalCount = this.signalCount + 1;
		if (this.signalCount == 1) {
			this._startObjectBehavior();
		}
	} // _send

}
