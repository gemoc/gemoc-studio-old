package org.gemoc.gemoc_language_workbench.ui.wizards;

import org.eclipse.jface.wizard.Wizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.pages.CreateMOCCWizardPage;

public class CreateMOCCWizard extends Wizard {

	protected CreateMOCCWizardContextAction context;
	

	public CreateMOCCWizard(CreateMOCCWizardContextAction context) {
		super();
		this.setWindowTitle("Create MOCC");
		//context = new CreateDSAWizardContextAction(updatedGemocLanguageProject);
		this.context = context;
		addPage(new CreateMOCCWizardPage("Create MOCC", context));
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
