package org.gemoc.execution.engine.core.impl.emf.ecl.ccsl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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
import org.gemoc.execution.engine.feedback.data.impl.easy.EObjectFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.feedback.policy.impl.easy.SimpleFeedbackPolicy;
import org.gemoc.execution.engine.solvers.Step;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslStep;

import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

    private CcslSolver solver;
    private FeedbackPolicy<EObjectFeedbackData> feedbackPolicy;

    private URI modelURI = null;
    private URI metamodelURI = null;

    public EmfEclCcslExecutionEngine(String ccslFilePath, String jarsFolderPath, String modelPath, String MMpath) {

        super();
        LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINEST);

        this.feedbackPolicy = new SimpleFeedbackPolicy(logger.getName());

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
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        }

        logger.log(Level.FINEST, "Instantiating CcslSolver");
        try {
            this.solver = new CcslSolver(logger.getName(), ccslResource);
        } catch (IOException e) {
            String errorMessage = "IOException while instantiating the CcslSolver";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (UnfoldingException e) {
            String errorMessage = "UnfoldingException while instantiating the CcslSolver";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (SolverException e) {
            String errorMessage = "SolverException while instantiating the CcslSolver";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        }

        logger.log(Level.FINEST, "Adding all the JAR files from folder " + jarsFolderPath
                + " to the current ClassLoader");
        ClassLoader customizedClassLoader = this.customizeClassLoader(jarsFolderPath);
        logger.log(Level.FINEST, "Initializing the model loader");
        EObject modelLoader = this.createAndInitializeModelLoader(customizedClassLoader);
        logger.log(Level.FINEST, "Loading the model");
        EObject modelRoot = this.loadModel(modelLoader, this.modelURI, this.metamodelURI);

        this.executor = new EmfExecutor(logger.getName());
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
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException while trying to load the model";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException while trying to load the model";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException while trying to load the model";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException while trying to load the model";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException while trying to load the model";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
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
            init.getDeclaredMethod("init4eclipse").invoke(null, (Object[]) null);
            Class<?> fact;
            fact = classLoader.loadClass(prop.get("mainFactory").toString());
            modelLoader = (EObject) fact.getDeclaredMethod("create" + prop.get("mainClass")).invoke(fact);
            in.close();
        } catch (IOException e) {
            String errorMessage = "IOException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (ClassNotFoundException e) {
            String errorMessage = "ClassNotFoundException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (IllegalAccessException e) {
            String errorMessage = "IllegalAccessException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (IllegalArgumentException e) {
            String errorMessage = "IllegalArgumentException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (InvocationTargetException e) {
            String errorMessage = "InvocationTargetException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (NoSuchMethodException e) {
            String errorMessage = "NoSuchMethodException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (SecurityException e) {
            String errorMessage = "SecurityException while creating the custom ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        }

        return modelLoader;

    }

    private ClassLoader customizeClassLoader(String jarsFolderPath) {
        List<URL> urls = new ArrayList<URL>();
        try {
            IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(jarsFolderPath));
            for (IResource resource : folder.members()) {
                if (resource instanceof IFile) {
                    IFile file = (IFile) resource;
                    if (file.getFileExtension().equals("jar")) {
                        urls.add(file.getLocationURI().toURL());
                    }
                }
            }
        } catch (CoreException e) {
            String errorMessage = "CoreException while customizing the ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        } catch (MalformedURLException e) {
            String errorMessage = "MalformedURLException while customizing the ClassLoader";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        }

        URL[] turls = (URL[]) urls.toArray(new URL[urls.size()]);
        ClassLoader res = new URLClassLoader(turls, Activator.class.getClassLoader());
        return res;
    }

    @Override
    protected List<DomainSpecificEvent> match(Step step) {
        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
        try {
            CcslStep ccslStep = (CcslStep) step;
            for (EventOccurrence eventOccurrence : ccslStep.getEventOccurrences()) {
                if (eventOccurrence.getFState() == FiredStateKind.TICK) {
                    res.add(new EclEvent(eventOccurrence));
                }

            }
        } catch (ClassCastException e) {
            String errorMessage = "ClassCastException while casting Step as CcslStep";
            logger.log(Level.SEVERE, errorMessage, e);
            Activator.error(errorMessage, e);
        }
        return res;

    }
}
