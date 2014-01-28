package fr.obeo.dsl.fuml.sirius.ui.action;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractDebugAsAction;
import fr.obeo.dsl.fuml.sirius.ui.launch.FUMLDelegate;

public class FUMLDebugAs extends AbstractDebugAsAction {

	@Override
	protected String getLaunchConfigurationTypeID() {
		return FUMLDelegate.TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(
			Collection<? extends EObject> selections) {
		EObject res = null;

		for (EObject selection : selections) {
			if (FUMLDelegate.isLaunchBehavior(selection)) {
				res = selection;
				break;
			}
		}

		return res;
	}

}
