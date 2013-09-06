/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides
 * an adapter <code>createXXX</code> method for each class of the model. <!--
 * end-user-doc -->
 * 
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage
 * @generated
 */
public class EmfExecutionConfigurationAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static EmfExecutionConfigurationPackage modelPackage;

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EmfExecutionConfigurationSwitch<Adapter> modelSwitch = new EmfExecutionConfigurationSwitch<Adapter>() {
        
        @Override
		public Adapter caseEMFExecutionConfiguration(EMFExecutionConfiguration object) {
            return EmfExecutionConfigurationAdapterFactory.this.createEMFExecutionConfigurationAdapter();
        }

        
        @Override
		public Adapter caseForcedClockMapping(ForcedClockMapping object) {
            return EmfExecutionConfigurationAdapterFactory.this.createForcedClockMappingAdapter();
        }

        
        @Override
		public Adapter caseImportStatement(ImportStatement object) {
            return EmfExecutionConfigurationAdapterFactory.this.createImportStatementAdapter();
        }

        
        @Override
		public Adapter caseJarImportStatement(JarImportStatement object) {
            return EmfExecutionConfigurationAdapterFactory.this.createJarImportStatementAdapter();
        }

        
        @Override
		public Adapter defaultCase(EObject object) {
            return EmfExecutionConfigurationAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    public EmfExecutionConfigurationAdapterFactory() {
        if (EmfExecutionConfigurationAdapterFactory.modelPackage == null) {
            EmfExecutionConfigurationAdapterFactory.modelPackage = EmfExecutionConfigurationPackage.eINSTANCE;
        }
    }

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    
    @Override
	public Adapter createAdapter(Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration
     * <em>EMF Execution Configuration</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration
     * @generated
     */
    public Adapter createEMFExecutionConfigurationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This
     * default implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping
     * <em>Forced Clock Mapping</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping
     * @generated
     */
    public Adapter createForcedClockMappingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement
     * <em>Import Statement</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement
     * @generated
     */
    public Adapter createImportStatementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement
     * <em>Jar Import Statement</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's
     * useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.JarImportStatement
     * @generated
     */
    public Adapter createJarImportStatementAdapter() {
        return null;
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc --> This implementation returns <code>true</code> if
     * the object is either the model's package or is an instance object of the
     * model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    
    @Override
	public boolean isFactoryForType(Object object) {
        if (object == EmfExecutionConfigurationAdapterFactory.modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == EmfExecutionConfigurationAdapterFactory.modelPackage;
        }
        return false;
    }

} // EmfExecutionConfigurationAdapterFactory
