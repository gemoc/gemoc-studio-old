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

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class EnumerationValue extends Value {

	/*
	 * The literal value of this enumeration value.
	 */
	public EnumerationLiteral literal;

	public Enumeration type;

	public ValueSpecification specify() {
		// Return an instance value with literal as the instance.
		InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
		// InstanceSpecification instance =
		// UMLFactory.eINSTANCE.createInstanceSpecification();
		instanceValue.setType(this.type);
		instanceValue.setInstance(this.literal);
		return instanceValue;
	}

	public Boolean equals(Value otherValue) {
		// Test if this enumeration value is equal to the otherValue.
		// To be equal, the otherValue must also be an enumeration value with
		// the same literal as this enumeration value.
		boolean isEqual = false;
		if(otherValue instanceof EnumerationValue) {
			isEqual = ((EnumerationValue)otherValue).literal == this.literal;
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new enumeration value with the same literal as this
		// enumeration value.
		EnumerationValue newValue = (EnumerationValue)(super.copy());
		newValue.type = this.type;
		newValue.literal = this.literal;
		return newValue;
	}

	public Value new_() {
		// Create a new enumeration value with no literal.
		return new EnumerationValue();
	}

	public List<Classifier> getTypes() {
		// Return the single type of this enumeration value.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	public String toString() {
		return literal.getName();
	}
}
