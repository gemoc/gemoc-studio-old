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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * CompositeComponent: A CompositeComponent objectifies the notion of hierarchy and "white-box". It allows hiding his sub-topologies associated with its description
 * (sub-topologies are not seen as black-boxes). A CompositeComponent has the same properties as a StructureContainer with the difference that it possibly has ports and behavior when interconnected with other components of the same hierarchical level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getSubComponents <em>Sub Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getCompositeComponent()
 * @model
 * @generated
 */
public interface CompositeComponent extends MoCComponent, Container {
	/**
	 * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectors</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getCompositeComponent_Connectors()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCConnector> getConnectors();

	/**
	 * Returns the value of the '<em><b>Sub Components</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Components</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getCompositeComponent_SubComponents()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCComponent> getSubComponents();

} // CompositeComponent
