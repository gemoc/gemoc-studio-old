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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mo CPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MoCPort: The ports are the interconnection points for the components. Ports are connected between them by the Cometa MoCConnector.
 * The MoCConnector of Cometa are structural elements to bind the ports of the various components (Part or MoCComponent).
 *  Links to ports are defined by the <source; target > functions that combine each connector to its specific input and output ports. 
 * The connectors more substantially contribute to the definition of the mechanisms of execution control because they are carriers of behaviors to synchronize components.
 * The MoCPort can be enriched with MoC based behaviors. When applying a MoC behavior to a MoCPort, this behavior participates in the specification of the communication protocol.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getPortInterfaces <em>Port Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCPort()
 * @model
 * @generated
 */
public interface MoCPort extends StructureElement {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The <direction> property qualifies the port with a "kind" (in or out) to specify the direction of the communication.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind
	 * @see #setDirection(PortKind)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCPort_Direction()
	 * @model required="true"
	 * @generated
	 */
	PortKind getDirection();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(PortKind value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(MoCPort)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCPort_Target()
	 * @model
	 * @generated
	 */
	MoCPort getTarget();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(MoCPort value);

	/**
	 * Returns the value of the '<em><b>Port Interfaces</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Interfaces</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCPort_PortInterfaces()
	 * @model required="true" upper="2"
	 * @generated
	 */
	EList<MoCInterface> getPortInterfaces();

} // MoCPort
