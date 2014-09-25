package org.gemoc.execution.engine.io.views.event.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.runtime.IPath;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.event.EventManagerView.SourceProviderControls;
import org.gemoc.execution.engine.io.views.event.SelectScenarioFileDialog;

@SuppressWarnings("restriction")
public class LoadScenario extends AbstractHandler /*implements IScenarioStateChangeListener*/ {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		if(eventView.getEngine()!=null)
		{
//			FileDialog dialog = new FileDialog(eventView.getSite().getShell(), SWT.OPEN);
//			dialog.setFilterExtensions(new String[]{"*.scenario"});
//			//dialog.setFilterPath(EventManagementCache.scenarioPath);
//			String path = dialog.open();
//			eventView.loadScenario(path);

			eventView.loadScenario(selectScenario());
			
			if(eventView.getScenario()!=null)
			{
				eventView.informationMsg("Replay", "Beginning");
				eventView.executeService(SourceProviderControls.PLAY);
			}
		}
		else
		{
			eventView.informationMsg("Load Scenario", "Please Select one engine");
		}
		return null;
	}
	
	private IPath selectScenario(){
		SelectScenarioFileDialog selector = new SelectScenarioFileDialog();
		selector.open();
		Object[] selection = selector.getResult();
		IPath path = ( (File)selection[0]).getLocation();
		return path;
	}
}
