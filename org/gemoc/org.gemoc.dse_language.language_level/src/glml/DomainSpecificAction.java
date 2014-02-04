/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.DomainSpecificAction#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link glml.DomainSpecificAction#getOperation <em>Operation</em>}</li>
 *   <li>{@link glml.DomainSpecificAction#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link glml.DomainSpecificAction#getOwningDomainSpecificEvent <em>Owning Domain Specific Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getDomainSpecificAction()
 * @model
 * @generated
 */
public interface DomainSpecificAction extends EObject {
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
	 * @see glml.GlmlPackage#getDomainSpecificAction_TargetClass()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getTargetClass();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificAction#getTargetClass <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Class</em>' reference.
	 * @see #getTargetClass()
	 * @generated
	 */
	void setTargetClass(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EOperation)
	 * @see glml.GlmlPackage#getDomainSpecificAction_Operation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificAction#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Parameter Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Types</em>' reference list.
	 * @see glml.GlmlPackage#getDomainSpecificAction_ParameterTypes()
	 * @model
	 * @generated
	 */
	EList<EClassifier> getParameterTypes();

	/**
	 * Returns the value of the '<em><b>Owning Domain Specific Event</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link glml.DomainSpecificEvent#getDomainSpecificActions <em>Domain Specific Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Domain Specific Event</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Domain Specific Event</em>' container reference.
	 * @see #setOwningDomainSpecificEvent(DomainSpecificEvent)
	 * @see glml.GlmlPackage#getDomainSpecificAction_OwningDomainSpecificEvent()
	 * @see glml.DomainSpecificEvent#getDomainSpecificActions
	 * @model opposite="domainSpecificActions" required="true" transient="false"
	 * @generated
	 */
	DomainSpecificEvent getOwningDomainSpecificEvent();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificAction#getOwningDomainSpecificEvent <em>Owning Domain Specific Event</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Domain Specific Event</em>' container reference.
	 * @see #getOwningDomainSpecificEvent()
	 * @generated
	 */
	void setOwningDomainSpecificEvent(DomainSpecificEvent value);

} // DomainSpecificAction
