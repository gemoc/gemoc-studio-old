/**
 */
package gee_configuration.impl;

import gee_configuration.DSAModel;
import gee_configuration.DSEModel;
import gee_configuration.Gee_configurationPackage;
import gee_configuration.MoccModel;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DSE Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gee_configuration.impl.DSEModelImpl#getMapped_mocc <em>Mapped mocc</em>}</li>
 *   <li>{@link gee_configuration.impl.DSEModelImpl#getMapped_dsa <em>Mapped dsa</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DSEModelImpl extends LocalResourceImpl implements DSEModel {
	/**
	 * The cached value of the '{@link #getMapped_mocc() <em>Mapped mocc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapped_mocc()
	 * @generated
	 * @ordered
	 */
	protected MoccModel mapped_mocc;

	/**
	 * The cached value of the '{@link #getMapped_dsa() <em>Mapped dsa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapped_dsa()
	 * @generated
	 * @ordered
	 */
	protected DSAModel mapped_dsa;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSEModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gee_configurationPackage.Literals.DSE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccModel getMapped_mocc() {
		if (mapped_mocc != null && mapped_mocc.eIsProxy()) {
			InternalEObject oldMapped_mocc = (InternalEObject)mapped_mocc;
			mapped_mocc = (MoccModel)eResolveProxy(oldMapped_mocc);
			if (mapped_mocc != oldMapped_mocc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC, oldMapped_mocc, mapped_mocc));
			}
		}
		return mapped_mocc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccModel basicGetMapped_mocc() {
		return mapped_mocc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapped_mocc(MoccModel newMapped_mocc) {
		MoccModel oldMapped_mocc = mapped_mocc;
		mapped_mocc = newMapped_mocc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC, oldMapped_mocc, mapped_mocc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSAModel getMapped_dsa() {
		if (mapped_dsa != null && mapped_dsa.eIsProxy()) {
			InternalEObject oldMapped_dsa = (InternalEObject)mapped_dsa;
			mapped_dsa = (DSAModel)eResolveProxy(oldMapped_dsa);
			if (mapped_dsa != oldMapped_dsa) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Gee_configurationPackage.DSE_MODEL__MAPPED_DSA, oldMapped_dsa, mapped_dsa));
			}
		}
		return mapped_dsa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSAModel basicGetMapped_dsa() {
		return mapped_dsa;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapped_dsa(DSAModel newMapped_dsa) {
		DSAModel oldMapped_dsa = mapped_dsa;
		mapped_dsa = newMapped_dsa;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Gee_configurationPackage.DSE_MODEL__MAPPED_DSA, oldMapped_dsa, mapped_dsa));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC:
				if (resolve) return getMapped_mocc();
				return basicGetMapped_mocc();
			case Gee_configurationPackage.DSE_MODEL__MAPPED_DSA:
				if (resolve) return getMapped_dsa();
				return basicGetMapped_dsa();
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
			case Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC:
				setMapped_mocc((MoccModel)newValue);
				return;
			case Gee_configurationPackage.DSE_MODEL__MAPPED_DSA:
				setMapped_dsa((DSAModel)newValue);
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
			case Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC:
				setMapped_mocc((MoccModel)null);
				return;
			case Gee_configurationPackage.DSE_MODEL__MAPPED_DSA:
				setMapped_dsa((DSAModel)null);
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
			case Gee_configurationPackage.DSE_MODEL__MAPPED_MOCC:
				return mapped_mocc != null;
			case Gee_configurationPackage.DSE_MODEL__MAPPED_DSA:
				return mapped_dsa != null;
		}
		return super.eIsSet(featureID);
	}

} //DSEModelImpl
