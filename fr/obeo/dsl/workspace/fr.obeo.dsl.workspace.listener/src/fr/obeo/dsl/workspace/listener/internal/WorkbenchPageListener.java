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
import fr.obeo.dsl.workspace.listener.change.workbench.PageActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PageClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PageOpened;

import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Listener for {@link IWorkbenchPage}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkbenchPageListener extends AbstractListener<IWorkbenchWindow> implements IPageListener {

	/**
	 * Constructor.
	 * 
	 * @param workbenchWindow
	 *            the {@link IWorkbenchWindow} to observe.
	 */
	public WorkbenchPageListener(IWorkbenchWindow workbenchWindow) {
		super(workbenchWindow);
		for (IWorkbenchPage page : workbenchWindow.getPages()) {
			WorkspaceUtils.createListener(page);
		}
		workbenchWindow.addPageListener(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPageListener#pageActivated(org.eclipse.ui.IWorkbenchPage)
	 */
	public void pageActivated(IWorkbenchPage page) {
		fireChange(new PageActivated(page));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPageListener#pageClosed(org.eclipse.ui.IWorkbenchPage)
	 */
	public void pageClosed(IWorkbenchPage page) {
		fireChange(new PageClosed(page));
		WorkspaceUtils.deleteListener(page);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IPageListener#pageOpened(org.eclipse.ui.IWorkbenchPage)
	 */
	public void pageOpened(IWorkbenchPage page) {
		WorkspaceUtils.createListener(page);
		fireChange(new PageOpened(page));
	}

	@Override
	protected void notifyCurrentState(IWorkbenchWindow observed2, IChangeProcessor processor) {
		for (IWorkbenchPage page : observed2.getPages()) {
			processor.process(new PageOpened(page));
		}
		final IWorkbenchPage activePage = observed2.getActivePage();
		if (activePage != null) {
			processor.process(new PageActivated(activePage));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.IListener#dispose()
	 */
	public void dispose() {
		getObserved().removePageListener(this);
	}

}
