package org.gemoc.execution.engine.commons.dsa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;
import org.gemoc.gemoc_language_workbench.api.exceptions.InvokationResultConvertionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;

/**
 * A generic EventExecutor...
 * 
 * @author flatombe
 * 
 */
public abstract class BasicEventExecutor implements EventExecutor {
	protected CodeExecutor codeExecutor = null;
	protected FeedbackPolicy feedbackPolicy = null;

	@Override
	public FeedbackData execute(ModelSpecificAction msa)
			throws EventExecutionException, InvokationResultConvertionException {
		Object res;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.addAll(msa.getParameters());
			res = this.codeExecutor.invoke(msa.getTarget(), msa.getOperation()
					.getName(), parameters);

		} catch (NoSuchMethodException e) {
			throw new EventExecutionException(e);
		} catch (IllegalAccessException e) {
			throw new EventExecutionException(e);
		} catch (IllegalArgumentException e) {
			throw new EventExecutionException(e);
		} catch (InvocationTargetException e) {
			throw new EventExecutionException(e);
		}

		try {
			return this.feedbackPolicy.convertToFeedbackDataImplementation(res,
					msa);
		} catch (SecurityException e) {
			throw new InvokationResultConvertionException(e);
		} catch (InstantiationException e) {
			throw new InvokationResultConvertionException(e);
		} catch (IllegalArgumentException e) {
			throw new InvokationResultConvertionException(e);
		} catch (IllegalAccessException e) {
			throw new InvokationResultConvertionException(e);
		} catch (InvocationTargetException e) {
			throw new InvokationResultConvertionException(e);
		} catch (NoSuchMethodException e) {
			throw new InvokationResultConvertionException(e);
		}

	}

	/**
	 * TODO : what happens when a DSE is linked to several DSAs ?
	 * 
	 * A list of Actions is executed sequentially.
	 * 
	 * @param actions
	 * @return
	 */
	protected List<FeedbackData> execute(List<ModelSpecificAction> actions)
			throws EventExecutionException, InvokationResultConvertionException {
		List<FeedbackData> res = new ArrayList<FeedbackData>();
		for (ModelSpecificAction action : actions) {
			res.add(this.execute(action));
		}
		return res;
	}

	@Override
	public List<FeedbackData> execute(ModelSpecificEvent mse)
			throws EventExecutionException, InvokationResultConvertionException {
		return this.execute(mse.getActions());
	}

}
