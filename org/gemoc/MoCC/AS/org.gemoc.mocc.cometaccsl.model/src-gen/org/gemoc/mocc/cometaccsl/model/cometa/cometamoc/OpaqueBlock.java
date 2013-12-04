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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A Block in Cometa helps to define a sequence of instructions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock#getRtElements <em>Rt Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getOpaqueBlock()
 * @model abstract="true"
 * @generated
 */
public interface OpaqueBlock extends ElementAbstraction {
	/**
	 * Returns the value of the '<em><b>Rt Elements</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rt Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rt Elements</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getOpaqueBlock_RtElements()
	 * @model
	 * @generated
	 */
	EList<RTInterface> getRtElements();

} // OpaqueBlock
