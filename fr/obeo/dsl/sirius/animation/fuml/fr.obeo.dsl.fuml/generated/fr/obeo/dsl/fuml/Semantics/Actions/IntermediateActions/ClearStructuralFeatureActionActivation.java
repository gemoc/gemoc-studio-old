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
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StructuredValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ClearStructuralFeatureActionActivation extends StructuralFeatureActionActivation {

	public void doAction() {
		// Get the value of the object input pin.
		// If the given feature is an association end, then
		// destroy all links that have the object input on the opposite end.
		// Otherwise, if the object input is a structured value, then
		// set the appropriate feature of the input value to be empty.
		ClearStructuralFeatureAction action = (ClearStructuralFeatureAction)(this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		Value value = this.takeTokens(action.getObject()).get(0);
		if(association != null) {
			List<Link> links = this.getMatchingLinks(association, feature, value);
			for(int i = 0; i < links.size(); i++) {
				Link link = links.get(i);
				link.destroy();
			}
		} else if(value instanceof StructuredValue) {
			// If the value is a data value, then it must be copied before
			// any change is made.
			if(!(value instanceof Reference)) {
				value = value.copy();
			}
			((StructuredValue)value).setFeatureValue(action.getStructuralFeature(), new ArrayList<Value>(), 0);
		}
		if(action.getResult() != null) {
			this.putToken(action.getResult(), value);
		}
	}
}
