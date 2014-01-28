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
package fr.obeo.dsl.fuml.Semantics.Actions.IntermediateActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StructuredValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.ChoiceStrategy;

public class AddStructuralFeatureValueActionActivation extends WriteStructuralFeatureActionActivation {

	public void doAction() {
		// Get the values of the object and value input pins.
		// If the given feature is an association end, then create a link
		// between the object and value inputs.
		// Otherwise, if the object input is a structural value, then add a
		// value to the values for the feature.
		// If isReplaceAll is true, first remove all current matching links or
		// feature values.
		// If isReplaceAll is false and there is an insertAt pin, insert the
		// value at the appropriate position.
		AddStructuralFeatureValueAction action = (AddStructuralFeatureValueAction)(this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		Value value = this.takeTokens(action.getObject()).get(0);
		List<Value> inputValues = this.takeTokens(action.getValue());
		// NOTE: Multiplicity of the value input pin is required to be 1..1.
		Value inputValue = inputValues.get(0);
		int insertAt = 0;
		if(action.getInsertAt() != null) {
			insertAt = ((UnlimitedNaturalValue)this.takeTokens(action.getInsertAt()).get(0)).value;
		}
		if(association != null) {
			List<Link> links = this.getMatchingLinks(association, feature, value);
			Property oppositeEnd = this.getOppositeEnd(association, feature);
			int position = 0;
			if(oppositeEnd.isOrdered()) {
				position = this.getMatchingLinks(association, oppositeEnd, inputValue).size() + 1;
			}
			if(action.isReplaceAll()) {
				for(int i = 0; i < links.size(); i++) {
					Link link = links.get(i);
					link.destroy();
				}
			} else if(feature.isUnique()) {
				int i = 1;
				boolean destroyed = false;
				while(!destroyed & i <= links.size()) {
					Link link = links.get(i - 1);
					FeatureValue featureValue = link.getFeatureValue(feature);
					if(featureValue.values.get(0).equals(inputValue)) {
						position = link.getFeatureValue(oppositeEnd).position;
						link.destroy();
						destroyed = true;
					}
					i = i + 1;
				}
			}
			Link newLink = new Link();
			newLink.type = association;
			newLink.setFeatureValue(feature, inputValues, insertAt);
			List<Value> oppositeValues = new ArrayList<Value>();
			oppositeValues.add(value);
			newLink.setFeatureValue(oppositeEnd, oppositeValues, position);
			newLink.addTo(this.getExecutionLocus());
		} else if(value instanceof StructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if(!(value instanceof Reference)) {
				value = value.copy();
			}
			StructuredValue structuredValue = (StructuredValue)value;
			if(action.isReplaceAll()) {
				structuredValue.setFeatureValue(feature, inputValues, 0);
			} else {
				FeatureValue featureValue = structuredValue.getFeatureValue(feature);
				if(featureValue.values.size() > 0 & insertAt == 0) {
					// *** If there is no insertAt pin, then the structural
					// feature must be unordered, and the insertion position is
					// immaterial. ***
					insertAt = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(featureValue.values.size());
				}
				if(feature.isUnique()) {
					// Remove any existing value that duplicates the input value
					int j = position(inputValue, featureValue.values, 1);
					if(j > 0) {
						featureValue.values.remove(j - 1);
					}
				}
				if(insertAt <= 0) { // Note: insertAt = -1 indicates an
									// unlimited value of "*"
					featureValue.values.add(inputValue);
				} else {
					featureValue.values.add(insertAt - 1, inputValue);
				}
			}
		}
		if(action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
