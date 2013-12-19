package org.gemoc.execution.engine.io.core.impl;

import glml.DomainSpecificEvent;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.io.core.ScenarioBuilder;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;

public abstract class BasicScenarioBuilder extends BasicFrontend implements
		ScenarioBuilder {

	@Override
	public void injectEvent(DomainSpecificEvent dse, EObject target)
			throws EventInjectionException {
		this.engine.injectEvent(dse, target);
	}

}
