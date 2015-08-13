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
package org.gemoc.gemoc_language_workbench.dashboard;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.gemoc.gemoc_language_workbench.dashboard.action.OpenDashboardAction;

public class OpenDashboard extends CommonActionProvider {
	/**
	 * Action used to open a Gemoc Dashboard.
	 */
	private OpenDashboardAction _openDashboardAction;

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#dispose()
	 */
	@Override
	public void dispose() {
		ISelectionProvider selectionProvider = getActionSite().getViewSite().getSelectionProvider();
		if (null != _openDashboardAction) {
			selectionProvider.removeSelectionChangedListener(_openDashboardAction);
			_openDashboardAction = null;
		}
		super.dispose();
	}

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
	 */
	@Override
	public void fillActionBars(IActionBars actionBars_p) {
		// Do nothing.
	}

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	@Override
	public void fillContextMenu(IMenuManager menuManager) {
		ISelection selection = getContext().getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection)selection).size() == 1) {
			Object object = ((IStructuredSelection)selection).getFirstElement();
			if (object instanceof IFile) {
				IFile file = (IFile)object;
				menuManager.add(new OpenDashboardAction(file));
			}
		}
		// updateActionBars();
		// menu_p.appendToGroup(ICommonMenuConstants.GROUP_OPEN, _openDashboardAction);
	}

	/**
	 * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite site) {
		super.init(site);
		// SelectionHelper.registerToSelectionChanges(_openDashboardAction, selectionProvider);
	}

	/**
	 * @see org.eclipse.ui.actions.ActionGroup#updateActionBars()
	 */
	@Override
	public void updateActionBars() {
		// IStructuredSelection selection = (IStructuredSelection)getContext().getSelection();
		// _openDashboardAction.selectionChanged(selection);
	}
}
