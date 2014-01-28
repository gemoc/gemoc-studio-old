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
package fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ReadIsClassifiedObjectActionActivation extends ActionActivation {

	public void doAction() {
		// Get the value on the object input pin and determine if it is
		// classified by the classifier specified in the action.
		// If the isDirect attribute of the action is false, then place true on
		// the result output pin if the input object has the specified
		// classifier or of one its (direct or indirect) descendants as a type.
		// If the isDirect attribute of the action is true, then place true on
		// the result output pin if the input object has the specified
		// classifier as a type.
		// Otherwise place false on the result output pin.
		ReadIsClassifiedObjectAction action = (ReadIsClassifiedObjectAction)(this.node);
		Value input = this.takeTokens(action.getObject()).get(0);
		List<Classifier> types = input.getTypes();
		boolean result = false;
		int i = 1;
		while(!result & i <= types.size()) {
			Classifier type = types.get(i - 1);
			if(type == action.getClassifier()) {
				result = true;
			} else if(!action.isDirect()) {
				result = this.checkAllParents(type, action.getClassifier());
			}
			i = i + 1;
		}
		List<Value> values = new ArrayList<Value>();
		values.add(this.makeBooleanValue(result));
		this.putTokens(action.getResult(), values);
	}

	public Boolean checkAllParents(Classifier type, Classifier classifier) {
		// Check if the given classifier matches any of the direct or indirect
		// ancestors of a given type.
		List<Classifier> directParents = type.getGenerals();
		boolean matched = false;
		int i = 1;
		while(!matched & i <= directParents.size()) {
			Classifier directParent = directParents.get(i - 1);
			if(directParent == classifier) {
				matched = true;
			} else {
				matched = this.checkAllParents(directParent, classifier);
			}
			i = i + 1;
		}
		return matched;
	}
}
