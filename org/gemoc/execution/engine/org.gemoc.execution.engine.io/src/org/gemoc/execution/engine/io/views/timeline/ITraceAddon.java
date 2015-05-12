package org.gemoc.execution.engine.io.views.timeline;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public interface ITraceAddon extends IEngineAddon{

	void goTo(EObject o1);
	
	void goTo(int i);

}
