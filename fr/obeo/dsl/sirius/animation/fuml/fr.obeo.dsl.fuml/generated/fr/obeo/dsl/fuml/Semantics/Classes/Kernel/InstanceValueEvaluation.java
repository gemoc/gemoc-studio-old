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


import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

import fr.obeo.dsl.fuml.debug.Debug;

public class InstanceValueEvaluation extends Evaluation {

	public Value evaluate() {
		// If the instance specification is for an enumeration, then return the
		// identified enumeration literal.
		// If the instance specification is for a data type (but not a primitive
		// value or an enumeration), then create a data value of the given data
		// type.
		// If the instance specification is for an object, then create an object
		// at the current locus with the specified types.
		// Set each feature of the created value to the result of evaluating the
		// value specifications for the specified slot for the feature.
		// Debug.println("[evaluate] InstanceValueEvaluation...");
		InstanceSpecification instance = ((InstanceValue)this.specification).getInstance();
		// List<Classifier> types = instance.getClassifiers();
		// Classifier myType = types.get(0);
		// Debug.println("[evaluate] type = " + myType.getName());
		Value value;
		if(instance instanceof EnumerationLiteral) {
			// Debug.println("[evaluate] Type is an enumeration.");
			EnumerationValue enumerationValue = new EnumerationValue();
			// enumerationValue.type = (Enumeration)myType;
			enumerationValue.type = ((EnumerationLiteral)instance).getEnumeration(); // ADDED
			enumerationValue.literal = (EnumerationLiteral)instance;
			value = enumerationValue;
			Debug.println("[evaluate] type = " + enumerationValue.type.getName()); // ADDED
		} else {
			// ADDED:
			List<Classifier> types = instance.getClassifiers();
			Classifier myType = types.get(0);
			Debug.println("[evaluate] type = " + myType.getName());
			//
			StructuredValue structuredValue = null;
			if(myType instanceof DataType) {
				// Debug.println("[evaluate] Type is a data type.");
				DataValue dataValue = new DataValue();
				dataValue.type = (DataType)myType;
				structuredValue = dataValue;
			} else {
				Object_ object = null;
				if(myType instanceof Behavior) {
					// Debug.println("[evaluate] Type is a behavior.");
					object = this.locus.factory.createExecution((Behavior)myType, null);
				} else {
					// Debug.println("[evaluate] Type is a class.");
					object = new Object_();
					for(int i = 0; i < types.size(); i++) {
						Classifier type = types.get(i);
						object.types.add((Class)type);
					}
				}
				this.locus.add(object);
				Reference reference = new Reference();
				reference.referent = object;
				structuredValue = reference;
			}
			structuredValue.createFeatureValues();
			// Debug.println("[evaluate] " + instance.slot.size() +
			// " slot(s).");
			List<Slot> instanceSlots = instance.getSlots();
			for(int i = 0; i < instanceSlots.size(); i++) {
				Slot slot = instanceSlots.get(i);
				List<Value> values = new ArrayList<Value>();
				// Debug.println("[evaluate] feature = " +
				// slot.definingFeature.getName() + ", " + slot.value.size() +
				// " value(s).");
				List<ValueSpecification> slotValues = slot.getValues();
				for(int j = 0; j < slotValues.size(); j++) {
					ValueSpecification slotValue = slotValues.get(j);
					// Debug.println("[evaluate] Value = " +
					// slotValue.getClass().getName());
					values.add(this.locus.executor.evaluate(slotValue));
				}
				structuredValue.setFeatureValue(slot.getDefiningFeature(), values, 0);
			}
			value = structuredValue;
		}
		return value;
	}
}
