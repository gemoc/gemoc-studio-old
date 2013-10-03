/**
 */
package tfsm.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import tfsm.TfsmClock;
import tfsm.TfsmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clock</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TfsmClockImpl extends NamedElementImpl implements TfsmClock {
	
	private int numberOfTicks;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TfsmClockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmPackage.Literals.TFSM_CLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String tick() {
		this.numberOfTicks++;
		return "[DSA TfsmClockImpl.tick()] : incremented number of ticks";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String initialize() {
		this.numberOfTicks = 0;
		return "[DSA TfsmClockImpl.initialize()] : initialized number of ticks to 0";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TfsmPackage.TFSM_CLOCK___TICK:
				return tick();
			case TfsmPackage.TFSM_CLOCK___INITIALIZE:
				return initialize();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TfsmClockImpl
