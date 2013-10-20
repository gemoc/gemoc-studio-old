/**
 */
package fr.inria.aoste.timesquare.backend.emfExecutionConfiguration;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forced Clock Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClock <em>Clock</em>}</li>
 *   <li>{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClockToAvoidWhenTrue <em>Clock To Avoid When True</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getForcedClockMapping()
 * @model
 * @generated
 */
public interface ForcedClockMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Clock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clock</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock</em>' reference.
   * @see #setClock(Clock)
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getForcedClockMapping_Clock()
   * @model
   * @generated
   */
  Clock getClock();

  /**
   * Sets the value of the '{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClock <em>Clock</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock</em>' reference.
   * @see #getClock()
   * @generated
   */
  void setClock(Clock value);

  /**
   * Returns the value of the '<em><b>Clock To Avoid When True</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Clock To Avoid When True</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Clock To Avoid When True</em>' reference.
   * @see #setClockToAvoidWhenTrue(Clock)
   * @see fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.EmfExecutionConfigurationPackage#getForcedClockMapping_ClockToAvoidWhenTrue()
   * @model
   * @generated
   */
  Clock getClockToAvoidWhenTrue();

  /**
   * Sets the value of the '{@link fr.inria.aoste.timesquare.backend.emfExecutionConfiguration.ForcedClockMapping#getClockToAvoidWhenTrue <em>Clock To Avoid When True</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Clock To Avoid When True</em>' reference.
   * @see #getClockToAvoidWhenTrue()
   * @generated
   */
  void setClockToAvoidWhenTrue(Clock value);

} // ForcedClockMapping
