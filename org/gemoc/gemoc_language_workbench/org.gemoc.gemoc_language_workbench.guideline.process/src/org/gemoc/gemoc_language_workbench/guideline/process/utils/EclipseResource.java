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
package org.gemoc.gemoc_language_workbench.guideline.process.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.guideline.process.Activator;

public final class EclipseResource {

	private EclipseResource() {

	}
	
	private static IResource getResource(Class<?> resourceClass, String resourceFullPath) {
		if (resourceFullPath == null) {
			return null;
		}
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		return (IResource)workspaceRoot.findMember(resourceFullPath);
	}
	
//	private static IResource getResource(Class<?> resourceClass, URI resourceURI) {
//		return getResource(resourceClass, resourceURI.toPlatformString(true));
//	}

	public static URI getUri(IResource resource) {
		return EMFUri.from(resource);
	}

	public static IFile getFile(URI uri) {
		if (uri == null) {
			return null;
		}
		return getFile(uri.toPlatformString(true));
	}
	
	public static IFile getFile(String filePath) {
		IFile file = (IFile)getResource(IFile.class, filePath);
		return file;
	}

	public static void touch(URI uri) {
		try {
			getFile(uri).touch(new org.eclipse.core.runtime.NullProgressMonitor());
		} catch (CoreException e) {
			Activator.getDefault().error(e);
		}
	}

	public static IProject getProject(String projectName) {
		IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		return myWorkspaceRoot.getProject(projectName);
	}

	public static boolean existProject(String projectName) {
		return getProject(projectName).exists();
	}

	public static boolean isFile(IResource resource, String filePath) {
		Object possibleFile = resource.getAdapter(IFile.class);
		if (possibleFile != null) {
			return resource.equals(getFile(filePath));
		}
		return false;
	}
	
	/**
	 * verifies that the provided resource corresponds to the element pointed by the uri in the workspace.
	 * @param resource the IResource in the workspace
	 * @param uri the URI to check
	 * @return true if the URI corresponds to the IResource, false otherwise
	 */
	public static boolean matches(IResource resource, URI uri) {
		IFile file = getFile(uri);
		if (file == null) {
			return false;
		}
		return file.equals(resource);
	}

	/**
	 * verifies that the provided resource correspond to the expected type and the given URI.
	 * @param resource is the IResource to check
	 * @param resourceClass is the expected concrete Class for the IResource
	 * @param resourceURI is the expected URI for the resource. 
	 * @return true if the IResource matches the resourceClass and URI
	 */
	public static boolean matches(IResource resource, Class<?> resourceClass, URI resourceURI) {
		if (resourceURI == null) {
			return false;
		}
		return matches(resource, resourceClass, resourceURI.toPlatformString(true));
	}
	
	/**
	 * Verifies that both IResource are equivalent and that they are of the given type.
	 * @param resource is the IResource to check
	 * @param resourceClass is the expected concrete Class for the IResource
	 * @param comparedResource is the second IResource
	 * @return true if both IResource matches and the are of the correct kind
	 */
	public static boolean matches(IResource resource, Class<?> resourceClass, IResource comparedResource) {
		if (comparedResource == null) {
			return false;
		}
		return matches(resource, resourceClass, comparedResource.getFullPath().toString());
	}
	
	/**
	 * verifies that the provided resource corresponds to the expected type and the given path.
	 * @param resource is the IResource to check
	 * @param resourceClass is the expected concrete Class for the IResource
	 * @param resourceFullPath is the expected String of the path for the resource. It is workspace relative.
	 * @return true if the IResource matches the resourceClass and path
	 */
	public static boolean matches(IResource resource, Class<?> resourceClass, String resourceFullPath) {
		if (resource.getAdapter(resourceClass) != null) {
			return resource.equals(getResource(resourceClass, resourceFullPath));
		}
		return false;
	}

}
