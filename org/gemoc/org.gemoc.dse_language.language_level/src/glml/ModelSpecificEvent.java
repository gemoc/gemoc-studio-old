/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ModelSpecificEvent#getReification <em>Reification</em>}</li>
 *   <li>{@link glml.ModelSpecificEvent#getCondition <em>Condition</em>}</li>
 *   <li>{@link glml.ModelSpecificEvent#getModelSpecificActions <em>Model Specific Actions</em>}</li>
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
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Pattern)
	 * @see glml.GlmlPackage#getModelSpecificEvent_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getCondition();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificEvent#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Pattern value);

	/**
	 * Returns the value of the '<em><b>Model Specific Actions</b></em>' containment reference list.
	 * The list contents are of type {@link glml.ModelSpecificAction}.
	 * It is bidirectional and its opposite is '{@link glml.ModelSpecificAction#getOwningModelSpecificEvent <em>Owning Model Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Specific Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Specific Actions</em>' containment reference list.
	 * @see glml.GlmlPackage#getModelSpecificEvent_ModelSpecificActions()
	 * @see glml.ModelSpecificAction#getOwningModelSpecificEvent
	 * @model opposite="owningModelSpecificEvent" containment="true"
	 * @generated
	 */
	EList<ModelSpecificAction> getModelSpecificActions();

} // ModelSpecificEvent
