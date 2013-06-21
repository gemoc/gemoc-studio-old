/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation.impl;

import fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution;
import fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl#getStatemachine <em>Statemachine</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl#getCurrent <em>Current</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.uml.umlanimation.impl.StateMachineExecutionImpl#getCandidates <em>Candidates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineExecutionImpl extends EObjectImpl implements StateMachineExecution {
	/**
	 * The cached value of the '{@link #getStatemachine() <em>Statemachine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatemachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine statemachine;

	/**
	 * The cached value of the '{@link #getCurrent() <em>Current</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrent()
	 * @generated
	 * @ordered
	 */
	protected State current;

	/**
	 * The cached value of the '{@link #getCandidates() <em>Candidates</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> candidates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlanimationPackage.Literals.STATE_MACHINE_EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStatemachine() {
		if (statemachine != null && statemachine.eIsProxy()) {
			InternalEObject oldStatemachine = (InternalEObject)statemachine;
			statemachine = (StateMachine)eResolveProxy(oldStatemachine);
			if (statemachine != oldStatemachine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE, oldStatemachine, statemachine));
			}
		}
		return statemachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine basicGetStatemachine() {
		return statemachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatemachine(StateMachine newStatemachine) {
		StateMachine oldStatemachine = statemachine;
		statemachine = newStatemachine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE, oldStatemachine, statemachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getCurrent() {
		if (current != null && current.eIsProxy()) {
			InternalEObject oldCurrent = (InternalEObject)current;
			current = (State)eResolveProxy(oldCurrent);
			if (current != oldCurrent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT, oldCurrent, current));
			}
		}
		return current;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetCurrent() {
		return current;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrent(State newCurrent) {
		State oldCurrent = current;
		current = newCurrent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT, oldCurrent, current));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getCandidates() {
		if (candidates == null) {
			candidates = new EObjectResolvingEList<State>(State.class, this, UmlanimationPackage.STATE_MACHINE_EXECUTION__CANDIDATES);
		}
		return candidates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE:
				if (resolve) return getStatemachine();
				return basicGetStatemachine();
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT:
				if (resolve) return getCurrent();
				return basicGetCurrent();
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CANDIDATES:
				return getCandidates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE:
				setStatemachine((StateMachine)newValue);
				return;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT:
				setCurrent((State)newValue);
				return;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CANDIDATES:
				getCandidates().clear();
				getCandidates().addAll((Collection<? extends State>)newValue);
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
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE:
				setStatemachine((StateMachine)null);
				return;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT:
				setCurrent((State)null);
				return;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CANDIDATES:
				getCandidates().clear();
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
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__STATEMACHINE:
				return statemachine != null;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CURRENT:
				return current != null;
			case UmlanimationPackage.STATE_MACHINE_EXECUTION__CANDIDATES:
				return candidates != null && !candidates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMachineExecutionImpl
