package org.gemoc.sigpml.concrete.design.services;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_modeling_workbench.ui.debug.sirius.services.AbstractGemocDebuggerServices;

public class SigPMLDebuggerServices extends AbstractGemocDebuggerServices {

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		// indicates which diagrams need to be updated on debugger changes
		res.add(new StringCouple("SigPML","SigPMLDebug"));
		
		return res;
	}
	
}
