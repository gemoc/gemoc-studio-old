/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
/**
 */
package org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.impl;

import org.eclipse.emf.ecore.EClass;

import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Guard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class GuardImpl extends NamedElementImpl implements Guard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.GUARD;
	}

} //GuardImpl
