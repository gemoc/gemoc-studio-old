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

import java.util.List;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;

import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Reference;
import fr.obeo.dsl.fuml.Semantics.Classes.Kernel.Value;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;

public class SendSignalActionActivation extends InvocationActionActivation {

	public void doAction() {
		// Get the value from the target pin. If the value is not a reference,
		// then do nothing.
		// Otherwise, construct a signal using the values from the argument pins
		// and send it to the referent object.
		SendSignalAction action = (SendSignalAction)(this.node);
		Value target = this.takeTokens(action.getTarget()).get(0);
		if(target instanceof Reference) {
			Signal signal = action.getSignal();
			SignalInstance signalInstance = new SignalInstance();
			signalInstance.type = signal;
			List<Property> attributes = signal.getOwnedAttributes();
			List<InputPin> argumentPins = action.getArguments();
			for(int i = 0; i < attributes.size(); i++) {
				Property attribute = attributes.get(i);
				InputPin argumentPin = argumentPins.get(i);
				List<Value> values = this.takeTokens(argumentPin);
				signalInstance.setFeatureValue(attribute, values, 0);
			}
			((Reference)target).send(signalInstance);
		}
	}
}
