/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Specific Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ModelSpecificAction#getReification <em>Reification</em>}</li>
 *   <li>{@link glml.ModelSpecificAction#getTarget <em>Target</em>}</li>
 *   <li>{@link glml.ModelSpecificAction#getOperation <em>Operation</em>}</li>
 *   <li>{@link glml.ModelSpecificAction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link glml.ModelSpecificAction#getOwningModelSpecificEvent <em>Owning Model Specific Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getModelSpecificAction()
 * @model
 * @generated
 */
public interface ModelSpecificAction extends EObject {
	/**
	 * Returns the value of the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reification</em>' reference.
	 * @see #setReification(DomainSpecificAction)
	 * @see glml.GlmlPackage#getModelSpecificAction_Reification()
	 * @model required="true"
	 * @generated
	 */
	DomainSpecificAction getReification();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificAction#getReification <em>Reification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reification</em>' reference.
	 * @see #getReification()
	 * @generated
	 */
	void setReification(DomainSpecificAction value);

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
	 * @see glml.GlmlPackage#getModelSpecificAction_Target()
	 * @model required="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificAction#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

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
	 * @see glml.GlmlPackage#getModelSpecificAction_Operation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificAction#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see glml.GlmlPackage#getModelSpecificAction_Parameters()
	 * @model
	 * @generated
	 */
	EList<EObject> getParameters();

	/**
	 * Returns the value of the '<em><b>Owning Model Specific Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Model Specific Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Model Specific Event</em>' reference.
	 * @see #setOwningModelSpecificEvent(ModelSpecificEvent)
	 * @see glml.GlmlPackage#getModelSpecificAction_OwningModelSpecificEvent()
	 * @model required="true"
	 * @generated
	 */
	ModelSpecificEvent getOwningModelSpecificEvent();

	/**
	 * Sets the value of the '{@link glml.ModelSpecificAction#getOwningModelSpecificEvent <em>Owning Model Specific Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Model Specific Event</em>' reference.
	 * @see #getOwningModelSpecificEvent()
	 * @generated
	 */
	void setOwningModelSpecificEvent(ModelSpecificEvent value);

} // ModelSpecificAction
