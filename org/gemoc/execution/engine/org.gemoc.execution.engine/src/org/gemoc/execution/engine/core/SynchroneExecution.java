package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.FeedbackFactory;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class SynchroneExecution extends OperationExecution 
{

	protected SynchroneExecution(ModelSpecificEvent mse, GemocExecutionEngine engine) 
	{
		super(mse, engine);
	}

	@Override
	public void run() 
	{
		Object res = callExecutor();
		setResult(res);
	}

	/**
	 * Calls the {@link EventExecutor} for the given
	 * {@link EngineEventOccurence}.
	 * 
	 * @param mse
	 *            the {@link EngineEventOccurence} to execute
	 * @return the {@link FeedbackData} if any, <code>null</code> other wise
	 */
	private Object callExecutor() 
	{
		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(getExecutionContext().getResourceModel().getResourceSet());
		Object res = null;
		final ActionCall call = FeedbackFactory.eINSTANCE.createActionCall();
		call.setTriggeringEvent(getMSE());
		if (editingDomain != null) {
			final RecordingCommand command = new RecordingCommand(editingDomain, "execute engine event occurence " + getMSE()) {
				private List<Object> result = new ArrayList<Object>();

				@Override
				protected void doExecute() {
					try {
						result.add(getExecutionContext().getEventExecutor().execute(call));
					} catch (EventExecutionException e) {
						Activator.getDefault().error("Exception received " + e.getMessage(), e);
					}
				}

				@Override
				public Collection<?> getResult() {
					return result;
				}
			};
			editingDomain.getCommandStack().execute(command);
			res = (Object) command.getResult().iterator().next();
		} else {
			try {
				res = getExecutionContext().getEventExecutor().execute(call);
			} catch (EventExecutionException e) { 
				Activator.getDefault().error("Exception received " + e.getMessage(), e);
			}
		}
		return res;
	}
	
}
