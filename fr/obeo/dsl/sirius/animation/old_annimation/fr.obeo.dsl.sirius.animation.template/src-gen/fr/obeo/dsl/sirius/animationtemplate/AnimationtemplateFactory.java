/**
 */
package fr.obeo.dsl.sirius.animationtemplate;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage
 * @generated
 */
public interface AnimationtemplateFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnimationtemplateFactory eINSTANCE = fr.obeo.dsl.sirius.animationtemplate.impl.AnimationtemplateFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Animation Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Animation Template</em>'.
	 * @generated
	 */
	AnimationTemplate createAnimationTemplate();

	/**
	 * Returns a new object of class '<em>Free Diagram Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Free Diagram Template</em>'.
	 * @generated
	 */
	FreeDiagramTemplate createFreeDiagramTemplate();

	/**
	 * Returns a new object of class '<em>TTransformer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TTransformer</em>'.
	 * @generated
	 */
	TTransformer createTTransformer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnimationtemplatePackage getAnimationtemplatePackage();

} //AnimationtemplateFactory
