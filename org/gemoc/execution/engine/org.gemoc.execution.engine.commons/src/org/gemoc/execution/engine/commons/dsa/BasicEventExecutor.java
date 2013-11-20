package org.gemoc.execution.engine.commons.dsa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * A generic EventExecutor...
 * 
 * @author flatombe
 * 
 */
public abstract class BasicEventExecutor implements EventExecutor {
	protected CodeExecutor codeExecutor = null;

	@Override
	public FeedbackData execute(ModelSpecificAction msa) {
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.addAll(msa.getParameters());
			Object res = this.codeExecutor.invoke(msa.getTarget(), msa
					.getOperation().getName(), parameters);
			return DataConverter.convertToFeedbackData(res, msa);
		} catch (NoSuchMethodException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a ModelSpecificAction";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (IllegalAccessException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a ModelSpecificAction";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (IllegalArgumentException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a ModelSpecificAction";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.error(errorMessage, e);
		} catch (InvocationTargetException e) {
			String errorMessage = e.getClass().getSimpleName()
					+ " when trying to execute a ModelSpecificAction";
			Activator.getMessagingSystem().error(errorMessage,
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().error(
					"Inner exception has been sent to the Error Log view.",
					Activator.PLUGIN_ID);
			Activator.error(e.getCause().getMessage(), e.getCause());
		}
		return null;
	}

	/**
	 * TODO : what happens when a DSE is linked to several DSAs ?
	 * 
	 * A list of Actions is executed sequentially.
	 * 
	 * @param actions
	 * @return
	 */
	protected List<FeedbackData> execute(List<ModelSpecificAction> actions) {
		List<FeedbackData> res = new ArrayList<FeedbackData>();
		for (ModelSpecificAction action : actions) {
			res.add(this.execute(action));
		}
		return res;
	}

	@Override
	public List<FeedbackData> execute(ModelSpecificEvent mse) {
		return this.execute(mse.getActions());
	}

}
