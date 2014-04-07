package org.gemoc.execution.engine.io.views;


import java.util.ArrayList;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.gemoc_commons.ui.ViewHelper;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import GemocExecutionEngineTrace.Choice;
import GemocExecutionEngineTrace.GemocExecutionEngineTraceFactory;

/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class ExecutionTraceView extends ViewPart implements IMotorSelectionListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.gemoc.execution.engine.io.views.ExecutionTraceView";

	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
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
					GemocExecutionEngine engine = (GemocExecutionEngine)parent;
					if (engine.getFirstChoice() != null) {
						Choice currentChoice = engine.getFirstChoice();
						while(currentChoice != null) {
							ExecutionTraceModelWrapper wrapper = new ExecutionTraceModelWrapper(currentChoice);
							int chosenLogicalStepIndex = wrapper.getChosenLogicalStepIndex();
							if (chosenLogicalStepIndex > greatestChosenLogicalStepIndex)
								greatestChosenLogicalStepIndex = chosenLogicalStepIndex;
							result.add(wrapper);
							currentChoice = currentChoice.getNextChoice();
						}
					}
				} 
			}
			for(ExecutionTraceModelWrapper wrapper : result) {
				int chosenLogicalStepIndex = wrapper.getChosenLogicalStepIndex();
				int leftBlankNumber = greatestChosenLogicalStepIndex - chosenLogicalStepIndex;
				wrapper.setLeftBlankCounter(leftBlankNumber);				
			}
			return result.toArray();
		}
	}

	 class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return "";
		}
		public Image getColumnImage(Object obj, int index) {
			if (obj instanceof ExecutionTraceModelWrapper) {
				return ((ExecutionTraceModelWrapper)obj).getColumnImage(index);
			}
			return null;
			
			
//			if (obj instanceof Choice) {
//				Choice choice = (Choice)obj;
//				int choiceIndex = choice.getPossibleLogicalSteps().indexOf(choice.getChosenLogicalStep());
//				if (choiceIndex == index)
//					return SharedIcons.getSharedImage(SharedIcons.CHOSEN_LOGICALSTEP_ICON);		
//				else if (index < choice.getPossibleLogicalSteps().size())
//					return SharedIcons.getSharedImage(SharedIcons.POSSIBLE_LOGICALSTEP_ICON);
//			}
//						return null;
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ExecutionTraceView() {
	}

	
	private EnginesStatusView _enginesStatusView; 
	
	private Composite _parent;
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		_parent = parent;
		createTableViewer(null);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.gemoc.execution.engine.io.viewer");
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
		
		// get the motor view to listen to motor selection
		startListeningToMotorSelectionChange();
		
	}

	private void createTableViewer(GemocExecutionEngine executionEngine) {
		viewer = new TableViewer(_parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		createColumns();
		viewer.setContentProvider(new ViewContentProvider());	
		viewer.setLabelProvider(new ViewLabelProvider());
		//viewer.setSorter(new NameSorter());
		viewer.setInput(executionEngine);
	}

	  private void createColumns() {
		  for(Integer i = 0; i < 10; i++) {
			  TableViewerColumn col = createTableViewerColumn(i.toString(), 50, 0);
			    col.setLabelProvider(new ColumnLabelProvider() {
			      @Override
			      public String getText(Object element) {
			    	  String result = null;
			    	  if (element instanceof Choice) {
			    		  result = ((Choice) element).toString();
			    	  }
			    	  return result;
			      }
			    });			
		  }
	  }
	
	  private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		    final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
		        SWT.NONE);
		    final TableColumn column = viewerColumn.getColumn();
		    column.setText(title);
		    column.setWidth(bound);
		    column.setResizable(true);
		    column.setMoveable(true);
		    return viewerColumn;
	  }
//	private void hookContextMenu() {
//		MenuManager menuMgr = new MenuManager("#PopupMenu");
//		menuMgr.setRemoveAllWhenShown(true);
//		menuMgr.addMenuListener(new IMenuListener() {
//			public void menuAboutToShow(IMenuManager manager) {
//				ExecutionTraceView.this.fillContextMenu(manager);
//			}
//		});
//		Menu menu = menuMgr.createContextMenu(viewer.getControl());
//		viewer.getControl().setMenu(menu);
//		getSite().registerContextMenu(menuMgr, viewer);
//	}
//
//	private void contributeToActionBars() {
//		IActionBars bars = getViewSite().getActionBars();
//		fillLocalPullDown(bars.getMenuManager());
//		fillLocalToolBar(bars.getToolBarManager());
//	}
//
//	private void fillLocalPullDown(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(new Separator());
//		manager.add(action2);
//	}
//
//	private void fillContextMenu(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//		// Other plug-ins can contribute there actions here
//		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
//	}
//	
//	private void fillLocalToolBar(IToolBarManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//	}
//
//	private void makeActions() {
//		action1 = new Action() {
//			public void run() {
//				showMessage("Action 1 executed");
//			}
//		};
//		action1.setText("Action 1");
//		action1.setToolTipText("Action 1 tooltip");
//		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		
//		action2 = new Action() {
//			public void run() {
//				showMessage("Action 2 executed");
//			}
//		};
//		action2.setText("Action 2");
//		action2.setToolTipText("Action 2 tooltip");
//		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		doubleClickAction = new Action() {
//			public void run() {
//				ISelection selection = viewer.getSelection();
//				Object obj = ((IStructuredSelection)selection).getFirstElement();
//				showMessage("Double-click detected on "+obj.toString());
//			}
//		};
//	}
//
//	private void hookDoubleClickAction() {
//		viewer.addDoubleClickListener(new IDoubleClickListener() {
//			public void doubleClick(DoubleClickEvent event) {
//				doubleClickAction.run();
//			}
//		});
//	}
//	private void showMessage(String message) {
//		MessageDialog.openInformation(
//			viewer.getControl().getShell(),
//			"Gemoc Execution Trace",
//			message);
//	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private void startListeningToMotorSelectionChange() {
		_enginesStatusView = ViewHelper.retrieveView(EnginesStatusView.ID);
		if (_enginesStatusView!= null) 
		{
			_enginesStatusView.addMotorSelectionListener(this);
		}
	}
	
	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView!= null) 
		{
			_enginesStatusView.removeMotorSelectionListener(this);
		}
	}

	
	private GemocExecutionEngine _currentEngine;
	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if(engine != null
			&& engine != _currentEngine) {
			_currentEngine = engine;
			viewer.setInput(null);
			viewer.setInput(_currentEngine);		
		} else {
			viewer.refresh();
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		_currentEngine = null;
		stopListeningToMotorSelectionChange();
	}

}