/**
 */
package glml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ModelSpecificEvent#getReification <em>Reification</em>}</li>
 *   <li>{@link glml.ModelSpecificEvent#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getModelSpecificEvent()
 * @model
 * @generated
 */
public interface ModelSpecificEvent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reification</em>' reference.
	 * @see #setReification(DomainSpecificEvent)
	 * @see glml.GlmlPackage#getModelSpecificEvent_Reification()
	 * @model
	 * @generated
	 */
	DomainSpecificEvent getReification();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificEvent#getReification <em>Reification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reification</em>' reference.
	 * @see #getReification()
	 * @generated
	 */
	void setReification(DomainSpecificEvent value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see glml.GlmlPackage#getModelSpecificEvent_Target()
	 * @model required="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificEvent#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

} // ModelSpecificEvent
