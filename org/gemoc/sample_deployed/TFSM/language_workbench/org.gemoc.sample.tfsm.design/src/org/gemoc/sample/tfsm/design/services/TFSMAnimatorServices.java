package org.gemoc.sample.tfsm.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.extensions.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices.StringCouple;

public class TFSMAnimatorServices extends AbstractGemocAnimatorServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		res.add(new StringCouple("TrafficControl","Debug"));
		res.add(new StringCouple("Semaphore","Debug"));

		res.add(new StringCouple("TrafficControl","Animation"));
		res.add(new StringCouple("Semaphore","Animation"));
		
		//res.add(new StringCouple("TFSM","Animator"));
		
		return res;
	}

}
