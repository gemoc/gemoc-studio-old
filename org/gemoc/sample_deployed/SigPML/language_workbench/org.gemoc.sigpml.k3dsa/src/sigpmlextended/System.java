/**
 */
package sigpmlextended;

import com.google.common.collect.LinkedListMultimap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.System#getSharedMemory <em>Shared Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends org.gemoc.sigpml.System {
	/**
	 * Returns the value of the '<em><b>Shared Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Memory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Memory</em>' attribute.
	 * @see #setSharedMemory(LinkedListMultimap)
	 * @see sigpmlextended.SigpmlextendedPackage#getSystem_SharedMemory()
	 * @model dataType="sigpmlextended.LinkedListMultimap"
	 * @generated
	 */
	LinkedListMultimap getSharedMemory();

	/**
	 * Sets the value of the '{@link sigpmlextended.System#getSharedMemory <em>Shared Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Memory</em>' attribute.
	 * @see #getSharedMemory()
	 * @generated
	 */
	void setSharedMemory(LinkedListMultimap value);

} // System
