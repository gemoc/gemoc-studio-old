/**
 */
package glml.util;

import glml.*;

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
 * @see glml.GlmlPackage
 * @generated
 */
public class GlmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GlmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlmlSwitch() {
		if (modelPackage == null) {
			modelPackage = GlmlPackage.eINSTANCE;
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT_FILE: {
				DomainSpecificEventFile domainSpecificEventFile = (DomainSpecificEventFile)theEObject;
				T result = caseDomainSpecificEventFile(domainSpecificEventFile);
				if (result == null) result = caseNamedElement(domainSpecificEventFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.IMPORT_STATEMENT: {
				ImportStatement importStatement = (ImportStatement)theEObject;
				T result = caseImportStatement(importStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT: {
				DomainSpecificEvent domainSpecificEvent = (DomainSpecificEvent)theEObject;
				T result = caseDomainSpecificEvent(domainSpecificEvent);
				if (result == null) result = caseNamedElement(domainSpecificEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION: {
				DomainSpecificAction domainSpecificAction = (DomainSpecificAction)theEObject;
				T result = caseDomainSpecificAction(domainSpecificAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.MOC_RELATION: {
				MocRelation mocRelation = (MocRelation)theEObject;
				T result = caseMocRelation(mocRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.EXTENDED_CCSL_RELATION: {
				ExtendedCcslRelation extendedCcslRelation = (ExtendedCcslRelation)theEObject;
				T result = caseExtendedCcslRelation(extendedCcslRelation);
				if (result == null) result = caseMocRelation(extendedCcslRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.JAVA_SOLVER_RELATION: {
				JavaSolverRelation javaSolverRelation = (JavaSolverRelation)theEObject;
				T result = caseJavaSolverRelation(javaSolverRelation);
				if (result == null) result = caseMocRelation(javaSolverRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.MODEL_SPECIFIC_EVENT: {
				ModelSpecificEvent modelSpecificEvent = (ModelSpecificEvent)theEObject;
				T result = caseModelSpecificEvent(modelSpecificEvent);
				if (result == null) result = caseNamedElement(modelSpecificEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GlmlPackage.MODEL_SPECIFIC_ACTION: {
				ModelSpecificAction modelSpecificAction = (ModelSpecificAction)theEObject;
				T result = caseModelSpecificAction(modelSpecificAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Specific Event File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Specific Event File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainSpecificEventFile(DomainSpecificEventFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportStatement(ImportStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Specific Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Specific Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainSpecificEvent(DomainSpecificEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Specific Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Specific Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainSpecificAction(DomainSpecificAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moc Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moc Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMocRelation(MocRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extended Ccsl Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extended Ccsl Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtendedCcslRelation(ExtendedCcslRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Solver Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Solver Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaSolverRelation(JavaSolverRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Specific Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Specific Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSpecificEvent(ModelSpecificEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Specific Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Specific Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelSpecificAction(ModelSpecificAction object) {
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

} //GlmlSwitch
