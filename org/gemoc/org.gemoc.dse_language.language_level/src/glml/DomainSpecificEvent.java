/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.DomainSpecificEvent#getCondition <em>Condition</em>}</li>
 *   <li>{@link glml.DomainSpecificEvent#getDomainSpecificActions <em>Domain Specific Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getDomainSpecificEvent()
 * @model
 * @generated
 */
public interface DomainSpecificEvent extends NamedElement {
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
	 * @see glml.GlmlPackage#getDomainSpecificEvent_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getCondition();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificEvent#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Pattern value);

	/**
	 * Returns the value of the '<em><b>Domain Specific Actions</b></em>' containment reference list.
	 * The list contents are of type {@link glml.DomainSpecificAction}.
	 * It is bidirectional and its opposite is '{@link glml.DomainSpecificAction#getOwningDomainSpecificEvent <em>Owning Domain Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Specific Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Specific Actions</em>' containment reference list.
	 * @see glml.GlmlPackage#getDomainSpecificEvent_DomainSpecificActions()
	 * @see glml.DomainSpecificAction#getOwningDomainSpecificEvent
	 * @model opposite="owningDomainSpecificEvent" containment="true"
	 * @generated
	 */
	EList<DomainSpecificAction> getDomainSpecificActions();

} // DomainSpecificEvent
