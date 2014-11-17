/**
 */
package org.gemoc.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sigpml.Agent#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link org.gemoc.sigpml.Agent#getCycles <em>Cycles</em>}</li>
 *   <li>{@link org.gemoc.sigpml.Agent#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gemoc.sigpml.Agent#getCode <em>Code</em>}</li>
 *   <li>{@link org.gemoc.sigpml.Agent#getAllocatedTo <em>Allocated To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sigpml.SigpmlPackage#getAgent()
 * @model
 * @generated
 */
public interface Agent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sigpml.Port}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sigpml.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Ports</em>' containment reference list.
	 * @see org.gemoc.sigpml.SigpmlPackage#getAgent_OwnedPorts()
	 * @see org.gemoc.sigpml.Port#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Port> getOwnedPorts();

	/**
	 * Returns the value of the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycles</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cycles</em>' attribute.
	 * @see #setCycles(int)
	 * @see org.gemoc.sigpml.SigpmlPackage#getAgent_Cycles()
	 * @model
	 * @generated
	 */
	int getCycles();

	/**
	 * Sets the value of the '{@link org.gemoc.sigpml.Agent#getCycles <em>Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycles</em>' attribute.
	 * @see #getCycles()
	 * @generated
	 */
	void setCycles(int value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see org.gemoc.sigpml.SigpmlPackage#getAgent_Owner()
	 * @see org.gemoc.sigpml.Application#getOwnedAgents
	 * @model opposite="ownedAgents" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link org.gemoc.sigpml.Agent#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see org.gemoc.sigpml.SigpmlPackage#getAgent_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.gemoc.sigpml.Agent#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Allocated To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated To</em>' reference.
	 * @see #setAllocatedTo(HWComputationalResource)
	 * @see org.gemoc.sigpml.SigpmlPackage#getAgent_AllocatedTo()
	 * @model
	 * @generated
	 */
	HWComputationalResource getAllocatedTo();

	/**
	 * Sets the value of the '{@link org.gemoc.sigpml.Agent#getAllocatedTo <em>Allocated To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated To</em>' reference.
	 * @see #getAllocatedTo()
	 * @generated
	 */
	void setAllocatedTo(HWComputationalResource value);

} // Agent
