/**
 */
package org.gemoc.sample.sigpml.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.sigpml.Agent;
import org.gemoc.sample.sigpml.Application;
import org.gemoc.sample.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.Port;
import org.gemoc.sample.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getCycles <em>Cycles</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getAllocatedTo <em>Allocated To</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.AgentImpl#isIsCurrentlyExecuting <em>Is Currently Executing</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentImpl extends NamedElementImpl implements Agent {
	/**
	 * The cached value of the '{@link #getOwnedPorts() <em>Owned Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> ownedPorts;

	/**
	 * The default value of the '{@link #getCycles() <em>Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCycles()
	 * @generated
	 * @ordered
	 */
	protected static final int CYCLES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCycles() <em>Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCycles()
	 * @generated
	 * @ordered
	 */
	protected int cycles = CYCLES_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocatedTo() <em>Allocated To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocatedTo()
	 * @generated
	 * @ordered
	 */
	protected HWComputationalResource allocatedTo;

	/**
	 * The default value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_EXEC_CYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected int currentExecCycle = CURRENT_EXEC_CYCLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsCurrentlyExecuting() <em>Is Currently Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCurrentlyExecuting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CURRENTLY_EXECUTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCurrentlyExecuting() <em>Is Currently Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCurrentlyExecuting()
	 * @generated
	 * @ordered
	 */
	protected boolean isCurrentlyExecuting = IS_CURRENTLY_EXECUTING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.AGENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOwnedPorts() {
		if (ownedPorts == null) {
			ownedPorts = new EObjectContainmentWithInverseEList<Port>(Port.class, this, SigpmlPackage.AGENT__OWNED_PORTS, SigpmlPackage.PORT__OWNER);
		}
		return ownedPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCycles() {
		return cycles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCycles(int newCycles) {
		int oldCycles = cycles;
		cycles = newCycles;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__CYCLES, oldCycles, cycles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getOwner() {
		if (eContainerFeatureID() != SigpmlPackage.AGENT__OWNER) return null;
		return (Application)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Application newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, SigpmlPackage.AGENT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Application newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != SigpmlPackage.AGENT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, SigpmlPackage.APPLICATION__OWNED_AGENTS, Application.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWComputationalResource getAllocatedTo() {
		if (allocatedTo != null && allocatedTo.eIsProxy()) {
			InternalEObject oldAllocatedTo = (InternalEObject)allocatedTo;
			allocatedTo = (HWComputationalResource)eResolveProxy(oldAllocatedTo);
			if (allocatedTo != oldAllocatedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SigpmlPackage.AGENT__ALLOCATED_TO, oldAllocatedTo, allocatedTo));
			}
		}
		return allocatedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWComputationalResource basicGetAllocatedTo() {
		return allocatedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocatedTo(HWComputationalResource newAllocatedTo) {
		HWComputationalResource oldAllocatedTo = allocatedTo;
		allocatedTo = newAllocatedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__ALLOCATED_TO, oldAllocatedTo, allocatedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentExecCycle() {
		return currentExecCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentExecCycle(int newCurrentExecCycle) {
		int oldCurrentExecCycle = currentExecCycle;
		currentExecCycle = newCurrentExecCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE, oldCurrentExecCycle, currentExecCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCurrentlyExecuting() {
		return isCurrentlyExecuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCurrentlyExecuting(boolean newIsCurrentlyExecuting) {
		boolean oldIsCurrentlyExecuting = isCurrentlyExecuting;
		isCurrentlyExecuting = newIsCurrentlyExecuting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING, oldIsCurrentlyExecuting, isCurrentlyExecuting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isExecuting() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void execute() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void stop() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case SigpmlPackage.AGENT__OWNED_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPorts()).basicAdd(otherEnd, msgs);
			case SigpmlPackage.AGENT__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Application)otherEnd, msgs);
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
			case SigpmlPackage.AGENT__OWNED_PORTS:
				return ((InternalEList<?>)getOwnedPorts()).basicRemove(otherEnd, msgs);
			case SigpmlPackage.AGENT__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SigpmlPackage.AGENT__OWNER:
				return eInternalContainer().eInverseRemove(this, SigpmlPackage.APPLICATION__OWNED_AGENTS, Application.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlPackage.AGENT__OWNED_PORTS:
				return getOwnedPorts();
			case SigpmlPackage.AGENT__CYCLES:
				return getCycles();
			case SigpmlPackage.AGENT__OWNER:
				return getOwner();
			case SigpmlPackage.AGENT__CODE:
				return getCode();
			case SigpmlPackage.AGENT__ALLOCATED_TO:
				if (resolve) return getAllocatedTo();
				return basicGetAllocatedTo();
			case SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
				return getCurrentExecCycle();
			case SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
				return isIsCurrentlyExecuting();
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
			case SigpmlPackage.AGENT__OWNED_PORTS:
				getOwnedPorts().clear();
				getOwnedPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case SigpmlPackage.AGENT__CYCLES:
				setCycles((Integer)newValue);
				return;
			case SigpmlPackage.AGENT__OWNER:
				setOwner((Application)newValue);
				return;
			case SigpmlPackage.AGENT__CODE:
				setCode((String)newValue);
				return;
			case SigpmlPackage.AGENT__ALLOCATED_TO:
				setAllocatedTo((HWComputationalResource)newValue);
				return;
			case SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle((Integer)newValue);
				return;
			case SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
				setIsCurrentlyExecuting((Boolean)newValue);
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
			case SigpmlPackage.AGENT__OWNED_PORTS:
				getOwnedPorts().clear();
				return;
			case SigpmlPackage.AGENT__CYCLES:
				setCycles(CYCLES_EDEFAULT);
				return;
			case SigpmlPackage.AGENT__OWNER:
				setOwner((Application)null);
				return;
			case SigpmlPackage.AGENT__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case SigpmlPackage.AGENT__ALLOCATED_TO:
				setAllocatedTo((HWComputationalResource)null);
				return;
			case SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle(CURRENT_EXEC_CYCLE_EDEFAULT);
				return;
			case SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
				setIsCurrentlyExecuting(IS_CURRENTLY_EXECUTING_EDEFAULT);
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
			case SigpmlPackage.AGENT__OWNED_PORTS:
				return ownedPorts != null && !ownedPorts.isEmpty();
			case SigpmlPackage.AGENT__CYCLES:
				return cycles != CYCLES_EDEFAULT;
			case SigpmlPackage.AGENT__OWNER:
				return getOwner() != null;
			case SigpmlPackage.AGENT__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case SigpmlPackage.AGENT__ALLOCATED_TO:
				return allocatedTo != null;
			case SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
				return currentExecCycle != CURRENT_EXEC_CYCLE_EDEFAULT;
			case SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
				return isCurrentlyExecuting != IS_CURRENTLY_EXECUTING_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SigpmlPackage.AGENT___IS_EXECUTING:
				isExecuting();
				return null;
			case SigpmlPackage.AGENT___EXECUTE:
				execute();
				return null;
			case SigpmlPackage.AGENT___STOP:
				stop();
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (cycles: ");
		result.append(cycles);
		result.append(", code: ");
		result.append(code);
		result.append(", currentExecCycle: ");
		result.append(currentExecCycle);
		result.append(", isCurrentlyExecuting: ");
		result.append(isCurrentlyExecuting);
		result.append(')');
		return result.toString();
	}

} //AgentImpl
