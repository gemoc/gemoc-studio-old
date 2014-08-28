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
package org.gemoc.gemoc_language_workbench.process.support;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.gemoc.gemoc_language_workbench.process.Activator;
import org.gemoc.gemoc_language_workbench.process.IActionProcessor;

public final class ActionProcessorFactory {

	private Map<Task, IActionProcessor> actionProcessors = new LinkedHashMap<Task, IActionProcessor>();

	private ActionProcessorFactory() {
	}

	public static Map<Task, IActionProcessor> createActionProcessors(Process process) {
		return new ActionProcessorFactory().internalCreateActionProcessors(process);
	}

	private Map<Task, IActionProcessor> internalCreateActionProcessors(Process process) {
		for (Task t : ProcessUtils.getAllTasks(process)) {
			if (t instanceof ActionTask) {
				ActionTask at = (ActionTask)t;
				IActionProcessor processor = instanciateProcessor(at);
				if (processor != null) {
					addActionProcessor(processor);
				}
			}
		}
		return actionProcessors;
	}

	private IActionProcessor instanciateProcessor(ActionTask at) {
		IActionProcessor processor = null;
		if (at.getInstanceClassName() != null) {
			try {
				Class<?> c = Activator.getDefault().getClass().getClassLoader().loadClass(
						at.getInstanceClassName());
				Constructor<?> constructor = c.getConstructor(ActionTask.class);
				Object newInstance = constructor.newInstance(at);
				processor = (IActionProcessor)newInstance;
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				String message = "Property instanceClassName not correctly set for action task "
						+ at.getName() + ".";
				Activator.getDefault().error(message, e);
			} catch (NoSuchMethodException | SecurityException e) {
				String message = "Class " + at.getInstanceClassName()
						+ " does not have a constructor taking an action task parameter.";
				Activator.getDefault().error(message, e);
			} catch (IllegalArgumentException | InvocationTargetException e) {
				String message = "Class " + at.getInstanceClassName() + " could not be instanciated.";
				Activator.getDefault().error(message, e);
			}
		}
		if (processor == null) {
			// add default implementation
			processor = new NotImplementedTask<ProcessContext>(at);
		}
		return processor;
	}

	/**
	 * Adds the given {@link IActionProcessor}.
	 * 
	 * @param processor
	 *            the {@link IActionProcessor}
	 */
	private void addActionProcessor(IActionProcessor processor) {
		actionProcessors.put(processor.getActionTask(), processor);
	}
}
