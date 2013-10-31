/**
 */
package gmml.impl;

import gmml.GmmlPackage;
import gmml.ImportStatement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gmml.impl.ImportStatementImpl#getDomainSpecificEventFileURI <em>Domain Specific Event File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportStatementImpl extends MinimalEObjectImpl.Container implements ImportStatement {
	/**
	 * The default value of the '{@link #getDomainSpecificEventFileURI() <em>Domain Specific Event File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecificEventFileURI()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_SPECIFIC_EVENT_FILE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDomainSpecificEventFileURI() <em>Domain Specific Event File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecificEventFileURI()
	 * @generated
	 * @ordered
	 */
	protected String domainSpecificEventFileURI = DOMAIN_SPECIFIC_EVENT_FILE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GmmlPackage.Literals.IMPORT_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainSpecificEventFileURI() {
		return domainSpecificEventFileURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainSpecificEventFileURI(String newDomainSpecificEventFileURI) {
		String oldDomainSpecificEventFileURI = domainSpecificEventFileURI;
		domainSpecificEventFileURI = newDomainSpecificEventFileURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GmmlPackage.IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI, oldDomainSpecificEventFileURI, domainSpecificEventFileURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GmmlPackage.IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI:
				return getDomainSpecificEventFileURI();
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
			case GmmlPackage.IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI:
				setDomainSpecificEventFileURI((String)newValue);
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
			case GmmlPackage.IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI:
				setDomainSpecificEventFileURI(DOMAIN_SPECIFIC_EVENT_FILE_URI_EDEFAULT);
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
			case GmmlPackage.IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI:
				return DOMAIN_SPECIFIC_EVENT_FILE_URI_EDEFAULT == null ? domainSpecificEventFileURI != null : !DOMAIN_SPECIFIC_EVENT_FILE_URI_EDEFAULT.equals(domainSpecificEventFileURI);
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
		result.append(" (DomainSpecificEventFileURI: ");
		result.append(domainSpecificEventFileURI);
		result.append(')');
		return result.toString();
	}

} //ImportStatementImpl
