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
import fr.obeo.dsl.debug.ide.adapter.AbstractDSLDebugElementAdapter;

import java.util.Iterator;

import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPart;

/**
 * DSL {@link IToggleBreakpointsTargetExtension2} that can be used to re-target break point toggle action.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLToggleBreakpointsTarget implements IToggleBreakpointsTargetExtension2 {

	/**
	 * The instance of {@link DSLToggleBreakpointsTarget}.
	 */
	public static final DSLToggleBreakpointsTarget INSTANCE = new DSLToggleBreakpointsTarget();

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
					toggleBreakpoint(instruction);
				}
			}
		}
	}

	/**
	 * Toggles the {@link DSLBreakpoint} for the given {@link EObject instruction}.
	 * 
	 * @param instruction
	 *            the {@link EObject instruction}
	 * @throws CoreException
	 *             if {@link DSLBreakpoint} can't be retrieved or installed
	 */
	private void toggleBreakpoint(EObject instruction) throws CoreException {
		DSLBreakpoint breakpoint = getBreakpoint(instruction);
		if (breakpoint != null) {
			breakpoint.delete();
		} else {
			breakpoint = new DSLBreakpoint(instruction, true);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(breakpoint);
		}
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

		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
				AbstractDSLDebugElementAdapter.REPRESENTATION_ID);
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
				res = (EObject)AdapterManager.getDefault().getAdapter(selected, EObject.class);
			}
		} else if (selected != null) {
			res = (EObject)AdapterManager.getDefault().getAdapter(selected, EObject.class);
		} else {
			res = null;
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleLineBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
		toggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleLineBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		return canToggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleMethodBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
		toggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleMethodBreakpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		return canToggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#toggleWatchpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
		toggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTarget#canToggleWatchpoints(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		return canToggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension2#toggleBreakpointsWithEvent(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection, org.eclipse.swt.widgets.Event)
	 */
	public void toggleBreakpointsWithEvent(IWorkbenchPart part, ISelection selection, Event event)
			throws CoreException {
		// TODO Auto-generated method stub
		toggleBreakpoints(part, selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.ui.actions.IToggleBreakpointsTargetExtension2#canToggleBreakpointsWithEvent(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection, org.eclipse.swt.widgets.Event)
	 */
	public boolean canToggleBreakpointsWithEvent(IWorkbenchPart part, ISelection selection, Event event) {
		// TODO Auto-generated method stub
		return canToggleBreakpoints(part, selection);
	}

}
