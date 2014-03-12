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
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link EMFProcessor} class for workbench window changes.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EMFProcessorWorkbenchWindowListenerTests {

	/**
	 * Tests {@link IWorkbenchWindowListener#windowActivated(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowActivated() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();

		IWorkbenchWindow window1 = null;
		IWorkbenchWindow window2 = null;
		try {
			window1 = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			window2 = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			final EObject eWindow1 = processor.getObject(window1);
			assertTrue(eWindow1 instanceof WorkbenchWindow);
			assertEquals(processor.getObject(window1.getWorkbench()), eWindow1.eContainer());
			assertTrue(eWindow1.eContainer() instanceof WorkbenchRoot);
			assertEquals(eWindow1, ((WorkbenchRoot)eWindow1.eContainer()).getActiveWindow());
		} finally {
			if (window1 != null) {
				window1.close();
			}
			if (window2 != null) {
				window2.close();
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchWindowListener#windowDeactivated(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowDeactivated() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();

		IWorkbenchWindow window = null;
		try {
			final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			final EObject eActiveWindow = processor.getObject(activeWindow);
			final WorkbenchRoot eWorkbench = (WorkbenchRoot)processor.getObject(PlatformUI.getWorkbench());

			assertEquals(eActiveWindow, eWorkbench.getActiveWindow());

			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			assertTrue(eActiveWindow instanceof WorkbenchWindow);
			assertEquals(processor.getObject(activeWindow.getWorkbench()), eActiveWindow.eContainer());
			assertTrue(eActiveWindow.eContainer() instanceof WorkbenchRoot);
			assertEquals(eActiveWindow, ((WorkbenchRoot)eActiveWindow.eContainer()).getActiveWindow());
		} finally {
			if (window != null) {
				window.close();
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchWindowListener#windowClosed(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowClosed() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();

		IWorkbenchWindow window = null;
		try {
			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			window.close();

			assertEquals(null, processor.getObject(window));
			window = null;
		} finally {
			if (window != null) {
				window.close();
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchWindowListener#windowOpened(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowOpened() throws WorkbenchException {
		final EMFProcessor processor = new EMFProcessor();

		IWorkbenchWindow window = null;
		try {
			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			final EObject eWindow = processor.getObject(window);
			assertTrue(eWindow instanceof WorkbenchWindow);
			assertEquals(processor.getObject(window.getWorkbench()), eWindow.eContainer());
			assertTrue(eWindow.eContainer() instanceof WorkbenchRoot);
		} finally {
			if (window != null) {
				window.close();
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

}
