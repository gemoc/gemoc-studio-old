package org.gemoc.sample.tfsm.purek3.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocAnimatorServices;
import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices.StringCouple;

public class TFSMAnimatorServices extends AbstractGemocAnimatorServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		res.add(new StringCouple("TFSM","Animatation"));
		
		return res;
	}

}
