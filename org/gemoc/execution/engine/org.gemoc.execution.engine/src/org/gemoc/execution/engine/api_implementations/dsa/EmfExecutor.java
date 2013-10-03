package org.gemoc.execution.engine.api_implementations.dsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class EmfExecutor implements Executor {

	private Resource modelResource = null;
	private EmfBytecodeNameResolver nameResolver = null;

	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {

		Object target = null;
		try {
			target = (Object) this.nameResolver.getEObjectFromQualifiedName(dsa.getTargetQualifiedName());
		} catch (SecurityException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve an EObject from the model from its qualified name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve an EObject from the model from its qualified name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve an EObject from the model from its qualified name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve an EObject from the model from its qualified name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve an EObject from the model from its qualified name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
		Activator.getMessagingSystem().info("EObject found: " + target.toString(), Activator.PLUGIN_ID);

		Method method = null;
		try {
			method = this.getMethod(target, dsa.getMethodQualifiedName());
		} catch (SecurityException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve the method from an object and a method name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve the method from an object and a method name";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}

		Activator.getMessagingSystem().info("Method found: " + method.toString(), Activator.PLUGIN_ID);

		try {
			return DataConverter.convertToFeedbackData(method.invoke(target, (Object[]) null));
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName() + " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage, Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}
	}

	private Method getMethod(Object target, String methodQualifiedName) throws SecurityException, NoSuchMethodException {
		String methodName = methodQualifiedName.substring(methodQualifiedName.lastIndexOf("::") + 2);
		Activator.getMessagingSystem().info(Arrays.asList(target.getClass().getMethods()).toString(), Activator.PLUGIN_ID);
		Activator.getMessagingSystem().debug(methodName, Activator.PLUGIN_ID);
		return target.getClass().getMethod(methodName);
	}

	@Override
	public FeedbackData execute(DomainSpecificEvent dse) {
		return this.execute(dse.getAction());
	}

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;
		this.nameResolver = new EmfBytecodeNameResolver(modelResource);
	}

}
