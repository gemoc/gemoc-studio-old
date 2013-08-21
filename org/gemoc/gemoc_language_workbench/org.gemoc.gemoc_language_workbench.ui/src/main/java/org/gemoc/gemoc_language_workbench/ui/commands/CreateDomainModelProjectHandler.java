package org.gemoc.gemoc_language_workbench.ui.commands;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.ui.wizards.CreateDomainModelWizard;

public class CreateDomainModelProjectHandler extends AbstractHandler implements
		IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the optional selection and eventually project data to preset the wizard

		IProject updatedGemocLanguageProject=null;
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
			        .getActivePage().getSelection();
			    if (selection != null & selection instanceof IStructuredSelection) {
			      IStructuredSelection strucSelection = (IStructuredSelection) selection;
			      for (Iterator<Object> iterator = strucSelection.iterator(); iterator
			          .hasNext();) {
			        Object element = iterator.next();
			        
			        if(element  instanceof IResource) {
			        	updatedGemocLanguageProject =((IResource)element).getProject();
						
					}
			        if(element  instanceof IAdaptable){
			        	IResource res =(IResource) ((IAdaptable)element).getAdapter(IResource.class);
			        	if(res != null){
			        		updatedGemocLanguageProject = res.getProject();
			        	}
			        }
			        
			        // if still null look after the activeEditor
			        if(updatedGemocLanguageProject == null){
			        	
			        	IResource res =(IResource) HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getActiveEditor().getEditorInput().getAdapter(IResource.class);
			        	if(res != null){
			        		updatedGemocLanguageProject = res.getProject();
			        	}
			        }
			        
			        
			   /*     MessageDialog.openInformation(
							HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
							"Gemoc Language Workbench UI",
							"Create Domain Model Project command was executed. Selected elment ="+element.toString());
			     */   
			      }
			    }
		
	
		// launch the wizard that will select the action	    
	    WizardDialog wizardDialog = new WizardDialog(HandlerUtil.getActiveWorkbenchWindow(event).getShell(), new CreateDomainModelWizard(updatedGemocLanguageProject));
		wizardDialog.open();
		
		return null;
	}

}
