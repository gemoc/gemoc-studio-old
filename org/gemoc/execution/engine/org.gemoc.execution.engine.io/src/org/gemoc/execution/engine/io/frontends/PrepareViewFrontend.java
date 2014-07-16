package org.gemoc.execution.engine.io.frontends;

import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.io.views.timeline.TimeLineView;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public class PrepareViewFrontend implements Frontend 
{


	
	@Override
	public void initialize(final GemocExecutionEngine engine) {
		if (PlatformUI.isWorkbenchRunning())
		{
			PlatformUI
				.getWorkbench()
				.getDisplay()
				.asyncExec(
						new Runnable()
						{

							@Override
							public void run() {
								ViewHelper.retrieveView(EnginesStatusView.ID);
								ViewHelper.retrieveView(LogicalStepsView.ID);
								ViewHelper.retrieveView(EventManagerView.ID);
								TimeLineView timelineView = ViewHelper.retrieveView(TimeLineView.ID);		
								ObservableBasicExecutionEngine castedEngine = (ObservableBasicExecutionEngine)engine;
								timelineView.configure(castedEngine);
							}
			
						});	
		}
	}

}