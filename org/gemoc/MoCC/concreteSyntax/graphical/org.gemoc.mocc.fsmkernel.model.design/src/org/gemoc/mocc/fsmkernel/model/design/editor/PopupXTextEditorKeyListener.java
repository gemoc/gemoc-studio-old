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

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;

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

	/**
	 * This element comes from the XText/GMF integration example, and was not originally documented.
	 * @param popupXtextEditorHelper 
	 * @param contentAssistant 
	 */
	public PopupXTextEditorKeyListener(PopupXTextEditorHelper popupXtextEditorHelper, IContentAssistant contentAssistant) {
		this.popupXtextEditorHelper = popupXtextEditorHelper;
		this.contentAssistant = contentAssistant instanceof ContentAssistant ? (ContentAssistant) contentAssistant : null;
		
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		synchronized (popupXtextEditorHelper) {
			this.popupXtextEditorHelper.check4DandlingCrossReferences();
		}
		this.popupXtextEditorHelper.setStableText();
		
		if((((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 's'))||
				(((stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 's'))){
			try {
				this.popupXtextEditorHelper.saveModifications(true);//TODO
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.keyCode == SWT.ESC){
			try {
				this.popupXtextEditorHelper.saveModifications(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
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