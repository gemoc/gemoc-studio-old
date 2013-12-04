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


import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cometa Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger#getTriggOn <em>Trigg On</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaTrigger()
 * @model
 * @generated
 */
public interface CometaTrigger extends Trigger {
	/**
	 * Returns the value of the '<em><b>Trigg On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigg On</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigg On</em>' reference.
	 * @see #setTriggOn(Event)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage#getCometaTrigger_TriggOn()
	 * @model required="true"
	 * @generated
	 */
	Event getTriggOn();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger#getTriggOn <em>Trigg On</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigg On</em>' reference.
	 * @see #getTriggOn()
	 * @generated
	 */
	void setTriggOn(Event value);

} // CometaTrigger
