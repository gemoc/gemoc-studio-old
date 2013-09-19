package org.gemoc.gemoc_language_workbench.ui.wizards.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizardContextAction.CreateDomainModelAction;




/**
 * Select the concrete action that will be launched
 * optionnally ask for missing info not present in the context 
 * @author dvojtise
 *
 */
public class CreateDomainModelWizardPage  extends WizardPage {

	
	protected CreateDomainModelWizardContextAction context;
	
	private Composite 	container;
	
	public CreateDomainModelWizardPage(String pageName, CreateDomainModelWizardContextAction context) {
		super(pageName);
		this.setDescription("Select the wizard you wish to use to create a Domain Model project for your executable language.");
		this.setTitle(pageName);
		this.context = context;
	}

	@Override
	public void performHelp(){
		PlatformUI.getWorkbench().getHelpSystem().displayHelpResource("/org.gemoc.gemoc_language_workbench.documentation/html/ASProject.html");
	}

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.FILL);
		container.setLayout(new RowLayout (SWT.VERTICAL));
		/*Text 		txtProjectName;
		txtProjectName = new Text(container, SWT.BORDER);
		txtProjectName.setBounds(93, 7, 255, 21);
		txtProjectName.setText("Ceci est un essai");		
		*/
		Group actionSelection = new Group(container, SWT.FILL);
		actionSelection.setLayout (new RowLayout (SWT.VERTICAL));
		actionSelection.setText("Select action");
		//actionSelection.setBounds(10, 10, 193, 85);
	    
	    Button createEMFProject = new Button(actionSelection, SWT.RADIO);
	    createEMFProject.setText("Create new EMF project");
	    createEMFProject.setSelection(true);
	    createEMFProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDomainModelAction.CREATE_NEW_EMF_PROJECT;
			}
		});
	    Button selectExistingEMFProject = new Button(actionSelection, SWT.RADIO);
	    selectExistingEMFProject.setText("Select existing EMF project");  
	    selectExistingEMFProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDomainModelAction.SELECT_EXISTING_EMF_PROJECT;
			}
		}); 
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
	

}
