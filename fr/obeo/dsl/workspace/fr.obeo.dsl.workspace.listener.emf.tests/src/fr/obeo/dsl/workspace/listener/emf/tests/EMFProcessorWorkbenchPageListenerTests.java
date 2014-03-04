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
package fr.obeo.dsl.workspace.listener.emf.tests;

import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.emf.EMFProcessor;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link EMFProcessor} class for workbench page changes.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EMFProcessorWorkbenchPageListenerTests {

	/**
	 * Tests {@link IWorkbenchPageListener#pageActivated(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageActivated() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		activePage.close();

		IWorkbenchPage page = null;
		try {
			page = activeWindow.openPage(null);

			final EObject ePage = processor.getObject(page);
			assertTrue(ePage instanceof WorkbenchPage);
			assertEquals(processor.getObject(page.getWorkbenchWindow()), ePage.eContainer());
			assertTrue(ePage.eContainer() instanceof WorkbenchWindow);
			assertEquals(ePage, ((WorkbenchWindow)ePage.eContainer()).getActivePage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPageListener#pageClosed(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageClosed() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		try {
			activePage.close();

			final EObject eActivePage = processor.getObject(activePage);
			final EObject eActiveWindow = processor.getObject(activeWindow);
			assertEquals(null, eActivePage);
			assertTrue(eActiveWindow instanceof WorkbenchWindow);
			assertEquals(null, ((WorkbenchWindow)eActiveWindow).getActivePage());
		} finally {
			activeWindow.openPage(null);
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPageListener#pageOpened(IWorkbenchPage)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchPage} can't be opened.
	 */
	@Test
	public void pageOpened() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		activePage.close();

		IWorkbenchPage page = null;
		try {
			page = activeWindow.openPage(null);

			final EObject ePage = processor.getObject(page);
			assertTrue(ePage instanceof WorkbenchPage);
			assertEquals(processor.getObject(page.getWorkbenchWindow()), ePage.eContainer());
			assertTrue(ePage.eContainer() instanceof WorkbenchWindow);
			assertEquals(ePage, ((WorkbenchWindow)ePage.eContainer()).getActivePage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

}
