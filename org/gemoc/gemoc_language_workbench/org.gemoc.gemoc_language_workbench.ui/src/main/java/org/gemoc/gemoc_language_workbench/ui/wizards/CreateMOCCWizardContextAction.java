package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;

public class CreateMOCCWizardContextAction {

	public enum CreateMOCCAction {CREATE_NEW_MOCC_PROJECT, SELECT_EXISTING_MOCC_PROJECT};
	
	public CreateMOCCAction actionToExecute = CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
	
	protected IProject gemocLanguageIProject; 
	
	public CreateMOCCWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}

	public void execute() {
		switch (actionToExecute) {
		case CREATE_NEW_MOCC_PROJECT:
			createNewMOCCProject();
			break;
		case SELECT_EXISTING_MOCC_PROJECT:
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
