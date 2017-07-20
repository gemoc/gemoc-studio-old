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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort#getSizeWritten <em>Size Written</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends Port {
	/**
	 * Returns the value of the '<em><b>Size Written</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size Written</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size Written</em>' attribute.
	 * @see #setSizeWritten(int)
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getOutputPort_SizeWritten()
	 * @model unique="false"
	 * @generated
	 */
	int getSizeWritten();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort#getSizeWritten <em>Size Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size Written</em>' attribute.
	 * @see #getSizeWritten()
	 * @generated
	 */
	void setSizeWritten(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void write();

} // OutputPort
