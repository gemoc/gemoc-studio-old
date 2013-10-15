package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.DataConverter;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class JavaExecutor implements Executor {
	private Resource modelResource;

	private Collection<BytecodeSentinel> sentinels = new ArrayList<BytecodeSentinel>();

	@Override
	public FeedbackData execute(DomainSpecificAction dsa) {
		Object target = (Object) dsa.getTarget();
		Object[] params = (new ArrayList<Object>(dsa.getParameters()))
				.toArray();
		Method method = null;
		for (BytecodeSentinel sentinel : sentinels) {
			method = sentinel.getMethodFromAction(dsa);
			if (method != null) {
				break;
			}
		}
		try {
			return DataConverter.convertToFeedbackData(method.invoke(target,
					params));
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Java method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Java method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Java method";
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
		return this.sentinels;
	}

	@Override
	public void addSentinel(BytecodeSentinel sentinel) {
		this.sentinels.add(sentinel);
	}

}
