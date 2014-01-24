/**
 */
package fr.obeo.dsl.sirius.animationtemplate.impl;

import fr.obeo.dsl.sirius.animationtemplate.AnimationTemplate;
import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplateFactory;
import fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage;
import fr.obeo.dsl.sirius.animationtemplate.FreeDiagramTemplate;

import fr.obeo.dsl.sirius.animationtemplate.TTransformer;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

import fr.obeo.dsl.viewpoint.description.DescriptionPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnimationtemplatePackageImpl extends EPackageImpl implements AnimationtemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animationTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeDiagramTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTransformerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.obeo.dsl.sirius.animationtemplate.AnimationtemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnimationtemplatePackageImpl() {
		super(eNS_URI, AnimationtemplateFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AnimationtemplatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnimationtemplatePackage init() {
		if (isInited) return (AnimationtemplatePackage)EPackage.Registry.INSTANCE.getEPackage(AnimationtemplatePackage.eNS_URI);

		// Obtain or create and register package
		AnimationtemplatePackageImpl theAnimationtemplatePackage = (AnimationtemplatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnimationtemplatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnimationtemplatePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ViewpointPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAnimationtemplatePackage.createPackageContents();

		// Initialize created meta-data
		theAnimationtemplatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnimationtemplatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnimationtemplatePackage.eNS_URI, theAnimationtemplatePackage);
		return theAnimationtemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimationTemplate() {
		return animationTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnimationTemplate_Animate() {
		return (EReference)animationTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreeDiagramTemplate() {
		return freeDiagramTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFreeDiagramTemplate_DomainClass() {
		return (EReference)freeDiagramTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTransformer() {
		return tTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTransformer_Outputs() {
		return (EReference)tTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationtemplateFactory getAnimationtemplateFactory() {
		return (AnimationtemplateFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		animationTemplateEClass = createEClass(ANIMATION_TEMPLATE);
		createEReference(animationTemplateEClass, ANIMATION_TEMPLATE__ANIMATE);

		freeDiagramTemplateEClass = createEClass(FREE_DIAGRAM_TEMPLATE);
		createEReference(freeDiagramTemplateEClass, FREE_DIAGRAM_TEMPLATE__DOMAIN_CLASS);

		tTransformerEClass = createEClass(TTRANSFORMER);
		createEReference(tTransformerEClass, TTRANSFORMER__OUTPUTS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DescriptionPackage theDescriptionPackage = (DescriptionPackage)EPackage.Registry.INSTANCE.getEPackage(DescriptionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		animationTemplateEClass.getESuperTypes().add(theDescriptionPackage.getRepresentationTemplate());
		animationTemplateEClass.getESuperTypes().add(this.getTTransformer());
		freeDiagramTemplateEClass.getESuperTypes().add(theDescriptionPackage.getRepresentationTemplate());
		freeDiagramTemplateEClass.getESuperTypes().add(this.getTTransformer());

		// Initialize classes and features; add operations and parameters
		initEClass(animationTemplateEClass, AnimationTemplate.class, "AnimationTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnimationTemplate_Animate(), theDescriptionPackage.getRepresentationDescription(), null, "animate", null, 1, -1, AnimationTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(freeDiagramTemplateEClass, FreeDiagramTemplate.class, "FreeDiagramTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFreeDiagramTemplate_DomainClass(), ecorePackage.getEClass(), null, "domainClass", null, 1, 1, FreeDiagramTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTransformerEClass, TTransformer.class, "TTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTransformer_Outputs(), ecorePackage.getEObject(), null, "outputs", null, 0, -1, TTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AnimationtemplatePackageImpl
