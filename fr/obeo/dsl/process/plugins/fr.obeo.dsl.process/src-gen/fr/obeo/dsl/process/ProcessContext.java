/**
 */
package fr.obeo.dsl.process;

import java.util.Map;

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
	 * Returns the value of the '<em><b>Variables</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variables</em>' attribute.
	 * @see fr.obeo.dsl.process.ProcessPackage#getProcessContext_Variables()
	 * @model transient="true" changeable="false"
	 * @generated
	 */
	Map<ProcessVariable, ContextVariable> getVariables();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Tells if the given
	 * {@link ActionTask} is done. <!-- end-model-doc -->
	 * 
	 * @model required="true" taskRequired="true"
	 * @generated
	 */
	boolean isDone(ActionTask task);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Marks the given
	 * {@link ActionTask} as done with the given value attached to it. <!-- end-model-doc -->
	 * 
	 * @model taskRequired="true" valueDataType="fr.obeo.dsl.process.Artifact" valueRequired="true"
	 * @generated
	 */
	void setDone(ActionTask task, Object value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Marks the given
	 * {@link ActionTask} as undone with the given reason. <!-- end-model-doc -->
	 * 
	 * @model taskRequired="true"
	 * @generated
	 */
	void setUndone(ActionTask task, String reason);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Gets the result artifact
	 * attached to the given {@link ActionTask} if any, <code>null</code> otherwise. <!-- end-model-doc -->
	 * 
	 * @model dataType="fr.obeo.dsl.process.Artifact" required="true" taskRequired="true"
	 * @generated
	 */
	Object getResult(ActionTask task);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> sets the value for the
	 * {@link ProcessVariable} in the current context. The set will be accepted only if the writter
	 * {@link ActionTask} has declared himself as writter for this {@link ProcessVariable}. If writter is
	 * null, the chek is disabled and the set will be done. <!-- end-model-doc -->
	 * 
	 * @model exceptions="fr.obeo.dsl.process.IllegalVariableAccessException" variableRequired="true"
	 *        variableValueDataType="fr.obeo.dsl.process.Object" variableValueRequired="true"
	 * @generated
	 */
	void setVariableValue(ProcessVariable variable, Object variableValue, ActionTask writter)
			throws IllegalVariableAccessException;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> returns the value for the
	 * {@link ProcessVariable} in the current context. <!-- end-model-doc -->
	 * 
	 * @model dataType="fr.obeo.dsl.process.Object" processRequired="true"
	 * @generated
	 */
	Object getVariableValue(ProcessVariable process);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	String getUndoneReason(ActionTask task);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> find the {@link ProcessVariable}
	 * with the given name or null if no such variable definition exists. <!-- end-model-doc -->
	 * 
	 * @model variableNameRequired="true"
	 * @generated
	 */
	ProcessVariable getProcessVariable(String variableName);

} // ProcessContext
