/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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

import java.lang.reflect.Field;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.gemoc.mocc.fsmkernel.model.design.Activator;

/**
 * @author koehnlein
 * 
 * +adaptation for the mocml design editor
 * FIXME + patch for windows bug stateMask has gone somewhere else
 * @author creffst
 */
public class PopupXTextEditorKeyListener extends KeyAdapter implements VerifyKeyListener {

	private final PopupXTextEditorHelper popupXtextEditorHelper;

	private ContentAssistant contentAssistant;
	
	private int stateMask;

	//private boolean isIgnoreNextESC;

	/**
	 * This element comes from the XText/GMF integration example, and was not originally documented.
	 * @param popupXtextEditorHelper 
	 * @param contentAssistant 
	 */
	public PopupXTextEditorKeyListener(PopupXTextEditorHelper popupXtextEditorHelper, IContentAssistant contentAssistant) {
		this.popupXtextEditorHelper = popupXtextEditorHelper;
		this.contentAssistant = contentAssistant instanceof ContentAssistant ? (ContentAssistant) contentAssistant : null;
		//isIgnoreNextESC = false;
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.keyCode;
		/*if (((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR)))||
				((stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR)))) { //for windows
			this.popupXtextEditorHelper.closeEditor(true);
		}*/
		if (keyCode == SWT.ESC) {
			/*if (isIgnoreNextESC) {
				isIgnoreNextESC = false;
			} else {
				PopupXTextEditorHelper.ignoreFocusLost = true ;*/
				try {
					this.popupXtextEditorHelper.closeEditor(true);
				} catch (CoreException exc) {
					// TODO Auto-generated catch block
					Activator.logError(exc);
				}
			//}
		}
		if((((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 's'))||
				(((stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 's'))){
			this.popupXtextEditorHelper.saveModifications();
		}
		stateMask = keyCode;
		/*if ((e.stateMask & SWT.CTRL) != 0 && (keyCode == ' ')) {
			this.contentAssistant.setRepeatedInvocationMode(true) ;
			this.contentAssistant.showPossibleCompletions() ;
			this.isIgnoreNextESC = true ;
			contentAssistant.addCompletionListener(new ICompletionListener() {
				
				public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {		
				}
				
				public void assistSessionStarted(ContentAssistEvent event) {
				}
				
				public void assistSessionEnded(ContentAssistEvent event) {
					try {
						popupXtextEditorHelper.getSourceViewerHandle().getViewer().getTextWidget().setFocus() ;
					}
					catch (Exception e) {
						//ignore
					}
				}
			}) ;
		}*/
	}

	public void verifyKey(VerifyEvent e) {
		if (e.keyCode == SWT.ESC && isContentAssistActive()) {
			//isIgnoreNextESC = true;
		}
		if ((e.stateMask & SWT.CTRL) != 0 && ((e.keyCode == SWT.KEYPAD_CR) || (e.keyCode == SWT.CR))) {
			e.doit = false;
		}
	}

	/**
	 * @return true if the proposal popup has focus
	 *
	 */
	public boolean isContentAssistActive() {
		return contentAssistant != null && contentAssistant.hasProposalPopupFocus();
	}
	
}