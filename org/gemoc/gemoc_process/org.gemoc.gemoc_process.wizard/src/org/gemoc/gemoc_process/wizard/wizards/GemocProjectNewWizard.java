package org.gemoc.gemoc_process.wizard.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class GemocProjectNewWizard extends Wizard implements INewWizard {
	
	ContextWizardNewProject context = new ContextWizardNewProject ();
	GemocProjectNewWizardPage DSMLpage = new GemocProjectNewWizardPage (context); 
	GemocProjectNewWizardAttributeDynManager attributeDyn = new GemocProjectNewWizardAttributeDynManager (context); 
	
	public GemocProjectNewWizard() {
		
	}
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
	}
	
	@Override
	public void addPages() {
		addPage(DSMLpage);
		addPage(attributeDyn);
	}
	
	@Override
	public boolean performFinish() {
		return true;
	}
}
