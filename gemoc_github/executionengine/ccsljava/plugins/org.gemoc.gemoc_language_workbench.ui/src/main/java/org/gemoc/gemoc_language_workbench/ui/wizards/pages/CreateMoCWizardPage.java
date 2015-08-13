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
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMoCWizardContextAction;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateMoCWizardContextAction.CreateMoCAction;

public class CreateMoCWizardPage extends WizardPage {

	
	protected CreateMoCWizardContextAction context;
	
	private Composite 	container;
	
	public CreateMoCWizardPage(String pageName, CreateMoCWizardContextAction context) {
		super(pageName);
		this.setDescription("Select the wizard you wish to use to create a MoCC project for your executable language.");
		this.setTitle(pageName);
		this.context = context;
	}
	
	@Override
	public void performHelp(){
		//PlatformUI.getWorkbench().getHelpSystem().displayHelp();
		PlatformUI.getWorkbench().getHelpSystem().displayHelpResource("/org.gemoc.gemoc_language_workbench.documentation/html/MoCProject.html");
	}

	@Override
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.FILL);
		container.setLayout(new RowLayout (SWT.VERTICAL));

		Group actionSelection = new Group(container, SWT.FILL);
		actionSelection.setLayout (new RowLayout (SWT.VERTICAL));
		actionSelection.setText("Select action");
		//actionSelection.setBounds(10, 10, 193, 85);
	    
	    Button createMoCProject = new Button(actionSelection, SWT.RADIO);
	    createMoCProject.setText("Create new MoCC project");
	    createMoCProject.setSelection(true);
	    createMoCProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateMoCAction.CREATE_NEW_MOC_PROJECT;
			}
		});
	    Button selectExistingMoCProject = new Button(actionSelection, SWT.RADIO);
	    selectExistingMoCProject.setText("Select existing MoCC project");  
	    selectExistingMoCProject.addListener (SWT.Selection, new Listener () {
			public void handleEvent (Event event) {
				// update context and potentially add new pages ?
				context.actionToExecute = CreateMoCAction.SELECT_EXISTING_MOC_PROJECT;
			}
		}); 
		
		// Required to avoid an error in the system
		setControl(container);
		setPageComplete(true);
	}
	
}
