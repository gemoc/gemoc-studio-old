package org.gemoc.sample.legacyfsm.xsfsm.trace.tracemanager;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.trace.commons.model.trace.State;
import fr.inria.diverse.trace.gemoc.api.IStateManager;
import fr.inria.diverse.trace.gemoc.api.IStepFactory;
import fr.inria.diverse.trace.commons.model.trace.TracedObject;
import fr.inria.diverse.trace.gemoc.api.ITraceConstructor;
import fr.inria.diverse.trace.gemoc.traceaddon.AbstractTraceAddon;

public class FsmTraceEngineAddon extends AbstractTraceAddon {

	private FsmTraceStepFactory factory = null;

	@Override
	public ITraceConstructor constructTraceConstructor(Resource modelResource, Resource traceResource,
			Map<EObject, TracedObject<?>> exeToTraced) {
		return new FsmTraceConstructor(modelResource, traceResource, exeToTraced);
	}

	@Override
	public IStateManager<State<?, ?>> constructStateManager(Resource modelResource,
			Map<TracedObject<?>, EObject> tracedToExe) {
		return new FsmTraceStateManager(modelResource, tracedToExe);
	}

	@Override
	public IStepFactory getFactory() {
		if (factory == null)
			factory = new FsmTraceStepFactory();
		return factory;
	}

	@Override
	public boolean isAddonForTrace(EObject root) {
		return root instanceof fsmTrace.SpecificTrace;
	}

}