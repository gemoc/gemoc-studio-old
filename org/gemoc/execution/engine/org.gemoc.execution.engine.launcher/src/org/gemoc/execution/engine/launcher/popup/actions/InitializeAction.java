package org.gemoc.execution.engine.launcher.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.gemoc.execution.engine.api_standard_implementations.feedback.SimpleFeedbackPolicy;
import org.gemoc.execution.engine.api_standard_implementations.moc.CcslSolver;
import org.gemoc.execution.engine.api_standard_implementations.moc.EclToCcslTranslator;
import org.gemoc.execution.engine.commons.dsa.executors.Kermeta3Executor;
import org.gemoc.execution.engine.commons.utils.TfsmModelLoader;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.execution.engine.launcher.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.ModelOfExecutionBuilder;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

//import org.gemoc.sample.tfsm.k3dsa.GroovyRunner;

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

		// Not used yet
		String ccslFilePath = "/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl_RendezVous.extendedCCSL";
		String MMPath = "fr.inria.aoste.gemoc.example";

		// Path to the tfsm model
		String modelPath = "/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl.tfsm";

		// Path to the ECL file so as to retrieve the resource.
		String eclFilePath = "/org.gemoc.sample.tfsm.ecldse/dse/TFSM.ecl";
		ResourceSet resSet = new ResourceSetImpl();
		Resource eclResource = resSet.getResource(URI.createURI(eclFilePath),
				true);

		try {
			// Language-level initialization of the engine
			this.engine = new GemocExecutionEngine((LanguageInitializer) null,
					(ModelLoader) new TfsmModelLoader(),
					(Resource) eclResource,
					(ModelOfExecutionBuilder) new EclToCcslTranslator(
							eclResource), (Solver) new CcslSolver(),
					(Executor) new Kermeta3Executor(Thread.currentThread()
							.getContextClassLoader(),
							"org.gemoc.sample.tfsm.k3dsa"),
					(FeedbackPolicy) new SimpleFeedbackPolicy());
			
			// Model-level initialization of the engine
			this.engine.initialize(modelPath);
			information += "Engine Initialized.";
		} catch (Exception e) {
			Activator.error("Exception in the initialization of the engine", e);
			this.engine = null;
			information += "Error during the initialization of the engine.";
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
				Object selected = ((IStructuredSelection) selection)
						.getFirstElement();
				if (selected instanceof IFile) {
					this.file = (IFile) selected;
				}
			}
		}

	}

}
