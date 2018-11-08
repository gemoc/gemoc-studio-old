package org.gemoc.sample.tfsm.concurrent.design.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.executionframework.engine.commons.K3DslHelper;

public class K3RuntimeDataHelper {
	

	public String getCurrentState(EObject eObject) {
		return getAspectProperty(eObject, "org.gemoc.sample.tfsm.concurrent.TFSM", "org.gemoc.sample.tfsm.concurrent.k3dsa.aspect.TFSMAspect", "currentState");
	}
	
	
	public String getAspectProperty(EObject eObject, String languageName, String aspectName, String propertyName) {
			List<Class<?>> aspects = K3DslHelper.getAspectsOn(languageName, eObject.getClass());
			Class<?> aspect = null;
			for (Class<?> a : aspects) {
				try {
					if (Class.forName(aspectName).isAssignableFrom(a)) {
						aspect = a;
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (aspect == null) {
				return "void (no aspect)";
			}
			Object res = null;
			 try {
				res = aspect.getDeclaredMethod(propertyName, ((fr.inria.diverse.k3.al.annotationprocessor.Aspect)aspect.getAnnotations()[0]).className()).invoke(eObject, eObject);
				if (res != null) {
					return res.toString();
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			
			 return "void";
		}
	

}

