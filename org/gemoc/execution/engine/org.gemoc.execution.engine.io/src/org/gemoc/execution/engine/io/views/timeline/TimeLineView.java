package org.gemoc.execution.engine.io.views.timeline;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.capabilitites.ModelExecutionTracingCapability;
import org.gemoc.execution.engine.capabilitites.ModelExecutionTracingException;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.ExecutionTraceModelWrapper;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.timeline.internal.editpart.ChoiceEditPart;
import fr.obeo.timeline.view.TimelineView;

public class TimeLineView extends TimelineView implements IMotorSelectionListener
{

	public static final String ID = "org.gemoc.execution.engine.io.views.timeline.TimeLineView";
	
	/**
	 * The {@link AdapterFactory} created from the EMF registry.
	 */
	private final AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private ObservableBasicExecutionEngine _currentEngine;
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		startListeningToMotorSelectionChange();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		disposeTimeLineProvider();
		removeDoubleClickListener();
		stopListeningToMotorSelectionChange();
	}

	private EnginesStatusView _enginesStatusView;

	private void startListeningToMotorSelectionChange() {
		_enginesStatusView = ViewHelper.retrieveView(EnginesStatusView.ID);
		if (_enginesStatusView != null) {
			_enginesStatusView.addMotorSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView != null) {
			_enginesStatusView.removeMotorSelectionListener(this);
		}
	}
	
	private TimelineProvider _timelineProvider;
	private MouseListener _mouseListener = null;
	
	public void configure(ObservableBasicExecutionEngine engine)
	{
		_currentEngine = engine;
		setDetailViewerContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		setDetailViewerLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		disposeTimeLineProvider();
		_timelineProvider = new TimelineProvider(engine);
		setTimelineProvider(_timelineProvider);

		removeDoubleClickListener();

		_mouseListener = new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) 
			{
			}
			
			@Override
			public void mouseDown(MouseEvent e) 
			{
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent event) 
			{
					final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
					if (selection instanceof IStructuredSelection) {
						final Object selected = ((IStructuredSelection) selection).getFirstElement();
						if (selected instanceof ChoiceEditPart) 
						{
							Object o = ((ChoiceEditPart) selected).getModel().getChoice();
							if (o instanceof Choice)
							{								
								if (_currentEngine.getEngineStatus().getRunningStatus().equals(RunStatus.WaitingLogicalStepSelection)
										&& _currentEngine.hasCapability(ModelExecutionTracingCapability.class)) {
									Choice choice = (Choice)o;
									try 
									{
										_currentEngine.capability(ModelExecutionTracingCapability.class).backToPast(choice);
									} catch (ModelExecutionTracingException e) 
									{
										e.printStackTrace();
									}				
								}
							}
						}
				}
			}

		};
		
		getTimelineViewer()
			.getControl()
			.addMouseListener(_mouseListener);
	}

	private void removeDoubleClickListener() {
		if (_mouseListener != null) 
		{
			getTimelineViewer()
				.getControl()
				.removeMouseListener(_mouseListener);			
		}
	}

	private void disposeTimeLineProvider() {
		if (_timelineProvider != null)
		{
			_timelineProvider.dispose();
		}
	}

	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		configure((ObservableBasicExecutionEngine)engine);
	}
	
}
