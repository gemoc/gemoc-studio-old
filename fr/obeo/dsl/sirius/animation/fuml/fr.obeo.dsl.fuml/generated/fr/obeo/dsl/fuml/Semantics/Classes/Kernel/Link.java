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

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;
import fr.obeo.dsl.fuml.debug.Debug;

public class Link extends ExtensionalValue {

	/*
	 * The type of this link.
	 */
	public Association type;

	public void destroy() {
		// Remove the type of this link and destroy it.
		// Shift the positions of the feature values of any remaining links in
		// the extent of the same association, for ends that are ordered.
		Debug.println("[destroy] link = " + this.objectId());
		List<Property> ends = this.type.getMemberEnds();
		List<ExtensionalValue> extent = this.locus.getExtent(this.type);
		for(int i = 0; i < extent.size(); i++) {
			ExtensionalValue otherLink = extent.get(i);
			for(int j = 0; j < ends.size(); j++) {
				Property end = ends.get(j);
				if(end.isOrdered()) {
					FeatureValue featureValue = otherLink.getFeatureValue(end);
					if(this.getFeatureValue(end).position < featureValue.position) {
						featureValue.position = featureValue.position - 1;
					}
				}
			}
		}
		this.type = null;
		super.destroy();
	}

	public Value copy() {
		// Create a new link with the same type, locus and feature values as
		// this link.
		Link newValue = (Link)(super.copy());
		newValue.type = this.type;
		return newValue;
	}

	public Value new_() {
		// Create a new link with no type or properies.
		return new Link();
	}

	public List<Classifier> getTypes() {
		// Return the single type of this link (if any).
		List<Classifier> types = null;
		if(this.type == null) {
			types = new ArrayList<Classifier>();
		} else {
			types = new ArrayList<Classifier>();
			types.add(this.type);
		}
		return types;
	}

	public Boolean isMatchingLink(ExtensionalValue link, Property end) {
		// Test whether the given link matches the values of this link on all
		// ends other than the given end.
		List<Property> ends = this.type.getMemberEnds();
		boolean matches = true;
		int i = 1;
		while(matches & i <= ends.size()) {
			Property otherEnd = ends.get(i - 1);
			if(otherEnd != end & !this.getFeatureValue(otherEnd).values.get(0).equals(link.getFeatureValue(otherEnd).values.get(0))) {
				matches = false;
			}
			i = i + 1;
		}
		return matches;
	}

	public List<FeatureValue> getOtherFeatureValues(List<ExtensionalValue> extent, Property end) {
		// Return all feature values for the given end of links in the given
		// extent whose other ends match this link.
		List<FeatureValue> featureValues = new ArrayList<FeatureValue>();
		for(int i = 0; i < extent.size(); i++) {
			ExtensionalValue link = extent.get(i);
			if(link != this) {
				if(isMatchingLink(link, end)) {
					featureValues.add(link.getFeatureValue(end));
				}
			}
		}
		return featureValues;
	}

	public void addTo(Locus locus) {
		// Add this link to the extent of its association at the given locus.
		// Shift the positions of ends of other links, as appropriate, for ends
		// that are ordered.
		Debug.println("[addTo] link = " + this.objectId());
		List<Property> ends = this.type.getMemberEnds();
		List<ExtensionalValue> extent = locus.getExtent(this.type);
		for(int i = 0; i < ends.size(); i++) {
			Property end = ends.get(i);
			if(end.isOrdered()) {
				FeatureValue featureValue = this.getFeatureValue(end);
				List<FeatureValue> otherFeatureValues = this.getOtherFeatureValues(extent, end);
				int n = otherFeatureValues.size();
				if(featureValue.position < 0 | featureValue.position > n) {
					featureValue.position = n + 1;
				} else {
					if(featureValue.position == 0) {
						featureValue.position = 1;
					}
					for(int j = 0; j < otherFeatureValues.size(); j++) {
						FeatureValue otherFeatureValue = otherFeatureValues.get(j);
						if(featureValue.position <= otherFeatureValue.position) {
							otherFeatureValue.position = otherFeatureValue.position + 1;
						}
					}
				}
			}
		}
		locus.add(this);
	}
}
