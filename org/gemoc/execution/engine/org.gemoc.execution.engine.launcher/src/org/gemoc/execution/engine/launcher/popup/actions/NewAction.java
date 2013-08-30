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
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.emf.ecl.ccsl.EmfEclCcslExecutionEngine;

public class NewAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile file;
    private ExecutionEngine engine;
    private String consoleName;

    /**
     * Constructor for Action1.
     */
    public NewAction() {
        super();
        this.consoleName = "debug";
    }

    private MessageConsole findConsole(String name) {
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++)
            if (name.equals(existing[i].getName()))
                return (MessageConsole) existing[i];
        // no console found, so create a new one
        MessageConsole myConsole = new MessageConsole(name, null);
        conMan.addConsoles(new IConsole[] { myConsole });
        return myConsole;
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

        MessageConsole myConsole = findConsole(consoleName);
        MessageConsoleStream out = myConsole.newMessageStream();
        out.println("truc");

        this.engine = new EmfEclCcslExecutionEngine(file, out);
        out.println(this.engine.toString());
        
        this.engine.run();
    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection) {
        StructuredSelection structuredSelection = (StructuredSelection) selection;
        this.file = (IFile) structuredSelection.getFirstElement();
    }

}
