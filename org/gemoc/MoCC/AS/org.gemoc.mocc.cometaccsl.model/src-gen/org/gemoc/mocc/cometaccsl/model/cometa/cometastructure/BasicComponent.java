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

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * BasicComponent: atomic components of a structure Cometa. Unlike the composite components, the BasicComponent are the entities directly interfaced with the application
 * blocks.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent#getComputation <em>Computation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getBasicComponent()
 * @model
 * @generated
 */
public interface BasicComponent extends MoCComponent {
	/**
	 * Returns the value of the '<em><b>Computation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation</em>' containment reference.
	 * @see #setComputation(OpaqueBlock)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getBasicComponent_Computation()
	 * @model containment="true"
	 * @generated
	 */
	OpaqueBlock getComputation();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent#getComputation <em>Computation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Computation</em>' containment reference.
	 * @see #getComputation()
	 * @generated
	 */
	void setComputation(OpaqueBlock value);

} // BasicComponent
