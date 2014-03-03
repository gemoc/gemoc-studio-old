/**
 */
package gepl.impl;

import gepl.Atom;
import gepl.Every;
import gepl.GeplPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Every</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gepl.impl.EveryImpl#getAtom <em>Atom</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EveryImpl extends PatternImpl implements Every {
	/**
	 * The cached value of the '{@link #getAtom() <em>Atom</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtom()
	 * @generated
	 * @ordered
	 */
	protected Atom atom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EveryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeplPackage.Literals.EVERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom getAtom() {
		if (atom != null && atom.eIsProxy()) {
			InternalEObject oldAtom = (InternalEObject)atom;
			atom = (Atom)eResolveProxy(oldAtom);
			if (atom != oldAtom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeplPackage.EVERY__ATOM, oldAtom, atom));
			}
		}
		return atom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom basicGetAtom() {
		return atom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtom(Atom newAtom) {
		Atom oldAtom = atom;
		atom = newAtom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeplPackage.EVERY__ATOM, oldAtom, atom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeplPackage.EVERY__ATOM:
				if (resolve) return getAtom();
				return basicGetAtom();
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
			case GeplPackage.EVERY__ATOM:
				setAtom((Atom)newValue);
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
			case GeplPackage.EVERY__ATOM:
				setAtom((Atom)null);
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
			case GeplPackage.EVERY__ATOM:
				return atom != null;
		}
		return super.eIsSet(featureID);
	}

} //EveryImpl
