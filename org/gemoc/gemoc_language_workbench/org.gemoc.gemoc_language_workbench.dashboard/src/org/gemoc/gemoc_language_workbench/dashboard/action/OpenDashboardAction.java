/*******************************************************************************
 * Copyright (c) 2006, 2014 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.gemoc.gemoc_language_workbench.dashboard.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.gemoc.gemoc_language_workbench.dashboard.GemocDashboardActivator;
import org.gemoc.gemoc_language_workbench.dashboard.GemocDashboardEditor;
import org.gemoc.gemoc_language_workbench.dashboard.GemocDashboardEditorInput;
import org.gemoc.gemoc_language_workbench.dashboard.utils.IImageKeys;

/**
 * Open Gemoc Dashboard for current xdsml file (if related session is open).
 */
public class OpenDashboardAction extends BaseSelectionListenerAction {

	IFile file = null;

	/**
	 * Constructor.
	 */
	public OpenDashboardAction(IFile file) {
		super("Gemoc Dashboard");
		setImageDescriptor(GemocDashboardActivator.getDefault().getImageDescriptor(IImageKeys.IMG_OVERVIEW));
		this.file = file;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		// Open dashboard
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			page.openEditor(new GemocDashboardEditorInput(file), GemocDashboardEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
