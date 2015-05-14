package org.gemoc.execution.engine.commons.trace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.EMFCompare.Builder;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

/**
 * 
 * Class responsible for feeding the trace model and to perform the move
 * backward/forward.
 * 
 * @author ftanguy
 *
 */
public class ModelExecutionTracingAddon extends DefaultEngineAddon
{
	
	private boolean shouldSave = true;
	public void disableTraceSaving() {
		shouldSave = false;
	}

	private TransactionalEditingDomain getEditingDomain()
	{
		return TransactionUtil.getEditingDomain(_executionContext.getResourceModel());
	}

	private boolean _backToPastHappened = false;

	public void branch(Choice choice) throws ModelExecutionTracingException
	{
		internalBranch(choice);
		_backToPastHappened = true;
		if (_executionContext.getLogicalStepDecider() != null)
		{
			_executionContext.getLogicalStepDecider().preempt();
		}
	}

	private Choice _lastChoice;

	private void internalBranch(final Choice choice)
	{
		final int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index != -1 && index != _executionTraceModel.getChoices().size())
		{
			RecordingCommand command = new RecordingCommand(getEditingDomain(), "Back to " + index) {
				@Override
				protected void doExecute()
				{
					Branch previousBranch = choice.getPreviousChoice().getBranch();
					Branch newBranch = Gemoc_execution_traceFactory.eINSTANCE.createBranch();
					int previousChoiceIndex = previousBranch.getChoices().indexOf(choice.getPreviousChoice());
					int index = previousBranch.getStartIndex() + previousChoiceIndex + 1;
					newBranch.setStartIndex(index);
					_currentBranch = newBranch;
					_executionTraceModel.getBranches().add(newBranch);
					if (_executionTraceModel.getChoices().size() > 0)
					{
						_lastChoice = choice.getPreviousChoice();
						if (_lastChoice != null)
						{
							_lastChoice.setSelectedNextChoice(null);
						}
					}
					try
					{
						restoreModelState(choice);
						restoreSolverState(choice);
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			};
			CommandExecution.execute(getEditingDomain(), command);
		}
	}

	private void restoreModelState(Choice choice)
	{

		EObject left = choice.getContextState().getModelState().getModel();
		EObject right = _executionContext.getResourceModel().getContents().get(0);

		IComparisonScope scope = new DefaultComparisonScope(left, right, null);
		EMFCompare build = EMFCompare.builder().build();
		Comparison comparison = build.compare(scope);
		List<Diff> differences = comparison.getDifferences();

		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : differences)
		{

			if (diff instanceof AttributeChangeSpec)
			{
				// if attribute, modify value on the aspect side that will
				// modify the model in return.
				AttributeChangeSpec asc = (AttributeChangeSpec) diff;
				ICodeExecutor codeExecutor = _executionContext.getExecutionPlatform().getCodeExecutor();
				EObject target = diff.getMatch().getRight();
				String methodName = asc.getAttribute().getName();
				ArrayList<Object> parameters = new ArrayList<Object>();
				parameters.add(asc.getValue());
				try
				{
					System.out
							.println("Begin setting " + target.toString() + "." + methodName + " = " + asc.getValue());
					codeExecutor.execute(target, methodName, parameters);
					System.out.println("End setting " + target.toString() + "." + methodName + " = " + asc.getValue());
				} catch (CodeExecutionException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else
			{
				// if reference, use the merger.
				merger.copyLeftToRight(diff, monitor);
				diff.setState(DifferenceState.UNRESOLVED);
			}
		}
	}

	byte[] _lastRestoredSolverState;

	private void restoreSolverState(Choice choice)
	{
		ISolver solver = _executionContext.getExecutionPlatform().getSolver();
		Activator.getDefault().debug(
				"restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
		solver.setState(choice.getContextState().getSolverState().getSerializableModel());
	}

	public boolean hasRewindHappened(boolean resetFlag)
	{
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}

	private boolean _cannotSaveTrace = false;

	private void saveTraceModel(long stepNumber)
	{
		Resource traceResource = _executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0)
		{
			// copy the model
			Copier copier = new GCopier();
			EObject result = copier.copy(_executionContext.getResourceModel().getContents().get(0));
			copier.copyReferences();

			ExecutionTraceModel traceModel = (ExecutionTraceModel) traceResource.getContents().get(0);
			if (traceModel.getChoices().size() > 0)
			{
				// link it to the trace model
				ModelState modelState = Gemoc_execution_traceFactory.eINSTANCE.createModelState();
				traceResource.getContents().add(result);
				modelState.setModel(result);

				SolverState solverState = Gemoc_execution_traceFactory.eINSTANCE.createSolverState();
				solverState.setSerializableModel(_executionContext.getExecutionPlatform().getSolver().getState());
				Activator.getDefault().debug(
						"step" + stepNumber + ", saving solver state: " + solverState.getSerializableModel());

				ContextState contextState = Gemoc_execution_traceFactory.eINSTANCE.createContextState();
				contextState.setModelState(modelState);
				contextState.setSolverState(solverState);
				traceModel.getChoices().get(traceModel.getChoices().size() - 1).setContextState(contextState);

				if (!_cannotSaveTrace && shouldSave)
				{
					try
					{
						traceResource.save(null);
					} catch (IOException e)
					{
						e.printStackTrace();
						_cannotSaveTrace = true;
					}
				}
			}
		}
	}

	private ExecutionTraceModel _executionTraceModel;
	private Branch _currentBranch;

	public Branch getCurrentBranch()
	{
		return _currentBranch;
	}

	private void setUp(IExecutionEngine engine)
	{
		if (_executionContext == null)
		{
			_executionTraceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();
			_currentBranch = Gemoc_execution_traceFactory.eINSTANCE.createBranch();
			_currentBranch.setStartIndex(0);
			_executionTraceModel.getBranches().add(_currentBranch);
			setModelExecutionContext(engine.getExecutionContext());
		}
	}

	private IExecutionContext _executionContext;

	private void setModelExecutionContext(IExecutionContext executionContext)
	{
		_executionContext = executionContext;
		ResourceSet rs = _executionContext.getResourceModel().getResourceSet();
		URI traceModelURI = URI.createPlatformResourceURI(_executionContext.getWorkspace().getExecutionPath()
				.toString()
				+ "/execution.trace", false);
		final Resource modelResource = rs.createResource(traceModelURI);

		RecordingCommand command = new RecordingCommand(getEditingDomain(), "set model execution context") {
			@Override
			protected void doExecute()
			{
				modelResource.getContents().add(_executionTraceModel);
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	private Choice createChoice()
	{
		Choice choice = Gemoc_execution_traceFactory.eINSTANCE.createChoice();
		return choice;
	}

	private void updateTraceModelBeforeDeciding(final Collection<LogicalStep> possibleLogicalSteps)
	{

		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute()
			{
				Choice choice = createChoice();
				_executionTraceModel.getChoices().add(choice);
				_currentBranch.getChoices().add(choice);
				if (_lastChoice != null)
				{
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

	private void updateTraceModelAfterExecution(final LogicalStep selectedLogicalStep)
	{
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model after deciding") {
			@Override
			protected void doExecute()
			{
				if (_lastChoice != null)
				{
					if (_lastChoice.getPossibleLogicalSteps().size() == 0)
						return;
					if (_lastChoice.getPossibleLogicalSteps().contains(selectedLogicalStep))
					{
						_lastChoice.setChosenLogicalStep(selectedLogicalStep);
					}
				}
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	public ExecutionTraceModel getExecutionTrace()
	{
		return _executionTraceModel;
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps)
	{
		setUp(engine);
		updateTraceModelBeforeDeciding(logicalSteps);
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted)
	{
		setUp(engine);
		updateTraceModelAfterExecution(logicalStepExecuted);
	}

	public void reintegrateBranch(final Choice choice)
	{
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "Reintegrate branch") {
			@Override
			protected void doExecute()
			{
				_currentBranch = choice.getBranch();
				_lastChoice = choice.getPreviousChoice();
				choice.setPreviousChoice(null);
				_lastChoice.setSelectedNextChoice(null);
				_currentBranch.getChoices().remove(choice);
				try
				{
					restoreModelState(choice);
					restoreSolverState(choice);
					if (_executionContext.getLogicalStepDecider() != null)
					{
						_executionContext.getLogicalStepDecider().preempt();
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine, final Collection<LogicalStep> logicalSteps)
	{
		RecordingCommand command = new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute()
			{
				if (_lastChoice != null)
				{
					_lastChoice.getPossibleLogicalSteps().clear();
					_lastChoice.getPossibleLogicalSteps().addAll(logicalSteps);
				}
				saveTraceModel(0);
			}
		};
		CommandExecution.execute(getEditingDomain(), command);
	}

}
