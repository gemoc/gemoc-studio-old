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
package org.gemoc.mocc.fsmkernel.model.FSMModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getConcreteEntities <em>Concrete Entities</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.DeclarationBlock#getClassicalExpressions <em>Classical Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getDeclarationBlock()
 * @model
 * @generated
 */
public interface DeclarationBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Concrete Entities</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Entities</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Entities</em>' containment reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getDeclarationBlock_ConcreteEntities()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<ConcreteEntity> getConcreteEntities();

	/**
	 * Returns the value of the '<em><b>Classical Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classical Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classical Expressions</em>' containment reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getDeclarationBlock_ClassicalExpressions()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<ClassicalExpression> getClassicalExpressions();

} // DeclarationBlock
