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

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public abstract class StructuredValue extends Value {

	public ValueSpecification specify() {
		// Return an instance value that specifies this structured value.
		// Debug.println("[specify] StructuredValue...");
		InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
		InstanceSpecification instance = UMLFactory.eINSTANCE.createInstanceSpecification();
		instanceValue.setType(null);
		instanceValue.setInstance(instance);
		instance.getClassifiers().addAll(this.getTypes());
		List<FeatureValue> featureValues = this.getFeatureValues();
		// Debug.println("[specify] " + featureValues.size() + " feature(s).");
		for(int i = 0; i < featureValues.size(); i++) {
			FeatureValue featureValue = featureValues.get(i);
			Slot slot = UMLFactory.eINSTANCE.createSlot();
			slot.setDefiningFeature(featureValue.feature);
			// Debug.println("[specify] feature = " + featureValue.feature.name
			// + ", " + featureValue.values.size() + " value(s).");
			List<Value> values = featureValue.values;
			for(int j = 0; j < values.size(); j++) {
				Value value = values.get(j);
				// Debug.println("[specify] value = " + value);
				slot.getValues().add(value.specify());
			}
			instance.getSlots().add(slot);
		}
		return instanceValue;
	}

	public abstract FeatureValue getFeatureValue(StructuralFeature feature);

	public abstract void setFeatureValue(StructuralFeature feature, List<Value> values, Integer position);

	public abstract List<FeatureValue> getFeatureValues();

	public void createFeatureValues() {
		// Create empty feature values for all structural features, direct and
		// inherited, of the types of this structured value.
		List<Classifier> types = this.getTypes();
		for(int i = 0; i < types.size(); i++) {
			Classifier type = types.get(i);
			this.createFeatureValuesFromType(type); // REPLACED body of loop
		}
	}	
	
	// ADDED
	public void createFeatureValuesFromType(Classifier type) {
		// Create empty feature values for all structural features from the
		// given type and all its direct and indirect parents.
		// [Note that this is necessary in order to set the feature values for
		// private structural features of parent classifiers, since these are
		// not actually inherited.]
		List<NamedElement> ownedMembers = type.getOwnedMembers();
		for(int i = 0; i < ownedMembers.size(); i++) {
			NamedElement member = ownedMembers.get(i);
			if(member instanceof StructuralFeature) {
				this.setFeatureValue((StructuralFeature)member, new ArrayList<Value>(), 0);
			}
		}
		
		List<Classifier> generals = type.getGenerals();
		for (int i = 0; i < generals.size(); i++) {
			Classifier general = generals.get(i);
			this.createFeatureValuesFromType(general);
		}
	}
	//
}
