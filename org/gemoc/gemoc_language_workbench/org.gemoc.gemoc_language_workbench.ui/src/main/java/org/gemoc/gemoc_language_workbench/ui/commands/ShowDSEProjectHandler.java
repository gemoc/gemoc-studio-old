package org.gemoc.gemoc_language_workbench.ui.commands;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowDSEProjectHandler extends AbstractHandler implements
		IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event)
		        .getActivePage().getSelection();
		    if (selection != null & selection instanceof IStructuredSelection) {
		      IStructuredSelection strucSelection = (IStructuredSelection) selection;
		      for (Iterator<Object> iterator = strucSelection.iterator(); iterator
		          .hasNext();) {
		        Object element = iterator.next();
		        MessageDialog.openWarning(
						HandlerUtil.getActiveWorkbenchWindow(event).getShell(),
						"Gemoc Language Workbench UI",
						"Show DSE Project command was executed. Action not implemented yet, Selected elment ="+element.toString());
		        //System.out.println(element.toString());
		      }
		    }
		return null;
	}

}
