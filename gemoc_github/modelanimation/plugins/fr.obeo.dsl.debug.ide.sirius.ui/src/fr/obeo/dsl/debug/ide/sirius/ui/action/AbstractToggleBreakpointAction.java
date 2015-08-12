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
package fr.obeo.dsl.debug.ide.sirius.ui.action;

import fr.obeo.dsl.debug.ide.sirius.ui.DSLToggleBreakpointsUtils;
import fr.obeo.dsl.debug.ide.sirius.ui.DebugSiriusIdeUiPlugin;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.PlatformUI;

/**
 * Toggle breakpoint {@link org.eclipse.sirius.tools.api.ui.IExternalJavaAction IExternalJavaAction}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractToggleBreakpointAction implements IExternalJavaAction {

	/**
	 * Toggle breakpoint utility.
	 */
	private final DSLToggleBreakpointsUtils toggleUtility = createToggleBreakpointsUtils();

	/**
	 * Creates an instance of {@link DSLToggleBreakpointsUtils}.
	 * 
	 * @return the created {@link DSLToggleBreakpointsUtils

	 */
	protected DSLToggleBreakpointsUtils createToggleBreakpointsUtils() {
		return new DSLToggleBreakpointsUtils(getModelIdentifier());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getSelection();
		if (toggleUtility.canToggleBreakpoints(selection)) {
			try {
				toggleUtility.toggleBreakpoints(selection);
			} catch (CoreException e) {
				DebugSiriusIdeUiPlugin.getPlugin().getLog().log(
						new Status(IStatus.ERROR, DebugSiriusIdeUiPlugin.ID, e.getLocalizedMessage(), e));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> selections) {
		final ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getSelection();
		return toggleUtility.canToggleBreakpoints(selection);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction2#mayDeleteElements()
	 */
	public boolean mayDeleteElements() {
		return false;
	}

	/**
	 * Gets the debug model identifier.
	 * 
	 * @return the debug model identifier
	 */
	protected abstract String getModelIdentifier();

}
