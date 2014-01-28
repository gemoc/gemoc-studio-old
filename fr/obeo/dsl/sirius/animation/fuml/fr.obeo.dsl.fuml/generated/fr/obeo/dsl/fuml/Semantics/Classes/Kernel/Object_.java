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
package fr.obeo.dsl.fuml.Semantics.Classes.Kernel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.ObjectActivation;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import fr.obeo.dsl.fuml.debug.Debug;

public class Object_ extends ExtensionalValue {

	/*
	 * The classes under which this object is currently classified. (A destroyed
	 * object has no types.)
	 */
	public List<Class> types = new ArrayList<Class>();

	/*
	 * The object activation handling the active behavior of this object.
	 */
	public ObjectActivation objectActivation;

	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// Create an object activation for this object (if one does not already
		// exist) and start its behavior(s).
		// Debug.println("[startBehavior] On object...");
		if(this.objectActivation == null) {
			this.objectActivation = new ObjectActivation();
			this.objectActivation.object = this;
		}
		// Debug.println("[startBehavior] objectActivation = " +
		// objectActivation);
		this.objectActivation.startBehavior(classifier, inputs);
	}

	public Execution dispatch(Operation operation) {
		// Dispatch the given operation to a method execution, using a dispatch
		// strategy.
		return ((DispatchStrategy)this.locus.factory.getStrategy("dispatch")).dispatch(this, operation);
	}

	public void send(SignalInstance signalInstance) {
		// If the object is active, add the given signal instance to the event
		// pool and signal that a new signal instance has arrived.
		if(this.objectActivation != null) {
			this.objectActivation.send(signalInstance);
		}
	}

	public void destroy() {
		// Stop the object activation (if any), clear all types and destroy the
		// object as an extensional value.
		Debug.println("[destroy] object = " + this.objectId());
		if(this.objectActivation != null) {
			this.objectActivation.stop();
			this.objectActivation = null;
		}
		this.types.clear();
		super.destroy();
	}

	public void register(EventAccepter accepter) {
		// Register the given accept event accepter to wait for a dispatched
		// signal event.
		if(this.objectActivation != null) {
			this.objectActivation.register(accepter);
		}
	}

	public void unregister(EventAccepter accepter) {
		// Remove the given event accepter for the list of waiting event
		// accepters.
		if(this.objectActivation != null) {
			this.objectActivation.unregister(accepter);
		}
	}

	public Value copy() {
		// Create a new object that is a copy of this object at the same locus
		// as this object.
		// However, the new object will NOT have any object activation (i.e, its
		// classifier behaviors will not be started).
		Object_ newObject = (Object_)(super.copy());
		List<Class> types = this.types;
		for(int i = 0; i < types.size(); i++) {
			Class type = types.get(i);
			newObject.types.add(type);
		}
		return newObject;
	}

	public Value new_() {
		// Create a new object with no type, feature values or locus.
		return new Object_();
	}

	public List<Classifier> getTypes() {
		// Return the types of this object.
		List<Classifier> types = new ArrayList<Classifier>();
		List<Class> myTypes = this.types;
		for(int i = 0; i < myTypes.size(); i++) {
			Class type = myTypes.get(i);
			types.add(type);
		}
		return types;
	}
}
