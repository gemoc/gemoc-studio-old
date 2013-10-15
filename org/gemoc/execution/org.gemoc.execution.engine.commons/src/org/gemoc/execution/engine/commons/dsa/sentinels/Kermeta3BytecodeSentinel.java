package org.gemoc.execution.engine.commons.dsa.sentinels;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

public class Kermeta3BytecodeSentinel implements BytecodeSentinel {
	protected ClassLoader classLoader;
	protected String bundleSymbolicName;

	public Kermeta3BytecodeSentinel(ClassLoader classLoader,
			String bundleSymbolicName) {
		this.classLoader = classLoader;
		this.bundleSymbolicName = bundleSymbolicName;
	}

	@Override
	public Method getMethodFromAction(DomainSpecificAction dsa) {
		Object target = (Object) dsa.getTarget();
		String methodName = dsa.getOperation().getName();
		List<Object> parameters = new ArrayList<Object>((dsa.getParameters()));

		Class<?> staticHelperClass = getStaticHelperClass(target);
		if (staticHelperClass == null)
			return null; // no applicable static class found

		Class<?>[] parameterTypes = new Class<?>[parameters != null ? parameters
				.size() + 1 : 1];
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		parameterTypesList.add(getInterfaceClassOfEObjectOrClass(target)); // add
																			// the
																			// target
																			// as
																			// first
																			// param
		if (parameters != null) {
			for (Object param : parameters) {
				parameterTypesList
						.add(getInterfaceClassOfEObjectOrClass(param));
			}
		}
		parameterTypes = parameterTypesList.toArray(parameterTypes);
		try {
			return staticHelperClass.getMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException e) {
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		}
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
		InputStream inputStream = classLoader
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

		try {
			return Class.forName(possibleStaticClassName, true, classLoader);
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

}
