package org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodCall;
import org.gemoc.gemoc_language_workbench.extensions.k3.dsa.api.IK3DSAExecutorClassLoader;

/**
 * Executor that is able to find the helper class associated with a given object
 * It also works for aspect on EMF: - In case of EObject, (target or parameter)
 * it is also able to find the appropriate interface when looking for the method
 * 
 * @author dvojtise
 * 
 */
public class Kermeta3AspectsCodeExecutor implements CodeExecutor {

	// protected ClassLoader classLoader;
	protected IK3DSAExecutorClassLoader k3DSAExecutorClassLoader;
	protected String bundleSymbolicName;

	public Kermeta3AspectsCodeExecutor(
			IK3DSAExecutorClassLoader k3DSAExecutorClassLoader,
			String bundleSymbolicName) {
		// this.classLoader = classLoader;
		this.k3DSAExecutorClassLoader = k3DSAExecutorClassLoader;
		this.bundleSymbolicName = bundleSymbolicName;
	}

	@Override
	public Object invoke(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException,
			IllegalAccessException {
		MethodCall command = this.getMethodCall(target, methodName, parameters);
		if (command != null) {
			try {
				return command.invoke();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		NoSuchMethodException e = new NoSuchMethodException(
				"cannot find applicable method " + methodName
						+ " and matching parameters on " + target);
		e.printStackTrace();
		// TODO should return the fact that it cannot be executed via an
		// exception (NoSuchMethodException ? or custom ?)
		return null;
	}

	@Override
	public MethodCall getMethodCall(Object target, String methodName,
			List<Object> parameters) throws NoSuchMethodException,
			IllegalArgumentException {

		Class<?> staticHelperClass = getStaticHelperClass(target);
		if (staticHelperClass == null)
			return null; // no applicable static class found

		ArrayList<Object> staticParameters = new ArrayList<Object>();
		staticParameters.add(target);
		if (parameters != null) {
			staticParameters.addAll(parameters);
		}
		Method bestApplicableMethod = getFirstApplicableMethod(
				staticHelperClass, methodName, staticParameters);
		if (bestApplicableMethod != null)
			return new Kermeta3AspectsMethodCall(staticHelperClass,
					bestApplicableMethod, staticParameters);
		else
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
	protected Method getFirstApplicableMethod(Class<?> staticHelperClass,
			String methodName, ArrayList<Object> parameters) {

		Method[] methods = staticHelperClass.getDeclaredMethods();
		for (Method method : methods) {
			Class<?>[] evaluatedMethodParamTypes = method.getParameterTypes();
			if (method.getName().equals(methodName)
					&& evaluatedMethodParamTypes.length == parameters.size()) {
				boolean isAllParamCompatible = true;
				for (int i = 0; i < evaluatedMethodParamTypes.length; i++) {
					if (!evaluatedMethodParamTypes[i].isInstance(parameters
							.get(i))) {
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
	protected Class<?> getStaticHelperClass(Object target) {

		String searchedAspectizedClassCanonicalName = getInterfaceClassOfEObjectOrClass(
				target).getCanonicalName();

		String searchedPropertyFileName = "/META-INF/xtend-gen/"
				+ bundleSymbolicName + ".k3_aspect_mapping.properties";
		Properties properties = new Properties();
		InputStream inputStream = k3DSAExecutorClassLoader
				.getResourceAsStream(searchedPropertyFileName);
		if (inputStream == null) {
			try {
				inputStream = org.eclipse.core.runtime.Platform
						.getBundle(bundleSymbolicName)
						.getEntry(searchedPropertyFileName).openStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		String possibleStaticClassName = null;
		try {
			if (inputStream != null) {
				properties.load(inputStream);
				possibleStaticClassName = properties
						.getProperty(searchedAspectizedClassCanonicalName);
			}
		} catch (IOException e) {
			// TODO report for debug that no mapping was found
			return null;
		}
		if (possibleStaticClassName == null) {
			return null;

		}

		try { // Class.forName(possibleStaticClassName)
				// Class.forName(possibleStaticClassName, true, classLoader);
			return k3DSAExecutorClassLoader
					.getClassForName(possibleStaticClassName);
		} catch (ClassNotFoundException e) {
		}
		return null;
	}

	/**
	 * returns the class of o or the interface that o implements in the case of
	 * EObjects
	 * 
	 * @param o
	 * @return
	 */
	public Class<?> getInterfaceClassOfEObjectOrClass(Object o) {
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
			Class<?> interfaces[] = o.getClass().getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				Class<?> interfac = interfaces[i];
				if (interfac.getSimpleName().equals(
						((EObject) o).eClass().getName())) {
					return interfaces[i];
				}
			}
			return o.getClass();

		} else {
			return o.getClass();
		}

	}

	/**
	 * Command that is able to execute the required method
	 * 
	 */
	public class Kermeta3AspectsMethodCall implements MethodCall {

		protected Class<?> staticHelperClass;
		protected Method method;
		protected List<Object> staticParameters;

		public Kermeta3AspectsMethodCall(Class<?> staticHelperClass,
				Method method, List<Object> staticParameters) {
			this.staticHelperClass = staticHelperClass;
			this.method = method;
			this.staticParameters = staticParameters;
		}

		@Override
		public Object invoke() throws IllegalAccessException,
				IllegalArgumentException, InvocationTargetException {
			Object[] args = new Object[0];
			if (staticParameters != null) {
				args = staticParameters.toArray();
			}
			Object res = method.invoke(null, args);
			return res;
		}

		@Override
		public Object getTarget() {
			return staticParameters.get(0);
		}

		@Override
		public Method getMethod() {
			return this.method;
		}

		@Override
		public List<Object> getParameters() {
			return staticParameters.subList(1, staticParameters.size() - 1);
		}

	}

}
