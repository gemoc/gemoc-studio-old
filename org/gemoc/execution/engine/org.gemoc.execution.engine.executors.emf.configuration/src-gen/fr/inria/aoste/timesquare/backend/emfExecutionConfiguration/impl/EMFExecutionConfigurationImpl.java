/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>EMF Execution Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl#getImports
 * <em>Imports</em>}</li>
 * <li>
 * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl#getJarImportStatement
 * <em>Jar Import Statement</em>}</li>
 * <li>
 * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl#getForcedClockMappings
 * <em>Forced Clock Mappings</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EMFExecutionConfigurationImpl extends MinimalEObjectImpl.Container implements EMFExecutionConfiguration {
    /**
     * The cached value of the '{@link #getImports() <em>Imports</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getImports()
     * @generated
     * @ordered
     */
    protected EList<ImportStatement> imports;

    /**
     * The cached value of the '{@link #getJarImportStatement()
     * <em>Jar Import Statement</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getJarImportStatement()
     * @generated
     * @ordered
     */
    protected JarImportStatement jarImportStatement;

    /**
     * The cached value of the '{@link #getForcedClockMappings()
     * <em>Forced Clock Mappings</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getForcedClockMappings()
     * @generated
     * @ordered
     */
    protected EList<ForcedClockMapping> forcedClockMappings;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EMFExecutionConfigurationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetJarImportStatement(JarImportStatement newJarImportStatement, NotificationChain msgs) {
        JarImportStatement oldJarImportStatement = this.jarImportStatement;
        this.jarImportStatement = newJarImportStatement;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT,
                    oldJarImportStatement, newJarImportStatement);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
                return this.getImports();
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT:
                return this.getJarImportStatement();
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
                return this.getForcedClockMappings();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
                return ((InternalEList<?>) this.getImports()).basicRemove(otherEnd, msgs);
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT:
                return this.basicSetJarImportStatement(null, msgs);
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
                return ((InternalEList<?>) this.getForcedClockMappings()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
                return this.imports != null && !this.imports.isEmpty();
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT:
                return this.jarImportStatement != null;
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
                return this.forcedClockMappings != null && !this.forcedClockMappings.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
	@SuppressWarnings("unchecked")
    
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
                this.getImports().clear();
                this.getImports().addAll((Collection<? extends ImportStatement>) newValue);
                return;
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT:
                this.setJarImportStatement((JarImportStatement) newValue);
                return;
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
                this.getForcedClockMappings().clear();
                this.getForcedClockMappings().addAll((Collection<? extends ForcedClockMapping>) newValue);
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
        return EmfExecutionConfigurationPackage.Literals.EMF_EXECUTION_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
                this.getImports().clear();
                return;
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT:
                this.setJarImportStatement((JarImportStatement) null);
                return;
            case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
                this.getForcedClockMappings().clear();
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
	public EList<ForcedClockMapping> getForcedClockMappings() {
        if (this.forcedClockMappings == null) {
            this.forcedClockMappings = new EObjectContainmentEList<ForcedClockMapping>(ForcedClockMapping.class, this,
                    EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS);
        }
        return this.forcedClockMappings;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public EList<ImportStatement> getImports() {
        if (this.imports == null) {
            this.imports = new EObjectContainmentEList<ImportStatement>(ImportStatement.class, this,
                    EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS);
        }
        return this.imports;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public JarImportStatement getJarImportStatement() {
        return this.jarImportStatement;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    
    @Override
	public void setJarImportStatement(JarImportStatement newJarImportStatement) {
        if (newJarImportStatement != this.jarImportStatement) {
            NotificationChain msgs = null;
            if (this.jarImportStatement != null) {
                msgs = ((InternalEObject) this.jarImportStatement).eInverseRemove(this,
                        InternalEObject.EOPPOSITE_FEATURE_BASE
                                - EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT,
                        null, msgs);
            }
            if (newJarImportStatement != null) {
                msgs = ((InternalEObject) newJarImportStatement).eInverseAdd(this,
                        InternalEObject.EOPPOSITE_FEATURE_BASE
                                - EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT,
                        null, msgs);
            }
            msgs = this.basicSetJarImportStatement(newJarImportStatement, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__JAR_IMPORT_STATEMENT,
                    newJarImportStatement, newJarImportStatement));
        }
    }

} // EMFExecutionConfigurationImpl
