package org.gemoc.execution.engine.commons.dsa.executors;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.commons.dsa.BasicEventExecutor;
import org.gemoc.execution.engine.commons.dsa.DataConverter;
import org.gemoc.execution.engine.commons.dsa.sentinels.JavaBytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.BytecodeSentinel;
import org.gemoc.gemoc_language_workbench.api.dsa.MethodNotFoundException;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

public class JavaEventExecutor extends BasicEventExecutor {

	private BytecodeSentinel sentinel = null;
	
	public void initialize(){
		
	}

	public JavaEventExecutor() {
		this.sentinel = new JavaBytecodeSentinel();
	}

	@Override
	public FeedbackData execute(ModelSpecificAction msa) {
		Object target = (Object) msa.getTarget();
		Object[] params = (new ArrayList<Object>(msa.getParameters()))
				.toArray();
		Method method = null;
		try {
			method = sentinel.getMethodFromAction(msa);
		} catch (MethodNotFoundException e) {
			Activator.getMessagingSystem().warn(
					this.getClass().getName()
							+ " could not find method of the action "
							+ msa.toString(), Activator.PLUGIN_ID);
		}

		try {
			return DataConverter.convertToFeedbackData(
					method.invoke(target, params), msa);
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
	public List<FeedbackData> execute(ModelSpecificEvent mse) {
		return this.execute(mse.getActions());
	}

}
