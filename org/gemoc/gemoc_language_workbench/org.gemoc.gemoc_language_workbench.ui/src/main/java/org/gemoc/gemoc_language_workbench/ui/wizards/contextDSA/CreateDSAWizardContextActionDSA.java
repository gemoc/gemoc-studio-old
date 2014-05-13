package org.gemoc.gemoc_language_workbench.ui.wizards.contextDSA;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.utils.ui.dialogs.SelectDSAIprojectDialog;

public class CreateDSAWizardContextActionDSA extends CreateDSAWizardContextBase {

	public CreateDSAWizardContextActionDSA(IProject gemocLanguageIProject) {
		super(gemocLanguageIProject);
	}

	public void createNewDSAProject() {
	}
	
	public void selectExistingDSAProject(){
		// launch the appropriate wizard
		SelectDSAIprojectDialog dialog = new SelectDSAIprojectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		int res = dialog.open();
		if(res == WizardDialog.OK){
			// update the project model
			addDSAProjectToConf(((IResource)dialog.getResult()[0]).getName());
		}
	}	
	
}
