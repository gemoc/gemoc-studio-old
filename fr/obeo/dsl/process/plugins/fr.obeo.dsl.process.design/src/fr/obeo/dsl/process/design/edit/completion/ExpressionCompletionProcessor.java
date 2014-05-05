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

import fr.obeo.dsl.process.ExpressionParser;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.viewers.ILabelProvider;

/**
 * {@link fr.obeo.dsl.process.Expression Expression} {@link IContentAssistProcessor}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExpressionCompletionProcessor implements IContentAssistProcessor {

	/**
	 * {@link fr.obeo.dsl.process.Expression Expression} {@link EClass}.
	 */
	private static final EClass[] EXPRESSIONS = new EClass[] {ProcessPackage.eINSTANCE.getAllDone(),
			ProcessPackage.eINSTANCE.getAnyDone(), ProcessPackage.eINSTANCE.getOneDone(),
			ProcessPackage.eINSTANCE.getNot(), ProcessPackage.eINSTANCE.getAnd(),
			ProcessPackage.eINSTANCE.getOr(), };

	/**
	 * The {@link ExpressionParser} used to parse the text.
	 */
	private final ExpressionParser parser;

	/**
	 * The {@link ILabelProvider} for display purpose.
	 */
	private final ILabelProvider labelProvider;

	/**
	 * Constructor.
	 * 
	 * @param task
	 *            the {@link Task} to edit
	 * @param eReference
	 *            the {@link EReference} to edit, either
	 *            {@link fr.obeo.dsl.process.ProcessPackage#getTask_Precondition() precondition} or
	 *            {@link fr.obeo.dsl.process.ProcessPackage#getComposedTask_DoneExpression()done expression}
	 * @param labelProvider
	 *            the {@link ILabelProvider} for display purpose
	 */
	public ExpressionCompletionProcessor(Task task, EReference eReference, ILabelProvider labelProvider) {
		parser = new ExpressionParser();
		parser.setPossibleTasks(ProcessUtils.getPossibleTasks(task, eReference));
		this.labelProvider = labelProvider;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		final List<ICompletionProposal> res = new ArrayList<ICompletionProposal>();

		final String text = viewer.getTextWidget().getText().substring(0, offset);
		parser.setText(text);
		try {
			parser.readExpression();
		} catch (IllegalStateException e) {
			// nothing to do here
		}

		if (parser.getEReference().getEType() == ProcessPackage.eINSTANCE.getExpression()
				|| parser.getEReference() == null) {
			final IRegion replacement = getReplacementForExpression(viewer.getTextWidget().getText(), parser
					.getLastStart());
			for (EClass exp : EXPRESSIONS) {
				res.add(new ExpressionCompletionProposal(exp, replacement, viewer, labelProvider));
			}
		} else if (parser.getEReference().getEType() == ProcessPackage.eINSTANCE.getTask()) {
			final IRegion replacement = getReplacementForTask(viewer.getTextWidget().getText(), parser
					.getLastStart());
			for (Task task : parser.getPossibleTasks()) {
				res.add(new TaskCompletionProposal(task, replacement, viewer, labelProvider));
			}
		} else {
			throw new IllegalStateException("don't know what to do with "
					+ parser.getEReference().getEType().getName());
		}

		return res.toArray(new ICompletionProposal[res.size()]);
	}

	/**
	 * Gets the {@link IRegion region} to be replaced for an {@link fr.obeo.dsl.process.Expression Expression}
	 * .
	 * 
	 * @param text
	 *            the text to analyze
	 * @param lastStart
	 *            the last position the parser started to parse an {@link fr.obeo.dsl.process.Expression
	 *            Expression} or a {@link Task#getName() task reference}
	 * @return the {@link IRegion region} to by replaced
	 */
	private IRegion getReplacementForExpression(String text, int lastStart) {
		int end = lastStart;

		while (end < text.length() && text.charAt(end) != ',' && text.charAt(end) != ')'
				&& text.charAt(end) != '"') {
			++end;
		}

		return new Region(lastStart, end - lastStart);
	}

	/**
	 * Gets the {@link IRegion region} to be replaced for a {@link Task}.
	 * 
	 * @param text
	 *            the text to analyze
	 * @param lastStart
	 *            the last position the parser started to parse an {@link fr.obeo.dsl.process.Expression
	 *            Expression} or a {@link Task#getName() task reference}
	 * @return the {@link IRegion region} to by replaced
	 */
	private IRegion getReplacementForTask(String text, int lastStart) {
		int end = lastStart;

		if (end < text.length() && text.charAt(end) == '"') {
			end = lastStart + 1;
		}

		while (end < text.length() && text.charAt(end) != '"' && text.charAt(end) != ','
				&& text.charAt(end) != ')') {
			if (text.charAt(end) == '\\') {
				++end;
			}
			++end;
		}

		if (end < text.length() && text.charAt(end) == '"') {
			++end;
		}

		return new Region(lastStart, end - lastStart);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer,
	 *      int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] {'(', '"', ',', };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}
