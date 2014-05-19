package org.gemoc.execution.engine.io.views;

import java.util.ArrayList;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.gemoc_commons.ui.ViewHelper;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class ExecutionTraceView extends ViewPart implements
		IMotorSelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.gemoc.execution.engine.io.views.ExecutionTraceView";

	private TableViewer viewer;

	private ExecutionTraceModelWrapper _lastCreatedWrapper;

	private EnginesStatusView _enginesStatusView;

	private Composite _parent;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	class ViewContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			int greatestChosenLogicalStepIndex = 0;
			ArrayList<ExecutionTraceModelWrapper> result = new ArrayList<ExecutionTraceModelWrapper>();
			if (parent != null) {
				if (parent instanceof GemocExecutionEngine) {
					GemocExecutionEngine engine = (GemocExecutionEngine) parent;
					for (Choice currentChoice : engine.getExecutionTrace().getChoices())
					{
						ExecutionTraceModelWrapper wrapper = new ExecutionTraceModelWrapper(currentChoice, engine.getEngineStatus().getRunningStatus());
						int chosenLogicalStepIndex = wrapper
								.getChosenLogicalStepIndex();
						if (chosenLogicalStepIndex > greatestChosenLogicalStepIndex)
							greatestChosenLogicalStepIndex = chosenLogicalStepIndex;
						result.add(wrapper);
					}
				}
			}
			for (ExecutionTraceModelWrapper wrapper : result) {
				int chosenLogicalStepIndex = wrapper
						.getChosenLogicalStepIndex();
				int leftBlankNumber = greatestChosenLogicalStepIndex
						- chosenLogicalStepIndex;
				if (chosenLogicalStepIndex == -1)
					leftBlankNumber = 0;
				wrapper.setLeftBlankCounter(leftBlankNumber);
			}
			if (!result.isEmpty()) {
				_lastCreatedWrapper = result.get(result.size() - 1);
			}
			return result.toArray();
		}
	}

	/**
	 * The constructor.
	 */
	public ExecutionTraceView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		_parent = parent;
		createTableViewer(null);
		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(viewer.getControl(),
						"org.gemoc.execution.engine.io.viewer");
		// get the motor view to listen to motor selection
		startListeningToMotorSelectionChange();
	}

	private void createTableViewer(GemocExecutionEngine executionEngine) {
		viewer = new TableViewer(_parent, SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		viewer.getTable().setLinesVisible(false);
		ColumnViewerToolTipSupport.enableFor(viewer, ToolTip.NO_RECREATE);
		createColumns();
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setInput(executionEngine);
		viewer.addDoubleClickListener(new DoubleClickListener());
	}

	private void createColumns() {
		for (Integer i = 0; i < 10; i++) {
			TableViewerColumn col = createTableViewerColumn(i.toString(), 25, 0);
			col.setLabelProvider(new SpecificColumnLabelProvider(i));
		}
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound,
			final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		return viewerColumn;
	}

	class SpecificColumnLabelProvider extends ColumnLabelProvider {

		private int _columnIndex;

		public SpecificColumnLabelProvider(int columnIndex) {
			_columnIndex = columnIndex;
		}

		@Override
		public String getText(Object element) {
			String result = null;
			return result;
		}

		@Override
		public String getToolTipText(Object element) {
			String result = null;
			if (element instanceof ExecutionTraceModelWrapper) {
				ExecutionTraceModelWrapper wrapper = (ExecutionTraceModelWrapper) element;
				result = wrapper.getToolTipText(_columnIndex);
			}
			return result;
		}

		@Override
		public Point getToolTipShift(Object object) {
			return new Point(10, 10);
		}

		@Override
		public int getToolTipDisplayDelayTime(Object object) {
			return 0; // msec
		}

		@Override
		public int getToolTipTimeDisplayed(Object object) {
			return 0; // msec
		}

		@Override
		public Font getToolTipFont(Object object) {
			return JFaceResources.getFont(JFaceResources.TEXT_FONT);
		}
		
		@Override
		public Image getImage(Object element) {
			if (element instanceof ExecutionTraceModelWrapper) {
				return ((ExecutionTraceModelWrapper) element)
						.getColumnImage(_columnIndex);
			}
			return null;
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

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

	private GemocExecutionEngine _currentEngine;

	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) {
			_currentEngine = engine;
			viewer.setInput(_currentEngine);
			if (_lastCreatedWrapper != null)
				viewer.reveal(_lastCreatedWrapper);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		_currentEngine = null;
		stopListeningToMotorSelectionChange();
	}

	public class DoubleClickListener implements IDoubleClickListener {

		@Override
		public void doubleClick(DoubleClickEvent event) {
			if (_currentEngine.getEngineStatus().getRunningStatus().equals(RunStatus.WaitingLogicalStepSelection)) {
				StructuredSelection s = (StructuredSelection)event.getSelection();
				ExecutionTraceModelWrapper wrapper = (ExecutionTraceModelWrapper)s.getFirstElement();
				_currentEngine.backToPast(wrapper.getChoice());				
			}
		}

	}

}