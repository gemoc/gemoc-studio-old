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
package fr.obeo.dsl.fuml.Semantics.Actions.IntermediateActions;

import java.util.List;

import org.eclipse.uml2.uml.ClearAssociationAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.ActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.ExtensionalValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Link;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ClearAssociationActionActivation extends ActionActivation {

	public void doAction() {
		// Get the extent, at the current execution locus, of the given
		// association.
		// Read the object input pin. Destroy all links in which the object
		// participates.
		ClearAssociationAction action = (ClearAssociationAction)(this.node);
		List<ExtensionalValue> extent = this.getExecutionLocus().getExtent(action.getAssociation());
		Value objectValue = this.takeTokens(action.getObject()).get(0);
		for(int i = 0; i < extent.size(); i++) {
			Link link = (Link)(extent.get(i));
			if(this.valueParticipatesInLink(objectValue, link)) {
				link.destroy();
			}
		}
	}
}
