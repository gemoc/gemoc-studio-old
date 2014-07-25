package org.gemoc.gemoc_modeling_workbench.ui.launcher.tabs;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.core.RunConfiguration;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtensionPoint;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAIRDIFileDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyIFileDialog;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;

import fr.obeo.dsl.debug.ide.launch.AbstractDSLLaunchConfigurationDelegate;
import fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI;

public class GemocModelLauncherMainTab extends HelpfulModelLauncherMainTab {

	protected Text _modelLocationText;
	protected Text _siriusRepresentationLocationText;
	protected Button _animateButton;
	protected Text _delayText;
	protected Combo _languageCombo;
	protected Combo _deciderCombo;
	protected Button _activeTraceCheckbox;

	protected FormattedText _deadlockDetectionDepth;
	protected Text modelofexecutionglml_LocationText;

	public int GRID_DEFAULT_WIDTH = 200;

	@Override
	public void createControl(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group modelArea = createGroup(area, "Model:");
		createModelLayout(modelArea, null);

		Group languageArea = createGroup(area, "Language:");
		createLanguageLayout(languageArea, null);

		Group prototypeArea = createGroup(area, "Engine Prototype parameters (these info will probably be removed in future version):");
		createPrototypeLayout(prototypeArea, null);
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ANIMATE,
				false);
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DELAY,
				1000);
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ACTIVE_TRACE,
				true);
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DEADLOCK_DETECTION_DEPTH,
				10);
		configuration.setAttribute(
				RunConfiguration.LAUNCH_SELECTED_DECIDER,
				RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) 
	{
		try 
		{
			RunConfiguration runConfiguration = new RunConfiguration(configuration);
			_modelLocationText.setText(runConfiguration.getModelURIAsString());
			if (runConfiguration.getAnimatorURIAsString() != null)
				_siriusRepresentationLocationText.setText(runConfiguration.getAnimatorURIAsString());
			else
				_siriusRepresentationLocationText.setText("");
			_animateButton.setSelection(runConfiguration.isAnimationActive());
			_delayText.setText(Integer.toString(runConfiguration.getAnimationDelay()));
			_activeTraceCheckbox.setSelection(runConfiguration.isTraceActive());
			_languageCombo.setText(runConfiguration.getLanguageName());
			_deciderCombo.setText(runConfiguration.getDeciderName());
			_deadlockDetectionDepth.setValue(runConfiguration.getDeadlockDetectionDepth());		
		} catch (CoreException e) {
			Activator.error(e.getMessage(), e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) 
	{
		configuration.setAttribute(
				AbstractDSLLaunchConfigurationDelegate.RESOURCE_URI,
				this._modelLocationText.getText());
		configuration.setAttribute(
				AbstractDSLLaunchConfigurationDelegateUI.SIRIUS_RESOURCE_URI,
				this._siriusRepresentationLocationText.getText());
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ANIMATE,
				_animateButton.getSelection());
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DELAY,
				Integer.parseInt(_delayText.getText()));
		configuration.setAttribute(
				RunConfiguration.LAUNCH_ACTIVE_TRACE,
				_activeTraceCheckbox.getSelection());
		configuration.setAttribute(
						RunConfiguration.LAUNCH_SELECTED_LANGUAGE,
						this._languageCombo.getText());
		configuration.setAttribute(
						RunConfiguration.LAUNCH_SELECTED_DECIDER,
						this._deciderCombo.getText());
		int depth = _deadlockDetectionDepth.getValue() == null ? 0 : Integer.valueOf(_deadlockDetectionDepth.getValue().toString());
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DEADLOCK_DETECTION_DEPTH,
				depth);
		configuration.setAttribute(
						RunConfiguration.LAUNCH_MODELOFEXECUTION_GLML_PATH,
						this.modelofexecutionglml_LocationText.getText());
	}

	@Override
	public String getName() {
		return "Main";
	}

	// -----------------------------------

	/**
	 * Basic modify listener that can be reused if there is no more precise need
	 */
	private ModifyListener fBasicModifyListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent arg0) {
			updateLaunchConfigurationDialog();
		}
	};

	// -----------------------------------

	/***
	 * Create the Field where user enters model to execute
	 * 
	 * @param parent
	 * @param font
	 * @return
	 */
	public Composite createModelLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "Model to execute");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
		gd.widthHint = GRID_DEFAULT_WIDTH;
		// Create the project selector button

		// Model location text
		_modelLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_modelLocationText.setLayoutData(gd);
		_modelLocationText.setFont(font);
		_modelLocationText.addModifyListener(fBasicModifyListener);
		Button modelLocationButton = createPushButton(parent, "Browse", null);
		modelLocationButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				// handleModelLocationButtonSelected();
				// TODO launch the appropriate selector

				SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
				if (dialog.open() == Dialog.OK) {
					String modelPath = ((IResource) dialog.getResult()[0])
							.getFullPath().toPortableString();
					_modelLocationText.setText(modelPath);
					updateLaunchConfigurationDialog();
				}
			}
		});
		// return parent;

		createTextLabelLayout(parent, "Sirius representation");
		// GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
		// gd.widthHint = GRID_DEFAULT_WIDTH;
		// Create the project selector button
		// Animation view location text
		_siriusRepresentationLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_siriusRepresentationLocationText.setLayoutData(gd);
		_siriusRepresentationLocationText.setFont(font);
		_siriusRepresentationLocationText.addModifyListener(fBasicModifyListener);
		Button siriusRepresentationLocationButton = createPushButton(parent,
				"Browse", null);
		siriusRepresentationLocationButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						// handleModelLocationButtonSelected();
						// TODO launch the appropriate selector

						SelectAIRDIFileDialog dialog = new SelectAIRDIFileDialog();
						if (dialog.open() == Dialog.OK) {
							String modelPath = ((IResource) dialog.getResult()[0])
									.getFullPath().toPortableString();
							_siriusRepresentationLocationText.setText(modelPath);
							updateLaunchConfigurationDialog();
						}
					}
				});
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));
		
		_animateButton = new Button(composite, SWT.CHECK);
		_animateButton.setText("animate");
		_animateButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		
		_delayText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		_delayText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		new Label(composite, SWT.BORDER).setText("delay in millisecond");

		_activeTraceCheckbox = new Button(composite, SWT.CHECK);
		_activeTraceCheckbox.setText("Active trace");
		_activeTraceCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfigurationDialog();
			}
		});

		
		return parent;
	}

	/***
	 * Create the Field where user enters the language used to execute
	 * 
	 * @param parent
	 * @param font
	 * @return
	 */
	public Composite createLanguageLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "xDSML");
//		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
//		gd.widthHint = GRID_DEFAULT_WIDTH;
		// Create the project selector button

		_languageCombo = new Combo(parent, SWT.NONE);

		ArrayList<String> xdsmlNames = new ArrayList<String>();
		IConfigurationElement[] confElements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT);
		for (int i = 0; i < confElements.length; i++) {
			xdsmlNames.add(confElements[i].getAttribute("name"));
		}
		if (confElements.length == 0) {
			xdsmlNames.add("<No xdml available>");
		}
		String[] empty = {};
		_languageCombo.setItems(xdsmlNames.toArray(empty));
		_languageCombo.addModifyListener(fBasicModifyListener);
		/*
		 * languageCombo.addListener (SWT.DefaultSelection, new Listener () {
		 * public void handleEvent (Event e) { //System.out.println (e.widget +
		 * " - Default Selection");
		 * 
		 * updateLaunchConfigurationDialog(); } });
		 */

		// button to deal with dynamic language creation and provisionning
		Button projectLocationButton = createPushButton(parent,
				"Dynamic Language Variants...", null);
		projectLocationButton.setEnabled(false);
		projectLocationButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				// handleModelLocationButtonSelected();
				// TODO launch the appropriate selector
				MessageDialog.openWarning(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(),
						"Dynamic Language Variants",
						"Action not implemented yet");
				updateLaunchConfigurationDialog();
			}
		});

		_deciderCombo = new Combo(parent, SWT.NONE);
		String[] deciderChoice = {
				RunConfiguration.DECIDER_SOLVER_PROPOSITION,
				RunConfiguration.DECIDER_RANDOM,
				RunConfiguration.DECIDER_ASKUSER,
				RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP };
		_deciderCombo.setItems(deciderChoice);
		_deciderCombo.select(0);
		_deciderCombo.addModifyListener(fBasicModifyListener);

		return parent;
	}

	/***
	 * Create the Field where user enters model to execute
	 * 
	 * @param parent
	 * @param font
	 * @return
	 */
	public Composite createPrototypeLayout(Composite parent, Font font) {

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
		gd.widthHint = GRID_DEFAULT_WIDTH;

		// --------------
		createTextLabelLayout(parent, "used defined ModelOfExecution glml File");
		modelofexecutionglml_LocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		modelofexecutionglml_LocationText.setLayoutData(gd);
		modelofexecutionglml_LocationText.setFont(font);
		modelofexecutionglml_LocationText.addModifyListener(fBasicModifyListener);

		createTextLabelLayout(parent, "Deadlock detection depth");
		Text underlyingText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		underlyingText.setLayoutData(gd);
		underlyingText.setFont(font);
		underlyingText.addModifyListener(fBasicModifyListener);
		_deadlockDetectionDepth = new FormattedText(underlyingText);
		_deadlockDetectionDepth.setFormatter(new NumberFormatter("#####"));

		return parent;
	}

	// -----------------------------------

	/**
	 * 
	 * @param parent
	 *            the Parent of this argument tab
	 * @param labelString
	 *            the label of the input text to create
	 * @param adapter
	 *            the event that is triggered when clicking on OK button
	 */
	private void createTextLabelLayout(Composite parent, String labelString) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		parent.setLayoutData(gd);
		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText(labelString); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalSpan = 2;
		inputLabel.setLayoutData(gd);
	}
}
