package org.gemoc.execution.engine.core;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public class PlainK3ExecutionEngine extends AbstractExecutionEngine implements IMSEOccurrenceListener {

	private Runnable _runnable;

	public PlainK3ExecutionEngine(final IExecutionContext context, final Object caller, final Method method, final ArrayList<Object> parameters) {
		super(context);
		MSEManager.getInstance().reset();
		_runnable = new Runnable() {
			@Override
			public void run() {
				try {
					MSEManager.getInstance().addListener(PlainK3ExecutionEngine.this);
					method.invoke(caller, parameters.get(0));
				} catch (Exception e) {
					throw new RuntimeException(e);
				} finally {
					MSEManager.getInstance().removeListener(PlainK3ExecutionEngine.this);
				}
			}
		};
	}

	@Override
	public void addFutureAction(IFutureAction action) {
	}

	@Override
	protected void executeSelectedLogicalStep() {
		if (_isStopped) {
			throw new RuntimeException(getName() + " is stopped");
		}
		// notifyAboutToExecuteLogicalStep();
		// notifyLogicalStepExecuted();
	}

	@Override
	protected Runnable getRunnable() {
		return _runnable;
	}

	@Override
	public void mseOccurenceRaised(MSEOccurrence occurrence) {
		if (_isStopped) {
			throw new RuntimeException("Execution stopped");
		}
		// before coming here, it is absolutely necessary to have visited the
		// solver first.
		try {
			performExecutionStep();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void mseOccurenceAboutToBeRaised(MSEOccurrence occurrence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mseOccurenceEnded(MSEOccurrence occurrence) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			addon.mseOccurrenceExecuted(this, occurrence);
		}
	}

}
