/**
 */
package glml;

import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ECL Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ECLEvent#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getECLEvent()
 * @model
 * @generated
 */
public interface ECLEvent extends MocEvent {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(DefPropertyCS)
	 * @see glml.GlmlPackage#getECLEvent_Element()
	 * @model required="true"
	 * @generated
	 */
	DefPropertyCS getElement();

	/**
	 * Sets the value of the '{@link glml.ECLEvent#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(DefPropertyCS value);

} // ECLEvent
