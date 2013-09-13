package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;

public class CreateDSEWizardContextAction {

	public enum CreateDSEAction {CREATE_NEW_DSE_PROJECT, SELECT_EXISTING_DSE_PROJECT};
	
	public CreateDSEAction actionToExecute = CreateDSEAction.CREATE_NEW_DSE_PROJECT;
	
	protected IProject gemocLanguageIProject; 
	
	public CreateDSEWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_DSE_PROJECT:
			createNewMOCCProject();
			break;
		case SELECT_EXISTING_DSE_PROJECT:
			selectExistingMOCCProject();
			break;

		default:
			break;
		}
	}

	protected void createNewMOCCProject(){
	}
	
	protected void selectExistingMOCCProject(){
	}
	
	protected void addMOCCProjectToConf(String projectName){
	}
	


}
