/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.ProcessContext#getDefinition <em>Definition</em>}</li>
 * <li>{@link fr.obeo.dsl.process.ProcessContext#getProgress <em>Progress</em>}</li>
 * </ul>
 * </p>
 * 
 * @see fr.obeo.dsl.process.ProcessPackage#getProcessContext()
 * @model
 * @generated
 */
public interface ProcessContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessContext_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ProcessContext#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(fr.obeo.dsl.process.Process)
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessContext_Definition()
	 * @model required="true"
	 * @generated
	 */
	fr.obeo.dsl.process.Process getDefinition();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.process.ProcessContext#getDefinition <em>Definition</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(fr.obeo.dsl.process.Process value);

	/**
	 * Returns the value of the '<em><b>Progress</b></em>' map. The key is of type
	 * {@link fr.obeo.dsl.process.Task}, and the value is of type {@link java.lang.Object}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Progress</em>' map.
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessContext_Progress()
	 * @model mapType=
	 *        "fr.obeo.dsl.process.TaskToArtifactMap<fr.obeo.dsl.process.Task, fr.obeo.dsl.process.Artifact>"
	 * @generated
	 */
	EMap<ActionTask, Object> getProgress();

} // ProcessContext
