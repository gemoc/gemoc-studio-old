/**
 */
package org.gemoc.sample.sigpml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.sigpml.Agent;
import org.gemoc.sample.sigpml.Application;
import org.gemoc.sample.sigpml.Place;
import org.gemoc.sample.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.impl.ApplicationImpl#getOwnedAgents <em>Owned Agents</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.impl.ApplicationImpl#getOwnedPlaces <em>Owned Places</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationImpl extends NamedElementImpl implements Application {
	/**
	 * The cached value of the '{@link #getOwnedAgents() <em>Owned Agents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAgents()
	 * @generated
	 * @ordered
	 */
	protected EList<Agent> ownedAgents;

	/**
	 * The cached value of the '{@link #getOwnedPlaces() <em>Owned Places</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPlaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Place> ownedPlaces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Agent> getOwnedAgents() {
		if (ownedAgents == null) {
			ownedAgents = new EObjectContainmentWithInverseEList<Agent>(Agent.class, this, SigpmlPackage.APPLICATION__OWNED_AGENTS, SigpmlPackage.AGENT__OWNER);
		}
		return ownedAgents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Place> getOwnedPlaces() {
		if (ownedPlaces == null) {
			ownedPlaces = new EObjectContainmentWithInverseEList<Place>(Place.class, this, SigpmlPackage.APPLICATION__OWNED_PLACES, SigpmlPackage.PLACE__OWNER);
		}
		return ownedPlaces;
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedAgents()).basicAdd(otherEnd, msgs);
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedPlaces()).basicAdd(otherEnd, msgs);
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				return ((InternalEList<?>)getOwnedAgents()).basicRemove(otherEnd, msgs);
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				return ((InternalEList<?>)getOwnedPlaces()).basicRemove(otherEnd, msgs);
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				return getOwnedAgents();
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				return getOwnedPlaces();
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				getOwnedAgents().clear();
				getOwnedAgents().addAll((Collection<? extends Agent>)newValue);
				return;
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				getOwnedPlaces().clear();
				getOwnedPlaces().addAll((Collection<? extends Place>)newValue);
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				getOwnedAgents().clear();
				return;
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				getOwnedPlaces().clear();
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
			case SigpmlPackage.APPLICATION__OWNED_AGENTS:
				return ownedAgents != null && !ownedAgents.isEmpty();
			case SigpmlPackage.APPLICATION__OWNED_PLACES:
				return ownedPlaces != null && !ownedPlaces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ApplicationImpl
