package fr.obeo.dsl.fuml.sirius.ui.services;

import java.util.ArrayList;
import java.util.List;


import fr.obeo.dsl.debug.ide.sirius.ui.services.AbstractDSLDebuggerServices;
import fr.obeo.dsl.fuml.sirius.ui.launch.FUMLDelegate;

public class DSLDebuggerServices extends AbstractDSLDebuggerServices {

	@Override
	public String getModelIdentifier() {
		return FUMLDelegate.MODEL_ID;
	}

	@Override
	protected List<StringCouple> getRepresentationRefreshList() {
		final List<StringCouple> res = new ArrayList<StringCouple>();
		
		res.add(new StringCouple("Activity Diagram","UML fUML Debug"));
		
		return res;
	}

	
	
}
