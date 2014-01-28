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
package fr.obeo.dsl.fuml.Semantics.Actions.BasicActions;

import org.eclipse.uml2.uml.Pin;

public class InputPinActivation extends PinActivation {

	public void receiveOffer() {
		// Forward the offer to the action activation. [When all input pins are
		// ready, the action will fire them.]
		this.actionActivation.receiveOffer();
	}

	public Boolean isReady() {
		// Return true if the total number of values already being offered by
		// this pin plus those being offered
		// by the sources of incoming edges is at least equal to the minimum
		// multiplicity of the pin.
		boolean ready = super.isReady();
		if(ready) {
			int totalValueCount = this.countUnofferedTokens() + this.countOfferedValues();
			int minimum = ((Pin)this.node).getLower();
			ready = totalValueCount >= minimum;
		}
		return ready;
	}
}
