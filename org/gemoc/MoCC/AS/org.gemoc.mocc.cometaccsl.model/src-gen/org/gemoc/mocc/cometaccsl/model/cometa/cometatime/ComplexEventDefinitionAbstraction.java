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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime;

import org.eclipse.emf.common.util.EList;

import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Event Definition Abstraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getComplexEventDefinitionAbstraction()
 * @model abstract="true"
 *        extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface ComplexEventDefinitionAbstraction extends ElementAbstraction {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyTrigger <em>Is Referedby Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getComplexEventDefinitionAbstraction_Uses()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyTrigger
	 * @model opposite="isReferedbyTrigger"
	 * @generated
	 */
	EList<ClockAbstraction> getUses();

} // ComplexEventDefinitionAbstraction
