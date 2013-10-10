package tfsm.impl;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

public class GroovyRunner {

	private static String absolutePathToGroovyControl = "/home/flatombe/thesis/gemoc/git/gemoc-dev/org/gemoc/sample/TFSM/DSA/org.gemoc.sample.i3s.fsm.dsa.groovy/groovy/control.groovy";

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
		} catch (NoClassDefFoundError e) {
			customizeClassLoader("/org.gemoc.execution.engine.example/my_jars/dependencies/groovy");

			try {
				GroovyObject groovyObj;
				GroovyClassLoader gcl = new GroovyClassLoader();
				Class<?> clazz = null;

				clazz = gcl.parseClass(new File(absolutePathToGroovyControl));

				groovyObj = (GroovyObject) clazz.newInstance();
				Object r = groovyObj.invokeMethod(expression, new Object[] {});
				return r;
			} catch (IOException e1) {
				String errorMessage = e1.getClass().getSimpleName() + " when trying to execute a Groovy expression";
				// Activator.getMessagingSystem().error(errorMessage,
				// Activator.PLUGIN_ID);
				// Activator.error(errorMessage, e);
			} catch (InstantiationException e1) {
				String errorMessage = e1.getClass().getSimpleName() + " when trying to execute a Groovy expression";
				// Activator.getMessagingSystem().error(errorMessage,
				// Activator.PLUGIN_ID);
				// Activator.error(errorMessage, e);
			} catch (IllegalAccessException e1) {
				String errorMessage = e1.getClass().getSimpleName() + " when trying to execute a Groovy expression";
				// Activator.getMessagingSystem().error(errorMessage,
				// Activator.PLUGIN_ID);
				// Activator.error(errorMessage, e);
			}
		}
		return null;
	}

	private static ClassLoader customizeClassLoader(String jarFolderPath) {
		List<URL> urls = new ArrayList<URL>();
		try {
			urls.addAll(getJarUrlsFromFolder(jarFolderPath));
		} catch (CoreException e) {
			String errorMessage = "CoreException while customizing the ClassLoader";
			// Activator.getMessagingSystem().error(errorMessage,
			// Activator.PLUGIN_ID);
			// Activator.error(errorMessage, e);
		} catch (MalformedURLException e) {
			String errorMessage = "MalformedURLException while customizing the ClassLoader";
			// Activator.getMessagingSystem().error(errorMessage,
			// Activator.PLUGIN_ID);
			// Activator.error(errorMessage, e);
		}

		// Activator.getMessagingSystem().debug("URLs added to the ClassLoader : "
		// + urls.toString(), Activator.PLUGIN_ID);

		URL[] turls = (URL[]) urls.toArray(new URL[urls.size()]);
		ClassLoader res = new URLClassLoader(turls, ClassLoader.getSystemClassLoader());
		return res;
	}

	private static List<URL> getJarUrlsFromFolder(String folderPath) throws MalformedURLException, CoreException {
		List<URL> urls = new ArrayList<URL>();
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(folderPath));
		for (IResource resource : folder.members()) {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.getFileExtension().equals("jar")) {
					urls.add(file.getLocationURI().toURL());
				}
			}
		}
		return urls;
	}

}
