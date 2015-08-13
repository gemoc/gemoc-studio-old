/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.ccslmocc.model.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

/**
 * @author Stfun
 *
 */
public class DeleteNotAllowed implements IExternalJavaAction {

	/**
	 * 
	 */
	public DeleteNotAllowed() {}

	/* (non-Javadoc)
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> selections,
			Map<String, Object> parameters) {
		MessageDialog.openError(getShell(), "Illegal action", "External library elements cannot be deleted.");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> selections) {
		 return !selections.isEmpty();
	}
	
	protected Shell getShell() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		return page.getActiveEditor().getSite().getShell();
	}

}
