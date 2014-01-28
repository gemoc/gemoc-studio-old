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

import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

public class RealValue extends PrimitiveValue {

	/*
	 * The actual Real value.
	 */
	public double value;

	public ValueSpecification specify() {
		// Return a literal real with the value of this real value.
		LiteralReal literal = UMLFactory.eINSTANCE.createLiteralReal();
		literal.setType(this.type);
		literal.setValue(this.value);
		return literal;
	}

	public Boolean equals(Value otherValue) {
		// Test if this real value is equal to the otherValue.
		// To be equal, the otherValue must have the same value as this real
		// value.
		boolean isEqual = false;
		if(otherValue instanceof RealValue) {
			isEqual = ((RealValue)otherValue).value == this.value;
		}
		return isEqual;
	}

	public Value copy() {
		// Create a new real value with the same value as this real value.
		RealValue newValue = (RealValue)(super.copy());
		newValue.value = this.value;
		return newValue;
	}

	public Value new_() {
		return new RealValue();
	}

	public String toString() {
		String stringValue = "";
		if(this.value == 0) {
			stringValue = "0";
		} else {
			double positiveValue = this.value;
			if(positiveValue < 0) {
				positiveValue = -positiveValue;
			}
			int exponent = 0;
			if(positiveValue < .1) {
				while(positiveValue < .1) {
					positiveValue = positiveValue * 10;
					exponent = exponent - 1;
				}
			} else if(positiveValue > 1) {
				while(positiveValue > 1) {
					positiveValue = positiveValue / 10;
					exponent = exponent + 1;
				}
			}
			// This gives 9 significant digits in the mantissa.
			for(int i = 0; i < 9; i++) {
				positiveValue = positiveValue * 10;
			}
			IntegerValue integerValue = new IntegerValue();
			integerValue.value = (int)positiveValue;
			stringValue = "0." + integerValue.toString();
			integerValue.value = exponent;
			stringValue = stringValue + "E" + integerValue.toString();
			if(this.value < 0) {
				stringValue = "-" + stringValue;
			}
		}
		return stringValue;
	}
}
