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
package org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary#getTypedef <em>Typedef</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage#getDataTypeLibrary()
 * @model
 * @generated
 */
public interface DataTypeLibrary extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Typedef</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.TypeDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typedef</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typedef</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage#getDataTypeLibrary_Typedef()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeDeclaration> getTypedef();

} // DataTypeLibrary
