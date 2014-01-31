/**
 */
package glml;

import fr.inria.aoste.timesquare.ECL.EventType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Ccsl Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ExtendedCcslElement#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getExtendedCcslElement()
 * @model
 * @generated
 */
public interface ExtendedCcslElement extends MocElement {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EventType)
	 * @see glml.GlmlPackage#getExtendedCcslElement_Element()
	 * @model required="true"
	 * @generated
	 */
	EventType getElement();

	/**
	 * Sets the value of the '{@link glml.ExtendedCcslElement#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EventType value);

} // ExtendedCcslElement
