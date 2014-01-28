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
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.StructuredValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ReadStructuralFeatureActionActivation extends StructuralFeatureActionActivation {

	public void doAction() {
		// Get the value of the object input pin.
		// If the given feature is an association end, then get all values of
		// the that end.
		// for which the opposite end has the object input value and place them
		// on the result pin.
		// Otherwise, if the object input value is a structural value, then get
		// the values
		// of the appropriate feature of the input value and place them on the
		// result output pin.
		ReadStructuralFeatureAction action = (ReadStructuralFeatureAction)(this.node);
		StructuralFeature feature = action.getStructuralFeature();
		Association association = this.getAssociation(feature);
		Value value = this.takeTokens(action.getObject()).get(0);
		List<Value> resultValues = new ArrayList<Value>();
		if(association != null) {
			List<Link> links = this.getMatchingLinks(association, feature, value);
			for(int i = 0; i < links.size(); i++) {
				Link link = links.get(i);
				resultValues.add(link.getFeatureValue(feature).values.get(0));
			}
		} else if(value instanceof StructuredValue) {
			// Debug.println("[ReadStructuralFeatureActionActivation] value = "
			// + value +", structural feature = " + feature.name);
			resultValues = ((StructuredValue)value).getFeatureValue(feature).values;
		}
		this.putTokens(action.getResult(), resultValues);
	}
}
