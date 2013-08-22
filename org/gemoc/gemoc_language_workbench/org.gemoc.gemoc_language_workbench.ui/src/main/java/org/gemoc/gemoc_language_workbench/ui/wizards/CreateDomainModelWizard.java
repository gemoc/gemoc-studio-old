package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.pages.CreateDomainModelWizardPage;


public class CreateDomainModelWizard extends Wizard {

	
	protected CreateDomainModelWizardContext context;
	

	public CreateDomainModelWizard(IProject updatedGemocLanguageProject) {
		super();
		this.setWindowTitle("Create Domain Model");
		context = new CreateDomainModelWizardContext(updatedGemocLanguageProject);
		addPage(new CreateDomainModelWizardPage("Create Domain Model", context));
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
