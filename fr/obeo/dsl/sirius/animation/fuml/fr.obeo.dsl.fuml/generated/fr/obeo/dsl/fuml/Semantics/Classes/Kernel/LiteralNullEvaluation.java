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

public class LiteralNullEvaluation extends LiteralEvaluation {

	public Value evaluate() {
		// Evaluate a literal null, returning nothing (since a null represents
		// an "absence of any value").
		return null;
	}
}
