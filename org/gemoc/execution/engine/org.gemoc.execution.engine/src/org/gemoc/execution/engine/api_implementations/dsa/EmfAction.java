/**
 * 
 */
package org.gemoc.execution.engine.api_implementations.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

/**
 * Basic implementation of DomainSpecificAction, contains the Object and a
 * Method to apply on the Object.
 * 
 * TODO : change name of the class it's terrible
 * 
 * @author flatombe
 * 
 */
public class EmfAction implements DomainSpecificAction {
	private EOperation operation;

	private EObject target;

	public EmfAction(EObject target, EOperation operation) {
		this.operation = operation;
		this.target = target;
	}

	public EOperation getOperation() {
		return this.operation;
	}

	public EObject getTarget() {
		return this.target;
	}

	@Override
	public String getMethodQualifiedName() {
		return this.getQualifiedName(this.operation);
	}

	@Override
	public String getTargetQualifiedName() {
		return this.getQualifiedName(this.target);
	}

	private String getQualifiedName(EObject eo) {
		String res = getSimpleName(eo);
		EObject tmp = eo.eContainer();
		while (tmp != null) {
			res = getSimpleName(tmp) + "::" + res;
			tmp = tmp.eContainer();
		}
		return res;
	}

	private String getSimpleName(EObject eo) {
		return this.retrieveMethodName(eo);
	}

	private String retrieveMethodName(EObject eObjectMethod) {
		Method method;
		try {
			method = eObjectMethod.getClass().getMethod("getName");
			Object res = method.invoke(eObjectMethod);
			if (res instanceof String) {
				return (String) res;
			} else {
				return null;
			}
		} catch (SecurityException e) {
			String errorMessage = "SecurityException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = "NoSuchMethodException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException when trying to get the qualified name of an object";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	public String toString() {
		return this.getClass().getName() + "@[" + this.target.toString() + " ; " + this.operation.toString() + "]";
	}

	@Override
	public List<String> getParametersQualifiedNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
