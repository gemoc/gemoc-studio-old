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

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain <em>Moc Domain</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getQueueInstances <em>Queue Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRtInterfaces <em>Rt Interfaces</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getBehaviorTimeConstraints <em>Behavior Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Behavior extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' attribute list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole}.
	 * The literals are from the enumeration {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The < role > function is defined to associate the following roles (SchedulingBehavior, PortBehavior, ConnectorBehavior) with the different behaviors, making explicit what they can be used for.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Roles</em>' attribute list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior_Roles()
	 * @model
	 * @generated
	 */
	EList<MoCRole> getRoles();

	/**
	 * Returns the value of the '<em><b>Moc Domain</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getMocBehaviors <em>Moc Behaviors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Domain</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Domain</em>' container reference.
	 * @see #setMocDomain(MoCDomain)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior_MocDomain()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getMocBehaviors
	 * @model opposite="mocBehaviors" required="true" derived="true"
	 *        extendedMetaData="name='mocDomain'"
	 * @generated
	 */
	MoCDomain getMocDomain();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain <em>Moc Domain</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moc Domain</em>' container reference.
	 * @see #getMocDomain()
	 * @generated
	 */
	void setMocDomain(MoCDomain value);

	/**
	 * Returns the value of the '<em><b>Queue Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Instances</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior_QueueInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<QueueInstance> getQueueInstances();

	/**
	 * Returns the value of the '<em><b>Rt Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rt Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rt Interfaces</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior_RtInterfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<RTInterface> getRtInterfaces();

	/**
	 * Returns the value of the '<em><b>Behavior Time Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Time Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Time Constraints</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getBehavior_BehaviorTimeConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimeConstraint> getBehaviorTimeConstraints();

} // Behavior
