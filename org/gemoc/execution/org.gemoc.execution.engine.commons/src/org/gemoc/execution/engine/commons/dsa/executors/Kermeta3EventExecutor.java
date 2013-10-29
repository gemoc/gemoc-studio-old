package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.BasicEventExecutor;
import org.gemoc.execution.engine.commons.dsa.DataConverter;
import org.gemoc.execution.engine.commons.dsa.sentinels.Kermeta3BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodNotFoundException;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class Kermeta3EventExecutor extends BasicEventExecutor {

	private BytecodeSentinel sentinel = null;

	public Kermeta3EventExecutor(ClassLoader classLoader,
			String bundleSymbolicName) {
		this.sentinel = new Kermeta3BytecodeSentinel(classLoader,
				bundleSymbolicName);
	}

	@Override
	public FeedbackData execute(ModelSpecificAction msa) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add((Object) msa.getTarget());
		parameters.addAll(msa.getParameters());

		Object[] params = parameters.toArray();
		Method method = null;
		try {
			method = this.sentinel.getMethodFromAction(msa);
		} catch (MethodNotFoundException e) {
			Activator.getMessagingSystem().warn(
					this.getClass().getName()
							+ " could not find method of the action "
							+ msa.toString(), Activator.PLUGIN_ID);
		}
		try {
			return DataConverter.convertToFeedbackData(
					method.invoke(null, params), msa);
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Kermeta3 method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Kermeta3 method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			return null;
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a Kermeta3 method";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
			Activator.error("Nested Exception", e.getCause());
			return null;
		}
	}

	@Override
	public List<FeedbackData> execute(ModelSpecificEvent dse) {
		return this.execute(dse.getActions());
	}

}
