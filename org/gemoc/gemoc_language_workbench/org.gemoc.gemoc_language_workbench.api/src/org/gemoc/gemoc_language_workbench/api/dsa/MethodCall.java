package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * A blob containing all the informations of a method call : an object, a
 * method, a list of parameters.
 * 
 * TODO : What will we do with checked exceptions ?
 * 
 * @author dvojtise
 * @author flatombe
 * 
 */
public interface MethodCall {

	/**
	 * 
	 * 
	 * @return The object targeted for this method call.
	 */
	public Object getTarget();

	/**
	 * 
	 * 
	 * @return The method of this method call.
	 */
	public Method getMethod();

	/**
	 * 
	 * 
	 * @return The parameters of this method call.
	 */
	public List<Object> getParameters();

	/**
	 * Invokes the method on the object with the given parameters. Returns the
	 * Object returned by the invoked method.
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object invoke() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException;

}
