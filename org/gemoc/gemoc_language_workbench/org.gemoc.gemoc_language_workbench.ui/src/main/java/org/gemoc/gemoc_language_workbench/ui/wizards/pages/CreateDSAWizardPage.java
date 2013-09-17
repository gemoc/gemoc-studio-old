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
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSAWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSAWizardContextAction.CreateDSAAction;

public class CreateDSAWizardPage extends WizardPage {

	
	protected CreateDSAWizardContextAction context;
	
	private Composite 	container;
	
	public CreateDSAWizardPage(String pageName, CreateDSAWizardContextAction context) {
		super(pageName);
		this.setDescription("Select the wizard you wish to use to create a DSA project for your executable language.");
		this.setTitle(pageName);
		this.context = context;
	}
	
	@Override
	public void performHelp(){
		//PlatformUI.getWorkbench().getHelpSystem().displayHelp();
		PlatformUI.getWorkbench().getHelpSystem().displayHelpResource("/org.gemoc.gemoc_language_workbench.documentation/html/DSAProject.html");
	}

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.FILL);
		container.setLayout(new RowLayout (SWT.VERTICAL));

		Group actionSelection = new Group(container, SWT.FILL);
		actionSelection.setLayout (new RowLayout (SWT.VERTICAL));
		actionSelection.setText("Select action");
		//actionSelection.setBounds(10, 10, 193, 85);
	    
	    Button createK2DSAProject = new Button(actionSelection, SWT.RADIO);
	    createK2DSAProject.setText("Create new K2 DSA project");
	    createK2DSAProject.setSelection(true);
	    createK2DSAProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDSAAction.CREATE_NEW_K2_DSA_PROJECT;
			}
		});
	    Button createK3DSAProject = new Button(actionSelection, SWT.RADIO);
	    createK3DSAProject.setText("Create new K3 DSA project");
	    createK3DSAProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDSAAction.CREATE_NEW_K3_DSA_PROJECT;
			}
		});
	    Button selectExistingDSAProject = new Button(actionSelection, SWT.RADIO);
	    selectExistingDSAProject.setText("Select existing DSA project");  
	    selectExistingDSAProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDSAAction.SELECT_EXISTING_DSA_PROJECT;
			}
		}); 
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
	


}
