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

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage
 * @generated
 */
public class CometastructureValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final CometastructureValidator INSTANCE = new CometastructureValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.gemoc.mocc.cometaccsl.model.cometa.cometastructure";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructureValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return CometastructurePackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case CometastructurePackage.STRUCTURE_CONTAINER:
				return validateStructureContainer((StructureContainer)value, diagnostics, context);
			case CometastructurePackage.MO_CCONNECTOR:
				return validateMoCConnector((MoCConnector)value, diagnostics, context);
			case CometastructurePackage.MO_CCOMPONENT:
				return validateMoCComponent((MoCComponent)value, diagnostics, context);
			case CometastructurePackage.MO_CPORT:
				return validateMoCPort((MoCPort)value, diagnostics, context);
			case CometastructurePackage.STRUCTURE_ELEMENT:
				return validateStructureElement((StructureElement)value, diagnostics, context);
			case CometastructurePackage.CONTAINER:
				return validateContainer((Container)value, diagnostics, context);
			case CometastructurePackage.COMPOSITE_COMPONENT:
				return validateCompositeComponent((CompositeComponent)value, diagnostics, context);
			case CometastructurePackage.BASIC_COMPONENT:
				return validateBasicComponent((BasicComponent)value, diagnostics, context);
			case CometastructurePackage.STRUCTURE_LIBRARY:
				return validateStructureLibrary((StructureLibrary)value, diagnostics, context);
			case CometastructurePackage.PART:
				return validatePart((Part)value, diagnostics, context);
			case CometastructurePackage.PORT_KIND:
				return validatePortKind((PortKind)value, diagnostics, context);
			case CometastructurePackage.MO_CCONNECTOR_KIND:
				return validateMoCConnectorKind((MoCConnectorKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructureContainer(StructureContainer structureContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structureContainer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMoCConnector(MoCConnector moCConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(moCConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMoCComponent(MoCComponent moCComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(moCComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMoCPort(MoCPort moCPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(moCPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructureElement(StructureElement structureElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structureElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContainer(Container container, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(container, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeComponent(CompositeComponent compositeComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicComponent(BasicComponent basicComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(basicComponent, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStructureLibrary(StructureLibrary structureLibrary, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(structureLibrary, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(part, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(part, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(part, diagnostics, context);
		if (result || diagnostics != null) result &= validatePart_PartHasSameNumberOfPortsThanItsComponent(part, diagnostics, context);
		if (result || diagnostics != null) result &= validatePart_EachPortIsDefinedInComponent(part, diagnostics, context);
		if (result || diagnostics != null) result &= validatePart_NoRedondancyInPortsNames(part, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the PartHasSameNumberOfPortsThanItsComponent constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PART__PART_HAS_SAME_NUMBER_OF_PORTS_THAN_ITS_COMPONENT__EEXPRESSION = "ports->size()=componentType.ownedPortInstances->size()";

	/**
	 * Validates the PartHasSameNumberOfPortsThanItsComponent constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart_PartHasSameNumberOfPortsThanItsComponent(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(CometastructurePackage.Literals.PART,
				 part,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "PartHasSameNumberOfPortsThanItsComponent",
				 PART__PART_HAS_SAME_NUMBER_OF_PORTS_THAN_ITS_COMPONENT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the EachPortIsDefinedInComponent constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PART__EACH_PORT_IS_DEFINED_IN_COMPONENT__EEXPRESSION = "ports->forAll(self.componentType.ownedPortInstances->collect(name)->includes(name))";

	/**
	 * Validates the EachPortIsDefinedInComponent constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart_EachPortIsDefinedInComponent(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(CometastructurePackage.Literals.PART,
				 part,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "EachPortIsDefinedInComponent",
				 PART__EACH_PORT_IS_DEFINED_IN_COMPONENT__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * The cached validation expression for the NoRedondancyInPortsNames constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String PART__NO_REDONDANCY_IN_PORTS_NAMES__EEXPRESSION = "self.ports->forAll(p1, p2 | p1<>p2 implies p1.name<>p2.name)";

	/**
	 * Validates the NoRedondancyInPortsNames constraint of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePart_NoRedondancyInPortsNames(Part part, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return
			validate
				(CometastructurePackage.Literals.PART,
				 part,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
				 "NoRedondancyInPortsNames",
				 PART__NO_REDONDANCY_IN_PORTS_NAMES__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortKind(PortKind portKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMoCConnectorKind(MoCConnectorKind moCConnectorKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //CometastructureValidator
