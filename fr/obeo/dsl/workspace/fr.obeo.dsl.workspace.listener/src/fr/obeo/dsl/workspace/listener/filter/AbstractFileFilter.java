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
package fr.obeo.dsl.workspace.listener.filter;

import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceAdded;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceRemoved;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

/**
 * Filters {@link IChange} related to {@link IFile} which {@link IFile#getName() name's}
 * {@link AbstractFileFilter#matchFile(String) matched}. It also {@link IFilter#keep(IChange) keeps}
 * {@link IChange} related to any {@link org.eclipse.core.resources.IContainer IContainer} of {@link IFile}
 * known to be {@link AbstractFileFilter#matchFile(String) matched}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractFileFilter implements IFilter {

	/**
	 * A node for tree construction.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private static final class Node {

		/**
		 * The value of this {@link Node}.
		 */
		private final String value;

		/**
		 * The parent {@link Node} if any, <code>null</code> otherwise.
		 */
		private final Node parent;

		/**
		 * Children {@link Node}.
		 */
		private final List<Node> children = new ArrayList<Node>();

		/**
		 * Constructor.
		 * 
		 * @param parent
		 *            the parent {@link Node} if any, <code>null</code> otherwise
		 * @param value
		 *            the value of this {@link Node}
		 */
		private Node(Node parent, String value) {
			this.parent = parent;
			this.value = value;
		}

		/**
		 * Gets the child with the given value.
		 * 
		 * @param val
		 *            the value
		 * @return the child if any, <code>null</code> otherwise
		 */
		private Node getChild(String val) {
			Node res = null;
			for (Node child : children) {
				if (child.value.equals(val)) {
					res = child;
					break;
				}
			}

			return res;
		}

		/**
		 * Pretty prints the tree at the given depth/prefix.
		 * 
		 * @param res
		 *            the resulting {@link StringBuilder}
		 * @param prefix
		 *            the depth/prefix
		 */
		void toString(StringBuilder res, String prefix) {
			res.append(prefix);
			res.append("- ");
			res.append(value);
			res.append('\n');

			for (Node child : children) {
				child.toString(res, prefix + "  ");
			}
		}

		@Override
		public String toString() {
			final StringBuilder res = new StringBuilder();
			toString(res, "");
			return res.toString();
		}

	}

	/**
	 * The tree.
	 */
	private final Node root = new Node(null, null);

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.filter.IFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public IChange<?> keep(IChange<?> change) {
		final IChange<?> res;

		IResource resource = (IResource)change.getObject();
		if (change instanceof ResourceAdded) {
			if (change.getObject() instanceof IFile && matchFile((IFile)change.getObject())) {
				remember(resource);
				res = change;
			} else {
				res = null;
			}
		} else if (change instanceof ResourceRemoved) {
			final Node forgotten = forget(resource);
			if (forgotten != null) {
				res = change;
			} else {
				res = null;
			}
		} else if (change instanceof ResourceMoved) {
			res = move((ResourceMoved)change);
		} else {
			if (change.getObject() instanceof IFile && matchFile((IFile)change.getObject())) {
				res = change;
			} else {
				res = null;
			}
		}

		return res;
	}

	/**
	 * Matches the given {@link IFile}.
	 * 
	 * @param file
	 *            the {@link IFile}
	 * @return <code>true</code> if the {@link IFile} is matched, <code>false</code> otherwise
	 */
	protected abstract boolean matchFile(IFile file);

	/**
	 * Moves according to the given {@link ResourceMoved}.
	 * 
	 * @param move
	 *            the {@link ResourceMoved}
	 * @return the {@link IChange} corresponding to the move
	 */
	private IChange<?> move(ResourceMoved move) {
		final IResource origin = move.getObject();
		final IResource destination = move.getDestination();
		final Node forgotten = forget(origin);
		final Node dest;

		if (destination instanceof IFile) {
			if (matchFile((IFile)destination)) {
				dest = remember(destination);
			} else {
				dest = null;
			}
		} else {
			if (forgotten != null) {
				dest = remember(destination);
			} else {
				dest = null;
			}
		}
		if (forgotten != null) {
			if (dest != null) {
				dest.children.addAll(forgotten.children);
			}
		}

		final IChange<?> res;

		if (forgotten != null) {
			if (dest != null) {
				res = move;
			} else {
				res = new ResourceRemoved(origin);
			}
		} else {
			if (dest != null) {
				res = new ResourceAdded(destination);
			} else {
				res = null;
			}
		}

		return res;
	}

	/**
	 * Forgets the given {@link IResource}.
	 * 
	 * @param resource
	 *            the {@link IResource} to forget
	 * @return the forgotten {@link Node} if any, <code>null</code> otherwise
	 */
	private Node forget(IResource resource) {
		final String[] segments = resource.getFullPath().segments();
		Node current = root.getChild(segments[0]);
		if (current != null) {
			for (int i = 1; i < segments.length; ++i) {
				current = current.getChild(segments[i]);
				if (current == null) {
					break;
				}
			}
		}

		if (current != null) {
			Node currentParent = current.parent;
			if (currentParent != null) {
				currentParent.children.remove(current);
				// delete any empty ancestors
				while (currentParent.parent != null && currentParent.children.size() == 0) {
					currentParent.parent.children.remove(currentParent);
					currentParent = currentParent.parent;
				}
			}
		}

		return current;
	}

	/**
	 * Remembers the given {@link IResource}.
	 * 
	 * @param resource
	 *            the {@link IResource} to remember
	 * @return the remembered {@link Node}
	 */
	private Node remember(IResource resource) {
		final String[] segments = resource.getFullPath().segments();
		Node current = root.getChild(segments[0]);
		if (current == null) {
			current = new Node(current, segments[0]);
			root.children.add(current);
		}
		for (int i = 1; i < segments.length; ++i) {
			Node next = current.getChild(segments[i]);
			if (next == null) {
				next = new Node(current, segments[i]);
				current.children.add(next);
			}
			current = next;
		}

		return current;
	}

}
