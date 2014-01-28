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

import java.util.List;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;

public class Reference extends StructuredValue {

	public Object_ referent;

	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// Asynchronously start the behavior of the given classifier for the
		// referent object.
		this.referent.startBehavior(classifier, inputs);
	}

	public Execution dispatch(Operation operation) {
		// Dispatch the given operation to the referent object.
		return this.referent.dispatch(operation);
	}

	public void send(SignalInstance signalInstance) {
		// Send the given signal instance to the referent object.
		this.referent.send(signalInstance);
	}

	public void destroy() {
		// Destroy the referent.
		this.referent.destroy();
	}

	public Boolean equals(Value otherValue) {
		// Test if this reference is equal to the otherValue.
		// To be equal, the otherValue must also be a reference, with the same
		// referent as this reference.
		boolean isEqual = false;
		if(otherValue instanceof Reference) {
			isEqual = (((Reference)otherValue).referent == this.referent);
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new reference with the same referent as this reference.
		Reference newValue = (Reference)(super.copy());
		newValue.referent = this.referent;
		return newValue;
	}

	public Value new_() {
		// Create a new reference with no referent.
		return new Reference();
	}

	public List<Classifier> getTypes() {
		// Get the types of the referent object.
		return this.referent.getTypes();
	}

	public FeatureValue getFeatureValue(StructuralFeature feature) {
		// Get the feature value associated with the given feature in the
		// referent object.
		return this.referent.getFeatureValue(feature);
	}

	public void setFeatureValue(StructuralFeature feature, List<Value> values, Integer position) {
		// Set the values associated with the given feature in the referent
		// object.
		this.referent.setFeatureValue(feature, values, position);
	}

	public List<FeatureValue> getFeatureValues() {
		// Return the feature values of the referent.
		return this.referent.getFeatureValues();
	}

	public String toString() {
		return "Reference to " + this.referent.toString();
	}
}
