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

import org.eclipse.uml2.uml.LiteralInteger;

public class LiteralIntegerEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a literal integer, producing an integer value.
		LiteralInteger literal = (LiteralInteger)specification;
		IntegerValue integerValue = new IntegerValue();
		integerValue.type = this.getType("Integer");
		integerValue.value = literal.integerValue();
		return integerValue;
	}
}
