package org.gemoc.execution.engine.api_implementations.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

public class Kermeta2ModelLoader implements ModelLoader{

	@Override
	public Resource loadModel(String modelFileUri) {
		EObject modelLoader = this.createAndInitializeModelLoader(customizedClassLoader);
        Activator.getMessagingSystem().debug("Model Loader returned : " + modelLoader.toString(), Activator.PLUGIN_ID);
        Activator.getMessagingSystem().debug("Loading the model", Activator.PLUGIN_ID);
        EObject modelRoot = this.loadModel(modelLoader, this.modelURI, this.metamodelURI);
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
	
	private EObject loadModel(EObject modelLoader, URI modelURI, URI metamodelURI) {
        EObject modelRoot = null;
        try {
            Method loadModelMethod;
            loadModelMethod = modelLoader.getClass().getDeclaredMethod("loadModel", String.class, String.class);

            Activator.getMessagingSystem().debug("loadModel method retrieved : " + loadModelMethod.toString(),
                    Activator.PLUGIN_ID);
            File f = new File(modelURI.toPlatformString(true));
            Activator.getMessagingSystem().debug(f.toString() + " - " + f.lastModified() + " - " + f.exists(), Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(modelURI.toString() + " ## " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(f.lastModified()), Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(metamodelURI.toString(), Activator.PLUGIN_ID);
            
            Activator.getMessagingSystem().debug(new File(URI.createPlatformResourceURI(("platform:/resource/org.gemoc.execution.engine.example"),true).toPlatformString(true)).exists() + "", Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects()).toString(), Activator.PLUGIN_ID);
            

            modelRoot = (EObject) loadModelMethod.invoke((Object) modelLoader, modelURI.toString(),
                    metamodelURI.toString());
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException while trying to load the model";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException while trying to load the model";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException while trying to load the model";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException while trying to load the model";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException while trying to load the model";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
            Activator.error(e.getCause().getMessage(), e.getCause());
        }
        return modelRoot;
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
            Class<?> fact;
            fact = classLoader.loadClass(prop.get("mainFactory").toString());
            modelLoader = (EObject) fact.getDeclaredMethod("create" + prop.get("mainClass")).invoke(fact);
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
