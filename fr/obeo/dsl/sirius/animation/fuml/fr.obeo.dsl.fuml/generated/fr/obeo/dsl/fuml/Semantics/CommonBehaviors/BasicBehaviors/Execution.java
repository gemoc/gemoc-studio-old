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
package fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Object_;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;

public abstract class Execution extends Object_ {

	/*
	 * The object that provides the context for this execution. The type of the
	 * context of the execution must be the context of the type (behavior) of
	 * the execution.
	 */
	public Object_ context;

	/*
	 * The parameterValues for this execution. All parameterValues must have a
	 * parameter that is a parameter of the type of this execution. The values
	 * of all input (in and in-out) parameters must be set before the execution
	 * is executed.
	 */
	public List<ParameterValue> parameterValues = new ArrayList<ParameterValue>();

	public abstract void execute();

	public void terminate() {
		// Terminate an ongoing execution. By default, do nothing.
		return;
	}

	public Value copy() {
		// Create a new execution that has the same behavior and parameterValues
		// as this execution.
		// Debug.println("[Copy] execution = " + this);
		Execution newValue = (Execution)(super.copy());
		newValue.context = this.context;
		List<ParameterValue> parameterValues = this.parameterValues;
		for(int i = 0; i < parameterValues.size(); i++) {
			ParameterValue parameterValue = parameterValues.get(i);
			newValue.parameterValues.add(parameterValue.copy());
		}
		// Debug.println("[Copy] Done.");
		return newValue;
	}

	public abstract Value new_();

	public void setParameterValue(ParameterValue parameterValue) {
		// Set the given parameter value for this execution.
		// If a parameter value already existed for the parameter of the given
		// parameter value, then replace its value.
		// Debug.println("[setParameterValue] parameter = " +
		// parameterValue.parameter.name + " with " +
		// parameterValue.values.size() + " values");
		ParameterValue existingParameterValue = this.getParameterValue(parameterValue.parameter);
		if(existingParameterValue == null) {
			this.parameterValues.add(parameterValue);
		} else {
			existingParameterValue.values = parameterValue.values;
		}
	}

	public ParameterValue getParameterValue(Parameter parameter) {
		// Get the parameter value of this execution corresponding to the given
		// parameter (if any).
		ParameterValue parameterValue = null;
		int i = 1;
		while(parameterValue == null & i <= this.parameterValues.size()) {
			if(this.parameterValues.get(i - 1).parameter == parameter) {
				parameterValue = this.parameterValues.get(i - 1);
			}
			i = i + 1;
		}
		return parameterValue;
	}

	public List<ParameterValue> getOutputParameterValues() {
		// Return the parameter values for output (in-out, out and return)
		// parameters.
		List<ParameterValue> outputs = new ArrayList<ParameterValue>();
		List<ParameterValue> parameterValues = this.parameterValues;
		for(int i = 0; i < parameterValues.size(); i++) {
			ParameterValue parameterValue = parameterValues.get(i);
			Parameter parameter = parameterValue.parameter;
			if((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				outputs.add(parameterValue);
			}
		}
		return outputs;
	}

	public Behavior getBehavior() {
		// Get the behavior that is the type of this execution.
		return (Behavior)(this.getTypes().get(0));
	}
}
