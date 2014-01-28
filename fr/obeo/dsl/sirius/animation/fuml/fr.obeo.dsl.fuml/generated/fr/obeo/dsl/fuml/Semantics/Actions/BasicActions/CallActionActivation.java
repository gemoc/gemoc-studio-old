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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;

public abstract class CallActionActivation extends InvocationActionActivation {

	/*
	 * The set of execution object for currently ongoing calls made through this
	 * call action activation.
	 */
	public List<Execution> callExecutions = new ArrayList<Execution>();

	public void doAction() {
		// Get the call execution object, set its input parameters from the
		// argument pins and execute it.
		// Once execution completes, copy the values of the output parameters of
		// the call execution to the result pins of the call action execution,
		// then destroy the execution.
		Execution callExecution = this.getCallExecution();
		if(callExecution != null) {
			this.callExecutions.add(callExecution);
			CallAction callAction = (CallAction)(this.node);
			List<InputPin> argumentPins = callAction.getArguments();
			List<OutputPin> resultPins = callAction.getResults();
			List<Parameter> parameters = callExecution.getBehavior().getOwnedParameters();
			int pinNumber = 1;
			int i = 1;
			while(i <= parameters.size()) {
				Parameter parameter = parameters.get(i - 1);
				if(parameter.getDirection() == ParameterDirectionKind.IN_LITERAL | parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
					ParameterValue parameterValue = new ParameterValue();
					parameterValue.parameter = parameter;
					parameterValue.values = this.takeTokens(argumentPins.get(pinNumber - 1));
					callExecution.setParameterValue(parameterValue);
					pinNumber = pinNumber + 1;
				}
				i = i + 1;
			}
			callExecution.execute();
			List<ParameterValue> outputParameterValues = callExecution.getOutputParameterValues();
			pinNumber = 1;
			i = 1;
			while(i <= parameters.size()) {
				Parameter parameter = parameters.get(i - 1);
				if((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
					for(int j = 0; j < outputParameterValues.size(); j++) {
						ParameterValue outputParameterValue = outputParameterValues.get(j);
						if(outputParameterValue.parameter == parameter) {
							OutputPin resultPin = resultPins.get(pinNumber - 1);
							this.putTokens(resultPin, outputParameterValue.values);
						}
					}
					pinNumber = pinNumber + 1;
				}
				i = i + 1;
			}
			callExecution.destroy();
			this.removeCallExecution(callExecution);
		}
	}

	public abstract Execution getCallExecution();

	public void terminate() {
		// Terminate all call executions (if any), then terminate the call
		// action activation (self).
		for(int i = 0; i < this.callExecutions.size(); i++) {
			Execution execution = this.callExecutions.get(i);
			execution.terminate();
		}
		super.terminate();
	}

	public void removeCallExecution(Execution execution) {
		// Remove the given execution from the current list of call executions.
		boolean notFound = true;
		int i = 1;
		while(notFound & i <= this.callExecutions.size()) {
			if(this.callExecutions.get(i - 1) == execution) {
				this.callExecutions.remove(i - 1);
				notFound = false;
			}
		}
	}
}
