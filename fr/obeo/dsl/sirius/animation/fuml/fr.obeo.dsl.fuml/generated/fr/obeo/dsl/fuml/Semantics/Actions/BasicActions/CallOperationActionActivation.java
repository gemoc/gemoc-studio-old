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
package fr.obeo.dsl.fuml.Semantics.Actions.BasicActions;

import org.eclipse.uml2.uml.CallOperationAction;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;

public class CallOperationActionActivation extends CallActionActivation {

	public Execution getCallExecution() {
		// If the value on the target input pin is a reference, dispatch the
		// operation to it and return the resulting execution object.
		CallOperationAction action = (CallOperationAction)(this.node);
		Value target = this.takeTokens(action.getTarget()).get(0);
		Execution execution;
		if(target instanceof Reference) {
			execution = ((Reference)target).dispatch(action.getOperation());
		} else {
			execution = null;
		}
		return execution;
	}
}
