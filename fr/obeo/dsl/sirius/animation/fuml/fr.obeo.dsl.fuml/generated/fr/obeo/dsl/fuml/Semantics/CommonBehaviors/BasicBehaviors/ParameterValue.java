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
package fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Parameter;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ParameterValue {

	public Parameter parameter;

	/*
	 * The values of for the parameter. Zero or more values are possible, as
	 * constrained by the multiplicity of the parameter.
	 */
	public List<Value> values = new ArrayList<Value>();

	public ParameterValue copy() {
		// Create a new parameter value for the same parameter as this parameter
		// value, but with copies of the values of this parameter value.
		ParameterValue newValue = new ParameterValue();
		newValue.parameter = this.parameter;
		List<Value> values = this.values;
		for(int i = 0; i < values.size(); i++) {
			Value value = values.get(i);
			newValue.values.add(value.copy());
		}
		return newValue;
	}
}
