/**
 * 
 */
package org.gemoc.execution.engine.core.impl.ccsl.ecl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.events.impl.ecl.EclEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.policy.impl.easy.SimpleFeedbackPolicy;
import org.gemoc.execution.engine.solvers.Step;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslStep;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;

/**
 * @author flatombe
 * 
 */
public class CcslEclBasicExecutionEngine extends BasicExecutionEngine {
    private URI modelURI = null;
    private URI metamodelURI = null;

    public CcslEclBasicExecutionEngine(String ccslFilePath, String jarDsaFolderPath, String jarDependenciesFolderPath,
            String modelPath, String MMpath) {

        super();

        this.feedbackPolicy = new SimpleFeedbackPolicy();
        this.executor = new EmfExecutor();

        this.modelURI = URI.createPlatformResourceURI(modelPath, true);
        this.metamodelURI = URI.createPlatformResourceURI(MMpath, true);

        Resource ccslResource = null;
        try {
            URI uri = URI.createPlatformResourceURI(ccslFilePath, false);
            ResourceSet resourceSet = new ResourceSetImpl();
            ccslResource = resourceSet.getResource(uri, true);
            ccslResource.load(null);
            EcoreUtil.resolveAll(resourceSet);
        } catch (IOException e) {
            String errorMessage = "IOException while loading CCSL file";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        }

        Activator.getMessagingSystem().debug("Instantiating CcslSolver", Activator.PLUGIN_ID);
        try {
            this.solver = new CcslSolver(ccslResource);
        } catch (IOException e) {
            String errorMessage = "IOException while instantiating the CcslSolver";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (UnfoldingException e) {
            String errorMessage = "UnfoldingException while instantiating the CcslSolver";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        } catch (SolverException e) {
            String errorMessage = "SolverException while instantiating the CcslSolver";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        }

        Activator.getMessagingSystem().debug(
                "Adding all the JAR files from folder " + jarDependenciesFolderPath + " and " + jarDsaFolderPath
                        + " to the current ClassLoader", Activator.PLUGIN_ID);
        ClassLoader customizedClassLoader = this.customizeClassLoader(jarDsaFolderPath, jarDependenciesFolderPath);
        Activator.getMessagingSystem().debug("Initializing the model loader", Activator.PLUGIN_ID);
        EObject modelLoader = this.createAndInitializeModelLoader(customizedClassLoader);
        // Activator.getMessagingSystem().debug("Loading the model",
        // Activator.PLUGIN_ID);
        // EObject modelRoot = this.loadModel(modelLoader, this.modelURI,
        // this.metamodelURI);

    }

    /**
     * the jarIFile must be set before to call this metamodel. It retrieves the
     * model and metamodel uri and load the model It considers that the main
     * class is in a mainPackage and that the mainClass have a the following
     * method: loadModel(String modelPath, String metamodelURI)
     * 
     * @param a
     *            configuration helper
     * @return
     * @throws IOException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    private EObject loadModel(EObject modelLoader, URI modelURI, URI metamodelURI) {
        EObject modelRoot = null;
        try {
            Method loadModelMethod;
            loadModelMethod = modelLoader.getClass().getDeclaredMethod("loadModel", String.class, String.class);
            modelRoot = (EObject) loadModelMethod.invoke(modelLoader, modelURI.toString(), metamodelURI.toString());
            for (EObject eo : modelRoot.eContents()) {
                Activator.getMessagingSystem().warn(eo.toString(), Activator.PLUGIN_ID);
            }
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
            Activator.error("Exception within InvocationTargetException", e.getCause());
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
            Class<?> init;
            init = classLoader.loadClass(prop.get("mainRunner").toString());
            Activator.getMessagingSystem().debug(
                    "ClassLoader : " + Arrays.asList(((URLClassLoader) classLoader).getURLs()).toString(),
                    Activator.PLUGIN_ID);
            Activator.getMessagingSystem().debug(
                    "Method init4eclipse : " + init.getDeclaredMethod("init4eclipse").toString(), Activator.PLUGIN_ID);
            init.getDeclaredMethod("init4eclipse").invoke(null, (Object[]) null);
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
            String errorMessage = "InvocationTargetException while initializing the model loader : ";
            for (StackTraceElement element : e.getCause().getStackTrace()) {
                errorMessage += "\n" + element.toString();
            }
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

    @Override
    protected List<DomainSpecificEvent> match(Step step) {
        Activator.getMessagingSystem().debug("Matching the given step : " + step.toString(), Activator.PLUGIN_ID);
        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
        try {
            CcslStep ccslStep = (CcslStep) step;
            for (EventOccurrence eventOccurrence : ccslStep.getEventOccurrences()) {
                if (eventOccurrence.getFState() == FiredStateKind.TICK) {
                    Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
                    if (c != null) {
                        // is c a DSA caller --> should be replaced with mapping
                        // manipulation
                        EList<EObject> linkedObjects = c.getTickingEvent().getReferencedObjectRefs();
                        if (linkedObjects.size() == 2) {
                            res.add(new EclEvent(linkedObjects.get(0), linkedObjects.get(1)));
                        }
                    }
                }

            }
        } catch (ClassCastException e) {
            String errorMessage = "ClassCastException while casting Step as CcslStep";
            Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
            Activator.error(errorMessage, e);
        }
        return res;

    }

    private Clock getClockLinkedToOccurrence(EventOccurrence eventOcc) {
        Reference ref = eventOcc.getReferedElement();
        if (ref instanceof ModelElementReference) {
            ModelElementReference mer = (ModelElementReference) ref;
            EList<EObject> eobjects = mer.getElementRef();
            EObject actualObject = eobjects.get(eobjects.size() - 1);
            if (actualObject instanceof Clock) {
                // you got the clock that ticked
                return (Clock) actualObject;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
