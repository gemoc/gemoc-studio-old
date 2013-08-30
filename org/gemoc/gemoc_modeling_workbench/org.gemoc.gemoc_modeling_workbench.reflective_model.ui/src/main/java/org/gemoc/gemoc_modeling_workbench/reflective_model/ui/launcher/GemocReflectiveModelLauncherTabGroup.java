package org.gemoc.gemoc_modeling_workbench.reflective_model.ui.launcher;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class GemocReflectiveModelLauncherTabGroup extends
		AbstractLaunchConfigurationTabGroup {

	public GemocReflectiveModelLauncherTabGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { 
				//new KermetaTabConfiguration(),
                new CommonTab()
		};
		setTabs(tabs);
	}

}
