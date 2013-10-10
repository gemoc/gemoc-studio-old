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
import org.gemoc.execution.engine.api_implementations.dsa.EmfExecutor;
import org.gemoc.execution.engine.api_implementations.feedback.SimpleFeedbackPolicy;
import org.gemoc.execution.engine.api_implementations.moc.MockSolver;
import org.gemoc.execution.engine.api_implementations.utils.EclToCcslTranslator;
import org.gemoc.execution.engine.api_implementations.utils.TfsmModelLoader;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.execution.engine.launcher.Activator;
import org.gemoc.gemoc_language_workbench.api.moc.ModelOfExecutionBuilder;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import tfsm.impl.GroovyRunner;

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

		String ccslFilePath = "/org.gemoc.execution.engine.example/model/TrafficControl_MoCC_new.extendedCCSL";
		String jarDsaFolderPath = "/org.gemoc.execution.engine.example/my_jars/dsa";
		String jarDependenciesFolderPath = "/org.gemoc.execution.engine.example/my_jars/dependencies";
		String modelPath = "/org.gemoc.execution.engine.example/model/TrafficControl.tfsm";
		String MMpath = "/org.gemoc.execution.engine.example.tfsm.model/model/Tfsm.ecore";
		GroovyRunner.absolutePathToGroovyControl = "/home/flatombe/thesis/gemoc/git/gemoc-dev/org/gemoc/sample/TFSM/DSA/org.gemoc.sample.i3s.fsm.dsa.groovy/groovy/control.groovy";


		// GemocExecutionEngine(LanguageInitializer languageInitializer,
		// ModelLoader modelLoader,
		// Resource domainSpecificEventsResource, ModelOfExecutionBuilder
		// modelOfExecutionBuilder, Solver solver,
		// Executor executor, FeedbackPolicy feedbackPolicy)
		String eclFilePath = "/org.gemoc.execution.engine.example/model/TFSM.ecl";
		ResourceSet resSet = new ResourceSetImpl();
		Resource eclResource = resSet.getResource(URI.createURI(eclFilePath), true);

		try {
			this.engine = new GemocExecutionEngine((LanguageInitializer) null, (ModelLoader) new TfsmModelLoader(),
					(Resource) eclResource, (ModelOfExecutionBuilder) new EclToCcslTranslator(eclResource),
					new MockSolver(), new EmfExecutor(), new SimpleFeedbackPolicy());
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
				Object selected = ((IStructuredSelection) selection).getFirstElement();
				if (selected instanceof IFile) {
					this.file = (IFile) selected;
				}
			}
		}

	}

}
