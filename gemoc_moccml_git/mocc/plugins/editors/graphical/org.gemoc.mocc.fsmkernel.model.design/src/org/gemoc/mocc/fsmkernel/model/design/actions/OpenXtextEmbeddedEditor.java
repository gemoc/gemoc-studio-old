/******************************************************************************
 * Copyright (c) 2011 Obeo  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo  - initial API and implementation
 * 
 ****************************************************************************/

package org.gemoc.mocc.fsmkernel.model.design.actions;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.gemoc.mocc.fsmkernel.model.design.editor.PopupXTextEditorHelper;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public abstract class OpenXtextEmbeddedEditor implements IExternalJavaAction {

	/* (non-Javadoc)
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> context,
			Map<String, Object> parameters) {
		DiagramEditPart diagramEditPart = ((DiagramEditor) getActiveEditor())
				.getDiagramEditPart();
		for (EObject o : context) {
			EditPart editPart;
			if (o instanceof DEdgeSpec) { //edge cannot directly be linked to edit part, opening on target node
				editPart = diagramEditPart
						.findEditPart(diagramEditPart, ((DEdgeSpec)o).getTargetNode());
			}else {
				editPart = diagramEditPart
						.findEditPart(diagramEditPart, o);
			}
			if (editPart != null && (editPart instanceof IGraphicalEditPart)) {
				
				PopupXTextEditorHelper embeddedEditorHelper = new PopupXTextEditorHelper(
						(IGraphicalEditPart) editPart/*diagramEditPart*/, o, getInjector(), getPageLocationX(), getPageLocationY(), getWindowBounds());
				embeddedEditorHelper.showEditor();
				break;
			}
		}
	}

	/**
	 * Return the injector associated to you domain model plug-in.
	 * 
	 * @return
	 */
	protected abstract Injector getInjector();

	/**
	 * Get the active editor part
	 * @return the one from the active page
	 */
	protected IEditorPart getActiveEditor() {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		return page.getActiveEditor();
	}
	
	// Added by pihd
	protected int getPageLocationX()
	{
		int x=0;
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		x = page.getWorkbenchWindow().getShell().getLocation().x;
		return x;
	}
	
	protected int getPageLocationY()
	{
		int y = 0;
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		y = page.getWorkbenchWindow().getShell().getLocation().y;
		
		return y;
	}
	
	protected Rectangle getWindowBounds()
	{
		Rectangle bound;
		
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
				.getActivePage();
		bound = page.getWorkbenchWindow().getShell().getBounds();
		
		return bound;
	}

}