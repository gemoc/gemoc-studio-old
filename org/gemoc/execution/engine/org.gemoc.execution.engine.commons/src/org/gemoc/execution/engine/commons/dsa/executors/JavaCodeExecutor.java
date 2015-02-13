package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;

public class JavaCodeExecutor implements ICodeExecutor {

	public JavaCodeExecutor() {

	}

	@Override
	public Object execute(MSEExecutionContext executionContext) throws CodeExecutionException
	{
		return execute(executionContext.getMse().getCaller(), 
				executionContext.getMse().getAction().getName(), 
				executionContext.getParameters(), 
				executionContext);
	}

	@Override
	public Object execute(Object caller, String methodName,
			List<Object> parameters) throws CodeExecutionException {
		return execute(caller,
						methodName, 
						parameters, 
						null);
	}
	
	private Object execute(Object caller, String methodName, Collection<Object> parameters, MSEExecutionContext executionContext) throws CodeExecutionException {
		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		if (executionContext.getParameters() != null) 
		{
			for (Object param : executionContext.getParameters()) 
			{
				parameterTypesList.add(param.getClass());
			}
		}
		Method method;
		Object result = null;
		try {
			method = caller.getClass().getMethod(methodName, parameterTypes);
			result =  method.invoke(caller, executionContext.getParameters());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new CodeExecutionException("Could not perform action call, see inner exception.", e, executionContext);
		}
		return result;
	}

}