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
package org.gemoc.gemoc_language_workbench.process.task;

import fr.obeo.dsl.workspace.listener.change.resource.AbstractResourceChange;
import fr.obeo.dsl.workspace.listener.change.resource.ResourceMoved;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.ui.Activator;
import org.gemoc.gemoc_language_workbench.ui.builder.GemocLanguageDesignerNature;

/**
 * Utility class for the Gemoc process.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public final class GemocProcessUtils {

	/**
	 * Constructor.
	 */
	private GemocProcessUtils() {
		// nothing to do here
	}

	/**
	 * Tells if the given {@link IResource} is an XDSML file.
	 * 
	 * @param resource
	 *            the {@link IResource}
	 * @return <code>true</code> if the given {@link IResource} is an XDSML file,<code>false</code> otherwise
	 */
	public static boolean isXDSMLFile(IResource resource) {
		// TODO add isInGemocProject(resource)
		return resource != null
				&& resource.getAdapter(IFile.class) != null
				&& Activator.GEMOC_PROJECT_CONFIGURATION_FILE_EXTENSION.equals(resource.getFileExtension());
	}

	/**
	 * Tells if the given {@link IResource} is in a project with the Gemoc nature.
	 * 
	 * @param resource
	 *            the {@link IResource}
	 * @return <code>true</code> if the given {@link IResource} is in a project with the Gemoc nature,
	 *         <code>false</code> otherwise
	 */
	public static boolean isInGemocProject(final IResource resource) {
		boolean res;
		try {
			res = resource.getProject().hasNature(GemocLanguageDesignerNature.NATURE_ID);
		} catch (CoreException e) {
			res = false;
		}
		return res;
	}

	/**
	 * Checks if the given {@link AbstractResourceChange} matches the given resource full path.
	 * 
	 * @param resourceFullPath
	 *            the resrouce full path
	 * @param change
	 *            the {@link AbstractResourceChange}
	 * @return <code>true</code> if the given {@link AbstractResourceChange} matches the given project name,
	 *         <code>false</code> otherwise
	 */
	public static boolean checkResourceChange(String resourceFullPath, AbstractResourceChange change) {
		return change.getObject().getFullPath().toString().equals(resourceFullPath)
				|| ((change instanceof ResourceMoved) && ((ResourceMoved)change).getDestination()
						.getFullPath().toString().equals(resourceFullPath));
	}

}
