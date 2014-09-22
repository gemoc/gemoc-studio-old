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

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;


/**
 * Pop-up Xtext editor part handler 
 * @author creffst
 *
 */
public class GraphicalPartHelper {
	
	/**
	 * Managed host graphical edit part
	 */
	private IGraphicalEditPart hostEditPart;
	private EObject semanticElement;
	
	
	/**
	 * GraphicalPartHelper
	 * @param editPart
	 */
	public GraphicalPartHelper(IGraphicalEditPart editPart,EObject semanticElement) {
		this.hostEditPart = editPart;
		this.semanticElement = semanticElement;
	}
	
	/**
	 * Get the semantic element related to the given graphical part
	 * (e.g. to a DNodeContainer in the sirius editor)
	 * @return the root semantic element
	 */
	public EObject resolveSemanticElement(){
		return ((DSemanticDecorator)semanticElement).getTarget();
	}
	
	
	/**
	 * Check whether the eObject is an instance of viewpoint::DSemanticDecorator
	 * @see DSemanticDecorator
	 * @param eObject to be checked
	 */
	public boolean isDSemanticDecorator(EObject eObject) {
		return ViewpointPackage.eINSTANCE.getDSemanticDecorator().isInstance(eObject);
	}
	
	/**
	 * Helper exchange, get the DiagramEditDomain of the given graphical part
	 * @return the DiagramEditDomain
	 */
	public IDiagramEditDomain getDiagramEditDomain(){
		return hostEditPart.getDiagramEditDomain();
	}
	
	/**
	 * Helper exchange, get the DiagramRootEditPart of the given graphical part
	 * @return the DiagramRootEditPart
	 */
	public DiagramRootEditPart getRootPart(){
		return (DiagramRootEditPart) hostEditPart.getRoot();
	}
	
	/**
	 * Access to the figure of the given graphical part
	 * @return an IFigure
	 */
	public IFigure getFigure(){
		return hostEditPart.getFigure();
	}
	
	/**
	 * Access to the EditPartViewer of the given graphical part
	 * @return an EditPartViewer
	 */
	public EditPartViewer getViewer(){
		return hostEditPart.getViewer();
	}

	public void refresh(){
		hostEditPart.refresh();
	}
}
