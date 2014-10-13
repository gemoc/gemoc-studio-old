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
package fr.obeo.dsl.workspace.listener.tests.filter;

import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;
import fr.obeo.dsl.workspace.listener.filter.ResourceFilter;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link ResourceFilter} class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ResourceFilterTests {

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceAdded} with a kept {@link IFile}.
	 */
	@Test
	public void keepAddFileKept() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));

		filter.getSet().add(file);

		final ResourceAdded change = new ResourceAdded(file);
		assertEquals(change, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceAdded} with a not kept {@link IFile}.
	 */
	@Test
	public void keepAddFileNotKept() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.notkeep"));

		final ResourceAdded change = new ResourceAdded(file);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceAdded} with a {@link IContainer} not containing kept {@link IFile}.
	 */
	@Test
	public void keepAddContainerNoKeptFile() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IContainer container = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder"));

		final ResourceAdded change = new ResourceAdded(container);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceRemoved} with a kept {@link IFile}.
	 */
	@Test
	public void keepRemoveFileKept() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));

		filter.getSet().add(file);

		filter.keep(new ResourceAdded(file));
		final ResourceRemoved change = new ResourceRemoved(file);
		assertEquals(change, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceRemoved} with a not kept {@link IFile}.
	 */
	@Test
	public void keepRemoveFileNotKept() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.notkeep"));

		final ResourceRemoved change = new ResourceRemoved(file);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceRemoved} with a {@link IContainer} not containing kept {@link IFile}.
	 */
	@Test
	public void keepRemoveContainerNoKeptFile() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IContainer container = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test/folder"));

		final ResourceRemoved change = new ResourceRemoved(container);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileKeptToNotExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.keep"));

		filter.getSet().add(origin);
		filter.getSet().add(destination);

		filter.keep(new ResourceAdded(origin));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(change, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a not kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileNotKeptToNotExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.notkeep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.notkeep"));

		filter.keep(new ResourceAdded(origin));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileKeptToNotKeptNotExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.notkeep"));

		filter.getSet().add(origin);

		filter.keep(new ResourceAdded(origin));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		final IChange<?> filtered = filter.keep(change);
		assertEquals(change, filtered);
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a not kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileNotKeptToKeptNotExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.notkeep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.keep"));

		filter.getSet().add(destination);

		filter.keep(new ResourceAdded(origin));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		final IChange<?> filtered = filter.keep(change);
		assertEquals(change, filtered);
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a {@link IContainer} not containing kept {@link IFile}.
	 */
	@Test
	public void keepMoveContainerNoKeptFileToNotExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IContainer origin = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(new Path("/test/folder"));
		final IContainer destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test2/folder"));

		filter.keep(new ResourceAdded(origin));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileKeptToExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.keep"));
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test2.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.keep"));

		filter.getSet().add(origin);
		filter.getSet().add(file);
		filter.getSet().add(destination);

		filter.keep(new ResourceAdded(origin));
		filter.keep(new ResourceAdded(file));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(change, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a not kept {@link IFile}.
	 */
	@Test
	public void keepMoveFileNotKeptToExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IFile origin = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test/folder/test.notkeep"));
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test2.keep"));
		final IFile destination = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test.notkeep"));

		filter.getSet().add(file);

		filter.keep(new ResourceAdded(origin));
		filter.keep(new ResourceAdded(file));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(null, filter.keep(change));
	}

	/**
	 * Tests {@link ResourceFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)} with
	 * {@link ResourceMoved} with a {@link IContainer} not containing kept {@link IFile}.
	 */
	@Test
	public void keepMoveContainerNoKeptFileToExisting() {
		final ResourceFilter<IFile> filter = new ResourceFilter<IFile>();
		final IContainer origin = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(new Path("/test/folder"));
		final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
				new Path("/test2/folder/test2.notkeep"));
		final IContainer destination = ResourcesPlugin.getWorkspace().getRoot().getFolder(
				new Path("/test2/folder"));

		filter.keep(new ResourceAdded(origin));
		filter.keep(new ResourceAdded(file));
		filter.keep(new ResourceAdded(destination));
		final ResourceMoved change = new ResourceMoved(origin, destination);
		assertEquals(null, filter.keep(change));
	}

}
