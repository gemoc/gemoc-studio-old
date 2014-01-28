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

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StructuredValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.ChoiceStrategy;

public class RemoveStructuralFeatureValueActionActivation extends WriteStructuralFeatureActionActivation {

	public void doAction() {
		// Get the values of the object and value input pins.
		// If the given feature is an association end, then destroy any matching
		// links.
		// Otherwise, if the object input is a structural value, remove values
		// from the given feature.
		// If isRemoveDuplicates is true, then destroy all current matching
		// links or remove all values equal to the input value.
		// If isRemoveDuplicates is false and there is no removeAt input pin,
		// remove any one feature value equal to the input value (if there are
		// any that are equal).
		// If isRemoveDuplicates is false, and there is a removeAt input pin
		// remove the feature value at that position.
		RemoveStructuralFeatureValueAction action = (RemoveStructuralFeatureValueAction)(this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		Value value = this.takeTokens(action.getObject()).get(0);
		Value inputValue = null;
		if(action.getValue() != null) {
			// NOTE: Multiplicity of the value input pin is required to be 1..1.
			inputValue = this.takeTokens(action.getValue()).get(0);
		}
		int removeAt = 0;
		if(action.getRemoveAt() != null) {
			removeAt = ((UnlimitedNaturalValue)this.takeTokens(action.getRemoveAt()).get(0)).value;
		}
		if(association != null) {
			List<Link> links = this.getMatchingLinks(association, feature, value);
			if(action.isRemoveDuplicates()) {
				for(int i = 0; i < links.size(); i++) {
					Link link = links.get(i);
					link.destroy();
				}
			} else if(action.getRemoveAt() == null) {
				// *** If there is more than one matching link,
				// non-deterministically choose one. ***
				if(links.size() > 0) {
					int i = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(links.size());
					links.get(i - 1).destroy();
				}
			} else {
				boolean notFound = true;
				int i = 1;
				while(notFound & i < links.size()) {
					Link link = links.get(i - 1);
					if(link.getFeatureValue(feature).position == removeAt) {
						notFound = false;
						link.destroy();
					}
				}
			}
		} else if(value instanceof StructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if(!(value instanceof Reference)) {
				value = value.copy();
			}
			FeatureValue featureValue = ((StructuredValue)value).getFeatureValue(action.getStructuralFeature());
			if(action.isRemoveDuplicates()) {
				int j = this.position(inputValue, featureValue.values, 1);
				while(j > 0) {
					featureValue.values.remove(j - 1);
					j = this.position(inputValue, featureValue.values, j);
				}
			} else if(action.getRemoveAt() == null) {
				List<Integer> positions = new ArrayList<Integer>();
				int j = this.position(inputValue, featureValue.values, 1);
				while(j > 0) {
					positions.add(j);
					j = this.position(inputValue, featureValue.values, j);
				}
				if(positions.size() > 0) {
					// *** Nondeterministically choose which value to remove.
					// ***
					int k = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(positions.size());
					featureValue.values.remove(positions.get(k - 1) - 1);
				}
			} else {
				if(featureValue.values.size() >= removeAt) {
					featureValue.values.remove(removeAt - 1);
				}
			}
		}
		if(action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
