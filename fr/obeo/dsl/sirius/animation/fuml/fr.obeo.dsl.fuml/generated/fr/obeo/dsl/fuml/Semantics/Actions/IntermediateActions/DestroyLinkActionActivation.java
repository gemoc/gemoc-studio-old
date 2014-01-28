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

import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Property;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import fr.obeo.dsl.fuml.debug.Debug;

public class DestroyLinkActionActivation extends WriteLinkActionActivation {

	public void doAction() {
		// Get the extent, at the current execution locus, of the association
		// for which links are being destroyed.
		// Destroy all links that match the given link end destruction data.
		// For unique ends, or non-unique ends for which isDestroyDuplicates is
		// true, match links with a matching value for that end.
		// For non-unique, ordered ends for which isDestroyDuplicates is false,
		// match links with an end value at the given destroyAt position. [Must
		// a value be given, too, in this case?]
		// For non-unique, non-ordered ends for which isDestroyDuplicates is
		// false, pick one matching link (if any) non-deterministically. [The
		// semantics of this case is not clear from the current spec.]
		Debug.println("[doAction] DestroyLinkAction...");
		DestroyLinkAction action = (DestroyLinkAction)(this.node);
		List<LinkEndDestructionData> destructionDataList = new ArrayList<LinkEndDestructionData>();
		for(LinkEndData data : action.getEndData()) {
			destructionDataList.add((LinkEndDestructionData)data);
		}
		Debug.println("[doAction] end data size = " + destructionDataList.size());
		boolean destroyOnlyOne = false;
		int j = 1;
		while(!destroyOnlyOne & j <= destructionDataList.size()) {
			LinkEndDestructionData endData = destructionDataList.get(j - 1);
			destroyOnlyOne = !endData.getEnd().isUnique() & !endData.getEnd().isOrdered() & !endData.isDestroyDuplicates();
			j = j + 1;
		}
		List<LinkEndData> endDataList = new ArrayList<LinkEndData>();
		for(int i = 0; i < destructionDataList.size(); i++) {
			LinkEndDestructionData endData = destructionDataList.get(i);
			Debug.println("[doAction] Matching end = " + endData.getEnd().getName());
			endDataList.add(endData);
		}
		List<ExtensionalValue> extent = this.getExecutionLocus().getExtent(this.getAssociation());
		List<ExtensionalValue> matchingLinks = new ArrayList<ExtensionalValue>();
		for(int i = 0; i < extent.size(); i++) {
			ExtensionalValue value = extent.get(i);
			Link link = (Link)value;
			if(this.linkMatchesEndData(link, endDataList)) {
				matchingLinks.add(link);
			}
		}
		// Now that matching is done, ensure that all tokens on end data input
		// pins
		// are consumed.
		for(int i = 0; i < destructionDataList.size(); i++) {
			LinkEndDestructionData endData = destructionDataList.get(i);
			Property end = endData.getEnd();
			if(!endData.isDestroyDuplicates() & !end.isUnique() & end.isOrdered()) {
				this.takeTokens(endData.getDestroyAt());
			}
			Debug.println("[doAction] Consuming tokens for end " + end.getName());
			this.takeTokens(endData.getValue());
		}
		if(destroyOnlyOne) {
			// *** If there is more than one matching link,
			// non-deterministically choose one. ***
			if(matchingLinks.size() > 0) {
				int i = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(matchingLinks.size());
				matchingLinks.get(i - 1).destroy();
			}
		} else {
			for(int i = 0; i < matchingLinks.size(); i++) {
				ExtensionalValue matchingLink = matchingLinks.get(i);
				matchingLink.destroy();
			}
		}
	}
}
