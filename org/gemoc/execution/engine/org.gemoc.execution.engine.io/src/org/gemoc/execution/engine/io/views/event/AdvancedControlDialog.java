package org.gemoc.execution.engine.io.views.event;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AdvancedControlDialog extends TitleAreaDialog{

	private FormattedText _startTxt;
	@SuppressWarnings("unused")
	private FormattedText _delayTxt;
	@SuppressWarnings("unused")
	private FormattedText _durationTxt;


	public AdvancedControlDialog(Shell parentShell) {

		super(parentShell);
	}

	@Override
	public void create() {

		super.create();
		setTitle("Advanced Control Panel");
		//setMessage("The clocks can be forced in the future", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.BORDER);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);

		/*
		createStart(container);
		createDelay(container);
		createDuration(container);
		createState(container);
		 */
		
		Label desole = new Label(container, SWT.NONE);
		desole.setText("Coming Soon ...");
		
		return area;
	}
	@SuppressWarnings("unused")
	private void createStart(Composite container) {
		Label lblStart = new Label(container, SWT.NONE);
		lblStart.setText("Start");
		lblStart.setToolTipText("Set the step when the forcing event will occur"
				+"\nMust be superior or egal to the current engine step");

		GridData dataStart = new GridData();
		dataStart.grabExcessHorizontalSpace = true;
		dataStart.horizontalAlignment = GridData.FILL;
		_startTxt = new FormattedText(container, SWT.BORDER);
		_startTxt.setFormatter(new org.eclipse.nebula.widgets.formattedtext.NumberFormatter("###,##0"));
	}

	@SuppressWarnings("unused")
	private void createDelay(Composite container) {

		Label lbtLastName = new Label(container, SWT.NONE);
		lbtLastName.setText("Last Name");

		GridData dataLastName = new GridData();
		dataLastName.grabExcessHorizontalSpace = true;
		dataLastName.horizontalAlignment = GridData.FILL;
		//	    lastNameText = new Text(container, SWT.BORDER);
		//	    lastNameText.setLayoutData(dataLastName);
	}

	@SuppressWarnings("unused")
	private void createState(Composite container) {

		// TODO Auto-generated method stub

	}
	@SuppressWarnings("unused")
	private void createDuration(Composite container) {

		// TODO Auto-generated method stub

	}


	@Override
	protected boolean isResizable() {

		return true;
	}

	// save content of the Text fields because they get disposed
	// as soon as the Dialog closes
	private void saveInput() {

		//	    firstName = txtFirstName.getText();
		//	    lastName = lastNameText.getText();

	}

	@Override
	protected void okPressed() {

		saveInput();
		super.okPressed();
	}

	public String getFirstName() {

		return "";
	}

	public String getLastName() {

		return "";
	}

}
