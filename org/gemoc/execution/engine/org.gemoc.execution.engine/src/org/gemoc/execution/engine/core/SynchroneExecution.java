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
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

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
		FeedbackData res = callExecutor();
		setResult(res);
		if (res != null) 
		{
			getExecutionContext().getFeedbackPolicy().processFeedback(res, getEngine());
		}
	}

	/**
	 * Calls the {@link EventExecutor} for the given
	 * {@link EngineEventOccurence}.
	 * 
	 * @param mse
	 *            the {@link EngineEventOccurence} to execute
	 * @return the {@link FeedbackData} if any, <code>null</code> other wise
	 */
	private FeedbackData callExecutor() 
	{
		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(getExecutionContext().getResourceModel().getResourceSet());
		FeedbackData res = null;
		final ActionCall call = FeedbackFactory.eINSTANCE.createActionCall();
		call.setTriggeringEvent(getMSE());
		if (editingDomain != null) {
			final RecordingCommand command = new RecordingCommand(editingDomain, "execute engine event occurence " + getMSE()) {
				private List<FeedbackData> result = new ArrayList<FeedbackData>();

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
			res = (FeedbackData) command.getResult().iterator().next();
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
