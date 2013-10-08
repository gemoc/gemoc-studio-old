package org.gemoc.gemoc_language_workbench.extensions.k3.dsa.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IDSAExecutorCommand;

public class K3DSAAspectExecutor implements IDSAExecutor {

	protected ClassLoader classLoader;
	
	public K3DSAAspectExecutor(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public Object execute(Object target, String methodName,
			ArrayList<Object> parameters) {
		IDSAExecutorCommand command = this.getCommand(target, methodName, parameters);
		if(command != null){
			try {
				return command.execute();
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
		NoSuchMethodException e = new NoSuchMethodException("cannot find applicable method "+methodName+" and matching parameters on "+target);
		e.printStackTrace();
		// TODO should return the fact that it cannot be executed via an exception (NoSuchMethodException ? or custom ?)
		return null;
	}

	@Override
	public IDSAExecutorCommand getCommand(Object target, String methodName,
			ArrayList<Object> parameters) {
		
		
		
		Class<?> staticHelperClass = getStaticHelperClass(target);
		if(staticHelperClass == null) return null; // no applicable static class found
		
		Class<?>[] parameterTypes = null;
		ArrayList<Class<?>> parameterTypesList = new ArrayList<Class<?>>();
		parameterTypesList.add(target.getClass()); // add the target as first param
		if(parameters != null){
			for(Object param : parameters){
				parameterTypesList.add(param.getClass());
			}
		}
		try {
			Method method = target.getClass().getMethod(methodName, parameterTypes);
			
			return new K3DSAAspectExecutorCommand(staticHelperClass, target, method, parameters);
		} catch (NoSuchMethodException e) {
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/** search static class by name  (future version should use a map of available aspects, and deals with it as a list of applicable static classes)
	 *
	 */
	protected Class<?> getStaticHelperClass(Object target){
		String targetClassCanonicalName = target.getClass().getCanonicalName();
		String possibleStaticClassName = targetClassCanonicalName.substring(0, targetClassCanonicalName.lastIndexOf("."));
		// class name comes from Ecore or just try as simpe java class
		String targetClassName = target instanceof EObject ? ((EObject)target).eClass().getName() : targetClassCanonicalName.substring(targetClassCanonicalName.lastIndexOf(".")+1, targetClassCanonicalName.length());
		if(target instanceof EObject && possibleStaticClassName.endsWith(".impl")){
			possibleStaticClassName = possibleStaticClassName.substring(0, possibleStaticClassName.lastIndexOf(".impl"));
		}
		possibleStaticClassName = possibleStaticClassName + ".aspect."+targetClassName+"Aspect";
		try {
			//Class.forName("org.gemoc.sample.tfsm.k3dsa.aspect.TimedSystemAspect");, true, classLoader)
			return Class.forName(possibleStaticClassName, true, classLoader);
		} catch (ClassNotFoundException e) {}
		return null;
	}
	
	public class K3DSAAspectExecutorCommand implements IDSAExecutorCommand{

		protected Class<?> staticHelperClass;
		protected Method method;
		protected ArrayList<Object> staticParameters = new ArrayList<Object>();
		
		public K3DSAAspectExecutorCommand(Class<?> staticHelperClass, Object target, Method method,
				ArrayList<Object> parameters) {
			this.staticHelperClass = staticHelperClass;
			this.method = method;
			this.staticParameters.add(target);
			this.staticParameters.addAll(parameters);
		}

		@Override
		public Object execute() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			Object[] args = new Object[0];
			if(staticParameters != null){
				args =staticParameters.toArray();
			}
			return method.invoke(null, args); 
		}
		
	}

}
