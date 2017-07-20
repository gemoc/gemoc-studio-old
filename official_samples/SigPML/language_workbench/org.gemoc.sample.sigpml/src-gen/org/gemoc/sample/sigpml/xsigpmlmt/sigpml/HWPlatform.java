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
 * A representation of the model object '<em><b>HW Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWPlatform()
 * @model
 * @generated
 */
public interface HWPlatform extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned HW Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned HW Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned HW Resources</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWPlatform_OwnedHWResources()
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<HWRessource> getOwnedHWResources();

} // HWPlatform
