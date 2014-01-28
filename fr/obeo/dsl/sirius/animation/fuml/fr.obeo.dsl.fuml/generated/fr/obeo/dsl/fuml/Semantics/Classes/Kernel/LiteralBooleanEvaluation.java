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

import org.eclipse.uml2.uml.LiteralBoolean;

public class LiteralBooleanEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a literal boolean, producing a boolean value.
		LiteralBoolean literal = (LiteralBoolean)specification;
		BooleanValue booleanValue = new BooleanValue();
		booleanValue.type = this.getType("Boolean");
		booleanValue.value = literal.booleanValue();
		return booleanValue;
	}
}
