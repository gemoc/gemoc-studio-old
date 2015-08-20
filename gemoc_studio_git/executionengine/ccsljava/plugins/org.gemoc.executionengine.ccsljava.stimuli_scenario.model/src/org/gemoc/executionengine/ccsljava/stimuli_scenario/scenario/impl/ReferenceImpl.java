/**
 */
package org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Fragment;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Reference;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ScenarioPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.impl.ReferenceImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.impl.ReferenceImpl#getStartStep <em>Start Step</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceImpl extends MinimalEObjectImpl.Container implements Reference {
	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected Fragment fragment;

	/**
	 * The default value of the '{@link #getStartStep() <em>Start Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartStep()
	 * @generated
	 * @ordered
	 */
	protected static final int START_STEP_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartStep() <em>Start Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartStep()
	 * @generated
	 * @ordered
	 */
	protected int startStep = START_STEP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScenarioPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFragment(Fragment newFragment, NotificationChain msgs) {
		Fragment oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ScenarioPackage.REFERENCE__FRAGMENT, oldFragment, newFragment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(Fragment newFragment) {
		if (newFragment != fragment) {
			NotificationChain msgs = null;
			if (fragment != null)
				msgs = ((InternalEObject)fragment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ScenarioPackage.REFERENCE__FRAGMENT, null, msgs);
			if (newFragment != null)
				msgs = ((InternalEObject)newFragment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ScenarioPackage.REFERENCE__FRAGMENT, null, msgs);
			msgs = basicSetFragment(newFragment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.REFERENCE__FRAGMENT, newFragment, newFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartStep() {
		return startStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartStep(int newStartStep) {
		int oldStartStep = startStep;
		startStep = newStartStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScenarioPackage.REFERENCE__START_STEP, oldStartStep, startStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScenarioPackage.REFERENCE__FRAGMENT:
				return basicSetFragment(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScenarioPackage.REFERENCE__FRAGMENT:
				return getFragment();
			case ScenarioPackage.REFERENCE__START_STEP:
				return getStartStep();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScenarioPackage.REFERENCE__FRAGMENT:
				setFragment((Fragment)newValue);
				return;
			case ScenarioPackage.REFERENCE__START_STEP:
				setStartStep((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScenarioPackage.REFERENCE__FRAGMENT:
				setFragment((Fragment)null);
				return;
			case ScenarioPackage.REFERENCE__START_STEP:
				setStartStep(START_STEP_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScenarioPackage.REFERENCE__FRAGMENT:
				return fragment != null;
			case ScenarioPackage.REFERENCE__START_STEP:
				return startStep != START_STEP_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startStep: ");
		result.append(startStep);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
