package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class GemocModelLauncherMainTab extends AbstractLaunchConfigurationTab {


	protected Text modelLocationText;
	protected Combo languageCombo;

	protected Text metamodelLocationText;
	protected Text ccslLocationText;
	private Text jarFolderLocationText;
	private Text k2MainOperationText;
	private Text k2ProjectNameText;
	private Text k2PortText;
	
	public int GRID_DEFAULT_WIDTH = 200;
	
	
	@Override
	public void createControl(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group modelArea = new Group(area, SWT.NULL);
		modelArea.setText("Model:");
		modelArea.setLayout(new FillLayout());
		// Create the area for the filename to get
		createModelLayout(modelArea, null);
		
		Group languageArea = new Group(area, SWT.NULL);
		languageArea.setText("Language:");
		languageArea.setLayout(new FillLayout());
		createLanguageLayout(languageArea, null);
		
		Group prototypeArea = new Group(area, SWT.NULL);
		prototypeArea.setText("Gemoc Engine Prototype parameters (these info will probably be removed in future version):");
		prototypeArea.setLayout(new FillLayout());
		createPrototypeLayout(prototypeArea, null);

		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.LAUNCH_MODEL_PATH,
				this.modelLocationText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE,
				this.languageCombo.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.LAUNCH_MM_PATH,
				this.metamodelLocationText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.LAUNCH_CCSL_FILE_PATH,
				this.ccslLocationText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.LAUNCH_JARS_FOLDER_PATH,
				this.jarFolderLocationText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.KM_LAUNCH_MAIN_OPERATION,
				this.k2MainOperationText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.KM_LAUNCH_PROJECT,
				this.k2ProjectNameText.getText());
		configuration.setAttribute(
				GemocModelLauncherConfigurationConstants.KM_LAUNCH_PORT,
				this.k2PortText.getText());
	}

	@Override
	public String getName() {
		return "Main";
	}
	
	
	// -----------------------------------
	
	/** Basic modify listener that can be reused if there is no more precise need */
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

		// Project location text
		modelLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		modelLocationText.setLayoutData(gd);
		modelLocationText.setFont(font);
		modelLocationText.addModifyListener(fBasicModifyListener);
		Button projectLocationButton = createPushButton(parent, "Browse", null);
		projectLocationButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				//handleModelLocationButtonSelected();
				// TODO launch the appropriate selector
				MessageDialog.openWarning(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"Browse model to execute",
						"Action not implemented yet");
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
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.horizontalSpan = 1;
		gd.widthHint = GRID_DEFAULT_WIDTH;
		// Create the project selector button

		languageCombo = new Combo (parent, SWT.NONE);
		languageCombo.setItems (new String [] {"", "sampleLanguage"});
		languageCombo.addModifyListener(fBasicModifyListener);
		/*languageCombo.addListener (SWT.DefaultSelection, new Listener () {
			public void handleEvent (Event e) {
				//System.out.println (e.widget + " - Default Selection");
				
				updateLaunchConfigurationDialog();
			}
		});*/
		
		// button to deal with dynamic language creation and provisionning		
		Button projectLocationButton = createPushButton(parent, "Dynamic Language Variants...", null);
		projectLocationButton.setEnabled(false);
		projectLocationButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				//handleModelLocationButtonSelected();
				// TODO launch the appropriate selector
				MessageDialog.openWarning(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"Dynamic Language Variants",
						"Action not implemented yet");
				updateLaunchConfigurationDialog();
			}
		});
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
		
		createTextLabelLayout(parent, "Metamodel path (*.ecore)");
		
		// metamodel location text
		metamodelLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		metamodelLocationText.setLayoutData(gd);
		metamodelLocationText.setFont(font);
		metamodelLocationText.addModifyListener(fBasicModifyListener);
		
		// --------------
		createTextLabelLayout(parent, "CCSL File");
		// metamodel location text
		ccslLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		ccslLocationText.setLayoutData(gd);
		ccslLocationText.setFont(font);
		ccslLocationText.addModifyListener(fBasicModifyListener);
		
		// --------------
		createTextLabelLayout(parent, "jar folder");
		jarFolderLocationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		jarFolderLocationText.setLayoutData(gd);
		jarFolderLocationText.setFont(font);
		jarFolderLocationText.addModifyListener(fBasicModifyListener);
		
		createSeparator(parent, 2);
		
		// --------------
		createTextLabelLayout(parent, "Kermeta 2 main operation");
		k2MainOperationText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		k2MainOperationText.setLayoutData(gd);
		k2MainOperationText.setFont(font);
		k2MainOperationText.addModifyListener(fBasicModifyListener);

		// --------------
		createTextLabelLayout(parent, "Kermeta 2 project name");
		k2ProjectNameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		k2ProjectNameText.setLayoutData(gd);
		k2ProjectNameText.setFont(font);
		k2ProjectNameText.addModifyListener(fBasicModifyListener);

		
		// --------------
		createTextLabelLayout(parent, "Kermeta 2 port");
		k2PortText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		k2PortText.setLayoutData(gd);
		k2PortText.setFont(font);
		k2PortText.addModifyListener(fBasicModifyListener);
		
		
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
	public void createTextLabelLayout(Composite parent, String labelString) {
		GridLayout locationLayout = new GridLayout();
		locationLayout.numColumns = 2;
		locationLayout.marginHeight = 10;
		locationLayout.marginWidth = 10;
		parent.setLayout(locationLayout);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		parent.setLayoutData(gd);
		// parent.setFont(null);

		Label inputLabel = new Label(parent, SWT.NONE);
		inputLabel.setText(labelString); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalSpan = 2;
		inputLabel.setLayoutData(gd);
	}

}
