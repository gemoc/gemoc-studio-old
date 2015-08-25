package org.gemoc.sequential_addons.multidimensional.timeline.views.timeline;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.obeo.timeline.view.ITimelineProvider;

public interface IMultiDimensionalTraceAddon extends IEngineAddon{

	void goTo(EObject o1);
	
	void goToNoTimelineNotification(int i);
	
	void goTo(int i);

	ITimelineProvider getTimeLineProvider();
	
}
