package org.gemoc.gemoc_language_workbench.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDSAWizard;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateKermeta2DSAWizardContextAction;

public class CreateDSAProjectHandler extends AbstractGemocLanguageProjectHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// get the optional selection and eventually project data to preset the wizard
		IProject updatedGemocLanguageProject = getUpdateGemocLanguageProjectFromSelection(event);

		// launch the wizard that will select the action and do the job
		WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
													 new CreateDSAWizard(new CreateKermeta2DSAWizardContextAction(updatedGemocLanguageProject)));
		wizardDialog.open();
		
		return null;
	}

}
