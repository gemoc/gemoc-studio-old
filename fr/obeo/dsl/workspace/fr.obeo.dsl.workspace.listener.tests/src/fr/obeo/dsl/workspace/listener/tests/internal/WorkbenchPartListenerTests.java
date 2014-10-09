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
import fr.obeo.dsl.workspace.listener.change.workbench.PartActivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartBroughtToTop;
import fr.obeo.dsl.workspace.listener.change.workbench.PartClosed;
import fr.obeo.dsl.workspace.listener.change.workbench.PartDeactivated;
import fr.obeo.dsl.workspace.listener.change.workbench.PartHidden;
import fr.obeo.dsl.workspace.listener.change.workbench.PartInputChanged;
import fr.obeo.dsl.workspace.listener.change.workbench.PartOpened;
import fr.obeo.dsl.workspace.listener.change.workbench.PartVisible;
import fr.obeo.dsl.workspace.listener.tests.change.processor.TestProcessor;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener WorkbenchPartListener}
 * class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkbenchPartListenerTests {

	/**
	 * The test {@link IProject}.
	 */
	private static IProject project;

	/**
	 * The text {@link IFile}.
	 */
	private static IFile textFile;

	/**
	 * Initializes a project with a text file.
	 * 
	 * @throws CoreException
	 *             if {@link org.eclipse.core.resources.IResource IResource} can't be created
	 */
	@BeforeClass
	public static void beforeClass() throws CoreException {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
		textFile = project.getFile(new Path("file.txt"));
		textFile.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
				new NullProgressMonitor());
	}

	/**
	 * Removes the Project and the text file.
	 * 
	 * @throws CoreException
	 *             if {@link org.eclipse.core.resources.IResource IResource} can't be deleted
	 */
	@AfterClass
	public static void afterClass() throws CoreException {
		textFile.delete(true, new NullProgressMonitor());
		project.delete(true, new NullProgressMonitor());
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partActivated(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partActivated() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();
		final IListener listener = WorkspaceUtils.getListener(activePage);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);
			listener.addProcessor(processor, false);
			activePage.activate(activePart);

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(1) instanceof PartActivated);
			final PartActivated change = (PartActivated)processor.getChanges().get(1);
			assertEquals(activePage.getReference(activePart), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partBroughtToTop() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);
		listener.addProcessor(processor, false);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			assertEquals(5, processor.getChanges().size());
			assertTrue(processor.getChanges().get(2) instanceof PartBroughtToTop);
			final PartBroughtToTop change = (PartBroughtToTop)processor.getChanges().get(2);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partClosed(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partClosed() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			final FileEditorInput input = new FileEditorInput(textFile);
			editor = activePage.openEditor(input, editorId);

			listener.addProcessor(processor, false);
			activePage.closeEditor(editor, false);

			assertEquals(4, processor.getChanges().size());
			assertTrue(processor.getChanges().get(3) instanceof PartClosed);
			final PartClosed change = (PartClosed)processor.getChanges().get(3);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partDeactivated() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();
		final IListener listener = WorkspaceUtils.getListener(activePage);
		listener.addProcessor(processor, false);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			assertEquals(5, processor.getChanges().size());
			assertTrue(processor.getChanges().get(3) instanceof PartDeactivated);
			final PartDeactivated change = (PartDeactivated)processor.getChanges().get(3);
			assertEquals(activePage.getReference(activePart), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partOpened(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partOpened() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);
		listener.addProcessor(processor, false);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			assertEquals(5, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof PartOpened);
			final PartOpened change = (PartOpened)processor.getChanges().get(0);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partHidden(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partHidden() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			final FileEditorInput input = new FileEditorInput(textFile);
			editor = activePage.openEditor(input, editorId);

			listener.addProcessor(processor, false);
			activePage.closeEditor(editor, false);

			assertEquals(4, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof PartHidden);
			final PartHidden change = (PartHidden)processor.getChanges().get(0);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partVisible(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partVisible() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);
		listener.addProcessor(processor, false);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			assertEquals(5, processor.getChanges().size());
			assertTrue(processor.getChanges().get(1) instanceof PartVisible);
			final PartVisible change = (PartVisible)processor.getChanges().get(1);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests
	 * {@link fr.obeo.dsl.workspace.listener.internal.WorkbenchPartListener#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)}
	 * .
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partInputChanged() throws PartInitException {
		final TestProcessor processor = new TestProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IListener listener = WorkspaceUtils.getListener(activePage);

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);
			listener.addProcessor(processor, false);
			activePage.reuseEditor((IReusableEditor)editor, new FileEditorInput(textFile));

			assertEquals(1, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof PartInputChanged);
			final PartInputChanged change = (PartInputChanged)processor.getChanges().get(0);
			assertEquals(activePage.getReference(editor), change.getObject());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			listener.removeProcessor(processor);
		}
	}

}
