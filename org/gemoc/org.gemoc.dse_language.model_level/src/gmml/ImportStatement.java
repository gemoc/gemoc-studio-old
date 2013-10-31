/**
 */
package gmml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gmml.ImportStatement#getDomainSpecificEventFileURI <em>Domain Specific Event File URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see gmml.GmmlPackage#getImportStatement()
 * @model
 * @generated
 */
public interface ImportStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Domain Specific Event File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Specific Event File URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Specific Event File URI</em>' attribute.
	 * @see #setDomainSpecificEventFileURI(String)
	 * @see gmml.GmmlPackage#getImportStatement_DomainSpecificEventFileURI()
	 * @model required="true"
	 * @generated
	 */
	String getDomainSpecificEventFileURI();

	/**
	 * Sets the value of the '{@link gmml.ImportStatement#getDomainSpecificEventFileURI <em>Domain Specific Event File URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Specific Event File URI</em>' attribute.
	 * @see #getDomainSpecificEventFileURI()
	 * @generated
	 */
	void setDomainSpecificEventFileURI(String value);

} // ImportStatement
