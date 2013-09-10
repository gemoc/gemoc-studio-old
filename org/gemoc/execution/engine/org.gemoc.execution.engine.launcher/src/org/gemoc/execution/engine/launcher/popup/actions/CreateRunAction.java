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
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.emf.ecl.ccsl.EmfEclCcslExecutionEngine;

public class CreateRunAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile file;
    private ExecutionEngine engine;
    private String consoleName;

    /**
     * Constructor for Action1.
     */
    public CreateRunAction() {
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
        MessageConsole myConsole = findConsole(consoleName);
        MessageConsoleStream out = myConsole.newMessageStream();
        String information = "";

        String ccslFilePath = "/org.gemoc.execution.engine.example/model/TrafficControl_MoCC-rendevous.extendedCCSL";
        String jarsFolderPath = "/org.gemoc.execution.engine.example/my_jars";
        String modelPath = "/org.gemoc.execution.engine.example/model/TrafficControl.tfsm";
        String MMpath = "/fr.inria.aoste.gemoc.example.tfsm.model/model/tfsm.ecore";

        if (engine == null) {
            out.println("Creating the engine...");
            try {
                this.engine = new EmfEclCcslExecutionEngine(ccslFilePath, jarsFolderPath, modelPath, MMpath);
            } catch (Exception e) {
                out.println("Got an exception, checkout the error log");
                Activator.error("Exception in the initialization of the engine", e);
                this.engine = null;
                e.printStackTrace();
            }
            out.println("...Engine created.");
            information += "Engine created";
        }

        out.println("Running the engine...");
        for (int i = 0; i < 100; i++) {
            ((EmfEclCcslExecutionEngine) this.engine).runOneStep();
        }
        if (!information.equals("")) {
            information += ", ";
        }
        information += "Engine ran.";
        MessageDialog.openInformation(shell, "Launcher", information);

        out.println("DONE");
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
