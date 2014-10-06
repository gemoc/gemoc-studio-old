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
package fr.obeo.dsl.process;

import fr.obeo.dsl.process.impl.ProcessVariableToObjectMapImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * Abstract implementation of {@link IProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractProcessRunner implements IProcessRunner {

	/**
	 * Listen to {@link ProcessContext#setDone(ActionTask, Object)} and
	 * {@link ProcessContext#setUndone(ActionTask, String)}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class ProgressListener extends AdapterImpl {

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getFeatureID(ActionTask.class) == Notification.NO_FEATURE_ID
					&& msg.getNotifier() instanceof ActionTask) {
				ActionTask task = (ActionTask)msg.getNotifier();
				for (Task following : ProcessUtils.getFollowingTasks(task)) {
					if (following instanceof ActionTask) {
						activateOrDeactivate((ActionTask)following);
					} else if (following instanceof ComposedTask) {
						for (ActionTask initialTask : ProcessUtils
								.getInitialActionTasks((ComposedTask)following)) {
							activateOrDeactivate((ActionTask)initialTask);
						}
					} else {
						throw new IllegalStateException("don't know what to do with "
								+ following.eClass().getName());
					}
				}
			}
		}

		/**
		 * {@link AbstractProcessRunner#activate(ActionTask) Activates} or
		 * {@link AbstractProcessRunner#deactivate(ActionTask) deactivates} the given {@link ActionTask}.
		 * 
		 * @param task
		 *            The {@link ActionTask}
		 */
		private void activateOrDeactivate(ActionTask task) {
			if (ProcessUtils.evaluatePrecondition(getContext(), task)) {
				activate(task);
			} else {
				deactivate(task);
			}
		}
	}

	/**
	 * Listen to {@link ProcessContext#setVariableValue(ProcessVariable, Object, ActionTask)}.
	 * 
	 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
	 */
	private final class VariablesListener extends EContentAdapter {

		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getEventType() == Notification.SET
					&& notification.getFeatureID(ProcessVariableToObjectMapImpl.class) == ProcessPackage.PROCESS_VARIABLE_TO_OBJECT_MAP__VALUE
					&& notification.getNewValue() != null
					&& notification.getNotifier() instanceof ProcessVariableToObjectMapImpl) {
				final ProcessVariableToObjectMapImpl entry = (ProcessVariableToObjectMapImpl)notification
						.getNotifier();
				final Object newValue = notification.getNewValue();
				if (!newValue.equals(notification.getOldValue())) {
					for (Entry<ActionTask, IActionTaskProcessor> activeEntry : getActiveProcessors()
							.entrySet()) {
						if (activeEntry.getKey().getObservedVariables().contains(entry.getKey())) {
							activeEntry.getValue().validate(getContext());
						}
					}
				}
			}
		}

	}

	/**
	 * Known {@link IActionTaskProcessor}.
	 */
	private final Map<ActionTask, IActionTaskProcessor> processors = new HashMap<ActionTask, IActionTaskProcessor>();

	/**
	 * Active {@link IActionTaskProcessor}.
	 */
	private final Map<ActionTask, IActionTaskProcessor> activeProcessors = new LinkedHashMap<ActionTask, IActionTaskProcessor>();

	/**
	 * The {@link ProcessContext}.
	 */
	private final ProcessContext processContext;

	/**
	 * The {@link ProgressListener}.
	 */
	private final ProgressListener progressListener = new ProgressListener();

	/**
	 * The {@link VariablesListener}.
	 */
	private final VariablesListener variablesListener = new VariablesListener();

	/**
	 * Constructor.
	 * 
	 * @param processContext
	 *            the {@link ProcessContext}
	 * @param listenToVariable
	 *            tells if we should listen to
	 *            {@link ProcessContext#setVariableValue(ProcessVariable, Object, ActionTask)} and
	 *            {@link ProcessContext#getVariableValue(ProcessVariable, ActionTask)}.
	 */
	public AbstractProcessRunner(ProcessContext processContext, boolean listenToVariable) {
		this.processContext = processContext;

		final Iterator<EObject> it = processContext.getDefinition().eAllContents();
		while (it.hasNext()) {
			EObject eObj = it.next();
			if (eObj instanceof ActionTask) {
				getProcessors().put((ActionTask)eObj, instanciate((ActionTask)eObj));
			}
		}
		if (listenToVariable) {
			processContext.eAdapters().add(variablesListener);
		}
		for (ActionTask task : ProcessUtils.getInitialActionTasks(processContext.getDefinition())) {
			activate(task);
		}
	}

	/**
	 * Instanciates an {@link IActionTaskProcessor} for the given {@link ActionTask}.
	 * 
	 * @param task
	 *            the {@link ActionTask}
	 * @return a new {@link IActionTaskProcessor} for the given {@link ActionTask}
	 */
	protected IActionTaskProcessor instanciate(ActionTask task) {
		IActionTaskProcessor res = null;

		try {
			@SuppressWarnings("unchecked")
			final Class<? extends IActionTaskProcessor> cls = (Class<? extends IActionTaskProcessor>)AbstractProcessRunner.class
					.getClassLoader().loadClass(task.getInstanceClassName());
			final Constructor<? extends IActionTaskProcessor> constructor = cls
					.getConstructor(ActionTask.class);
			res = constructor.newInstance(task);
		} catch (ClassNotFoundException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (SecurityException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (InstantiationException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			Activator.getDefault().error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			Activator.getDefault().error(e.getMessage(), e);
		}

		return res;
	}

	protected Map<ActionTask, IActionTaskProcessor> getProcessors() {
		return processors;
	}

	protected Map<ActionTask, IActionTaskProcessor> getActiveProcessors() {
		return activeProcessors;
	}

	/**
	 * Activate the given {@link ActionTask}. Its {@link ActionTask#getPrecondition()} must be
	 * {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task) evaluated} to <code>true</code>.
	 * 
	 * @param task
	 *            the {@link ActionTask} to activate
	 */
	protected void activate(ActionTask task) {
		final IActionTaskProcessor processor = getProcessors().get(task);
		if (!activeProcessors.containsKey(task)) {
			processor.validate(getContext());
			task.eAdapters().add(progressListener);
			activeProcessors.put(task, processor);
		}
	}

	/**
	 * Deactivate the given {@link ActionTask}. Its {@link ActionTask#getPrecondition()} must be
	 * {@link ProcessUtils#evaluatePrecondition(ProcessContext, Task) evaluated} to <code>false</code>.
	 * 
	 * @param task
	 *            the {@link ActionTask} to deactivate
	 */
	protected void deactivate(ActionTask task) {
		final IActionTaskProcessor processor = getActiveProcessors().remove(task);
		if (processor != null) {
			task.eAdapters().remove(progressListener);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getContext()
	 */
	public ProcessContext getContext() {
		return processContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#doAction(fr.obeo.dsl.process.ActionTask)
	 */
	public void doAction(ActionTask task) {
		getActiveProcessors().get(task).doAction(getContext());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#undoAction(fr.obeo.dsl.process.ActionTask)
	 */
	public void undoAction(ActionTask task) {
		getActiveProcessors().get(task).undoAction(getContext());
	}

	/**
	 * Disposes this {@link IProcessRunner}.
	 */
	public void dispose() {
		processContext.eAdapters().remove(variablesListener);
		for (ActionTask task : getActiveProcessors().keySet()) {
			task.eAdapters().remove(progressListener);
		}
	}

}
