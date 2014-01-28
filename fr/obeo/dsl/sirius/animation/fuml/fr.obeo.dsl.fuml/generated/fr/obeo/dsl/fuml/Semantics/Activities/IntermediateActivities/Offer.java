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

public class Offer {

	public List<Token> offeredTokens = new ArrayList<Token>();

	public Integer countOfferedValues() {
		// Return the number of values being offered on object tokens.
		// Remove any tokens that have already been withdrawn and don't include
		// them in the count.
		this.removeWithdrawnTokens();
		int count = 0;
		for(int i = 0; i < this.offeredTokens.size(); i++) {
			if(this.offeredTokens.get(i).getValue() != null) {
				count = count + 1;
			}
		}
		return count;
	}

	public List<Token> getOfferedTokens() {
		// Get the offered tokens, removing any that have been withdrawn.
		this.removeWithdrawnTokens();
		List<Token> tokens = new ArrayList<Token>();
		List<Token> offeredTokens = this.offeredTokens;
		for(int i = 0; i < this.offeredTokens.size(); i++) {
			Token offeredToken = offeredTokens.get(i);
			// Debug.println("[getOfferedTokens] token value = " +
			// offeredToken.getValue());
			tokens.add(offeredToken);
		}
		return tokens;
	}

	public void removeOfferedValues(Integer count) {
		// Remove the given number of non-null object tokens from those in this
		// offer.
		int n = count;
		int i = 1;
		while(n > 0) {
			if(this.offeredTokens.get(i - 1).getValue() != null) {
				this.offeredTokens.remove(i - 1);
			} else {
				i = i + 1;
			}
			n = n - 1;
		}
	}

	public void removeWithdrawnTokens() {
		// Remove any tokens that have already been consumed.
		// List<Token> offeredTokens = this.offeredTokens;
		int i = 1;
		while(i <= this.offeredTokens.size()) {
			if(this.offeredTokens.get(i - 1).isWithdrawn()) {
				this.offeredTokens.remove(i - 1);
				i = i - 1;
			}
			i = i + 1;
		}
	}

	public Boolean hasTokens() {
		// Check whether this offer has any tokens that have not been withdrawn.
		this.removeWithdrawnTokens();
		return this.offeredTokens.size() > 0;
	}
}
