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

import org.eclipse.uml2.uml.PrimitiveType;

public abstract class LiteralEvaluation extends Evaluation {

	public PrimitiveType getType(String builtInTypeName) {
		// Get the type of the specification. If that is null, then use the
		// built-in type of the given name.
		PrimitiveType type = (PrimitiveType)(this.specification.getType());
		if(type == null) {
			type = this.locus.factory.getBuiltInType(builtInTypeName);
		}
		return type;
	}
}
