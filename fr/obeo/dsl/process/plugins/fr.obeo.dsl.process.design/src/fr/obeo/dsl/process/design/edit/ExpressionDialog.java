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
package fr.obeo.dsl.process.design.edit;

import fr.obeo.dsl.process.Expression;
import fr.obeo.dsl.process.ExpressionParser;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.design.edit.completion.ExpressionCompletionProcessor;
import fr.obeo.dsl.process.provider.CustomProcessItemProviderAdapterFactory;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * A dialog for {@link Expression} editing.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExpressionDialog extends MessageDialog {

	/**
	 * The {@link Task} to edit.
	 */
	private Task task;

	/**
	 * The {@link EReference} to edit, either
	 * {@link fr.obeo.dsl.process.ProcessPackage#getTask_Precondition() precondition} or
	 * {@link fr.obeo.dsl.process.ProcessPackage#getComposedTask_DoneExpression()done expression}.
	 */
	private EReference eReference;

	/**
	 * {@link Task} reference {@link Color}.
	 */
	private final Color taskRefColor;

	/**
	 * {@link Expression} {@link Color}.
	 */
	private final Color expressionColor;

	/**
	 * Punctuation {@link Color}.
	 */
	private final Color punctuationColor;

	/**
	 * The {@link ISourceViewer} to edit the {@link Expression}.
	 */
	private ISourceViewer viewer;

	/**
	 * The {@link ExpressionParser}.
	 */
	private final ExpressionParser parser;

	/**
	 * The {@link ComposedAdapterFactory} for display purpose.
	 */
	private final ComposedAdapterFactory adapterFactory;

	/**
	 * The resulting {@link Expression}.
	 */
	private Expression expression;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent {@link Shell}
	 * @param task
	 *            the {@link Task} to edit
	 * @param eReference
	 *            the {@link EReference} to edit, either
	 *            {@link fr.obeo.dsl.process.ProcessPackage#getTask_Precondition() precondition} or
	 *            {@link fr.obeo.dsl.process.ProcessPackage#getComposedTask_DoneExpression()done expression}
	 */
	public ExpressionDialog(Shell parent, Task task, EReference eReference) {
		super(parent, "Edit Expression", null, "", MessageDialog.CONFIRM, new String[] {
				IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL, }, 0);

		this.task = task;
		this.eReference = eReference;
		parser = new ExpressionParser();
		parser.setPossibleTasks(ProcessUtils.getPossibleTasks(task, eReference));
		expression = (Expression)task.eGet(eReference);

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new CustomProcessItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// CHECKSTYLE:OFF
		taskRefColor = new Color(parent.getDisplay(), 53, 53, 191);
		expressionColor = new Color(parent.getDisplay(), 127, 0, 85);
		punctuationColor = new Color(parent.getDisplay(), 0, 0, 0);
		// CHECKSTYLE:ON
	}

	@Override
	public Image getImage() {
		return null;
	}

	@Override
	protected Point getInitialSize() {
		final Point res = super.getInitialSize();

		res.y = res.y * 4;

		return res;
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		final GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);

		viewer = new SourceViewer(parent, null, SWT.NONE);
		viewer.configure(new ExpressionSourceViewerConfiguration());
		viewer.getTextWidget().setLayoutData(gridData);
		viewer.setDocument(new Document());
		if (expression != null) {
			viewer.getTextWidget().setText(ExpressionParser.toString(expression));
		}
		final ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(new ExpressionCompletionProcessor(task, eReference,
				new AdapterFactoryLabelProvider(adapterFactory)), IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.setInformationControlCreator(new IInformationControlCreator() {
			public IInformationControl createInformationControl(Shell parent) {
				return new DefaultInformationControl(parent);
			}
		});
		assistant.install(viewer);

		final PresentationReconciler reconciler = new PresentationReconciler();
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(new ExpressionPartitionScanner(taskRefColor,
				expressionColor, punctuationColor));
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		reconciler.install(viewer);

		viewer.addTextInputListener(new ITextInputListener() {

			public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
				if (newInput != null) {
					parser.setText(newInput.get());
					parse();
				}
			}

			public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
				// nothing to do here
			}
		});
		viewer.addTextListener(new ITextListener() {

			public void textChanged(TextEvent event) {
				parser.setText(viewer.getDocument().get());
				parse();
			}
		});

		return viewer.getTextWidget();
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		final Control res = super.createButtonBar(parent);

		parser.setText(viewer.getDocument().get());
		parse();

		return res;
	}

	/**
	 * Parses.
	 */
	private void parse() {
		if (parser.getText() != null && parser.getText().length() != 0) {
			try {
				expression = parser.readExpression();
				message = "";
				messageLabel.setText(message);
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			} catch (IllegalStateException e) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				message = e.getMessage();
				messageLabel.setText(message);
			}
		} else {
			expression = null;
			message = "";
			messageLabel.setText(message);
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		}
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (IDialogConstants.OK_ID == buttonId) {
			okPressed();
		} else if (IDialogConstants.CANCEL_ID == buttonId) {
			cancelPressed();
		} else {
			super.buttonPressed(buttonId);
		}
	}

	@Override
	protected void okPressed() {
		task.eSet(eReference, expression);
		super.okPressed();
	}

	@Override
	public boolean close() {
		final boolean res = super.close();

		taskRefColor.dispose();
		expressionColor.dispose();
		punctuationColor.dispose();

		adapterFactory.dispose();

		return res;
	}
}
