package org.gemoc.execution.engine.commons.dsa;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;

/**
 * A generic EventExecutor...
 * 
 * @author flatombe
 * 
 */
public abstract class BasicEventExecutor implements EventExecutor {
	protected CodeExecutor codeExecutor = null;
	protected Object feedbackPolicy = null;

	@Override
	public Object execute(ActionCall call)
			throws EventExecutionException {
		Object res = null;
		try {
			List<Object> parameters = new ArrayList<Object>();
			parameters.addAll(call.getParameters());
			res = codeExecutor.invoke(
									call.getTriggeringEvent().getCaller(), 
									call.getTriggeringEvent().getAction().getName(), 
									parameters);

		} catch (NoSuchMethodException e) {
			throw new EventExecutionException(e);
		} catch (IllegalAccessException e) {
			throw new EventExecutionException(e);
		} catch (IllegalArgumentException e) {
			throw new EventExecutionException(e);
		} catch (InvocationTargetException e) {
			throw new EventExecutionException(e);
		}
		return res;
	}


}
