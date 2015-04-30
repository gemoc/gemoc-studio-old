package org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutionException;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.extensions.k3.Activator;
import org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api.IK3DSAExecutorClassLoader;

/**
 * Executor that is able to find the helper class associated with a given object
 * It also works for aspect on EMF: - In case of EObject, (target or parameter)
 * it is also able to find the appropriate interface when looking for the method
 * 
 * @author dvojtise
 * 
 */
public class Kermeta3AspectsCodeExecutor implements ICodeExecutor {

	// protected ClassLoader classLoader;
	protected IK3DSAExecutorClassLoader k3DSAExecutorClassLoader;
	protected String bundleSymbolicName;

	public Kermeta3AspectsCodeExecutor(IK3DSAExecutorClassLoader k3DSAExecutorClassLoader, String bundleSymbolicName) {
		// this.classLoader = classLoader;
		this.k3DSAExecutorClassLoader = k3DSAExecutorClassLoader;
		this.bundleSymbolicName = bundleSymbolicName;
	}

	@Override
	public Object execute(MSEOccurrence mseOccurrence) throws CodeExecutionException {
		Object caller = mseOccurrence.getMse().getCaller();
		String methodName = mseOccurrence.getMse().getAction().getName();
		return internal_execute(caller, methodName, mseOccurrence.getParameters(), mseOccurrence);
	}

	@Override
	public Object execute(Object caller, String methodName, List<Object> parameters) throws CodeExecutionException {
		return internal_execute(caller, methodName, parameters, null);
	}

	private Object internal_execute(Object caller, String methodName, Collection<Object> parameters,
			MSEOccurrence mseOccurrence) throws CodeExecutionException {
		ArrayList<Object> staticParameters = new ArrayList<Object>();
		staticParameters.add(caller);
		if (parameters != null) {
			staticParameters.addAll(parameters);
		}
		Method bestApplicableMethod = getBestApplicableMethod(caller, methodName, staticParameters);
		if (bestApplicableMethod == null)
			throw new CodeExecutionException("static class not found or method not found when calling " + methodName
					+ " on " + caller + ". MSEOccurence=" + mseOccurrence, mseOccurrence, false);

		Object[] args = new Object[0];
		if (staticParameters != null) {
			args = staticParameters.toArray();
		}
		Object result = null;
		try {
			result = bestApplicableMethod.invoke(null, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new CodeExecutionException("Exception caught during execution of a call, see inner exception.", e,
					mseOccurrence, true);
		}
		return result;
	}

	private Method getBestApplicableMethod(Object caller, String methodName, List<Object> parameters) {
		Set<Class<?>> staticHelperClasses = getStaticHelperClasses(caller);
		if (staticHelperClasses == null || staticHelperClasses.isEmpty()) {
			return null;
		}
		for (Class<?> c : staticHelperClasses) {
			Method m = getFirstApplicableMethod(c, methodName, parameters);
			if (m != null)
				return m;
		}
		return null;
	}

	/**
	 * return the first compatible method, goes up the inheritance hierarchy
	 * 
	 * @param staticHelperClass
	 * @param methodName
	 * @param parameters
	 * @return
	 */
	protected Method getFirstApplicableMethod(Class<?> staticHelperClass, String methodName, List<Object> parameters) {

		Method[] methods = staticHelperClass.getDeclaredMethods();
		for (Method method : methods) {
			Class<?>[] evaluatedMethodParamTypes = method.getParameterTypes();
			if (method.getName().equals(methodName) && evaluatedMethodParamTypes.length == parameters.size()) {
				boolean isAllParamCompatible = true;
				for (int i = 0; i < evaluatedMethodParamTypes.length; i++) {
					Object p = parameters.get(i);
					if (evaluatedMethodParamTypes[i].isPrimitive()) {

						if (evaluatedMethodParamTypes[i].equals(Integer.TYPE) && !Integer.class.isInstance(p)) {
							isAllParamCompatible = false;
							break;
						} else if (evaluatedMethodParamTypes[i].equals(Boolean.TYPE) && !Boolean.class.isInstance(p)) {
							isAllParamCompatible = false;
							break;
						}

					} else if (!evaluatedMethodParamTypes[i].isInstance(p)) {
						isAllParamCompatible = false;
						break;
					}
				}
				if (isAllParamCompatible) {
					return method;
				}
			}
		}
		// tries going in the inheritance hierarchy
		Class<?> superClass = staticHelperClass.getSuperclass();
		if (superClass != null)
			return getFirstApplicableMethod(superClass, methodName, parameters);
		else
			return null;
	}

	/**
	 * search static class by name (future version should use a map of available
	 * aspects, and deals with it as a list of applicable static classes)
	 * 
	 */
	protected Set<Class<?>> getStaticHelperClasses(Object target) {
		List<Class<?>> allPossibleInterfaces = getInterfacesClassOfEObjectOrClass(target);

		String searchedPropertyFileName = "/META-INF/xtend-gen/" + bundleSymbolicName + ".k3_aspect_mapping.properties";
		Properties properties = new Properties();
		InputStream inputStream = k3DSAExecutorClassLoader.getResourceAsStream(searchedPropertyFileName);
		if (inputStream == null) {
			try {
				inputStream = org.eclipse.core.runtime.Platform.getBundle(bundleSymbolicName)
						.getEntry(searchedPropertyFileName).openStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		String possibleStaticClassesNames = null;
		try {
			if (inputStream != null) {
				properties.load(inputStream);
				for (int i = 0; i < allPossibleInterfaces.size(); i++) {
					possibleStaticClassesNames = properties
							.getProperty(allPossibleInterfaces.get(i).getCanonicalName());
					// Break so that the aspect is applied on the most precise
					// type
					if (possibleStaticClassesNames != null)
						break;
				}
			}
		} catch (IOException e) {
			// TODO report for debug that no mapping was found
			return null;
		}
		if (possibleStaticClassesNames == null) {
			return null;
		}

		Set<Class<?>> classes = new HashSet<Class<?>>();
		ClassNotFoundException possibleException = null;
		for (String possibleName : possibleStaticClassesNames.replaceAll(" ", "").split(",")) {
			try {
				classes.add(k3DSAExecutorClassLoader.getClassForName(possibleName));
			} catch (ClassNotFoundException e) {
				possibleException = e;
			}
		}
		if (classes.isEmpty()) {
			Activator.getMessagingSystem().error("ClassNotFoundException, see Error Log View", Activator.PLUGIN_ID,
					possibleException);
		}

		return classes;
	}

	/**
	 * returns the class of o or the interface that o implements in the case of
	 * EObjects
	 * 
	 * @param o
	 * @return
	 */
	protected List<Class<?>> getInterfacesClassOfEObjectOrClass(Object o) {
		List<Class<?>> possibleInterfaces = new ArrayList<Class<?>>();
		if (o instanceof EObject) {
			/*
			 * String targetClassCanonicalName =
			 * o.getClass().getCanonicalName(); String
			 * searchedAspectizedClassCanonicalName = targetClassCanonicalName;
			 * // apply special rules to retrieve the Ecore interface instead of
			 * the Impl String searchedAspectizedClasPackageName =
			 * targetClassCanonicalName.substring(0,
			 * targetClassCanonicalName.lastIndexOf("."));
			 * searchedAspectizedClasPackageName =
			 * searchedAspectizedClasPackageName.substring(0,
			 * searchedAspectizedClasPackageName.lastIndexOf(".impl"));
			 * searchedAspectizedClassCanonicalName =
			 * searchedAspectizedClasPackageName
			 * +"."+((EObject)o).eClass().getName();
			 */

			// @author tdegueul
			// Since aspects may target both base / extended metamodel classes
			// we need to retrieve the complete hierarchy of possible
			// applications
			List<Class<?>> interfaces = getAllInterfaces(o.getClass());
			for (int i = 0; i < interfaces.size(); i++) {
				Class<?> interfac = interfaces.get(i);
				if (interfac.getSimpleName().equals(((EObject) o).eClass().getName())) {
					possibleInterfaces.add(interfac);
				}
			}

		} else {
			possibleInterfaces.add(o.getClass());
		}

		return possibleInterfaces;

	}

	// The two following methods are copied from
	// org.apache.commons.lang.ClassUtils
	private static List<Class<?>> getAllInterfaces(Class<?> cls) {
		if (cls == null) {
			return null;
		}

		LinkedHashSet<Class<?>> interfacesFound = new LinkedHashSet<Class<?>>();
		getAllInterfaces(cls, interfacesFound);

		return new ArrayList<Class<?>>(interfacesFound);
	}

	private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
		while (cls != null) {
			Class<?>[] interfaces = cls.getInterfaces();

			for (Class<?> i : interfaces) {
				if (interfacesFound.add(i)) {
					getAllInterfaces(i, interfacesFound);
				}
			}

			cls = cls.getSuperclass();
		}
	}

	@Override
	public String getExcutorID() {
		return this.getClass().getSimpleName() + "[" + bundleSymbolicName + "]";
	}

	// @Override
	// public boolean canExecute(ActionCall call)
	// {
	// return getBestApplicableMethod(call.getTriggeringEvent().getCaller(),
	// call.getTriggeringEvent().getAction().getName(),
	// call.getParameters(),
	// call) != null;
	// }
	//
	//
	// @Override
	// public boolean canExecute(Object caller, String methodName, List<Object>
	// parameters)
	// {
	// return getBestApplicableMethod(caller,
	// methodName,
	// parameters,
	// null) != null;
	// }

}
