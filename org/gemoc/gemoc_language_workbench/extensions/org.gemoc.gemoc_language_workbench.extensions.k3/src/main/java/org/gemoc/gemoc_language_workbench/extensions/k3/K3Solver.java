package org.gemoc.gemoc_language_workbench.extensions.k3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.execution.engine.core.IMSEOccurrenceListener;
import org.gemoc.execution.engine.core.MSEManager;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionWorkspace;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;

public class K3Solver implements ISolver, IMSEOccurrenceListener
{

	@Override
	public void forbidEventOccurrence(EventOccurrence eventOccurrence) 
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void forceEventOccurrence(EventOccurrence eventOccurrence) 
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<LogicalStep> computeAndGetPossibleLogicalSteps() 
	{
		return updatePossibleLogicalSteps();
	}

	@Override
	public List<LogicalStep> updatePossibleLogicalSteps() 
	{ 	ArrayList<LogicalStep> l = new ArrayList<LogicalStep>();
		if (_lastOccurrence != null
			&& _lastOccurrence.getLogicalstep() != null)
		{
			l.add(_lastOccurrence.getLogicalstep());
		}
		return l;
	}

	@Override
	public LogicalStep proposeLogicalStep() 
	{
		if (_lastOccurrence.getLogicalstep() != null)
		{
			return _lastOccurrence.getLogicalstep();
		}
		return null;
	}

	@Override
	public void applyLogicalStep(LogicalStep logicalStep) 
	{
	}

	private Resource _resourceModel;

	@Override
	public byte[] getState() 
	{
		return new byte[] {};
	}

	@Override
	public void setState(byte[] serializableModel) 
	{
	}

	@Override
	public void revertForceClockEffect() 
	{
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void setUp(IExecutionContext context) 
	{
		Resource resourceFeedback = generateFeedback(context);
		_resourceModel = context.getResourceModel();
		MSEManager.getInstance().addListener(this);
		MSEManager.getInstance().setActiveActionModel((ActionModel) resourceFeedback.getContents().get(0));
		
	}

	@Override
	public void dispose() 
	{
		MSEManager.getInstance().removeListener(this);
	}

	private MSEOccurrence _lastOccurrence;
	
	@Override
	public void mseOccurenceRaised(MSEOccurrence occurrence) 
	{
	}

	@Override
	public ArrayList<ModelElementReference> getAllDiscreteClocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mseOccurenceAboutToBeRaised(MSEOccurrence occurrence) 
	{
		_lastOccurrence = occurrence;
		String uri = _resourceModel.getURIFragment(occurrence.getMse().getCaller());
//		String uri = engine.getExecutionContext().getResourceModel().getURIFragment(occurrence.getMse().getCaller());
		if (uri != null)
		{
			ArrayList<LogicalStep> logicalSteps = new ArrayList<LogicalStep>();
			logicalSteps.add(occurrence.getLogicalstep());
		}
	}
	
	private Resource generateFeedback(IExecutionContext context) 
	{
		IExecutionWorkspace workspace = context.getWorkspace();
		boolean mustGenerate = false;
		IFile feedbackFile = ResourcesPlugin.getWorkspace().getRoot().getFile(workspace.getFeedbackModelPath());
		if (!feedbackFile.exists()
				|| workspace.getModelPath().toFile().lastModified() > workspace.getFeedbackModelPath().toFile().lastModified()) 
		{
			mustGenerate = true;
		}
		
		if (mustGenerate)
		{
			// generate an empty feedback model. It will be filled on the fly when running the model using this k3 solver
			ResourceSet resourceSet = context.getResourceModel().getResourceSet();
			Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(workspace.getFeedbackModelPath().toString().toString(), true));
			resource.getContents().add(FeedbackFactory.eINSTANCE.createActionModel());
			try {
				resource.save(null);
			} catch (IOException e) {
				new RuntimeException("Error when saving feedback model", e);
			}
			return resource;
		} else {
			URI feedbackPlatformURI = URI.createPlatformResourceURI(workspace.getFeedbackModelPath().toString(), true);
			Resource resource = context.getResourceModel().getResourceSet().getResource(feedbackPlatformURI, true);
			return resource;				
			 
		}
		
	}

	@Override
	public void mseOccurenceEnded(MSEOccurrence occurrence) {
		// TODO Auto-generated method stub
		
	}

}
