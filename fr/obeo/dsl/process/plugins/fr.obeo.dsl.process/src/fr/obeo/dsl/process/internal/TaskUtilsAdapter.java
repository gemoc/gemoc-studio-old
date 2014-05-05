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
package fr.obeo.dsl.process.internal;

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.ITaskUtils;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * {@link Task} utility class.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class TaskUtilsAdapter extends AdapterImpl implements ITaskUtils {
	// TODO implement...
	/**
	 * Tells if the {@link TaskUtilsAdapter#getTarget() attached} {@link Task} is reachable.
	 */
	private boolean reachable;

	/**
	 * Constructor.
	 */
	public TaskUtilsAdapter() {
		super();
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
		update();
	}

	@Override
	public void notifyChanged(Notification msg) {
		super.notifyChanged(msg);

		final Task task = (Task)getTarget();
		if (msg.getFeature() == ProcessPackage.eINSTANCE.getTask_PrecedingTasks()) {
			update();
			if (task instanceof ComposedTask) {
				Set<Task> initialTasks = new HashSet<Task>();
			}
		} else if (msg.getFeature() == ProcessPackage.eINSTANCE.getComposedTask_InitialTasks()) {
			// final ITaskUtils tool = ProcessUtils.getTool(msg.get);
			// ((TaskUtilsAdapter)tool).update();
		}
		// TODO initialTasks
		// TODO containment feature process_task
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.ITaskUtils#isReachable()
	 */
	public boolean isReachable() {
		return reachable;
	}

	/**
	 * Updates the adapter with the given {@link Task}.
	 */
	private void update() {
		boolean newReachable = false;

		final Task task = (Task)getTarget();
		if (task.eContainingFeature() == ProcessPackage.eINSTANCE.getProcess_Task()) {
			newReachable = true;
		} else {
			for (Task preceding : ProcessUtils.getPrecedingTasks(task)) {
				final ITaskUtils tool = ProcessUtils.getTool(preceding);
				if (tool.isReachable()) {
					newReachable = true;
					break;
				}
			}
		}

		if (reachable != newReachable) {
			reachable = newReachable;
			for (Task following : ProcessUtils.getFollowingTasks(task)) {
				final ITaskUtils tool = ProcessUtils.getTool(following);
				((TaskUtilsAdapter)tool).update();
			}
		}
	}

}
