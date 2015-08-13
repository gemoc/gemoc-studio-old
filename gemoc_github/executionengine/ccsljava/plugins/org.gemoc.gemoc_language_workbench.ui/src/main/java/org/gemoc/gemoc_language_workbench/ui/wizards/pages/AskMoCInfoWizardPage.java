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

public class AskMoCInfoWizardPage extends WizardPage {

	// initial value stores
    public String initialTemplateMoCFileFieldValue = "my";
    
	// widgets
    Text templateMoCFileField;

    // constants
    protected static final int SIZING_TEXT_FIELD_WIDTH = 250;
    
    private Listener genericModifyListener = new Listener() {
        public void handleEvent(Event e) {
        	//setLocationForSelection();
            boolean valid = validatePage();
            setPageComplete(valid);
                
        }
    };
	
	public AskMoCInfoWizardPage(String pageName) {
		super(pageName);
	}

	
	/** (non-Javadoc)
     * Method declared on IDialogPage.
     */
    public void createControl(Composite parent) {
    	
    	Composite composite = new Composite(parent, SWT.NULL);
    	composite.setLayout(new GridLayout());
    	composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    
    	createTemplateMoCFileGroup(composite);
    	
	
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
    private final void createTemplateMoCFileGroup(Composite parent) {
        // project specification group
        Composite templateMoCFileGroup = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        templateMoCFileGroup.setLayout(layout);
        templateMoCFileGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // root container label
        Label label = new Label(templateMoCFileGroup, SWT.NONE);
        label.setText("new MoCC file base name");
        label.setFont(parent.getFont());

        // new project name entry field
        templateMoCFileField = new Text(templateMoCFileGroup, SWT.BORDER);
        GridData data = new GridData(GridData.FILL_HORIZONTAL);
        data.widthHint = SIZING_TEXT_FIELD_WIDTH;
        templateMoCFileField.setLayoutData(data);
        templateMoCFileField.setFont(parent.getFont());

        // Set the initial value first before listener
        // to avoid handling an event during the creation.
        if (initialTemplateMoCFileFieldValue != null) {
        	templateMoCFileField.setText(initialTemplateMoCFileFieldValue);
		}
        templateMoCFileField.addListener(SWT.Modify, genericModifyListener);
        BidiUtils.applyBidiProcessing(templateMoCFileField, BidiUtils.BTD_DEFAULT);
                
    }
    
   
    public String getTemplateMoCFileNameFile(){
    	return templateMoCFileField.getText();
    }
    
    protected boolean validatePage() {
    	boolean result = true;//
    	if(result){
    		// TODO check that the rootModelelement exists in the ecore file
    	}
    	return result;
    }
}
