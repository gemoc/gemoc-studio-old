/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
/**
 */
package org.gemoc.sample.sigpml.xsigpml.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.Application#getOwnedPlaces <em>Owned Places</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Agents</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpml.sigpml.Agent}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Agents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Agents</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getApplication_OwnedAgents()
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.Agent#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Agent> getOwnedAgents();

	/**
	 * Returns the value of the '<em><b>Owned Places</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpml.sigpml.Place}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Places</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Places</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getApplication_OwnedPlaces()
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.Place#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Place> getOwnedPlaces();

} // Application
