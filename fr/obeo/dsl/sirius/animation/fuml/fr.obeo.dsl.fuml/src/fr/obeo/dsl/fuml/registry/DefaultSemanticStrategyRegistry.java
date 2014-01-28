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
package fr.obeo.dsl.fuml.registry;


import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.FirstChoiceStrategy;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;

public class DefaultSemanticStrategyRegistry implements ISemanticStrategyRegistry {

	public ISemanticStrategyRegistry init(Object parameters) {
		// no need for additional parameters
		return this;
	}

	public void registerSemanticStrategies(Locus locus) {
		locus.factory.setStrategy(new FirstChoiceStrategy());
		locus.factory.setStrategy(new FIFOGetNextEventStrategy());
		locus.factory.setStrategy(new RedefinitionBasedDispatchStrategy());
	}
}
