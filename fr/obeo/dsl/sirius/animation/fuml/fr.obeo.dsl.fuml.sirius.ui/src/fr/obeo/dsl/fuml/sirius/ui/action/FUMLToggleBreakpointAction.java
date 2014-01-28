package fr.obeo.dsl.fuml.sirius.ui.action;


import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractToggleBreakpointAction;
import fr.obeo.dsl.fuml.sirius.ui.launch.FUMLDelegate;

public class FUMLToggleBreakpointAction extends AbstractToggleBreakpointAction {

	@Override
	protected String getModelIdentifier() {
		return FUMLDelegate.MODEL_ID;
	}

}
