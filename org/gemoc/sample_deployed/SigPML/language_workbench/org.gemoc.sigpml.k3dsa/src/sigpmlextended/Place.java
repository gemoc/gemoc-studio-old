/**
 */
package sigpmlextended;

import java.util.ArrayList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.Place#getFifo <em>Fifo</em>}</li>
 *   <li>{@link sigpmlextended.Place#isIsInitialized <em>Is Initialized</em>}</li>
 *   <li>{@link sigpmlextended.Place#getCurrentSize <em>Current Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends org.gemoc.sigpml.Place {
	/**
	 * Returns the value of the '<em><b>Current Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Size</em>' attribute.
	 * @see #setCurrentSize(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_CurrentSize()
	 * @model
	 * @generated
	 */
	int getCurrentSize();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getCurrentSize <em>Current Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Size</em>' attribute.
	 * @see #getCurrentSize()
	 * @generated
	 */
	void setCurrentSize(int value);

	/**
	 * Returns the value of the '<em><b>Fifo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fifo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fifo</em>' attribute.
	 * @see #setFifo(ArrayList)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_Fifo()
	 * @model dataType="sigpmlextended.ArrayList"
	 * @generated
	 */
	ArrayList getFifo();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getFifo <em>Fifo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fifo</em>' attribute.
	 * @see #getFifo()
	 * @generated
	 */
	void setFifo(ArrayList value);

	/**
	 * Returns the value of the '<em><b>Is Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Initialized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Initialized</em>' attribute.
	 * @see #setIsInitialized(boolean)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_IsInitialized()
	 * @model
	 * @generated
	 */
	boolean isIsInitialized();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#isIsInitialized <em>Is Initialized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Initialized</em>' attribute.
	 * @see #isIsInitialized()
	 * @generated
	 */
	void setIsInitialized(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void pop();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void push();

} // Place
