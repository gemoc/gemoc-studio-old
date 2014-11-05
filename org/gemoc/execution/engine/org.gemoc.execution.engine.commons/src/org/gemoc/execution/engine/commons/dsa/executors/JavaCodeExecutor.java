package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

public class JavaCodeExecutor implements ICodeExecutor {

	public JavaCodeExecutor() {

	}

	@Override
	public Object execute(ActionCall call) throws CodeExecutionException
	{
		return execute(call.getTriggeringEvent().getCaller(), 
				call.getTriggeringEvent().getAction().getName(), 
				call.getParameters(), 
				call);
	}

	@Override
	public Object execute(Object caller, String methodName,
			List<Object> parameters) throws CodeExecutionException {
		return execute(caller,
						methodName, 
						parameters, 
						null);
	}
	
	private Object execute(Object caller, String methodName, Collection<Object> parameters, ActionCall call) throws CodeExecutionException {
		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		if (call.getParameters() != null) 
		{
			for (Object param : call.getParameters()) 
			{
				parameterTypesList.add(param.getClass());
			}
		}
		Method method;
		Object result = null;
		try {
			method = caller.getClass().getMethod(methodName, parameterTypes);
			result =  method.invoke(caller, call.getParameters());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new CodeExecutionException("Could not perform action call, see inner exception.", e, call);
		}
		return result;
	}

}