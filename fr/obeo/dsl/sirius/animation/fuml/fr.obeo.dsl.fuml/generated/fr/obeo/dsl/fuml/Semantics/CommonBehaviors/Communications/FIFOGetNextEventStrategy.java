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
package fr.obeo.dsl.fuml.Semantics.CommonBehaviors.Communications;

public class FIFOGetNextEventStrategy extends GetNextEventStrategy {

	public SignalInstance getNextEvent(ObjectActivation objectActivation) {
		// Get the first event from the given event pool. The event is removed
		// from the pool.
		SignalInstance signalInstance = objectActivation.eventPool.get(0);
		objectActivation.eventPool.remove(0);
		return signalInstance;
	}
}
