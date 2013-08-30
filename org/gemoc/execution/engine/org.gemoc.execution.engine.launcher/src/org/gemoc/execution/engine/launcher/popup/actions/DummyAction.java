package org.gemoc.execution.engine.launcher.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.emf.ecl.ccsl.EmfEclCcslExecutionEngine;

public class DummyAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile file;

    /**
     * Constructor for Action1.
     */
    public DummyAction() {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        shell = targetPart.getSite().getShell();
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    public void run(IAction action) {
        MessageDialog.openInformation(shell, "Launcher", "New Action was executed.");
        System.out.println("Hello : " + this.file.toString());
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection) {
        StructuredSelection structuredSelection = (StructuredSelection) selection;
        this.file = (IFile) structuredSelection.getFirstElement();
    }

}
