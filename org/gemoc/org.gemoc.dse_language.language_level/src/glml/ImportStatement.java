/**
 */
package glml;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.ImportStatement#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getImportStatement()
 * @model
 * @generated
 */
public interface ImportStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Import URI</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import URI</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import URI</em>' attribute list.
	 * @see glml.GlmlPackage#getImportStatement_ImportURI()
	 * @model
	 * @generated
	 */
	EList<String> getImportURI();

} // ImportStatement
