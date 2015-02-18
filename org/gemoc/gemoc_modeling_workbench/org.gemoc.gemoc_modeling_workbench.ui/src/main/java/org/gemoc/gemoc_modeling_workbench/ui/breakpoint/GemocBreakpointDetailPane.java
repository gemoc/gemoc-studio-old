package org.gemoc.gemoc_modeling_workbench.ui.breakpoint;

import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * Gemoc {@link IDetailPane} for breakpoints.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 *
 */
public class GemocBreakpointDetailPane implements IDetailPane {

	public final static String PANEL_TYPE = "org.gemoc.gemoc_modeling_workbench.ui.breakpoint.GemocPanelType";

	private Button logicalStepButton;

	private Button mseButton;

	private GemocBreakpoint breakpoint;

	@Override
	public void init(IWorkbenchPartSite partSite) {
		// nothing to do here
	}

	@Override
	public Control createControl(Composite parent) {
		logicalStepButton = new Button(parent, SWT.CHECK);
		logicalStepButton.setText("Break on logical step");
		logicalStepButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (breakpoint != null) {
					breakpoint.setBreakOnLogicalStep(logicalStepButton.getSelection());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (breakpoint != null) {
					breakpoint.setBreakOnLogicalStep(logicalStepButton.getSelection());
				}
			}
		});
		mseButton = new Button(parent, SWT.CHECK);
		mseButton.setText("Break on MSE");
		mseButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (breakpoint != null) {
					breakpoint.setBreakOnMSE(mseButton.getSelection());
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (breakpoint != null) {
					breakpoint.setBreakOnMSE(mseButton.getSelection());
				}
			}
		});
		return logicalStepButton;
	}

	@Override
	public void dispose() {
		logicalStepButton.dispose();
		mseButton.dispose();
	}

	@Override
	public void display(IStructuredSelection selection) {
		if (selection != null
				&& selection.getFirstElement() instanceof GemocBreakpoint) {
			breakpoint = (GemocBreakpoint) selection.getFirstElement();
			logicalStepButton.setSelection(breakpoint.getBreakOnLogicalStep());
			mseButton.setSelection(breakpoint.getBreakOnMSE());
			logicalStepButton.setVisible(true);
			mseButton.setVisible(true);
		} else {
			breakpoint = null;
			logicalStepButton.setVisible(false);
			mseButton.setVisible(false);
		}
	}

	@Override
	public boolean setFocus() {
		return false;
	}

	@Override
	public String getID() {
		return PANEL_TYPE;
	}

	@Override
	public String getName() {
		return "Gemoc breakpoint settings";
	}

	@Override
	public String getDescription() {
		return getName();
	}

}
