/**
 */
package sigpmlextended.impl;

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

import sigpmlextended.Agent;
import sigpmlextended.Application;
import sigpmlextended.HWComputationalResource;
import sigpmlextended.Port;
import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getCycles <em>Cycles</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getCode <em>Code</em>}</li>
 *   <li>{@link sigpmlextended.impl.AgentImpl#getAllocatedTo <em>Allocated To</em>}</li>
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
		return SigpmlextendedPackage.Literals.AGENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOwnedPorts() {
		if (ownedPorts == null) {
			ownedPorts = new EObjectContainmentWithInverseEList<Port>(Port.class, this, SigpmlextendedPackage.AGENT__OWNED_PORTS, SigpmlextendedPackage.PORT__OWNER);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__CYCLES, oldCycles, cycles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application getOwner() {
		if (eContainerFeatureID() != SigpmlextendedPackage.AGENT__OWNER) return null;
		return (Application)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Application newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, SigpmlextendedPackage.AGENT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Application newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != SigpmlextendedPackage.AGENT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, SigpmlextendedPackage.APPLICATION__OWNED_AGENTS, Application.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__OWNER, newOwner, newOwner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__CODE, oldCode, code));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SigpmlextendedPackage.AGENT__ALLOCATED_TO, oldAllocatedTo, allocatedTo));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.AGENT__ALLOCATED_TO, oldAllocatedTo, allocatedTo));
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPorts()).basicAdd(otherEnd, msgs);
			case SigpmlextendedPackage.AGENT__OWNER:
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				return ((InternalEList<?>)getOwnedPorts()).basicRemove(otherEnd, msgs);
			case SigpmlextendedPackage.AGENT__OWNER:
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
			case SigpmlextendedPackage.AGENT__OWNER:
				return eInternalContainer().eInverseRemove(this, SigpmlextendedPackage.APPLICATION__OWNED_AGENTS, Application.class, msgs);
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				return getOwnedPorts();
			case SigpmlextendedPackage.AGENT__CYCLES:
				return getCycles();
			case SigpmlextendedPackage.AGENT__OWNER:
				return getOwner();
			case SigpmlextendedPackage.AGENT__CODE:
				return getCode();
			case SigpmlextendedPackage.AGENT__ALLOCATED_TO:
				if (resolve) return getAllocatedTo();
				return basicGetAllocatedTo();
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				getOwnedPorts().clear();
				getOwnedPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case SigpmlextendedPackage.AGENT__CYCLES:
				setCycles((Integer)newValue);
				return;
			case SigpmlextendedPackage.AGENT__OWNER:
				setOwner((Application)newValue);
				return;
			case SigpmlextendedPackage.AGENT__CODE:
				setCode((String)newValue);
				return;
			case SigpmlextendedPackage.AGENT__ALLOCATED_TO:
				setAllocatedTo((HWComputationalResource)newValue);
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				getOwnedPorts().clear();
				return;
			case SigpmlextendedPackage.AGENT__CYCLES:
				setCycles(CYCLES_EDEFAULT);
				return;
			case SigpmlextendedPackage.AGENT__OWNER:
				setOwner((Application)null);
				return;
			case SigpmlextendedPackage.AGENT__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case SigpmlextendedPackage.AGENT__ALLOCATED_TO:
				setAllocatedTo((HWComputationalResource)null);
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
			case SigpmlextendedPackage.AGENT__OWNED_PORTS:
				return ownedPorts != null && !ownedPorts.isEmpty();
			case SigpmlextendedPackage.AGENT__CYCLES:
				return cycles != CYCLES_EDEFAULT;
			case SigpmlextendedPackage.AGENT__OWNER:
				return getOwner() != null;
			case SigpmlextendedPackage.AGENT__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case SigpmlextendedPackage.AGENT__ALLOCATED_TO:
				return allocatedTo != null;
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
		result.append(" (cycles: ");
		result.append(cycles);
		result.append(", code: ");
		result.append(code);
		result.append(')');
		return result.toString();
	}

} //AgentImpl
