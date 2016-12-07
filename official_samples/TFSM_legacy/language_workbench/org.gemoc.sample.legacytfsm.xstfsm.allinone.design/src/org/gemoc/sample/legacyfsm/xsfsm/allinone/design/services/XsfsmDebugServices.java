package org.gemoc.sample.legacyfsm.xsfsm.allinone.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.sequential.javaengine.ui.Activator;
import org.gemoc.executionframework.extensions.sirius.services.AbstractGemocDebuggerServices;

public class XsfsmDebugServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();

		res.add(new StringCouple("TimeFSM_AllInOne", "Debug"));

		return res;
	}

	@Override
	public String getModelIdentifier() {
		return Activator.DEBUG_MODEL_ID;
	}

}
