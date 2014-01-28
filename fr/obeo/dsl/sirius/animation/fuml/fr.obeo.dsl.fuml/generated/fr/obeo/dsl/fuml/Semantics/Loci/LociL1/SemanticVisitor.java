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
package fr.obeo.dsl.fuml.Semantics.Loci.LociL1;

import fr.obeo.dsl.fuml.debug.Debug;

public abstract class SemanticVisitor {

	public void _endIsolation() {
		Debug.println("[_endIsolation] End isolation.");
	}

	public void _beginIsolation() {
		Debug.println("[_beginIsolation] Begin isolation.");
	}
}
