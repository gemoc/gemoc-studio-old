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
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.ActivityNode;

import fr.obeo.dsl.fuml.FUMLExecutionEngine;
import fr.obeo.dsl.fuml.FUMLExecutionEngineForDSL;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.Locus;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.SemanticVisitor;
import fr.obeo.dsl.fuml.debug.Debug;

public abstract class ActivityNodeActivation extends SemanticVisitor {

	/*
	 * The group that contains this activity node activation.
	 */
	public ActivityNodeActivationGroup group;

	/*
	 * The activity node being activated by this activity node activation. The
	 * node must be owned by the activity (type) of the activity execution of
	 * this node activation. [This is optional, to allow for fork node edge
	 * queues and implicit fork and join node activations for actions to not
	 * have nodes in the model.]
	 */
	public ActivityNode node;

	/*
	 * The set of activity edge instances for the incoming edges of the node.
	 */
	public List<ActivityEdgeInstance> incomingEdges = new ArrayList<ActivityEdgeInstance>();

	/*
	 * The set of activity edge instances for the outgoing edges of the node.
	 */
	public List<ActivityEdgeInstance> outgoingEdges = new ArrayList<ActivityEdgeInstance>();

	/*
	 * If true, this node activation is enabled for execution once all its other
	 * prerequesites are satisfied.
	 */
	public Boolean running;

	public List<Token> heldTokens = new ArrayList<Token>();

	public void run() {
		// Run the activation of this node.
		if(this.node != null) {
			Debug.println("[run] node = " + this.node.getName());
		} else {
			Debug.println("[run] Anonymous activation of type " + this.getClass().getName());
		}
		this.running = true;
	}

	public void receiveOffer() {
		// Receive an offer from an incoming edge.
		// Check if all prerequisites have been satisfied. If so, fire.
		Debug.println("[receiveOffer] " + (this.node == null ? "..." : "node = " + this.node.getName()));
		_beginIsolation();
		boolean ready = this.isReady();
		List<Token> tokens = new ArrayList<Token>();
		if(ready) {
			Debug.println("[receiveOffer] Firing.");
			tokens = this.takeOfferedTokens();
		}
		_endIsolation();
		if(ready) {
 			if (FUMLExecutionEngine.eInstance.getDebugger() != null && FUMLExecutionEngine.eInstance.getDebugger().control(Thread.currentThread().getName(), this)) // Added for connection with debug API
				this.fire(tokens);
		}
	}

	public List<Token> takeOfferedTokens() {
		// Get tokens from all incoming edges.
		List<Token> allTokens = new ArrayList<Token>();
		List<ActivityEdgeInstance> incomingEdges = this.incomingEdges;
		for(int i = 0; i < incomingEdges.size(); i++) {
			ActivityEdgeInstance incomingEdge = incomingEdges.get(i);
			List<Token> tokens = incomingEdge.takeOfferedTokens();
			for(int j = 0; j < tokens.size(); j++) {
				Token token = tokens.get(j);
				allTokens.add(token);
			}
		}
		return allTokens;
	}

	public abstract void fire(List<Token> incomingTokens);

	public void sendOffers(List<Token> tokens) {
		// Send offers for the given set of tokens over all outgoing edges (if
		// there are any tokens actually being offered).
		if(tokens.size() > 0) {
			// *** Send all outgoing offers concurrently. ***
			List<ActivityEdgeInstance> outgoingEdges = this.outgoingEdges;
			for(Iterator<ActivityEdgeInstance> i = outgoingEdges.iterator(); i.hasNext();) {
				ActivityEdgeInstance outgoingEdge = i.next();
				// Debug.println("[sendOffers] Sending offer to " +
				// outgoingEdge.target.node.getName() + ".");
				outgoingEdge.sendOffer(tokens);
			}
		}
	}

	public void terminate() {
		// Terminate the activation of this node.
		if(this.running) {
			if(this.node != null) {
				Debug.println("[terminate] node = " + this.node.getName());
			} else {
				Debug.println("[terminate] Anonymous activation of type " + this.getClass().getName());
			}
		}
		this.running = false;
	}

	public Boolean isReady() {
		// Check if all the prerequisites for this node have been satisfied.
		// By default, check that this node is running.
		return this.isRunning();
	}

	public Boolean isRunning() {
		// Test whether this node activation is running.
		return this.running;
	}

	public void addOutgoingEdge(ActivityEdgeInstance edge) {
		// Add an activity edge instance as an outgoing edge of this activity
		// node activation.
		edge.source = this;
		this.outgoingEdges.add(edge);
	}

	public void addIncomingEdge(ActivityEdgeInstance edge) {
		// Add an activity edge instance as an incoming edge of this activity
		// node activation.
		edge.target = this;
		this.incomingEdges.add(edge);
	}

	public void createNodeActivations() {
		// Create node activations for any subnodes of the node for this
		// activation.
		// For most kinds of nodes, this does nothing.
		return;
	}

	public void createEdgeInstances() {
		// Create edge instances for any edge instances owned by the node for
		// this activation.
		// For most kinds of nodes, this does nothing.
		return;
	}

	public Boolean isSourceFor(ActivityEdgeInstance edgeInstance) {
		// Check if this node activation is the effective source for the given
		// edge instance.
		return edgeInstance.source == this;
	}

	public ActivityExecution getActivityExecution() {
		// Return the activity execution that contains this activity node
		// activation, directly or indirectly.
		return this.group.getActivityExecution();
	}

	public Object_ getExecutionContext() {
		// Get the context object for the containing activity execution.
		return this.getActivityExecution().context;
	}

	public Locus getExecutionLocus() {
		// Get the locus of the containing activity execution.
		return this.getActivityExecution().locus;
	}

	public ActivityNodeActivation getNodeActivation(ActivityNode node) {
		// Get the activity node activation corresponding to the given activity
		// node, in the context of this activity node activation.
		// By default, return this activity node activation, if it is for the
		// given node, otherwise return nothing.
		ActivityNodeActivation activation = null;
		if(node == this.node) {
			activation = this;
		}
		return activation;
	}

	public void addToken(Token token) {
		// Transfer the given token to be held by this node.
		if(this.node == null) {
			Debug.println("[addToken] ...");
		} else {
			Debug.println("[addToken] node = " + this.node.getName());
		}
		Token transferredToken = token.transfer(this);
		// Debug.println("[addToken] Adding token with value = " +
		// transferredToken.get());
		this.heldTokens.add(transferredToken);
	}

	public Integer removeToken(Token token) {
		// Remove the given token, if it is held by this node activation.
		// Return the position (counting from 1) of the removed token (0 if
		// there is none removed).
		boolean notFound = true;
		int i = 1;
		while(notFound & i <= this.heldTokens.size()) {
			if(this.heldTokens.get(i - 1) == token) {
				if(this.node == null) {
					Debug.println("[removeToken] ...");
				} else {
					Debug.println("[removeToken] node = " + this.node.getName());
				}
				this.heldTokens.remove(i - 1);
				notFound = false;
			}
			i = i + 1;
		}
		if(notFound) {
			i = 0;
		} else {
			i = i - 1;
		}
		return i;
	}

	public void addTokens(List<Token> tokens) {
		// Transfer the given tokens to be the held tokens for this node.
		// if (this.node == null) {
		// Debug.println("[addTokens] ...");
		// } else {
		// Debug.println("[addTokens] node = " + this.node.getName());
		// }
		for(int i = 0; i < tokens.size(); i++) {
			Token token = tokens.get(i);
			this.addToken(token);
		}
	}

	public List<Token> takeTokens() {
		// Take the tokens held by this node activation.
		List<Token> tokens = this.getTokens();
		this.clearTokens();
		return tokens;
	}

	public void clearTokens() {
		// Remove all held tokens.
		while(this.heldTokens.size() > 0) {
			this.heldTokens.get(0).withdraw();
		}
	}

	public List<Token> getTokens() {
		// Get the tokens held by this node activation.
		// Debug.println("[getTokens] node = " + this.node.getName());
		List<Token> tokens = new ArrayList<Token>();
		List<Token> heldTokens = this.heldTokens;
		for(int i = 0; i < heldTokens.size(); i++) {
			Token heldToken = heldTokens.get(i);
			// Debug.println("[getTokens] token value = " +
			// heldTokens.get());
			tokens.add(heldToken);
		}
		return tokens;
	}

	public void suspend() {
		// Suspend this activation within the activation group that contains it.
		this.group.suspend(this);
	}

	public void resume() {
		// Resume this activation within the activation group that contains it.
		this.group.resume(this);
	}
}
