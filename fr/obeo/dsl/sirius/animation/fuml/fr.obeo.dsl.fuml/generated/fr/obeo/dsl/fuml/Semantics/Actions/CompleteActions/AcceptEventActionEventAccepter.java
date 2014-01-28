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

import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.EventAccepter;
import fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;

public class AcceptEventActionEventAccepter extends EventAccepter {

	/*
	 * The accept event action activation on behalf of which this event accepter
	 * is waiting.
	 */
	public AcceptEventActionActivation actionActivation;

	public void accept(SignalInstance signalInstance) {
		// Accept a signal occurance for the given signal instance.
		// Forward the signal occuranceto the action activation.
		this.actionActivation.accept(signalInstance);
	}

	public Boolean match(SignalInstance signalInstance) {
		// Return true if the given signal instance matches a trigger of the
		// accept action of the action activation.
		return this.actionActivation.match(signalInstance);
	}
}
