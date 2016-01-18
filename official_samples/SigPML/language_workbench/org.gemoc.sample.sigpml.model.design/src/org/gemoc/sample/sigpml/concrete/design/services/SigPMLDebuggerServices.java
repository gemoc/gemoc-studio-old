package org.gemoc.sample.sigpml.concrete.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.executionframework.extensions.sirius.services.AbstractGemocDebuggerServices;

public class SigPMLDebuggerServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		// indicates which diagrams need to be updated on debugger changes
		res.add(new StringCouple("SigPML","SigPMLDebug"));
		
		return res;
	}
	
	@Override
	public String getModelIdentifier() {
		return org.gemoc.execution.concurrent.ccsljavaengine.ui.Activator.PLUGIN_ID+".debugModel";
	}
}
