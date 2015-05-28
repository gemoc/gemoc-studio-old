package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.pages.CreateAnimatorProjectWizardPage;


public class CreateAnimatorProjectWizard extends Wizard {

	
	protected CreateAnimatorProjectWizardContextAction context;
	

	public CreateAnimatorProjectWizard(IProject updatedGemocLanguageProject) {
		super();
		this.setWindowTitle("Create Animator");
		context = new CreateAnimatorProjectWizardContextAction(updatedGemocLanguageProject);
		addPage(new CreateAnimatorProjectWizardPage("Create Animator", context));
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
