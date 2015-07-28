/**
 */
package org.gemoc.sample.sigpml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getCycles <em>Cycles</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getCode <em>Code</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getAllocatedTo <em>Allocated To</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 *   <li>{@link org.gemoc.sample.sigpml.Agent#isIsCurrentlyExecuting <em>Is Currently Executing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent()
 * @model
 * @generated
 */
public interface Agent extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.sample.sigpml.Port}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Ports</em>' containment reference list.
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_OwnedPorts()
	 * @see org.gemoc.sample.sigpml.Port#getOwner
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
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_Cycles()
	 * @model
	 * @generated
	 */
	int getCycles();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#getCycles <em>Cycles</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycles</em>' attribute.
	 * @see #getCycles()
	 * @generated
	 */
	void setCycles(int value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.gemoc.sample.sigpml.Application#getOwnedAgents <em>Owned Agents</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_Owner()
	 * @see org.gemoc.sample.sigpml.Application#getOwnedAgents
	 * @model opposite="ownedAgents" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#getOwner <em>Owner</em>}' container reference.
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
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#getCode <em>Code</em>}' attribute.
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
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_AllocatedTo()
	 * @model
	 * @generated
	 */
	HWComputationalResource getAllocatedTo();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#getAllocatedTo <em>Allocated To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocated To</em>' reference.
	 * @see #getAllocatedTo()
	 * @generated
	 */
	void setAllocatedTo(HWComputationalResource value);

	/**
	 * Returns the value of the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Exec Cycle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #setCurrentExecCycle(int)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_CurrentExecCycle()
	 * @model
	 * @generated
	 */
	int getCurrentExecCycle();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#getCurrentExecCycle <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Exec Cycle</em>' attribute.
	 * @see #getCurrentExecCycle()
	 * @generated
	 */
	void setCurrentExecCycle(int value);

	/**
	 * Returns the value of the '<em><b>Is Currently Executing</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Currently Executing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Currently Executing</em>' attribute.
	 * @see #setIsCurrentlyExecuting(boolean)
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#getAgent_IsCurrentlyExecuting()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsCurrentlyExecuting();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.sigpml.Agent#isIsCurrentlyExecuting <em>Is Currently Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Currently Executing</em>' attribute.
	 * @see #isIsCurrentlyExecuting()
	 * @generated
	 */
	void setIsCurrentlyExecuting(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	void isExecuting();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void execute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void stop();

} // Agent
