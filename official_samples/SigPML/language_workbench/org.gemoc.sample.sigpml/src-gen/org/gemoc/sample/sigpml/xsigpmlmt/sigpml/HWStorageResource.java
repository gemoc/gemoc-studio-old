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
 * A representation of the model object '<em><b>HW Storage Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWStorageResource#getAllocatedPlaces <em>Allocated Places</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWStorageResource()
 * @model
 * @generated
 */
public interface HWStorageResource extends HWRessource {
	/**
	 * Returns the value of the '<em><b>Allocated Places</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Place}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Places</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Places</em>' reference list.
	 * @see org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage#getHWStorageResource_AllocatedPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getAllocatedPlaces();

} // HWStorageResource
