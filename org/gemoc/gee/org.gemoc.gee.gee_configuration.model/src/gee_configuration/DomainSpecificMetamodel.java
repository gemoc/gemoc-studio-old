/**
 */
package gee_configuration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Specific Metamodel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gee_configuration.DomainSpecificMetamodel#getEditors <em>Editors</em>}</li>
 * </ul>
 * </p>
 *
 * @see gee_configuration.Gee_configurationPackage#getDomainSpecificMetamodel()
 * @model
 * @generated
 */
public interface DomainSpecificMetamodel extends LocalResource {
	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link gee_configuration.DomainSpecificEditor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see gee_configuration.Gee_configurationPackage#getDomainSpecificMetamodel_Editors()
	 * @model
	 * @generated
	 */
	EList<DomainSpecificEditor> getEditors();

} // DomainSpecificMetamodel
