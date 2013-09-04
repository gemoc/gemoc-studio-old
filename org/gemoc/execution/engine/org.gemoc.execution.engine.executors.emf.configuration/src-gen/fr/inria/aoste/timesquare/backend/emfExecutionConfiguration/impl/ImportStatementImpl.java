/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Import Statement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ImportStatementImpl#getImportURI
 * <em>Import URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ImportStatementImpl extends MinimalEObjectImpl.Container implements ImportStatement {
    /**
     * The default value of the '{@link #getImportURI() <em>Import URI</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportURI() <em>Import URI</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected String importURI = ImportStatementImpl.IMPORT_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ImportStatementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI:
                return this.getImportURI();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI:
                return ImportStatementImpl.IMPORT_URI_EDEFAULT == null ? this.importURI != null
                        : !ImportStatementImpl.IMPORT_URI_EDEFAULT.equals(this.importURI);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI:
                this.setImportURI((String) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	protected EClass eStaticClass() {
        return EmfExecutionConfigurationPackage.Literals.IMPORT_STATEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI:
                this.setImportURI(ImportStatementImpl.IMPORT_URI_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public String getImportURI() {
        return this.importURI;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void setImportURI(String newImportURI) {
        String oldImportURI = this.importURI;
        this.importURI = newImportURI;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EmfExecutionConfigurationPackage.IMPORT_STATEMENT__IMPORT_URI, oldImportURI, this.importURI));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (importURI: ");
        result.append(this.importURI);
        result.append(')');
        return result.toString();
    }

} // ImportStatementImpl
