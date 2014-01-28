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

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class UnlimitedNaturalValue extends PrimitiveValue {

	/*
	 * The actual unlimited natural value.
	 */
	public Integer value;

	public ValueSpecification specify() {
		// Return a literal unlimited natural with the value of this unlimited
		// natural value.
		LiteralUnlimitedNatural literal = UMLFactory.eINSTANCE.createLiteralUnlimitedNatural();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	public Boolean equals(Value otherValue) {
		// Test if this unlimited natural value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this
		// unlimited natural value.
		boolean isEqual = false;
		if(otherValue instanceof UnlimitedNaturalValue) {
			isEqual = ((UnlimitedNaturalValue)otherValue).value.equals(this.value); // CHANGED == to equals
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new unlimited natural value with the same value as this
		// value.
		UnlimitedNaturalValue newValue = (UnlimitedNaturalValue)(super.copy());
		newValue.value = this.value;
		return newValue;
	}

	public Value new_() {
		// Create a new unlimited natural value with no value.
		return new UnlimitedNaturalValue();
	}

	public String toString() {
		String stringValue = "*";
		if(this.value >= 0) {
			IntegerValue integerValue = new IntegerValue();
			integerValue.value = this.value;
			stringValue = integerValue.toString();
		}
		return stringValue;
	}
}
