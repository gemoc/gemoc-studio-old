package org.gemoc.sequential_addons.multidimensional.timeline.views.timeline;

import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gemoc.executionframework.ui.views.engine.IEngineSelectionListener;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IBasicExecutionEngine;

import fr.obeo.timeline.editpart.PossibleStepEditPart;
import fr.obeo.timeline.editpart.TimelineEditPartFactory;
import fr.obeo.timeline.view.AbstractTimelineView;
import fr.obeo.timeline.view.ITimelineProvider;

public class MultidimensionalTimeLineView extends AbstractTimelineView implements IEngineSelectionListener {

	public static final String ID = "org.gemoc.sequential_addons.multidimensional.timeline.views.timeline.TimeLineView";

	public static final String FOLLOW_COMMAND_ID = "org.gemoc.execution.engine.io.views.timeline.Follow";

	/**
	 * The {@link AdapterFactory} created from the EMF registry.
	 */
	private final AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	private IContentProvider _contentProvider;
	private ILabelProvider _labelProvider;

	private IBasicExecutionEngine _currentEngine;

	private WeakHashMap<IBasicExecutionEngine, Integer> _positions = new WeakHashMap<IBasicExecutionEngine, Integer>();

	public MultidimensionalTimeLineView() {
		_contentProvider = new AdapterFactoryContentProvider(adapterFactory);
		_labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		startListeningToMotorSelectionChange();
	}

	@Override
	public void dispose() {
		disposeTimeLineProvider();
		removeDoubleClickListener();
		stopListeningToMotorSelectionChange();
		super.dispose();
		_contentProvider.dispose();
		_labelProvider.dispose();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		setDetailViewerContentProvider(_contentProvider);
		setDetailViewerLabelProvider(_labelProvider);
		_mouseListener = new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent event) {
				handleDoubleCick();
			}
		};

		getTimelineViewer().getControl().addMouseListener(_mouseListener);
	}


	private void startListeningToMotorSelectionChange() {
		org.gemoc.executionframework.ui.Activator.getDefault().getEngineSelectionManager().addEngineSelectionListener(this);
	}

	private void stopListeningToMotorSelectionChange() {
		org.gemoc.executionframework.ui.Activator.getDefault().getEngineSelectionManager().removeEngineSelectionListener(this);
	}

	private ITimelineProvider _timelineProvider;
	private MouseListener _mouseListener = null;

	public void configure(IBasicExecutionEngine engine) {
		if (_currentEngine != engine || _timelineProvider == null) {
			saveStartIndex();
			_currentEngine = engine;
			disposeTimeLineProvider();
			if (engine != null) {
				int start = getStartIndex(engine);
				
				// We first look for trace addons
				Set<IMultiDimensionalTraceAddon> traceAddons = engine.getAddonsTypedBy(IMultiDimensionalTraceAddon.class);
				if (!traceAddons.isEmpty()){
					_timelineProvider = traceAddons.iterator().next().getTimeLineProvider();

					setTimelineProvider(_timelineProvider, start);
				}
			}
		}
	}

	private int getStartIndex(IBasicExecutionEngine engine) {
		int start = 0;
		if (_positions.containsKey(engine)) {
			start = _positions.get(engine);
		}
		return start;
	}

	private void saveStartIndex() {
		if (_currentEngine != null) {
			_positions.put(_currentEngine, getStart());
		}
	}

	private void removeDoubleClickListener() {
		if (_mouseListener != null && getTimelineViewer() != null && getTimelineViewer().getControl() != null) {
			getTimelineViewer().getControl().removeMouseListener(_mouseListener);
		}
	}

	private void disposeTimeLineProvider() {
		if (_timelineProvider != null) {
			((IDisposable) _timelineProvider).dispose();
			_timelineProvider = null;
			setTimelineProvider(_timelineProvider, 0);
		}
	}

	@Override
	public void engineSelectionChanged(IBasicExecutionEngine engine) {
		update(engine);
	}

	private boolean canDisplayTimeline(IBasicExecutionEngine engine) {
		if (engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Run)
				&& engine.getRunningStatus().equals(RunStatus.Stopped)) {
			return true;
		}
		if (engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Animation)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasDetailViewer() {
		return false;
	}

	@Override
	public String getFollowCommandID() {
		return FOLLOW_COMMAND_ID;
	}

	private void handleDoubleCick() {
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService()
				.getSelection();
		if (selection instanceof IStructuredSelection) {
			final Object selected = ((IStructuredSelection) selection).getFirstElement();
			if (selected instanceof PossibleStepEditPart) {
				final Object o1 = ((PossibleStepEditPart) selected).getModel().getChoice2();
				//Object o2 = ((PossibleStepEditPart) selected).getModel().getPossibleStep();
				for (IMultiDimensionalTraceAddon traceAddon : _currentEngine.getAddonsTypedBy(IMultiDimensionalTraceAddon.class)) {
					if (o1 instanceof EObject)
						traceAddon.goTo((EObject) o1);
				}
			}
		}
	}

	@Override
	protected TimelineEditPartFactory getTimelineEditPartFactory() {
		return new TimelineEditPartFactory(false);
	}

	public void update(IBasicExecutionEngine engine) {
		if (engine != null) {
			if (canDisplayTimeline(engine)) {
				configure(engine);
			} else {
				disposeTimeLineProvider();
			}
		}
	}
}
