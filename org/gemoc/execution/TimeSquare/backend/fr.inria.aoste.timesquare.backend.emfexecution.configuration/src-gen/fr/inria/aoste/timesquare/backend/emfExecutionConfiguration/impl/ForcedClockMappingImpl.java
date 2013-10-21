/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl;

import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage;
import fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Forced Clock Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl#getClock <em>Clock</em>}</li>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.impl.ForcedClockMappingImpl#getClockToAvoidWhenTrue <em>Clock To Avoid When True</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForcedClockMappingImpl extends MinimalEObjectImpl.Container implements ForcedClockMapping
{
  /**
   * The cached value of the '{@link #getClock() <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClock()
   * @generated
   * @ordered
   */
  protected Clock clock;

  /**
   * The cached value of the '{@link #getClockToAvoidWhenTrue() <em>Clock To Avoid When True</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClockToAvoidWhenTrue()
   * @generated
   * @ordered
   */
  protected Clock clockToAvoidWhenTrue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForcedClockMappingImpl()
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
    return EmfExecutionConfigurationPackage.Literals.FORCED_CLOCK_MAPPING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock getClock()
  {
    if (clock != null && clock.eIsProxy())
    {
      InternalEObject oldClock = (InternalEObject)clock;
      clock = (Clock)eResolveProxy(oldClock);
      if (clock != oldClock)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK, oldClock, clock));
      }
    }
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetClock()
  {
    return clock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClock(Clock newClock)
  {
    Clock oldClock = clock;
    clock = newClock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK, oldClock, clock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock getClockToAvoidWhenTrue()
  {
    if (clockToAvoidWhenTrue != null && clockToAvoidWhenTrue.eIsProxy())
    {
      InternalEObject oldClockToAvoidWhenTrue = (InternalEObject)clockToAvoidWhenTrue;
      clockToAvoidWhenTrue = (Clock)eResolveProxy(oldClockToAvoidWhenTrue);
      if (clockToAvoidWhenTrue != oldClockToAvoidWhenTrue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE, oldClockToAvoidWhenTrue, clockToAvoidWhenTrue));
      }
    }
    return clockToAvoidWhenTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Clock basicGetClockToAvoidWhenTrue()
  {
    return clockToAvoidWhenTrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setClockToAvoidWhenTrue(Clock newClockToAvoidWhenTrue)
  {
    Clock oldClockToAvoidWhenTrue = clockToAvoidWhenTrue;
    clockToAvoidWhenTrue = newClockToAvoidWhenTrue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE, oldClockToAvoidWhenTrue, clockToAvoidWhenTrue));
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
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK:
        if (resolve) return getClock();
        return basicGetClock();
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE:
        if (resolve) return getClockToAvoidWhenTrue();
        return basicGetClockToAvoidWhenTrue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK:
        setClock((Clock)newValue);
        return;
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE:
        setClockToAvoidWhenTrue((Clock)newValue);
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
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK:
        setClock((Clock)null);
        return;
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE:
        setClockToAvoidWhenTrue((Clock)null);
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
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK:
        return clock != null;
      case EmfExecutionConfigurationPackage.FORCED_CLOCK_MAPPING__CLOCK_TO_AVOID_WHEN_TRUE:
        return clockToAvoidWhenTrue != null;
    }
    return super.eIsSet(featureID);
  }

} //ForcedClockMappingImpl
