package org.gemoc.gemoc_language_workbench.ui.wizards.pages;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.util.BidiUtils;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IIDEHelpContextIds;
import org.eclipse.ui.internal.ide.dialogs.ProjectContentsLocationArea;
import org.gemoc.commons.eclipse.ui.dialogs.SelectAnyIFileDialog;
import org.gemoc.gemoc_language_workbench.ui.activeFile.ActiveFile;
import org.gemoc.gemoc_language_workbench.ui.commands.ENamedElementQualifiedNameLabelProvider;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyConcreteEClassDialog;
import org.gemoc.gemoc_language_workbench.ui.dialogs.SelectAnyEObjectDialog;

public class AskDSEInfoWizardPage extends WizardPage {

	// initial value stores
    public String initialTemplateECLFileFieldValue = "my";
    public String initialEcoreFileFieldValue;
    public String initialRootContainerFieldValue;
    
	// widgets
    Text templateECLFileField;
    Text ecoreFileField;
    Text rootContainerField;
    
    // constants
    protected static final int SIZING_TEXT_FIELD_WIDTH = 250;
    
    private Listener genericModifyListener = new Listener() {
        public void handleEvent(Event e) {
        	//setLocationForSelection();
            boolean valid = validatePage();
            setPageComplete(valid);
                
        }
    };
	
	public AskDSEInfoWizardPage(String pageName) {
		super(pageName);
	}

	
	/** (non-Javadoc)
     * Method declared on IDialogPage.
     */
    public void createControl(Composite parent) {
    	
    	Composite composite = new Composite(parent, SWT.NULL);
    	composite.setLayout(new GridLayout());
    	composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    	
    	createEcoreFileGroup(composite);
    	createRootContainerGroup(composite);
    	createTemplateECLFileGroup(composite);
    	
	
 //       setPageComplete(validatePage());
        // Show description on opening
//        setErrorMessage(null);
//        setMessage(null);
        setControl(composite);
        Dialog.applyDialogFont(composite);
    }
    
    /**
     * @param parent the parent composite
     */
    private final void createTemplateECLFileGroup(Composite parent) {
        // project specification group
        Composite templateECLFileGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        templateECLFileGroup.setLayout(layout);
        templateECLFileGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // root container label
        Label label = new Label(templateECLFileGroup, SWT.NONE);
        label.setText("new ECL file base name");
        label.setFont(parent.getFont());

        // new project name entry field
        templateECLFileField = new Text(templateECLFileGroup, SWT.BORDER);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        templateECLFileField.setLayoutData(data);
        templateECLFileField.setFont(parent.getFont());

        // Set the initial value first before listener
        // to avoid handling an event during the creation.
        if (initialTemplateECLFileFieldValue != null) {
        	templateECLFileField.setText(initialTemplateECLFileFieldValue);
		}
        templateECLFileField.addListener(SWT.Modify, genericModifyListener);
        BidiUtils.applyBidiProcessing(templateECLFileField, BidiUtils.BTD_DEFAULT);
                
    }
    
    /**
     * @param parent the parent composite
     */
    private final void createEcoreFileGroup(Composite parent) {
        // project specification group
        Composite ecoreFileGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        ecoreFileGroup.setLayout(layout);
        ecoreFileGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // root container label
        Label ecoreFileLabel = new Label(ecoreFileGroup, SWT.NONE);
        ecoreFileLabel.setText("Ecore file");
        ecoreFileLabel.setFont(parent.getFont());

        // new project name entry field
        ecoreFileField = new Text(ecoreFileGroup, SWT.BORDER);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        ecoreFileField.setLayoutData(data);
        ecoreFileField.setFont(parent.getFont());

        // Set the initial value first before listener
        // to avoid handling an event during the creation.
        if (initialEcoreFileFieldValue != null) {
        	ecoreFileField.setText(initialEcoreFileFieldValue);
		}
        ecoreFileField.addListener(SWT.Modify, genericModifyListener);
        BidiUtils.applyBidiProcessing(ecoreFileField, BidiUtils.BTD_DEFAULT);
        
        Button btnBrowse = new Button(ecoreFileGroup,
				SWT.NONE);
		btnBrowse.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		btnBrowse.setBounds(0, 0, 75, 25);
		btnBrowse.setText("Browse");
		btnBrowse.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					
					SelectAnyIFileDialog dialog = new SelectAnyIFileDialog();
					dialog.setPattern("*.ecore");
					if (dialog.open() == Dialog.OK) {
						ecoreFileField.setText("platform:/resource"
								+ ((IResource) dialog.getResult()[0])
										.getFullPath().toString());
					}
					
					break;
				}
			}
		});
    }
    
    /**
     * @param parent the parent composite
     */
    private final void createRootContainerGroup(Composite parent) {
        // project specification group
        Composite rootContainerGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        rootContainerGroup.setLayout(layout);
        rootContainerGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // root container label
        Label rootContainerLabel = new Label(rootContainerGroup, SWT.NONE);
        rootContainerLabel.setText("Root container model element");
        rootContainerLabel.setFont(parent.getFont());

        // new project name entry field
        rootContainerField = new Text(rootContainerGroup, SWT.BORDER);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        rootContainerField.setLayoutData(data);
        rootContainerField.setFont(parent.getFont());

        // Set the initial value first before listener
        // to avoid handling an event during the creation.
        if (initialRootContainerFieldValue != null) {
        	rootContainerField.setText(initialRootContainerFieldValue);
		}
        rootContainerField.addListener(SWT.Modify, genericModifyListener);
        BidiUtils.applyBidiProcessing(rootContainerField, BidiUtils.BTD_DEFAULT);
        
        Button btSelectRootModelElement = new Button(rootContainerGroup,
				SWT.NONE);
		btSelectRootModelElement.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));
		btSelectRootModelElement.setBounds(0, 0, 75, 25);
		btSelectRootModelElement.setText("Select");
		btSelectRootModelElement.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					
					if (ecoreFileField.getText() != null && !ecoreFileField.getText().isEmpty()) {
						LabelProvider labelProvider = new ENamedElementQualifiedNameLabelProvider();
						ResourceSet resSet = new ResourceSetImpl();

						// get the resource
						Resource resource = resSet.getResource(URI
								.createURI(ecoreFileField.getText()), true);
						SelectAnyEObjectDialog dialog = new SelectAnyConcreteEClassDialog(
								PlatformUI.getWorkbench()
										.getActiveWorkbenchWindow().getShell(),
								resource, labelProvider);
						int res = dialog.open();
						if (res == WizardDialog.OK) {
							// update the field
							rootContainerField.setText(labelProvider
									.getText(dialog.getFirstResult()));
						}
					}
					break;
				}
			}
		});
    }
    
    public String getRootContainerModelElement(){
    	return rootContainerField.getText();
    }
    public String getEcoreFile(){
    	return ecoreFileField.getText();
    }
    public String getTemplateECLFileNameFile(){
    	return templateECLFileField.getText();
    }
    
    protected boolean validatePage() {
    	boolean result = true;//
    	if(result){
    		// TODO check that the rootModelelement exists in the ecore file
    	}
    	return result;
    }
}
