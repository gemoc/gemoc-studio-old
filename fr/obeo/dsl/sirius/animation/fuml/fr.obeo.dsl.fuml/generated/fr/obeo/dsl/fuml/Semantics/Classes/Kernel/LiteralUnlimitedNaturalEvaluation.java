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

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

public class LiteralUnlimitedNaturalEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a literal unlimited natural producing an unlimited natural
		// value.
		LiteralUnlimitedNatural literal = (LiteralUnlimitedNatural)specification;
		UnlimitedNaturalValue unlimitedNaturalValue = new UnlimitedNaturalValue();
		unlimitedNaturalValue.type = this.getType("UnlimitedNatural");
		unlimitedNaturalValue.value = literal.getValue();
		return unlimitedNaturalValue;
	}
}
