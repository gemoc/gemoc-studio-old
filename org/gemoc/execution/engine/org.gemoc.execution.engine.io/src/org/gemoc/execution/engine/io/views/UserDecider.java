package org.gemoc.execution.engine.io.views;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

public class UserDecider implements ILogicalStepDecider {

	boolean isStepByStep = false;
	
	public UserDecider(boolean isStepByStep) {
		super();
		this.isStepByStep = isStepByStep;
	}

	private Semaphore _semaphore = null;

	@Override
	public int decide(final List<LogicalStep> possibleLogicalSteps)
			throws InterruptedException {
		_semaphore = new Semaphore(0);
		if(!isStepByStep && possibleLogicalSteps.size() == 1) return 0;
		retreiveDecisionView();
		// add action into view menu
		IMenuListener menuListener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				// EnginesStatusView.this.fillContextMenu(manager);
				if (possibleLogicalSteps.contains(decisionView
						.getSelectedLogicalStep())) {
					Action selectLogicalStepAction = new Action() {
						public void run() {

							_semaphore.release();
							// decisionView.showMessage("TODO notify engine that we have selected this logicalStep");
						}
					};
					selectLogicalStepAction.setText("Select LogicalStep");
					selectLogicalStepAction
							.setToolTipText("Use selected LogicalStep");
					selectLogicalStepAction
							.setImageDescriptor(SharedIcons.LOGICALSTEP_ICON);
					manager.add(selectLogicalStepAction);
				}
			}
		};
		decisionView.menuMgr.addMenuListener(menuListener);
		
		// add action on double click
		IDoubleClickListener doubleClickListener = new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				if (possibleLogicalSteps.contains(decisionView
						.getSelectedLogicalStep())) {
					Action selectLogicalStepAction = new Action() {
						public void run() {
							_semaphore.release();
						}
					};
					selectLogicalStepAction.run();
				}
			}
		};
		decisionView.viewer.addDoubleClickListener(doubleClickListener);
		
		
		// wait for user selection if it applies to this engine
		_semaphore.acquire();
		_semaphore = null;
		// clean menu listener
		decisionView.menuMgr.removeMenuListener(menuListener);
		decisionView.viewer.removeDoubleClickListener(doubleClickListener);
		return possibleLogicalSteps.indexOf(decisionView
				.getSelectedLogicalStep());

	}

	EnginesStatusView decisionView;

	private void retreiveDecisionView() {

		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				try {

					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView(EnginesStatusView.ID);
					decisionView = (EnginesStatusView) PlatformUI
							.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().findView(EnginesStatusView.ID);
				} catch (PartInitException e) {
					Activator.getDefault().error(e.getMessage(), e);
				}
			}

		});

	}

	@Override
	public void dispose() {
		if (_semaphore != null)
			_semaphore.release();
	}

	@Override
	public void preempt() {
		if (_semaphore != null)
			_semaphore.release();
	}
}
