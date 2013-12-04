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

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mo CDomain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A MoCDomain is a concept reifying the notion of MoC modeling space. A MoC modeling space captures all of the rules, properties and semantics specific to a MoC.
 * The captured rules include operational behaviors defined through the notion of Behavior.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getMocBehaviors <em>Moc Behaviors</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getDomainTimeConstraints <em>Domain Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getMoCDomain()
 * @model
 * @generated
 */
public interface MoCDomain extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Moc Behaviors</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain <em>Moc Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Behaviors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Behaviors</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getMoCDomain_MocBehaviors()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain
	 * @model opposite="mocDomain" containment="true"
	 * @generated
	 */
	EList<Behavior> getMocBehaviors();

	/**
	 * Returns the value of the '<em><b>Domain Time Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Time Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Time Constraints</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getMoCDomain_DomainTimeConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimeConstraint> getDomainTimeConstraints();

} // MoCDomain
