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

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * StructureLibrary: is uniquely defined to contain the library of semantic layers described at the topological level. The networks of interconnected components forms the semantic layer. The library allows describing several containers of topologies (StructureContainer, CompositeComponent) and atomic (BasiCComponent) components. In Cometa, each StructureContainer represents a semantic layer.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocStructures <em>Moc Structures</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocInterfaces <em>Moc Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureLibrary()
 * @model
 * @generated
 */
public interface StructureLibrary extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Moc Structures</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Structures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Structures</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureLibrary_MocStructures()
	 * @model containment="true"
	 * @generated
	 */
	EList<StructureContainer> getMocStructures();

	/**
	 * Returns the value of the '<em><b>Moc Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moc Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moc Interfaces</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureLibrary_MocInterfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCInterface> getMocInterfaces();

} // StructureLibrary
