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
	

	@Override
	public void initialize() {		
		Activator.getMessagingSystem().debug(
                "Adding all the JAR files from folder " + jarDependenciesFolderPath + " and " + jarDsaFolderPath
                        + " to the current ClassLoader", Activator.PLUGIN_ID);
        ClassLoader customizedClassLoader = this.customizeClassLoader(jarDsaFolderPath, jarDependenciesFolderPath);
        Activator.getMessagingSystem().debug("Initializing the model loader", Activator.PLUGIN_ID);
        EObject modelLoader = this.createAndInitializeModelLoader(customizedClassLoader);
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

        Activator.getMessagingSystem().debug("URLs added to the ClassLoader : " + urls.toString(), Activator.PLUGIN_ID);

        URL[] turls = (URL[]) urls.toArray(new URL[urls.size()]);
        ClassLoader res = new URLClassLoader(turls, Activator.class.getClassLoader());
        return res;
    }
	
	private EObject createAndInitializeModelLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new NullPointerException("The given ClassLoader is null");
        }

        // Parsing the "main.properties" file.
        Properties prop = new Properties();
        InputStream in = classLoader.getResourceAsStream("main.properties");
        EObject modelLoader = null;
        try {
            prop.load(in);
            Class<?> init;
            init = classLoader.loadClass(prop.get("mainRunner").toString());
            Activator.getMessagingSystem().debug(
                    "ClassLoader : " + Arrays.asList(((URLClassLoader) classLoader).getURLs()).toString(),
                    Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(
                    "Method init4eclipse : " + init.getDeclaredMethod("init4eclipse").toString(), Activator.PLUGIN_ID);
            init.getDeclaredMethod("init4eclipse").invoke(null, (Object[]) null);
            in.close();
        } catch (IOException e) {
            String errorMessage = "IOException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (ClassNotFoundException e) {
            String errorMessage = "ClassNotFoundException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            Activator.error(e.getCause().getMessage(), e.getCause());
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException while initializing the model loader";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        }

        return modelLoader;

    }

}
