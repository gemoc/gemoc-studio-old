/**
 */
package gemoc_language_designer_conf.impl;

import gemoc_language_designer_conf.*;

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
public class Gemoc_language_designer_confFactoryImpl extends EFactoryImpl implements Gemoc_language_designer_confFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Gemoc_language_designer_confFactory init() {
		try {
			Gemoc_language_designer_confFactory theGemoc_language_designer_confFactory = (Gemoc_language_designer_confFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.gemoc.org/gemoc_language_designer_conf"); 
			if (theGemoc_language_designer_confFactory != null) {
				return theGemoc_language_designer_confFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Gemoc_language_designer_confFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_language_designer_confFactoryImpl() {
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
			case Gemoc_language_designer_confPackage.GEMOC_LANGUAGE_DESIGNER_CONFIGURATION: return createGemocLanguageDesignerConfiguration();
			case Gemoc_language_designer_confPackage.PROJECT_RESOURCE: return createProjectResource();
			case Gemoc_language_designer_confPackage.KERMETA2_DSA_PROJECT: return createKermeta2DSAProject();
			case Gemoc_language_designer_confPackage.LANGUAGE_DEFINITION: return createLanguageDefinition();
			case Gemoc_language_designer_confPackage.DOMAIN_MODEL_PROJECT: return createDomainModelProject();
			case Gemoc_language_designer_confPackage.CCSL_MO_CPROJECT: return createCCSLMoCProject();
			case Gemoc_language_designer_confPackage.ANIMATOR_PROJECT: return createAnimatorProject();
			case Gemoc_language_designer_confPackage.EMF_ECORE_PROJECT: return createEMFEcoreProject();
			case Gemoc_language_designer_confPackage.OD_PROJECT: return createODProject();
			case Gemoc_language_designer_confPackage.SIRIUS_ANIMATOR_PROJECT: return createSiriusAnimatorProject();
			case Gemoc_language_designer_confPackage.MOD_HEL_XMO_CPROJECT: return createModHelXMoCProject();
			case Gemoc_language_designer_confPackage.DSE_PROJECT: return createDSEProject();
			case Gemoc_language_designer_confPackage.ECL_PROJECT: return createECLProject();
			case Gemoc_language_designer_confPackage.TREE_EDITOR_PROJECT: return createTreeEditorProject();
			case Gemoc_language_designer_confPackage.ECORE_MODEL: return createEcoreModel();
			case Gemoc_language_designer_confPackage.FILE_RESOURCE: return createFileResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocLanguageDesignerConfiguration createGemocLanguageDesignerConfiguration() {
		GemocLanguageDesignerConfigurationImpl gemocLanguageDesignerConfiguration = new GemocLanguageDesignerConfigurationImpl();
		return gemocLanguageDesignerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectResource createProjectResource() {
		ProjectResourceImpl projectResource = new ProjectResourceImpl();
		return projectResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kermeta2DSAProject createKermeta2DSAProject() {
		Kermeta2DSAProjectImpl kermeta2DSAProject = new Kermeta2DSAProjectImpl();
		return kermeta2DSAProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageDefinition createLanguageDefinition() {
		LanguageDefinitionImpl languageDefinition = new LanguageDefinitionImpl();
		return languageDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainModelProject createDomainModelProject() {
		DomainModelProjectImpl domainModelProject = new DomainModelProjectImpl();
		return domainModelProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSLMoCProject createCCSLMoCProject() {
		CCSLMoCProjectImpl ccslMoCProject = new CCSLMoCProjectImpl();
		return ccslMoCProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimatorProject createAnimatorProject() {
		AnimatorProjectImpl animatorProject = new AnimatorProjectImpl();
		return animatorProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFEcoreProject createEMFEcoreProject() {
		EMFEcoreProjectImpl emfEcoreProject = new EMFEcoreProjectImpl();
		return emfEcoreProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ODProject createODProject() {
		ODProjectImpl odProject = new ODProjectImpl();
		return odProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiriusAnimatorProject createSiriusAnimatorProject() {
		SiriusAnimatorProjectImpl siriusAnimatorProject = new SiriusAnimatorProjectImpl();
		return siriusAnimatorProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModHelXMoCProject createModHelXMoCProject() {
		ModHelXMoCProjectImpl modHelXMoCProject = new ModHelXMoCProjectImpl();
		return modHelXMoCProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSEProject createDSEProject() {
		DSEProjectImpl dseProject = new DSEProjectImpl();
		return dseProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ECLProject createECLProject() {
		ECLProjectImpl eclProject = new ECLProjectImpl();
		return eclProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeEditorProject createTreeEditorProject() {
		TreeEditorProjectImpl treeEditorProject = new TreeEditorProjectImpl();
		return treeEditorProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreModel createEcoreModel() {
		EcoreModelImpl ecoreModel = new EcoreModelImpl();
		return ecoreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileResource createFileResource() {
		FileResourceImpl fileResource = new FileResourceImpl();
		return fileResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_language_designer_confPackage getGemoc_language_designer_confPackage() {
		return (Gemoc_language_designer_confPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Gemoc_language_designer_confPackage getPackage() {
		return Gemoc_language_designer_confPackage.eINSTANCE;
	}

} //Gemoc_language_designer_confFactoryImpl
