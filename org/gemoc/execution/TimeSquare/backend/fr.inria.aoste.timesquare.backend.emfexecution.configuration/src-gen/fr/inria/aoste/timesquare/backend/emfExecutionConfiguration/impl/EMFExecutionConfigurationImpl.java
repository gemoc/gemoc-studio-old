/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EMFExecutionConfiguration;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ImportStatement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Execution Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.EMFExecutionConfigurationImpl#getForcedClockMappings <em>Forced Clock Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFExecutionConfigurationImpl extends MinimalEObjectImpl.Container implements EMFExecutionConfiguration
{
  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected EList<ImportStatement> imports;

  /**
   * The cached value of the '{@link #getForcedClockMappings() <em>Forced Clock Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForcedClockMappings()
   * @generated
   * @ordered
   */
  protected EList<ForcedClockMapping> forcedClockMappings;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EMFExecutionConfigurationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EmfExecutionConfigurationPackage.Literals.EMF_EXECUTION_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ImportStatement> getImports()
  {
    if (imports == null)
    {
      imports = new EObjectContainmentEList<ImportStatement>(ImportStatement.class, this, EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS);
    }
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ForcedClockMapping> getForcedClockMappings()
  {
    if (forcedClockMappings == null)
    {
      forcedClockMappings = new EObjectContainmentEList<ForcedClockMapping>(ForcedClockMapping.class, this, EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS);
    }
    return forcedClockMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
        return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
        return ((InternalEList<?>)getForcedClockMappings()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
        return getImports();
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
        return getForcedClockMappings();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
        getImports().clear();
        getImports().addAll((Collection<? extends ImportStatement>)newValue);
        return;
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
        getForcedClockMappings().clear();
        getForcedClockMappings().addAll((Collection<? extends ForcedClockMapping>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
        getImports().clear();
        return;
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
        getForcedClockMappings().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__IMPORTS:
        return imports != null && !imports.isEmpty();
      case EmfExecutionConfigurationPackage.EMF_EXECUTION_CONFIGURATION__FORCED_CLOCK_MAPPINGS:
        return forcedClockMappings != null && !forcedClockMappings.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EMFExecutionConfigurationImpl
