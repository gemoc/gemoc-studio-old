package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchGroup;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.gemoc.execution.engine.commons.ModelExecutionContext;
import org.gemoc.execution.engine.commons.RunConfiguration;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.executionengine.ccsljava.api.moc.ISolver;
import org.gemoc.executionengine.ccsljava.engine.commons.ConcurrentModelExecutionContext;
import org.gemoc.executionengine.ccsljava.engine.dse.NonDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.extensions.k3.PlainK3ExecutionEngine;
import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocDebuggerServices;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.AbstractGemocDebugger;
import org.gemoc.gemoc_modeling_workbench.ui.debug.GemocModelDebugger;
import org.gemoc.gemoc_modeling_workbench.ui.debug.PlainK3ModelDebugger;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

public class Launcher extends fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI {

	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.launcher";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private IExecutionEngine _executionEngine;

	@Override
	public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		try {
			debug("About to initialize and run the GEMOC Execution Engine...");

			// We parse the run configuration
			final RunConfiguration runConfiguration = new RunConfiguration(configuration);

			// We detect if we are running in debug mode or not
			ExecutionMode executionMode = null;
			if (ILaunchManager.DEBUG_MODE.equals(mode)) {
				executionMode = ExecutionMode.Animation;
			} else {
				executionMode = ExecutionMode.Run;
			}

			// We stop the launch if an engine is already running for this model
			if (isEngineAlreadyRunning(runConfiguration.getExecutedModelURI())) {
				return;
			}

			// Depending on the parsed launch conf and the mode, we create the
			// execution context
			// Then we see if we have a solver in the language def by trying to
			// create a concurrent context
			final ConcurrentModelExecutionContext concurrentexecutionContext = new ConcurrentModelExecutionContext(
					runConfiguration, executionMode);
			ISolver solver = null;
			try {
				solver = concurrentexecutionContext.getConcurrentLanguageDefinitionExtension().instanciateSolver();
			} catch (CoreException e) {
			}

			// This allows us to decide which kind of engine to create
			// Eventually, this would either be decided in the launch conf... or
			// in the xDSML file? not clear
			// Or we would automatically find the appropriate engine...
			if (solver != null) {
				_executionEngine = new NonDeterministicExecutionEngine();
				// In any case we initialize the engine
				_executionEngine.initialize(concurrentexecutionContext);
			} else {
				_executionEngine = new PlainK3ExecutionEngine();

				// In any case we initialize the engine
				_executionEngine.initialize(new ModelExecutionContext(runConfiguration, executionMode));
			}

			// And we start it within a dedicated job
			Job job = new Job(getDebugJobName(configuration, getFirstInstruction(configuration))) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// If we are debugging, we add the animator and we start
					// the execution using the super class
					// AbstractDSLLaunchConfigurationDelegateUI
					// This will start yet another job and eventually start
					// the engine
					if (ILaunchManager.DEBUG_MODE.equals(mode)) {
						IEngineAddon animator = AbstractGemocAnimatorServices.getAnimator();
						_executionEngine.getExecutionContext().getExecutionPlatform().addEngineAddon(animator);
						try {
							Launcher.super.launch(configuration, mode, launch, monitor);
							return new Status(IStatus.OK, getPluginID(), "Execution was launched successfully");
						} catch (CoreException e) {
							e.printStackTrace();
							return new Status(IStatus.ERROR, getPluginID(), "Could not start debugger.");
						}
					}

					// If we are not debugging, we simply start the engine
					// from the current job
					else {
						_executionEngine.start();
						debug("Execution finished.");
						return new Status(IStatus.OK, getPluginID(), "Execution was launched successfully");
					}
				}
			};
			debug("Initialization done, starting engine...");
			job.schedule();

		} catch (Exception e) {
			String message = "Error occured when starting execution engine: " + e.getMessage()
					+ " (see inner exception).";
			// error(message);
			e.printStackTrace();
			throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
		}
	}

	private boolean isEngineAlreadyRunning(URI launchedModelURI) throws CoreException {
		// make sure there is no other running engine on this model
		Collection<IExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry
				.getRunningEngines().values();
		for (IExecutionEngine engine : engines) {
			AbstractExecutionEngine observable = (AbstractExecutionEngine) engine;
			if (observable.getRunningStatus() != RunStatus.Stopped
					&& observable.getExecutionContext().getResourceModel().getURI().equals(launchedModelURI)) {
				String message = "An engine is already running on this model, please stop it first";
				warn(message);
				return true;
			}
		}
		return false;
	}

	protected void debug(String message) {
		getMessagingSystem().debug(message, getPluginID());
	}

	protected void info(String message) {
		getMessagingSystem().info(message, getPluginID());
	}

	protected void warn(final String message) {
		getMessagingSystem().warn(message, getPluginID());
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"GEMOC Engine Launcher", message);
			}
		});
	}

	protected void error(final String message) {
		getMessagingSystem().error(message, getPluginID());
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						"GEMOC Engine Launcher", message);
			}
		});
	}

	private MessagingSystem getMessagingSystem() {
		return Activator.getDefault().getMessaggingSystem();
	}

	@Override
	protected String getLaunchConfigurationTypeID() {
		return TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(ISelection selection) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(IEditorPart editor) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected EObject getFirstInstruction(ILaunchConfiguration configuration) {
		return EcorePackage.eINSTANCE;
	}

	@Override
	protected IDSLDebugger getDebugger(ILaunchConfiguration configuration, DSLDebugEventDispatcher dispatcher,
			EObject firstInstruction, IProgressMonitor monitor) {

		AbstractGemocDebugger res = null;

		if (_executionEngine instanceof INonDeterministicExecutionEngine) {

			res = new GemocModelDebugger(dispatcher, _executionEngine);

		} else if (_executionEngine instanceof IDeterministicExecutionEngine) {
			res = new PlainK3ModelDebugger(dispatcher, (IDeterministicExecutionEngine) _executionEngine);
		}

		// If in the launch configuration it is asked to pause at the start,
		// we add this dummy break
		try {
			if (configuration.getAttribute(RunConfiguration.LAUNCH_BREAK_START, false)) {
				res.addPredicateBreak(new BiPredicate<IExecutionEngine, MSEOccurrence>() {
					@Override
					public boolean test(IExecutionEngine t, MSEOccurrence u) {
						return true;
					}
				});
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		_executionEngine.getExecutionContext().getExecutionPlatform().addEngineAddon(res);
		return res;
	}

	@Override
	protected String getDebugTargetName(ILaunchConfiguration configuration, EObject firstInstruction) {
		return "Gemoc debug target";
	}

	@Override
	protected List<IDSLCurrentInstructionListener> getCurrentInstructionListeners() {
		List<IDSLCurrentInstructionListener> result = super.getCurrentInstructionListeners();
		result.add(AbstractGemocDebuggerServices.LISTENER);
		return result;
	}

	@Override
	protected String getDebugJobName(ILaunchConfiguration configuration, EObject firstInstruction) {
		return "Gemoc debug job";
	}

	@Override
	protected String getPluginID() {
		return Activator.PLUGIN_ID;
	}

	@Override
	protected String getModelIdentifier() {
		if (_executionEngine instanceof PlainK3ExecutionEngine)
			return "org.gemoc.gemoc_modeling_workbench.ui.plainK3debugModel";
		else
			return MODEL_ID;
	}

	@Override
	protected ILaunchConfiguration[] createLaunchConfiguration(IResource file, EObject firstInstruction, String mode)
			throws CoreException {
		ILaunchConfiguration[] launchConfigs = super.createLaunchConfiguration(file, firstInstruction, mode);

		if (launchConfigs.length == 1) {
			// open configuration for further editing
			if (launchConfigs[0] instanceof ILaunchConfigurationWorkingCopy) {
				ILaunchConfigurationWorkingCopy configuration = (ILaunchConfigurationWorkingCopy) launchConfigs[0];

				String selectedLanguage = configuration.getAttribute(RunConfiguration.LAUNCH_SELECTED_LANGUAGE, "");
				if (selectedLanguage.equals("")) {

					// TODO try to infer possible language and other attribute
					// from project content and environment
					configuration.setAttribute(RunConfiguration.LAUNCH_SELECTED_DECIDER,
							RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP);
					final ILaunchGroup group = DebugUITools.getLaunchGroup(configuration, mode);
					if (group != null) {
						ILaunchConfiguration savedLaunchConfig = configuration.doSave();
						// open configuration for user validation and inputs
						DebugUITools.openLaunchConfigurationDialogOnGroup(PlatformUI.getWorkbench()
								.getActiveWorkbenchWindow().getShell(), new StructuredSelection(savedLaunchConfig),
								group.getIdentifier(), null);
						// DebugUITools.openLaunchConfigurationDialog(PlatformUI.getWorkbench()
						// .getActiveWorkbenchWindow().getShell(),
						// savedLaunchConfig, group.getIdentifier(), null);
					}
				}
			}
		}
		return launchConfigs;

	}

}
