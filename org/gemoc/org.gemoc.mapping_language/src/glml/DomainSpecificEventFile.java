/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link glml.DomainSpecificEventFile#getModelEvents <em>Model Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getDomainSpecificEventFile()
 * @model
 * @generated
 */
public interface DomainSpecificEventFile extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link glml.ImportStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see glml.GlmlPackage#getDomainSpecificEventFile_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportStatement> getImports();

	/**
	 * Returns the value of the '<em><b>Language Events</b></em>' containment reference list.
	 * The list contents are of type {@link glml.DomainSpecificEvent}.
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
	EList<DomainSpecificEvent> getLanguageEvents();

	/**
	 * Returns the value of the '<em><b>Model Events</b></em>' containment reference list.
	 * The list contents are of type {@link glml.ModelSpecificEvent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Events</em>' containment reference list.
	 * @see glml.GlmlPackage#getDomainSpecificEventFile_ModelEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelSpecificEvent> getModelEvents();

} // DomainSpecificEventFile
