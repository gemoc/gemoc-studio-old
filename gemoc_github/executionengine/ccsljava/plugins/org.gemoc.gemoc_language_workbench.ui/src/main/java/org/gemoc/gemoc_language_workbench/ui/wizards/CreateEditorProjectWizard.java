package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.pages.CreateEditorProjectWizardPage;


public class CreateEditorProjectWizard extends Wizard {

	
	protected CreateEditorProjectWizardContextAction context;
	

	public CreateEditorProjectWizard(IProject updatedGemocLanguageProject) {
		super();
		this.setWindowTitle("Create Editor");
		context = new CreateEditorProjectWizardContextAction(updatedGemocLanguageProject);
		addPage(new CreateEditorProjectWizardPage("Create Editor", context));
	}

	@Override
	public void addPages() {
		
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		// do the selected actions now ...
		context.execute();
		return true;
	}

}
