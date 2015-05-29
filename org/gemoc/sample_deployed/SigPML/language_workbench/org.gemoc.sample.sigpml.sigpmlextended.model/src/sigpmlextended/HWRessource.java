/**
 */
package sigpmlextended;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Ressource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.HWRessource#getOwner <em>Owner</em>}</li>
 *   <li>{@link sigpmlextended.HWRessource#getConnectedTo <em>Connected To</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getHWRessource()
 * @model abstract="true"
 * @generated
 */
public interface HWRessource extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link sigpmlextended.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(HWPlatform)
	 * @see sigpmlextended.SigpmlextendedPackage#getHWRessource_Owner()
	 * @see sigpmlextended.HWPlatform#getOwnedHWResources
	 * @model opposite="ownedHWResources" transient="false"
	 * @generated
	 */
	HWPlatform getOwner();

	/**
	 * Sets the value of the '{@link sigpmlextended.HWRessource#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(HWPlatform value);

	/**
	 * Returns the value of the '<em><b>Connected To</b></em>' reference list.
	 * The list contents are of type {@link sigpmlextended.HWRessource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected To</em>' reference list.
	 * @see sigpmlextended.SigpmlextendedPackage#getHWRessource_ConnectedTo()
	 * @model
	 * @generated
	 */
	EList<HWRessource> getConnectedTo();

} // HWRessource
