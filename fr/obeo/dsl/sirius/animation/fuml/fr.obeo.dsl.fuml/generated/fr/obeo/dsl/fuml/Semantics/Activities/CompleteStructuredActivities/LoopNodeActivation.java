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
import java.util.List;

import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Pin;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.OutputPinActivation;
import fr.obeo.dsl.fuml.Semantics.Activities.IntermediateActivities.ActivityNodeActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.BooleanValue;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.debug.Debug;

public class LoopNodeActivation extends StructuredActivityNodeActivation {

	public List<Values> bodyOutputLists = new ArrayList<Values>();
	public Boolean isTerminateAll;
	
	public void doStructuredActivity() {
		// Set the initial values for the body outputs to the values of the loop
		// variable input pins.
		// If isTestedFirst is true, then repeatedly run the test part and the
		// body part of the loop, copying values from the body outputs to the
		// loop variables.
		// If isTestedFirst is false, then repeatedly run the body part and the
		// test part of the loop, copying values from the body outputs to the
		// loop variables.
		// When the test fails, copy the values of the body outputs to the loop
		// outputs.
		// [Note: The body outputs are used for the loop outputs, rather than
		// the loop variables, since values on the loop variables may be
		// consumed when running the test for the last time.]
		LoopNode loopNode = (LoopNode)(this.node);
		List<InputPin> loopVariableInputs = loopNode.getLoopVariableInputs();
		
		this.bodyOutputLists.clear(); // Added
		
		for(int i = 0; i < loopVariableInputs.size(); i++) {
			InputPin loopVariableInput = loopVariableInputs.get(i);
			Values bodyOutputList = new Values();
			bodyOutputList.values = this.takeTokens(loopVariableInput);
			this.bodyOutputLists.add(bodyOutputList);
		}
		this.isTerminateAll = false;
		this.doLoop(true);
	}

	public void doLoop(Boolean continuing) {
		// If isTestedFirst is true, then repeatedly run the test part and the
		// body part of the loop, copying values from the body outputs to the
		// loop variables.
		// If isTestedFirst is false, then repeatedly run the body part and the
		// test part of the loop, copying values from the body outputs to the
		// loop variables.
		LoopNode loopNode = (LoopNode)(this.node);
		List<OutputPin> loopVariables = loopNode.getLoopVariables();
		List<OutputPin> resultPins = this.getResults(); // CHANGED from: loopNode.getResults();
		while(continuing) {
			// Set loop variable values
			this.runLoopVariables();
			for(int i = 0; i < loopVariables.size(); i++) {
				OutputPin loopVariable = loopVariables.get(i);
				Values bodyOutputList = bodyOutputLists.get(i);
				List<Value> values = bodyOutputList.values;
				this.putPinValues(loopVariable, values);
				((OutputPinActivation)this.activationGroup.getNodeActivation(loopVariable)).sendUnofferedTokens();
			}
			// Run all the non-executable, non-pin nodes in the conditional
			// node.
			List<ActivityNodeActivation> nodeActivations = this.activationGroup.nodeActivations;
			List<ActivityNodeActivation> nonExecutableNodeActivations = new ArrayList<ActivityNodeActivation>();
			for(int i = 0; i < nodeActivations.size(); i++) {
				ActivityNodeActivation nodeActivation = nodeActivations.get(i);
				if(!(nodeActivation.node instanceof ExecutableNode | nodeActivation.node instanceof Pin)) {
					nonExecutableNodeActivations.add(nodeActivation);
				}
			}
			this.activationGroup.run(nonExecutableNodeActivations);
			// Run the loop
			if(loopNode.isTestedFirst()) {
				continuing = this.runTest();
				if(continuing) {
					this.runBody();
				}
			} else {
				this.runBody();
				if(this.isRunning() & !this.isSuspended()) {
					continuing = this.runTest();
				}
			}
			if(!this.isTerminateAll & this.isRunning() & !this.isSuspended()) {
				this.activationGroup.terminateAll();
			} else {
				continuing = false;
			}
			Debug.println("[doStructuredActivity] " + (continuing ? "Continuing." : this.isSuspended() ? "Suspended" : "Done."));
		}
		if(!this.isTerminateAll & this.isRunning() & !this.isSuspended()) {
			for(int i = 0; i < bodyOutputLists.size(); i++) {
				Values bodyOutputList = bodyOutputLists.get(i);
				OutputPin resultPin = resultPins.get(i);
				this.putTokens(resultPin, bodyOutputList.values);
			}
		}
	}

	public Boolean runTest() {
		// Run the test part of the loop node for this node activation.
		// Return the value on the decider pin.
		Debug.println("[runTest] Running test...");
		LoopNode loopNode = (LoopNode)(this.node);
		this.activationGroup.runNodes(this.makeActivityNodeList(loopNode.getTests()));
		List<Value> values = this.getPinValues(loopNode.getDecider());
		// If there is no decider value, treat it as false.
		boolean decision = false;
		if(values.size() > 0) {
			decision = ((BooleanValue)(values.get(0))).value;
		}
		Debug.println("[runTest] " + (decision ? "Test succeeded." : "Test failed."));
		return decision;
	}

	public void runBody() {
		// Run the body part of the loop node for this node activation and save
		// the body outputs.
		Debug.println("[runBody] Running body...");
		LoopNode loopNode = (LoopNode)this.node;
		this.activationGroup.runNodes(this.makeActivityNodeList(loopNode.getBodyParts()));
		if(!this.isTerminateAll && !this.isSuspended()) {
			this.saveBodyOutputs();
		}
	}

	public void saveBodyOutputs() {
		// Save the body outputs for use in the next iteration.
		LoopNode loopNode = (LoopNode)this.node;
		List<OutputPin> bodyOutputs = loopNode.getBodyOutputs();
		List<Values> bodyOutputLists = this.bodyOutputLists;
		for(int i = 0; i < bodyOutputs.size(); i++) {
			OutputPin bodyOutput = bodyOutputs.get(i);
			Values bodyOutputList = bodyOutputLists.get(i);
			bodyOutputList.values = this.getPinValues(bodyOutput);
		}
	}

	public void runLoopVariables() {
		// Run the loop variable pins of the loop node for this node activation.
		this.activationGroup.runNodes(this.makeLoopVariableList());
	}

	public void createNodeActivations() {
		// In addition to creating activations for contained nodes, create
		// activations for any loop variables.
		
		super.createNodeActivations();
		this.activationGroup.createNodeActivations(this.makeLoopVariableList());
	}

	public List<ActivityNode> makeLoopVariableList() {
		// Return an activity node list containing the loop variable pins for
		// the loop node of this activation.
		LoopNode loopNode = (LoopNode)(this.node);
		List<ActivityNode> nodes = new ArrayList<ActivityNode>();
		List<OutputPin> loopVariables = loopNode.getLoopVariables();
		for(int i = 0; i < loopVariables.size(); i++) {
			OutputPin loopVariable = loopVariables.get(i);
			nodes.add(loopVariable);
		}
		return nodes;
	}

	public void terminateAll() {
		// Copy the values of the body outputs to the loop outputs, and then
		// terminate all activations in the loop.
		this.isTerminateAll = true;		
		LoopNode loopNode = (LoopNode) this.node;
		List<OutputPin> bodyOutputs = loopNode.getBodyOutputs();
		List<OutputPin> resultPins = this.getResults();
		for (int i = 0; i < bodyOutputs.size(); i++) {
			OutputPin bodyOutput = bodyOutputs.get(i);
			OutputPin resultPin = resultPins.get(i);
			this.putTokens(resultPin, this.getPinValues(bodyOutput));
		}
		super.terminateAll();
	}

	public void resume() {
		// When this loop node is resumed after being suspended, continue with
		// its next iteration (if any). Once the loop has completed execution
		// without being suspended again, complete the action.
		LoopNode loopNode = (LoopNode)(this.node);
		this.saveBodyOutputs();
		if (!this.isTerminateAll) {
			if(loopNode.isMustIsolate()) {
				_beginIsolation();
				this.continueLoop();
				_endIsolation();
			} else {
				this.continueLoop();
			}
		}
		if(this.isSuspended()) {
			// NOTE: If the subsequent iteration of the loop suspends it again,
			// then it is necessary to remove the previous suspension from the
			// containing activity node activation group.
			this.group.resume(this);
		} else {
			super.resume();
		}
	}

	public void continueLoop() {
		// Continue the loop node when it is resumed after being suspended. If
		// isTestedFirst is true, then continue executing the loop. If
		// isTestedFirst is false, then run the test to determine whether
		// the loop should be continued or completed.
		// [Note that this presumes that an accept event action is not allowed
		// in the test part of a loop node.]
		LoopNode loopNode = (LoopNode)(this.node);
		boolean continuing = true;
		if(!loopNode.isTestedFirst()) {
			continuing = this.runTest();
		}
		if(this.isRunning()) {
			this.activationGroup.terminateAll();
			this.doLoop(continuing);
		}
	}
	
	// ADDED:
	private List<OutputPin> getResults() {
		LoopNode node = (LoopNode)this.node;
		List<OutputPin> results = new ArrayList<OutputPin>(node.getResults());
		List<OutputPin> loopVariables = node.getLoopVariables();
		results.removeAll(loopVariables);
		return results;
	}
	//
}
