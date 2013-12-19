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

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.TypeDeclaration;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Parameter is an abstract concept of the meta-model that aims to capture variables, parameters. A Parameter has a value (Block) and a type (Type). The value represents
 * the data stored by the variable. The type represents the type of the stored value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getParameter()
 * @model extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface Parameter extends NamedElement, RTInterface {
	/**
	 * Returns the value of the '<em><b>Parameter Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Type</em>' reference.
	 * @see #setParameterType(TypeDeclaration)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getParameter_ParameterType()
	 * @model
	 * @generated
	 */
	TypeDeclaration getParameterType();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getParameterType <em>Parameter Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Type</em>' reference.
	 * @see #getParameterType()
	 * @generated
	 */
	void setParameterType(TypeDeclaration value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OpaqueBlock)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getParameter_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OpaqueBlock getValue();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OpaqueBlock value);

} // Parameter
