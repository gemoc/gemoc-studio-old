package org.gemoc.gemoc_language_workbench.api.dsa;

import java.lang.reflect.InvocationTargetException;

/**
 * The concrete command that is executed
 * @author dvojtise
 *
 */
public interface IDSAExecutorCommand {

	public Object execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

}
