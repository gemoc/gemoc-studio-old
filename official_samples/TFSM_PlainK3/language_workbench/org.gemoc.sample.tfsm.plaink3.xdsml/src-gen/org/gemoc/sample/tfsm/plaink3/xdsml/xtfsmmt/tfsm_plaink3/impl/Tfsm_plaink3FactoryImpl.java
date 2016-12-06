/**
 */
package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tfsm_plaink3FactoryImpl extends EFactoryImpl implements Tfsm_plaink3Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Tfsm_plaink3Factory init() {
		try {
			Tfsm_plaink3Factory theTfsm_plaink3Factory = (Tfsm_plaink3Factory)EPackage.Registry.INSTANCE.getEFactory(Tfsm_plaink3Package.eNS_URI);
			if (theTfsm_plaink3Factory != null) {
				return theTfsm_plaink3Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Tfsm_plaink3FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3FactoryImpl() {
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
			case Tfsm_plaink3Package.TFSM: return createTFSM();
			case Tfsm_plaink3Package.STATE: return createState();
			case Tfsm_plaink3Package.TRANSITION: return createTransition();
			case Tfsm_plaink3Package.TEMPORAL_GUARD: return createTemporalGuard();
			case Tfsm_plaink3Package.EVENT_GUARD: return createEventGuard();
			case Tfsm_plaink3Package.FSM_EVENT: return createFSMEvent();
			case Tfsm_plaink3Package.FSM_CLOCK: return createFSMClock();
			case Tfsm_plaink3Package.TIMED_SYSTEM: return createTimedSystem();
			case Tfsm_plaink3Package.EVALUATE_GUARD: return createEvaluateGuard();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFSM createTFSM() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporalGuard createTemporalGuard() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventGuard createEventGuard() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMEvent createFSMEvent() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMClock createFSMClock() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimedSystem createTimedSystem() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EvaluateGuard createEvaluateGuard() {
		throw new UnsupportedOperationException("Cannot invoke element creation on a model type");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tfsm_plaink3Package getTfsm_plaink3Package() {
		return (Tfsm_plaink3Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Tfsm_plaink3Package getPackage() {
		return Tfsm_plaink3Package.eINSTANCE;
	}

} //Tfsm_plaink3FactoryImpl
