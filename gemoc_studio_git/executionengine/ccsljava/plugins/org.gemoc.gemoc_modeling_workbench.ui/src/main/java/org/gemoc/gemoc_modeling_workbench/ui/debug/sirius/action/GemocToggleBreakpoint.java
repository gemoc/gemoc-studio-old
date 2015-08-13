package org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_modeling_workbench.ui.breakpoint.GemocBreakpoint;
import org.gemoc.gemoc_modeling_workbench.ui.launcher.Launcher;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.sirius.ui.DSLToggleBreakpointsUtils;
import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractToggleBreakpointAction;

public class GemocToggleBreakpoint extends AbstractToggleBreakpointAction {

	@Override
	protected String getModelIdentifier() {
		return Launcher.MODEL_ID;
	}

	@Override
	protected DSLToggleBreakpointsUtils createToggleBreakpointsUtils() {
		return new DSLToggleBreakpointsUtils(getModelIdentifier()){
			
			@Override
			protected DSLBreakpoint createBreakpoint(Object selected,
					EObject instruction) throws CoreException {
				return new GemocBreakpoint(identifier, instruction, true);
			}
			
		};
	}
	
}
