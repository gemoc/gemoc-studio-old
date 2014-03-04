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
package fr.obeo.dsl.workspace.listener.internal;

import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowOpened;

import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * A listener for {@link IWorkbenchWindow}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkbenchWindowListener extends AbstractListener<IWorkbench> implements IWindowListener {

	/**
	 * Constructor.
	 * 
	 * @param workbench
	 *            the {@link IWorkbench} to observe.
	 */
	public WorkbenchWindowListener(IWorkbench workbench) {
		super(workbench);
		for (IWorkbenchWindow window : workbench.getWorkbenchWindows()) {
			WorkspaceUtils.createListener(window);
		}
		workbench.addWindowListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWindowListener#windowActivated(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void windowActivated(IWorkbenchWindow window) {
		fireChange(new WindowActivated(window));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWindowListener#windowDeactivated(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void windowDeactivated(IWorkbenchWindow window) {
		fireChange(new WindowDeactivated(window));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWindowListener#windowClosed(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void windowClosed(IWorkbenchWindow window) {
		fireChange(new WindowClosed(window));
		WorkspaceUtils.deleteListener(window);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IWindowListener#windowOpened(org.eclipse.ui.IWorkbenchWindow)
	 */
	public void windowOpened(IWorkbenchWindow window) {
		WorkspaceUtils.createListener(window);
		fireChange(new WindowOpened(window));
	}

	@Override
	protected void notifyCurrentState(IWorkbench observed2, IChangeProcessor processor) {
		for (IWorkbenchWindow window : observed2.getWorkbenchWindows()) {
			processor.process(new WindowOpened(window));
		}
		final IWorkbenchWindow activeWindow = observed2.getActiveWorkbenchWindow();
		if (activeWindow != null) {
			processor.process(new WindowActivated(activeWindow));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#dispose()
	 */
	public void dispose() {
		getObserved().removeWindowListener(this);
	}

}
