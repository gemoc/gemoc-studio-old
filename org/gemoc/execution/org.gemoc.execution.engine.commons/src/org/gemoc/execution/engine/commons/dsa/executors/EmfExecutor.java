package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.DataConverter;
import org.gemoc.execution.engine.commons.dsa.sentinels.EmfBytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class EmfExecutor implements Executor {

	private Resource modelResource = null;
	private BytecodeSentinel sentinel = null;

	public EmfExecutor() {
//		this.sentinel = new EmfBytecodeSentinel();
	}

	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {
		// The target is simply casting the EObject into an Object
		Object target = (Object) dsa.getTarget();

		// Retrieving the parameters from which we can deduce their types
		List<EParameter> parameters = new ArrayList<EParameter>(
				dsa.getParameters());
		Class<?>[] parametersType = new Class<?>[parameters.size()];
		for (int i = 0; i < parameters.size(); i++) {
			parametersType[i] = parameters.get(i).getClass();
		}

		// Retrieving the method from its name and parameters types array.
		Method method;
		try {
			method = target.getClass().getMethod(dsa.getOperation().getName(),
					parametersType);
		} catch (SecurityException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve a method from its name and its parameters' types array";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (NoSuchMethodException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to retrieve a method from its name and its parameters' types array";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		}

		try {
			return DataConverter.convertToFeedbackData(method.invoke(target,
					(Object[]) null));
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute an Emf method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			Activator.error("Nested Exception", e.getCause());
			return null;
		}
	}

	@Override
	public FeedbackData execute(DomainSpecificEvent dse) {
		return this.execute(dse.getAction());
	}

	@Override
	public void setModel(Resource modelResource) {
		this.modelResource = modelResource;
	}

	@Override
	public Collection<BytecodeSentinel> getSentinels() {
		Collection<BytecodeSentinel> res = new ArrayList<BytecodeSentinel>();
		res.add(this.sentinel);
		return res;
	}

	@Override
	public void addSentinel(BytecodeSentinel sentinel) {
		;
	}

}
