package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodCall;

/**
 * An aggregation of several CodeExecutors.
 * The actual invoke command will be dispatched to the first CodeExecutor that is able to handle it 
 * @author dvojtise
 * @author flatombe
 * 
 */
public class CodeExecutorDispatcher implements CodeExecutor {

	protected List<CodeExecutor> availableExecutors = null;

	public CodeExecutorDispatcher() {
		this.availableExecutors = new ArrayList<CodeExecutor>();
	}

	public CodeExecutorDispatcher(CodeExecutor codeExecutor) {
		this();
		this.addExecutor(codeExecutor);
	}

	public CodeExecutorDispatcher(List<CodeExecutor> codeExecutors) {
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