/**
 */
package org.gemoc.gemoc_language_workbench.conf.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.gemoc_language_workbench.conf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage
 * @generated
 */
public class confAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static confPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public confAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = confPackage.eINSTANCE;
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
	protected confSwitch<Adapter> modelSwitch =
		new confSwitch<Adapter>() {
			@Override
			public Adapter caseGemocLanguageWorkbenchConfiguration(GemocLanguageWorkbenchConfiguration object) {
				return createGemocLanguageWorkbenchConfigurationAdapter();
			}
			@Override
			public Adapter caseProjectResource(ProjectResource object) {
				return createProjectResourceAdapter();
			}
			@Override
			public Adapter caseDSAProject(DSAProject object) {
				return createDSAProjectAdapter();
			}
			@Override
			public Adapter caseKermeta2DSAProject(Kermeta2DSAProject object) {
				return createKermeta2DSAProjectAdapter();
			}
			@Override
			public Adapter caseLanguageDefinition(LanguageDefinition object) {
				return createLanguageDefinitionAdapter();
			}
			@Override
			public Adapter caseEditorProject(EditorProject object) {
				return createEditorProjectAdapter();
			}
			@Override
			public Adapter caseDomainModelProject(DomainModelProject object) {
				return createDomainModelProjectAdapter();
			}
			@Override
			public Adapter caseMoCProject(MoCProject object) {
				return createMoCProjectAdapter();
			}
			@Override
			public Adapter caseCCSLMoCProject(CCSLMoCProject object) {
				return createCCSLMoCProjectAdapter();
			}
			@Override
			public Adapter caseAnimatorProject(AnimatorProject object) {
				return createAnimatorProjectAdapter();
			}
			@Override
			public Adapter caseEMFEcoreProject(EMFEcoreProject object) {
				return createEMFEcoreProjectAdapter();
			}
			@Override
			public Adapter caseODProject(ODProject object) {
				return createODProjectAdapter();
			}
			@Override
			public Adapter caseSiriusAnimatorProject(SiriusAnimatorProject object) {
				return createSiriusAnimatorProjectAdapter();
			}
			@Override
			public Adapter caseModHelXMoCProject(ModHelXMoCProject object) {
				return createModHelXMoCProjectAdapter();
			}
			@Override
			public Adapter caseDSEProject(DSEProject object) {
				return createDSEProjectAdapter();
			}
			@Override
			public Adapter caseECLProject(ECLProject object) {
				return createECLProjectAdapter();
			}
			@Override
			public Adapter caseTreeEditorProject(TreeEditorProject object) {
				return createTreeEditorProjectAdapter();
			}
			@Override
			public Adapter caseEMFGenmodel(EMFGenmodel object) {
				return createEMFGenmodelAdapter();
			}
			@Override
			public Adapter caseFileResource(FileResource object) {
				return createFileResourceAdapter();
			}
			@Override
			public Adapter caseXTextEditorProject(XTextEditorProject object) {
				return createXTextEditorProjectAdapter();
			}
			@Override
			public Adapter caseK3DSAProject(K3DSAProject object) {
				return createK3DSAProjectAdapter();
			}
			@Override
			public Adapter caseECLFile(ECLFile object) {
				return createECLFileAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration <em>Gemoc Language Workbench Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration
	 * @generated
	 */
	public Adapter createGemocLanguageWorkbenchConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.ProjectResource <em>Project Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectResource
	 * @generated
	 */
	public Adapter createProjectResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject <em>DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSAProject
	 * @generated
	 */
	public Adapter createDSAProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.Kermeta2DSAProject <em>Kermeta2 DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.Kermeta2DSAProject
	 * @generated
	 */
	public Adapter createKermeta2DSAProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition <em>Language Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition
	 * @generated
	 */
	public Adapter createLanguageDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.EditorProject <em>Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.EditorProject
	 * @generated
	 */
	public Adapter createEditorProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.DomainModelProject <em>Domain Model Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.DomainModelProject
	 * @generated
	 */
	public Adapter createDomainModelProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.MoCProject <em>Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.MoCProject
	 * @generated
	 */
	public Adapter createMoCProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.CCSLMoCProject <em>CCSL Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.CCSLMoCProject
	 * @generated
	 */
	public Adapter createCCSLMoCProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.AnimatorProject <em>Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.AnimatorProject
	 * @generated
	 */
	public Adapter createAnimatorProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject <em>EMF Ecore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject
	 * @generated
	 */
	public Adapter createEMFEcoreProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.ODProject <em>OD Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.ODProject
	 * @generated
	 */
	public Adapter createODProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject <em>Sirius Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject
	 * @generated
	 */
	public Adapter createSiriusAnimatorProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.ModHelXMoCProject <em>Mod Hel XMo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.ModHelXMoCProject
	 * @generated
	 */
	public Adapter createModHelXMoCProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.DSEProject <em>DSE Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSEProject
	 * @generated
	 */
	public Adapter createDSEProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.ECLProject <em>ECL Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.ECLProject
	 * @generated
	 */
	public Adapter createECLProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.TreeEditorProject <em>Tree Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.TreeEditorProject
	 * @generated
	 */
	public Adapter createTreeEditorProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.EMFGenmodel <em>EMF Genmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFGenmodel
	 * @generated
	 */
	public Adapter createEMFGenmodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.FileResource
	 * @generated
	 */
	public Adapter createFileResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.XTextEditorProject <em>XText Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.XTextEditorProject
	 * @generated
	 */
	public Adapter createXTextEditorProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.K3DSAProject <em>K3DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.K3DSAProject
	 * @generated
	 */
	public Adapter createK3DSAProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.gemoc_language_workbench.conf.ECLFile <em>ECL File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.gemoc_language_workbench.conf.ECLFile
	 * @generated
	 */
	public Adapter createECLFileAdapter() {
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

} //confAdapterFactory
