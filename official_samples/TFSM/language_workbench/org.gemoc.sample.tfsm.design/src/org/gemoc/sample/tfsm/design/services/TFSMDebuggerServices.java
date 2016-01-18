package org.gemoc.sample.tfsm.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.executionframework.extensions.sirius.services.AbstractGemocDebuggerServices;


public class TFSMDebuggerServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		res.add(new StringCouple("TimedSystem","Debug"));
		res.add(new StringCouple("TFSM","Debug"));
		
		return res;
	}

	@Override
	public String getModelIdentifier() {
		return org.gemoc.execution.concurrent.ccsljavaengine.ui.Activator.PLUGIN_ID+".debugModel";
	}
	
}
