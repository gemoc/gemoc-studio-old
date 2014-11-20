package org.gemoc.execution.engine.io.addons;

import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.io.views.timeline.TimeLineView;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;

public class PrepareViewFrontend implements IEngineAddon 
{

	@Override
	public void engineAboutToStart(final IExecutionEngine engine) 
	{
		if (PlatformUI.isWorkbenchRunning())
		{
			PlatformUI
				.getWorkbench()
				.getDisplay()
				.syncExec(
						new Runnable()
						{
							@Override
							public void run() {
								ViewHelper.retrieveView(EnginesStatusView.ID);
								ViewHelper.retrieveView(LogicalStepsView.ID);
								ViewHelper.retrieveView(EventManagerView.ID);
								TimeLineView timelineView = ViewHelper.retrieveView(TimeLineView.ID);		
								AbstractExecutionEngine castedEngine = (AbstractExecutionEngine)engine;
								timelineView.configure(castedEngine);
							}			
						});	
		}
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preLogicalStepSelection(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postLogicalStepSelection(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postStopEngine(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine engine,
			LogicalStep logicalStepToApply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToExecuteMSE(IExecutionEngine engine,
			ModelSpecificEvent mse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStatusHasChanged(IExecutionEngine engine,
			RunStatus newStatus) {
		// TODO Auto-generated method stub
		
	}

}
