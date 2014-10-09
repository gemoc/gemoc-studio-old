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
package fr.obeo.dsl.workspace.listener.tests.internal;

import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.workbench.PageActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PageClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PageOpened;
import fr.obeo.dsl.workspace.listener.tests.change.processor.TestProcessor;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPageListener WorkbenchPageListener}
 * class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkbenchPageListenerTests {

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPageListener#pageActivated(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageActivated() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		activePage.close();
		final IListener listener = WorkspaceUtils.getListener(activeWindow);
		listener.addProcessor(processor, false);

		IWorkbenchPage page = null;
		try {
			page = activeWindow.openPage(null);

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(1) instanceof PageActivated);
			final PageActivated change = (PageActivated)processor.getChanges().get(1);
			assertEquals(page, change.getObject());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPageListener#pageClosed(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageClosed() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activeWindow);
		listener.addProcessor(processor, false);

		try {
			activePage.close();

			assertEquals(1, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof PageClosed);
			final PageClosed change = (PageClosed)processor.getChanges().get(0);
			assertEquals(activePage, change.getObject());
		} finally {
			activeWindow.openPage(null);
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPageListener#pageOpened(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageOpened() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		activePage.close();
		final IListener listener = WorkspaceUtils.getListener(activeWindow);
		listener.addProcessor(processor, false);

		IWorkbenchPage page = null;
		try {
			page = activeWindow.openPage(null);

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof PageOpened);
			final PageOpened change = (PageOpened)processor.getChanges().get(0);
			assertEquals(page, change.getObject());
		} finally {
			listener.removeProcessor(processor);
		}
	}

}
