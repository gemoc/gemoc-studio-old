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

public class LaunchConfigurationMainTab extends LaunchConfigurationTab {

	protected Text _modelLocationText;
	protected Text _siriusRepresentationLocationText;
	protected Button _animateButton;
	protected Text _delayText;
	protected Combo _languageCombo;
	protected Combo _deciderCombo;

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

		Group debugArea = createGroup(area, "Debug:");
		createDebugLayout(debugArea, null);
	}
	
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				RunConfiguration.LAUNCH_DELAY,
				1000);
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
			_delayText.setText(Integer.toString(runConfiguration.getAnimationDelay()));
			_languageCombo.setText(runConfiguration.getLanguageName());
			_deciderCombo.setText(runConfiguration.getDeciderName());
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
				RunConfiguration.LAUNCH_DELAY,
				Integer.parseInt(_delayText.getText()));
		configuration.setAttribute(
						RunConfiguration.LAUNCH_SELECTED_LANGUAGE,
						this._languageCombo.getText());
		configuration.setAttribute(
						RunConfiguration.LAUNCH_SELECTED_DECIDER,
						this._deciderCombo.getText());
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
		// Model location text
		_modelLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_modelLocationText.setLayoutData(createStandardLayout());
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
		return parent;
	}
	
	private Composite createDebugLayout(Composite parent, Font font) {
		createTextLabelLayout(parent, "Animator");

		_siriusRepresentationLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_siriusRepresentationLocationText.setLayoutData(createStandardLayout());
		_siriusRepresentationLocationText.setFont(font);
		_siriusRepresentationLocationText.addModifyListener(fBasicModifyListener);
		Button siriusRepresentationLocationButton = createPushButton(parent, "Browse", null);
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


		createTextLabelLayout(parent, "Delay");
		_delayText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		_delayText.setLayoutData(createStandardLayout());
		_delayText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}
		});
		createTextLabelLayout(parent, "(in milliseconds)");

		createTextLabelLayout(parent, "Decider");
		_deciderCombo = new Combo(parent, SWT.BORDER);
		_deciderCombo.setLayoutData(createStandardLayout());
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

	private GridData createStandardLayout() {
		return new GridData(SWT.FILL, SWT.CENTER, true, false);
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
		_languageCombo = new Combo(parent, SWT.NONE);
		_languageCombo.setLayoutData(createStandardLayout());
		
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
//		Button projectLocationButton = createPushButton(parent,
//				"Dynamic Language Variants...", null);
//		projectLocationButton.setEnabled(false);
//		projectLocationButton.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent evt) {
//				// handleModelLocationButtonSelected();
//				// TODO launch the appropriate selector
//				MessageDialog.openWarning(PlatformUI.getWorkbench()
//						.getActiveWorkbenchWindow().getShell(),
//						"Dynamic Language Variants",
//						"Action not implemented yet");
//				updateLaunchConfigurationDialog();
//			}
//		});
		return parent;
	}

}
