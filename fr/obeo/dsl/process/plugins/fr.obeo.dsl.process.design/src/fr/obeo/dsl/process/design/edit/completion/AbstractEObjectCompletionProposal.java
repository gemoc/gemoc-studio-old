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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * Abstract {@link EObject} {@link ICompletionProposal}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractEObjectCompletionProposal implements ICompletionProposal {

	/**
	 * The proposed {@link EObject}.
	 */
	private final EObject object;

	/**
	 * The {@link ILabelProvider} for display purpose.
	 */
	private final ILabelProvider labelProvider;

	/**
	 * The {@link IRegion region} to replace.
	 */
	private final IRegion replacement;

	/**
	 * The {@link ITextViewer}.
	 */
	private ITextViewer viewer;

	/**
	 * Constructor.
	 * 
	 * @param object
	 *            the {@link EObject} to propose
	 * @param replacement
	 *            the {@link IRegion region} to replace
	 * @param viewer
	 *            the {@link ITextViewer}
	 * @param labelProvider
	 *            the {@link ILabelProvider} for display purpose
	 */
	public AbstractEObjectCompletionProposal(EObject object, IRegion replacement, ITextViewer viewer,
			ILabelProvider labelProvider) {
		this.object = object;
		this.replacement = replacement;
		this.viewer = viewer;
		this.labelProvider = labelProvider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#apply(org.eclipse.jface.text.IDocument)
	 */
	public void apply(IDocument document) {
		try {
			final String proposedText = getProposedText();
			document.replace(replacement.getOffset(), replacement.getLength(), proposedText);
			viewer.setSelectedRange(replacement.getOffset() + proposedText.length(), 0);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the proposed text.
	 * 
	 * @return the proposed text
	 */
	protected abstract String getProposedText();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getSelection(org.eclipse.jface.text.IDocument)
	 */
	public Point getSelection(IDocument document) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAdditionalProposalInfo() {
		return null;
	}

	public String getDisplayString() {
		return labelProvider.getText(object);
	}

	public Image getImage() {
		return labelProvider.getImage(object);
	}

	public IContextInformation getContextInformation() {
		return null;
	}

	/**
	 * Gets the proposed {@link EObject}.
	 * 
	 * @return the proposed {@link EObject}
	 */
	protected EObject getObject() {
		return object;
	}

}
