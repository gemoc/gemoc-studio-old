package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodCall;

public class JavaCodeExecutor implements CodeExecutor {

	public JavaCodeExecutor() {

	}

	@Override
	public Object invoke(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			IllegalAccessException {

		// Retrieving the methodCall. Can fail with NoSuchMethodException or
		// IllegalArgumentException.
		MethodCall methodCall = this.getMethodCall(target, methodName,
				parameters);

		// Invoking the methodCall. Can fail with IllegalAccessException,
		// IllegalArgumentException or InvocationTargetException.
		return methodCall.invoke();
	}

	@Override
	public MethodCall getMethodCall(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException {

		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		if (parameters != null) {
			for (Object param : parameters) {
				parameterTypesList.add(param.getClass());
			}
		}
		Method method = target.getClass().getMethod(methodName, parameterTypes);

		return new JavaMethodCall(target, method, parameters);

	}

	public class JavaMethodCall implements MethodCall {

		protected Method method;
		protected Object target;
		protected List<Object> parameters;

		public JavaMethodCall(Object target, Method method,
				List<Object> parameters) {
			this.target = target;
			this.method = method;
			this.parameters = parameters;
		}

		@Override
		public Object invoke() throws IllegalAccessException,
				IllegalArgumentException, InvocationTargetException {
			Object[] args = new Object[0];
			if (parameters != null) {
				args = parameters.toArray();
			}
			return method.invoke(target, args);
		}

		@Override
		public Object getTarget() {
			return this.target;
		}

		@Override
		public Method getMethod() {
			return this.method;
		}

		@Override
		public List<Object> getParameters() {
			return this.parameters;
		}

	}

}