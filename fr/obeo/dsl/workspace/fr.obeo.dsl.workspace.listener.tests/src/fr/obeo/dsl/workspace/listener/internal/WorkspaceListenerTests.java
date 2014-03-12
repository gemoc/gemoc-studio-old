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
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceClosed;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceDescriptionChanged;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceOpened;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;
import fr.obeo.dsl.workspace.listener.tests.TestProjectNature;
import fr.obeo.dsl.workspace.listener.tests.change.processor.TestProcessor;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests the {@link WorkspaceListener} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class WorkspaceListenerTests {

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
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)} adding
	 * an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedAdd() {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}

			listener.addProcessor(processor, false);
			project.create(new NullProgressMonitor());

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceAdded);

			final ResourceAdded change = (ResourceAdded)processor.getChanges().get(0);

			assertEquals(project, change.getObject());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * removing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedRemove() {
		final TestProcessor processor = new TestProcessor();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			project.create(new NullProgressMonitor());
			listener.addProcessor(processor, false);
			project.delete(true, new NullProgressMonitor());

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceRemoved);

			final ResourceRemoved change = (ResourceRemoved)processor.getChanges().get(0);

			assertEquals(project, change.getObject());

		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)} moving
	 * an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceChangedMove() {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
			listener.addProcessor(processor, false);

			final Path destination = new Path("/test2");
			project.move(destination, true, new NullProgressMonitor());

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceMoved);

			final ResourceMoved change = (ResourceMoved)processor.getChanges().get(0);

			assertEquals(project, change.getObject());
			assertEquals(destination, change.getDestination().getFullPath());

			project.delete(true, new NullProgressMonitor());
			ResourcesPlugin.getWorkspace().getRoot().getProject("test2").delete(true,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * opening an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceOpened() {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			listener.addProcessor(processor, false);
			project.open(new NullProgressMonitor());

			assertEquals(1, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceOpened);

			final ResourceOpened change = (ResourceOpened)processor.getChanges().get(0);

			assertEquals(project, change.getObject());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * closing an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceClosed() {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
			listener.addProcessor(processor, false);
			project.close(new NullProgressMonitor());

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceClosed);

			final ResourceClosed change = (ResourceClosed)processor.getChanges().get(0);

			assertEquals(project, change.getObject());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

	/**
	 * Tests {@link WorkspaceListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)}
	 * changing description of an {@link org.eclipse.core.resources.IResource IResource}.
	 */
	@Test
	public void resourceDescriptionChanged() {
		final TestProcessor processor = new TestProcessor();
		final IListener listener = WorkspaceUtils.getListener(ResourcesPlugin.getWorkspace());

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("test");
			if (project.exists()) {
				project.delete(true, new NullProgressMonitor());
			}
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
			listener.addProcessor(processor, false);
			final IProjectDescription description = project.getDescription();
			final String[] natureIDs = description.getNatureIds();
			final String[] newNatureIDs = Arrays.copyOf(natureIDs, natureIDs.length + 1);
			newNatureIDs[natureIDs.length] = TestProjectNature.ID;
			description.setNatureIds(newNatureIDs);
			project.setDescription(description, new NullProgressMonitor());

			assertEquals(2, processor.getChanges().size());
			assertTrue(processor.getChanges().get(0) instanceof ResourceDescriptionChanged);

			final ResourceDescriptionChanged change = (ResourceDescriptionChanged)processor.getChanges().get(
					0);

			assertEquals(project, change.getObject());

			project.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} finally {
			listener.removeProcessor(processor);
		}
	}

}
