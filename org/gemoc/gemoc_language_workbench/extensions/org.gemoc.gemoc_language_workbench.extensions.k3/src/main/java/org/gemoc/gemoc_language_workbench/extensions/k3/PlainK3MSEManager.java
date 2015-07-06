package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

/**
 * This class contains the complete MSE management for PlainK3ExecutionEngine.
 * All this code could be withing PlainK3ExecutionEngine.
 * 
 * @author ebousse
 *
 */
public final class PlainK3MSEManager {

	public PlainK3MSEManager(K3Solver solver) {
		this._solver = solver;
		this._actionModel = solver.getActionModel();
	}

	private K3Solver _solver;

	private ActionModel _actionModel;

	private MSEOccurrence createMSEOccurrenceAndTellSolver(EObject caller, EOperation operation) {

		LogicalStep logicalStep = Gemoc_execution_traceFactory.eINSTANCE.createLogicalStep();
		MSEOccurrence occurrence = Gemoc_execution_traceFactory.eINSTANCE.createMSEOccurrence();
		occurrence.setLogicalstep(logicalStep);
		ModelSpecificEvent mse = findOrCreateMSE(caller, operation);
		occurrence.setMse(mse);

		_solver.setNextMSEOccurrence(occurrence);

		return occurrence;

	}

	private Deque<MSEOccurrence> _mseOccurences = new ArrayDeque<MSEOccurrence>();

	public MSEOccurrence raiseMSEOccurrence(EObject caller, String methodName) {
		EOperation operation = findOperation(caller, methodName);
		// If the operation is null, is means it's not an operation added as
		// aspect
		MSEOccurrence occurrence = null;

		// We don't want to stop on getters/setters of structural features
		boolean isNotStruturalFeature = true;
		for (EStructuralFeature p : caller.eClass().getEAllStructuralFeatures()) {
			if (p.getName().equals(methodName)) {
				isNotStruturalFeature = false;
				break;
			}
		}

		if (operation != null || isNotStruturalFeature) {
			occurrence = createMSEOccurrenceAndTellSolver(caller, operation);
		}
		_mseOccurences.push(occurrence);
		return occurrence;

	}

	/**
	 * Handles the end of an step by potentially creating a fake MSE to pause the
	 * engine. If such mse is created, then a corresponding "performExecutionStep" must be done.
	 * 
	 * @return true if we are still within a step and if there is a new (fake) mse given to the solver, 
	 * 		   false otherwise.
	 */
	public boolean endMSEOccurrence() {
		MSEOccurrence occurrence = _mseOccurences.pop();

		if (occurrence != null) {
			// If we are still "inside an mse", then we have a "fill mse" to
			// raise. This MSE has no operation, so that it isn't handled in the
			// trace manager.

			boolean containsNotNull = false;
			for (MSEOccurrence mseocc : _mseOccurences) {
				if (mseocc != null) {
					containsNotNull = true;
					break;
				}
			}

			if (!_mseOccurences.isEmpty() && containsNotNull) {
				ModelSpecificEvent mse = occurrence.getMse();
				createMSEOccurrenceAndTellSolver(mse.getCaller(), null);
				return true;
			}
		}
		return false;
	}

	private EOperation findOperation(EObject object, String methodName) {
		for (EOperation operation : object.eClass().getEAllOperations()) {
			// !!! this is not super correct yet as polyphormism allows the
			// definition of 2 methods with the same name !!!
			if (operation.getName().equals(methodName)) {
				return operation;
			}
		}
		return null;
	}

	private ModelSpecificEvent findOrCreateMSE(EObject caller, EOperation operation) {

		if (_actionModel != null) {
			for (ModelSpecificEvent existingMSE : _actionModel.getEvents()) {
				if (existingMSE.getCaller().equals(caller)
						&& ((existingMSE.getAction() != null && existingMSE.getAction().equals(operation)) || (existingMSE
								.getAction() == null && operation == null))) {
					// no need to create one, we already have it
					return existingMSE;
				}
			}
		}
		// let's create a MSE
		final ModelSpecificEvent mse = FeedbackFactory.eINSTANCE.createModelSpecificEvent();
		mse.setCaller(caller);
		mse.setAction(operation);
		if (operation != null)
			mse.setName("MSE_" + caller.getClass().getSimpleName() + "_" + operation.getName());
		else
			mse.setName("MSE_" + caller.getClass().getSimpleName() + "_nextStep");
		// and add it for possible reuse
		if (_actionModel != null) {

			if (_actionModel.eResource() != null) {
				TransactionUtil.getEditingDomain(_actionModel.eResource());
				RecordingCommand command = new RecordingCommand(TransactionUtil.getEditingDomain(_actionModel
						.eResource()), "Saving new MSE ") {
					@Override
					protected void doExecute() {
						_actionModel.getEvents().add(mse);

						try {
							_actionModel.eResource().save(null);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
				TransactionUtil.getEditingDomain(_actionModel.eResource()).getCommandStack().execute(command);

			}
		}
		return mse;
	}

	public ActionModel getActiveActionModel() {
		return _actionModel;
	}

}
