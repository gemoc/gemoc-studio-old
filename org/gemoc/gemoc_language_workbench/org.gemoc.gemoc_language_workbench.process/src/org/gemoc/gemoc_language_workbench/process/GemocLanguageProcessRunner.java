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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;


/**
 * The Gemoc language {@link IProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class GemocLanguageProcessRunner implements IProcessRunner, IChangeProcessor {

	/**
	 * {@link List} of {@link IActionProcessor}.
	 */
	final Map<Task, IActionProcessor> actionProcessors;

	/**
	 * The  {@link ProcessContext}.
	 */
	final GemocLanguageProcessContext context = new GemocLanguageProcessContext();

	/**
	 * The {@link Process}.
	 */
	final Process process;
	
	final URI xdsmlUri;

	/**
	 * Constructor.
	 */
	public GemocLanguageProcessRunner(URI xdsmlUri, IFile xdsmlFile) {
		this.xdsmlUri = xdsmlUri;
		Resource resource = new XMIResourceImpl();
		try {
			resource.load(GemocLanguageProcessRunner.class
					.getResourceAsStream("/process/gemoc_language.process"), new HashMap<String, String>());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		process = (Process)resource.getContents().get(0);
		context.initialize(process, xdsmlUri, xdsmlFile);

		actionProcessors = new GemocLanguageProcessJavaTaskFactory().createJavaTaskForProcess(process);
	}

	

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getProcess()
	 */
	public Process getProcess() {
		return process;
	}

	/**
	 * 
	 */
	public GemocLanguageProcessContext getGemocLanguageProcessContext() {
		return context;
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getContext()
	 */
	public ProcessContext getContext() {
		return context;
	}

	

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#doAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void doAction(ProcessContext context, ActionTask task) {
		// TODO move this test to caller...
		if (ProcessUtils.canDoAction(context, task)) {
			actionProcessors.get(task).doAction(context);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#undoAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void undoAction(ProcessContext context, ActionTask task) {
		// TODO move this test to caller...
		if (ProcessUtils.isDone(context, task)) {
			actionProcessors.get(task).undoAction(context);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		for (IActionProcessor actionProcessor : actionProcessors.values()) {
			if(ProcessUtils.evaluatePrecondition(getContext(), actionProcessor.getActionTask())){
				boolean b = actionProcessor.checkIsDone(getContext(), change);
				if (b){
					Object result = actionProcessor.updateContextWhenDone(getContext(), change);
					if(result == null) result = "DummyObject";
					context.setDone(actionProcessor.getActionTask(), result);
				}
				else{
					if(context.isDone(actionProcessor.getActionTask())){
						context.setUndone(actionProcessor.getActionTask(),actionProcessor.updateContextWhenUndone(getContext(), change));
					}
					//else{ was already undone}
				}
			}
		}
	}

}
