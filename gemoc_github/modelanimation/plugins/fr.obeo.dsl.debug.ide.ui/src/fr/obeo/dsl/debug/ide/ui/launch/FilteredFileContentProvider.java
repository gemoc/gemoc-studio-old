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
package fr.obeo.dsl.debug.ide.ui.launch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.model.WorkbenchContentProvider;

/**
 * a {@link WorkbenchContentProvider} keeping only {@link IFile} with supported extension.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class FilteredFileContentProvider extends WorkbenchContentProvider {

	/**
	 * The supported file extensions.
	 */
	private final String[] extensions;

	/**
	 * Constructor.
	 * 
	 * @param extensions
	 *            the supported file extensions
	 */
	public FilteredFileContentProvider(final String[] extensions) {
		this.extensions = extensions;
	}

	@Override
	public Object[] getChildren(final Object element) {
		List<Object> children = Arrays.asList(super.getChildren(element));
		List<Object> filteredChildren = new ArrayList<Object>(children);

		for (Object child : children) {
			if ((child instanceof IFile) && (!isAccepted((IFile)child))) {
				filteredChildren.remove(child);
			}
		}

		return filteredChildren.toArray();
	}

	/**
	 * Tells if the given {@link IFile} should be accepted as a child of the tree.
	 * 
	 * @param child
	 *            the {@link IFile} to check
	 * @return <code>true</code> if the {@link IFile} extension is one of
	 *         {@link FilteredFileContentProvider#extensions}, <code>false</code> otherwise
	 */
	private boolean isAccepted(final IFile child) {
		boolean res = false;

		for (String extension : extensions) {
			if (extension.equalsIgnoreCase(child.getFileExtension())) {
				res = true;
				break;
			}
		}

		return res;
	}
}
