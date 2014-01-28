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

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Property;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public abstract class LinkActionActivation extends ActionActivation {

	public Boolean linkMatchesEndData(Link link, List<LinkEndData> endDataList) {
		// Test whether the given link matches the given end data.
		boolean matches = true;
		int i = 1;
		while(matches & i <= endDataList.size()) {
			matches = this.endMatchesEndData(link, endDataList.get(i - 1));
			i = i + 1;
		}
		return matches;
	}

	public Boolean endMatchesEndData(Link link, LinkEndData endData) {
		// Test whether the appropriate end of the given link matches the given
		// end data.
		boolean matches = false;
		if(endData.getValue() == null) {
			matches = true;
		} else {
			Property end = endData.getEnd();
			FeatureValue linkFeatureValue = link.getFeatureValue(end);
			Value endValue = this.getTokens(endData.getValue()).get(0);
			if(endData instanceof LinkEndDestructionData) {
				if(!((LinkEndDestructionData)endData).isDestroyDuplicates() & !end.isUnique() & end.isOrdered()) {
					int destroyAt = ((UnlimitedNaturalValue)(this.getTokens(((LinkEndDestructionData)endData).getDestroyAt()).get(0))).value;
					matches = linkFeatureValue.values.get(0).equals(endValue) && linkFeatureValue.position == destroyAt;
				} else {
					matches = linkFeatureValue.values.get(0).equals(endValue);
				}
			} else {
				matches = linkFeatureValue.values.get(0).equals(endValue);
			}
		}
		return matches;
	}

	public Association getAssociation() {
		// Get the association for the link action of this activation.
		return (Association)(((LinkAction)(this.node)).getEndData().get(0).getEnd().getAssociation());
	}
}
