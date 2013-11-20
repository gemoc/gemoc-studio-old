package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * A CodeExecutor is an entity responsible for being able to invoke a method on
 * an object and parameters, based on the method's name. It must have knowledge
 * about how the code is compiled into Java Bytecode, and if any particular
 * strategy must be used to locate the correct method.
 * 
 */
public interface CodeExecutor {

	/**
	 * Returns the MethodCall object corresponding to the invocation of the
	 * method of name methodName on the object target with the given parameters.
	 * 
	 * @param target
	 * @param methodName
	 * @param parameters
	 * @return
	 */
	public MethodCall getMethodCall(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException;

	/**
	 * Invokes the method of name methodName on the object target with the given
	 * parameters. Returns the Object returned by the method called. Throws
	 * MethodNotFoundException if this CodeExecutor is not able to locate the
	 * method.
	 * 
	 * @param target
	 * @param methodName
	 * @param parameters
	 * @throws MethodNotFoundException
	 * @return
	 */
	public Object invoke(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			IllegalAccessException;

}
