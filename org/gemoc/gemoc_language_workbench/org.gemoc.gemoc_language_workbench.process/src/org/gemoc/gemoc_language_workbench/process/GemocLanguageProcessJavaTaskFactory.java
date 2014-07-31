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
import fr.obeo.dsl.process.Process;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;

import java.util.LinkedHashMap;
import java.util.Map;

import org.gemoc.gemoc_language_workbench.process.task.CreateNewGemocLanguageProjectTask;
import org.gemoc.gemoc_language_workbench.process.task.CreateNewEMFProjectTask;
import org.gemoc.gemoc_language_workbench.process.task.SelectEMFProjectTask;
//import org.gemoc.gemoc_language_workbench.process.task.Task2c;
//import org.gemoc.gemoc_language_workbench.process.task.Task3a;
//import org.gemoc.gemoc_language_workbench.process.task.Task4;
//import org.gemoc.gemoc_language_workbench.process.task.Task5a;
//import org.gemoc.gemoc_language_workbench.process.task.Task5b1;
//import org.gemoc.gemoc_language_workbench.process.task.Task5b2;
//import org.gemoc.gemoc_language_workbench.process.task.Task5b3;
//import org.gemoc.gemoc_language_workbench.process.task.Task5b4;
//import org.gemoc.gemoc_language_workbench.process.task.Task5c1;
//import org.gemoc.gemoc_language_workbench.process.task.Task5d;
//import org.gemoc.gemoc_language_workbench.process.task.Task6a;
//import org.gemoc.gemoc_language_workbench.process.task.Task6b;
//import org.gemoc.gemoc_language_workbench.process.task.Task6c;
//import org.gemoc.gemoc_language_workbench.process.task.Task7a;
//import org.gemoc.gemoc_language_workbench.process.task.Task7b;
//import org.gemoc.gemoc_language_workbench.process.task.Task8a1;
//import org.gemoc.gemoc_language_workbench.process.task.Task8b;
//import org.gemoc.gemoc_language_workbench.process.task.Task8c;
//import org.gemoc.gemoc_language_workbench.process.task.Task9a;
//import org.gemoc.gemoc_language_workbench.process.task.Task9b;

public class GemocLanguageProcessJavaTaskFactory {

	Map<Task, ActionProcessor> actionProcessors = new LinkedHashMap<Task, ActionProcessor>();
	
	public Map<Task, ActionProcessor> createJavaTaskForProcess(Process process){
		Map<String, Task> taskByIDMap = ProcessUtils.getTaskByIDMap(process);

		addActionProcessor(new CreateNewGemocLanguageProjectTask((ActionTask)taskByIDMap.get("Task1")));
		addActionProcessor(new CreateNewEMFProjectTask((ActionTask)taskByIDMap.get("Task2.a")));
		addActionProcessor(new SelectEMFProjectTask((ActionTask)taskByIDMap.get("Task2.b")));
		/*addActionProcessor(new Task2c((ActionTask)taskByIDMap.get("Task2.c"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task3a((ActionTask)taskByIDMap.get("Task3.a"), (ActionTask)taskByIDMap
				.get("Task1"), (ActionTask)taskByIDMap.get("Task2.b")));
		addActionProcessor(new Task4((ActionTask)taskByIDMap.get("Task4"), (ActionTask)taskByIDMap
				.get("Task2.b")));
		addActionProcessor(new Task5a((ActionTask)taskByIDMap.get("Task5.a"), (ActionTask)taskByIDMap
				.get("Task2.b")));
		addActionProcessor(new Task5b1((ActionTask)taskByIDMap.get("Task5.b.1")));
		addActionProcessor(new Task5b2((ActionTask)taskByIDMap.get("Task5.b.2")));
		addActionProcessor(new Task5b3((ActionTask)taskByIDMap.get("Task5.b.3")));
		addActionProcessor(new Task5b4((ActionTask)taskByIDMap.get("Task5.b.4")));
		addActionProcessor(new Task5c1((ActionTask)taskByIDMap.get("Task5.c.1")));
		addActionProcessor(new Task5d((ActionTask)taskByIDMap.get("Task5.d"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task6a((ActionTask)taskByIDMap.get("Task6.a")));
		addActionProcessor(new Task6b((ActionTask)taskByIDMap.get("Task6.b")));
		addActionProcessor(new Task6c((ActionTask)taskByIDMap.get("Task6.c"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task7a((ActionTask)taskByIDMap.get("Task7.a"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task7b((ActionTask)taskByIDMap.get("Task7.b"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task8a1((ActionTask)taskByIDMap.get("Task8.a.1"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task8b((ActionTask)taskByIDMap.get("Task8.b"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task8c((ActionTask)taskByIDMap.get("Task8.c"), (ActionTask)taskByIDMap
				.get("Task1")));
		addActionProcessor(new Task9a((ActionTask)taskByIDMap.get("Task9.a")));
		addActionProcessor(new Task9b((ActionTask)taskByIDMap.get("Task9.b"), (ActionTask)taskByIDMap
				.get("Task1")));*/
		
		return actionProcessors;
		
	}
	
	/**
	 * Adds the given {@link IActionProcessor}.
	 * 
	 * @param processor
	 *            the {@link IActionProcessor}
	 */
	private void addActionProcessor(ActionProcessor processor) {
		actionProcessors.put(processor.getActionTask(), processor);
	}
}
