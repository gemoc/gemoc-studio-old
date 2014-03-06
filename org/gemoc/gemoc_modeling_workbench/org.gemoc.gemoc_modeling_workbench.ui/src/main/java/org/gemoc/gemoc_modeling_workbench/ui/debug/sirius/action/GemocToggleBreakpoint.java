package org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action;

import org.gemoc.gemoc_modeling_workbench.ui.launcher.GemocReflectiveModelLauncher;

import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractToggleBreakpointAction;

public class GemocToggleBreakpoint extends AbstractToggleBreakpointAction {

	@Override
	protected String getModelIdentifier() {
		return GemocReflectiveModelLauncher.MODEL_ID;
	}

}
