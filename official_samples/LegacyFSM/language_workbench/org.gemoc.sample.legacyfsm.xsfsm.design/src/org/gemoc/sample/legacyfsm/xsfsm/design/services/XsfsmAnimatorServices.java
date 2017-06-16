package org.gemoc.sample.legacyfsm.xsfsm.design.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.executionframework.extensions.sirius.services.AbstractGemocAnimatorServices;

public class XsfsmAnimatorServices extends AbstractGemocAnimatorServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();

		res.add(new StringCouple("FSM", "Animation"));
		res.add(new StringCouple("XFSM", "Animation"));

		return res;
	}

}
