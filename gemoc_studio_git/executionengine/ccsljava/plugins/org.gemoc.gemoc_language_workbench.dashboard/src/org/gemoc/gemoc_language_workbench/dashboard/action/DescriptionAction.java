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

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;
import org.gemoc.gemoc_language_workbench.dashboard.GemocDashboardActivator;
import org.gemoc.gemoc_language_workbench.dashboard.utils.FileHelper;
import org.gemoc.gemoc_language_workbench.dashboard.utils.IImageKeys;

public class DescriptionAction extends Action {
	/**
	 * Shell used as parent of the popup dialog.
	 */
	private Shell shell;

	private String descriptionRelativePath = null;

	public DescriptionAction(String descriptionRelativePath, Shell shell) {
		setText("Description");
		setImageDescriptor(GemocDashboardActivator.getDefault().getImageDescriptor(
				IImageKeys.IMG_DESCRIPTOR_DESCRIPTION));
		this.shell = shell;
		this.descriptionRelativePath = descriptionRelativePath;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		String descriptionContent = FileHelper.readFile(GemocDashboardActivator.getDefault().getPluginId()
				+ "/" + descriptionRelativePath);
		new DescriptionDialog(shell, descriptionContent).open();
	}
}
