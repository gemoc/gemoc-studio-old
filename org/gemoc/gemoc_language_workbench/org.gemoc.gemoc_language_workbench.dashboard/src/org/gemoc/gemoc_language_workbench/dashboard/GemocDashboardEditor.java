/*******************************************************************************
 * Copyright (c) 2015 Obeo. All Rights Reserved.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;

public class GemocDashboardEditor extends SharedHeaderFormEditor {
	/**
	 * Editor ID.
	 */
	public static final String ID = "org.gemoc.gemoc_language_workbench.dashboard.editor"; //$NON-NLS-1$

	public GemocDashboardEditor() {

	}

	@Override
	protected void addPages() {
		try {
			addPage(new GemocOverviewDashboardPage(this));
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public String getPartName() {
		if (getEditorInput() != null) {
			return getEditorInput().getName() + " - Gemoc Dashboard";
		}
		return super.getPartName();
	}
}
