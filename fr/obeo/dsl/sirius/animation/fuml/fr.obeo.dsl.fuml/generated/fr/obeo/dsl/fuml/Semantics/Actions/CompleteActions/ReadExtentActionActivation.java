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

import org.eclipse.uml2.uml.ReadExtentAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ReadExtentActionActivation extends ActionActivation {

	public void doAction() {
		// Get the extent, at the current execution locus, of the classifier
		// (which must be a class) identified in the action.
		// Place references to the resulting set of objects on the result pin.
		ReadExtentAction action = (ReadExtentAction)(this.node);
		List<ExtensionalValue> objects = this.getExecutionLocus().getExtent(action.getClassifier());
		// Debug.println("[doAction] " + action.classifier.name + " has " +
		// objects.size() + " instance(s).");
		List<Value> references = new ArrayList<Value>();
		for(int i = 0; i < objects.size(); i++) {
			Value object = objects.get(i);
			Reference reference = new Reference();
			reference.referent = (Object_)object;
			references.add(reference);
		}
		this.putTokens(action.getResult(), references);
	}
}
