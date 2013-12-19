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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Send event, This abstraction allows describing the sending events. The sending events are the result of data sending requests emitted by an entity behavior. These
 * events can be parameterized. The parameters are used to specify the receiver of the request, the communication connector, or the data to be transmitted, etc.
 * <!-- end-model-doc -->
 *
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getSend()
 * @model extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface Send extends MoCInterface, Event {
} // Send
