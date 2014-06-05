package org.gemoc.execution.engine.io.frontends;

import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.views.EnginesStatusView;
import org.gemoc.execution.engine.io.views.ExecutionTraceView;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public class PrepareViewFrontend implements Frontend 
{

	@Override
	public void initialize(GemocExecutionEngine engine) {
		if (PlatformUI.isWorkbenchRunning())
		{
			ViewHelper.retrieveView(EnginesStatusView.ID);
			ViewHelper.retrieveView(ExecutionTraceView.ID);
		}
	}

}
