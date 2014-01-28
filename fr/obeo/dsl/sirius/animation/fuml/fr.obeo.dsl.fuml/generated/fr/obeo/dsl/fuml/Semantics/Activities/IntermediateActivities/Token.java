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

public abstract class Token {

	public ActivityNodeActivation holder;

	public Token transfer(ActivityNodeActivation holder) {
		// if this token does not have any holder, make the given holder its
		// holder.
		// Otherwise, remove this token from its holder and return a copy of it
		// transfered to a new holder.
		Token token = this;
		if(this.holder != null) {
			this.withdraw();
			token = this.copy();
		}
		token.holder = holder;
		return token;
	}

	public void withdraw() {
		// Remove this token from its holder, withdrawing any offers for it.
		if(!this.isWithdrawn()) {
			// Debug.println("[withdraw] Taking token with value = " +
			// this.getValue());
			this.holder.removeToken(this);
			this.holder = null;
		}
	}

	public abstract Boolean equals(Token other);

	public abstract Token copy();

	public Boolean isWithdrawn() {
		// Test if this token has been withdrawn.
		return this.holder == null;
	}

	public abstract Boolean isControl();

	public abstract Value getValue();
}
