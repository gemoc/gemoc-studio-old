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
package org.gemoc.mocc.fsmkernel.model.design.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.expressions.Expression;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.commands.ActionHandler;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.ActiveShellExpression;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.actions.TextViewerAction;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.gemoc.mocc.fsmkernel.model.design.edit.OperationHistoryListener;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Attempt to add undo/redo management for the pop-up editor, 
 * useless until...
 * FIXME
 * @author creffst
 * 
 */
public class PopupXTextEditorActionSupport {
	
	private OperationHistoryListener operationHistoryListener;
	
	private XtextSourceViewer viewer;
	
	public PopupXTextEditorActionSupport(XtextSourceViewer sourceViewer) {
		this.viewer = sourceViewer;
	}

	public void installUndoRedoSupport() {
		IDocumentUndoManager undoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(viewer.getDocument());
		final IUndoContext context = undoManager.getUndoContext();
		IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory() ;
		operationHistoryListener = new OperationHistoryListener(context, new IUpdate() {
			public void update() {
				updateAction(ITextEditorActionConstants.REDO);
				updateAction(ITextEditorActionConstants.UNDO);
			}
		});
		operationHistory.addOperationHistoryListener(operationHistoryListener);
	}
	
	private Map<String, org.eclipse.ui.console.actions.TextViewerAction> fGlobalActions= Maps.newHashMapWithExpectedSize(10);
	private List<String> fSelectionActions = Lists.newArrayListWithExpectedSize(3);
	
	protected void updateAction(String actionId) {
		IAction action= fGlobalActions.get(actionId);
		if (action instanceof IUpdate)
			((IUpdate) action).update();
	}
	
	public void uninstallUndoRedoSupport() {
		IOperationHistory operationHistory = PlatformUI.getWorkbench().getOperationSupport().getOperationHistory();
		operationHistory.removeOperationHistoryListener(operationHistoryListener);
		operationHistoryListener = null;
	}
	
	public void initializeActions() {
		final List<IHandlerActivation> handlerActivations= Lists.newArrayListWithExpectedSize(3);
		final IHandlerService handlerService= (IHandlerService) PlatformUI.getWorkbench().getAdapter(IHandlerService.class);
		final Expression expression= new ActiveShellExpression(viewer.getControl().getShell());

		viewer.getControl().getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
				}
		});

		TextViewerAction action= new TextViewerAction(viewer, ITextOperationTarget.UNDO);
		action.setText("UNDO");
		fGlobalActions.put(ITextEditorActionConstants.UNDO, action);

		action= new TextViewerAction(viewer, ITextOperationTarget.REDO);
		action.setText("REDO");
		fGlobalActions.put(ITextEditorActionConstants.REDO, action);

		action= new TextViewerAction(viewer, ITextOperationTarget.CUT);
		action.setText("CUT");
		fGlobalActions.put(ITextEditorActionConstants.CUT, action);

		action= new TextViewerAction(viewer, ITextOperationTarget.COPY);
		action.setText("COPY");
		fGlobalActions.put(ITextEditorActionConstants.COPY, action);

		action= new TextViewerAction(viewer, ITextOperationTarget.PASTE);
		action.setText("PASTE");
		fGlobalActions.put(ITextEditorActionConstants.PASTE, action);

		action= new TextViewerAction(viewer, ITextOperationTarget.SELECT_ALL);
		action.setText("SELECT_ALL");
		fGlobalActions.put(ITextEditorActionConstants.SELECT_ALL, action);

		action= new TextViewerAction(viewer, ISourceViewer.CONTENTASSIST_PROPOSALS);
		action.setText("CONTENTASSIST_PROPOSALS");
		fGlobalActions.put(ITextEditorActionConstants.CONTENT_ASSIST, action);

		fSelectionActions.add(ITextEditorActionConstants.CUT);
		fSelectionActions.add(ITextEditorActionConstants.COPY);
		fSelectionActions.add(ITextEditorActionConstants.PASTE);
		
		viewer.getTextWidget().addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				handlerService.deactivateHandlers(handlerActivations);
			}
			public void focusGained(FocusEvent e) {
				IAction action= fGlobalActions.get(ITextEditorActionConstants.REDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_REDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.UNDO);
				handlerActivations.add(handlerService.activateHandler(IWorkbenchCommandConstants.EDIT_UNDO, new ActionHandler(action), expression));
				action= fGlobalActions.get(ITextEditorActionConstants.CONTENT_ASSIST);
				handlerActivations.add(handlerService.activateHandler(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS, new ActionHandler(action), expression));
			}
		});

	}

}
