package org.gemoc.execution.engine.capabilitites;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public class ModelExecutionTracingCapability implements IExecutionEngineCapability {

	private GemocExecutionEngine _engine;
	
	@Override
	public void initialize(GemocExecutionEngine engine) {
		_engine = engine;
	}

	private boolean _backToPastHappened = false;
	public void backToPast(Choice choice) throws ModelExecutionTracingException {
		int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index == (_engine.getExecutionTrace().getChoices().size()-1))
//			|| index == (_engine.getExecutionTrace().getChoices().size()-2))
			return;
//		try {
			backInTraceModelTo(choice);
			_backToPastHappened = true;
			if (_engine.getLogicalStepDecider() != null) 
			{
				_engine.getLogicalStepDecider().preempt();
			}
//		} 
//		catch (IOException e) {
//			throw new ModelExecutionTracingException(e);
//		}
	}

	private void backInTraceModelTo(final Choice choice) {
		final int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index != -1
			&& index != _engine.getExecutionTrace().getChoices().size()) {
			final CommandStack commandStack = _editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(_editingDomain) {
				@Override
				protected void doExecute() {
//					Comparison firstComparison = (Comparison)choice.getContextState().getModelState().getModel();
//					Comparison secondComparison = (Comparison)_engine.getExecutionTrace().getChoices().get(_engine.getExecutionTrace().getChoices().size()-1).getContextState().getModelState().getModel();
	//				comparison.getDifferences();
					//					for(int i=_engine.getExecutionTrace().getChoices().size()-1; i>-1; i++)
//					{
//						Choice temp = _engine.getExecutionTrace().getChoices().get(i);
//						if (temp.getContextState() != null
//							&& temp.getContextState().getModelState() != null
//							&& temp.getContextState().getModelState().getModel() != null) {
//							lastChoiceWithChanges = choice;
//							break;
//						}
//					}
					_engine.getExecutionTrace().getChoices().subList(index, _engine.getExecutionTrace().getChoices().size()).clear();
					if (_engine.getExecutionTrace().getChoices().size() > 0)
						_engine.getExecutionTrace().getChoices().get(_engine.getExecutionTrace().getChoices().size()-1).setNextChoice(null);
//					choice.setNextChoice(null);
					try {
						restoreModelState(choice);
	//					restoreModelState(firstComparison, secondComparison);
						restoreSolverState(choice);
						//_engine.doLogicalStep(choice.getChosenLogicalStep());
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
		IComparisonScope scope1 = EMFCompare.createDefaultScope(choice.getContextState().getModelState().getModel(), _engine.getModelUnderExecutionResource().getContents().get(0));
		Comparison otherComparison = comparator.compare(scope1);
		otherComparison.getDifferences();
		
		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : otherComparison.getDifferences()) {
			merger.copyLeftToRight(
					diff,
					monitor);			
			diff.setState(DifferenceState.UNRESOLVED);
//			merger.copyRightToLeft(
//					diff,
//					monitor);			
//			diff.setState(DifferenceState.UNRESOLVED);
		}			
	}
	
	private void restoreModelState(Comparison firstComparison, Comparison secondComparison) throws IOException {		
		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		if (firstComparison.getDifferences().size() > 0) {
			for (Diff diff : firstComparison.getDifferences()) {
				merger.copyLeftToRight(
						diff,
						monitor);			
				diff.setState(DifferenceState.UNRESOLVED);
				merger.copyRightToLeft(
						diff,
						monitor);			
				diff.setState(DifferenceState.UNRESOLVED);
			}			
		} else if (secondComparison.getDifferences().size() > 0) {
			for (Diff diff : secondComparison.getDifferences()) {
				merger.copyRightToLeft(
						diff,
						monitor);			
				diff.setState(DifferenceState.UNRESOLVED);
			}			
		}
	}

	byte[] _lastRestoredSolverState;
	private void restoreSolverState(Choice choice) {
		//_engine.getSolver().getPossibleLogicalSteps();
//		if (_lastRestoredSolverState != null) {
//			boolean result = Arrays.equals(_lastRestoredSolverState, choice.getContextState().getSolverState().getSerializableModel());
//			if (result)
//				Activator.debug("restoring solver state equals to last restored solver state");
//			else
//				Activator.debug("restoring solver state NOT equals to last restored solver state");				
//		}
//		_lastRestoredSolverState = choice.getContextState().getSolverState().getSerializableModel();
		
		Activator.debug("restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
		_engine.getSolver().setState(choice.getContextState().getSolverState().getSerializableModel());
		boolean b = Arrays.equals(_engine.getSolver().getState(), choice.getContextState().getSolverState().getSerializableModel());
		if (b)
			Activator.debug("new state does equal the restored state");
		else
			Activator.debug("new state does NOT equal the restored state");
		
		//		_engine.getSolver().getPossibleLogicalSteps();
//		int selectedChoiceIndex = choice.getPossibleLogicalSteps().indexOf(choice.getChosenLogicalStep());
//		_engine.getSolver().applyLogicalStepByIndex(selectedChoiceIndex);
	}

	private EList<EObject> loadModel(URI uri) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(uri);
		r.load(null);
		return r.getContents();
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}

	private TransactionalEditingDomain _editingDomain;
	public void setEditingDomain(TransactionalEditingDomain editingDomain) {
		_editingDomain = editingDomain;
	}
	
	public void saveTraceModel(Resource traceResource, Resource modelUnderExecutionResource, Solver solver, long stepNumber) throws CoreException, IOException {
		if (traceResource.getContents().size() > 0) {
			
//			Resource resource = getOriginalModel(modelUnderExecutionResource);			
//			// Configure EMF Compare
//			IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//			IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//			IMatchEngine matchEngine = new DefaultMatchEngine(matcher, comparisonFactory);
//			IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
//		    IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin.getDefault().getPostProcessorRegistry();
//			EMFCompare comparator = EMFCompare.builder()
//		                                           .setMatchEngineFactoryRegistry(matchEngineRegistry)
//		                                           .setPostProcessorRegistry(postProcessorRegistry)
//		                                           .build();
//			// Compare the two models
//			IComparisonScope scope = EMFCompare.createDefaultScope(resource, modelUnderExecutionResource);
//			Comparison usedComparison = comparator.compare(scope);
//			IComparisonScope scope1 = EMFCompare.createDefaultScope(modelUnderExecutionResource, resource);
//			Comparison otherComparison = comparator.compare(scope1);
//			usedComparison.getDifferences();
//			otherComparison.getDifferences();
			
//			IPath traceFilePath = new Path(traceResource.getURI().toPlatformString(true));
			
		    Copier copier = new Copier();		    
		    EObject result = copier.copy(_engine.getModelUnderExecutionResource().getContents().get(0));
		    copier.copyReferences();
		    			
			
			ExecutionTraceModel traceModel = (ExecutionTraceModel)traceResource.getContents().get(0);				
			if (traceModel.getChoices().size() > 0) {
				// link it to the trace model
				ModelState modelState = GemocExecutionEngineTraceFactory.eINSTANCE.createModelState();					
				traceResource.getContents().add(result);
				modelState.setModel(result);
				
				SolverState solverState = GemocExecutionEngineTraceFactory.eINSTANCE.createSolverState();									
				solverState.setSerializableModel(solver.getState());
				Activator.debug("step" + stepNumber + ", saving solver state: " 
						 + solverState.getSerializableModel());
				
				ContextState contextState = GemocExecutionEngineTraceFactory.eINSTANCE.createContextState();
				contextState.setModelState(modelState);
				contextState.setSolverState(solverState);
				traceModel.getChoices().get(traceModel.getChoices().size()-1).setContextState(contextState);
			}
			
//			saveResource(traceResource, traceFilePath);			
		}
	}

	private Resource getOriginalModel(Resource modelUnderExecutionResource) {
		ResourceSet rs = new ResourceSetImpl();
		URI modelURI = modelUnderExecutionResource.getURI();
		Resource resource = rs.getResource(modelURI, true);
		return resource;
	}

	private void saveResource(Resource resource, IPath filePath) throws IOException, CoreException {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = null;
		try {
			resource.save(out, null);				
			in = new ByteArrayInputStream(out.toByteArray());
			if (file.exists()) {
				file.setContents(in, true, false, new NullProgressMonitor());
			} else {
				file.create(in, true, new NullProgressMonitor());				
			}
		} finally {
			out.close();
			if (in != null)
				in.close();
		}
	}
}
