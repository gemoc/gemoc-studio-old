package org.gemoc.gemoc_language_workbench.api.dsa.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutorCommand;

/**
 * composes several executors in order to find out which can execute the method
 * @author dvojtise
 *
 */
public class ChainedDSAExecutor implements IDSAExecutor{

	protected ArrayList<IDSAExecutor> availableExecutors = new ArrayList<IDSAExecutor>();
	
	@Override
	public Object execute(Object target, String methodName,
			ArrayList<Object> parameters) {
		IDSAExecutorCommand command = this.getCommand(target, methodName, parameters);
		if(command != null){
			try {
				return command.execute();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO should return the fact that it cannot be executed via an exception (NoSuchMethodException ? or custom ?)
		return null;
	}

	@Override
	public IDSAExecutorCommand getCommand(Object target, String methodName,
			ArrayList<Object> parameters) {
		for (IDSAExecutor executor : availableExecutors) {
			IDSAExecutorCommand command = executor.getCommand(target, methodName, parameters);
			if(command != null) return command;
		}
		return null;
	}

	
	public void addExecutor(IDSAExecutor newexecutor){
		availableExecutors.add(newexecutor);
	}
}
