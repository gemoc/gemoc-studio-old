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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mo CConnector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MoCConnector: represents the set of connectors that can be defined from the structure abstract syntax. The connectors allow linking the components of the topology.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getSource <em>Source</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCConnector()
 * @model
 * @generated
 */
public interface MoCConnector extends StructureElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(MoCPort)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCConnector_Source()
	 * @model required="true"
	 * @generated
	 */
	MoCPort getSource();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(MoCPort value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(MoCPort)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCConnector_Target()
	 * @model required="true"
	 * @generated
	 */
	MoCPort getTarget();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(MoCPort value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind
	 * @see #setKind(MoCConnectorKind)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCConnector_Kind()
	 * @model required="true"
	 * @generated
	 */
	MoCConnectorKind getKind();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MoCConnectorKind value);

} // MoCConnector
