/**
 */
package glml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spatial Coincidence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.SpatialCoincidence#getFirstArgument <em>First Argument</em>}</li>
 *   <li>{@link glml.SpatialCoincidence#getSecondArgument <em>Second Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getSpatialCoincidence()
 * @model
 * @generated
 */
public interface SpatialCoincidence extends Pattern {
	/**
	 * Returns the value of the '<em><b>First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Argument</em>' containment reference.
	 * @see #setFirstArgument(MocEvent)
	 * @see glml.GlmlPackage#getSpatialCoincidence_FirstArgument()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MocEvent getFirstArgument();

	/**
	 * Sets the value of the '{@link glml.SpatialCoincidence#getFirstArgument <em>First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Argument</em>' containment reference.
	 * @see #getFirstArgument()
	 * @generated
	 */
	void setFirstArgument(MocEvent value);

	/**
	 * Returns the value of the '<em><b>Second Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Argument</em>' containment reference.
	 * @see #setSecondArgument(MocEvent)
	 * @see glml.GlmlPackage#getSpatialCoincidence_SecondArgument()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MocEvent getSecondArgument();

	/**
	 * Sets the value of the '{@link glml.SpatialCoincidence#getSecondArgument <em>Second Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Argument</em>' containment reference.
	 * @see #getSecondArgument()
	 * @generated
	 */
	void setSecondArgument(MocEvent value);

} // SpatialCoincidence
