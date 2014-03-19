package org.gemoc.execution.engine.io.core;

import glml.DomainSpecificEvent;

import org.eclipse.emf.ecore.EObject;

public interface ScenarioBuilder extends Frontend {
	public void injectEvent(DomainSpecificEvent dse, EObject target);
}
