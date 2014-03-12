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
import fr.obeo.dsl.workspace.workbench.EditorReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
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
 * Tests the {@link EMFProcessor} class for workbench part changes.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EMFProcessorWorkbenchPartListenerTests {

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
	 * Tests {@link IWorkbenchPartListener#partActivated(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partActivated() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			activePage.activate(activePart);

			final EObject eActivePartRef = processor.getObject(activePage.getReference(activePart));
			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
			assertEquals(eActivePartRef, ((WorkbenchPage)eActivePage).getActivePart());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partBroughtToTop() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
			// TODO the model is not changed on this IChange for the moment
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partClosed(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partClosed() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			final FileEditorInput input = new FileEditorInput(textFile);
			editor = activePage.openEditor(input, editorId);

			activePage.closeEditor(editor, false);

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			assertEquals(null, eEditorRef);
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partDeactivated() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			final EObject eActivePartRef = processor.getObject(activePage.getReference(activePart));
			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
			assertTrue(eActivePartRef != ((WorkbenchPage)eActivePage).getActivePart());
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partOpened(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partOpened() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partHidden(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partHidden() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			final FileEditorInput input = new FileEditorInput(textFile);
			editor = activePage.openEditor(input, editorId);

			activePage.closeEditor(editor, false);

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertEquals(null, eEditorRef);
			assertTrue(eActivePage instanceof WorkbenchPage);
			// TODO the model is not changed on this IChange for the moment
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partVisible(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partVisible() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
			// TODO the model is not changed on this IChange for the moment
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkbenchPartListener#partInputChanged(org.eclipse.ui.IWorkbenchPartReference)}.
	 * 
	 * @throws PartInitException
	 *             if the editor can't be opened
	 */
	@Test
	public void partInputChanged() throws PartInitException {
		final EMFProcessor processor = new EMFProcessor();
		final IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage activePage = activeWindow.getActivePage();

		IEditorPart editor = null;
		try {
			final String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(
					textFile.getName()).getId();
			editor = activePage.openEditor(new FileEditorInput(textFile), editorId);

			activePage.reuseEditor((IReusableEditor)editor, new FileEditorInput(textFile));

			final EObject eEditorRef = processor.getObject(activePage.getReference(editor));
			final EObject eActivePage = processor.getObject(activePage);
			assertTrue(eEditorRef instanceof EditorReference);
			assertTrue(eActivePage instanceof WorkbenchPage);
			// TODO the model is not changed on this IChange for the moment
		} finally {
			if (editor != null) {
				activePage.closeEditor(editor, false);
			}
			WorkspaceUtils.removeProcessor(processor);
		}
	}

}
