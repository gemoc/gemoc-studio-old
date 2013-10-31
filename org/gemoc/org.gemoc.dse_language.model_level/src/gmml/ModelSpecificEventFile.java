/**
 */
package gmml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Specific Event File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gmml.ModelSpecificEventFile#getImport <em>Import</em>}</li>
 *   <li>{@link gmml.ModelSpecificEventFile#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see gmml.GmmlPackage#getModelSpecificEventFile()
 * @model
 * @generated
 */
public interface ModelSpecificEventFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(ImportStatement)
	 * @see gmml.GmmlPackage#getModelSpecificEventFile_Import()
	 * @model required="true"
	 * @generated
	 */
	ImportStatement getImport();

	/**
	 * Sets the value of the '{@link gmml.ModelSpecificEventFile#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(ImportStatement value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' reference list.
	 * The list contents are of type {@link gmml.ModelSpecificEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' reference list.
	 * @see gmml.GmmlPackage#getModelSpecificEventFile_Events()
	 * @model
	 * @generated
	 */
	EList<ModelSpecificEvent> getEvents();

} // ModelSpecificEventFile
