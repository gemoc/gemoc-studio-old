package org.gemoc.gemoc_language_workbench.extensions.timesquare.moc.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_traceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.extensions.timesquare.Activator;
import org.gemoc.gemoc_language_workbench.utils.ccsl.QvtoTransformationPerformer;

import fr.inria.aoste.timesquare.ccslkernel.explorer.CCSLConstraintState;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.NoBooleanSolution;
import fr.inria.aoste.timesquare.ccslkernel.runtime.exceptions.SimulationException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.timesquare.ccslkernel.solver.launch.CCSLKernelSolverWrapper;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.simulationpolicy.maxcardpolicy.MaxCardSimulationPolicy;
import fr.inria.aoste.trace.EventOccurrence;
//import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;

/**
 * Implementation of the ISolver dedicated to CCSL.
 * 
 */
public class CcslSolver implements org.gemoc.gemoc_language_workbench.api.moc.ISolver {

	private CCSLKernelSolverWrapper solverWrapper = null;
	private URI solverInputURI = null;
	private ArrayList<LogicalStep> _lastLogicalSteps = new ArrayList<LogicalStep>();
	private ActionModel _feedbackModel;
	
	public CcslSolver() 
	{
	}

	@Override
	public ArrayList<ModelElementReference> getAllDiscreteClocks(){
		return solverWrapper.getClockList();
	}
	
	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockAbsence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) {
		this.solverWrapper.forceClockPresence(this
				.getModelElementReferenceFromEventOccurrence(eventOccurrence));

	}

	/**
	 * Returns the ModelElementReference refered by this eventOccurrence (as
	 * originally sent by the CCSL Solver).
	 * 
	 * @param eventOccurrence
	 * @return
	 */
	private ModelElementReference getModelElementReferenceFromEventOccurrence(
			EventOccurrence eventOccurrence) {
		Reference reference = eventOccurrence.getReferedElement();
		if (reference instanceof ModelElementReference) {
			ModelElementReference mer = (ModelElementReference) reference;
			return mer;
			//			ModelElementReference merToForce = this.mappingEventToOriginalMer
//					.get(mer.getElementRef().get(0));
//			return merToForce;
		} else {
			throw new RuntimeException(
					"Refered Element of eventOccurrence should be a ModelElementReference");
		}
	}

	private LogicalStep createLogicalStep(fr.inria.aoste.trace.LogicalStep res) 
	{
		LogicalStep ls = Gemoc_execution_traceFactory.eINSTANCE.createLogicalStep();
		for (Event e : LogicalStepHelper.getTickedEvents(res))
		{
			MSEOccurrence mseOccurrence = Gemoc_execution_traceFactory.eINSTANCE.createMSEOccurrence();
			for (ModelSpecificEvent mse : _feedbackModel.getEvents())
			{
				if (mse.getName().replace("MSE_", "").equals(e.getName().replace("evt_", "")))
				{
					mseOccurrence.setMse(mse);
					break;
				}
			}
			
			ls.getMseOccurrences().add(mseOccurrence);
		}
		return ls;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[modelOfExecutionURI="
				+ this.solverInputURI + "]";
	}

	private void createSolver(IExecutionContext context) 
	{
		this.solverInputURI = URI.createPlatformResourceURI(context.getWorkspace().getMoCPath().toString(), true);
		URI feedbackURI = URI.createPlatformResourceURI(context.getWorkspace().getFeedbackModelPath().toString(), true);
		
		try 
		{
			ResourceSet resourceSet = context.getResourceModel().getResourceSet();		
			
			Resource ccslResource = resourceSet.getResource(this.solverInputURI, true);
			EcoreUtil.resolveAll(resourceSet);
			traceResources(resourceSet);
			traceUnresolvedProxies(resourceSet, solverInputURI);			
			
			this.solverWrapper = new CCSLKernelSolverWrapper();
			this.solverWrapper.getSolver().loadModel(ccslResource);
			this.solverWrapper.getSolver().initSimulation();
			this.solverWrapper.getSolver().setPolicy(new MaxCardSimulationPolicy());

			Resource feedbackResource = resourceSet.getResource(feedbackURI, true);
			_feedbackModel = (ActionModel)feedbackResource.getContents().get(0);
			
		} catch (IOException e) {
			String errorMessage = "IOException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (UnfoldingException e) {
			String errorMessage = "UnfoldingException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (SolverException e) {
			String errorMessage = "SolverException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		} catch (SimulationException e) {
			String errorMessage = "SimulationException while instantiating the CcslSolver";
			Activator.getDefault().error(errorMessage);
			Activator.getDefault().error(errorMessage, e);
		}
	}

	private void traceUnresolvedProxies(ResourceSet resourceSet,
			URI solverInputURI) {
		Map<EObject, Collection<Setting>>  unresolvedProxies = EcoreUtil.UnresolvedProxyCrossReferencer.find(resourceSet);
		if(unresolvedProxies.size() != 0){
			Activator.getDefault().warn("There are unresolved proxies in "+solverInputURI+ ", the first is "+unresolvedProxies.entrySet().toArray()[0]);
			Activator.getDefault().warn("Please verify your extendedCCSL file, (it must not contain resolve warning).");
		}
	}

	private void traceResources(ResourceSet resourceSet) {
		Activator.getDefault().info("Input resources:");
		for(Resource r : resourceSet.getResources()) 
		{
			Activator.getDefault().info(r.getURI().toString());
		}
	}

	@Override
	public List<LogicalStep> computeAndGetPossibleLogicalSteps() {
		
		try {
			List<fr.inria.aoste.trace.LogicalStep> intermediateResult = solverWrapper.computeAndGetPossibleLogicalSteps();			
			_lastLogicalSteps.clear();
			for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : intermediateResult)
			{
				LogicalStep lsFromTrace = createLogicalStep(lsFromTimesquare);
				_lastLogicalSteps.add(lsFromTrace);
			}
			return new ArrayList<LogicalStep>(_lastLogicalSteps);
		} catch (NoBooleanSolution e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
		return new ArrayList<LogicalStep>();
	}

	@Override
	public List<LogicalStep> updatePossibleLogicalSteps() {
		
		try {
			List<fr.inria.aoste.trace.LogicalStep> intermediateResult = solverWrapper.updatePossibleLogicalSteps();			
			_lastLogicalSteps.clear();
			for (fr.inria.aoste.trace.LogicalStep lsFromTimesquare : intermediateResult)
			{
				LogicalStep lsFromTrace = createLogicalStep(lsFromTimesquare);
				_lastLogicalSteps.add(lsFromTrace);
			}
			return new ArrayList<LogicalStep>(_lastLogicalSteps);
		} catch (NoBooleanSolution e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
		return new ArrayList<LogicalStep>();
	}

	@Override
	public LogicalStep proposeLogicalStep() {
		int index = solverWrapper.proposeLogicalStepByIndex();
		LogicalStep result = null;
		if (_lastLogicalSteps.size() > index)
		{
			result = _lastLogicalSteps.get(index);			
		}
		return result;
	}

	@Override
	public void applyLogicalStep(LogicalStep logicalStep) {
		try {
			int index = _lastLogicalSteps.indexOf(logicalStep);
			solverWrapper.applyLogicalStepByIndex(index);
		} catch (SolverException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SimulationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}
	}

	@Override
	public byte[] getState() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut;
		try {
			objOut = new ObjectOutputStream(out);
	        objOut.writeObject(solverWrapper.getSolver().getCurrentState());
			return out.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void setState(byte[] serializableModel) {
		ByteArrayInputStream out = new ByteArrayInputStream(serializableModel);
        ObjectInputStream objOut;
		try {
			objOut = new ObjectInputStream(out);
	        Object o = objOut.readObject();
	        solverWrapper.getSolver().setCurrentState((CCSLConstraintState) o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void revertForceClockEffect() {
		try {
			solverWrapper.revertForceClockEffect();
		} catch (SimulationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void setUp(IExecutionContext context) 
	{
		generateMoC(context);
		createSolver(context);
	}
	
	private void generateMoC(IExecutionContext context) 
	{
		IExecutionWorkspace workspace = context.getWorkspace();
		String transformationPath = context.getLanguageDefinitionExtension().getQVTOPath();
		boolean mustGenerate = false;
		IFile mocFile = ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getMoCPath());		
		if (!mocFile.exists()
			|| 	ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getModelPath()).getLocalTimeStamp() > 
				ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getMoCPath()).getLocalTimeStamp()) 
		{
			mustGenerate = true;
		}
		IFile feedbackFile = ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getFeedbackModelPath());
		if (!feedbackFile.exists()
				|| 	ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getModelPath()).getLocalTimeStamp() > 
					ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getFeedbackModelPath()).getLocalTimeStamp()) 
		{
			mustGenerate = true;
		}
		
		if (mustGenerate)
		{
			QvtoTransformationPerformer performer = new QvtoTransformationPerformer();
			performer.run(
						context.getResourceModel().getResourceSet(),
						"platform:/plugin" + transformationPath, 
						context.getRunConfiguration().getExecutedModelAsMelangeURI().toString(), 
						"platform:/resource" + workspace.getMoCPath().toString(),
						"platform:/resource" + workspace.getFeedbackModelPath().toString());			
		}		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
