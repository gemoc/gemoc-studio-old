package org.gemoc.execution.engine.commons.dsa.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

/**
 * An aggregation of several CodeExecutors.
 * The actual invoke command will be dispatched to the first CodeExecutor that is able to handle it 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class CodeExecutorDispatcher implements ICodeExecutor 
{

	protected List<ICodeExecutor> _executors = null;

	public CodeExecutorDispatcher() 
	{
		_executors = new ArrayList<ICodeExecutor>();
	}

	public CodeExecutorDispatcher(ICodeExecutor codeExecutor) 
	{
		this();
		addExecutor(codeExecutor);
	}

	public CodeExecutorDispatcher(List<ICodeExecutor> codeExecutors) 
	{
		this();
		for (ICodeExecutor codeExecutor : codeExecutors) 
		{
			addExecutor(codeExecutor);
		}
	}

	public void addExecutor(ICodeExecutor executor) 
	{
		_executors.add(executor);
	}

	@Override
	public Object execute(ActionCall call) throws CodeExecutionException 
	{		
		for (ICodeExecutor executor : _executors) 
		{
			try {
				return executor.execute(call);
			} catch (CodeExecutionException e) 
			{
				e.printStackTrace();
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call", call);
	}

	@Override
	public Object execute(Object caller, String methodName,
			Collection<Object> parameters) throws CodeExecutionException {
		for (ICodeExecutor executor : _executors) 
		{
			try {
				return executor.execute(caller, methodName, parameters);
			} catch (CodeExecutionException e) 
			{
				e.printStackTrace();
			}
		}
		throw new CodeExecutionException("No code executor could perform the action call", null);
	}
}