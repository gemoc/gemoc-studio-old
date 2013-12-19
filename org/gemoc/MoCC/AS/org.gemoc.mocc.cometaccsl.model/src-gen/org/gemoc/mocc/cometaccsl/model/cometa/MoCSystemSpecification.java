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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mo CSystem Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification#getMocLib <em>Moc Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getMoCSystemSpecification()
 * @model
 * @generated
 */
public interface MoCSystemSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Moc Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Lib</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Lib</em>' containment reference.
	 * @see #setMocLib(MoCLibrary)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage#getMoCSystemSpecification_MocLib()
	 * @model containment="true"
	 * @generated
	 */
	MoCLibrary getMocLib();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification#getMocLib <em>Moc Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moc Lib</em>' containment reference.
	 * @see #getMocLib()
	 * @generated
	 */
	void setMocLib(MoCLibrary value);

} // MoCSystemSpecification
