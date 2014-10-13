package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration;

public class CreateMOCCWizardContextAction {

	public enum CreateMOCCAction {CREATE_NEW_MOCC_PROJECT, SELECT_EXISTING_MOCC_PROJECT};
	
	public CreateMOCCAction actionToExecute = CreateMOCCAction.CREATE_NEW_MOCC_PROJECT;
	
	// one of these must be set, depending on it it will work on the file or directly in the model 
	protected IProject gemocLanguageIProject = null;
	protected GemocLanguageWorkbenchConfiguration gemocLanguageModel = null; 
	
	public CreateMOCCWizardContextAction(IProject updatedGemocLanguageProject) {
		gemocLanguageIProject = updatedGemocLanguageProject;
	}
	public CreateMOCCWizardContextAction(GemocLanguageWorkbenchConfiguration rootModelElement) {
		gemocLanguageModel = rootModelElement;
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
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"createNewMOCCProject. Action not implemented yet");
	}
	
	protected void selectExistingMOCCProject(){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"selectExistingMOCCProject. Action not implemented yet");
	}
	
	protected void addMOCCProjectToConf(String projectName){
		MessageDialog.openWarning(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				"Gemoc Language Workbench UI",
				"addMOCCProjectToConf. Action not implemented yet");
	}
	


}
