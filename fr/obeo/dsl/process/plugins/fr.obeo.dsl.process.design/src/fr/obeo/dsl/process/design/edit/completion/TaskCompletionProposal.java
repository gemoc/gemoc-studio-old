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
package fr.obeo.dsl.process.design.edit.completion;

import fr.obeo.dsl.process.Task;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * {@link org.eclipse.jface.text.contentassist.ICompletionProposal ICompletionProposal} for {@link Task}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TaskCompletionProposal extends AbstractEObjectCompletionProposal {

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the {@link Task} to propose
	 * @param replacement
	 *            the {@link IRegion region} to replace
	 * @param viewer
	 *            the {@link ITextViewer}
	 * @param labelProvider
	 *            the {@link ILabelProvider} for display purpose
	 */
	public TaskCompletionProposal(Task task, IRegion replacement, ITextViewer viewer,
			ILabelProvider labelProvider) {
		super(task, replacement, viewer, labelProvider);
	}

	@Override
	protected Task getObject() {
		return (Task)super.getObject();
	}

	@Override
	public String getAdditionalProposalInfo() {
		return getObject().getDescription();
	}

	@Override
	protected String getProposedText() {
		return "\"" + StringEscapeUtils.escapeJava(getObject().getName()) + "\"";
	}

}
