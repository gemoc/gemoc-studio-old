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
package org.gemoc.mocc.cometafsm.model.design.editor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.gemoc.mocc.cometafsm.model.design.Activator;
import org.gemoc.mocc.cometafsm.model.design.services.StringUtil;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;


/**
 * Inspired by the gmf glue example from koehnlein
 *
 * @see org.eclipse.xtext.gmf.glue
 */
public class PopupXTextEditorHelper {
	
	private static int MIN_EDITOR_WIDTH = 100;

	private static int MIN_EDITOR_HEIGHT = 20;

	private GraphicalPartHelper hostEditPartHelper;
	
	private ResourceHelper resourceHelper;

	private IEditorPart diagramEditor;
	
	private XtextEditor xtextEditor;

	private int editorOffset;

	private int initialEditorSize;
	
	private int initialDocumentSize;

	private Composite xtextEditorComposite;

	private final Injector xtextInjector;
	
	private XtextResource xtextResource;
	
	private Resource originalResource;

	private String semanticElementFragment;

	public PopupXTextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector) {
		this.hostEditPartHelper = new GraphicalPartHelper(editPart);
		this.xtextInjector = xtextInjector;
		this.resourceHelper = new ResourceHelper(xtextInjector);
	}
	
	
	/**
	 * Show editor
	 */
	public void showEditor() {
		try {
			EObject originalSemanticElement = hostEditPartHelper.resolveSemanticElement();
			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			// Clone root EObject
			EObject semanticElement = EcoreUtil.copy(originalResource.getContents().get(0));
			
			this.xtextResource = resourceHelper.createVirtualXtextResource(semanticElement);
			
			semanticElementFragment = originalResource.getURIFragment(originalSemanticElement);
			if (semanticElementFragment == null || "".equals(semanticElementFragment)) {
				return;
			}
			IDiagramEditDomain diagramEditDomain = hostEditPartHelper.getDiagramEditDomain();
			diagramEditor = ((DiagramEditDomain) diagramEditDomain).getEditorPart();
			createXtextEditor(new ResourceWorkingCopyFileEditorInput(xtextResource));
		} catch (Exception e) {
			Activator.logError(e);
		}
	}
	
	/**
	 * Create the XText editor
	 * @param editorInput the editor input
	 * @throws Exception
	 */
	protected void createXtextEditor(IEditorInput editorInput) throws Exception {
		DiagramRootEditPart diagramEditPart = hostEditPartHelper.getRootPart();
		
		Composite parentComposite = (Composite) diagramEditPart.getViewer().getControl();
		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE|SWT.CLOSE); //SWT.TITLE|SWT.CLOSE|SWT.RESIZE | SWT.ON_TOP | SWT.BORDER
		xtextEditorComposite.setLayout(new FillLayout());
		xtextEditorComposite.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent e) {
				//Save if no syntax error
				closeEditor(true);
				
			}
		});
		IEditorSite editorSite = diagramEditor.getEditorSite();
		this.xtextEditor = xtextInjector.getInstance(XtextEditor.class);
		
		// remove dirty state editor callback
		xtextEditor.setXtextEditorCallback(new CompoundXtextEditorCallback(Guice.createInjector(new Module() {
			public void configure(Binder binder) {
			}
		})));
		xtextEditor.init(editorSite, editorInput);
		xtextEditor.createPartControl(xtextEditorComposite);
		addKeyVerifyListener();
		setEditorRegion();
		setEditorBounds();
		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.forceFocus();
		xtextEditor.setFocus();
	}
	
	private void addKeyVerifyListener() {
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		xtextTextWidget.addVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent e) {
				if ((e.stateMask & SWT.CTRL) != 0 && ((e.keyCode == SWT.KEYPAD_CR) || (e.keyCode == SWT.CR))) {
					e.doit = false;
				}
			}
		});
		xtextTextWidget.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.keyCode;
				if ((e.stateMask & SWT.CTRL) != 0 && ((keyCode == SWT.KEYPAD_CR) || (keyCode == SWT.CR))) {
					closeEditor(true);
				}
				if (keyCode == SWT.ESC) {
					closeEditor(true);
				}
				if(((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 's')){
					saveModifications();
				}else {
				}
			}
		});
	}
	
	/**
	 * Close this editor.
	 * @param isReconcile
	 */
	public void closeEditor(boolean isReconcile) {
		if (xtextEditor != null) {
			if (isReconcile) {
				try {
					final IXtextDocument xtextDocument = xtextEditor.getDocument();
					if (!isDocumentHasErrors(xtextDocument)) {
						// subtract 2 for the artificial newlines
						int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
						String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
						resourceHelper.updateXtextResource(editorOffset, initialEditorSize, newText,originalResource);
					}
				} catch (Exception exc) {
					Activator.logError(exc);
				}
			}
			xtextEditor.dispose();
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose();
			xtextEditor = null;
		}
	}
	
	private void saveModifications(){
		try {
			final IXtextDocument xtextDocument = xtextEditor.getDocument();
			if (!isDocumentHasErrors(xtextDocument)) {
				// subtract 2 for the artificial newlines
				int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
				String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
				resourceHelper.updateXtextResource(editorOffset, initialEditorSize, newText,originalResource);
			}
		} catch (Exception exc) {
			Activator.logError(exc);
		}
	}

	private void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextEditor.getDocument().modify(new IUnitOfWork<Boolean, XtextResource>() {

			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(semanticElementFragment);
				if (semanticElementInDocument == null) {
					return false;
				}
				ICompositeNode xtextNode = getCompositeNode(semanticElementInDocument);
				if (xtextNode == null) {
					return false;
				}
				// getOffset() and getLength() are trimming whitespaces
				editorOffset = xtextNode.getOffset();
				initialEditorSize = xtextNode.getLength();
				initialDocumentSize = xtextDocument.getLength();

				// insert a newline directly before and after the node
				xtextDocument.replace(editorOffset, 0, "\n");
				xtextDocument.replace(editorOffset + 1 + initialEditorSize, 0, "\n");
				return true;
			}

		});
		if (success) {
			xtextEditor.showHighlightRangeOnly(true);
			xtextEditor.setHighlightRange(editorOffset + 1, initialEditorSize, true);
			xtextEditor.setFocus();
		}
	}

	private void setEditorBounds() {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		// mind the added newlines
		String editString = "";
		try {
			editString = xtextDocument.get(editorOffset + 1, initialEditorSize);
		} catch (BadLocationException exc) {
			Activator.logError(exc);
		}
		int numLines = StringUtil.getNumLines(editString);
		int numColumns = StringUtil.getMaxColumns(editString);

		IFigure figure = hostEditPartHelper.getFigure();
		Rectangle bounds = figure.getBounds().getCopy();
		DiagramRootEditPart diagramEditPart = hostEditPartHelper.getRootPart();
		IFigure contentPane = diagramEditPart.getContentPane();
		contentPane.translateToAbsolute(bounds);
		EditPartViewer viewer = hostEditPartHelper.getViewer();
		Control control = viewer.getControl();
		while (control != null && false == control instanceof Shell) {
			bounds.translate(control.getBounds().x, control.getBounds().y);
			control = control.getParent();
		}

		Font font = figure.getFont();
		FontData fontData = font.getFontData()[0];
		int fontHeightInPixel = fontData.getHeight();

		int width = Math.max(fontHeightInPixel * (numColumns + 3), MIN_EDITOR_WIDTH);
		int height = Math.max(fontHeightInPixel * (numLines + 4), MIN_EDITOR_HEIGHT);
		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width, height);
		xtextEditorComposite.setBounds(bounds.x - 200, bounds.y - 120, width + 250, height + 50);
	}

	private ICompositeNode getCompositeNode(EObject semanticElement) {
		return NodeModelUtils.getNode(semanticElement);
	}

	private boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || parseResult.hasSyntaxErrors();
			}
		}));
	}
	
	
}
