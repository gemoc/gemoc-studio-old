/**
 */
package tfsm_plaink3Trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tfsm_plaink3Trace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tfsm_plaink3TraceFactoryImpl extends EFactoryImpl implements Tfsm_plaink3TraceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tfsm_plaink3TraceFactory init() {
		try {
			Tfsm_plaink3TraceFactory theTfsm_plaink3TraceFactory = (Tfsm_plaink3TraceFactory)EPackage.Registry.INSTANCE.getEFactory(Tfsm_plaink3TracePackage.eNS_URI);
			if (theTfsm_plaink3TraceFactory != null) {
				return theTfsm_plaink3TraceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Tfsm_plaink3TraceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3TraceFactoryImpl() {
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
			case Tfsm_plaink3TracePackage.SPECIFIC_TRACE: return createSpecificTrace();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificTrace createSpecificTrace() {
		SpecificTraceImpl specificTrace = new SpecificTraceImpl();
		return specificTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3TracePackage getTfsm_plaink3TracePackage() {
		return (Tfsm_plaink3TracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Tfsm_plaink3TracePackage getPackage() {
		return Tfsm_plaink3TracePackage.eINSTANCE;
	}

} //Tfsm_plaink3TraceFactoryImpl
