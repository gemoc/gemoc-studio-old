package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.pages.CreateDSAWizardPage;

public class CreateDSAWizard extends Wizard {

	protected CreateDSAWizardContextAction context;
	

	public CreateDSAWizard(IProject updatedGemocLanguageProject) {
		super();
		this.setWindowTitle("Create DSA");
		context = new CreateDSAWizardContextAction(updatedGemocLanguageProject);
		addPage(new CreateDSAWizardPage("Create DSA", context));
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
