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
 * A representation of the model object '<em><b>Mo CComponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * MoCComponent: abstract structural component, that is specialized into Basic and Composite components.
 * The MoCComponent are virtual parallel entities used for the hierarchical description of topologies, but also as support for the mechanisms of execution control. The MoCComponent represent atomic and composite components. These two types of components have similar properties such as the ability to define sets of ports and to carry
 * behaviors used for execution control. However, when they are defined separately, atomic and composite components provide different properties.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent#getOwnedPortInstances <em>Owned Port Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCComponent()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface MoCComponent extends StructureElement {
	/**
	 * Returns the value of the '<em><b>Owned Port Instances</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Port Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Port Instances</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage#getMoCComponent_OwnedPortInstances()
	 * @model containment="true"
	 * @generated
	 */
	EList<MoCPort> getOwnedPortInstances();

} // MoCComponent
