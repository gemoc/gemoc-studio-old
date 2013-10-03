package org.gemoc.execution.engine.api_implementations.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;

public class EmfBytecodeNameResolver {

	Resource modelResource;

	public EmfBytecodeNameResolver(Resource modelResource) {
		this.modelResource = modelResource;
	}

	public EObject getEObjectFromQualifiedName(String qualifiedName) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Activator.getMessagingSystem()
				.debug("Entering with targetqualifiedname: " + qualifiedName, Activator.PLUGIN_ID);
		Iterator<EObject> iterator = this.modelResource.getAllContents();// this.modelResource.getContents().get(0).eAllContents();
		EObject res = null;
		while (iterator.hasNext() & res == null) {
			EObject modelElement = iterator.next();
			if (this.getQualifiedName(modelElement).equals(qualifiedName)) {
				res = modelElement;
			}
		}
		return res;
	}

	private String getQualifiedName(EObject eo) throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String res = this.invokeGetNameOnEObject(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null) {
			res = this.invokeGetNameOnEObject(tmp) + "::" + res;
			tmp = tmp.eContainer();
		}
		return res;
	}

	private String invokeGetNameOnEObject(EObject eObjectMethod) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method method;
		method = eObjectMethod.getClass().getMethod("getName");
		Object res = method.invoke(eObjectMethod);
		if (res instanceof String) {
			return (String) res;
		} else {
			return null;
		}
	}
}
