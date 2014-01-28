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

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CreateObjectAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;

public class CreateObjectActionActivation extends ActionActivation {

	public void doAction() {
		// Create an object with the given classifier (which must be a class) as
		// its type, at the same locus as the action activation.
		// Place a reference to the object on the result pin of the action.
		CreateObjectAction action = (CreateObjectAction)(this.node);
		Reference reference = new Reference();
		reference.referent = this.getExecutionLocus().instantiate((Class)(action.getClassifier()));
		this.putToken(action.getResult(), reference);
	}
}
