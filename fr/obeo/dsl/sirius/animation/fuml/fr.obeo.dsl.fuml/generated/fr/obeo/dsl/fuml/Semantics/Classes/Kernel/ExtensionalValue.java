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

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;

public abstract class ExtensionalValue extends CompoundValue {

	/*
	 * The locus of the extent of which this value is a member. (If the value
	 * has been destroyed, it has no locus.)
	 */
	public Locus locus;

	public void destroy() {
		// Remove this value from its locus (if it has not already been
		// destroyed).
		if(this.locus != null) {
			this.locus.remove(this);
		}
	}

	public Value copy() {
		// Create a new extensional value with the same feature values at the
		// same locus as this one.
		ExtensionalValue newValue = (ExtensionalValue)(super.copy());
		if(this.locus != null) {
			this.locus.add(newValue);
		}
		return newValue;
	}
}
