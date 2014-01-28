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
import org.eclipse.uml2.uml.StructuralFeature;

public abstract class CompoundValue extends StructuredValue {

	public List<FeatureValue> featureValues = new ArrayList<FeatureValue>();

	public Boolean equals(Value otherValue) {
		// Test if this data value is equal to the otherValue.
		// To be equal, the otherValue must also be a compund value with the
		// same types and equal values for each feature.
		// Debug.println("[equals] othervalue instanceof CompoundValue = " +
		// (otherValue instanceof CompoundValue));
		// Debug.println("[equals] super.equals(otherValue) = " +
		// super.equals(otherValue));
		boolean isEqual = otherValue instanceof CompoundValue;
		if(isEqual) {
			CompoundValue otherCompoundValue = (CompoundValue)otherValue;
			// Debug.println("[equals] " + this.featureValues.size() +
			// " feature(s).");
			isEqual = super.equals(otherValue) & otherCompoundValue.featureValues.size() == this.featureValues.size();
			int i = 1;
			while(isEqual & i <= this.featureValues.size()) {
				FeatureValue thisFeatureValue = this.featureValues.get(i - 1);
				boolean matched = false;
				int j = 1;
				while(!matched & j <= otherCompoundValue.featureValues.size()) {
					FeatureValue otherFeatureValue = otherCompoundValue.featureValues.get(j - 1);
					if(thisFeatureValue.feature == otherFeatureValue.feature) {
						matched = thisFeatureValue.hasEqualValues(otherFeatureValue);
					}
					j = j + 1;
				}
				isEqual = matched;
				i = i + 1;
			}
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new data value with the same featureValues as this data
		// value.
		CompoundValue newValue = (CompoundValue)(super.copy());
		List<FeatureValue> featureValues = this.featureValues;
		for(int i = 0; i < featureValues.size(); i++) {
			FeatureValue featureValue = featureValues.get(i);
			newValue.featureValues.add(featureValue.copy());
		}
		return newValue;
	}

	public FeatureValue getFeatureValue(StructuralFeature feature) {
		// Get the value(s) of the member of featureValues for the given
		// feature.
		FeatureValue featureValue = null;
		int i = 1;
		while(featureValue == null & i <= this.featureValues.size()) {
			if(this.featureValues.get(i - 1).feature == feature) {
				featureValue = this.featureValues.get(i - 1);
			}
			i = i + 1;
		}
		return featureValue;
	}

	public void setFeatureValue(StructuralFeature feature, List<Value> values, Integer position) {
		// Set the value(s) of the member of featureValues for the given
		// feature.
		FeatureValue featureValue = this.getFeatureValue(feature);
		if(featureValue == null) {
			featureValue = new FeatureValue();
			this.featureValues.add(featureValue);
		}
		featureValue.feature = feature;
		featureValue.values = values;
		featureValue.position = position;
	}

	public List<FeatureValue> getFeatureValues() {
		// Return the feature values for this compound value.
		return this.featureValues;
	}

	public void removeFeatureValues(Classifier classifier) {
		// Remove all feature values for features whose type is the given
		// classifier.
		int i = 1;
		while(i <= this.featureValues.size()) {
			if(this.featureValues.get(i - 1).feature.getType() == classifier) {
				this.featureValues.remove(i - 1);
			} else {
				i = i + 1;
			}
		}
	}

	public String toString() {
		String buffer = "(" + this.objectId() + ":";
		List<Classifier> types = this.getTypes();
		int i = 1;
		while(i <= types.size()) {
			buffer = buffer + " " + types.get(i - 1).getName();
			i = i + 1;
		}
		int k = 1;
		while(k <= this.featureValues.size()) {
			FeatureValue featureValue = this.featureValues.get(k - 1);
			buffer = buffer + "\n\t\t" + featureValue.feature.getName() + "[" + featureValue.position + "]  =";
			int j = 1;
			while(j <= featureValue.values.size()) {
				Value value = featureValue.values.get(j - 1);
				if (value instanceof Reference) {
					Object_ object = ((Reference)value).referent;
					buffer = buffer + " Reference to (" + object.objectId() + ":";
					types = object.getTypes();
					int n = 1;
					while (n <= types.size()) {
						buffer = buffer + " " + types.get(n - 1).getName();
						n = n + 1;
					}
					buffer = buffer + ")";
				} else {
					buffer = buffer + " " + value.toString();
				}
				j = j + 1;
			}
			k = k + 1;
		}
		return buffer + ")";
	}
}
