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
 * A representation of the model object '<em><b>Ack</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Ack event, The Ack events are sent back to the behavioral entity so they can continue their execution. The Ack are needed in all running control scenarios with Cometa.
 * They reify the notion of permission to run.
 * <!-- end-model-doc -->
 *
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getAck()
 * @model extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface Ack extends MoCInterface, Event {
} // Ack
