/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GemocExecutionEngineTraceFactoryImpl extends EFactoryImpl implements GemocExecutionEngineTraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GemocExecutionEngineTraceFactory init() {
		try {
			GemocExecutionEngineTraceFactory theGemocExecutionEngineTraceFactory = (GemocExecutionEngineTraceFactory)EPackage.Registry.INSTANCE.getEFactory(GemocExecutionEngineTracePackage.eNS_URI);
			if (theGemocExecutionEngineTraceFactory != null) {
				return theGemocExecutionEngineTraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GemocExecutionEngineTraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocExecutionEngineTraceFactoryImpl() {
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
			case GemocExecutionEngineTracePackage.CHOICE: return createChoice();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocExecutionEngineTracePackage getGemocExecutionEngineTracePackage() {
		return (GemocExecutionEngineTracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GemocExecutionEngineTracePackage getPackage() {
		return GemocExecutionEngineTracePackage.eINSTANCE;
	}

} //GemocExecutionEngineTraceFactoryImpl
