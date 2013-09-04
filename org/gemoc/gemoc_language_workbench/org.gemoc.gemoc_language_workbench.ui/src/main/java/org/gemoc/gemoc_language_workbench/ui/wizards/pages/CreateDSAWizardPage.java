package org.gemoc.gemoc_language_workbench.ui.wizards.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
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
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.FILL);
		container.setLayout(new RowLayout (SWT.VERTICAL));

		Group actionSelection = new Group(container, SWT.FILL);
		actionSelection.setLayout (new RowLayout (SWT.VERTICAL));
		actionSelection.setText("Select action");
		//actionSelection.setBounds(10, 10, 193, 85);
	    
	    Button createDSAProject = new Button(actionSelection, SWT.RADIO);
	    createDSAProject.setText("Create new DSA project");
	    createDSAProject.setSelection(true);
	    createDSAProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateDSAAction.CREATE_NEW_DSA_PROJECT;
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
