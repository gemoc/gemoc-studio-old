/**
 */
package gee_configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gemoc Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gee_configuration.GemocConfiguration#getDsaModels <em>Dsa Models</em>}</li>
 *   <li>{@link gee_configuration.GemocConfiguration#getMoccModels <em>Mocc Models</em>}</li>
 *   <li>{@link gee_configuration.GemocConfiguration#getDseModels <em>Dse Models</em>}</li>
 *   <li>{@link gee_configuration.GemocConfiguration#getDomainSpecificMetamodels <em>Domain Specific Metamodels</em>}</li>
 *   <li>{@link gee_configuration.GemocConfiguration#getEditors <em>Editors</em>}</li>
 * </ul>
 * </p>
 *
 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration()
 * @model
 * @generated
 */
public interface GemocConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Dsa Models</b></em>' containment reference list.
	 * The list contents are of type {@link gee_configuration.DSAModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dsa Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dsa Models</em>' containment reference list.
	 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration_DsaModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DSAModel> getDsaModels();

	/**
	 * Returns the value of the '<em><b>Mocc Models</b></em>' containment reference list.
	 * The list contents are of type {@link gee_configuration.MoccModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mocc Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mocc Models</em>' containment reference list.
	 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration_MoccModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MoccModel> getMoccModels();

	/**
	 * Returns the value of the '<em><b>Dse Models</b></em>' containment reference list.
	 * The list contents are of type {@link gee_configuration.DSEModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dse Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dse Models</em>' containment reference list.
	 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration_DseModels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DSEModel> getDseModels();

	/**
	 * Returns the value of the '<em><b>Domain Specific Metamodels</b></em>' containment reference list.
	 * The list contents are of type {@link gee_configuration.DomainSpecificMetamodel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Specific Metamodels</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Specific Metamodels</em>' containment reference list.
	 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration_DomainSpecificMetamodels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DomainSpecificMetamodel> getDomainSpecificMetamodels();

	/**
	 * Returns the value of the '<em><b>Editors</b></em>' containment reference list.
	 * The list contents are of type {@link gee_configuration.DomainSpecificEditor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' containment reference list.
	 * @see gee_configuration.Gee_configurationPackage#getGemocConfiguration_Editors()
	 * @model containment="true"
	 * @generated
	 */
	EList<DomainSpecificEditor> getEditors();

} // GemocConfiguration
