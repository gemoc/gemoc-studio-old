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

import org.eclipse.uml2.uml.LiteralReal;

public class LiteralRealEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a real integer, producing a real value.
		LiteralReal literal = (LiteralReal)specification;
		RealValue realValue = new RealValue();
		realValue.type = this.getType("Real");
		realValue.value = literal.getValue();
		return realValue;
	}
}
