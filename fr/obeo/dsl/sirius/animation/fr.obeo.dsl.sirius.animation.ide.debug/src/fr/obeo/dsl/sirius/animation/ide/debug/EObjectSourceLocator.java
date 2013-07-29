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

import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IPersistableSourceLocator;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;

import com.google.common.collect.Sets;

import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.viewpoint.DRepresentation;
import fr.obeo.dsl.viewpoint.DRepresentationElement;
import fr.obeo.dsl.viewpoint.business.api.dialect.DialectManager;
import fr.obeo.dsl.viewpoint.business.api.query.DRepresentationElementQuery;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.ui.business.api.dialect.DialectUIManager;

public class EObjectSourceLocator implements IPersistableSourceLocator {

	public Object getSourceElement(IStackFrame stackFrame) {
		if (stackFrame instanceof IStackFrameAnimationAdapter) {
			StackFrame sourceElement = ((IStackFrameAnimationAdapter) stackFrame)
					.getHost();
			EObject elementToOpenElement = sourceElement.getSourceElement();

			return elementToOpenElement;
		} else {
			return null;
		}
	}

	public String getMemento() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public void initializeFromMemento(String memento) throws CoreException {
		// TODO Auto-generated method stub

	}

	public void initializeDefaults(ILaunchConfiguration configuration)
			throws CoreException {
		// TODO Auto-generated method stub

	}

}
