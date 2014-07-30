/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.process.handler;

import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.ui.handler.AbstractSelectProcessHandler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.gemoc.gemoc_language_workbench.process.Activator;
import org.gemoc.gemoc_language_workbench.process.view.ProcessView;

/**
 * Select a {@link Process} instance.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class SelectProcessHandler extends AbstractSelectProcessHandler {

	@Override
	protected List<IProcessRunner> getProcessRunners(ExecutionEvent event) {
		ArrayList<IProcessRunner> result = new ArrayList<IProcessRunner>();
		for (IProcessRunner runner : ProcessUtils.getRegisteredRunners())
		{
			result.add(runner);
		}
		return result;
		
//		return new ArrayList<ProcessContext>(Activator.getDefault().getProcessDiscovery()getRunner().getContexts());
	}

	@Override
	protected void setProcessRunner(ExecutionEvent event, IProcessRunner processContext) {
		final IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof ProcessView) {
			((ProcessView)part).setProcessRunner(processContext);
		}
	}

}
