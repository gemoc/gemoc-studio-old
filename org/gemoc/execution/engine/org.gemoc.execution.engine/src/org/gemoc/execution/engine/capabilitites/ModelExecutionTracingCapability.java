package org.gemoc.execution.engine.capabilitites;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicMonitor;
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
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
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
			return;
		backInTraceModelTo(choice);
		_backToPastHappened = true;
		if (_engine.getLogicalStepDecider() != null) 
		{
			_engine.getLogicalStepDecider().preempt();
		}
	}

	private void backInTraceModelTo(final Choice choice) {
		final int index = _engine.getExecutionTrace().getChoices().indexOf(choice);
		if (index != -1
			&& index != _engine.getExecutionTrace().getChoices().size()) {
			final CommandStack commandStack = _editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(_editingDomain) {
				@Override
				protected void doExecute() {
					_engine.getExecutionTrace().getChoices().subList(index, _engine.getExecutionTrace().getChoices().size()).clear();
					if (_engine.getExecutionTrace().getChoices().size() > 0)
						_engine.getExecutionTrace().getChoices().get(_engine.getExecutionTrace().getChoices().size()-1).setNextChoice(null);
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
		IComparisonScope scope1 = EMFCompare.createDefaultScope(choice.getContextState().getModelState().getModel(), _engine.getModelUnderExecutionResource().getContents().get(0));
		Comparison otherComparison = comparator.compare(scope1);
		otherComparison.getDifferences();
		
		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : otherComparison.getDifferences()) {
			
			if (diff instanceof AttributeChangeSpec) 
			{
				// if attribute, modify value on the aspect side that will modify the model in return.
				AttributeChangeSpec asc = (AttributeChangeSpec)diff;
				CodeExecutor codeExecutor = _engine.getCodeExecutor();
				EObject target = diff.getMatch().getRight();
				String methodName = asc.getAttribute().getName();
				ArrayList parameters = new ArrayList();
				parameters.add(asc.getValue());
				try {
					System.out.println("Begin setting " + target.toString() + "." + methodName + " = " + asc.getValue());
					codeExecutor.invoke(target, methodName, parameters);
					System.out.println("End setting " + target.toString() + "." + methodName + " = " + asc.getValue());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
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
	
//	private void restoreModelState(Comparison firstComparison, Comparison secondComparison) throws IOException {		
//		Merger merger = new Merger();
//		BasicMonitor monitor = new BasicMonitor();
//		if (firstComparison.getDifferences().size() > 0) {
//			for (Diff diff : firstComparison.getDifferences()) {
//				merger.copyLeftToRight(
//						diff,
//						monitor);			
//				diff.setState(DifferenceState.UNRESOLVED);
//				merger.copyRightToLeft(
//						diff,
//						monitor);			
//				diff.setState(DifferenceState.UNRESOLVED);
//			}			
//		} else if (secondComparison.getDifferences().size() > 0) {
//			for (Diff diff : secondComparison.getDifferences()) {
//				merger.copyRightToLeft(
//						diff,
//						monitor);			
//				diff.setState(DifferenceState.UNRESOLVED);
//			}			
//		}
//	}

	byte[] _lastRestoredSolverState;
	private void restoreSolverState(Choice choice) 
	{
		Activator.debug("restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
		_engine.getSolver().setState(choice.getContextState().getSolverState().getSerializableModel());
		boolean b = Arrays.equals(_engine.getSolver().getState(), choice.getContextState().getSolverState().getSerializableModel());
		if (b)
			Activator.debug("new state does equal the restored state");
		else
			Activator.debug("new state does NOT equal the restored state");
	}

//	private EList<EObject> loadModel(URI uri) throws IOException {
//		ResourceSet rs = new ResourceSetImpl();
//		Resource r = rs.createResource(uri);
//		r.load(null);
//		return r.getContents();
//	}

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
		if (traceResource.getContents().size() > 0) 
		{			
		    Copier copier = new GCopier();		    
		    EObject result = copier.copy(_engine.getModelUnderExecutionResource().getContents().get(0));
		    copier.copyReferences();
			
			ExecutionTraceModel traceModel = (ExecutionTraceModel)traceResource.getContents().get(0);				
			if (traceModel.getChoices().size() > 0) 
			{
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
		}
	}

//	private Resource getOriginalModel(Resource modelUnderExecutionResource) {
//		ResourceSet rs = new ResourceSetImpl();
//		URI modelURI = modelUnderExecutionResource.getURI();
//		Resource resource = rs.getResource(modelURI, true);
//		return resource;
//	}
//
//	private void saveResource(Resource resource, IPath filePath) throws IOException, CoreException {
//		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);		
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		ByteArrayInputStream in = null;
//		try {
//			resource.save(out, null);				
//			in = new ByteArrayInputStream(out.toByteArray());
//			if (file.exists()) {
//				file.setContents(in, true, false, new NullProgressMonitor());
//			} else {
//				file.create(in, true, new NullProgressMonitor());				
//			}
//		} finally {
//			out.close();
//			if (in != null)
//				in.close();
//		}
//	}
}
