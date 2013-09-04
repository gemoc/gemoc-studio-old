/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Jar Import Statement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.JarImportStatementImpl#getPathToJar
 * <em>Path To Jar</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class JarImportStatementImpl extends MinimalEObjectImpl.Container implements JarImportStatement {
    /**
     * The default value of the '{@link #getPathToJar() <em>Path To Jar</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPathToJar()
     * @generated
     * @ordered
     */
    protected static final String PATH_TO_JAR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPathToJar() <em>Path To Jar</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPathToJar()
     * @generated
     * @ordered
     */
    protected String pathToJar = JarImportStatementImpl.PATH_TO_JAR_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected JarImportStatementImpl() {
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
            case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR:
                return this.getPathToJar();
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
            case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR:
                return JarImportStatementImpl.PATH_TO_JAR_EDEFAULT == null ? this.pathToJar != null
                        : !JarImportStatementImpl.PATH_TO_JAR_EDEFAULT.equals(this.pathToJar);
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
            case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR:
                this.setPathToJar((String) newValue);
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
        return EmfExecutionConfigurationPackage.Literals.JAR_IMPORT_STATEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR:
                this.setPathToJar(JarImportStatementImpl.PATH_TO_JAR_EDEFAULT);
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
	public String getPathToJar() {
        return this.pathToJar;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void setPathToJar(String newPathToJar) {
        String oldPathToJar = this.pathToJar;
        this.pathToJar = newPathToJar;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EmfExecutionConfigurationPackage.JAR_IMPORT_STATEMENT__PATH_TO_JAR, oldPathToJar, this.pathToJar));
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
        result.append(" (pathToJar: ");
        result.append(this.pathToJar);
        result.append(')');
        return result.toString();
    }

} // JarImportStatementImpl
