/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Branch;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.BranchImpl#getStartIndex <em>Start Index</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.BranchImpl#getStopIndex <em>Stop Index</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.BranchImpl#getChoices <em>Choices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchImpl extends MinimalEObjectImpl.Container implements Branch {
	/**
	 * The default value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int START_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStartIndex() <em>Start Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartIndex()
	 * @generated
	 * @ordered
	 */
	protected int startIndex = START_INDEX_EDEFAULT;
	/**
	 * The default value of the '{@link #getStopIndex() <em>Stop Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int STOP_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStopIndex() <em>Stop Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopIndex()
	 * @generated
	 * @ordered
	 */
	protected int stopIndex = STOP_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
	protected EList<Choice> choices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gemoc_execution_tracePackage.Literals.BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Choice> getChoices() {
		if (choices == null) {
			choices = new EObjectWithInverseResolvingEList<Choice>(Choice.class, this, Gemoc_execution_tracePackage.BRANCH__CHOICES, Gemoc_execution_tracePackage.CHOICE__BRANCH);
		}
		return choices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChoices()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				return ((InternalEList<?>)getChoices()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartIndex(int newStartIndex) {
		int oldStartIndex = startIndex;
		startIndex = newStartIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.BRANCH__START_INDEX, oldStartIndex, startIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStopIndex() {
		return stopIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopIndex(int newStopIndex) {
		int oldStopIndex = stopIndex;
		stopIndex = newStopIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gemoc_execution_tracePackage.BRANCH__STOP_INDEX, oldStopIndex, stopIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Gemoc_execution_tracePackage.BRANCH__START_INDEX:
				return getStartIndex();
			case Gemoc_execution_tracePackage.BRANCH__STOP_INDEX:
				return getStopIndex();
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				return getChoices();
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
			case Gemoc_execution_tracePackage.BRANCH__START_INDEX:
				setStartIndex((Integer)newValue);
				return;
			case Gemoc_execution_tracePackage.BRANCH__STOP_INDEX:
				setStopIndex((Integer)newValue);
				return;
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends Choice>)newValue);
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
			case Gemoc_execution_tracePackage.BRANCH__START_INDEX:
				setStartIndex(START_INDEX_EDEFAULT);
				return;
			case Gemoc_execution_tracePackage.BRANCH__STOP_INDEX:
				setStopIndex(STOP_INDEX_EDEFAULT);
				return;
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				getChoices().clear();
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
			case Gemoc_execution_tracePackage.BRANCH__START_INDEX:
				return startIndex != START_INDEX_EDEFAULT;
			case Gemoc_execution_tracePackage.BRANCH__STOP_INDEX:
				return stopIndex != STOP_INDEX_EDEFAULT;
			case Gemoc_execution_tracePackage.BRANCH__CHOICES:
				return choices != null && !choices.isEmpty();
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
		result.append(" (startIndex: ");
		result.append(startIndex);
		result.append(", stopIndex: ");
		result.append(stopIndex);
		result.append(')');
		return result.toString();
	}

} //BranchImpl
