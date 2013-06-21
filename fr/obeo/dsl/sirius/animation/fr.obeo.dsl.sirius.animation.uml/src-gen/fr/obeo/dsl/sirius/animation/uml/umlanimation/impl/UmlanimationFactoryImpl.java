/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation.impl;

import fr.obeo.dsl.sirius.animation.uml.umlanimation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlanimationFactoryImpl extends EFactoryImpl implements UmlanimationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmlanimationFactory init() {
		try {
			UmlanimationFactory theUmlanimationFactory = (UmlanimationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeo.fr/dsl/sirius/umlanimation"); 
			if (theUmlanimationFactory != null) {
				return theUmlanimationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlanimationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlanimationFactoryImpl() {
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
			case UmlanimationPackage.STATE_MACHINE_EXECUTION: return createStateMachineExecution();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachineExecution createStateMachineExecution() {
		StateMachineExecutionImpl stateMachineExecution = new StateMachineExecutionImpl();
		return stateMachineExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlanimationPackage getUmlanimationPackage() {
		return (UmlanimationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlanimationPackage getPackage() {
		return UmlanimationPackage.eINSTANCE;
	}

} //UmlanimationFactoryImpl
