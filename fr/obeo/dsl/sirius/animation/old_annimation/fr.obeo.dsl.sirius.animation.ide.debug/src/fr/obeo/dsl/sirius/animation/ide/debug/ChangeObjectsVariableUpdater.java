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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;

import com.google.common.collect.Sets;

import fr.obeo.dsl.sirius.animation.AnimationPackage;
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Variable;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

public class ChangeObjectsVariableUpdater extends ResourceSetListenerImpl {

	private Set<EObject> changedObjects = Sets.newLinkedHashSet();
	private StackFrame frame;

	public ChangeObjectsVariableUpdater(StackFrame frame) {
		this.frame = frame;
	}

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}

	@Override
	public boolean isAggregatePrecommitListener() {
		return true;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event)
			throws RollbackException {
		for (Notification change : event.getNotifications()) {
			if (!change.isTouch()) {
				if (change.getNotifier() instanceof EObject
						&& ((EObject) change.getNotifier()).eClass()
								.getEPackage() != AnimationPackage.eINSTANCE
						&& ((EObject) change.getNotifier()).eClass()
								.getEPackage() != ViewpointPackage.eINSTANCE)
					changedObjects.add((EObject) change.getNotifier());
			}
		}
		if (changedObjects.size() > 0) {

			return new RecordingCommand(event.getEditingDomain()) {

				@Override
				protected void doExecute() {
					Variable changedObjs = frame
							.getOrCreateVariable("modified");
					changedObjs.getElements().clear();
					changedObjs.getElements().addAll(changedObjects);
					changedObjects.clear();
				}
			};
		} else {
			return super.transactionAboutToCommit(event);
		}
	}

}
