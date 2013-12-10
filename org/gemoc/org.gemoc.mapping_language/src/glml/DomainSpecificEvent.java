/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.DomainSpecificEvent#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link glml.DomainSpecificEvent#getOperations <em>Operations</em>}</li>
 *   <li>{@link glml.DomainSpecificEvent#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getDomainSpecificEvent()
 * @model
 * @generated
 */
public interface DomainSpecificEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Class</em>' reference.
	 * @see #setTargetClass(EClassifier)
	 * @see glml.GlmlPackage#getDomainSpecificEvent_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getTargetClass();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificEvent#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(EClassifier value);

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
	 * @see glml.GlmlPackage#getDomainSpecificEvent_Operations()
	 * @model
	 * @generated
	 */
	EList<EOperation> getOperations();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(MocRelation)
	 * @see glml.GlmlPackage#getDomainSpecificEvent_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MocRelation getCondition();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificEvent#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(MocRelation value);

} // DomainSpecificEvent
