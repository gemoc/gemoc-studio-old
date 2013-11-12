package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.gemoc.gemoc_language_workbench.api.Activator;

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
			} catch (IllegalArgumentException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to execute a method";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (IllegalAccessException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to execute a method";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				return null;
			} catch (InvocationTargetException e) {
				String errorMessage = e.getClass().getSimpleName()
						+ " when trying to execute a method";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(errorMessage, e);
				Activator.error("Nested Exception", e.getCause());
				return null;
			}
		}
		// TODO should return the fact that it cannot be executed via an exception (NoSuchMethodException ? or custom ?)
		Exception e = new NoSuchMethodException("None of the registered executors know how to run method "+methodName+ " on "+target);
		e.printStackTrace();
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