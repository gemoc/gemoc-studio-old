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
package fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities;

import java.util.ArrayList;
import java.util.List;

public class InitialNodeActivation extends ControlNodeActivation {

	public void fire(List<Token> incomingTokens) {
		// Create a single token and send offers for it.
		List<Token> tokens = new ArrayList<Token>();
		tokens.add(new ControlToken());
		this.addTokens(tokens);
		this.sendOffers(tokens);
	}
}
