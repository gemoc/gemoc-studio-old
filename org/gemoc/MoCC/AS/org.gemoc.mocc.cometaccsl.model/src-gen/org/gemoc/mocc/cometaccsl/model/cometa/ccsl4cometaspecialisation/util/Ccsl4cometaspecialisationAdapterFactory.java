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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.*;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage
 * @generated
 */
public class Ccsl4cometaspecialisationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Ccsl4cometaspecialisationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ccsl4cometaspecialisationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Ccsl4cometaspecialisationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Ccsl4cometaspecialisationSwitch<Adapter> modelSwitch =
		new Ccsl4cometaspecialisationSwitch<Adapter>() {
			@Override
			public Adapter caseCCSL4CometaClock(CCSL4CometaClock object) {
				return createCCSL4CometaClockAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaBlockAbstraction(CCSL4CometaBlockAbstraction object) {
				return createCCSL4CometaBlockAbstractionAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaTimeConstraint(CCSL4CometaTimeConstraint object) {
				return createCCSL4CometaTimeConstraintAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaComplexTrigger(CCSL4CometaComplexTrigger object) {
				return createCCSL4CometaComplexTriggerAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaCometaSystemSpecification(CCSL4CometaCometaSystemSpecification object) {
				return createCCSL4CometaCometaSystemSpecificationAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaGuard(CCSL4CometaGuard object) {
				return createCCSL4CometaGuardAdapter();
			}
			@Override
			public Adapter caseCCSL4CometaAction(CCSL4CometaAction object) {
				return createCCSL4CometaActionAdapter();
			}
			@Override
			public Adapter caseElementAbstraction(ElementAbstraction object) {
				return createElementAbstractionAdapter();
			}
			@Override
			public Adapter caseClockAbstraction(ClockAbstraction object) {
				return createClockAbstractionAdapter();
			}
			@Override
			public Adapter caseOpaqueBlock(OpaqueBlock object) {
				return createOpaqueBlockAdapter();
			}
			@Override
			public Adapter caseTimeConstraint(TimeConstraint object) {
				return createTimeConstraintAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
			}
			@Override
			public Adapter caseMoCSystemSpecification(MoCSystemSpecification object) {
				return createMoCSystemSpecificationAdapter();
			}
			@Override
			public Adapter caseCometaSystemSpecification(CometaSystemSpecification object) {
				return createCometaSystemSpecificationAdapter();
			}
			@Override
			public Adapter caseGuard(Guard object) {
				return createGuardAdapter();
			}
			@Override
			public Adapter caseCometaGuard(CometaGuard object) {
				return createCometaGuardAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseCometaAction(CometaAction object) {
				return createCometaActionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaClock <em>CCSL4 Cometa Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaClock
	 * @generated
	 */
	public Adapter createCCSL4CometaClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaBlockAbstraction <em>CCSL4 Cometa Block Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaBlockAbstraction
	 * @generated
	 */
	public Adapter createCCSL4CometaBlockAbstractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaTimeConstraint <em>CCSL4 Cometa Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaTimeConstraint
	 * @generated
	 */
	public Adapter createCCSL4CometaTimeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger <em>CCSL4 Cometa Complex Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaComplexTrigger
	 * @generated
	 */
	public Adapter createCCSL4CometaComplexTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification <em>CCSL4 Cometa Cometa System Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaCometaSystemSpecification
	 * @generated
	 */
	public Adapter createCCSL4CometaCometaSystemSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaGuard <em>CCSL4 Cometa Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaGuard
	 * @generated
	 */
	public Adapter createCCSL4CometaGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaAction <em>CCSL4 Cometa Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.CCSL4CometaAction
	 * @generated
	 */
	public Adapter createCCSL4CometaActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction <em>Element Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction
	 * @generated
	 */
	public Adapter createElementAbstractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction <em>Clock Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction
	 * @generated
	 */
	public Adapter createClockAbstractionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock <em>Opaque Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock
	 * @generated
	 */
	public Adapter createOpaqueBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint <em>Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint
	 * @generated
	 */
	public Adapter createTimeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger
	 * @generated
	 */
	public Adapter createTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification <em>Mo CSystem Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification
	 * @generated
	 */
	public Adapter createMoCSystemSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification <em>System Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification
	 * @generated
	 */
	public Adapter createCometaSystemSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard
	 * @generated
	 */
	public Adapter createGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard <em>Cometa Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard
	 * @generated
	 */
	public Adapter createCometaGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction <em>Cometa Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction
	 * @generated
	 */
	public Adapter createCometaActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Ccsl4cometaspecialisationAdapterFactory
