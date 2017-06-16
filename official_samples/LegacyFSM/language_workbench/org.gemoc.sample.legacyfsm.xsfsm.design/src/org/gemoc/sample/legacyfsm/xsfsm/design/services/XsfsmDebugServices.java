package org.gemoc.sample.legacyfsm.xsfsm.design.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.executionframework.extensions.sirius.services.AbstractGemocDebuggerServices;

public class XsfsmDebugServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();

		res.add(new StringCouple("FSM", "Debug"));
		res.add(new StringCouple("XFSM", "Debug"));

		return res;
	}
	
	@Override
	public String getModelIdentifier() {
		return org.gemoc.execution.sequential.javaengine.ui.Activator.DEBUG_MODEL_ID;
	}
}
