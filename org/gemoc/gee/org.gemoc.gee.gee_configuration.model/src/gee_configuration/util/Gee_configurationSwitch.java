/**
 */
package gee_configuration.util;

import gee_configuration.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see gee_configuration.Gee_configurationPackage
 * @generated
 */
public class Gee_configurationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Gee_configurationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gee_configurationSwitch() {
		if (modelPackage == null) {
			modelPackage = Gee_configurationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Gee_configurationPackage.GEMOC_CONFIGURATION: {
				GemocConfiguration gemocConfiguration = (GemocConfiguration)theEObject;
				T result = caseGemocConfiguration(gemocConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.DSA_MODEL: {
				DSAModel dsaModel = (DSAModel)theEObject;
				T result = caseDSAModel(dsaModel);
				if (result == null) result = caseLocalResource(dsaModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.MOCC_MODEL: {
				MoccModel moccModel = (MoccModel)theEObject;
				T result = caseMoccModel(moccModel);
				if (result == null) result = caseLocalResource(moccModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.DSE_MODEL: {
				DSEModel dseModel = (DSEModel)theEObject;
				T result = caseDSEModel(dseModel);
				if (result == null) result = caseLocalResource(dseModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL: {
				DomainSpecificMetamodel domainSpecificMetamodel = (DomainSpecificMetamodel)theEObject;
				T result = caseDomainSpecificMetamodel(domainSpecificMetamodel);
				if (result == null) result = caseLocalResource(domainSpecificMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.LOCAL_RESOURCE: {
				LocalResource localResource = (LocalResource)theEObject;
				T result = caseLocalResource(localResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Gee_configurationPackage.DOMAIN_SPECIFIC_EDITOR: {
				DomainSpecificEditor domainSpecificEditor = (DomainSpecificEditor)theEObject;
				T result = caseDomainSpecificEditor(domainSpecificEditor);
				if (result == null) result = caseLocalResource(domainSpecificEditor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gemoc Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gemoc Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGemocConfiguration(GemocConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSA Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSA Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSAModel(DSAModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mocc Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mocc Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoccModel(MoccModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSE Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSE Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSEModel(DSEModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Specific Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Specific Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainSpecificMetamodel(DomainSpecificMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalResource(LocalResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Specific Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Specific Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainSpecificEditor(DomainSpecificEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Gee_configurationSwitch
