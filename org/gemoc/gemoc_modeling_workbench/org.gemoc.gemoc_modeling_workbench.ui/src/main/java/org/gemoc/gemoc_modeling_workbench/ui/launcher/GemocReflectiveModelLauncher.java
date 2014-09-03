package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.util.EclipseUtil;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.gemoc.execution.engine.core.ModelExecutionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.core.RunConfiguration;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.exceptions.EngineContextException;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.obeo.dsl.debug.ide.IDSLDebugger;
import fr.obeo.dsl.debug.ide.adapter.IDSLCurrentInstructionListener;
import fr.obeo.dsl.debug.ide.event.DSLDebugEventDispatcher;

public class GemocReflectiveModelLauncher
		extends
		fr.obeo.dsl.debug.ide.sirius.ui.launch.AbstractDSLLaunchConfigurationDelegateUI 
{
	
	public final static String TYPE_ID = "org.gemoc.gemoc_modeling_workbench.ui.GemocReflectiveModelLauncherID";

	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private ObservableBasicExecutionEngine _engine;

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {		
		try 
		{
			RunConfiguration runConfiguration = new RunConfiguration(configuration);

			if (ILaunchManager.DEBUG_MODE.equals(mode)
				&& runConfiguration.getAnimatorURIAsString() != null) 
			{
				URI uri = URI.createPlatformResourceURI(runConfiguration.getAnimatorURIAsString(), true);
				killPreviousSiriusSession(uri, monitor);
				openNewSiriusSession(uri, monitor);
			}
			
			debug("About to initialize and run the GEMOC Execution Engine...");			
			ModelExecutionContext executionContext = new ModelExecutionContext(runConfiguration);			
			throwExceptionIfEngineAlreadyRunning(executionContext);
			ILogicalStepDecider decider = LogicalStepDeciderFactory.createDecider(executionContext.getRunConfiguration().getDeciderName(), executionContext.getSolver());

			_engine = new ObservableBasicExecutionEngine(decider, executionContext);

			if (executionContext.getRunConfiguration().isAnimationActive()) 
			{
				_engine.setAnimator(AbstractGemocAnimatorServices.getAnimator());
			}
			// delegate for debug mode
			if (ILaunchManager.DEBUG_MODE.equals(mode)) {
				super.launch(configuration, mode, launch, monitor);
			} else {
				Job job = new Job(getDebugJobName(configuration,
						getFirstInstruction(configuration))) {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						_engine.start();
						return new Status(IStatus.OK, getPluginID(),
								"Execution was successfull");
					}
				};
				job.schedule();
			}
		} 
		catch (Exception e)
		{
			String message = "Error occured when starting execution engine, see inner exception.";
		  	//error(message);
		  	throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message, e));
		}
	}

	private void openNewSiriusSession(URI sessionResourceURI, IProgressMonitor monitor) {
		Session session = SessionManager.INSTANCE.getSession(sessionResourceURI, monitor);
		session.open(monitor);
//
//		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(sessionResourceURI.toPlatformString(true)));
//		final IPath uriAsPath = file.getLocation();
//		Display.getDefault().asyncExec(new Runnable() {
//			@Override
//			public void run() {
//				//IEditorPart editor = DialectUIManager.INSTANCE.openEditor(session, representation, new NullProgressMonitor());
//				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//				IFileStore fileStore = EFS.getLocalFileSystem().getStore(uriAsPath);
//				try {
//					IDE.openEditorOnFileStore( page, fileStore );
//				} catch (PartInitException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
// 			}
//		});
//		
		for (DView view : session.getSelectedViews())
		{
			for (DRepresentation representation : view.getOwnedRepresentations())
			{
				DialectUIManager.INSTANCE.openEditor(session, representation, new NullProgressMonitor());
			}
		}
	}

	private void killPreviousSiriusSession(URI sessionResourceURI, IProgressMonitor monitor) {
		Session session = SessionManager.INSTANCE.getExistingSession(sessionResourceURI);
		if (session != null) {
			session.close(monitor);
			SessionManager.INSTANCE.remove(session);			
		}
	}


	private void throwExceptionIfEngineAlreadyRunning(ModelExecutionContext executionContext) throws CoreException 
	{
		// make sure there is no other running engine on this model
		Collection<GemocExecutionEngine> engines = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values();
		for (GemocExecutionEngine engine : engines)
		{
			ObservableBasicExecutionEngine observable = (ObservableBasicExecutionEngine) engine;
  		  	if (observable.getEngineStatus().getRunningStatus() != RunStatus.Stopped 
  		  		&&  observable.getExecutionContext().getResourceModel().getURI().equals(URI.createPlatformResourceURI(executionContext.getWorkspace().getModelPath().toString(), true)))
  		  	{
  		  		String message = "An engine is already running on this model, please stop it first";
  		  		warn(message);
  		  		throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, message));
  		  	}
		}
	}

	private void debug(String message) {
		getMessagingSystem().debug(message, getPluginID());
	}

	private void info(String message) {
		getMessagingSystem().info(message, getPluginID());
	}

	private void warn(String message) {
		getMessagingSystem().warn(message, getPluginID());
	}

	private void error(String message) {
		getMessagingSystem().error(message, getPluginID());
	}

	private MessagingSystem getMessagingSystem() {
		return Activator
				.getDefault()
				.getMessaggingSystem();	
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
	protected IDSLDebugger getDebugger(ILaunchConfiguration configuration,
			DSLDebugEventDispatcher dispatcher, EObject firstInstruction,
			IProgressMonitor monitor) {
		GemocModelDebugger res = new GemocModelDebugger(dispatcher, _engine);
		_engine.setDebugger(res);
		return res;
	}

	@Override
	protected String getDebugTargetName(ILaunchConfiguration configuration, EObject firstInstruction) 
	{
		return "Gemoc debug target";
	}

	@Override
	protected List<IDSLCurrentInstructionListener> getCurrentInstructionListeners() 
	{
		List<IDSLCurrentInstructionListener> result = super.getCurrentInstructionListeners();
		result.add(AbstractGemocDebuggerServices.LISTENER);
		return result;
	}

	@Override
	protected String getDebugJobName(ILaunchConfiguration configuration, EObject firstInstruction) 
	{
		return "Gemoc debug job";
	}

	@Override
	protected String getPluginID() 
	{
		return Activator.PLUGIN_ID;
	}

	@Override
	protected String getModelIdentifier() 
	{
		return MODEL_ID;
	}
}
