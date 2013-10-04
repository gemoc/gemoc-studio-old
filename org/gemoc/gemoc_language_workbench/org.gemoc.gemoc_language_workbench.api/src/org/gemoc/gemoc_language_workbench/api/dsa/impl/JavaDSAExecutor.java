package org.gemoc.gemoc_language_workbench.api.dsa.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutorCommand;

public class JavaDSAExecutor implements IDSAExecutor {

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
		
		Class[] parameterTypes = null;
		ArrayList<Class> parameterTypesList = new ArrayList<Class>();
		for(Object param : parameters){
			parameterTypesList.add(param.getClass());
		}
		try {
			Method method = target.getClass().getMethod(methodName, parameterTypes);
			
			return new JavaDSAExecutorCommand(target, method, parameters);
		} catch (NoSuchMethodException e) {
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public class JavaDSAExecutorCommand implements IDSAExecutorCommand{

		protected Method method;
		protected Object target;
		protected ArrayList<Object> parameters;
		
		public JavaDSAExecutorCommand(Object target, Method method,
				ArrayList<Object> parameters) {
			this.target = target;
			this.method = method;
			this.parameters = parameters;
		}

		@Override
		public Object execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			return method.invoke(target, parameters);
		}
		
	}

}
