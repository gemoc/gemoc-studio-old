package org.gemoc.execution.engine.launcher.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.emf.ecl.ccsl.EmfEclCcslExecutionEngine;
import org.gemoc.execution.engine.launcher.Activator;

public class RunOneStepAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile file;
    private ExecutionEngine engine;

    // private String consoleName;

    /**
     * Constructor for Action1.
     */
    public RunOneStepAction() {
        super();
        this.engine = Activator.engine;
    }

    // private MessageConsole findConsole(String name) {
    // ConsolePlugin plugin = ConsolePlugin.getDefault();
    // IConsoleManager conMan = plugin.getConsoleManager();
    // IConsole[] existing = conMan.getConsoles();
    // for (int i = 0; i < existing.length; i++)
    // if (name.equals(existing[i].getName()))
    // return (MessageConsole) existing[i];
    // // no console found, so create a new one
    // MessageConsole myConsole = new MessageConsole(name, null);
    // conMan.addConsoles(new IConsole[] { myConsole });
    // return myConsole;
    // }

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
        String information = "";

        if (engine == null) {
            information += "Engine is null. Please initialize engine before running.";
        } else {
            int numberOfSteps = 1;
            ((EmfEclCcslExecutionEngine) this.engine).run(numberOfSteps);

            information += "Engine ran " + numberOfSteps + " step(s).";
        }
        MessageDialog.openInformation(shell, "Launcher", information);
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            if (((IStructuredSelection) selection).size() == 1) {
                Object selected = ((IStructuredSelection) selection).getFirstElement();
                if (selected instanceof IFile) {
                    this.file = (IFile) selected;
                }
            }
        }

    }

}
