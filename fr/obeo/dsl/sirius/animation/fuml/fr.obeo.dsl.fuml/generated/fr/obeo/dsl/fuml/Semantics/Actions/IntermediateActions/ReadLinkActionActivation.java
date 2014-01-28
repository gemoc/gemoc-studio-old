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

import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.ReadLinkAction;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.FeatureValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;

public class ReadLinkActionActivation extends LinkActionActivation {

	public void doAction() {
		// Get the extent, at the current execution locus, of the association to
		// which the action applies.
		// For all links that match the link end data, place the value of the
		// remaining "open" end on the result pin.
		ReadLinkAction action = (ReadLinkAction)(this.node);
		List<LinkEndData> endDataList = action.getEndData();
		LinkEndData openEnd = null;
		int i = 1;
		while((openEnd == null) & i <= endDataList.size()) {
			if(endDataList.get(i - 1).getValue() == null) {
				openEnd = endDataList.get(i - 1);
			}
			i = i + 1;
		}
		List<ExtensionalValue> extent = this.getExecutionLocus().getExtent(this.getAssociation());
		List<FeatureValue> featureValues = new ArrayList<FeatureValue>();
		for(int j = 0; j < extent.size(); j++) {
			ExtensionalValue value = extent.get(j);
			Link link = (Link)value;
			if(this.linkMatchesEndData(link, endDataList)) {
				FeatureValue featureValue = link.getFeatureValue(openEnd.getEnd());
				if(!openEnd.getEnd().isOrdered() | featureValues.size() == 0) {
					featureValues.add(featureValue);
				} else {
					int n = featureValue.position;
					boolean continueSearching = true;
					int k = 0;
					while(continueSearching & k < featureValues.size()) {
						k = k + 1;
						continueSearching = featureValues.get(k - 1).position < n;
					}
					if(continueSearching) {
						featureValues.add(featureValue);
					} else {
						featureValues.add(k - 1, featureValue);
					}
				}
			}
		}
		for(int j = 0; j < featureValues.size(); j++) {
			FeatureValue featureValue = featureValues.get(j);
			this.putToken(action.getResult(), featureValue.values.get(0));
		}
		// Now that matching is done, ensure that all tokens on end data input
		// pins
		// are consumed.
		for(int k = 0; k < endDataList.size(); k++) {
			LinkEndData endData = endDataList.get(k);
			if(endData.getValue() != null) {
				this.takeTokens(endData.getValue());
			}
		}
	}
}
