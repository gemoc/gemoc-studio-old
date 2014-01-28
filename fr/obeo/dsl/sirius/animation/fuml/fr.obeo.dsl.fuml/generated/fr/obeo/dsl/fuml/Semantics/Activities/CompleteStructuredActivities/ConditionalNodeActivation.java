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
package fr.obeo.dsl.fuml.Semantics.Activities.CompleteStructuredActivities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.Token;
import fr.obeo.dsl.fuml.Semantics.Loci.LociL1.ChoiceStrategy;
import fr.obeo.dsl.fuml.debug.Debug;

public class ConditionalNodeActivation extends StructuredActivityNodeActivation {

	/*
	 * The activations for each clause in the conditional node for this node
	 * activation.
	 */
	public List<ClauseActivation> clauseActivations = new ArrayList<ClauseActivation>();

	/*
	 * The set of clauses which meet the conditions to have their bodies
	 * activated.
	 */
	public List<Clause> selectedClauses = new ArrayList<Clause>();

	/*
	 * The clause chosen from the set of selectedClauses to actually be
	 * executed.
	 */
	public Clause selectedClause;

	public void doStructuredActivity() {
		// Run all the non-executable, non-pin nodes in the conditional node.
		// Activate all clauses in the conditional node and pass control to
		// those that are ready (i.e., have no predecessors).
		// If one or more clauses have succeeded in being selected, choose one
		// non-deterministically and run its body, then copy the outputs of that
		// clause to the output pins of the node.
		ConditionalNode node = (ConditionalNode)(this.node);
		List<ActivityNodeActivation> nodeActivations = this.activationGroup.nodeActivations;
		List<ActivityNodeActivation> nonExecutableNodeActivations = new ArrayList<ActivityNodeActivation>();
		for(int i = 0; i < nodeActivations.size(); i++) {
			ActivityNodeActivation nodeActivation = nodeActivations.get(i);
			if(!(nodeActivation.node instanceof ExecutableNode | nodeActivation.node instanceof Pin)) {
				nonExecutableNodeActivations.add(nodeActivation);
			}
		}
		this.activationGroup.run(nonExecutableNodeActivations);
		this.clauseActivations.clear();
		List<Clause> clauses = node.getClauses();
		for(int i = 0; i < clauses.size(); i++) {
			Clause clause = clauses.get(i);
			ClauseActivation clauseActivation = new ClauseActivation();
			clauseActivation.clause = clause;
			clauseActivation.conditionalNodeActivation = this;
			this.clauseActivations.add(clauseActivation);
		}
		this.selectedClauses.clear();
		List<ClauseActivation> readyClauseActivations = new ArrayList<ClauseActivation>();
		for(int i = 0; i < this.clauseActivations.size(); i++) {
			ClauseActivation clauseActivation = this.clauseActivations.get(i);
			Debug.println("[doStructuredActivity] clauseActivations[" + i + "] = " + clauseActivation);
			if(clauseActivation.isReady()) {
				Debug.println("[doStructuredActivity] Clause activation is ready.");
				readyClauseActivations.add(clauseActivation);
			}
		}
		// *** Give control to all ready clauses concurrently. ***
		for(Iterator<ClauseActivation> i = readyClauseActivations.iterator(); i.hasNext();) {
			ClauseActivation clauseActivation = (ClauseActivation)i.next();
			Debug.println("[doStructuredActivity] Giving control to " + clauseActivation + "...");
			clauseActivation.receiveControl();
		}
		this.selectedClause = null;
		if(this.selectedClauses.size() > 0 & this.isRunning()) {
			Debug.println("[doStructuredActivity] " + this.selectedClauses.size() + " clause(s) selected.");
			// *** If multiple clauses are selected, choose one
			// non-deterministically. ***
			int i = ((ChoiceStrategy)this.getExecutionLocus().factory.getStrategy("choice")).choose(this.selectedClauses.size());
			this.selectedClause = this.selectedClauses.get(i - 1);
			Debug.println("[doStructuredActivity] Running selectedClauses[" + i + "] = " + this.selectedClause);
			for(int j = 0; j < clauses.size(); j++) {
				Clause clause = clauses.get(j);
				if(clause != selectedClause) {
					List<ExecutableNode> testNodes = clause.getTests();
					for(int k = 0; k < testNodes.size(); k++) {
						ExecutableNode testNode = testNodes.get(k);
						this.activationGroup.getNodeActivation(testNode).terminate();
					}
				}
			}
			this.activationGroup.runNodes(this.makeActivityNodeList(this.selectedClause.getBodies()));
		}
	}

	public void completeBody() {
		// Complete the activation of the body of a conditional note by
		// copying the outputs of the selected clause (if any) to the output
		// pins of the node and terminating the activation of all nested nodes.
		if(this.selectedClause != null) {
			ConditionalNode node = (ConditionalNode)(this.node);
			List<OutputPin> resultPins = node.getResults();
			List<OutputPin> bodyOutputPins = this.selectedClause.getBodyOutputs();
			for(int k = 0; k < resultPins.size(); k++) {
				OutputPin resultPin = resultPins.get(k);
				OutputPin bodyOutputPin = bodyOutputPins.get(k);
				this.putTokens(resultPin, this.getPinValues(bodyOutputPin));
			}
		}
		this.activationGroup.terminateAll();
	}

	public List<Token> completeAction() {
		// Only complete the conditional node if it is not suspended.
		if(!this.isSuspended()) {
			completeBody();
		}
		return super.completeAction();
	}

	public ClauseActivation getClauseActivation(Clause clause) {
		// Get the clause activation corresponding to the given clause.
		// Debug.println("[getClauseActivation] clause = " + clause);
		ClauseActivation selectedClauseActivation = null;
		int i = 1;
		while((selectedClauseActivation == null) & i <= this.clauseActivations.size()) {
			ClauseActivation clauseActivation = this.clauseActivations.get(i - 1);
			// Debug.println("[getClauseActivations] clauseActivations[" + i +
			// "].clause = " + clauseActivation.clause);
			if(clauseActivation.clause == clause) {
				selectedClauseActivation = clauseActivation;
			}
			i = i + 1;
		}
		return selectedClauseActivation;
	}

	public void runTest(Clause clause) {
		// Run the test for the given clause.
		if(this.isRunning()) {
			this.activationGroup.runNodes(this.makeActivityNodeList(clause.getTests()));
		}
	}

	public void selectBody(Clause clause) {
		// Add the clause to the list of selected clauses.
		this.selectedClauses.add(clause);
	}

	public void resume() {
		// When this conditional node is resumed after being suspended, complete
		// its body and then resume it as a structured activity node.
		// [Note that this presumes that accept event actions are not allowed
		// in the test part of a clause of a conditional node.]
		completeBody();
		super.resume();
	}
}
