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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.gemoc.gemoc_language_workbench.process.utils.EMFResource;


/**
 * The Gemoc language {@link IProcessRunner}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class GemocLanguageProcessRunner 
		implements IProcessRunner, 
					IChangeProcessor {

	/**
	 * {@link List} of {@link IActionProcessor}.
	 */
	final private Map<Task, ActionProcessor> _actionProcessors;

	/**
	 * The  {@link ProcessContext}.
	 */
	final private GemocLanguageProcessContext _processContext = new GemocLanguageProcessContext();

	/**
	 * The {@link Process}.
	 */
	final private Process _process;

	/**
	 * Constructor.
	 */
	public GemocLanguageProcessRunner(URI xdsmlUri) 
	{		
		URI processURI = URI.createPlatformPluginURI(Activator.getDefault().getBundle().getSymbolicName() + "/process/gemoc_language.process", true);
		_process = (Process)EMFResource.getFirstContent(processURI);
		
//		Resource resource = new XMIResourceImpl();
//		try 
//		{
//			InputStream is = GemocLanguageProcessRunner.class.getResourceAsStream("/process/gemoc_language.process");
//			resource.load(is, new HashMap<String, String>());
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		_process = (Process)resource.getContents().get(0);
		_processContext.setDefinition(_process);
		_processContext.initialize(xdsmlUri);
		_actionProcessors = new GemocLanguageProcessJavaTaskFactory().createJavaTaskForProcess(_process);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#getContext()
	 */
	public ProcessContext getContext() 
	{
		return _processContext;
	}
	public GemocLanguageProcessContext getCastedContext() 
	{
		return _processContext;
	}

	private IActionProcessor<GemocLanguageProcessContext> getActionProcessor(ActionTask task) {
		return _actionProcessors.get(task);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.process.IProcessRunner#doAction(fr.obeo.dsl.process.ProcessContext,
	 *      fr.obeo.dsl.process.ActionTask)
	 */
	public void doAction(ActionTask task) 
	{
		// TODO move this test to caller...
		if (ProcessUtils.canDoAction(_processContext, task)) 
		{
			getActionProcessor(task).doAction(_processContext);
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
		if (ProcessUtils.isDone(_processContext, task)) 
		{
			getActionProcessor(task).undoAction(_processContext);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.workspace.listener.change.processor.IChangeProcessor#process(fr.obeo.dsl.workspace.listener.change.IChange)
	 */
	public void process(IChange<?> change) {
		for (ActionProcessor actionProcessor : _actionProcessors.values()) 
		{
			ActionTask actionTask = actionProcessor.getActionTask();
			if (ProcessUtils.evaluatePrecondition(_processContext, actionTask) 
				&& actionProcessor.acceptChange(_processContext, change))
			{
				boolean b = actionProcessor.validate(_processContext);
				if (b)
				{
					Object result = actionProcessor.updateContextWhenDone(_processContext);
					if (result == null) 
						result = "DummyObject";
					_processContext.setDone(actionTask, result);
				}
				else
				{
					if (_processContext.isDone(actionTask))
					{
						String result = actionProcessor.updateContextWhenUndone(_processContext);
						_processContext.setUndone(actionTask, result);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @return the task without predecessor that can start the process
	 * TODO find a better way to identify the root action task that can start the wizard
	 * TODO should we propose several actions (ie. there are several ways to start the process)
	 */
	public List<ActionTask> getStartNewProcessActionTasks()
	{
		ArrayList<ActionTask> result = new ArrayList<ActionTask>();
		for (ActionProcessor actionProcessor : _actionProcessors.values()) 
		{
			ActionTask task = actionProcessor.getActionTask();
			if (!hasPreceding(task))
			{
				result.add(task);				
			}
		}
		return result;
	}
	
	public boolean hasPreceding(Task task)
	{
		if (task.getPrecedingTasks().isEmpty())
		{
			if (task.getParentTask() == null)
			{
				return false;
			}
			else
			{
				return hasPreceding(task.getParentTask());
			}
		}
		return true;
	}

	public Process getProcess() 
	{
		return _process;
	}

}
