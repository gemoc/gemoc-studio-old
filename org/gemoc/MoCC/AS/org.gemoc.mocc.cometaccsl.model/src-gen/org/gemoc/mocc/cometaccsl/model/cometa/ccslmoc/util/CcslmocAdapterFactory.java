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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.util;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.PrimitiveElement;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryIntegerExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExternalRelationDefinition;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDefinition;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.*;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage
 * @generated
 */
public class CcslmocAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CcslmocPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CcslmocAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CcslmocPackage.eINSTANCE;
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
	protected CcslmocSwitch<Adapter> modelSwitch =
		new CcslmocSwitch<Adapter>() {
			@Override
			public Adapter caseCCSLLibrary(CCSLLibrary object) {
				return createCCSLLibraryAdapter();
			}
			@Override
			public Adapter caseCCSLStateMachineRelationDefinition(CCSLStateMachineRelationDefinition object) {
				return createCCSLStateMachineRelationDefinitionAdapter();
			}
			@Override
			public Adapter caseCCSLAction(CCSLAction object) {
				return createCCSLActionAdapter();
			}
			@Override
			public Adapter caseFinishClock(FinishClock object) {
				return createFinishClockAdapter();
			}
			@Override
			public Adapter caseIntegerAssignement(IntegerAssignement object) {
				return createIntegerAssignementAdapter();
			}
			@Override
			public Adapter caseCCSLGuard(CCSLGuard object) {
				return createCCSLGuardAdapter();
			}
			@Override
			public Adapter caseCCSLTrigger(CCSLTrigger object) {
				return createCCSLTriggerAdapter();
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
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter caseRelationDefinition(RelationDefinition object) {
				return createRelationDefinitionAdapter();
			}
			@Override
			public Adapter caseExternalRelationDefinition(ExternalRelationDefinition object) {
				return createExternalRelationDefinitionAdapter();
			}
			@Override
			public Adapter caseFiniteStateMachine(FiniteStateMachine object) {
				return createFiniteStateMachineAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseBindableEntity(BindableEntity object) {
				return createBindableEntityAdapter();
			}
			@Override
			public Adapter caseConcreteEntity(ConcreteEntity object) {
				return createConcreteEntityAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter casePrimitiveElement(PrimitiveElement object) {
				return createPrimitiveElementAdapter();
			}
			@Override
			public Adapter caseClassicalExpression(ClassicalExpression object) {
				return createClassicalExpressionAdapter();
			}
			@Override
			public Adapter caseIntegerExpression(IntegerExpression object) {
				return createIntegerExpressionAdapter();
			}
			@Override
			public Adapter caseBinaryIntegerExpression(BinaryIntegerExpression object) {
				return createBinaryIntegerExpressionAdapter();
			}
			@Override
			public Adapter caseGuard(Guard object) {
				return createGuardAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary <em>CCSL Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary
	 * @generated
	 */
	public Adapter createCCSLLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition <em>CCSL State Machine Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLStateMachineRelationDefinition
	 * @generated
	 */
	public Adapter createCCSLStateMachineRelationDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLAction <em>CCSL Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLAction
	 * @generated
	 */
	public Adapter createCCSLActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock <em>Finish Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.FinishClock
	 * @generated
	 */
	public Adapter createFinishClockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement <em>Integer Assignement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.IntegerAssignement
	 * @generated
	 */
	public Adapter createIntegerAssignementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard <em>CCSL Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard
	 * @generated
	 */
	public Adapter createCCSLGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger <em>CCSL Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLTrigger
	 * @generated
	 */
	public Adapter createCCSLTriggerAdapter() {
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
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDefinition <em>Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationDefinition
	 * @generated
	 */
	public Adapter createRelationDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExternalRelationDefinition <em>External Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExternalRelationDefinition
	 * @generated
	 */
	public Adapter createExternalRelationDefinitionAdapter() {
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
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity <em>Bindable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity
	 * @generated
	 */
	public Adapter createBindableEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity <em>Concrete Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity
	 * @generated
	 */
	public Adapter createConcreteEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.PrimitiveElement <em>Primitive Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.PrimitiveElement
	 * @generated
	 */
	public Adapter createPrimitiveElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression <em>Classical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression
	 * @generated
	 */
	public Adapter createClassicalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerExpression <em>Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerExpression
	 * @generated
	 */
	public Adapter createIntegerExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryIntegerExpression <em>Binary Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryIntegerExpression
	 * @generated
	 */
	public Adapter createBinaryIntegerExpressionAdapter() {
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

} //CcslmocAdapterFactory
