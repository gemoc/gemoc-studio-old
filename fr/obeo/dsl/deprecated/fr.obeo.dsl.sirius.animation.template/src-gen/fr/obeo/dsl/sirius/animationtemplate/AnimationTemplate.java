/**
 */
package fr.obeo.dsl.sirius.animationtemplate;

import fr.obeo.dsl.viewpoint.description.RepresentationDescription;
import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animation Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate#getAnimate <em>Animate</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getAnimationTemplate()
 * @model
 * @generated
 */
public interface AnimationTemplate extends RepresentationTemplate, TTransformer {
	/**
	 * Returns the value of the '<em><b>Animate</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.viewpoint.description.RepresentationDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animate</em>' reference list.
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getAnimationTemplate_Animate()
	 * @model required="true"
	 * @generated
	 */
	EList<RepresentationDescription> getAnimate();

} // AnimationTemplate
