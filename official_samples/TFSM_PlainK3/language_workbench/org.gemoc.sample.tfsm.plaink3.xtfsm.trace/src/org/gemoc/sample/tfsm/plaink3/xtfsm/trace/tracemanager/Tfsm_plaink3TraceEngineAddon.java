package org.gemoc.sample.tfsm.plaink3.xtfsm.trace.tracemanager;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.trace.gemoc.api.IStepFactory;
import fr.inria.diverse.trace.gemoc.api.ITraceConstructor;
import fr.inria.diverse.trace.gemoc.api.ITraceExplorer;
import fr.inria.diverse.trace.gemoc.api.ITraceExtractor;
import fr.inria.diverse.trace.gemoc.traceaddon.AbstractTraceAddon;

public class Tfsm_plaink3TraceEngineAddon extends AbstractTraceAddon {

	private Tfsm_plaink3TraceStepFactory factory = null;

	@Override
	public ITraceConstructor constructTraceConstructor(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> exeToTraced) {
		return new Tfsm_plaink3TraceConstructor(modelResource, traceResource, exeToTraced);
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource traceResource) {
		Tfsm_plaink3TraceExplorer explorer = new Tfsm_plaink3TraceExplorer();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsm_plaink3Trace.SpecificTrace) {
			explorer.loadTrace((tfsm_plaink3Trace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> tracedToExe) {
		Tfsm_plaink3TraceExplorer explorer = new Tfsm_plaink3TraceExplorer(tracedToExe);
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsm_plaink3Trace.SpecificTrace) {
			explorer.loadTrace(modelResource, (tfsm_plaink3Trace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExtractor constructTraceExtractor(Resource traceResource) {
		Tfsm_plaink3TraceExtractor extractor = new Tfsm_plaink3TraceExtractor();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsm_plaink3Trace.SpecificTrace) {
			extractor.loadTrace((tfsm_plaink3Trace.SpecificTrace) root);
			return extractor;
		}
		return null;
	}

	@Override
	public IStepFactory getFactory() {
		if (factory == null)
			factory = new Tfsm_plaink3TraceStepFactory();
		return factory;
	}

	@Override
	public boolean isAddonForTrace(EObject root) {
		return root instanceof tfsm_plaink3Trace.SpecificTrace;
	}

}