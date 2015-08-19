package org.gemoc.executionengine.ccsljava.engine.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.CodeExecutionException;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.ICodeExecutor;

public class JavaCodeExecutor implements ICodeExecutor {

	public JavaCodeExecutor() {

	}

	@Override
	public Object execute(MSEOccurrence mseOccurrence) throws CodeExecutionException {
		return execute(mseOccurrence.getMse().getCaller(), mseOccurrence.getMse().getAction().getName(),
				mseOccurrence.getParameters(), mseOccurrence);
	}

	@Override
	public Object execute(Object caller, String methodName, List<Object> parameters) throws CodeExecutionException {

		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		if (parameters != null) {
			for (Object param : parameters) {
				parameterTypesList.add(param.getClass());
			}
		}
		Method method;
		Object result = null;
		try {
			method = caller.getClass().getMethod(methodName, parameterTypes);
			result = method.invoke(caller, parameters);
		} catch (NoSuchMethodException e) {
			throw new CodeExecutionException("No applicable method " + methodName
					+ "for this code executor. Could not perform action call, see inner exception.", e, null, false);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new CodeExecutionException("Could not perform action call, see inner exception.", e, null, true);
		}
		return result;

	}

	private Object execute(Object caller, String methodName, Collection<Object> parameters, MSEOccurrence mseoccurrence)
			throws CodeExecutionException {
		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		if (mseoccurrence.getParameters() != null) {
			for (Object param : mseoccurrence.getParameters()) {
				parameterTypesList.add(param.getClass());
			}
		}
		Method method;
		Object result = null;
		try {
			method = caller.getClass().getMethod(methodName, parameterTypes);
			result = method.invoke(caller, mseoccurrence.getParameters());
		} catch (NoSuchMethodException e) {
			throw new CodeExecutionException("No applicable method " + methodName
					+ "for this code executor. Could not perform action call, see inner exception.", e, mseoccurrence,
					false);
		} catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new CodeExecutionException("Could not perform action call, see inner exception.", e, mseoccurrence,
					true);
		}
		return result;
	}

	@Override
	public String getExcutorID() {
		return this.getClass().getSimpleName();
	}

}