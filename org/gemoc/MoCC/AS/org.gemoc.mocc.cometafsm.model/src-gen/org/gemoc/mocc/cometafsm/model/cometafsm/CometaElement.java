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
package org.gemoc.mocc.cometafsm.model.cometafsm;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cometa Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.CometaElement#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.CometaElement#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getCometaElement()
 * @model abstract="true"
 * @generated
 */
public interface CometaElement extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getCometaElement_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometafsm.model.cometafsm.CometaElement#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' attribute.
	 * @see #setDefinition(String)
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getCometaElement_Definition()
	 * @model
	 * @generated
	 */
	String getDefinition();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometafsm.model.cometafsm.CometaElement#getDefinition <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' attribute.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(String value);

} // CometaElement
