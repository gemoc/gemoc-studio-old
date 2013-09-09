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

import javax.naming.NotContextException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.console.MessageConsoleStream;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.modelunfolding.exception.UnfoldingException;
import fr.inria.aoste.timesquare.ccslkernel.solver.CCSLKernelSolver;
import fr.inria.aoste.timesquare.ccslkernel.solver.exception.SolverException;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

	private CCSLKernelSolver solver;
	private Resource ccslRessource;
	private URLClassLoader _kerLoader = null;
	private EObject _modelRoot = null;
	private EObject _modelLoader = null;
	private URI _modelURI = null;
	private URI _metamodelURI = null;
	private MessageConsoleStream out;

	public EmfEclCcslExecutionEngine(String ccslFilePath,
			MessageConsoleStream out, String jarsFolderPath, String modelPath,
			String MMpath) throws IOException, UnfoldingException,
			SolverException, ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		super();
		this.out = out;
		_modelURI = URI.createPlatformResourceURI(modelPath, true); // "platform:/resource/
		_metamodelURI = URI.createPlatformResourceURI(MMpath, true);
		try {
			URI uri = URI.createPlatformResourceURI(ccslFilePath, false);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			// resourceSet.createResource(uri);
			resource.load(null);
			EcoreUtil.resolveAll(resourceSet);

			ccslRessource = resource;
		} catch (IOException e) {
			out.println("exception");
			out.println(e.getMessage());
			e.printStackTrace();
		}
		out.println("Creating solver...");
		solver = new CCSLKernelSolver();
		solver.loadModel(ccslRessource);
		solver.initSimulation();
		out.println("...solver OK : " + solver.toString());

		out.println("Loading ALL THE jar files...");
		setJarFile(jarsFolderPath);
		// Path path = new Path(dsajarFilePath);
		// IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		// out.println("ifile du jar : " + file.toString());
		// out.println("loadjarfile : " + loadJarFile(file));
		out.println("... jar OK");

		loadModel();
	}

	private boolean setJarFile(String folderName) {
		// URLClassLoader loader = (URLClassLoader)
		// ClassLoader.getSystemClassLoader();
		List<URL> urls = new ArrayList<URL>();
		try {
			// urls.add(new URL(jarFileName));
			IFolder folder = ResourcesPlugin.getWorkspace().getRoot()
					.getFolder(new Path(folderName));
			try {
				for (IResource resource : folder.members()) {
					if (resource instanceof IFile) {
						IFile file = (IFile) resource;
						if (file.getFileExtension().equals("jar")) {
							urls.add(file.getLocationURI().toURL());
						}
					}
				}
			} catch (CoreException e) {
				out.println("coreexception");
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			out.println("malformed url");
			Activator.error("malformed url", e);
			e.printStackTrace();
		}
		URL[] turls = (URL[]) urls.toArray(new URL[urls.size()]);
		_kerLoader = new URLClassLoader(turls, Activator.class.getClassLoader());
		return true;

	}

	public void runOneStep() throws NotContextException, SolverException {
		LogicalStep currentStep = solver.doOneSimulationStep();
		out.println("***** INSIDE runOneStep *****");
		for (EventOccurrence eventOcc : currentStep.getEventOccurrences()) {
			if (eventOcc.getFState() != FiredStateKind.TICK) {
				continue;
			}

			Clock c = getClock(eventOcc);

			if (c == null) {
				continue;
			}

			// is c a DSA caller --> should be replaced with mapping
			// manipulation
			EList<EObject> linkedObjects = c.getTickingEvent()
					.getReferencedObjectRefs();
			if (linkedObjects.size() != 2) {
				continue;
			}

			// first object is the object, second is the method
			EObject eo = linkedObjects.get(0);
			EObject method = linkedObjects.get(1);
			String methodName = "";
			if (method instanceof EOperation) {
				methodName = getSimpleName(method);
			} else {
				throw new NotContextException("ouch");
			}

			out.println("Trying to invoke method : " + methodName
					+ " on object " + eo.toString());

			invokeMethod(eo, methodName);
		}
	}

	private EObject createAndInitializeModelLoader() throws IOException,
			ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		if (_kerLoader == null) {
			out.println("kerloader is null");
			throw new NullPointerException("the _kerLoader is null");
		}
		Properties prop = new Properties();
		InputStream in = _kerLoader.getResourceAsStream("main.properties");
		prop.load(in);

		String s = prop.get("mainRunner").toString();
		Class<?> init = _kerLoader.loadClass(prop.get("mainRunner").toString());
		init.getDeclaredMethod("init4eclipse").invoke(null, (Object[]) null);
		Class<?> fact = _kerLoader
				.loadClass(prop.get("mainFactory").toString());
		_modelLoader = (EObject) fact.getDeclaredMethod(
				"create" + prop.get("mainClass")).invoke(fact);
		in.close();

		return _modelLoader;

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
	private EObject loadModel() throws ClassNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException,
			SecurityException, IOException {
		createAndInitializeModelLoader();
		try {
			Method load = _modelLoader.getClass().getDeclaredMethod(
					"loadModel", String.class, String.class);
			_modelRoot = (EObject) load.invoke(_modelLoader,
					_modelURI.toString(), _metamodelURI.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return _modelRoot;
	}

	private Object invokeMethod(EObject eo, String methodName) {
		Method m = null;
		Object res = null;
		try {
			m = eo.getClass().getMethod(methodName);
			res = m.invoke(eo);
		} catch (SecurityException e) {
			Activator.error("exception", e);
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			Activator.error("exception", e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			Activator.error("exception", e);
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			Activator.error("exception", e);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			try {
				m = eo.getClass().getMethod("EMFRENAME" + methodName); // dirty
																		// fix
																		// due
																		// to
																		// kermeta
																		// dirty
																		// fix
																		// :-/
																		// ask
																		// Didier
				res = m.invoke(eo);
			} catch (SecurityException e1) {
				Activator.error("exception", e);
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				Activator.error("exception", e);
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				Activator.error("exception", e);
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				Activator.error("exception", e);
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				Activator.error("exception", e);
				e1.printStackTrace();
			}
		}
		out.println("Result of calling " + methodName + " on " + eo.toString()
				+ " : " + res.toString());
		return res;
	}

	private String getSimpleName(EObject eo) {
		Object res = null;
		res = invokeMethod(eo, "getName");
		return (String) res;
	}

	private Clock getClock(EventOccurrence eventOcc) throws NotContextException {

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
			throw new NotContextException(
					"executionEngine::runOneStep(): What's this reference ?"
							+ ref);
		}
	}

	@Override
	protected List<DomainSpecificEvent> match(Step step) {
		// TODO Auto-generated method stub
		return null;
	}

	// private ClockEntity findClockEntity(ConcreteEntity clock) {
	// String clockPath = CCSLKernelUtils.getQualifiedName(clock, "::");
	//
	// for (ClockEntity ce : _helper.getClocks()) {
	// ModelElementReference mer = ce.getModelElementReference();
	// String path = ReferenceNameBuilder.buildQualifiedName(mer, "::");
	// if (clockPath.compareTo(path) == 0) {
	// return ce;
	// }
	// }
	// return null;
	// }

	//
	//
	//
	//
	// public List<DomainSpecificEvent> loadEcl(String filename) {
	//
	// List<DomainSpecificEvent> events = new ArrayList<DomainSpecificEvent>();
	//
	// // Initialize the model
	// ECLPackage.eINSTANCE.eClass();
	//
	// // Register the XMI resource factory for the .website extension
	//
	// Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	// Map<String, Object> m = reg.getExtensionToFactoryMap();
	// m.put("ecl", new ECLFactoryImpl());
	//
	// // Obtain a new resource set
	// ResourceSet resSet = new ResourceSetImpl();
	//
	// // Get the resource
	// Resource resource = resSet.getResource(URI.createURI(filename), true);
	// // Get the first model element and cast it to the right type, in my
	// // example everything is hierarchical included in this first node
	// ECLDocument document = (ECLDocument) resource.getContents().get(0);
	// Iterator<EObject> it = resource.getAllContents();
	//
	// while (it.hasNext()) {
	// EObject eo = it.next();
	// if (eo instanceof DefCS) {
	// DefCS def = (DefCS) eo;
	// if (def.getOwnedType() instanceof EventType) {
	// // def is a variable of type event
	// EventType et = (EventType) def.getOwnedType();
	// ExpCS nav = et.getReferedElement();
	//
	// EObject cont = def.eContainer();
	// // get a OCL interpreter
	// // oclinterpeter.eval(nav, cont);
	// Query query = QueryFactory.eINSTANCE.createQuery(nav, cont);
	// }
	// }
	// }
	//
	// return events;
	// }
	//
	// /**
	// *
	// * @param step
	// * @return the list of Domain Specific Event which are triggered by the
	// * step.
	// */
	// protected List<DomainSpecificEvent> match(Step step) {
	// List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
	// for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
	// res.add(new EclEvent(eventOccurrence));
	// }
	// return res;
	// }
	//
	// public String toString() {
	// return "EmfEclCcslExecutionEngine@[rounds=" + this.getRounds() + "]";
	// }
}
