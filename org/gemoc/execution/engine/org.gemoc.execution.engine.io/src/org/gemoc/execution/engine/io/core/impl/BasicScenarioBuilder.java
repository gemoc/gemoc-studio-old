package org.gemoc.execution.engine.io.core.impl;

import glml.DomainSpecificEvent;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.io.core.ScenarioBuilder;

public abstract class BasicScenarioBuilder extends BasicFrontend implements
		ScenarioBuilder {

	@Override
	public void injectEvent(DomainSpecificEvent dse, EObject target) {
	//	this.engine.injectEvent(dse, target);
	}

}
