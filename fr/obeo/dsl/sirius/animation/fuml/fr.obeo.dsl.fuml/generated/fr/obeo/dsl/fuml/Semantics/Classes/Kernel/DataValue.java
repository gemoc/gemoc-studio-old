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
import org.eclipse.uml2.uml.DataType;

public class DataValue extends CompoundValue {

	/*
	 * The type of this data value. This must not be a primitive or an
	 * enumeration.
	 */
	public DataType type;

	public List<Classifier> getTypes() {
		// Return the single type of this data value.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	public Value copy() {
		// Create a new data value with the same type and feature values as this
		// data value.
		DataValue newValue = (DataValue)(super.copy());
		newValue.type = this.type;
		return newValue;
	}

	public Value new_() {
		// Create a new data value with no type or feature values.
		return new DataValue();
	}
}
