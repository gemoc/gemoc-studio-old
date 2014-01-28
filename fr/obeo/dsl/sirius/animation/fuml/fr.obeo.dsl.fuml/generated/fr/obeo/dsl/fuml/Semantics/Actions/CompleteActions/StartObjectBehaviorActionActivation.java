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
package fr.obeo.dsl.fuml.Semantics.Actions.CompleteActions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;

import fr.obeo.dsl.fuml.Semantics.Actions.BasicActions.InvocationActionActivation;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;

public class StartObjectBehaviorActionActivation extends InvocationActionActivation {

	public void doAction() {
		// Get the value on the object input pin. If it is not a reference, then
		// do nothing.
		// Start the behavior of the referent object for the classifier given as
		// the type of the object input pin, with parameter values taken from
		// the argument input pins.
		// If the object input pin has no type, then start the classifier
		// behaviors of all types of the referent object.
		StartObjectBehaviorAction action = (StartObjectBehaviorAction)(this.node);
		Value object = this.takeTokens(action.getObject()).get(0);
		if(object instanceof Reference) {
			Class type = (Class)(action.getObject().getType());
			List<InputPin> argumentPins = action.getArguments();
			List<ParameterValue> inputs = new ArrayList<ParameterValue>();
			if(type != null) {
				Behavior behavior;
				if(type instanceof Behavior) {
					behavior = (Behavior)type;
				} else {
					behavior = type.getClassifierBehavior();
				}
				if(behavior != null) {
					List<Parameter> parameters = behavior.getOwnedParameters();
					int pinNumber = 1;
					int i = 1;
					while(i <= parameters.size()) {
						Parameter parameter = parameters.get(i - 1);
						int j = pinNumber;
						if(parameter.getDirection() == ParameterDirectionKind.IN_LITERAL | parameter.getDirection() == ParameterDirectionKind.INOUT_LITERAL) {
							ParameterValue parameterValue = new ParameterValue();
							parameterValue.parameter = parameter;
							parameterValue.values = this.takeTokens(argumentPins.get(j - 1));
							inputs.add(parameterValue);
							j = j + 1;
						}
						pinNumber = j;
						i = i + 1;
					}
				}
			}
			((Reference)object).startBehavior(type, inputs);
		}
	}
}
