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
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ValueSpecification;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.BooleanValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import fr.obeo.dsl.fuml.debug.Debug;

public class DecisionNodeActivation extends ControlNodeActivation {

	/*
	 * The current execution of the decision input behavior (if any).
	 */
	public Execution decisionInputExecution;

	public void fire(List<Token> incomingTokens) {
		// Get the decision values and test them on each guard.
		// Forward the offer over the edges for which the test succeeds.
		Debug.println("[fire] Decision node " + this.node.getName() + "...");
		// List<Token> incomingTokens = this.takeOfferedTokens();
		List<Token> removedControlTokens = this.removeJoinedControlTokens(incomingTokens);
		List<Value> decisionValues = this.getDecisionValues(incomingTokens);
		List<ActivityEdgeInstance> outgoingEdges = this.outgoingEdges;
		for(int i = 0; i < outgoingEdges.size(); i++) {
			ActivityEdgeInstance edgeInstance = outgoingEdges.get(i);
			ValueSpecification guard = edgeInstance.edge.getGuard();
			List<Token> offeredTokens = new ArrayList<Token>();
			for(int j = 0; j < incomingTokens.size(); j++) {
				Token incomingToken = incomingTokens.get(j);
				Value decisionValue = decisionValues.get(j);
				if(this.test(guard, decisionValue)) {
					offeredTokens.add(incomingToken);
				}
			}
			if(offeredTokens.size() > 0) {
				for(int j = 0; j < removedControlTokens.size(); j++) {
					Token removedControlToken = removedControlTokens.get(j);
					offeredTokens.add(removedControlToken);
				}
				edgeInstance.sendOffer(offeredTokens);
			}
		}
	}

	public List<Value> getDecisionValues(List<Token> incomingTokens) {
		// If there is neither a decision input flow nor a decision input
		// behavior, then return the set of values from the incoming tokens.
		// [In this case, the single incoming edge must be an object flow.]
		// If there is a decision input flow, but no decision input behavior,
		// then return a list of the decision input values equal in size to the
		// number of incoming tokens.
		// If there is both a decision input flow and a decision input behavior,
		// then execute the decision input behavior once for each incoming token
		// and return the set of resulting values.
		// If the primary incoming edge is an object flow, then the value on
		// each object token is passed to the decision input behavior, along
		// with the decision input flow value, if any.
		// If the primary incoming edge is a control flow, then the decision
		// input behavior only receives the decision input flow, if any.
		Value decisionInputValue = this.getDecisionInputFlowValue();
		List<Value> decisionValues = new ArrayList<Value>();
		for(int i = 0; i < incomingTokens.size(); i++) {
			Token incomingToken = incomingTokens.get(i);
			Value value = this.executeDecisionInputBehavior(incomingToken.getValue(), decisionInputValue);
			decisionValues.add(value);
		}
		// Debug.println("[getDecisionValues] " + decisionValues.size() +
		// " decision value(s):");
		for(int i = 0; i < decisionValues.size(); i++) {
			Value decisionValue = decisionValues.get(i);
			Debug.println("[getDecisionValues] decisionValues[" + i + "] = " + decisionValue);
		}
		return decisionValues;
	}

	public Value executeDecisionInputBehavior(Value inputValue, Value decisionInputValue) {
		// Create the decision input execution from the decision input behavior.
		// If the behavior has input parameter(s), set the input parameter(s) of
		// the execution to the given value(s).
		// Execute the decision input execution and then remove it.
		// Return the value of the output parameter of the execution.
		// If there is no decision input behavior, the decision input value is
		// returned, if one is given, otherwise the input value is used as the
		// decision value.
		Debug.println("[executeDecisionBehavior] inputValue = " + inputValue);
		Behavior decisionInputBehavior = ((DecisionNode)(this.node)).getDecisionInput();
		Value decisionInputResult = null;
		if(decisionInputBehavior == null) {
			if(decisionInputValue != null) {
				decisionInputResult = decisionInputValue;
			} else {
				decisionInputResult = inputValue;
			}
		} else {
			this.decisionInputExecution = this.getExecutionLocus().factory.createExecution(decisionInputBehavior, this.getExecutionContext());
			int i = 1;
			int j = 0;
			while((j == 0 | (j == 1 & decisionInputValue != null)) & i <= decisionInputBehavior.getOwnedParameters().size()) {
				Parameter parameter = decisionInputBehavior.getOwnedParameters().get(i - 1);
				if(parameter.getDirection().equals(ParameterDirectionKind.IN_LITERAL) | parameter.getDirection().equals(ParameterDirectionKind.INOUT_LITERAL)) {
					ParameterValue inputParameterValue = new ParameterValue();
					inputParameterValue.parameter = parameter;
					j = j + 1;
					if(j == 1 && inputValue != null) {
						inputParameterValue.values.add(inputValue);
					} else {
						inputParameterValue.values.add(decisionInputValue);
					}
					this.decisionInputExecution.setParameterValue(inputParameterValue);
				}
				i = i + 1;
			}
			this.decisionInputExecution.execute();
			List<ParameterValue> outputParameterValues = this.decisionInputExecution.getOutputParameterValues();
			decisionInputExecution.destroy();
			if (outputParameterValues.get(0).values.size() == 0) { 
				// FIXME Added for connection with debug API
				// When execution stops due to client request, outputParameterValues is empty
				// Just puts true. Execution flow is supposed to stop "by itself" then
				decisionInputResult = new BooleanValue() ;
				((BooleanValue)decisionInputResult).value = true ;
			}
			else {
				decisionInputResult = outputParameterValues.get(0).values.get(0);
			}
		}
		return decisionInputResult;
	}

	public void terminate() {
		// Terminate the decision input execution, if any, and then terminate
		// this activation.
		if(this.decisionInputExecution != null) {
			this.decisionInputExecution.terminate();
		}
		super.terminate();
	}

	public Boolean isReady() {
		// Check that all incoming edges have sources that are offering tokens.
		// [This should be at most two incoming edges, if there is a decision
		// input flow.]
		int i = 1;
		boolean ready = true;
		while(ready & i <= this.incomingEdges.size()) {
			ready = this.incomingEdges.get(i - 1).hasOffer();
			i = i + 1;
		}
		return ready;
	}

	public List<Token> takeOfferedTokens() {
		// Get tokens from the incoming edge that is not the decision input
		// flow.
		ObjectFlow decisionInputFlow = ((DecisionNode)(this.node)).getDecisionInputFlow();
		List<Token> allTokens = new ArrayList<Token>();
		List<ActivityEdgeInstance> incomingEdges = this.incomingEdges;
		for(int i = 0; i < incomingEdges.size(); i++) {
			ActivityEdgeInstance edgeInstance = incomingEdges.get(i);
			if(edgeInstance.edge != decisionInputFlow) {
				List<Token> tokens = edgeInstance.takeOfferedTokens();
				for(int j = 0; j < tokens.size(); j++) {
					allTokens.add(tokens.get(j));
				}
			}
		}
		return allTokens;
	}

	public Value getDecisionInputFlowValue() {
		// Take the next token available on the decision input flow, if any, and
		// return its value.
		ActivityEdgeInstance decisionInputFlowInstance = this.getDecisionInputFlowInstance();
		Value value = null;
		if(decisionInputFlowInstance != null) {
			List<Token> tokens = decisionInputFlowInstance.takeOfferedTokens();
			if(tokens.size() > 0) {
				value = tokens.get(0).getValue();
			}
		}
		return value;
	}

	public ActivityEdgeInstance getDecisionInputFlowInstance() {
		// Get the activity edge instance for the decision input flow, if any.
		ActivityEdge decisionInputFlow = ((DecisionNode)(this.node)).getDecisionInputFlow();
		ActivityEdgeInstance edgeInstance = null;
		if(decisionInputFlow != null) {
			int i = 1;
			while(edgeInstance == null & i <= this.incomingEdges.size()) {
				ActivityEdgeInstance incomingEdge = this.incomingEdges.get(i - 1);
				if(incomingEdge.edge == decisionInputFlow) {
					edgeInstance = incomingEdge;
				}
				i = i + 1;
			}
		}
		return edgeInstance;
	}

	public Boolean test(ValueSpecification guard, Value value) {
		// Test if the given value matches the guard. If there is no guard,
		// return true.
		boolean guardResult = true;
		if(guard != null) {
			Value guardValue = this.getExecutionLocus().executor.evaluate(guard);
			guardResult = guardValue.equals(value);
		}
		return guardResult;
	}

	public List<Token> removeJoinedControlTokens(List<Token> incomingTokens) {
		// If the primary incoming edge is an object flow, then remove any
		// control tokens from the incoming tokens and return them.
		// [Control tokens may effectively be offered on an object flow outgoing
		// from a join node that has both control and object flows incoming.]
		List<Token> removedControlTokens = new ArrayList<Token>();
		if(this.hasObjectFlowInput()) {
			int i = 1;
			while(i <= incomingTokens.size()) {
				Token token = incomingTokens.get(i - 1);
				if(token.isControl()) {
					removedControlTokens.add(token);
					incomingTokens.remove(i - 1);
					i = i - 1;
				}
				i = i + 1;
			}
		}
		return removedControlTokens;
	}

	public Boolean hasObjectFlowInput() {
		// Check that the primary incoming edge is an object flow.
		ActivityEdge decisionInputFlow = ((DecisionNode)(this.node)).getDecisionInputFlow();
		boolean isObjectFlow = false;
		int i = 1;
		while(!isObjectFlow & i <= this.incomingEdges.size()) {
			ActivityEdge edge = this.incomingEdges.get(i - 1).edge;
			isObjectFlow = edge != decisionInputFlow & edge instanceof ObjectFlow;
			i = i + 1;
		}
		return isObjectFlow;
	}
}
