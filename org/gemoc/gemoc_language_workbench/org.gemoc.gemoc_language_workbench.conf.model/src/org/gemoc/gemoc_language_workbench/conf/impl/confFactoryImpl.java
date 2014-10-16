/**
 */
package org.gemoc.gemoc_language_workbench.conf.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.gemoc_language_workbench.conf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class confFactoryImpl extends EFactoryImpl implements confFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static confFactory init() {
		try {
			confFactory theconfFactory = (confFactory)EPackage.Registry.INSTANCE.getEFactory(confPackage.eNS_URI);
			if (theconfFactory != null) {
				return theconfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new confFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public confFactoryImpl() {
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
			case confPackage.LANGUAGE_DEFINITION: return createLanguageDefinition();
			case confPackage.DSA_PROJECT: return createDSAProject();
			case confPackage.DOMAIN_MODEL_PROJECT: return createDomainModelProject();
			case confPackage.MO_CC_PROJECT: return createMoCCProject();
			case confPackage.DSE_PROJECT: return createDSEProject();
			case confPackage.SIRIUS_EDITOR_PROJECT: return createSiriusEditorProject();
			case confPackage.SIRIUS_ANIMATOR_PROJECT: return createSiriusAnimatorProject();
			case confPackage.XTEXT_EDITOR_PROJECT: return createXTextEditorProject();
			case confPackage.TREE_EDITOR_PROJECT: return createTreeEditorProject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case confPackage.PROJECT_KIND:
				return createProjectKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case confPackage.PROJECT_KIND:
				return convertProjectKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public DSAProject createDSAProject() {
		DSAProjectImpl dsaProject = new DSAProjectImpl();
		return dsaProject;
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
	public MoCCProject createMoCCProject() {
		MoCCProjectImpl moCCProject = new MoCCProjectImpl();
		return moCCProject;
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
	public SiriusEditorProject createSiriusEditorProject() {
		SiriusEditorProjectImpl siriusEditorProject = new SiriusEditorProjectImpl();
		return siriusEditorProject;
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
	public XTextEditorProject createXTextEditorProject() {
		XTextEditorProjectImpl xTextEditorProject = new XTextEditorProjectImpl();
		return xTextEditorProject;
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
	public ProjectKind createProjectKindFromString(EDataType eDataType, String initialValue) {
		ProjectKind result = ProjectKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProjectKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public confPackage getconfPackage() {
		return (confPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static confPackage getPackage() {
		return confPackage.eINSTANCE;
	}

} //confFactoryImpl
