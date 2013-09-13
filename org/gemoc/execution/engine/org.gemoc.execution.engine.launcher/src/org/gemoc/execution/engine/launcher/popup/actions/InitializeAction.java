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

public class InitializeAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile file;
    private ExecutionEngine engine;

    /**
     * Constructor for Action1.
     */
    public InitializeAction() {
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
        String information = "";

        String ccslFilePath = "/org.gemoc.execution.engine.example/model/TrafficControl_MoCC-rendevous.extendedCCSL";
        String jarDsaFolderPath = "/org.gemoc.execution.engine.example/my_jars/dsa";
        String jarDependenciesFolderPath = "/org.gemoc.execution.engine.example/my_jars/dependencies";
        String modelPath = "/org.gemoc.execution.engine.example/model/TrafficControl.tfsm";
        String MMpath = "/fr.inria.aoste.gemoc.example.tfsm.model/model/tfsm.ecore";

        try {
            this.engine = new EmfEclCcslExecutionEngine(ccslFilePath, jarDsaFolderPath, jarDependenciesFolderPath,
                    modelPath, MMpath);
            information += "Engine Initialized.";
        } catch (Exception e) {
            Activator.error("Exception in the initialization of the engine", e);
            this.engine = null;
            information += "Error during the initialization of the engine.";
            e.printStackTrace();
        }
        Activator.engine = this.engine;
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
