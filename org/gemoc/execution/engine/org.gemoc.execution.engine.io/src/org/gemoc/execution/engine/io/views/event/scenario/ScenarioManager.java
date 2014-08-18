package org.gemoc.execution.engine.io.views.event.scenario;

import org.gemoc.execution.engine.io.views.event.EventManagerView.CacheStatus;
import org.gemoc.execution.engine.io.views.event.WrapperCache;

public class ScenarioManager 
{
	/**
	 * Link with the corresponding engine wrappers cache for recording and playing
	 * operations.
	 */
	private WrapperCache cache;
	private ScenarioRecorder _recorder;
	private ScenarioPlayer _player;
	/**
	 * <h2>Cache state</h2>
	 * <p> Each engine possess a scenario cache and a wrapper cache. The scenario
	 * cache commands the behavior of the event manager view.
	 */
	private CacheStatus _state;
	/**
	 * <h2>Progression of replay</h2>
	 * <p> Increased with each new replayed step until it
	 * reaches the last step. Then its reset for a new replay
	 * of another fragment.
	 */
	private int _progressPlay;
	/**
	 * Match the engine current step.
	 * <p> Make us able to detect when there is a transition between 2 steps.
	 */
	private int cacheStep;
	
	
	public ScenarioManager()
	{
		cacheStep = 0;
		_recorder = new ScenarioRecorder(this);
		_player = new ScenarioPlayer(this);
		/* When created, it means a running engine had been selected so the corresponding 
		 * state is the idle state.														*/
		_state = CacheStatus.WAITING;
		resetProgress();
	}
	
	/**
	 * The scenario recorder is called and prepare the record. 
	 * <p>Record mode is set.
	 */
	public void startRecord()
	{
		/* The state is set to recording mode.											*/
		_state = CacheStatus.RECORDING;
		/* The scenario recorder begin the preparation for recording future steps.		*/
		_recorder.startRecord();
	}
	
	public void record()
	{
		_recorder.record();
	}
	
	/**
	 * The cache state is reset to idle mode.
	 */
	public void stopRecord()
	{
		/* Recording mode is terminated,the state is set to idle mode.					*/
		_state = CacheStatus.WAITING;
	}
	
	
	/**
	 * The scenario Player is called and set his scenario.
	 * <p> The state is set on playing mode.
	 * @param path The path to the scenario to be set
	 */
	public void load(final String path)
	{
		_state = CacheStatus.PLAYING;
		_player.load(path);
	}
	
	public void play()
	{
		_player.play();
	}
	
	/**
	 * The state is reset to idle mode and scenario player is reset. 
	 */
	public void stop()
	{
		_state = CacheStatus.WAITING;
		_player.stop();
	}

	public void setCache(WrapperCache currentEngineCache) 
	{
		this.cache = currentEngineCache;
	}
	
	public WrapperCache getWrapperCache()
	{
		return cache;
	}
	
	/**
	 * @return The current state of the cache (scenario manager).
	 */
	public CacheStatus getState()
	{
		return _state;
	}
	
	public int getProgress()
	{
		return _progressPlay;
	}
	
	public void incProgress()
	{
		_progressPlay++;
	}
	
	public void resetProgress()
	{
		_progressPlay = 0;
	}
	
	public void setcacheStep(int step)
	{
		cacheStep = step;
	}
	public int getCacheStep()
	{
		return cacheStep;
	}
}
