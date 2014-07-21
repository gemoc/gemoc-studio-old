package org.gemoc.execution.engine.io.views.event;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;
import org.gemoc.commons.eclipse.ui.ViewHelper;

public class LoadScenario extends AbstractHandler {

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
		}
		else
		{
			eventView.informationMsg("Load Scenario", "Please Select one engine");
		}
		return null;
	}
}
