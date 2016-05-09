/**
 */
package tfsm_plaink3Trace.Steps.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.gemoc.sample.tfsm_plaink3.Transition;

import tfsm_plaink3Trace.Steps.StepsPackage;
import tfsm_plaink3Trace.Steps.Tfsm_plaink3_Transition_Fire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tfsm plaink3 Transition Fire</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class Tfsm_plaink3_Transition_FireImpl extends SmallStepImpl implements Tfsm_plaink3_Transition_Fire {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tfsm_plaink3_Transition_FireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StepsPackage.Literals.TFSM_PLAINK3_TRANSITION_FIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getCaller() {
		return (org.gemoc.sample.tfsm_plaink3.Transition) this.getMse().getCaller();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StepsPackage.TFSM_PLAINK3_TRANSITION_FIRE___GET_CALLER:
				return getCaller();
		}
		return super.eInvoke(operationID, arguments);
	}

} //Tfsm_plaink3_Transition_FireImpl
