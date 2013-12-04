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

import org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cometa Mo CLibrary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MoCLibrary represents the unique library of MoC domains from Cometa.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocDomains <em>Moc Domains</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocEvents <em>Moc Events</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getQueues <em>Queues</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaMoCLibrary()
 * @model
 * @generated
 */
public interface CometaMoCLibrary extends MoCLibrary, NamedElement {
	/**
	 * Returns the value of the '<em><b>Moc Domains</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Domains</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Domains</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaMoCLibrary_MocDomains()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCDomain> getMocDomains();

	/**
	 * Returns the value of the '<em><b>Moc Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Events</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaMoCLibrary_MocEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCEvent> getMocEvents();

	/**
	 * Returns the value of the '<em><b>Queues</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queues</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queues</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaMoCLibrary_Queues()
	 * @model containment="true"
	 * @generated
	 */
	EList<Queue> getQueues();

} // CometaMoCLibrary
