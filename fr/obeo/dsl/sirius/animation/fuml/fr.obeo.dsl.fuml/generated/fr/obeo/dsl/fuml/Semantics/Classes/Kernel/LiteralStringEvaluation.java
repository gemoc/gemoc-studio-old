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

import org.eclipse.uml2.uml.LiteralString;

public class LiteralStringEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a literal string, producing a string value.
		LiteralString literal = (LiteralString)specification;
		StringValue stringValue = new StringValue();
		stringValue.type = this.getType("String");
		stringValue.value = literal.getValue();
		return stringValue;
	}
}
