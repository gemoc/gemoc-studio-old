package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class GemocReflectiveModelLauncherTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public GemocReflectiveModelLauncherTabGroup() 
	{
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { 
				new GemocModelLauncherMainTab(),
                new ModelLauncherBackendsTab(),
                new ModelLauncherFrontendsTab(),
                new CommonTab()
		};
		setTabs(tabs);
	}

}
