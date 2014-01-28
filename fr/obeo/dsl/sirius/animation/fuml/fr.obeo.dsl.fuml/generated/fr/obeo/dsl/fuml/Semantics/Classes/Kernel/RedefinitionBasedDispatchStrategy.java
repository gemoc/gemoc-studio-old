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

import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;

public class RedefinitionBasedDispatchStrategy extends DispatchStrategy {

	public Behavior getMethod(Object_ object, Operation operation) {
		// Get the method that corresponds to the given operation for the given
		// object.
		// [If there is more than one type with a method for the operation, then
		// the first one is arbitrarily chosen.]
		Behavior method = null;
		int i = 1;
		while(method == null & i <= object.types.size()) {
			Class type = object.types.get(i - 1);
			List<NamedElement> members = type.getMembers();
			int j = 1;
			while(method == null & j <= members.size()) {
				NamedElement member = members.get(j - 1);
				if(member instanceof Operation) {
					Operation memberOperation = (Operation)member;
					if(this.operationsMatch(memberOperation, operation)) {
						method = memberOperation.getMethods().get(0);
					}
				}
				j = j + 1;
			}
			i = i + 1;
		}
		return method;
	}

	public Boolean operationsMatch(Operation ownedOperation, Operation baseOperation) {
		// Check if the owned operation is equal to or a redefinition (directly
		// or indirectly) of the base operation.
		boolean matches = false;
		if(ownedOperation == baseOperation) {
			matches = true;
		} else {
			int i = 1;
			while(!matches & i <= ownedOperation.getRedefinedOperations().size()) {
				matches = this.operationsMatch(ownedOperation.getRedefinedOperations().get(i - 1), baseOperation);
				i = i + 1;
			}
		}
		return matches;
	}
}
