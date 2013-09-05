package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;

public class CreateDSAWizardContextAction {

	public enum CreateDSAAction {CREATE_NEW_DSA_PROJECT, SELECT_EXISTING_DSA_PROJECT};
	
	public CreateDSAAction actionToExecute = CreateDSAAction.CREATE_NEW_DSA_PROJECT;
	
	protected IProject gemocLanguageIProject; 
	
	public CreateDSAWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_DSA_PROJECT:
			createNewDSAProject();
			break;
		case SELECT_EXISTING_DSA_PROJECT:
			selectExistingDSAProject();
			break;

		default:
			break;
		}
	}

	protected void createNewDSAProject(){
	}
	
	protected void selectExistingDSAProject(){
	}
	
	protected void addDSAProjectToConf(String projectName){
	}
	


}
