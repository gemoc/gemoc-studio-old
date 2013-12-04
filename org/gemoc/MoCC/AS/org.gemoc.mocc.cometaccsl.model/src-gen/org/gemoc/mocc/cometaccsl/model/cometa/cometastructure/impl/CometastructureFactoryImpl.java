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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CometastructureFactoryImpl extends EFactoryImpl implements CometastructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CometastructureFactory init() {
		try {
			CometastructureFactory theCometastructureFactory = (CometastructureFactory)EPackage.Registry.INSTANCE.getEFactory(CometastructurePackage.eNS_URI);
			if (theCometastructureFactory != null) {
				return theCometastructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CometastructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CometastructurePackage.STRUCTURE_CONTAINER: return createStructureContainer();
			case CometastructurePackage.MO_CCONNECTOR: return createMoCConnector();
			case CometastructurePackage.MO_CPORT: return createMoCPort();
			case CometastructurePackage.COMPOSITE_COMPONENT: return createCompositeComponent();
			case CometastructurePackage.BASIC_COMPONENT: return createBasicComponent();
			case CometastructurePackage.STRUCTURE_LIBRARY: return createStructureLibrary();
			case CometastructurePackage.PART: return createPart();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CometastructurePackage.PORT_KIND:
				return createPortKindFromString(eDataType, initialValue);
			case CometastructurePackage.MO_CCONNECTOR_KIND:
				return createMoCConnectorKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CometastructurePackage.PORT_KIND:
				return convertPortKindToString(eDataType, instanceValue);
			case CometastructurePackage.MO_CCONNECTOR_KIND:
				return convertMoCConnectorKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureContainer createStructureContainer() {
		StructureContainerImpl structureContainer = new StructureContainerImpl();
		return structureContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCConnector createMoCConnector() {
		MoCConnectorImpl moCConnector = new MoCConnectorImpl();
		return moCConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCPort createMoCPort() {
		MoCPortImpl moCPort = new MoCPortImpl();
		return moCPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeComponent createCompositeComponent() {
		CompositeComponentImpl compositeComponent = new CompositeComponentImpl();
		return compositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicComponent createBasicComponent() {
		BasicComponentImpl basicComponent = new BasicComponentImpl();
		return basicComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureLibrary createStructureLibrary() {
		StructureLibraryImpl structureLibrary = new StructureLibraryImpl();
		return structureLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part createPart() {
		PartImpl part = new PartImpl();
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind createPortKindFromString(EDataType eDataType, String initialValue) {
		PortKind result = PortKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCConnectorKind createMoCConnectorKindFromString(EDataType eDataType, String initialValue) {
		MoCConnectorKind result = MoCConnectorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMoCConnectorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructurePackage getCometastructurePackage() {
		return (CometastructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CometastructurePackage getPackage() {
		return CometastructurePackage.eINSTANCE;
	}

} //CometastructureFactoryImpl
