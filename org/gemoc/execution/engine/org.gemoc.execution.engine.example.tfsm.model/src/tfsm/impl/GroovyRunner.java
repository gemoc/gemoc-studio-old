package tfsm.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

import org.eclipse.ui.plugin.AbstractUIPlugin;

public class GroovyRunner {

	public static String absolutePathToGroovyControl;

	static Object executeScript(String expression) {
		try {
			GroovyObject groovyObj;
			GroovyClassLoader gcl = new GroovyClassLoader();
			Class<?> clazz = null;

			clazz = gcl.parseClass(new File(absolutePathToGroovyControl));

			groovyObj = (GroovyObject) clazz.newInstance();
			Object r = groovyObj.invokeMethod(expression, new Object[] {});
			return r;
		} catch (IOException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute a Groovy expression";
			// Activator.getMessagingSystem().error(errorMessage,
			// Activator.PLUGIN_ID);
			// Activator.error(errorMessage, e);
		} catch (InstantiationException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute a Groovy expression";
			// Activator.getMessagingSystem().error(errorMessage,
			// Activator.PLUGIN_ID);
			// Activator.error(errorMessage, e);
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute a Groovy expression";
			// Activator.getMessagingSystem().error(errorMessage,
			// Activator.PLUGIN_ID);
			// Activator.error(errorMessage, e);
		}
		return null;
	}

}
