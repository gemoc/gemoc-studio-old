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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A StructureContainer represents a possible configuration of interconnected components. Indeed, it allows describing new components, connectors and the mechanisms of
 * the components interconnections.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getConnectorInstances <em>Connector Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getComponentInstances <em>Component Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getPortInstances <em>Port Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureContainer()
 * @model
 * @generated
 */
public interface StructureContainer extends NamedElement, Container {
	/**
	 * Returns the value of the '<em><b>Connector Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connector Instances</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureContainer_ConnectorInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCConnector> getConnectorInstances();

	/**
	 * Returns the value of the '<em><b>Component Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instances</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureContainer_ComponentInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCComponent> getComponentInstances();

	/**
	 * Returns the value of the '<em><b>Port Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Instances</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getStructureContainer_PortInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCPort> getPortInstances();

} // StructureContainer
