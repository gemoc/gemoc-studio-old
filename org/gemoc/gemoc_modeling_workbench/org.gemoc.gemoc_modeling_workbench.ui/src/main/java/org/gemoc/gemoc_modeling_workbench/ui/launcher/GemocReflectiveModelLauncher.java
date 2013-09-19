package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.gemoc.gemoc_modeling_workbench.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.ui.launcher.minitestengine.MiniEngine;

public class GemocReflectiveModelLauncher implements
		ILaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		Activator.getDefault().getMessaggingSystem().showConsole();
		Activator.getDefault().getMessaggingSystem().warn("Run Gemoc Model using MiniEngine for test, need to connect the real generic execution engine here","");
		String modelPath = configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_MODEL_PATH,"");
		String languageName = configuration.getAttribute(GemocModelLauncherConfigurationConstants.LAUNCH_SELECTED_LANGUAGE,"");
		
		
		MiniEngine engine = new MiniEngine(languageName);
		engine.launchEngine(modelPath);

	}

}
