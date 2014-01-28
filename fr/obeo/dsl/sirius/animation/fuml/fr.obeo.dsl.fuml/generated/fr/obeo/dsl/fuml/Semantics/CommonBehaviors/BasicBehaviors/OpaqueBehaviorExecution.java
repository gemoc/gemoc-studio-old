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

import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;

import fr.obeo.dsl.fuml.debug.Debug;

public abstract class OpaqueBehaviorExecution extends Execution {

	public void execute() {
		// Execute the body of the opaque behavior.
		Debug.println("[execute] Opaque behavior " + this.getBehavior().getName() + "...");
		List<Parameter> parameters = this.getBehavior().getOwnedParameters();
		List<ParameterValue> inputs = new ArrayList<ParameterValue>();
		List<ParameterValue> outputs = new ArrayList<ParameterValue>();
		for(int i = 0; i < parameters.size(); i++) {
			Parameter parameter = parameters.get(i);
			if((parameter.getDirection() == ParameterDirectionKind.IN_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL)) {
				inputs.add(this.getParameterValue(parameter));
			}
			if((parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.OUT_LITERAL) | (parameter.getDirection() == ParameterDirectionKind.RETURN_LITERAL)) {
				ParameterValue parameterValue = new ParameterValue();
				parameterValue.parameter = parameter;
				this.setParameterValue(parameterValue);
				outputs.add(parameterValue);
			}
		}
		this.doBody(inputs, outputs);
	}

	public abstract void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters);
}
