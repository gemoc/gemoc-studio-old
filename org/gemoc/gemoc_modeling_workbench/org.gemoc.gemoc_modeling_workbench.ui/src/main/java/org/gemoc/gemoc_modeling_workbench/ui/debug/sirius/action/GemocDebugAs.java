package org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.action;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.gemoc_modeling_workbench.ui.launcher.GemocReflectiveModelLauncher;

import fr.obeo.dsl.debug.ide.sirius.ui.action.AbstractDebugAsAction;

public class GemocDebugAs extends AbstractDebugAsAction {

	@Override
	protected String getLaunchConfigurationTypeID() {
		return GemocReflectiveModelLauncher.TYPE_ID;
	}

	@Override
	protected EObject getFirstInstruction(
			Collection<? extends EObject> selections) {
		return EcorePackage.eINSTANCE;
	}
	
}
