/**
 */
package glml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moc Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link glml.MocRelation#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see glml.GlmlPackage#getMocRelation()
 * @model abstract="true"
 * @generated
 */
public interface MocRelation extends EObject {

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see glml.GlmlPackage#getMocRelation_Arguments()
	 * @model
	 * @generated
	 */
	EList<EObject> getArguments();
} // MocRelation
