/**
 */
package gee_configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DSE Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gee_configuration.DSEModel#getMapped_mocc <em>Mapped mocc</em>}</li>
 *   <li>{@link gee_configuration.DSEModel#getMapped_dsa <em>Mapped dsa</em>}</li>
 * </ul>
 * </p>
 *
 * @see gee_configuration.Gee_configurationPackage#getDSEModel()
 * @model
 * @generated
 */
public interface DSEModel extends LocalResource {
	/**
	 * Returns the value of the '<em><b>Mapped mocc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped mocc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped mocc</em>' reference.
	 * @see #setMapped_mocc(MoccModel)
	 * @see gee_configuration.Gee_configurationPackage#getDSEModel_Mapped_mocc()
	 * @model required="true"
	 * @generated
	 */
	MoccModel getMapped_mocc();

	/**
	 * Sets the value of the '{@link gee_configuration.DSEModel#getMapped_mocc <em>Mapped mocc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped mocc</em>' reference.
	 * @see #getMapped_mocc()
	 * @generated
	 */
	void setMapped_mocc(MoccModel value);

	/**
	 * Returns the value of the '<em><b>Mapped dsa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped dsa</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped dsa</em>' reference.
	 * @see #setMapped_dsa(DSAModel)
	 * @see gee_configuration.Gee_configurationPackage#getDSEModel_Mapped_dsa()
	 * @model required="true"
	 * @generated
	 */
	DSAModel getMapped_dsa();

	/**
	 * Sets the value of the '{@link gee_configuration.DSEModel#getMapped_dsa <em>Mapped dsa</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped dsa</em>' reference.
	 * @see #getMapped_dsa()
	 * @generated
	 */
	void setMapped_dsa(DSAModel value);

} // DSEModel
