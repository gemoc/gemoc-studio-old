/**
 */
package sigpmlextended;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.Place#getItsOutputPort <em>Its Output Port</em>}</li>
 *   <li>{@link sigpmlextended.Place#getItsInputPort <em>Its Input Port</em>}</li>
 *   <li>{@link sigpmlextended.Place#getSize <em>Size</em>}</li>
 *   <li>{@link sigpmlextended.Place#getOwner <em>Owner</em>}</li>
 *   <li>{@link sigpmlextended.Place#getType <em>Type</em>}</li>
 *   <li>{@link sigpmlextended.Place#getByteSize <em>Byte Size</em>}</li>
 *   <li>{@link sigpmlextended.Place#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getPlace()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='matchRates'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot matchRates='if byteSize > 0 then byteSize >= itsOutputPort.byteRate and byteSize >= itsInputPort.byteRate else true endif'"
 * @generated
 */
public interface Place extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Output Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Output Port</em>' reference.
	 * @see #setItsOutputPort(OutputPort)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_ItsOutputPort()
	 * @model required="true"
	 * @generated
	 */
	OutputPort getItsOutputPort();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getItsOutputPort <em>Its Output Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Output Port</em>' reference.
	 * @see #getItsOutputPort()
	 * @generated
	 */
	void setItsOutputPort(OutputPort value);

	/**
	 * Returns the value of the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Its Input Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Its Input Port</em>' reference.
	 * @see #setItsInputPort(InputPort)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_ItsInputPort()
	 * @model required="true"
	 * @generated
	 */
	InputPort getItsInputPort();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getItsInputPort <em>Its Input Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Its Input Port</em>' reference.
	 * @see #getItsInputPort()
	 * @generated
	 */
	void setItsInputPort(InputPort value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link sigpmlextended.Application#getOwnedPlaces <em>Owned Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Application)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_Owner()
	 * @see sigpmlextended.Application#getOwnedPlaces
	 * @model opposite="ownedPlaces" required="true" transient="false"
	 * @generated
	 */
	Application getOwner();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Application value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link sigpmlextended.sizeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see sigpmlextended.sizeType
	 * @see #setType(sizeType)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_Type()
	 * @model required="true"
	 * @generated
	 */
	sizeType getType();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see sigpmlextended.sizeType
	 * @see #getType()
	 * @generated
	 */
	void setType(sizeType value);

	/**
	 * Returns the value of the '<em><b>Byte Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Byte Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Byte Size</em>' attribute.
	 * @see #setByteSize(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_ByteSize()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getByteSize();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getByteSize <em>Byte Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Byte Size</em>' attribute.
	 * @see #getByteSize()
	 * @generated
	 */
	void setByteSize(int value);

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(int)
	 * @see sigpmlextended.SigpmlextendedPackage#getPlace_Delay()
	 * @model
	 * @generated
	 */
	int getDelay();

	/**
	 * Sets the value of the '{@link sigpmlextended.Place#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(int value);

} // Place
