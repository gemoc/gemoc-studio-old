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
	 *            object targeted by the method call.
	 * @param methodName
	 *            name of the method called.
	 * @param parameters
	 *            parameters of the method called.
	 * @exception NoSuchMethodException
	 *                if a method of the given name cannot be found.
	 * @exception IllegalArgumentException
	 *                if the arguments given for this method call are not
	 *                correct.
	 * @return an object MethodCall representing a method call.
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
	 *            object on which to call the method.
	 * @param methodName
	 *            name of the method to call.
	 * @param parameters
	 *            arguments of the method to call.
	 * @throws MethodNotFoundException
	 *             if a method of the given name cannot be found.
	 * @return the result of the method call.
	 */
	public Object invoke(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			IllegalAccessException;

}
