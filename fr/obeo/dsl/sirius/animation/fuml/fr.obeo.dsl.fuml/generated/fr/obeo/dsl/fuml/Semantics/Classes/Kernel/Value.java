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

import java.util.List;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ValueSpecification;

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticVisitor;

public abstract class Value extends SemanticVisitor {

	public abstract ValueSpecification specify();

	public Boolean equals(Value otherValue) {
		// Test if this value is equal to otherValue. To be equal, this value
		// must have the same type as otherValue.
		// This operation must be overridden in Value subclasses to check for
		// equality of properties defined in those subclasses.
		List<Classifier> myTypes = this.getTypes();
		List<Classifier> otherTypes = otherValue.getTypes();
		boolean isEqual = true;
		// Debug.println("[equals] Value...");
		// Debug.println("[equals] this has " + myTypes.size() +
		// "types, other has " + otherTypes.size() + ".");
		if(myTypes.size() != otherTypes.size()) {
			isEqual = false;
		} else {
			// Debug.println("[equals] " + myTypes.size() + " type(s).");
			int i = 1;
			while(isEqual & i <= myTypes.size()) {
				// Debug.println("[equals] this type = " +
				// myTypes.get(i-1).name);
				boolean matched = false;
				int j = 1;
				while(!matched & j <= otherTypes.size()) {
					// Debug.println("[equals] other type = " +
					// otherTypes.get(j-1).name);
					matched = (otherTypes.get(j - 1) == myTypes.get(i - 1));
					j = j + 1;
				}
				isEqual = matched;
				i = i + 1;
			}
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new value that is equal to this value.
		// By default, this operation simply creates a new value with empty
		// properties.
		// It must be overridden in each Value subclass to do the superclass
		// copy and then appropriately set properties defined in the subclass.
		return this.new_();
	}

	public abstract Value new_();

	public abstract List<Classifier> getTypes();

	public Boolean hasType(Classifier type) {
		// Check if this object has the given classifier as a type.
		List<Classifier> types = this.getTypes();
		boolean found = false;
		int i = 1;
		while(!found & i <= types.size()) {
			found = (types.get(i - 1) == type);
			i = i + 1;
		}
		return found;
	}

	public abstract String toString();

	public String objectId() {
		// Return an identifier for this object.
		// [Non-normative.]
		return super.toString();
	}
}
