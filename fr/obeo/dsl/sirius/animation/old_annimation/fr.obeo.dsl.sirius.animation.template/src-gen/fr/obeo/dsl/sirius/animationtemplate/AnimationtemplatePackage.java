/**
 */
package fr.obeo.dsl.sirius.animationtemplate;

import fr.obeo.dsl.viewpoint.description.DescriptionPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplateFactory
 * @model kind="package"
 * @generated
 */
public interface AnimationtemplatePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "animationtemplate";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/sirius/animation/template";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "animationtemplate";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnimationtemplatePackage eINSTANCE = fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.AnimationTemplateImpl <em>Animation Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationTemplateImpl
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getAnimationTemplate()
	 * @generated
	 */
	int ANIMATION_TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TEMPLATE__NAME = DescriptionPackage.REPRESENTATION_TEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Representations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TEMPLATE__OWNED_REPRESENTATIONS = DescriptionPackage.REPRESENTATION_TEMPLATE__OWNED_REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TEMPLATE__OUTPUTS = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Animate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TEMPLATE__ANIMATE = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Animation Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATION_TEMPLATE_FEATURE_COUNT = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl <em>Free Diagram Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getFreeDiagramTemplate()
	 * @generated
	 */
	int FREE_DIAGRAM_TEMPLATE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_DIAGRAM_TEMPLATE__NAME = DescriptionPackage.REPRESENTATION_TEMPLATE__NAME;

	/**
	 * The feature id for the '<em><b>Owned Representations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_DIAGRAM_TEMPLATE__OWNED_REPRESENTATIONS = DescriptionPackage.REPRESENTATION_TEMPLATE__OWNED_REPRESENTATIONS;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_DIAGRAM_TEMPLATE__OUTPUTS = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Free Diagram Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FREE_DIAGRAM_TEMPLATE_FEATURE_COUNT = DescriptionPackage.REPRESENTATION_TEMPLATE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.TTransformerImpl <em>TTransformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.TTransformerImpl
	 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getTTransformer()
	 * @generated
	 */
	int TTRANSFORMER = 2;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTRANSFORMER__OUTPUTS = 0;

	/**
	 * The number of structural features of the '<em>TTransformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTRANSFORMER_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate <em>Animation Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animation Template</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate
	 * @generated
	 */
	EClass getAnimationTemplate();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate#getAnimate <em>Animate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Animate</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate#getAnimate()
	 * @see #getAnimationTemplate()
	 * @generated
	 */
	EReference getAnimationTemplate_Animate();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate <em>Free Diagram Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Free Diagram Template</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate
	 * @generated
	 */
	EClass getFreeDiagramTemplate();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate#getDomainClass <em>Domain Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain Class</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate#getDomainClass()
	 * @see #getFreeDiagramTemplate()
	 * @generated
	 */
	EReference getFreeDiagramTemplate_DomainClass();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.sirius.animationtemplate.TTransformer <em>TTransformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTransformer</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.TTransformer
	 * @generated
	 */
	EClass getTTransformer();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.sirius.animationtemplate.TTransformer#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see fr.obeo.dsl.sirius.animationtemplate.TTransformer#getOutputs()
	 * @see #getTTransformer()
	 * @generated
	 */
	EReference getTTransformer_Outputs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnimationtemplateFactory getAnimationtemplateFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.AnimationTemplateImpl <em>Animation Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationTemplateImpl
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getAnimationTemplate()
		 * @generated
		 */
		EClass ANIMATION_TEMPLATE = eINSTANCE.getAnimationTemplate();

		/**
		 * The meta object literal for the '<em><b>Animate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANIMATION_TEMPLATE__ANIMATE = eINSTANCE.getAnimationTemplate_Animate();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl <em>Free Diagram Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.FreeDiagramTemplateImpl
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getFreeDiagramTemplate()
		 * @generated
		 */
		EClass FREE_DIAGRAM_TEMPLATE = eINSTANCE.getFreeDiagramTemplate();

		/**
		 * The meta object literal for the '<em><b>Domain Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS = eINSTANCE.getFreeDiagramTemplate_DomainClass();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.sirius.animationtemplate.impl.TTransformerImpl <em>TTransformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.TTransformerImpl
		 * @see fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplatePackageImpl#getTTransformer()
		 * @generated
		 */
		EClass TTRANSFORMER = eINSTANCE.getTTransformer();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTRANSFORMER__OUTPUTS = eINSTANCE.getTTransformer_Outputs();

	}

} //AnimationtemplatePackage
