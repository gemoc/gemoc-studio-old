/**
 */
package fr.obeo.dsl.sirius.animationtemplate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTransformer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animationtemplate.TTransformer#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getTTransformer()
 * @model
 * @generated
 */
public interface TTransformer extends EObject {
	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getTTransformer_Outputs()
	 * @model
	 * @generated
	 */
	EList<EObject> getOutputs();

} // TTransformer
