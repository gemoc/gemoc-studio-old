package org.gemoc.sample.legacyfsm.xsfsm.trace.tracemanager;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.trace.gemoc.api.IStepFactory;
import fr.inria.diverse.trace.gemoc.api.ITraceConstructor;
import fr.inria.diverse.trace.gemoc.api.ITraceExplorer;
import fr.inria.diverse.trace.gemoc.api.ITraceExtractor;
import fr.inria.diverse.trace.gemoc.traceaddon.AbstractTraceAddon;

public class FsmTraceEngineAddon extends AbstractTraceAddon {

	private FsmTraceStepFactory factory = null;

	@Override
	public ITraceConstructor constructTraceConstructor(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> exeToTraced) {
		return new FsmTraceConstructor(modelResource, traceResource, exeToTraced);
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource traceResource) {
		FsmTraceExplorer explorer = new FsmTraceExplorer();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof fsmTrace.SpecificTrace) {
			explorer.loadTrace((fsmTrace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> tracedToExe) {
		FsmTraceExplorer explorer = new FsmTraceExplorer(tracedToExe);
		EObject root = traceResource.getContents().get(0);
		if (root instanceof fsmTrace.SpecificTrace) {
			explorer.loadTrace(modelResource, (fsmTrace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExtractor constructTraceExtractor(Resource traceResource) {
		FsmTraceExtractor extractor = new FsmTraceExtractor();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof fsmTrace.SpecificTrace) {
			extractor.loadTrace((fsmTrace.SpecificTrace) root);
			return extractor;
		}
		return null;
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