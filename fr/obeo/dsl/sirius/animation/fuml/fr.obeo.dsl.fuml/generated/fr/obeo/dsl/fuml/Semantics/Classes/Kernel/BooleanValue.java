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

import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class BooleanValue extends PrimitiveValue {

	/*
	 * The actual Boolean value.
	 */
	public Boolean value;

	public ValueSpecification specify() {
		// Return a literal boolean with the value of this boolean value.
		LiteralBoolean literal = UMLFactory.eINSTANCE.createLiteralBoolean();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	public Boolean equals(Value otherValue) {
		// Test if this boolean value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this boolean
		// value.
		boolean isEqual = false;
		if(otherValue instanceof BooleanValue) {
			isEqual = ((BooleanValue)otherValue).value.equals(this.value); // CHANGED == to equals;
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new boolean value with the same value as this boolean value.
		BooleanValue newValue = (BooleanValue)(super.copy());
		newValue.value = this.value;
		return newValue;
	}

	public Value new_() {
		// Return a new boolean value with no value.
		return new BooleanValue();
	}

	public String toString() {
		String stringValue = "false";
		if(this.value) {
			stringValue = "true";
		}
		return stringValue;
	}
}
