package org.gemoc.execution.engine.io.frontends;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.execution.engine.io.views.ExecutionTraceView;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.obeo.TimelineProvider;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.obeo.timeline.view.TimelineView;

public class PrepareViewFrontend implements Frontend 
{

	/**
	 * The {@link AdapterFactory} created from the EMF registry.
	 */
	private final AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	
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
								ViewHelper.retrieveView(ExecutionTraceView.ID);
								TimelineView timelineView = ViewHelper.retrieveView(TimelineView.ID);			
								ObservableBasicExecutionEngine e = (ObservableBasicExecutionEngine) engine;
								timelineView.setDetailViewerContentProvider(new AdapterFactoryContentProvider(adapterFactory));
								timelineView.setDetailViewerLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
								timelineView.setTimelineProvider(new TimelineProvider(e));
							}
			
						});	
		}
	}

}
