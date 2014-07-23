package org.gemoc.execution.engine.io.views.event.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagementCache;
import org.gemoc.execution.engine.io.views.event.EventManagerView;

public class LoadScenario extends AbstractHandler /*implements IScenarioStateChangeListener*/ {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		if(eventView.getEngine()!=null)
		{
			FileDialog dialog = new FileDialog(eventView.getSite().getShell(), SWT.OPEN);
			dialog.setFilterExtensions(new String[]{"*.scenario"});
			dialog.setFilterPath(EventManagementCache.scenarioPath);
			String path = dialog.open();
			eventView.loadScenario(path);
			if(eventView.getScenario()!=null)
			{
				eventView.informationMsg("Replay", "Beginning");
				eventView.executeService(event, "PLAY");
			}
		}
		else
		{
			eventView.informationMsg("Load Scenario", "Please Select one engine");
		}
		return null;
	}
}
