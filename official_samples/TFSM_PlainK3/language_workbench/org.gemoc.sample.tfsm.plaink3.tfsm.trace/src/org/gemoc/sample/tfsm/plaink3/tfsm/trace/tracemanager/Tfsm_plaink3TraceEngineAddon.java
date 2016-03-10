package org.gemoc.sample.tfsm.plaink3.tfsm.trace.tracemanager;

import fr.inria.diverse.trace.gemoc.traceaddon.AbstractTraceAddon;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

import org.eclipse.emf.ecore.resource.Resource;

public class Tfsm_plaink3TraceEngineAddon extends AbstractTraceAddon {

	@Override
	public fr.inria.diverse.trace.gemoc.api.IGemocTraceManager constructTraceManager(Resource exeModel,
			Resource traceResource) {
		return new Tfsm_plaink3TraceManager(exeModel, traceResource);
	}

	private Tfsm_plaink3TraceStepFactory factory = null;

	@Override
	public IStepFactory getFactory() {
		if (factory == null)
			factory = new Tfsm_plaink3TraceStepFactory();
		return factory;
	}

}