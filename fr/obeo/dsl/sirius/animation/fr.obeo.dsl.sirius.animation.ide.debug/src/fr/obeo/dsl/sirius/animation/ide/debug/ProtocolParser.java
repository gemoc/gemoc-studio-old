/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.ide.debug;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import fr.obeo.dsl.sirius.animation.AnimationFactory;

public class ProtocolParser extends ResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		Resource res = createResource();
		return res;
	}

	private Resource createResource() {
		Resource res = new AnimationResource(
				URI.createURI("animation:/currentsessions"));
		EObject rootObject = AnimationFactory.eINSTANCE.createCurrentSessions();
		res.getContents().add(rootObject);
		return res;
	}

	public Resource getOrCreateDebugResource(ResourceSet resourceSet) {
		Resource found = null;
		Iterator<Resource> its = resourceSet.getResources().iterator();
		while (found == null && its.hasNext()) {
			Resource res = its.next();
			if (res.getURI() != null && res.getURI().scheme() != null
					&& "animation".equals(res.getURI().scheme())) {
				found = res;
			}
		}

		if (found == null) {
			found = createResource();
		}
		return found;
	}
}
