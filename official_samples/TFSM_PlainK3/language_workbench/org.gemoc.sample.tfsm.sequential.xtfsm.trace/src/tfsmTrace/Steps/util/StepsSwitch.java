/**
 */
package tfsmTrace.Steps.util;

import org.eclipse.gemoc.trace.commons.model.trace.BigStep;
import org.eclipse.gemoc.trace.commons.model.trace.SequentialStep;
import org.eclipse.gemoc.trace.commons.model.trace.SmallStep;
import org.eclipse.gemoc.trace.commons.model.trace.Step;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tfsmTrace.Steps.*;

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
 * @see tfsmTrace.Steps.StepsPackage
 * @generated
 */
public class StepsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StepsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepsSwitch() {
		if (modelPackage == null) {
			modelPackage = StepsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
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
			case StepsPackage.ROOT_IMPLICIT_STEP: {
				RootImplicitStep rootImplicitStep = (RootImplicitStep)theEObject;
				T result = caseRootImplicitStep(rootImplicitStep);
				if (result == null) result = caseSmallStep(rootImplicitStep);
				if (result == null) result = caseStep(rootImplicitStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.SPECIFIC_STEP: {
				SpecificStep specificStep = (SpecificStep)theEObject;
				T result = caseSpecificStep(specificStep);
				if (result == null) result = caseStep(specificStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_FSM_CLOCK_TICKS: {
				Tfsm_FSMClock_Ticks tfsm_FSMClock_Ticks = (Tfsm_FSMClock_Ticks)theEObject;
				T result = caseTfsm_FSMClock_Ticks(tfsm_FSMClock_Ticks);
				if (result == null) result = caseSpecificStep(tfsm_FSMClock_Ticks);
				if (result == null) result = caseSmallStep(tfsm_FSMClock_Ticks);
				if (result == null) result = caseStep(tfsm_FSMClock_Ticks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_FSM_EVENT_TRIGGER: {
				Tfsm_FSMEvent_Trigger tfsm_FSMEvent_Trigger = (Tfsm_FSMEvent_Trigger)theEObject;
				T result = caseTfsm_FSMEvent_Trigger(tfsm_FSMEvent_Trigger);
				if (result == null) result = caseSpecificStep(tfsm_FSMEvent_Trigger);
				if (result == null) result = caseSmallStep(tfsm_FSMEvent_Trigger);
				if (result == null) result = caseStep(tfsm_FSMEvent_Trigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_FSM_EVENT_UN_TRIGGER: {
				Tfsm_FSMEvent_UnTrigger tfsm_FSMEvent_UnTrigger = (Tfsm_FSMEvent_UnTrigger)theEObject;
				T result = caseTfsm_FSMEvent_UnTrigger(tfsm_FSMEvent_UnTrigger);
				if (result == null) result = caseSpecificStep(tfsm_FSMEvent_UnTrigger);
				if (result == null) result = caseSmallStep(tfsm_FSMEvent_UnTrigger);
				if (result == null) result = caseStep(tfsm_FSMEvent_UnTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_STATE_VISIT: {
				Tfsm_State_Visit tfsm_State_Visit = (Tfsm_State_Visit)theEObject;
				T result = caseTfsm_State_Visit(tfsm_State_Visit);
				if (result == null) result = caseSpecificStep(tfsm_State_Visit);
				if (result == null) result = caseSequentialStep(tfsm_State_Visit);
				if (result == null) result = caseBigStep(tfsm_State_Visit);
				if (result == null) result = caseStep(tfsm_State_Visit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_STATE_VISIT_ABSTRACT_SUB_STEP: {
				Tfsm_State_Visit_AbstractSubStep tfsm_State_Visit_AbstractSubStep = (Tfsm_State_Visit_AbstractSubStep)theEObject;
				T result = caseTfsm_State_Visit_AbstractSubStep(tfsm_State_Visit_AbstractSubStep);
				if (result == null) result = caseSpecificStep(tfsm_State_Visit_AbstractSubStep);
				if (result == null) result = caseStep(tfsm_State_Visit_AbstractSubStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_STATE_VISIT_IMPLICIT_STEP: {
				Tfsm_State_Visit_ImplicitStep tfsm_State_Visit_ImplicitStep = (Tfsm_State_Visit_ImplicitStep)theEObject;
				T result = caseTfsm_State_Visit_ImplicitStep(tfsm_State_Visit_ImplicitStep);
				if (result == null) result = caseTfsm_State_Visit_AbstractSubStep(tfsm_State_Visit_ImplicitStep);
				if (result == null) result = caseSmallStep(tfsm_State_Visit_ImplicitStep);
				if (result == null) result = caseSpecificStep(tfsm_State_Visit_ImplicitStep);
				if (result == null) result = caseStep(tfsm_State_Visit_ImplicitStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_TFSM_INIT: {
				Tfsm_TFSM_Init tfsm_TFSM_Init = (Tfsm_TFSM_Init)theEObject;
				T result = caseTfsm_TFSM_Init(tfsm_TFSM_Init);
				if (result == null) result = caseSpecificStep(tfsm_TFSM_Init);
				if (result == null) result = caseSmallStep(tfsm_TFSM_Init);
				if (result == null) result = caseStep(tfsm_TFSM_Init);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_TRANSITION_FIRE: {
				Tfsm_Transition_Fire tfsm_Transition_Fire = (Tfsm_Transition_Fire)theEObject;
				T result = caseTfsm_Transition_Fire(tfsm_Transition_Fire);
				if (result == null) result = caseTfsm_Transition_Visit_AbstractSubStep(tfsm_Transition_Fire);
				if (result == null) result = caseSmallStep(tfsm_Transition_Fire);
				if (result == null) result = caseSpecificStep(tfsm_Transition_Fire);
				if (result == null) result = caseStep(tfsm_Transition_Fire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_TRANSITION_VISIT: {
				Tfsm_Transition_Visit tfsm_Transition_Visit = (Tfsm_Transition_Visit)theEObject;
				T result = caseTfsm_Transition_Visit(tfsm_Transition_Visit);
				if (result == null) result = caseSequentialStep(tfsm_Transition_Visit);
				if (result == null) result = caseTfsm_State_Visit_AbstractSubStep(tfsm_Transition_Visit);
				if (result == null) result = caseSpecificStep(tfsm_Transition_Visit);
				if (result == null) result = caseBigStep(tfsm_Transition_Visit);
				if (result == null) result = caseStep(tfsm_Transition_Visit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_TRANSITION_VISIT_ABSTRACT_SUB_STEP: {
				Tfsm_Transition_Visit_AbstractSubStep tfsm_Transition_Visit_AbstractSubStep = (Tfsm_Transition_Visit_AbstractSubStep)theEObject;
				T result = caseTfsm_Transition_Visit_AbstractSubStep(tfsm_Transition_Visit_AbstractSubStep);
				if (result == null) result = caseSpecificStep(tfsm_Transition_Visit_AbstractSubStep);
				if (result == null) result = caseStep(tfsm_Transition_Visit_AbstractSubStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StepsPackage.TFSM_TRANSITION_VISIT_IMPLICIT_STEP: {
				Tfsm_Transition_Visit_ImplicitStep tfsm_Transition_Visit_ImplicitStep = (Tfsm_Transition_Visit_ImplicitStep)theEObject;
				T result = caseTfsm_Transition_Visit_ImplicitStep(tfsm_Transition_Visit_ImplicitStep);
				if (result == null) result = caseTfsm_Transition_Visit_AbstractSubStep(tfsm_Transition_Visit_ImplicitStep);
				if (result == null) result = caseSmallStep(tfsm_Transition_Visit_ImplicitStep);
				if (result == null) result = caseSpecificStep(tfsm_Transition_Visit_ImplicitStep);
				if (result == null) result = caseStep(tfsm_Transition_Visit_ImplicitStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Implicit Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootImplicitStep(RootImplicitStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificStep(SpecificStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm FSM Clock Ticks</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm FSM Clock Ticks</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_FSMClock_Ticks(Tfsm_FSMClock_Ticks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm FSM Event Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm FSM Event Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_FSMEvent_Trigger(Tfsm_FSMEvent_Trigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm FSM Event Un Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm FSM Event Un Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_FSMEvent_UnTrigger(Tfsm_FSMEvent_UnTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm State Visit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm State Visit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_State_Visit(Tfsm_State_Visit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm State Visit Abstract Sub Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm State Visit Abstract Sub Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_State_Visit_AbstractSubStep(Tfsm_State_Visit_AbstractSubStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm State Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm State Visit Implicit Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_State_Visit_ImplicitStep(Tfsm_State_Visit_ImplicitStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm TFSM Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm TFSM Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_TFSM_Init(Tfsm_TFSM_Init object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm Transition Fire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm Transition Fire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_Transition_Fire(Tfsm_Transition_Fire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm Transition Visit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm Transition Visit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_Transition_Visit(Tfsm_Transition_Visit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm Transition Visit Abstract Sub Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm Transition Visit Abstract Sub Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_Transition_Visit_AbstractSubStep(Tfsm_Transition_Visit_AbstractSubStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tfsm Transition Visit Implicit Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tfsm Transition Visit Implicit Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTfsm_Transition_Visit_ImplicitStep(Tfsm_Transition_Visit_ImplicitStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStep(Step object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Small Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Small Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSmallStep(SmallStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Big Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Big Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <StepSubtype extends Step> T caseBigStep(BigStep<StepSubtype> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequential Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequential Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <StepSubtype extends Step> T caseSequentialStep(SequentialStep<StepSubtype> object) {
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

} //StepsSwitch
