/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.LanguageSpecificEvent#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link glml.LanguageSpecificEvent#getOperations <em>Operations</em>}</li>
 *   <li>{@link glml.LanguageSpecificEvent#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getLanguageSpecificEvent()
 * @model
 * @generated
 */
public interface LanguageSpecificEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(EClass)
	 * @see glml.GlmlPackage#getLanguageSpecificEvent_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getTargetClass();

	/**
	 * Sets the value of the '{@link glml.LanguageSpecificEvent#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see glml.GlmlPackage#getLanguageSpecificEvent_Operations()
	 * @model
	 * @generated
	 */
	EList<EOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see glml.GlmlPackage#getLanguageSpecificEvent_Condition()
	 * @model required="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link glml.LanguageSpecificEvent#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // LanguageSpecificEvent
