/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mo CEvent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The concept of MoCEvent is used to describe the communication events between FSMs of a semantic layer. For example, the distribution of control over ports and
 * connectors involves the use of these events as triggers for state changes in ports and connectors. These events are dissociated with interface events that are directly related to the application blocks.
 * <!-- end-model-doc -->
 *
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getMoCEvent()
 * @model
 * @generated
 */
public interface MoCEvent extends NamedElement, Event {
} // MoCEvent
