package org.gemoc.gemoc_modeling_workbench.ui;

import org.eclipse.ui.IStartup;

public class ModelingWorkbenchEarlyStartup implements IStartup {

	@Override
	public void earlyStartup() {
		//nothing to do except making sure this plugin is started
		// because PropertyTester seems to be fully activated only when the containing plugin is started

	}

}
