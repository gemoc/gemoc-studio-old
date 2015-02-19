package org.gemoc.execution.engine.commons.trace;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public interface IAddon extends IEngineAddon 
{

	Resource getResource();
	
}
