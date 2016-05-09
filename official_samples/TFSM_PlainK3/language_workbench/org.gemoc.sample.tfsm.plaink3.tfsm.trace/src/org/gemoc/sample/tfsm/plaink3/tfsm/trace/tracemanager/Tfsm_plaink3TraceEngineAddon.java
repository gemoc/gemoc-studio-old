package org.gemoc.sample.tfsm.plaink3.tfsm.trace.tracemanager;

import fr.inria.diverse.trace.gemoc.traceaddon.AbstractTraceAddon;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class Tfsm_plaink3TraceEngineAddon extends AbstractTraceAddon {

	private Tfsm_plaink3TraceStepFactory factory = null;

	@Override
	public fr.inria.diverse.trace.gemoc.api.IGemocTraceManager constructTraceManager(Resource exeModel,
			Resource traceResource) {
		return new Tfsm_plaink3TraceManager(exeModel, traceResource);
	}

	@Override
	public fr.inria.diverse.trace.gemoc.api.ITraceConstructor constructTraceConstructor(Resource exeModel,
			Resource traceResource) {
		return new Tfsm_plaink3TraceConstructor(exeModel, traceResource);
	}

	@Override
	public fr.inria.diverse.trace.gemoc.api.IGemocTraceManager loadTrace(Resource exeModel, Resource traceResource) {
		Tfsm_plaink3TraceManager manager = new Tfsm_plaink3TraceManager(exeModel, traceResource);
		manager.loadTrace((tfsm_plaink3Trace.Trace) traceResource.getContents().get(0));
		return manager;
	}

	@Override
	public IStepFactory getFactory() {
		if (factory == null)
			factory = new Tfsm_plaink3TraceStepFactory();
		return factory;
	}

	@Override
	public boolean isAddonForTrace(EObject root) {
		return root instanceof tfsm_plaink3Trace.Trace;
	}

}