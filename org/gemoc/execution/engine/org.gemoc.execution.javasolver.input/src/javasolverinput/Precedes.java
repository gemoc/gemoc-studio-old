/**
 */
package javasolverinput;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Precedes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link javasolverinput.Precedes#getClock1 <em>Clock1</em>}</li>
 *   <li>{@link javasolverinput.Precedes#getClock2 <em>Clock2</em>}</li>
 * </ul>
 * </p>
 *
 * @see javasolverinput.JavasolverinputPackage#getPrecedes()
 * @model
 * @generated
 */
public interface Precedes extends Relation {
	/**
	 * Returns the value of the '<em><b>Clock1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock1</em>' reference.
	 * @see #setClock1(Clock)
	 * @see javasolverinput.JavasolverinputPackage#getPrecedes_Clock1()
	 * @model required="true"
	 * @generated
	 */
	Clock getClock1();

	/**
	 * Sets the value of the '{@link javasolverinput.Precedes#getClock1 <em>Clock1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock1</em>' reference.
	 * @see #getClock1()
	 * @generated
	 */
	void setClock1(Clock value);

	/**
	 * Returns the value of the '<em><b>Clock2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock2</em>' reference.
	 * @see #setClock2(Clock)
	 * @see javasolverinput.JavasolverinputPackage#getPrecedes_Clock2()
	 * @model required="true"
	 * @generated
	 */
	Clock getClock2();

	/**
	 * Sets the value of the '{@link javasolverinput.Precedes#getClock2 <em>Clock2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock2</em>' reference.
	 * @see #getClock2()
	 * @generated
	 */
	void setClock2(Clock value);

} // Precedes
