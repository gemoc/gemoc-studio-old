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
package org.gemoc.mocc.cometaccsl.model.cometa;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getDataLib <em>Data Lib</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getStructureLib <em>Structure Lib</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getTimeLib <em>Time Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getCometaSystemSpecification()
 * @model
 * @generated
 */
public interface CometaSystemSpecification extends MoCSystemSpecification {
	/**
	 * Returns the value of the '<em><b>Data Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Lib</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Lib</em>' containment reference.
	 * @see #setDataLib(DataTypeLibrary)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getCometaSystemSpecification_DataLib()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeLibrary getDataLib();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getDataLib <em>Data Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Lib</em>' containment reference.
	 * @see #getDataLib()
	 * @generated
	 */
	void setDataLib(DataTypeLibrary value);

	/**
	 * Returns the value of the '<em><b>Structure Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structure Lib</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure Lib</em>' containment reference.
	 * @see #setStructureLib(StructureLibrary)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getCometaSystemSpecification_StructureLib()
	 * @model containment="true"
	 * @generated
	 */
	StructureLibrary getStructureLib();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getStructureLib <em>Structure Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure Lib</em>' containment reference.
	 * @see #getStructureLib()
	 * @generated
	 */
	void setStructureLib(StructureLibrary value);

	/**
	 * Returns the value of the '<em><b>Time Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Lib</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Lib</em>' containment reference.
	 * @see #setTimeLib(TimeLibrary)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getCometaSystemSpecification_TimeLib()
	 * @model containment="true"
	 * @generated
	 */
	TimeLibrary getTimeLib();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getTimeLib <em>Time Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Lib</em>' containment reference.
	 * @see #getTimeLib()
	 * @generated
	 */
	void setTimeLib(TimeLibrary value);

} // CometaSystemSpecification
