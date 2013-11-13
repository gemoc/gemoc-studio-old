package org.gemoc.execution.engine.launcher.popup.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
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
import org.gemoc.execution.engine.api_standard_implementations.moc.EclToCcslTranslator;
import org.gemoc.execution.engine.commons.dsa.executors.Kermeta3EventExecutor;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.execution.engine.launcher.Activator;
import org.gemoc.execution.javasolver.core.TFSMJavaSolver;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.ModelOfExecutionBuilder;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;
import org.gemoc.sample.tfsm.feedback.TfsmFeedbackPolicy;
import org.gemoc.sample.tfsm.k3dsa.GroovyRunner;

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
		// String modelPath =
		// "/org.gemoc.sample.tfsm.instances/TrafficControl/test.tfsm";
		String modelPath = "/org.gemoc.sample.tfsm.instances/TrafficControl/TrafficControl.tfsm";

		GroovyRunner.absolutePathToGroovyControl = "/home/flatombe/thesis/gemoc/git/gemoc-dev/org/gemoc/sample/TFSM/DSA/org.gemoc.sample.i3s.fsm.dsa.groovy/groovy/control.groovy";

		// Path to the ECL file so as to retrieve the resource.
		String eclFilePath = "/org.gemoc.sample.tfsm.ecldse/dse/TFSM.ecl";
		ResourceSet resSet = new ResourceSetImpl();
		Resource eclResource = resSet.getResource(URI.createURI(eclFilePath),
				true);

		try {
			ModelLoader modelLoader = null;
			LanguageInitializer languageInitializer = null;
			IDSAExecutor languageDSAExecutor = null;
			// retrieve the language extension point
			IConfigurationElement confElement = null;
			IConfigurationElement[] confElements = Platform.getExtensionRegistry().getConfigurationElementsFor("org.gemoc.gemoc_language_workbench.xdsml");
			// retrieve the extension for the chosen language
			for (int i = 0; i < confElements.length; i++) {
				if(confElements[i].getAttribute("name").equals("tfsm")){
					confElement =confElements[i];
				}
			}
			// get the extension objects
			if(confElement != null){
				final Object omodelLoader = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
				if(omodelLoader instanceof ModelLoader){
					modelLoader = (ModelLoader) omodelLoader;
				}
				final Object oinitializer = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_INITIALIZER_ATT);
				if(oinitializer instanceof LanguageInitializer){
					languageInitializer = (LanguageInitializer) oinitializer;
				}

				final Object oexecutor = confElement.createExecutableExtension(org.gemoc.gemoc_language_workbench.ui.Activator.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_EXECUTOR_ATT);
				if(oexecutor instanceof IDSAExecutor){
					languageDSAExecutor = (IDSAExecutor) oexecutor;
				}
				
			}
			if(modelLoader != null && languageDSAExecutor != null){
				// Language-level initialization of the engine
				this.engine = new GemocExecutionEngine((LanguageInitializer) null,
						modelLoader,
						(Resource) eclResource,
						(ModelOfExecutionBuilder) new EclToCcslTranslator(
								eclResource), (Solver) new TFSMJavaSolver(modelLoader),
						(EventExecutor) new Kermeta3EventExecutor(Thread
								.currentThread().getContextClassLoader(),
								"org.gemoc.sample.tfsm.k3dsa", 
								languageDSAExecutor),
						(FeedbackPolicy) new TfsmFeedbackPolicy());
			}
			else {
				Activator.error("Problem initializing GemocExecutionEngine, cannot find modelLoader or dsaExecutor", new Exception());
			}
			
			

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
