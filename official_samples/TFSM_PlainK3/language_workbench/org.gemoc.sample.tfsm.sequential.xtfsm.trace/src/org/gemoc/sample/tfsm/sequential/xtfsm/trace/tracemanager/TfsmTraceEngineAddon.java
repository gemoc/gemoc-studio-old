package org.gemoc.sample.tfsm.sequential.xtfsm.trace.tracemanager;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gemoc.trace.gemoc.api.IStepFactory;
import org.eclipse.gemoc.trace.gemoc.api.ITraceConstructor;
import org.eclipse.gemoc.trace.gemoc.api.ITraceExplorer;
import org.eclipse.gemoc.trace.gemoc.api.ITraceExtractor;
import org.eclipse.gemoc.trace.gemoc.traceaddon.AbstractTraceAddon;

public class TfsmTraceEngineAddon extends AbstractTraceAddon {

	private TfsmTraceStepFactory factory = null;

	@Override
	public ITraceConstructor constructTraceConstructor(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> exeToTraced) {
		return new TfsmTraceConstructor(modelResource, traceResource, exeToTraced);
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource traceResource) {
		TfsmTraceExplorer explorer = new TfsmTraceExplorer();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsmTrace.SpecificTrace) {
			explorer.loadTrace((tfsmTrace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExplorer constructTraceExplorer(Resource modelResource, Resource traceResource,
			Map<EObject, EObject> tracedToExe) {
		TfsmTraceExplorer explorer = new TfsmTraceExplorer(tracedToExe);
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsmTrace.SpecificTrace) {
			explorer.loadTrace(modelResource, (tfsmTrace.SpecificTrace) root);
			return explorer;
		}
		return null;
	}

	@Override
	public ITraceExtractor constructTraceExtractor(Resource traceResource) {
		TfsmTraceExtractor extractor = new TfsmTraceExtractor();
		EObject root = traceResource.getContents().get(0);
		if (root instanceof tfsmTrace.SpecificTrace) {
			extractor.loadTrace((tfsmTrace.SpecificTrace) root);
			return extractor;
		}
		return null;
	}

	@Override
	public IStepFactory getFactory() {
		if (factory == null)
			factory = new TfsmTraceStepFactory();
		return factory;
	}

	@Override
	public boolean isAddonForTrace(EObject root) {
		return root instanceof tfsmTrace.SpecificTrace;
	}

}