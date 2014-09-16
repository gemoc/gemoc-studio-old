package org.gemoc.execution.engine.io.views.event.commands;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.event.EventManagerView.SourceProviderControls;

public class DoInit extends AbstractHandler {
	
	public static final String ID = "org.gemoc.execution.engine.io.views.event.commands.DoInit";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		eventView.executeService(SourceProviderControls.INIT);
		return null;			
	}	
	
}
