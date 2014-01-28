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

import java.util.List;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.Property;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.debug.Debug;

public class DestroyObjectActionActivation extends ActionActivation {

	public void doAction() {
		// Get the value on the target input pin.
		// If the value is not a reference, then the action has no effect.
		// Otherwise, do the following.
		// If isDestroyLinks is true, destroy all links in which the referent
		// participates.
		// If isDestroyOwnedObjects is true, destroy all objects owned by the
		// referent via composition links.
		// Destroy the referent object.
		DestroyObjectAction action = (DestroyObjectAction)(this.node);
		Value value = this.takeTokens(action.getTarget()).get(0);
		this.destroyObject(value, action.isDestroyLinks(), action.isDestroyOwnedObjects());
	}

	public void destroyObject(Value value, Boolean isDestroyLinks, Boolean isDestroyOwnedObjects) {
		// If the given value is a reference, then destroy the referenced
		// object, per the given destroy action attribute values.
		// Debug.println("[destroyObject] object = " + value.objectId());
		if(value instanceof Reference) {
			Reference reference = (Reference)value;
			if(isDestroyLinks | isDestroyOwnedObjects) {
				Debug.println("[destroyObject] Destroying links...");
				List<ExtensionalValue> extensionalValues = this.getExecutionLocus().extensionalValues;
				for(int i = 0; i < extensionalValues.size(); i++) {
					ExtensionalValue extensionalValue = extensionalValues.get(i);
					if(extensionalValue instanceof Link) {
						Link link = (Link)extensionalValue;
						if(this.valueParticipatesInLink(reference, link)) {
							if(isDestroyLinks | this.objectIsComposite(reference, link)) {
								// Debug.println("[destroyObject] Destroying link "
								// + link.objectId());
								link.destroy();
							}
						}
					}
				}
			}
			if(isDestroyOwnedObjects) {
				Debug.println("[destroyObject] Destroying owned objects...");
				List<FeatureValue> objectFeatureValues = reference.getFeatureValues();
				for(int i = 0; i < objectFeatureValues.size(); i++) {
					FeatureValue featureValue = objectFeatureValues.get(i);
					if(((Property)featureValue.feature).getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
						List<Value> values = featureValue.values;
						for(int j = 0; j < values.size(); j++) {
							Value ownedValue = values.get(j);
							this.destroyObject(ownedValue, isDestroyLinks, isDestroyOwnedObjects);
						}
					}
				}
			}
			reference.destroy();
		}
	}

	public Boolean objectIsComposite(Reference reference, Link link) {
		// Test whether the given reference participates in the given link as a
		// composite.
		List<FeatureValue> linkFeatureValues = link.getFeatureValues();
		boolean isComposite = false;
		int i = 1;
		while(!isComposite & i <= linkFeatureValues.size()) {
			FeatureValue featureValue = linkFeatureValues.get(i - 1);
			if(!featureValue.values.get(0).equals(reference) & ((Property)featureValue.feature).getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
				isComposite = true;
			}
			i = i + 1;
		}
		return isComposite;
	}
}
