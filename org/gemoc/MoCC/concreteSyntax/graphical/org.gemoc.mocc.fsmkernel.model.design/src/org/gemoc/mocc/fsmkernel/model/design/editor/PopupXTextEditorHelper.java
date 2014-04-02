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


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
//import org.eclipse.xtext.nodemodel.serialization.SerializationUtil;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.CompoundXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.info.ResourceWorkingCopyFileEditorInput;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.gemoc.mocc.fsmkernel.model.design.Activator;
import org.gemoc.mocc.fsmkernel.model.design.services.ResourceHelper;
import org.gemoc.mocc.fsmkernel.model.design.services.StringUtil;

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
	
	/**
	 * Helper to access to the host Edit GraphicalPart 
	 */
	private GraphicalPartHelper hostEditPartHelper;
	
	/**
	 * Helper to manage the resources
	 */
	private ResourceHelper resourceHelper;

	/**
	 * Pop up xtext diagram editor part,
	 * (hostEditPartHelper-..>diagramEditor)
	 */
	private IEditorPart diagramEditor;
	

	/**
	 * Pop up xtext editor composite
	  * (hostEditPartHelper-..>diagramEditor-..>xtextEditorComposite)
	 */
	private Composite xtextEditorComposite;
	
	/**
	 * Pop up xtext editor
	 * (hostEditPartHelper-..>diagramEditor-..>xtextEditorComposite->xtextEditor)
	 */
	private XtextEditor xtextEditor;
	
	/**
	 * editor offset, 
	 * used to set and save&close the pop up editor
	 */
	private int editorOffset;
	
	/**
	 * initial Editor Size,
	 * used to set and save&close the pop up editor
	 */
	private int initialEditorSize;
	
	/**
	 * initial xtext document size,
	 * used to set and save&close the pop up editor
	 */
	private int initialDocumentSize;

	/**
	 * Dependency tracker service
	 */
	private final Injector xtextInjector;
	
	/**
	 * xtext pop up editor working resource
	 */
	private XtextResource xtextResource;
	
	/**
	 * host resource
	 */
	private Resource originalResource;

	/**
	 * host semantic element fragment
	 */
	private String semanticElementFragment;
	
	

	/**
	 * Create new PopupXTextEditor on a given edit part to perform direct xtext edition
	 * @param editPart : the host edit part
	 * @param xtextInjector : the dependency tracker xtext injector
	 * @wbp.parser.entryPoint
	 */
	public PopupXTextEditorHelper(IGraphicalEditPart editPart, Injector xtextInjector) {
		this.hostEditPartHelper = new GraphicalPartHelper(editPart);
		this.xtextInjector = xtextInjector;
		this.resourceHelper = new ResourceHelper(xtextInjector);
	}
	
	/**
	 * Show editor
	 * @wbp.parser.entryPoint
	 */
	public void showEditor() {
		try {
			EObject originalSemanticElement = hostEditPartHelper.resolveSemanticElement();
			if (originalSemanticElement == null) {
				return;
			}
			this.originalResource = originalSemanticElement.eResource();
			
			this.xtextResource = resourceHelper.createVirtualXtextResource(originalResource, hostEditPartHelper);
			
			// TODO manage multi resource with Xtext Linking or Scoping service
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
	 * Close this editor (performing a reconciliation with the host resource or not)
	 * @param isReconcile : true if reconciliation has to be performed
	 * @throws CoreException 
	 */
	public void closeEditor(boolean isReconcile) throws CoreException {
		if (xtextEditor != null) {
			if (isReconcile) {
				saveModifications();
			}
			deleteFile();
			xtextEditor.dispose();
			xtextEditor = null;
			xtextEditorComposite.setVisible(false);
			xtextEditorComposite.dispose();
			
			//TODO firePropertyChange(IEditorPart.PROP_DIRTY);	
		}
	}
	
	public void deleteFile() throws CoreException{
		IFile file = ResourceUtil.getFile(xtextEditor.getEditorInput());
		file.delete(true, new NullProgressMonitor());
		IProject activeProject = file.getProject();
		IFolder folder= activeProject.getFolder(ResourceHelper.TEMPORARY_PROJECT_NAME);	
		if((folder.members()==null) ||(folder.members().length==0)){
			//remove folder
			folder.delete(true, new NullProgressMonitor());
		}
	}
	
	/**
	 * Performs a reconciliation with the host resource whether possible (document  has no error)
	 * and necessary (resource has been modified)
	 */
	public void saveModifications(){
		try {
			final IXtextDocument xtextDocument = xtextEditor.getDocument();
			if (!isDocumentHasErrors(xtextDocument)) {
				// subtract 2 for the artificial newlines
				int documentGrowth = xtextDocument.getLength() - initialDocumentSize - 2;
				String newText = xtextDocument.get(editorOffset + 1, initialEditorSize + documentGrowth);
				resourceHelper.updateXtextResource(editorOffset, initialEditorSize, newText);
			}else {
				
			}
		} catch (Exception exc) {
			Activator.logError(exc);
		}
	}
	
	//
	private boolean isDocumentHasErrors(final IXtextDocument xtextDocument) {
		return (xtextDocument.readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			public Boolean exec(XtextResource state) throws Exception {
				IParseResult parseResult = state.getParseResult();
				return !state.getErrors().isEmpty() || parseResult == null || parseResult.hasSyntaxErrors();
			}
		}));
	}
	
	/**
	 * Create the XText editor
	 * @param editorInput the editor input (ResourceWorkingCopyFileEditorInput on the temporary xtext resource)
	 * @throws Exception
	 * @wbp.parser.entryPoint
	 */
	protected void createXtextEditor(IEditorInput editorInput) throws Exception {
		DiagramRootEditPart diagramEditPart = hostEditPartHelper.getRootPart();
		
		Composite parentComposite = (Composite) diagramEditPart.getViewer().getControl();
		xtextEditorComposite = new Decorations(parentComposite, SWT.RESIZE|SWT.CLOSE); //SWT.TITLE|SWT.CLOSE|SWT.RESIZE | SWT.ON_TOP | SWT.BORDER
		xtextEditorComposite.setLayout(new FillLayout());
		
		xtextEditorComposite.addDisposeListener(new DisposeListener() {
			
			//@Override
			public void widgetDisposed(DisposeEvent e) {
				//Don't save if no syntax error
				try {
				if (MessageDialog.openQuestion(xtextEditorComposite.getShell(), "Warning", "You are about to close without saving, save anyway?")) {
					
						closeEditor(true);
					
				}else {
					closeEditor(false);
				}
				} catch (CoreException ce) {
					Activator.logError(ce);
				}
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
		xtextEditor.createPartControl(xtextEditorComposite);//xtextEditorComposite);
		
		registerKeyListener();
		setEditorRegion();
		setEditorBounds();
		
		PopupXTextEditorActionSupport xtextActionSupport = new PopupXTextEditorActionSupport((XtextSourceViewer)xtextEditor.getInternalSourceViewer());
		xtextActionSupport.initializeActions();
		xtextActionSupport.installUndoRedoSupport();
		//}
		xtextEditorComposite.setVisible(true);
		xtextEditorComposite.forceFocus();
		xtextEditor.setFocus();
	}
	
	
/*	class fileExitItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      closeEditor(false);
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      closeEditor(false);
	    }
	  }

	  class fileSaveItemListener implements SelectionListener {
	    public void widgetSelected(SelectionEvent event) {
	      saveModifications();
	    }

	    public void widgetDefaultSelected(SelectionEvent event) {
	      saveModifications();
	    }
	  }*/
	
	
	/**
	 * Add key listener
	 * @see PopupXTextEditorKeyListener
	 */
	private void registerKeyListener() {
		ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
		final StyledText xtextTextWidget = sourceViewer.getTextWidget();
		PopupXTextEditorKeyListener keyListener = 
				new PopupXTextEditorKeyListener
							(this, ((XtextSourceViewer)sourceViewer).getContentAssistant());
		xtextTextWidget.addVerifyKeyListener(keyListener);
		xtextTextWidget.addKeyListener(keyListener);
	}
	
	

	/**
	 * Set xtext pop up editor region, open xtext document for modifications
	 * @throws BadLocationException
	 */
	private void setEditorRegion() throws BadLocationException {
		final IXtextDocument xtextDocument = xtextEditor.getDocument();
		boolean success = xtextDocument.modify(new IUnitOfWork<Boolean, XtextResource>() {
			
			public Boolean exec(XtextResource state) throws Exception {
				EObject semanticElementInDocument = state.getEObject(semanticElementFragment);
				if (semanticElementInDocument == null) {
					return false;
				}
				
				ICompositeNode xtextNode = NodeModelUtils.getNode(semanticElementInDocument);
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
	
	
	private static int MIN_EDITOR_WIDTH = 100;
	private static int MIN_EDITOR_HEIGHT = 20;
	/**
	 * Set pop up xtext editor initial bounds
	 */
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

}
