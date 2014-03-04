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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;

/**
 * Filter {@link org.eclipse.core.resources.IFile IFile} with a given extension.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ExtensionFileFilter extends AbstractFileFilter {

	/**
	 * Extensions to {@link PatternFileFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange) keep}.
	 */
	private final Set<String> extensions = new HashSet<String>();

	/**
	 * Constructor.
	 * 
	 * @param extensions
	 *            extensions to {@link PatternFileFilter#keep(fr.obeo.dsl.workspace.listener.change.IChange)
	 *            keep}
	 */
	public ExtensionFileFilter(String... extensions) {
		for (String extension : extensions) {
			this.extensions.add("." + extension);
		}
	}

	@Override
	protected boolean matchFile(IFile file) {
		boolean res = false;

		for (String extension : extensions) {
			if (file.getName().endsWith(extension)) {
				res = true;
				break;
			}
		}

		return res;
	}

}
