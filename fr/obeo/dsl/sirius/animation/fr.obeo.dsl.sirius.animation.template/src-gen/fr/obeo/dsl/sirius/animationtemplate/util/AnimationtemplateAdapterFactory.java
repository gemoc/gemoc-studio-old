/**
 */
package fr.obeo.dsl.sirius.animationtemplate.util;

import fr.obeo.dsl.sirius.animationtemplate.*;

import fr.obeo.dsl.viewpoint.description.RepresentationTemplate;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage
 * @generated
 */
public class AnimationtemplateAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnimationtemplatePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationtemplateAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnimationtemplatePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimationtemplateSwitch<Adapter> modelSwitch =
		new AnimationtemplateSwitch<Adapter>() {
			@Override
			public Adapter caseAnimationTemplate(AnimationTemplate object) {
				return createAnimationTemplateAdapter();
			}
			@Override
			public Adapter caseFreeDiagramTemplate(FreeDiagramTemplate object) {
				return createFreeDiagramTemplateAdapter();
			}
			@Override
			public Adapter caseTTransformer(TTransformer object) {
				return createTTransformerAdapter();
			}
			@Override
			public Adapter caseRepresentationTemplate(RepresentationTemplate object) {
				return createRepresentationTemplateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate <em>Animation Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate
	 * @generated
	 */
	public Adapter createAnimationTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate <em>Free Diagram Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate
	 * @generated
	 */
	public Adapter createFreeDiagramTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.sirius.animationtemplate.TTransformer <em>TTransformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.sirius.animationtemplate.TTransformer
	 * @generated
	 */
	public Adapter createTTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.viewpoint.description.RepresentationTemplate <em>Representation Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.viewpoint.description.RepresentationTemplate
	 * @generated
	 */
	public Adapter createRepresentationTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AnimationtemplateAdapterFactory
