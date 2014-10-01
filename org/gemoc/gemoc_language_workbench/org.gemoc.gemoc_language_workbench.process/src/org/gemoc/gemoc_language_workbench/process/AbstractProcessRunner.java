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
package org.gemoc.gemoc_language_workbench.process;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IProcessRunner;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.impl.ProcessVariableToObjectMapImpl;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessRunner;
import org.gemoc.gemoc_language_workbench.process.support.ActionProcessorFactory;

public abstract class AbstractProcessRunner implements IProcessRunner, IChangeProcessor {

	/**
	 * {@link List} of {@link IActionProcessor}.
	 */
	protected final Map<Task, IActionProcessor> actionProcessors;

	/**
	 * The {@link ProcessContext}.
	 */
	private final ProcessContext processContext;

	private EContentAdapter adapter;

	/**
	 * The {@link Process}.
	 */
	private final Process process;

	public AbstractProcessRunner(String processPath, ProcessContext processContext) {
		Resource resource = new XMIResourceImpl();
		try {
			resource.load(GemocLanguageProcessRunner.class.getResourceAsStream(processPath),
					new HashMap<String, String>());
		} catch (IOException e) {
			Activator.getDefault().error(e);
		}
		process = (Process)resource.getContents().get(0);
		this.processContext = processContext;
		this.processContext.setDefinition(getProcess());

		adapter = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				processNotification(notification);
			}
		};
		processContext.eAdapters().add(adapter);
		processContext.getDefinition().eAdapters().add(adapter);

		actionProcessors = ActionProcessorFactory.createActionProcessors(process);
	}

	public void dispose() {
		if (processContext != null) {
			processContext.eAdapters().remove(adapter);
		}
	}

	protected Process getProcess() {
		return process;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getContext()
	 */
	public ProcessContext getContext() {
		return processContext;
	}

	private IActionProcessor getActionProcessor(ActionTask task) {
		return actionProcessors.get(task);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#doAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void doAction(ActionTask task) {
		// TODO move this test to caller...
		if (ProcessUtils.canDoAction(processContext, task)) {
			getActionProcessor(task).doAction(processContext);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#undoAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void undoAction(ActionTask task) {
		// TODO move this test to caller...
		if (ProcessUtils.isDone(processContext, task)) {
			getActionProcessor(task).undoAction(processContext);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		for (IActionProcessor processor : actionProcessors.values()) {
			ActionTask actionTask = processor.getActionTask();
			if (ProcessUtils.evaluatePrecondition(processContext, actionTask)
					&& processor.acceptChange(processContext, change)) {
				validateAndUpdateContext(processor, actionTask);
			}
		}
	}

	/**
	 * @return the task without predecessor that can start the process TODO find a better way to identify the
	 *         root action task that can start the wizard TODO should we propose several actions (ie. there
	 *         are several ways to start the process)
	 */
	public List<ActionTask> getStartNewProcessActionTasks() {
		ArrayList<ActionTask> result = new ArrayList<ActionTask>();
		for (IActionProcessor actionProcessor : actionProcessors.values()) {
			ActionTask task = actionProcessor.getActionTask();
			if (!hasPreceding(task)) {
				result.add(task);
			}
		}
		return result;
	}

	public boolean hasPreceding(Task task) {
		boolean result = true;
		if (task.getPrecedingTasks().isEmpty()) {
			if (task.getParentTask() == null) {
				result = false;
			} else {
				result = hasPreceding(task.getParentTask());
			}
		}
		return result;
	}

	private void processNotification(Notification notification) {
		if (notification.getNotifier() instanceof Task) {
			Task task = (Task)notification.getNotifier();
			if (notification.getEventType() == Notification.SET && notification.getNewValue() != null) {
				Object newValue = notification.getNewValue();
				if (!newValue.equals(notification.getOldValue())) {
					fireTaskChanged(task);
				}
			}
		}
		if (notification.getNotifier() instanceof ProcessVariableToObjectMapImpl) {
			ProcessVariableToObjectMapImpl entry = (ProcessVariableToObjectMapImpl)notification.getNotifier();
			if (notification.getEventType() == Notification.SET
					&& notification.getFeatureID(ProcessVariableToObjectMapImpl.class) == ProcessPackage.PROCESS_VARIABLE_TO_OBJECT_MAP__VALUE
					&& notification.getNewValue() != null) {
				Object newValue = notification.getNewValue();
				if (!newValue.equals(notification.getOldValue())) {
					fireVariableChanged(entry.getKey());
				}
			}
		}
	}

	private List<ITaskChangedActionProcessor> getTaskChangedActionProcessors() {
		ArrayList<ITaskChangedActionProcessor> l = new ArrayList<ITaskChangedActionProcessor>();
		for (IActionProcessor p : actionProcessors.values()) {
			if (p instanceof ITaskChangedActionProcessor) {
				l.add((ITaskChangedActionProcessor)p);
			}
		}
		return l;
	}

	private List<IVariableChangedActionProcessor> getVariableChangedActionProcessors() {
		ArrayList<IVariableChangedActionProcessor> l = new ArrayList<IVariableChangedActionProcessor>();
		for (IActionProcessor p : actionProcessors.values()) {
			if (p instanceof IVariableChangedActionProcessor) {
				l.add((IVariableChangedActionProcessor)p);
			}
		}
		return l;
	}

	/**
	 * Fires the given change to {@link fr.obeo.dsl.workspace.listener.IListener#getProcessors() processors}.
	 * 
	 * @param change
	 *            the {@link IChange} to fire
	 */
	protected void fireTaskChanged(Task changedTask) {
		List<ITaskChangedActionProcessor> processors = getTaskChangedActionProcessors();
		if (processors.size() != 0) {
			// TODO should be asynchronous and ran in a single other thread
			for (ITaskChangedActionProcessor processor : processors) {
				ActionTask actionTask = processor.getActionTask();
				if (ProcessUtils.evaluatePrecondition(processContext, actionTask)
						&& ProcessUtils.isTaskFollowing(processor.getActionTask(), changedTask)
						&& processor.acceptTaskChanged(processContext, changedTask)) {
					validateAndUpdateContext(processor, actionTask);
				}
			}
		}
	}

	protected void fireVariableChanged(ProcessVariable variableChanged) {
		List<IVariableChangedActionProcessor> processors = getVariableChangedActionProcessors();
		if (processors.size() != 0) {
			// TODO should be asynchronous and ran in a single other thread
			for (IVariableChangedActionProcessor processor : processors) {
				ActionTask actionTask = processor.getActionTask();
				if (ProcessUtils.evaluatePrecondition(processContext, actionTask)
						&& processor.acceptVariableChanged(processContext, variableChanged)) {
					validateAndUpdateContext(processor, actionTask);
				}
			}
		}
	}

	private void validateAndUpdateContext(IActionProcessor processor, ActionTask actionTask) {
		boolean b = processor.validate(processContext);
		if (b) {
			Object result = processor.updateContextWhenDone(processContext);
			if (result == null) {
				result = "DummyObject";
			}
			processContext.setDone(actionTask, result);
		} else {
			if (processContext.isDone(actionTask) || processContext.getUndoneReason(actionTask) == null) {
				String result = processor.updateContextWhenUndone(processContext);
				processContext.setUndone(actionTask, result);
			}
		}
	}
}
