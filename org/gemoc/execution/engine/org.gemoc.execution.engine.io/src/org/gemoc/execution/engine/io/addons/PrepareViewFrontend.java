package org.gemoc.execution.engine.io.addons;

import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.io.views.timeline.TimeLineView;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;

public class PrepareViewFrontend extends DefaultEngineAddon 
{

	private TimeLineView _timelineView;
	
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
								_timelineView = ViewHelper.retrieveView(TimeLineView.ID);		
								AbstractExecutionEngine castedEngine = (AbstractExecutionEngine)engine;
								_timelineView.configure(castedEngine);
							}			
						});	
		}
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine) 
	{
		_timelineView.update(engine);
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) 
	{
		_timelineView.update(engine);
	}

}
