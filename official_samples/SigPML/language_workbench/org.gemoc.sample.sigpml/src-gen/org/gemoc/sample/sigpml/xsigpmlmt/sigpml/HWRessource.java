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
package org.gemoc.sample.sigpml.xsigpmlmt.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Ressource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWRessource()
 * @model abstract="true"
 * @generated
 */
public interface HWRessource extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(HWPlatform)
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWRessource_Owner()
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform#getOwnedHWResources
	 * @model opposite="ownedHWResources" transient="false"
	 * @generated
	 */
	HWPlatform getOwner();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(HWPlatform value);

	/**
	 * Returns the value of the '<em><b>Connected To</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected To</em>' reference list.
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWRessource_ConnectedTo()
	 * @model
	 * @generated
	 */
	EList<HWRessource> getConnectedTo();

} // HWRessource
