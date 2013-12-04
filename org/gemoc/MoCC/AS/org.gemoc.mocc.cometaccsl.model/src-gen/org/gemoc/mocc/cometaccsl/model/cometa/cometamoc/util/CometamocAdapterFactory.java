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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.*;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage
 * @generated
 */
public class CometamocAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CometamocPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometamocAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CometamocPackage.eINSTANCE;
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
	protected CometamocSwitch<Adapter> modelSwitch =
		new CometamocSwitch<Adapter>() {
			@Override
			public Adapter caseQueue(Queue object) {
				return createQueueAdapter();
			}
			@Override
			public Adapter caseCometaMoCLibrary(CometaMoCLibrary object) {
				return createCometaMoCLibraryAdapter();
			}
			@Override
			public Adapter caseMoCDomain(MoCDomain object) {
				return createMoCDomainAdapter();
			}
			@Override
			public Adapter caseBehavior(Behavior object) {
				return createBehaviorAdapter();
			}
			@Override
			public Adapter caseOpaqueBlock(OpaqueBlock object) {
				return createOpaqueBlockAdapter();
			}
			@Override
			public Adapter caseOpaqueBehavior(OpaqueBehavior object) {
				return createOpaqueBehaviorAdapter();
			}
			@Override
			public Adapter caseMoCEvent(MoCEvent object) {
				return createMoCEventAdapter();
			}
			@Override
			public Adapter caseQueueInstance(QueueInstance object) {
				return createQueueInstanceAdapter();
			}
			@Override
			public Adapter caseFiniteStateMachineBehavior(FiniteStateMachineBehavior object) {
				return createFiniteStateMachineBehaviorAdapter();
			}
			@Override
			public Adapter caseCometaGuard(CometaGuard object) {
				return createCometaGuardAdapter();
			}
			@Override
			public Adapter caseCometaAction(CometaAction object) {
				return createCometaActionAdapter();
			}
			@Override
			public Adapter caseCometaTrigger(CometaTrigger object) {
				return createCometaTriggerAdapter();
			}
			@Override
			public Adapter caseMoCLibrary(MoCLibrary object) {
				return createMoCLibraryAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseElementAbstraction(ElementAbstraction object) {
				return createElementAbstractionAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseFiniteStateMachine(FiniteStateMachine object) {
				return createFiniteStateMachineAdapter();
			}
			@Override
			public Adapter caseGuard(Guard object) {
				return createGuardAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue <em>Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue
	 * @generated
	 */
	public Adapter createQueueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary <em>Cometa Mo CLibrary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary
	 * @generated
	 */
	public Adapter createCometaMoCLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain <em>Mo CDomain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain
	 * @generated
	 */
	public Adapter createMoCDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior
	 * @generated
	 */
	public Adapter createBehaviorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior <em>Opaque Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior
	 * @generated
	 */
	public Adapter createOpaqueBehaviorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent <em>Mo CEvent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent
	 * @generated
	 */
	public Adapter createMoCEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance <em>Queue Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance
	 * @generated
	 */
	public Adapter createQueueInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior <em>Finite State Machine Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior
	 * @generated
	 */
	public Adapter createFiniteStateMachineBehaviorAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger <em>Cometa Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger
	 * @generated
	 */
	public Adapter createCometaTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary <em>Mo CLibrary</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary
	 * @generated
	 */
	public Adapter createMoCLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine <em>Finite State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine
	 * @generated
	 */
	public Adapter createFiniteStateMachineAdapter() {
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

} //CometamocAdapterFactory
