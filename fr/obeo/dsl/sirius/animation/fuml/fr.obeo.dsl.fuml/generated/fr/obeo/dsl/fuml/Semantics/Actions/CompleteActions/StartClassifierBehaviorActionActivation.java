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

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;

public class StartClassifierBehaviorActionActivation extends ActionActivation {

	public void doAction() {
		// Get the value on the object input pin. If it is not a reference, then
		// do nothing.
		// Start the classifier behavior of the referent object for the
		// classifier given as the type of the object input pin.
		// If the object input pin has no type, then start the classifier
		// behaviors of all types of the referent object. [The required behavior
		// in this case is not clear from the spec.]
		StartClassifierBehaviorAction action = (StartClassifierBehaviorAction)(this.node);
		Value object = this.takeTokens(action.getObject()).get(0);
		if(object instanceof Reference) {
			((Reference)object).startBehavior((Class)(action.getObject().getType()), new ArrayList<ParameterValue>());
		}
	}
}
