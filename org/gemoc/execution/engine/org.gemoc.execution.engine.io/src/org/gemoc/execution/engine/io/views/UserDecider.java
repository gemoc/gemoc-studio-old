package org.gemoc.execution.engine.io.views;

import java.util.List;
import java.util.concurrent.Semaphore;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

public class UserDecider implements ILogicalStepDecider {

	public UserDecider() {
		super();
	}

	Semaphore semaphore = new Semaphore(0);

	@Override
	public int decide(final List<LogicalStep> possibleLogicalSteps)
			throws InterruptedException {
		retreiveDecisionView();
		// add action into view menu
		IMenuListener menuListener = new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				// EnginesStatusView.this.fillContextMenu(manager);
				if (possibleLogicalSteps.contains(decisionView
						.getSelectedLogicalStep())) {
					Action selectLogicalStepAction = new Action() {
						public void run() {

							semaphore.release();
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
		// wait for user selection if it applies to this engine
		semaphore.acquire();
		// clean menu listener
		decisionView.menuMgr.removeMenuListener(menuListener);
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
					Activator.eclipseError(e.getMessage(), e);
				}
			}

		});

	}

	@Override
	public void dispose() {
		semaphore.release();
	}
}
