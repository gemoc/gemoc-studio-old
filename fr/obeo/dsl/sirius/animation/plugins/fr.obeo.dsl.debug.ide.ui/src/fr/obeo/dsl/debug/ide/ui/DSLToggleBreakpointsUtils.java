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
package fr.obeo.dsl.debug.ide.ui;

import fr.obeo.dsl.debug.ide.DSLBreakpoint;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * Utility class for breakpoint {@link DSLBreakpoint} toggling.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLToggleBreakpointsUtils {

	/**
	 * The debug model identifier.
	 */
	protected final String identifier;

	/**
	 * Constructor.
	 * 
	 * @param identifier
	 *            the debug model identifier
	 */
	public DSLToggleBreakpointsUtils(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension#toggleBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void toggleBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		if (selection instanceof IStructuredSelection) {
			@SuppressWarnings("unchecked")
			final Iterator<Object> it = ((IStructuredSelection)selection).iterator();
			while (it.hasNext()) {
				final Object selected = it.next();
				EObject instruction = getInstruction(selected);
				if (instruction != null) {
					toggleBreakpoint(selected, instruction);
				}
			}
		}
	}

	/**
	 * Toggles the {@link DSLBreakpoint} for the given {@link EObject instruction}.
	 * 
	 * @param selected
	 *            the selected {@link Object}
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @throws CoreException
	 *             if {@link DSLBreakpoint} can't be retrieved or installed
	 */
	protected void toggleBreakpoint(Object selected, EObject instruction) throws CoreException {
		DSLBreakpoint breakpoint = getBreakpoint(instruction);
		if (breakpoint != null) {
			breakpoint.delete();
		} else {
			breakpoint = createBreakpoint(selected, instruction);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(breakpoint);
		}
	}

	/**
	 * Creates a {@link DSLBreakpoint} for the given instruction.
	 * 
	 * @param selected
	 *            the selected {@link Object}
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @return the created {@link DSLBreakpoint} for the given instruction
	 * @throws CoreException
	 *             if the {@link DSLBreakpoint} instantiation fails
	 */
	protected DSLBreakpoint createBreakpoint(Object selected, EObject instruction) throws CoreException {
		return new DSLBreakpoint(identifier, instruction, true);
	}

	/**
	 * Gets the {@link DSLBreakpoint} for the given {@link EObject instruction}.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @return the {@link DSLBreakpoint} for the given {@link EObject instruction} if nay, <code>null</code>
	 *         otherwise
	 */
	protected DSLBreakpoint getBreakpoint(EObject instruction) {
		DSLBreakpoint res = null;

		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
				.getBreakpoints(identifier);
		final URI instructionURI = EcoreUtil.getURI(instruction);
		for (IBreakpoint breakpoint : breakpoints) {
			if (breakpoint instanceof DSLBreakpoint
					&& ((DSLBreakpoint)breakpoint).getURI().equals(instructionURI)) {
				res = (DSLBreakpoint)breakpoint;
				break;
			}
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension#canToggleBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public boolean canToggleBreakpoints(IWorkbenchPart part, ISelection selection) {
		boolean res = false;

		if (selection instanceof IStructuredSelection) {
			@SuppressWarnings("unchecked")
			final Iterator<Object> it = ((IStructuredSelection)selection).iterator();
			while (it.hasNext()) {
				final Object selected = it.next();
				if (selected != null) {
					res = getInstruction(selected) != null;
					break;
				}
			}
		}

		return res;
	}

	/**
	 * Gets an {@link EObject instruction} from the given {@link Object}.
	 * 
	 * @param selected
	 *            the {@link Object}
	 * @return the corresponding {@link EObject instruction} or <code>null</code> if no {@link EObject
	 *         instruction} match
	 */
	protected EObject getInstruction(Object selected) {
		final EObject res;

		if (selected instanceof EObject) {
			res = (EObject)selected;
		} else if (selected instanceof IAdaptable) {
			final EObject adapter = (EObject)((IAdaptable)selected).getAdapter(EObject.class);
			if (adapter != null) {
				res = adapter;
			} else {
				res = (EObject)Platform.getAdapterManager().getAdapter(selected, EObject.class);
			}
		} else if (selected != null) {
			res = (EObject)Platform.getAdapterManager().getAdapter(selected, EObject.class);
		} else {
			res = null;
		}

		return res;
	}

}
