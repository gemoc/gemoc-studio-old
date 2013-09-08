/**
 */
package org.gemoc.mocc.model.moccmetamodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.model.moccmetamodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MoccmetamodelFactoryImpl extends EFactoryImpl implements MoccmetamodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MoccmetamodelFactory init() {
		try {
			MoccmetamodelFactory theMoccmetamodelFactory = (MoccmetamodelFactory)EPackage.Registry.INSTANCE.getEFactory(MoccmetamodelPackage.eNS_URI);
			if (theMoccmetamodelFactory != null) {
				return theMoccmetamodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MoccmetamodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccmetamodelFactoryImpl() {
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
			case MoccmetamodelPackage.STATE_MACHINE_RELATION_DEFINITION: return createStateMachineRelationDefinition();
			case MoccmetamodelPackage.STATE: return createState();
			case MoccmetamodelPackage.TRANSITION: return createTransition();
			case MoccmetamodelPackage.STATE_BASE_RELATION_LIBRARY: return createStateBaseRelationLibrary();
			case MoccmetamodelPackage.INTEGER_ASSIGNMENT: return createIntegerAssignment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachineRelationDefinition createStateMachineRelationDefinition() {
		StateMachineRelationDefinitionImpl stateMachineRelationDefinition = new StateMachineRelationDefinitionImpl();
		return stateMachineRelationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateBaseRelationLibrary createStateBaseRelationLibrary() {
		StateBaseRelationLibraryImpl stateBaseRelationLibrary = new StateBaseRelationLibraryImpl();
		return stateBaseRelationLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAssignment createIntegerAssignment() {
		IntegerAssignmentImpl integerAssignment = new IntegerAssignmentImpl();
		return integerAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccmetamodelPackage getMoccmetamodelPackage() {
		return (MoccmetamodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MoccmetamodelPackage getPackage() {
		return MoccmetamodelPackage.eINSTANCE;
	}

} //MoccmetamodelFactoryImpl
