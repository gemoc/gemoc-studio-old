/**
 */
package tfsmTrace.States;

import org.eclipse.emf.common.util.EList;

import tfsmTrace.States.tfsm.TracedFSMClock;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>FSM Clock number Of Ticks Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getNumberOfTicks <em>Number Of Ticks</em>}</li>
 *   <li>{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see tfsmTrace.States.StatesPackage#getFSMClock_numberOfTicks_Value()
 * @model annotation="http://www.modelexecution.org/trace/XMOF executionMetamodelElement='null'"
 * @generated
 */
public interface FSMClock_numberOfTicks_Value extends Value {
	/**
	 * Returns the value of the '<em><b>Number Of Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Ticks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Ticks</em>' attribute.
	 * @see #setNumberOfTicks(Integer)
	 * @see tfsmTrace.States.StatesPackage#getFSMClock_numberOfTicks_Value_NumberOfTicks()
	 * @model
	 * @generated
	 */
	Integer getNumberOfTicks();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getNumberOfTicks <em>Number Of Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Ticks</em>' attribute.
	 * @see #getNumberOfTicks()
	 * @generated
	 */
	void setNumberOfTicks(Integer value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.tfsm.TracedFSMClock#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(TracedFSMClock)
	 * @see tfsmTrace.States.StatesPackage#getFSMClock_numberOfTicks_Value_Parent()
	 * @see tfsmTrace.States.tfsm.TracedFSMClock#getNumberOfTicksSequence
	 * @model opposite="numberOfTicksSequence" required="true" transient="false"
	 * @generated
	 */
	TracedFSMClock getParent();

	/**
	 * Sets the value of the '{@link tfsmTrace.States.FSMClock_numberOfTicks_Value#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TracedFSMClock value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' reference list.
	 * The list contents are of type {@link tfsmTrace.States.State}.
	 * It is bidirectional and its opposite is '{@link tfsmTrace.States.State#getFSMClock_numberOfTicks_Values <em>FSM Clock number Of Ticks Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' reference list.
	 * @see tfsmTrace.States.StatesPackage#getFSMClock_numberOfTicks_Value_States()
	 * @see tfsmTrace.States.State#getFSMClock_numberOfTicks_Values
	 * @model opposite="fSMClock_numberOfTicks_Values" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getStates();'"
	 * @generated
	 */
	EList<State> getStatesNoOpposite();

} // FSMClock_numberOfTicks_Value
