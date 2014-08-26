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
package fr.obeo.dsl.debug.ide.sirius.ui;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDiagramElementEditPart;
import org.eclipse.sirius.ui.business.api.dialect.marker.TraceabilityMarkerNavigationProvider;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

//import org.eclipse.sirius.diagram.edit.api.part.IDDiagramEditPart;

/**
 * Utility class for breakpoint {@link DSLBreakpoint} toggling.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLToggleBreakpointsUtils extends fr.obeo.dsl.debug.ide.ui.DSLToggleBreakpointsUtils {

	/**
	 * The annotation ID for debug {@link DRepresentation}.
	 */
	public static final String ANNOTATION_ID = "fr.obeo.dsl.debug.ide.sirius.ui.breakpointAnnotation";

	/**
	 * Constructor.
	 * 
	 * @param identifier
	 *            the debug model identifier
	 */
	public DSLToggleBreakpointsUtils(String identifier) {
		super(identifier);
	}

	@Override
	protected EObject getInstruction(Object selected) {
		final EObject res;

		if (selected instanceof DSemanticDecorator) {
			res = super.getInstruction(((DSemanticDecorator)selected).getTarget());
		} else if (selected instanceof IDiagramElementEditPart) {
			res = super.getInstruction(((IDiagramElementEditPart)selected).resolveTargetSemanticElement());
		} else if (selected instanceof IDDiagramEditPart) {
			res = ((DSemanticDecorator)((IDDiagramEditPart)selected).resolveSemanticElement()).getTarget();
		} else {
			res = super.getInstruction(selected);
		}

		return res;
	}

	@Override
	protected DSLBreakpoint createBreakpoint(Object selected, EObject instruction) throws CoreException {
		final DSLBreakpoint res = super.createBreakpoint(selected, instruction);

		final DSemanticDecorator decorator;
		if (selected instanceof DSemanticDecorator) {
			decorator = (DSemanticDecorator)selected;
		} else if (selected instanceof IDiagramElementEditPart) {
			decorator = ((IDiagramElementEditPart)selected).resolveDiagramElement();
		} else if (selected instanceof IDDiagramEditPart) {
			decorator = (DSemanticDecorator)((IDDiagramEditPart)selected).resolveSemanticElement();
		} else {
			decorator = null;
		}

		if (decorator != null) {
			final DRepresentation representation = getDRepresentation(decorator);

			if (representation != null) {
				final IMarker marker = res.getMarker();
				marker.setAttribute(TraceabilityMarkerNavigationProvider.INTERNAL_REPRESENTATION_URI,
						EcoreUtil.getURI(representation).toString());
				marker.setAttribute(TraceabilityMarkerNavigationProvider.REPRESENTATION_ELEMENT_ID,
						representation.eResource().getURIFragment(decorator).toString());
				marker.setAttribute(TraceabilityMarkerNavigationProvider.REPRESENTATION_URI, EcoreUtil
						.getURI(representation).toString());
				marker.setAttribute("traceab_viewpoint_ghost", "active");
			}
		}

		return res;
	}

	/**
	 * Gets the {@link DRepresentation} from the given {@link DSemanticDecorator}.
	 * 
	 * @param decorator
	 *            the {@link DSemanticDecorator}
	 * @return the {@link DRepresentation} from the given {@link DSemanticDecorator}
	 */
	protected DRepresentation getDRepresentation(DSemanticDecorator decorator) {
		DRepresentation res = null;
		EObject current = decorator;
		while (current != null) {
			if (current instanceof DRepresentation) {
				res = (DRepresentation)current;
				break;
			} else {
				current = current.eContainer();
			}
		}

		return res;
	}

}
