package org.gemoc.execution.engine.io.views.timeline;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.diverse.trace.api.ITraceManager;

public interface ITraceAddon extends IEngineAddon{

	ITraceManager getTraceManager();

	void goTo(EObject o1);

}
