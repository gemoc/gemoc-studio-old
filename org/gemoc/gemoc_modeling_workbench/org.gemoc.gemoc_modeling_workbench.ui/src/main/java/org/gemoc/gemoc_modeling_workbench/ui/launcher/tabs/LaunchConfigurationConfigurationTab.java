package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.NumberFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.gemoc.execution.engine.core.RunConfiguration;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

public class LaunchConfigurationConfigurationTab extends LaunchConfigurationTab 
{

	protected Button _activeTraceCheckbox;
	protected FormattedText _deadlockDetectionDepth;

	
	@Override
	public void createControl(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group motorArea = createGroup(area, "Motor configuration:");
		createMotorLayout(motorArea, null);
	}

	private void createMotorLayout(Group parent, Font font) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		_activeTraceCheckbox = new Button(composite, SWT.CHECK);
		_activeTraceCheckbox.setText("Active trace");
		_activeTraceCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
		gd.widthHint = 200;
		
		createTextLabelLayout(parent, "Deadlock detection depth");
		Text underlyingText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		underlyingText.setLayoutData(gd);
		underlyingText.setFont(font);
		underlyingText.addModifyListener(fBasicModifyListener);
		_deadlockDetectionDepth = new FormattedText(underlyingText);
		_deadlockDetectionDepth.setFormatter(new NumberFormatter("#####"));

	}

	/**
	 * Basic modify listener that can be reused if there is no more precise need
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent arg0) {
			updateLaunchConfigurationDialog();
		}
	};
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ACTIVE_TRACE,
				true);
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DEADLOCK_DETECTION_DEPTH,
				10);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try 
		{
			RunConfiguration runConfiguration = new RunConfiguration(configuration);
			_activeTraceCheckbox.setSelection(runConfiguration.isTraceActive());
			_deadlockDetectionDepth.setValue(runConfiguration.getDeadlockDetectionDepth());		
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ACTIVE_TRACE,
				_activeTraceCheckbox.getSelection());
		int depth = _deadlockDetectionDepth.getValue() == null ? 0 : Integer.valueOf(_deadlockDetectionDepth.getValue().toString());
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DEADLOCK_DETECTION_DEPTH,
				depth);

	}

	@Override
	public String getName() {
		return "Configuration";
	}


	
}
