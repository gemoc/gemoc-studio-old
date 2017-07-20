/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.sigpml.concrete.design.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gemoc.executionframework.extensions.sirius.services.AbstractGemocDebuggerServices;

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
		return org.eclipse.gemoc.execution.concurrent.ccsljavaengine.ui.Activator.PLUGIN_ID+".debugModel";
	}
}
