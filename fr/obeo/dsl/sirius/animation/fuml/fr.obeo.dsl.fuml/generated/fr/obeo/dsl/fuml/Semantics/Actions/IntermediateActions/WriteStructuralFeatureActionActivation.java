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

import java.util.List;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public abstract class WriteStructuralFeatureActionActivation extends StructuralFeatureActionActivation {

	public Integer position(Value value, List<Value> list, Integer startAt) {
		// Return the position (counting from 1) of the first occurance of the
		// given value in the given list at or after the starting index, or 0 if
		// it is not found.
		boolean found = false;
		int i = startAt;
		while(!found & i <= list.size()) {
			found = list.get(i - 1).equals(value);
			i = i + 1;
		}
		if(!found) {
			i = 1;
		}
		return i - 1;
	}
}
