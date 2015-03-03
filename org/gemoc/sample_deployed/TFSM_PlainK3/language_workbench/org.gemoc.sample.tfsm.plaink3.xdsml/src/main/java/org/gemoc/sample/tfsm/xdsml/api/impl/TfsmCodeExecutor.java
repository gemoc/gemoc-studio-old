
package org.gemoc.sample.tfsm.xdsml.api.impl;

import java.lang.reflect.Method;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;

public class TfsmCodeExecutor implements ICodeExecutor  {

	@Override
	public Object execute(MSEOccurrence call) throws CodeExecutionException {
		return null;
	}

	@Override
	public Object execute(Object className, String methodName, List<Object> parameters) throws CodeExecutionException {
		Class c;
		try {
			c = Class.forName((String)className);
			Method method = c.getMethod(methodName, parameters.get(0).getClass().getInterfaces()[0]);
			Object o = c.newInstance();
			method.invoke(o, parameters.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}