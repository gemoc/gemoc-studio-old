package org.gemoc.execution.engine.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public abstract class AbstractExecutionEngine implements IExecutionEngine, IDisposable {

	private RunStatus _runningStatus = RunStatus.Initializing;

	protected EngineStatus engineStatus = new EngineStatus();

	protected IExecutionContext _executionContext;
	
	@Override
	public void initialize(IExecutionContext executionContext)  {
		if (executionContext == null)
			throw new IllegalArgumentException("executionContext");
		_executionContext = executionContext;
		setEngineStatus(EngineStatus.RunStatus.Initializing);
	};

	@Override
	public IExecutionContext getExecutionContext() {
		return _executionContext;
	}

	public EngineStatus getEngineStatus() {
		return engineStatus;
	}

	@Override
	public void dispose() {

		try {
			notifyEngineAboutToDispose();
			getExecutionContext().dispose();
		} finally {
			Activator.getDefault().gemocRunningEngineRegistry.unregisterEngine(getName());
		}
	}

	protected String getName() {
		return "Gemoc engine " + _executionContext.getRunConfiguration().getExecutedModelURI();
	}

	protected void notifyEngineAboutToStart() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineAboutToStart(this);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyEngineStarted() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineStarted(this);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyAboutToStop() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineAboutToStop(this);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyEngineStopped() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineStopped(this);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyEngineAboutToDispose() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineAboutToDispose(this);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyEngineStatusChanged(RunStatus newStatus) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.engineStatusChanged(this, newStatus);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyAboutToExecuteLogicalStep(LogicalStep l) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.aboutToExecuteLogicalStep(this, l);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	protected void notifyLogicalStepExecuted(LogicalStep l) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			try {
				addon.logicalStepExecuted(this, l);
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon " + addon + ", " + e.getMessage(), e);
			}
		}
	}

	public <T extends IEngineAddon> boolean hasAddon(Class<T> type) {
		for (IEngineAddon c : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			if (c.getClass().equals(type))
				return true;
		}
		return false;
	}

	@SuppressWarnings("all")
	@Override
	public <T extends IEngineAddon> T getAddon(Class<T> type) {
		for (IEngineAddon c : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			if (c.getClass().equals(type))
				return (T) c;
		}
		return null;
	}

	@SuppressWarnings("all")
	@Override
	public <T extends IEngineAddon> Set<T> getAddonsTypedBy(Class<T> type) {
		Set<T> result = new HashSet<T>();
		for (IEngineAddon c : getExecutionContext().getExecutionPlatform().getEngineAddons()) {
			if (type.isAssignableFrom(c.getClass()))
				result.add((T) c);
		}
		return result;
	}

	protected void setEngineStatus(RunStatus newStatus) {
		_runningStatus = newStatus;
		notifyEngineStatusChanged(newStatus);
	}

	public RunStatus getRunningStatus() {
		return _runningStatus;
	}

	abstract protected Runnable getRunnable();

	private Thread thread;

	public void joinThread() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			Activator.getDefault().warn("InterruptedException received", e);
		}
	}

	@Override
	public void start() {
		if (!_started) {
			_started = true;
			Runnable r = new Runnable() {

				@Override
				public void run() {
					try {
						notifyEngineAboutToStart();
						Activator.getDefault().gemocRunningEngineRegistry.registerEngine(getName(), AbstractExecutionEngine.this);
						setEngineStatus(EngineStatus.RunStatus.Running);
						notifyEngineStarted();
						getRunnable().run();
					} catch (Throwable e) {
						e.printStackTrace();
						Activator.getDefault().error("Exception received " + e.getMessage() + ", stopping engine.", e);
						StringWriter sw = new StringWriter();
						e.printStackTrace(new PrintWriter(sw));
						String exceptionAsString = sw.toString();

						Activator.getDefault().error(exceptionAsString);
					} finally {
						// make sure to notify the stop if this wasn't an
						// external call to stop() that lead us here.
						// ie. normal end of the mode execution
						stop();
						setEngineStatus(EngineStatus.RunStatus.Stopped);
						notifyEngineStopped();
					}
				}
			};
			thread = new Thread(r, engineKindName()+" " + _executionContext.getRunConfiguration().getExecutedModelURI());
			thread.start();
		}
	}

	@Override
	public void stop() {
		if (!_isStopped) {
			notifyAboutToStop(); // notification occurs only if not already
									// stopped
			_isStopped = true;

		}
	}

	private boolean _started = false;
	protected boolean _isStopped = false;

}