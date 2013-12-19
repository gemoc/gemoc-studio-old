package org.gemoc.execution.engine.io.core;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;

public interface ScenarioBuilder extends Frontend {
	public void injectEvent(DomainSpecificEvent dse, EObject target)
			throws EventInjectionException;
}
