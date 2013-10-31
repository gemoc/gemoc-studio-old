/**
 */
package gmml;

import glml.LanguageSpecificEvent;
import glml.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Specific Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gmml.ModelSpecificEvent#getTarget <em>Target</em>}</li>
 *   <li>{@link gmml.ModelSpecificEvent#getOperations <em>Operations</em>}</li>
 *   <li>{@link gmml.ModelSpecificEvent#getCondition <em>Condition</em>}</li>
 *   <li>{@link gmml.ModelSpecificEvent#getReification <em>Reification</em>}</li>
 * </ul>
 * </p>
 *
 * @see gmml.GmmlPackage#getModelSpecificEvent()
 * @model
 * @generated
 */
public interface ModelSpecificEvent extends NamedElement {
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
	 * @see gmml.GmmlPackage#getModelSpecificEvent_Target()
	 * @model required="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link gmml.ModelSpecificEvent#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

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
	 * @see gmml.GmmlPackage#getModelSpecificEvent_Operations()
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
	 * @see gmml.GmmlPackage#getModelSpecificEvent_Condition()
	 * @model required="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link gmml.ModelSpecificEvent#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reification</em>' reference.
	 * @see #setReification(LanguageSpecificEvent)
	 * @see gmml.GmmlPackage#getModelSpecificEvent_Reification()
	 * @model required="true"
	 * @generated
	 */
	LanguageSpecificEvent getReification();

	/**
	 * Sets the value of the '{@link gmml.ModelSpecificEvent#getReification <em>Reification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reification</em>' reference.
	 * @see #getReification()
	 * @generated
	 */
	void setReification(LanguageSpecificEvent value);

} // ModelSpecificEvent
