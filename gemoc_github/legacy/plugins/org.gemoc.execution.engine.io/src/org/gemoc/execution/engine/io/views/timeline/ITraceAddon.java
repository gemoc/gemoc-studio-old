package org.gemoc.execution.engine.io.views.timeline;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.obeo.timeline.view.ITimelineProvider;

public interface ITraceAddon extends IEngineAddon{

	void goTo(EObject o1);
	
	void goToNoTimelineNotification(int i);
	
	void goTo(int i);

	ITimelineProvider getTimeLineProvider();
	
}
