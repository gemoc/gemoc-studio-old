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

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public class ForkedToken extends Token {

	public Token baseToken;

	/*
	 * The remaining number of outstanding offers for this token on outgoing
	 * edges of the fork node.
	 */
	public Integer remainingOffersCount;

	/*
	 * Indicates whether withdraw() has been called on the base token.
	 */
	public Boolean baseTokenIsWithdrawn;

	public Boolean isControl() {
		// Test if the base token is a control token.
		return this.baseToken.isControl();
	}

	public void withdraw() {
		// If the base token is not withdrawn, then withdraw it.
		// Decrement the remaining offers count.
		// When the remaining number of offers is zero, then remove this token
		// from its holder.
		if(!this.baseTokenIsWithdrawn & !this.baseToken.isWithdrawn()) {
			this.baseToken.withdraw();
			// NOTE: This keeps a base token that is a forked token from being
			// withdrawn more than once, since withdrawing a forked token may
			// not actually remove it from its fork node holder.
			this.baseTokenIsWithdrawn = true;
		}
		if(this.remainingOffersCount > 0) {
			this.remainingOffersCount = this.remainingOffersCount - 1;
		}
		if(this.remainingOffersCount == 0) {
			super.withdraw();
		}
	}

	public Token copy() {
		// Return a copy of the base token.
		return this.baseToken.copy();
	}

	public Boolean equals(Token otherToken) {
		// Test if this token is equal to another token.
		return this == otherToken;
	}

	public Value getValue() {
		// Return the value of the base token.
		return this.baseToken.getValue();
	}
}
