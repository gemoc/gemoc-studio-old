package org.gemoc.execution.engine.api_implementations.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;

public class Kermeta2LanguageInitializer implements LanguageInitializer {

	String jarDependenciesFolderPath;
	String jarDsaFolderPath;

	public Kermeta2LanguageInitializer(String jarDependenciesFolderPath, String jarDsaFolderPath) {
		this.jarDependenciesFolderPath = jarDependenciesFolderPath;
		this.jarDsaFolderPath = jarDsaFolderPath;
	}

	@Override
	public void initialize() {
		Activator.getMessagingSystem().info("Initializing Kermeta2 Language with...", Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tFolder containing jar dependencies: " + jarDependenciesFolderPath,
				Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tFolder containing jar DSA: " + jarDsaFolderPath, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug(
				"Adding all the JAR files from folder " + jarDependenciesFolderPath + " and " + jarDsaFolderPath
						+ " to the current ClassLoader", Activator.PLUGIN_ID);
		ClassLoader customizedClassLoader = this.customizeClassLoader(jarDsaFolderPath, jarDependenciesFolderPath);
		this.initializeKermeta2(customizedClassLoader);
	}

	private void initializeKermeta2(ClassLoader classLoader) {
		if (classLoader == null) {
			throw new NullPointerException("The given ClassLoader is null");
		}

		// Parsing the "main.properties" file.
		Properties prop = new Properties();
		InputStream in = classLoader.getResourceAsStream("main.properties");
		try {
			prop.load(in);
			Class<?> init;
			init = classLoader.loadClass(prop.get("mainRunner").toString());
			Activator.getMessagingSystem().debug(
					"Calling method init4eclipse : " + init.getDeclaredMethod("init4eclipse").toString(),
					Activator.PLUGIN_ID);
			init.getDeclaredMethod("init4eclipse").invoke(null, (Object[]) null);
			in.close();
		} catch (IOException e) {
			String errorMessage = "IOException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (ClassNotFoundException e) {
			String errorMessage = "ClassNotFoundException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			Activator.error(e.getCause().getMessage(), e.getCause());
		} catch (NoSuchMethodException e) {
			String errorMessage = "NoSuchMethodException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (SecurityException e) {
			String errorMessage = "SecurityException while initializing the Kermeta2 language";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}

	}

	private ClassLoader customizeClassLoader(String jarDsaFolderPath, String jarDependenciesFolderPath) {
		List<URL> urls = new ArrayList<URL>();
		try {
			urls.addAll(this.getJarUrlsFromFolder(jarDependenciesFolderPath));
			urls.addAll(this.getJarUrlsFromFolder(jarDsaFolderPath));
		} catch (CoreException e) {
			String errorMessage = "CoreException while customizing the ClassLoader";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (MalformedURLException e) {
			String errorMessage = "MalformedURLException while customizing the ClassLoader";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		}
		URL[] turls = (URL[]) urls.toArray(new URL[urls.size()]);
		ClassLoader res = new URLClassLoader(turls, Activator.class.getClassLoader());
		return res;
	}

	private List<URL> getJarUrlsFromFolder(String folderPath) throws MalformedURLException, CoreException {
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
