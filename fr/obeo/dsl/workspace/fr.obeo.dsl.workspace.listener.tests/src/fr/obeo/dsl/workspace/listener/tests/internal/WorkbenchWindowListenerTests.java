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

import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.WindowOpened;
import fr.obeo.dsl.workspace.listener.tests.change.processor.TestProcessor;

import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link WorkbenchWindowListener} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkbenchWindowListenerTests {

	/**
	 * Tests {@link WorkbenchWindowListener#windowActivated(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowActivated() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(PlatformUI.getWorkbench());

		IWorkbenchWindow window1 = null;
		IWorkbenchWindow window2 = null;
		try {
			window1 = PlatformUI.getWorkbench().openWorkbenchWindow(null);
			listener.addProcessor(processor, false);
			window2 = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			assertEquals(3, processor.getChanges().size());
			assertTrue(processor.getChanges().get(1) instanceof WindowActivated);
			final WindowActivated change = (WindowActivated)processor.getChanges().get(1);
			assertEquals(window1, change.getObject());
		} finally {
			if (window1 != null) {
				window1.close();
			}
			if (window2 != null) {
				window2.close();
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkbenchWindowListener#windowDeactivated(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowDeactivated() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(PlatformUI.getWorkbench());
		listener.addProcessor(processor, false);

		IWorkbenchWindow window = null;
		try {
			final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			assertEquals(3, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof WindowDeactivated);
			final WindowDeactivated change = (WindowDeactivated)processor.getChanges().get(0);
			assertEquals(activeWindow, change.getObject());
		} finally {
			if (window != null) {
				window.close();
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkbenchWindowListener#windowClosed(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowClosed() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(PlatformUI.getWorkbench());

		IWorkbenchWindow window = null;
		try {
			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);
			listener.addProcessor(processor, false);
			window.close();

			assertEquals(1, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof WindowClosed);
			final WindowClosed change = (WindowClosed)processor.getChanges().get(0);
			assertEquals(window, change.getObject());
			window = null;
		} finally {
			if (window != null) {
				window.close();
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkbenchWindowListener#windowOpened(org.eclipse.ui.IWorkbenchWindow)}.
	 * 
	 * @throws WorkbenchException
	 *             if the {@link IWorkbenchWindow} can't be opened
	 */
	@Test
	public void windowOpened() throws WorkbenchException {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(PlatformUI.getWorkbench());
		listener.addProcessor(processor, false);

		IWorkbenchWindow window = null;
		try {
			window = PlatformUI.getWorkbench().openWorkbenchWindow(null);

			assertEquals(3, processor.getChanges().size());
			assertTrue(processor.getChanges().get(2) instanceof WindowOpened);
			final WindowOpened change = (WindowOpened)processor.getChanges().get(2);
			assertEquals(window, change.getObject());
		} finally {
			if (window != null) {
				window.close();
			}
			listener.removeProcessor(processor);
		}
	}

}
