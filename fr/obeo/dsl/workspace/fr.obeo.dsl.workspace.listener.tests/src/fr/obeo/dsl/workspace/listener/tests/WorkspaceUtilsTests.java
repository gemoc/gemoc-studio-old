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
package fr.obeo.dsl.workspace.listener.tests;

import fr.obeo.dsl.workspace.listener.IListener;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.internal.WorkbenchPageListener;
import fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener;
import fr.obeo.dsl.workspace.listener.internal.WorkbenchWindowListener;
import fr.obeo.dsl.workspace.listener.internal.WorkspaceListener;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link WorkspaceUtils} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceUtilsTests {

	/**
	 * Tests {@link WorkspaceUtils#getListener(Object)} with a <code>null</code> {@link Object}.
	 */
	@Test
	public void getListenerNull() {
		final IListener listener = WorkspaceUtils.getListener(null);
		assertEquals(null, listener);
	}

	/**
	 * Tests {@link WorkspaceUtils#getListener(Object)} with an {@link org.eclipse.core.resources.IWorkspace
	 * IWorkspace}.
	 */
	@Test
	public void getListenerWorkspace() {
		final IListener listener1 = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());
		final IListener listener2 = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		assertTrue(listener1 instanceof WorkspaceListener);
		assertTrue(listener2 instanceof WorkspaceListener);
		assertTrue(listener1 == listener2);
	}

	/**
	 * Tests {@link WorkspaceUtils#getListener(Object)} with an {@link IWorkbench}.
	 */
	@Test
	public void getListenerWorkbench() {
		final IListener listener1 = WorkspaceUtils.getListener(PlatformUI.getWorkbench());
		final IListener listener2 = WorkspaceUtils.getListener(PlatformUI.getWorkbench());

		assertTrue(listener1 instanceof WorkbenchWindowListener);
		assertTrue(listener2 instanceof WorkbenchWindowListener);
		assertTrue(listener1 == listener2);
	}

	/**
	 * Tests {@link WorkspaceUtils#getListener(Object)} with an {@link IWorkbenchWindow}.
	 */
	@Test
	public void getListenerWorkbenchWindow() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final IListener listener1 = WorkspaceUtils.getListener(workbench.getActiveWorkbenchWindow());
		final IListener listener2 = WorkspaceUtils.getListener(workbench.getActiveWorkbenchWindow());

		assertTrue(listener1 instanceof WorkbenchPageListener);
		assertTrue(listener2 instanceof WorkbenchPageListener);
		assertTrue(listener1 == listener2);
	}

	/**
	 * Tests {@link WorkspaceUtils#getListener(Object)} with an {@link org.eclipse.ui.IWorkbenchPage
	 * IWorkbenchPage}.
	 */
	@Test
	public void getListenerWorkbenchPage() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
		final IListener listener1 = WorkspaceUtils.getListener(activeWorkbenchWindow.getActivePage());
		final IListener listener2 = WorkspaceUtils.getListener(activeWorkbenchWindow.getActivePage());

		assertTrue(listener1 instanceof WorkbenchPartListener);
		assertTrue(listener2 instanceof WorkbenchPartListener);
		assertTrue(listener1 == listener2);
	}

	// TODO add create and delete tests when the ListenerFactory can be extended...

}
