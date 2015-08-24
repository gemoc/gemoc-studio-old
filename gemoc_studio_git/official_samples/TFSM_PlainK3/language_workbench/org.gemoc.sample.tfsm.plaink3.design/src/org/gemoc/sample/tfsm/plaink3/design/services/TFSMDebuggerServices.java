package org.gemoc.sample.tfsm.plaink3.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocDebuggerServices;

public class TFSMDebuggerServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		res.add(new StringCouple("TimedSystem","Debug"));
		res.add(new StringCouple("TFSM","Debug"));
		
		return res;
	}
	
}
