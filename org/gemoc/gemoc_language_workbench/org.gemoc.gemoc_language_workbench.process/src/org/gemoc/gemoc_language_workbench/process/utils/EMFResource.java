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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public final class EMFResource {

	private EMFResource() {

	}

	public static Object getFirstContent(IFile xmiFile) {
		return getFirstContent(getResource(xmiFile));
	}

	public static Object getFirstContent(String uriAsString) {
		return getFirstContent(getResource(uriAsString));
	}
	
	public static Object getFirstContent(URI uri) {
		return getFirstContent(getResource(uri));
	}
	
	private static Object getFirstContent(Resource resource) {
		if (resource.getContents().size() > 0) {
			return resource.getContents().get(0);
		} else {
			return null;
		}
	}

	public static Resource getResource(String uriAsString) {
		URI uri = URI.createURI(uriAsString);
		return getResource(uri);
	}
	
	public static Resource getResource(IFile file) {
		URI uri = URI.createURI(file.getLocationURI().toString());
		return getResource(uri);
	}
	
	public static Resource getResource(URI uri) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource r = resourceSet.getResource(uri, true);
		return r;
	}

}
