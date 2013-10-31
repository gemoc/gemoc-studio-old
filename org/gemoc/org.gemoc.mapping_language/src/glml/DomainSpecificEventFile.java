/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Event File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.DomainSpecificEventFile#getImports <em>Imports</em>}</li>
 *   <li>{@link glml.DomainSpecificEventFile#getLanguageEvents <em>Language Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getDomainSpecificEventFile()
 * @model
 * @generated
 */
public interface DomainSpecificEventFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference.
	 * @see #setImports(ImportStatement)
	 * @see glml.GlmlPackage#getDomainSpecificEventFile_Imports()
	 * @model containment="true"
	 * @generated
	 */
	ImportStatement getImports();

	/**
	 * Sets the value of the '{@link glml.DomainSpecificEventFile#getImports <em>Imports</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imports</em>' containment reference.
	 * @see #getImports()
	 * @generated
	 */
	void setImports(ImportStatement value);

	/**
	 * Returns the value of the '<em><b>Language Events</b></em>' containment reference list.
	 * The list contents are of type {@link glml.LanguageSpecificEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Events</em>' containment reference list.
	 * @see glml.GlmlPackage#getDomainSpecificEventFile_LanguageEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<LanguageSpecificEvent> getLanguageEvents();

} // DomainSpecificEventFile
