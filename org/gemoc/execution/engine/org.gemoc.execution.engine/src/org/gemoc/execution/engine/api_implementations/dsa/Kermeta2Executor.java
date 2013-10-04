package org.gemoc.execution.engine.api_implementations.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * An executor that can call methods contained in compiled EMF code (like
 * Kermeta's).
 * 
 * @author flatombe
 */
public class Kermeta2Executor implements Executor {

	private DomainSpecificAction lastExecutedAction;
	private Resource modelResource;

	public Kermeta2Executor(Resource modelResource) {
		this.lastExecutedAction = null;
		this.modelResource = modelResource;
	}

	private Object executeWithInvoke(EObject eObject, EOperation operation) {
		Object res = null;
		Method method = null;
		try {
			try {
				method = eObject.getClass().getMethod("EMFRENAME" + operation.getName());
				Activator.getMessagingSystem().debug("méthode de nom hacked : " + method.toString(),
						Activator.PLUGIN_ID);

			} catch (NoSuchMethodException e) {
				String errorMessage = "NoSuchMethodException when trying to execute the method corresponding to an EOperation";
				Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
				try {
					method = eObject.getClass().getMethod(operation.getName());
					Activator.getMessagingSystem().debug("méthode de nom normal : " + method.toString(),
							Activator.PLUGIN_ID);
				} catch (NoSuchMethodException e1) {
					Activator.getMessagingSystem().error("suchmethodexception balbal", Activator.PLUGIN_ID);
				}
			}
			res = method.invoke(eObject, (Object[]) null);

			return res;
		} catch (SecurityException e) {
			String errorMessage = "SecurityException when trying to execute the method corresponding to an EOperation";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = "IllegalArgumentException when trying to execute the method corresponding to an EOperation";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = "IllegalAccessException when trying to execute the method corresponding to an EOperation";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = "InvocationTargetException when trying to execute the method corresponding to an EOperation";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			Activator.error("Nested Exception", e.getCause());
			return null;
		}

	}

	public FeedbackData execute(EObject eObject, EOperation operation) {
		Activator.getMessagingSystem().info(
				"Executing EOperation of name " + operation.getName() + " on eobject " + eObject.toString()
						+ " or on one of its heirs if the method is not implemented in EMF.", Activator.PLUGIN_ID);

		FeedbackData res = null;
		// Object eInvokeResult = this.executeWithEInvoke(eObject, operation);
		Object invokeResult = this.executeWithInvoke(eObject, operation);
		Activator.getMessagingSystem().debug("Result of the invokation: " + invokeResult.toString(),
				Activator.PLUGIN_ID);

		return res;

		/*
		 * try { realObject = this.getMethod(eObject, operation); Method method
		 * = realObject.getClass().getMethod(operation);
		 * Activator.getMessagingSystem
		 * ().debug("The real object which we will use: " +
		 * realObject.toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("The method is the following: "
		 * + method.toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("-Declaring Class: " +
		 * method.getDeclaringClass().toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("-Class: " +
		 * method.getClass().toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("-Return type: " +
		 * method.getReturnType().toString(), Activator.PLUGIN_ID); return
		 * DataConverter.convertToFeedbackData(method.invoke(realObject)); }
		 * catch (SecurityException e) { String errorMessage =
		 * "SecurityException when trying to invoke a Domain Specific Action";
		 * Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e); return null;
		 * } catch (NoSuchMethodException e) { String errorMessage =
		 * "NoSuchMethodException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e); return null;
		 * } catch (IllegalAccessException e) { String errorMessage =
		 * "IllegalAccessException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e); return null;
		 * } catch (IllegalArgumentException e) { String errorMessage =
		 * "IllegalArgumentException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e); return null;
		 * } catch (InvocationTargetException e) { try {
		 * Activator.getMessagingSystem().debug("InvocationTargetException : " +
		 * e.getCause().getMessage(), Activator.PLUGIN_ID);
		 * Activator.error("InvocationTargetException on " + operation,
		 * e.getCause()); Activator.getMessagingSystem().debug(
		 * "Could not find method " + operation +
		 * " so let's try with the EMF hack!", Activator.PLUGIN_ID); Method
		 * method = this.getMethodEmfHack(realObject, operation);
		 * Activator.getMessagingSystem().debug(
		 * "EMFHACK::The real object which we will use: " +
		 * realObject.toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem
		 * ().debug("EMFHACK::The method is the following: " +
		 * method.toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug( "EMFHACK::-Declaring Class: " +
		 * method.getDeclaringClass().toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("EMFHACK::-Class: " +
		 * method.getClass().toString(), Activator.PLUGIN_ID);
		 * Activator.getMessagingSystem().debug("EMFHACK::-Return type: " +
		 * method.getReturnType().toString(), Activator.PLUGIN_ID); return
		 * (FeedbackData) method.invoke(realObject); } catch
		 * (IllegalArgumentException e1) { String errorMessage =
		 * "IllegalArgumentException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e1); return null;
		 * } catch (IllegalAccessException e1) { String errorMessage =
		 * "IllegalAccessException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e1); return null;
		 * } catch (InvocationTargetException e1) { String errorMessage =
		 * "InvocationTargetException when trying to invoke a Domain Specific Action"
		 * ; Activator.getMessagingSystem().error(errorMessage,
		 * Activator.PLUGIN_ID); Activator.error(errorMessage, e1); return null;
		 * } }
		 */
	}

	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {
		Activator.getMessagingSystem().debug("Executing Domain Specific Action : " + dsa.toString(),
				Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug("EObj: " + ((EmfAction) dsa).getTarget().toString(), Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug("EObj: " + ((EmfAction) dsa).getTarget().eClass().toString(),
				Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug(
				"EObj: " + ((EmfAction) dsa).getTarget().eClass().getEAllOperations().toString(), Activator.PLUGIN_ID);

		Activator.getMessagingSystem()
				.debug("EOp: " + ((EmfAction) dsa).getOperation().toString(), Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug(
				"EOp: " + ((EmfAction) dsa).getOperation().getEContainingClass().toString(), Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug(
				"EOp: " + ((EmfAction) dsa).getOperation().getEContainingClass().getEAllOperations().toString(),
				Activator.PLUGIN_ID);

		Activator.getMessagingSystem().debug("Retrieving EObject in the DSA with the name: " + dsa.getTarget(),
				Activator.PLUGIN_ID);

		EObject eObject = dsa.getTarget();

		Activator.getMessagingSystem().debug("EObject found: " + eObject.toString(), Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug("Retrieving EOperation in the DSA with the name: " + dsa.getOperation(),
				Activator.PLUGIN_ID);

		EOperation eOperation = dsa.getOperation();

		Activator.getMessagingSystem().debug("EOperation found: " + eOperation.toString(), Activator.PLUGIN_ID);

		FeedbackData feedback = this.execute(eObject, eOperation);

		this.lastExecutedAction = dsa;
		return feedback;
	}

	@Override
	public FeedbackData execute(DomainSpecificEvent dse) {
		Activator.getMessagingSystem().debug("EMFExecuting the action from DomainSpecificEvent " + dse.toString(),
				Activator.PLUGIN_ID);
		return this.execute(dse.getAction());
	}

	public String toString() {
		return this.getClass().getName() + "@[lastExecutedAction=" + lastExecutedAction.toString() + " ; modelRoot="
				+ modelResource.toString() + "]";
	}

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;
	}

}
