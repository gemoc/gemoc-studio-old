/**
 */
package sigpmlextended;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getHWPlatform()
 * @model
 * @generated
 */
public interface HWPlatform extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned HW Resources</b></em>' containment reference list.
	 * The list contents are of type {@link sigpmlextended.HWRessource}.
	 * It is bidirectional and its opposite is '{@link sigpmlextended.HWRessource#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned HW Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned HW Resources</em>' containment reference list.
	 * @see sigpmlextended.SigpmlextendedPackage#getHWPlatform_OwnedHWResources()
	 * @see sigpmlextended.HWRessource#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<HWRessource> getOwnedHWResources();

} // HWPlatform
