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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CCSL4 Cometa Cometa System Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification#getCcslLib <em>Ccsl Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage#getCCSL4CometaCometaSystemSpecification()
 * @model
 * @generated
 */
public interface CCSL4CometaCometaSystemSpecification extends CometaSystemSpecification {
	/**
	 * Returns the value of the '<em><b>Ccsl Lib</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ccsl Lib</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ccsl Lib</em>' reference.
	 * @see #setCcslLib(Library)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage#getCCSL4CometaCometaSystemSpecification_CcslLib()
	 * @model
	 * @generated
	 */
	Library getCcslLib();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification#getCcslLib <em>Ccsl Lib</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ccsl Lib</em>' reference.
	 * @see #getCcslLib()
	 * @generated
	 */
	void setCcslLib(Library value);

} // CCSL4CometaCometaSystemSpecification
