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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage
 * @generated
 */
public class CometastructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CometastructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CometastructurePackage.eINSTANCE;
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
	protected CometastructureSwitch<Adapter> modelSwitch =
		new CometastructureSwitch<Adapter>() {
			@Override
			public Adapter caseStructureContainer(StructureContainer object) {
				return createStructureContainerAdapter();
			}
			@Override
			public Adapter caseMoCConnector(MoCConnector object) {
				return createMoCConnectorAdapter();
			}
			@Override
			public Adapter caseMoCComponent(MoCComponent object) {
				return createMoCComponentAdapter();
			}
			@Override
			public Adapter caseMoCPort(MoCPort object) {
				return createMoCPortAdapter();
			}
			@Override
			public Adapter caseStructureElement(StructureElement object) {
				return createStructureElementAdapter();
			}
			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter caseCompositeComponent(CompositeComponent object) {
				return createCompositeComponentAdapter();
			}
			@Override
			public Adapter caseBasicComponent(BasicComponent object) {
				return createBasicComponentAdapter();
			}
			@Override
			public Adapter caseStructureLibrary(StructureLibrary object) {
				return createStructureLibraryAdapter();
			}
			@Override
			public Adapter casePart(Part object) {
				return createPartAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer <em>Structure Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer
	 * @generated
	 */
	public Adapter createStructureContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector <em>Mo CConnector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector
	 * @generated
	 */
	public Adapter createMoCConnectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent <em>Mo CComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent
	 * @generated
	 */
	public Adapter createMoCComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort <em>Mo CPort</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort
	 * @generated
	 */
	public Adapter createMoCPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement <em>Structure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement
	 * @generated
	 */
	public Adapter createStructureElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent
	 * @generated
	 */
	public Adapter createCompositeComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent <em>Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent
	 * @generated
	 */
	public Adapter createBasicComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary <em>Structure Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary
	 * @generated
	 */
	public Adapter createStructureLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part
	 * @generated
	 */
	public Adapter createPartAdapter() {
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

} //CometastructureAdapterFactory
