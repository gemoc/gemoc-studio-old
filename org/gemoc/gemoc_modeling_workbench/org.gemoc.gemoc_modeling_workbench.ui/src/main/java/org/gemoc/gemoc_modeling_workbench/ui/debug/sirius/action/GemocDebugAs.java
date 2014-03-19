package org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action;

import org.gemoc.gemoc_modeling_workbench.ui.launcher.GemocReflectiveModelLauncher;

import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractDebugAsAction;

public class GemocDebugAs extends AbstractDebugAsAction {

	@Override
	protected String getLaunchConfigurationTypeID() {
		return GemocReflectiveModelLauncher.TYPE_ID;
	}
	
}
