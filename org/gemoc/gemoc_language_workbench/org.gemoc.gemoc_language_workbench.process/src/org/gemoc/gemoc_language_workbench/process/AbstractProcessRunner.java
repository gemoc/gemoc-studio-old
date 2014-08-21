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
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.workspace.listener.change.IChange;
import fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.gemoc.gemoc_language_workbench.process.specific.GemocLanguageProcessRunner;
import org.gemoc.gemoc_language_workbench.process.support.ActionProcessorFactory;

public abstract class AbstractProcessRunner implements IProcessRunner, IChangeProcessor {

	/**
	 * {@link List} of {@link IActionProcessor}.
	 */
	private final Map<Task, IActionProcessor> actionProcessors;

	/**
	 * The {@link ProcessContext}.
	 */
	private final ProcessContext processContext;

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
		actionProcessors = ActionProcessorFactory.createActionProcessors(process);
		this.processContext = processContext;
		this.processContext.setDefinition(getProcess());
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
		for (IActionProcessor actionProcessor : actionProcessors.values()) {
			ActionTask actionTask = actionProcessor.getActionTask();
			if (ProcessUtils.evaluatePrecondition(processContext, actionTask)
					&& actionProcessor.acceptChange(processContext, change)) {
				boolean b = actionProcessor.validate(processContext);
				if (b) {
					Object result = actionProcessor.updateContextWhenDone(processContext);
					if (result == null) {
						result = "DummyObject";
					}
					processContext.setDone(actionTask, result);
				} else {
					if (processContext.isDone(actionTask)
							|| processContext.getUndoneReason(actionTask) == null) {
						String result = actionProcessor.updateContextWhenUndone(processContext);
						processContext.setUndone(actionTask, result);
					}
				}
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

}
