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

import org.eclipse.uml2.uml.ActivityEdge;

import fr.obeo.dsl.fuml.FUMLExecutionEngine;
import fr.obeo.dsl.fuml.FUMLExecutionEngineForDSL;

public class ActivityEdgeInstance {

	/*
	 * The activity edge of which this is an instance. [This is optional to
	 * allow for an implicit fork node execution to be connected to its action
	 * execution by an edge instance which does not have a corresponding node in
	 * the model.]
	 */
	public ActivityEdge edge;

	/*
	 * The activity group that contains this activity edge instance.
	 */
	public ActivityNodeActivationGroup group;

	/*
	 * The source of this activity edge instance. The node of the source must be
	 * the same as the source of the edge of this edge instance.
	 */
	public ActivityNodeActivation source;

	/*
	 * The target of this activity edge instance. The node of the target must be
	 * the same as the target of the edge of this edge instance.
	 */
	public ActivityNodeActivation target;

	public List<Offer> offers = new ArrayList<Offer>();

	public void sendOffer(List<Token> tokens) {
		// Send an offer from the source to the target.
		// Keep the offered tokens until taken by the target.
		// (Note that any one edge should only be handling either all object
		// tokens or all control tokens.)
 		if (! (FUMLExecutionEngine.eInstance.getDebugger() != null && FUMLExecutionEngine.eInstance.getDebugger().control(Thread.currentThread().getName(), this))) { // Added for connection with the debug API
			return ;
		}
		Offer offer = new Offer();
		for(int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			// Debug.println("[sendOffer] token value = " + token.get());
			offer.offeredTokens.add(token);
		}
		this.offers.add(offer);
		this.target.receiveOffer();
	}

	public Integer countOfferedValues() {
		// Return the number of values being offered in object tokens.
		int count = 0;
		List<Offer> offers = this.offers;
		for(int i = 0; i < offers.size(); i++) {
			count = count + offers.get(i).countOfferedValues();
		}
		return count;
	}

	public List<Token> takeOfferedTokens() {
		// Take all the offered tokens and return them.
		List<Token> tokens = new ArrayList<Token>();
		while(this.offers.size() > 0) {
			List<Token> offeredTokens = this.offers.get(0).getOfferedTokens();
			for(int i = 0; i < offeredTokens.size(); i++) {
				tokens.add(offeredTokens.get(i));
			}
			this.offers.remove(0);
		}
		return tokens;
	}

	public List<Token> takeOfferedTokens(Integer maxCount) {
		// Take all the offered tokens, up to the given maximum count of
		// non-null object tokens, and return them.
		List<Token> tokens = new ArrayList<Token>();
		int remainingCount = maxCount;
		while(this.offers.size() > 0 & remainingCount > 0) {
			Offer offer = this.offers.get(0);
			List<Token> offeredTokens = offer.getOfferedTokens();
			int count = offer.countOfferedValues();
			if(count <= remainingCount) {
				for(int i = 0; i < offeredTokens.size(); i++) {
					tokens.add(offeredTokens.get(i));
				}
				remainingCount = remainingCount - count;
				this.offers.remove(0);
			} else {
				for(int i = 0; i < remainingCount; i++) {
					Token token = offeredTokens.get(i);
					if(token.getValue() != null) {
						tokens.add(token);
					}
				}
				offer.removeOfferedValues(remainingCount);
				remainingCount = 0;
			}
		}
		return tokens;
	}

	public List<Token> getOfferedTokens() {
		// Get the offered tokens (after which the tokens will still be
		// offered).
		List<Token> tokens = new ArrayList<Token>();
		List<Offer> offers = this.offers;
		for(int i = 0; i < offers.size(); i++) {
			List<Token> offeredTokens = offers.get(i).getOfferedTokens();
			for(int j = 0; j < offeredTokens.size(); j++) {
				tokens.add(offeredTokens.get(j));
			}
		}
		return tokens;
	}

	public Boolean hasOffer() {
		// Return true if there are any pending offers.
		boolean hasTokens = false;
		int i = 1;
		while(!hasTokens & i <= this.offers.size()) {
			hasTokens = this.offers.get(i - 1).hasTokens();
			i = i + 1;
		}
		return hasTokens;
	}
}
