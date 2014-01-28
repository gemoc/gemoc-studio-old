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
package fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications;

import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticStrategy;

public abstract class GetNextEventStrategy extends SemanticStrategy {

	public String getName() {
		// Get next event strategies are always named "getNextEvent".
		return "getNextEvent";
	}

	public abstract SignalInstance getNextEvent(ObjectActivation objectActivation);
}
