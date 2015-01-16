package org.gemoc.execution.engine.commons.trace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;

public class ModelExecutionTracingAddon extends DefaultEngineAddon {
	
	private TransactionalEditingDomain getEditingDomain()
	{
		return  TransactionUtil.getEditingDomain(_executionContext.getResourceModel());
	}

	private boolean _backToPastHappened = false;
	public void backToPast(Choice choice) throws ModelExecutionTracingException {
		int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index == (_executionTraceModel.getChoices().size()-1))
			return;
		backInTraceModelTo(choice);
		_backToPastHappened = true;
		if (_executionContext.getLogicalStepDecider() != null) 
		{
			_executionContext.getLogicalStepDecider().preempt();
		}
	}

	private void backInTraceModelTo(final Choice choice) {
		final int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index != -1
			&& index != _executionTraceModel.getChoices().size()) {
			final CommandStack commandStack = getEditingDomain().getCommandStack();
			commandStack.execute(new RecordingCommand(getEditingDomain(), "Back to " + index) {
				@Override
				protected void doExecute() {
//					int fixedIndex = index == 0 ? index : index -1;
					List<Choice> choicesToRemove = _executionTraceModel.getChoices().subList(index, _executionTraceModel.getChoices().size());
					_executionTraceModel.getChoices().removeAll(choicesToRemove);
					if (_executionTraceModel.getChoices().size() > 0)
						_executionTraceModel.getChoices().get(_executionTraceModel.getChoices().size()-1).setNextChoice(null);
					try {
						restoreModelState(choice);
						restoreSolverState(choice);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	private void restoreModelState(Choice choice) {
		// Configure EMF Compare
		IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
	    IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin.getDefault().getPostProcessorRegistry();
		EMFCompare comparator = EMFCompare.builder()
	                                           .setMatchEngineFactoryRegistry(matchEngineRegistry)
	                                           .setPostProcessorRegistry(postProcessorRegistry)
	                                           .build();
		// Compare the two models
		IComparisonScope scope1 = EMFCompare.createDefaultScope(choice.getContextState().getModelState().getModel(), _executionContext.getResourceModel().getContents().get(0));
		Comparison otherComparison = comparator.compare(scope1);
		otherComparison.getDifferences();
		
		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : otherComparison.getDifferences()) {
			
			if (diff instanceof AttributeChangeSpec) 
			{
				// if attribute, modify value on the aspect side that will modify the model in return.
				AttributeChangeSpec asc = (AttributeChangeSpec)diff;
				ICodeExecutor codeExecutor = _executionContext.getExecutionPlatform().getCodeExecutor();
				EObject target = diff.getMatch().getRight();
				String methodName = asc.getAttribute().getName();
				ArrayList<Object> parameters = new ArrayList<Object>();
				parameters.add(asc.getValue());
				try {
					System.out.println("Begin setting " + target.toString() + "." + methodName + " = " + asc.getValue());
					codeExecutor.execute(target, methodName, parameters);
					System.out.println("End setting " + target.toString() + "." + methodName + " = " + asc.getValue());
				} catch (CodeExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			} else {
				// if reference, use the merger.
				merger.copyLeftToRight(
						diff,
						monitor);			
				diff.setState(DifferenceState.UNRESOLVED);				
			}
		}			
	}
	
	byte[] _lastRestoredSolverState;
	private void restoreSolverState(Choice choice) 
	{
		ISolver solver = _executionContext.getExecutionPlatform().getSolver();
		Activator.getDefault().debug("restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
		solver.setState(choice.getContextState().getSolverState().getSerializableModel());
		boolean b = Arrays.equals(solver.getState(), choice.getContextState().getSolverState().getSerializableModel());
		if (b)
			Activator.getDefault().debug("new state does equal the restored state");
		else
			Activator.getDefault().debug("new state does NOT equal the restored state");
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}

	private boolean _cannotSaveTrace = false;
	
	private void saveTraceModel(long stepNumber) {
		Resource traceResource = _executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0) 
		{			
		    Copier copier = new GCopier();		    
		    EObject result = copier.copy(_executionContext.getResourceModel().getContents().get(0));
		    copier.copyReferences();
			
			ExecutionTraceModel traceModel = (ExecutionTraceModel)traceResource.getContents().get(0);				
			if (traceModel.getChoices().size() > 0) 
			{
				// link it to the trace model
				ModelState modelState = Gemoc_execution_traceFactory.eINSTANCE.createModelState();					
				traceResource.getContents().add(result);
				modelState.setModel(result);
				
				SolverState solverState = Gemoc_execution_traceFactory.eINSTANCE.createSolverState();									
				solverState.setSerializableModel(_executionContext.getExecutionPlatform().getSolver().getState());
				Activator.getDefault().debug("step" + stepNumber + ", saving solver state: " 
						 + solverState.getSerializableModel());
				
				ContextState contextState = Gemoc_execution_traceFactory.eINSTANCE.createContextState();
				contextState.setModelState(modelState);
				contextState.setSolverState(solverState);
				traceModel.getChoices().get(traceModel.getChoices().size()-1).setContextState(contextState);

				if (!_cannotSaveTrace)
				{
					try 
					{
						traceResource.save(null);
					} catch (IOException e) {
						e.printStackTrace();
						_cannotSaveTrace = true;
					}					
				}
			}			
		}
	}

	private ExecutionTraceModel _executionTraceModel = Gemoc_execution_traceFactory.eINSTANCE.createExecutionTraceModel();

	
	private void setUp(IExecutionEngine engine)
	{
		if (_executionContext == null)
		{
			setModelExecutionContext(engine.getExecutionContext());
		}
	}
	
	private IExecutionContext _executionContext;
	private void setModelExecutionContext(IExecutionContext executionContext) {
		_executionContext = executionContext;
		ResourceSet rs = _executionContext.getResourceModel().getResourceSet();
		URI traceModelURI = URI.createPlatformResourceURI(_executionContext.getWorkspace().getExecutionPath().toString() + "/execution.trace", false);
		final Resource modelResource = rs.createResource(traceModelURI);
		final CommandStack commandStack = getEditingDomain().getCommandStack();
		commandStack.execute(new RecordingCommand(getEditingDomain(), "set model execution context") {
			@Override
			protected void doExecute() {
				modelResource.getContents().add(_executionTraceModel);
			}
		});
	}

	public Choice getLastChoice() {
		if (_executionTraceModel.getChoices().size() > 0)
			return _executionTraceModel.getChoices().get(_executionTraceModel.getChoices().size()-1);
		else 
			return null;
	}
		
	private Choice createChoice() {
		Choice choice = Gemoc_execution_traceFactory.eINSTANCE.createChoice();
		return choice;
	}

	public void updateTraceModelBeforeDeciding(final List<LogicalStep> possibleLogicalSteps) {
		final CommandStack commandStack = getEditingDomain().getCommandStack();
		commandStack.execute(new RecordingCommand(getEditingDomain(), "update trace model") {

			@Override
			protected void doExecute() {
				Choice lastChoice = getLastChoice();
				Choice choice = createChoice();
				_executionTraceModel.getChoices().add(choice);
				if (lastChoice != null)
				{
					lastChoice.setNextChoice(choice);
				}		
				choice.getPossibleLogicalSteps().addAll(possibleLogicalSteps);
				for (LogicalStep ls : possibleLogicalSteps) {
					LogicalStepHelper.removeNotTickedEvents(ls);
				}
				_executionTraceModel.getChoices().add(choice);
				for (LogicalStep step : choice.getPossibleLogicalSteps()) {
					for (EventOccurrence occurence : step.getEventOccurrences()) {
						_executionTraceModel.eResource().getContents().add(occurence.getReferedElement());
					}
				}
				saveTraceModel(0);
			}
		});
	}
	
	private void updateTraceModelAfterExecution(final LogicalStep selectedLogicalStep) {
		final CommandStack commandStack = getEditingDomain().getCommandStack();
		commandStack.execute(new RecordingCommand(getEditingDomain(), "update trace model after deciding") {

			@Override
			protected void doExecute() {
				Choice choice = getLastChoice();
				if (choice.getPossibleLogicalSteps().size() == 0)
					return;
				if (choice.getPossibleLogicalSteps().contains(selectedLogicalStep))
				{
					choice.setChosenLogicalStep(selectedLogicalStep);					
				}
			}
		});
	}

	public ExecutionTraceModel getExecutionTrace() {
		return _executionTraceModel;
	}
	
	
	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine) 
	{
		setUp(engine);
		updateTraceModelBeforeDeciding(engine.getPossibleLogicalSteps());
	}
	
//	@Override
//	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) 
//	{
//		setUp(engine);
//		updateTraceModelAfterDeciding(selectedLogicalStep);
//	}
	
	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted) {
		setUp(engine);
		updateTraceModelAfterExecution(logicalStepExecuted);
	}
}
