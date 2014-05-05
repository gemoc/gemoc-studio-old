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
package fr.obeo.dsl.process.design.action;

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Task;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction2;

/**
 * Toggles a {@link Task} has being {@link ComposedTask#getInitialTasks() initial} in its
 * {@link Task#getParentTask() parent task}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class ToggleInitialTask implements IExternalJavaAction2 {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#execute(java.util.Collection, java.util.Map)
	 */
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		for (EObject selection : selections) {
			final Task task = (Task)selection;
			final ComposedTask parentTask = task.getParentTask();
			if (selection instanceof Task && parentTask != null) {
				if (!parentTask.getInitialTasks().remove(selection)) {
					parentTask.getInitialTasks().add((Task)selection);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction#canExecute(java.util.Collection)
	 */
	public boolean canExecute(Collection<? extends EObject> selections) {
		boolean res = false;

		for (EObject selection : selections) {
			if (selection instanceof Task) {
				res = true;
				break;
			}
		}

		return res;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.tools.api.ui.IExternalJavaAction2#mayDeleteElements()
	 */
	public boolean mayDeleteElements() {
		return false;
	}

}
