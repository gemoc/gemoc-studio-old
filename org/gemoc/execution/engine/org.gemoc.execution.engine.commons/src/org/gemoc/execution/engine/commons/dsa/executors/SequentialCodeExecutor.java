package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodCall;

/**
 * An aggregation of several CodeExecutors.
 * 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class SequentialCodeExecutor implements CodeExecutor {

	protected List<CodeExecutor> availableExecutors = null;

	public SequentialCodeExecutor() {
		this.availableExecutors = new ArrayList<CodeExecutor>();
	}

	public SequentialCodeExecutor(CodeExecutor codeExecutor) {
		this();
		this.addExecutor(codeExecutor);
	}

	public SequentialCodeExecutor(List<CodeExecutor> codeExecutors) {
		this();
		for (CodeExecutor codeExecutor : codeExecutors) {
			this.addExecutor(codeExecutor);
		}
	}

	@Override
	public Object invoke(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			IllegalAccessException {

		MethodCall command = this.getMethodCall(target, methodName, parameters);
		return command.invoke();
	}

	@Override
	public MethodCall getMethodCall(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException {
		for (CodeExecutor executor : this.availableExecutors) {
			MethodCall command = executor.getMethodCall(target, methodName,
					parameters);
			if (command != null)
				return command;
		}
		return null;
	}

	public void addExecutor(CodeExecutor newexecutor) {
		this.availableExecutors.add(newexecutor);
	}
}