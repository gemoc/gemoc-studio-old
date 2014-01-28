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
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public abstract class StructuralFeatureActionActivation extends ActionActivation {

	public Association getAssociation(StructuralFeature feature) {
		// If the structural feature for the action of this activation is an
		// association end,
		// then get the associated association.
		Association association = null;
		if(feature instanceof Property) {
			association = ((Property)feature).getAssociation();
		}
		return association;
	}

	public List<Link> getMatchingLinks(Association association, StructuralFeature end, Value oppositeValue) {
		// Get the links of the given binary association whose end opposite
		// to the given end has the given value
		Property oppositeEnd = this.getOppositeEnd(association, end);
		List<ExtensionalValue> extent = this.getExecutionLocus().getExtent(association);
		List<Link> links = new ArrayList<Link>();
		for(int i = 0; i < extent.size(); i++) {
			ExtensionalValue link = extent.get(i);
			if(link.getFeatureValue(oppositeEnd).values.get(0).equals(oppositeValue)) {
				if(!end.isOrdered() | links.size() == 0) {
					links.add((Link)link);
				} else {
					int n = link.getFeatureValue(end).position;
					boolean continueSearching = true;
					int j = 0;
					while(continueSearching & j < links.size()) {
						j = j + 1;
						continueSearching = links.get(j - 1).getFeatureValue(end).position < n;
					}
					if(continueSearching) {
						links.add((Link)link);
					} else {
						links.add(j - 1, (Link)link);
					}
				}
			}
		}
		return links;
	}

	public Property getOppositeEnd(Association association, StructuralFeature end) {
		// Get the end of a binary association opposite to the given end.
		Property oppositeEnd = association.getMemberEnds().get(0);
		if(oppositeEnd == end) {
			oppositeEnd = association.getMemberEnds().get(1);
		}
		return oppositeEnd;
	}
}
