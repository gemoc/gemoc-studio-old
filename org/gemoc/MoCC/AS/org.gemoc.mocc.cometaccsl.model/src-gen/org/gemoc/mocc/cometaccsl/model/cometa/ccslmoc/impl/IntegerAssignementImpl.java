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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.impl.BinaryIntegerExpressionImpl;

import org.eclipse.emf.ecore.EClass;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Assignement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class IntegerAssignementImpl extends BinaryIntegerExpressionImpl implements IntegerAssignement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerAssignementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CcslmocPackage.Literals.INTEGER_ASSIGNEMENT;
	}

} //IntegerAssignementImpl
