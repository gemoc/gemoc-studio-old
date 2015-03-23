/**
 */
package sigpmlextended;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HW Storage Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sigpmlextended.HWStorageResource#getAllocatedPlaces <em>Allocated Places</em>}</li>
 * </ul>
 * </p>
 *
 * @see sigpmlextended.SigpmlextendedPackage#getHWStorageResource()
 * @model
 * @generated
 */
public interface HWStorageResource extends HWRessource {
	/**
	 * Returns the value of the '<em><b>Allocated Places</b></em>' reference list.
	 * The list contents are of type {@link sigpmlextended.Place}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocated Places</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocated Places</em>' reference list.
	 * @see sigpmlextended.SigpmlextendedPackage#getHWStorageResource_AllocatedPlaces()
	 * @model
	 * @generated
	 */
	EList<Place> getAllocatedPlaces();

} // HWStorageResource
