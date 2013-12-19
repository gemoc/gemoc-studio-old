/**
 */
package fr.obeo.dsl.sirius.animationtemplate.impl;

import fr.obeo.dsl.sirius.animationtemplate.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimationtemplateFactoryImpl extends EFactoryImpl implements AnimationtemplateFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnimationtemplateFactory init() {
		try {
			AnimationtemplateFactory theAnimationtemplateFactory = (AnimationtemplateFactory)EPackage.Registry.INSTANCE.getEFactory(AnimationtemplatePackage.eNS_URI);
			if (theAnimationtemplateFactory != null) {
				return theAnimationtemplateFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnimationtemplateFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationtemplateFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnimationtemplatePackage.ANIMATION_TEMPLATE: return createAnimationTemplate();
			case AnimationtemplatePackage.FREE_DIAGRAM_TEMPLATE: return createFreeDiagramTemplate();
			case AnimationtemplatePackage.TTRANSFORMER: return createTTransformer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationTemplate createAnimationTemplate() {
		AnimationTemplateImpl animationTemplate = new AnimationTemplateImpl();
		return animationTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FreeDiagramTemplate createFreeDiagramTemplate() {
		FreeDiagramTemplateImpl freeDiagramTemplate = new FreeDiagramTemplateImpl();
		return freeDiagramTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTransformer createTTransformer() {
		TTransformerImpl tTransformer = new TTransformerImpl();
		return tTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationtemplatePackage getAnimationtemplatePackage() {
		return (AnimationtemplatePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnimationtemplatePackage getPackage() {
		return AnimationtemplatePackage.eINSTANCE;
	}

} //AnimationtemplateFactoryImpl
