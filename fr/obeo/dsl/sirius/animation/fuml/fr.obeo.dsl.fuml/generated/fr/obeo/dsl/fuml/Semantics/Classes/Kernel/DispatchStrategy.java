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

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticStrategy;

public abstract class DispatchStrategy extends SemanticStrategy {

	public String getName() {
		// Dispatch strategies are always named "dispatch".
		return "dispatch";
	}

	public Execution dispatch(Object_ object, Operation operation) {
		// Get the behavior for the given operation as determined by the type(s)
		// of the given object, compile the behavior at the locus of the object,
		// and return the resulting execution object.
		return object.locus.factory.createExecution(this.getMethod(object, operation), object);
	}

	public abstract Behavior getMethod(Object_ object, Operation operation);
}
