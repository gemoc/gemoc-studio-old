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
package org.gemoc.gemoc_language_workbench.process.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

public final class EclipseResource {

	private EclipseResource() {

	}
	
	private static IResource getResource(Class<?> resourceClass, String resourceFullPath) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public static boolean checkFile(IResource resource, URI uri) {
		IFile file = getFile(uri);
		if (file == null) {
			return false;
		}
		return file.equals(resource);
	}

	public static boolean check(IResource resource, Class<?> resourceClass, URI resourceURI) {
		return check(resource, resourceClass, resourceURI.toPlatformString(true));
	}
	
	public static boolean check(IResource resource, Class<?> resourceClass, IResource comparedResource) {
		return check(resource, resourceClass, comparedResource.getFullPath().toString());
	}
	
	public static boolean check(IResource resource, Class<?> resourceClass, String resourceFullPath) {
		if (resource.getAdapter(resourceClass) != null) {
			return resource.equals(getResource(resourceClass, resourceFullPath));
		}
		return false;
	}

}
