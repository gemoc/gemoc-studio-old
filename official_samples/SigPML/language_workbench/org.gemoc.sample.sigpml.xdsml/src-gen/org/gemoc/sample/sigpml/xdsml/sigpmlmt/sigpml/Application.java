/**
 */
package org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Application#getOwnedPlaces <em>Owned Places</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.SigpmlPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Agents</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Agent}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Agent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Agents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Agents</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.SigpmlPackage#getApplication_OwnedAgents()
	 * @see org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Agent#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Agent> getOwnedAgents();

	/**
	 * Returns the value of the '<em><b>Owned Places</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Place}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Place#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Places</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Places</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.SigpmlPackage#getApplication_OwnedPlaces()
	 * @see org.gemoc.sample.sigpml.xdsml.sigpmlmt.sigpml.Place#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Place> getOwnedPlaces();

} // Application
