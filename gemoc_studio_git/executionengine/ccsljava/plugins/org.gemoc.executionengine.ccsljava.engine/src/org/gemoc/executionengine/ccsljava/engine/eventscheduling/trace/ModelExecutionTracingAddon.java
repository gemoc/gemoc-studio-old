package org.gemoc.executionengine.ccsljava.engine.eventscheduling.trace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.CommandExecution;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Branch;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.executionengine.ccsljava.api.core.IConcurrentExecutionContext;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.CodeExecutionException;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.ICodeExecutor;
import org.gemoc.executionengine.ccsljava.api.moc.ISolver;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;

/**
 * 
 * Class responsible for feeding the trace model and to perform the move
 * backward/forward.
 * 
 * @author ftanguy
 *
 */
@SuppressWarnings("restriction")
public class ModelExecutionTracingAddon extends DefaultEngineAddon {

	private IConcurrentExecutionContext _executionContext;
	private IExecutionEngine _executionEngine;
	private ExecutionTraceModel _executionTraceModel;
	private Choice _lastChoice;
	private Branch _currentBranch;
	private ModelState currentState = null;
	byte[] _lastRestoredSolverState;
	private EContentAdapter adapter;
	private boolean shouldSave = true;
	private boolean stateChanged = false;
	private boolean _backToPastHappened = false;
	private boolean _cannotSaveTrace = false;

	private void modifyTrace(final Runnable r) {
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute() {
				r.run();
			}
		};

		CommandExecution.execute(getEditingDomain(), command);
	}

	public void disableTraceSaving() {
		shouldSave = false;
	}

	private TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(_executionContext.getResourceModel());
	}

	public void branch(Choice choice) throws ModelExecutionTracingException {
		internalBranch(choice);
		_backToPastHappened = true;
		if (_executionEngine instanceof INonDeterministicExecutionEngine) {
			((INonDeterministicExecutionEngine) _executionEngine).getLogicalStepDecider().preempt();
		}
	}

	private void internalBranch(final Choice choice) {
		final int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index != -1 && index != _executionTraceModel.getChoices().size()) {
			RecordingCommand command = new RecordingCommand(getEditingDomain(), "Back to " + index) {
				@Override
				protected void doExecute() {
					Branch previousBranch = choice.getPreviousChoice().getBranch();
					Branch newBranch = Gemoc_execution_traceFactory.eINSTANCE.createBranch();
					int previousChoiceIndex = previousBranch.getChoices().indexOf(choice.getPreviousChoice());
					int index = previousBranch.getStartIndex() + previousChoiceIndex + 1;
					newBranch.setStartIndex(index);
					_currentBranch = newBranch;
					_executionTraceModel.getBranches().add(newBranch);
					if (_executionTraceModel.getChoices().size() > 0) {
						_lastChoice = choice.getPreviousChoice();
						if (_lastChoice != null) {
							_lastChoice.setSelectedNextChoice(null);
						}
					}
					try {
						restoreModelState(choice);
						restoreSolverState(choice);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			CommandExecution.execute(getEditingDomain(), command);
		}
	}

	private void restoreModelState(Choice choice) {
		ModelState state = choice.getContextState().getModelState();
		restoreModelState(state, true);
	}

	public void jump(final ModelState state) {
		modifyTrace(new Runnable() {
			@Override
			public void run() {
				restoreModelState(state, false);
			}
		});
	}

	private void restoreModelState(ModelState state, boolean restoreAspects) {

		EObject left = state.getModel();
		EObject right = _executionContext.getResourceModel().getContents().get(0);

		IComparisonScope scope = new DefaultComparisonScope(left, right, null);
		EMFCompare build = EMFCompare.builder().build();
		Comparison comparison = build.compare(scope);
		List<Diff> differences = comparison.getDifferences();

		Merger merger = new Merger();

		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : differences) {

			if (diff instanceof AttributeChangeSpec) {
				// if attribute, modify value on the aspect side that will
				// modify the model in return.
				AttributeChangeSpec asc = (AttributeChangeSpec) diff;
				ICodeExecutor codeExecutor = _executionContext.getConcurrentExecutionPlatform().getCodeExecutor();
				EObject target = diff.getMatch().getRight();
				String methodName = asc.getAttribute().getName();
				ArrayList<Object> parameters = new ArrayList<Object>();
				parameters.add(asc.getValue());
				if (restoreAspects) {
					try {
						System.out.println("Begin setting " + target.toString() + "." + methodName + " = "
								+ asc.getValue());
						codeExecutor.execute(target, methodName, parameters);
						System.out.println("End setting " + target.toString() + "." + methodName + " = "
								+ asc.getValue());
					} catch (CodeExecutionException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						System.out.println("Coudln't set value with aspects, using normal setter.");
						try {
							target.eSet(asc.getAttribute(), asc.getValue());
						} catch (IllegalArgumentException e2) {
							System.out.println("Didn't work either...");
						}
					}
				} else {
					try {
						target.eSet(asc.getAttribute(), asc.getValue());
					} catch (IllegalArgumentException e2) {
						System.out.println("WARNING - Couldn't set value.");
					}
				}
			} else {
				// if reference, use the merger.
				merger.copyLeftToRight(diff, monitor);
				diff.setState(DifferenceState.UNRESOLVED);
			}
		}
	}

	private void restoreSolverState(Choice choice) {

		if (_executionEngine instanceof INonDeterministicExecutionEngine) {
			INonDeterministicExecutionEngine engine_cast = (INonDeterministicExecutionEngine) _executionEngine;
			ISolver solver = engine_cast.getSolver();
			Activator.getDefault().debug(
					"restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
			solver.setState(choice.getContextState().getSolverState().getSerializableModel());
		}
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}

	private void addModelStateIfChanged() {
		Resource traceResource = _executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0) {

			ExecutionTraceModel traceModel = (ExecutionTraceModel) traceResource.getContents().get(0);

			if (stateChanged || currentState == null) {

				Activator.getDefault().debug("saving model state " + traceModel.getReachedStates().size());

				ModelState modelState = null;
				// copy the model
				Copier copier = new GCopier();
				EObject result = copier.copy(_executionContext.getResourceModel().getContents().get(0));
				copier.copyReferences();

				// No one needs to observe the clone
				result.eAdapters().clear();
				modelState = Gemoc_execution_traceFactory.eINSTANCE.createModelState();
				traceModel.getReachedStates().add(modelState);
				modelState.setModel(result);
				currentState = modelState;
				traceResource.getContents().add(result);
				stateChanged = false;

			}
		}
	}

	private void saveTraceModel(long stepNumber) {

		Resource traceResource = _executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0) {

			ExecutionTraceModel traceModel = (ExecutionTraceModel) traceResource.getContents().get(0);
			if (traceModel.getChoices().size() > 0) {

				addModelStateIfChanged();

				ContextState contextState = Gemoc_execution_traceFactory.eINSTANCE.createContextState();
				ModelState modelState = currentState;
				contextState.setModelState(modelState);

				if (_executionEngine instanceof INonDeterministicExecutionEngine) {
					INonDeterministicExecutionEngine engine_cast = (INonDeterministicExecutionEngine) _executionEngine;
					SolverState solverState = Gemoc_execution_traceFactory.eINSTANCE.createSolverState();
					solverState.setSerializableModel(engine_cast.getSolver().getState());
					contextState.setSolverState(solverState);
				}

				traceModel.getChoices().get(traceModel.getChoices().size() - 1).setContextState(contextState);

				if (!_cannotSaveTrace && shouldSave) {
					try {
						traceResource.save(null);
					} catch (IOException e) {
						e.printStackTrace();
						_cannotSaveTrace = true;
					}
				}
			}

		}
	}

	public Branch getCurrentBranch() {
		return _currentBranch;
	}

	private void setUp(IExecutionEngine engine) {
		if (_executionContext == null) {
			
			if(!(engine.getExecutionContext() instanceof IConcurrentExecutionContext)){
				// DVK current implementation of this addon is Concurrent specific (due to the use of the CodeExecutor
				// for now fail with an error message, later work may generalize this and remove the dependency (by removing some features ?)
				System.err.println("incorrect use of ModelExecutionTracingAddon with non concurrent engine");
				return;
			}
			_executionEngine = engine;
			_executionTraceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();
			_currentBranch = Gemoc_execution_traceFactory.eINSTANCE.createBranch();
			_currentBranch.setStartIndex(0);
			_executionTraceModel.getBranches().add(_currentBranch);
			setModelExecutionContext((IConcurrentExecutionContext) engine.getExecutionContext());

			adapter = new EContentAdapter() {

				@Override
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					stateChanged = true;

				}

			};

			_executionContext.getResourceModel().eAdapters().add(adapter);

		}
	}

	// private static class GemocTraceResource extends ResourceImpl

	private void setModelExecutionContext(IConcurrentExecutionContext executionContext) {
		_executionContext = executionContext;
		ResourceSet rs = _executionContext.getResourceModel().getResourceSet();
		URI traceModelURI = URI.createPlatformResourceURI(_executionContext.getWorkspace().getExecutionPath()
				.toString()
				+ "/execution.trace", false);
		final Resource modelResource = rs.createResource(traceModelURI);

		RecordingCommand command = new RecordingCommand(getEditingDomain(), "set model execution context") {
			@Override
			protected void doExecute() {
				modelResource.getContents().add(_executionTraceModel);
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	private Choice createChoice() {
		Choice choice = Gemoc_execution_traceFactory.eINSTANCE.createChoice();
		return choice;
	}

	private void updateTraceModelBeforeDeciding(final Collection<LogicalStep> possibleLogicalSteps) {

		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute() {
				Choice choice = createChoice();
				_executionTraceModel.getChoices().add(choice);
				_currentBranch.getChoices().add(choice);
				if (_lastChoice != null) {
					_lastChoice.getNextChoices().add(choice);
					_lastChoice.setSelectedNextChoice(choice);
				}
				choice.getPossibleLogicalSteps().addAll(possibleLogicalSteps);
				_lastChoice = choice;
				saveTraceModel(0);
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	private void updateTraceModelAfterExecution(final LogicalStep selectedLogicalStep) {
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model after deciding") {
			@Override
			protected void doExecute() {
				if (_lastChoice != null) {
					if (_lastChoice.getPossibleLogicalSteps().size() == 0)
						return;
					if (_lastChoice.getPossibleLogicalSteps().contains(selectedLogicalStep)) {
						_lastChoice.setChosenLogicalStep(selectedLogicalStep);
					}
				}
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	public ExecutionTraceModel getExecutionTrace() {
		return _executionTraceModel;
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) {
		setUp(engine);
		updateTraceModelBeforeDeciding(logicalSteps);
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted) {
		setUp(engine);
		updateTraceModelAfterExecution(logicalStepExecuted);
	}

	public void reintegrateBranch(final Choice choice) {
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "Reintegrate branch") {
			@Override
			protected void doExecute() {
				_currentBranch = choice.getBranch();
				_lastChoice = choice.getPreviousChoice();
				choice.setPreviousChoice(null);
				_lastChoice.setSelectedNextChoice(null);
				_currentBranch.getChoices().remove(choice);
				try {
					restoreModelState(choice);
					restoreSolverState(choice);
					if (_executionEngine instanceof INonDeterministicExecutionEngine) {
						((INonDeterministicExecutionEngine) _executionEngine).getLogicalStepDecider().preempt();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine, final Collection<LogicalStep> logicalSteps) {
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute() {
				if (_lastChoice != null) {
					_lastChoice.getPossibleLogicalSteps().clear();
					_lastChoice.getPossibleLogicalSteps().addAll(logicalSteps);
				}
				saveTraceModel(0);
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) {

		if (stateChanged || currentState == null) {

			modifyTrace(new Runnable() {

				@Override
				public void run() {

					// We store the states when MSE ends, to be able to
					// distinguish precisely changes made by a single MSE
					// Not used by any tool for not
					// Can be used with "jump" programmatically
					addModelStateIfChanged();
				}
			});
		}

	}

	@Override
	public void engineStopped(IExecutionEngine engine) {
		modifyTrace(new Runnable() {

			@Override
			public void run() {

				// Same as in "mseOccurrenceExecuted", and probably redundant
				// addModelStateIfChanged();

				// No need to observe changes in the model anymore
				_executionContext.getResourceModel().eAdapters().remove(adapter);
			}
		});
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
		setUp(engine);
	}
}
