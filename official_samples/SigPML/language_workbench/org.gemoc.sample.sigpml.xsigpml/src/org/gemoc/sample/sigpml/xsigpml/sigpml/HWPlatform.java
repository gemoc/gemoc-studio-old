/**
 */
package org.gemoc.sample.sigpml.xsigpml.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWPlatform#getOwnedHWResources <em>Owned HW Resources</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWPlatform()
 * @model
 * @generated
 */
public interface HWPlatform extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned HW Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWRessource}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xsigpml.sigpml.HWRessource#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned HW Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned HW Resources</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlPackage#getHWPlatform_OwnedHWResources()
	 * @see org.gemoc.sample.sigpml.xsigpml.sigpml.HWRessource#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<HWRessource> getOwnedHWResources();

} // HWPlatform
