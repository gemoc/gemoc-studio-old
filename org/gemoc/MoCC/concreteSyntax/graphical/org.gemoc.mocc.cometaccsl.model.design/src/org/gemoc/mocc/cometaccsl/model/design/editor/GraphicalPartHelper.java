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
package org.gemoc.mocc.cometaccsl.model.design.editor;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.ViewpointPackage;



public class GraphicalPartHelper {
	
	private IGraphicalEditPart hostEditPart;
	
	
	public GraphicalPartHelper(IGraphicalEditPart editPart) {
		this.hostEditPart = editPart;
	}
	
	public EObject resolveSemanticElement(){
		return 	 resolveSemanticElement(hostEditPart);
	}
	
	private EObject resolveSemanticElement(IGraphicalEditPart hostEditPart) {
		EObject eObject = hostEditPart.resolveSemanticElement();
		if (isDSemanticDecorator(eObject)) {
			DSemanticDecorator semanticDecorator = (DSemanticDecorator) eObject;
			return semanticDecorator.getTarget();
		}
		return resolveSemanticElement(hostEditPart);
	}
	
	private boolean isDSemanticDecorator(EObject eObject) {
		return ViewpointPackage.eINSTANCE.getDSemanticDecorator().isInstance(eObject);
	}
	
	public IDiagramEditDomain getDiagramEditDomain(){
		return hostEditPart.getDiagramEditDomain();
	}
	
	public DiagramRootEditPart getRootPart(){
		return (DiagramRootEditPart) hostEditPart.getRoot();
	}
	
	public IFigure getFigure(){
		return hostEditPart.getFigure();
	}
	
	public EditPartViewer getViewer(){
		return hostEditPart.getViewer();
	}

}
