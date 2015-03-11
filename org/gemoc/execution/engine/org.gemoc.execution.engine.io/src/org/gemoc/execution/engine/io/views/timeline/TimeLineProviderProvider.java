package org.gemoc.execution.engine.io.views.timeline;

import org.gemoc.gemoc_language_workbench.api.engine_addon.DefaultEngineAddon;

import fr.obeo.timeline.view.AbstractTimelineProvider;

public class TimeLineProviderProvider extends DefaultEngineAddon {

	private AbstractTimelineProvider currentProvider;

	public void setTimeLineProvider(AbstractTimelineProvider newProvider) {
		currentProvider = newProvider;
	}

	public AbstractTimelineProvider getTimeLineProvider() {
		return currentProvider;
	}

}
