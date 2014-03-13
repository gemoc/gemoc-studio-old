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

import fr.obeo.dsl.workspace.File;
import fr.obeo.dsl.workspace.Folder;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.WorkspaceRoot;
import fr.obeo.dsl.workspace.listener.WorkspaceUtils;
import fr.obeo.dsl.workspace.listener.emf.EMFProcessor;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the {@link EMFProcessor} class for space changes.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class EMFProcessorWorkspaceListenerTests {

	/**
	 * Clears the workspace after each test.
	 */
	@After
	public void afterTest() {
		try {
			for (IResource resource : ResourcesPlugin.getWorkspace().getRoot().members()) {
				resource.delete(true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * adding an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedAddProject() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), processor.getObject(project));

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * removing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedRemoveProject() {
		final EMFProcessor processor = new EMFProcessor();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");

		try {
			project.create(new NullProgressMonitor());

			project.delete(true, new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());

			assertEquals(0, eWorkspaceRoot.getMembers().size());

		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * moving an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedMoveProject() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final Path destination = new Path("/test2");
			project.move(destination, true, new NullProgressMonitor());
			final IProject project2 = ResourcesPlugin.getWorkspace().getRoot().getProject("test2");

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(null, processor.getObject(project));
			assertEquals(eWorkspaceRoot, ((Project)processor.getObject(project2)).getParent());
			assertEquals("test2", ((Project)processor.getObject(project2)).getName());

			project.delete(true, new NullProgressMonitor());
			project2.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * adding an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedAddFile() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/file.txt"));
			file.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
					new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(file);
			assertTrue(eFile instanceof File);
			assertEquals(eProject, ((File)eFile).getParent());
			assertEquals("file.txt", ((File)eFile).getName());

			file.delete(true, new NullProgressMonitor());
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * removing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedRemoveFile() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/file.txt"));
			file.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
					new NullProgressMonitor());
			file.delete(true, new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(file);
			assertEquals(null, eFile);
			assertEquals(1, ((Project)eProject).getMembers().size());
			assertEquals(".project", ((Project)eProject).getMembers().get(0).getName());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * moving an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedMoveFile() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/file.txt"));
			file.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
					new NullProgressMonitor());
			file.move(new Path("/test/file2.txt"), true, new NullProgressMonitor());
			final IFile file2 = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path("/test/file2.txt"));

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(file);
			final EObject eFile2 = processor.getObject(file2);
			assertEquals(null, eFile);
			assertEquals(eProject, ((File)eFile2).getParent());
			assertEquals("file2.txt", ((File)eFile2).getName());

			file.delete(true, new NullProgressMonitor());
			file2.delete(true, new NullProgressMonitor());
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * adding an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedAddFolder() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder"));
			folder.create(true, true, new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(folder);
			assertTrue(eFile instanceof Folder);
			assertEquals(eProject, ((Folder)eFile).getParent());
			assertEquals("folder", ((Folder)eFile).getName());

			folder.delete(true, new NullProgressMonitor());
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * removing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedRemoveFolder() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder"));
			folder.create(true, true, new NullProgressMonitor());
			folder.delete(true, new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(folder);
			assertEquals(null, eFile);
			assertEquals(1, ((Project)eProject).getMembers().size());
			assertEquals(".project", ((Project)eProject).getMembers().get(0).getName());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * moving an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedMoveFolder() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder"));
			folder.create(true, true, new NullProgressMonitor());
			folder.move(new Path("/test/folder2"), true, new NullProgressMonitor());
			final IFolder folder2 = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder2"));

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(folder);
			final EObject eFile2 = processor.getObject(folder2);
			assertEquals(null, eFile);
			assertEquals(eProject, ((Folder)eFile2).getParent());
			assertEquals("folder2", ((Folder)eFile2).getName());

			folder.delete(true, new NullProgressMonitor());
			folder2.delete(true, new NullProgressMonitor());
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * removing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedRemoveFolderNotEmpty() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder"));
			folder.create(true, true, new NullProgressMonitor());
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path("/test/folder/file.txt"));
			file.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
					new NullProgressMonitor());
			folder.delete(true, new NullProgressMonitor());

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(folder);
			assertEquals(null, eFile);
			assertEquals(1, ((Project)eProject).getMembers().size());
			assertEquals(".project", ((Project)eProject).getMembers().get(0).getName());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * moving an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedMoveFolderNotEmpty() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder"));
			folder.create(true, true, new NullProgressMonitor());
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path("/test/folder/file.txt"));
			file.create(new ByteArrayInputStream("Test Test Test".getBytes()), true,
					new NullProgressMonitor());
			folder.move(new Path("/test/folder2"), true, new NullProgressMonitor());
			final IFolder folder2 = ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path("/test/folder2"));

			final WorkspaceRoot eWorkspaceRoot = (WorkspaceRoot)processor.getObject(ResourcesPlugin
					.getWorkspace().getRoot());
			final EObject eProject = processor.getObject(project);

			assertEquals(1, eWorkspaceRoot.getMembers().size());
			assertEquals(eWorkspaceRoot.getMembers().get(0), eProject);

			final EObject eFile = processor.getObject(folder);
			final EObject eFile2 = processor.getObject(folder2);
			assertEquals(null, eFile);
			assertEquals(eProject, ((Folder)eFile2).getParent());
			assertEquals("folder2", ((Folder)eFile2).getName());

			file.delete(true, new NullProgressMonitor());
			folder.delete(true, new NullProgressMonitor());
			folder2.delete(true, new NullProgressMonitor());
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * opening an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceOpened() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());

			final EObject eProject = processor.getObject(project);
			assertTrue(eProject instanceof Project);
			assertEquals(project.getDescription().getNatureIds().length, ((Project)eProject).getNatureId()
					.size());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * closing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceClosed() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
			project.close(new NullProgressMonitor());

			// TODO the model is not changed on this IChange for the moment
			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link IWorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * changing description of an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceDescriptionChanged() {
		final EMFProcessor processor = new EMFProcessor();

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
			final IProjectDescription description = project.getDescription();
			final String[] natureIDs = description.getNatureIds();
			final String[] newNatureIDs = Arrays.copyOf(natureIDs, natureIDs.length + 1);
			newNatureIDs[natureIDs.length] = TestProjectNature.ID;
			description.setNatureIds(newNatureIDs);
			project.setDescription(description, new NullProgressMonitor());

			final EObject eProject = processor.getObject(project);
			assertTrue(eProject instanceof Project);
			assertEquals(1, ((Project)eProject).getNatureId().size());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			WorkspaceUtils.removeProcessor(processor);
		}
	}

}
