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
package org.gemoc.gemoc_language_workbench.dashboard.action;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.dashboard.GemocDashboardActivator;
import org.gemoc.gemoc_language_workbench.dashboard.utils.IImageKeys;

public class FilterTreeAction extends Action {
	/**
	 * Shell used as parent of the popup dialog.
	 */
	private Shell shell;

	private Object object;

	private TreeViewer viewer;

	public FilterTreeAction(TreeViewer viewer, EObject eObject, Shell shell) {
		setText("Synchronize");
		setImageDescriptor(GemocDashboardActivator.getDefault().getImageDescriptor(
				IImageKeys.IMG_SYNCRONIZE_VIEWER));
		this.shell = shell;
		this.object = eObject;
		this.viewer = viewer;
	}

	public FilterTreeAction(TreeViewer viewer, List list, Shell shell) {
		setText("Synchronize");
		setImageDescriptor(GemocDashboardActivator.getDefault().getImageDescriptor(
				IImageKeys.IMG_SYNCRONIZE_VIEWER));
		this.shell = shell;
		this.object = list;
		this.viewer = viewer;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		System.out.println("Synchronize");
		viewer.setInput(object);
	}
}
