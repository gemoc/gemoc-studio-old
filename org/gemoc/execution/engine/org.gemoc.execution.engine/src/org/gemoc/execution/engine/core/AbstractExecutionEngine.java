package org.gemoc.execution.engine.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public abstract class AbstractExecutionEngine implements IExecutionEngine, IDisposable {

	private RunStatus _runningStatus = RunStatus.Initializing;

	protected EngineStatus engineStatus = new EngineStatus();

	protected IExecutionContext _executionContext;
	
	public AbstractExecutionEngine(IExecutionContext executionContext) {
		super();
		if (executionContext == null)
			throw new IllegalArgumentException("executionContext");
		_executionContext = executionContext;
		setEngineStatus(EngineStatus.RunStatus.Initializing);
	}

	@Override
	public IExecutionContext getExecutionContext() 
	{
		return _executionContext;
	}

	public EngineStatus getEngineStatus() {
		return engineStatus;
	}

	@Override
	public void dispose() 
	{
		try
		{
			getExecutionContext().dispose();
		}
		finally
		{
			Activator.getDefault().gemocRunningEngineRegistry.unregisterEngine(getName());
		}
	}
	
	protected String getName()
	{
		return "Gemoc engine " + _executionContext.getRunConfiguration().getExecutedModelURI();		
	}

	protected void notifyEngineAboutToStart()
	{
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons())
		{
			addon.engineAboutToStart(this);
		}		
	}
	
	protected void notifyEngineStarted() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons())
		{
			addon.engineStarted(this);
		}
	}

	protected void notifyAboutToStop() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons())
		{
			addon.engineAboutToStop(this);
		}
	}

	protected void notifyEngineStopped() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.engineStopped(this);
		}
	}

	protected void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.aboutToSelectLogicalStep(this, getPossibleLogicalSteps());
		}
	}

	protected void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.logicalStepSelected(this, getSelectedLogicalStep());
		}
	}

	protected void notifyEngineStatusChanged(RunStatus newStatus) {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons())
		{
			addon.engineStatusChanged(this, newStatus);
		}
	}

	protected void notifyAboutToExecuteLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.aboutToExecuteLogicalStep(this, getSelectedLogicalStep());
		}
	}

	protected void notifyLogicalStepExecuted() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.logicalStepExecuted(this, getSelectedLogicalStep());
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
				result.add((T)c);
		}
		return result;
	}
	
	protected void setEngineStatus(RunStatus newStatus) {
		_runningStatus = newStatus;
		notifyEngineStatusChanged(newStatus);
	}

	private LogicalStep selectAndExecuteLogicalStep() throws InterruptedException 
	{
		LogicalStep selectedLogicalStep;
		setEngineStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
		notifyAboutToSelectLogicalStep();
		selectedLogicalStep = getExecutionContext().getLogicalStepDecider().decide(this, getPossibleLogicalSteps());
		if (selectedLogicalStep != null)
		{
			setSelectedLogicalStep(selectedLogicalStep);
			setEngineStatus(EngineStatus.RunStatus.Running);
			notifyLogicalStepSelected();
			// run all the event occurrences of this logical
			// step
			notifyAboutToExecuteLogicalStep();
			executeSelectedLogicalStep();
			notifyLogicalStepExecuted();
		}
		return selectedLogicalStep;
	}

	abstract protected void executeSelectedLogicalStep();
	
	protected LogicalStep _selectedLogicalStep;

	@Override
	public LogicalStep getSelectedLogicalStep() 
	{
		synchronized (this) {
			return _selectedLogicalStep;
		}
	}
	
	protected void setSelectedLogicalStep(LogicalStep ls)
	{
		synchronized (this) {
			_selectedLogicalStep = ls;
		}
	}
	
	protected List<LogicalStep> _possibleLogicalSteps = new ArrayList<>();

	@Override
	public List<LogicalStep> getPossibleLogicalSteps() 
	{
		synchronized (this)
		{
			return new ArrayList<LogicalStep>(_possibleLogicalSteps);
		}
	}

	public RunStatus getRunningStatus() {
		return _runningStatus;
	}
	
	abstract protected Runnable getRunnable();

	@Override
	public void start() 
	{
		if (!_started)
		{
			_started = true;
			Runnable r = new Runnable() {
				
				@Override
				public void run() 
				{
					try
					{
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
					}
					finally
					{
						notifyAboutToStop();
						stop();
						notifyEngineStopped();
					}
				}
			};
			Thread t = new Thread(r, "Gemoc engine " + _executionContext.getRunConfiguration().getExecutedModelURI());
			t.start();
		}
	}
	
	@Override
	public void stop() 
	{
		if (!_isStopped)
		{
			_isStopped = true;
			setEngineStatus(EngineStatus.RunStatus.Stopped);
			notifyEngineStopped();
			setSelectedLogicalStep(null);
			if (getExecutionContext().getLogicalStepDecider() != null)
			{
				getExecutionContext().getLogicalStepDecider().preempt();
			}
		}
	}
	
	private boolean _started = false;
	protected boolean _isStopped = false;
	
	protected void performExecutionStep() throws InterruptedException {
		switchDeciderIfNecessary();
						
		computePossibleLogicalSteps();
		updatePossibleLogicalSteps();
		// 2- select one solution from available logical step /
		// select interactive vs batch
		if (_possibleLogicalSteps.size() == 0) {
			Activator.getDefault().debug("No more LogicalStep to run");
			stop();
		} else {
			//Activator.getDefault().debug("\t\t ---------------- LogicalStep " + count);
			LogicalStep selectedLogicalStep = selectAndExecuteLogicalStep();						
			// 3 - run the selected logical step
			// inform the solver that we will run this step
			if (selectedLogicalStep != null)
			{
				getSolver().applyLogicalStep(selectedLogicalStep);
			}
		}
		engineStatus.incrementNbLogicalStepRun();
	}
	
	private ILogicalStepDecider _logicalStepDecider;

	private void switchDeciderIfNecessary()
	{
		if (_executionContext.getLogicalStepDecider() != null
			&& _executionContext.getLogicalStepDecider() != _logicalStepDecider)
		{
			_logicalStepDecider = _executionContext.getLogicalStepDecider();
		}
	}

	private void computePossibleLogicalSteps() 
	{
		_possibleLogicalSteps = getSolver().computeAndGetPossibleLogicalSteps();
	}

	private void updatePossibleLogicalSteps()
	{
		for(IMSEStateController c : getExecutionContext().getExecutionPlatform().getMSEStateControllers())
		{
			c.applyMSEFutureStates(getSolver());
		}
		synchronized(this)
		{
			_possibleLogicalSteps = getSolver().updatePossibleLogicalSteps();
		}
	}
	
	public void recomputePossibleLogicalSteps()
	{
		getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			addon.proposedLogicalStepsChanged(this, getPossibleLogicalSteps());
		}
	}

	private ISolver getSolver()
	{
		return _executionContext.getExecutionPlatform().getSolver();
	}
	
	private ICodeExecutor getCodeExecutor()
	{
		return _executionContext.getExecutionPlatform().getCodeExecutor();		
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver() + " ; ModelResource=" + _executionContext.getResourceModel()+ "]";
	}


}