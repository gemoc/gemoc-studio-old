/**
 */
package fr.obeo.dsl.sirius.animationtemplate;

import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;


import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Free Diagram Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate#getDomainClass <em>Domain Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getFreeDiagramTemplate()
 * @model
 * @generated
 */
public interface FreeDiagramTemplate extends RepresentationTemplate, TTransformer {
	/**
	 * Returns the value of the '<em><b>Domain Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Class</em>' reference.
	 * @see #setDomainClass(EClass)
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#getFreeDiagramTemplate_DomainClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getDomainClass();

	/**
	 * Sets the value of the '{@link fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate#getDomainClass <em>Domain Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Class</em>' reference.
	 * @see #getDomainClass()
	 * @generated
	 */
	void setDomainClass(EClass value);

} // FreeDiagramTemplate
