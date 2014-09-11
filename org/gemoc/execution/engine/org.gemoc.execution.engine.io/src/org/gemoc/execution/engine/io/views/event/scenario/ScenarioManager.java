package org.gemoc.execution.engine.io.views.event.scenario;

import org.gemoc.execution.engine.io.views.event.EngineCache;
import org.gemoc.execution.engine.io.views.event.EventManagerView.CacheStatus;

public class ScenarioManager 
{
	private ScenarioRecorder _recorder;
	private ScenarioPlayer _player;
	/**
	 * <h2>Cache state</h2>
	 * <p> Each engine possess a scenario cache and a wrapper cache. The scenario
	 * cache commands the behavior of the event manager view.
	 */
	/**
	 * <h2>Progression of replay</h2>
	 * <p> Increased with each new replayed step until it
	 * reaches the last step. Then its reset for a new replay
	 * of another fragment.
	 */
	private int _progressPlay;
	/**
	 * Link with the corresponding engine cache for recording and playing
	 * operations.
	 */
	private EngineCache _cache;

	
	//TODO:
	public ScenarioManager(EngineCache enginecache)
	{
		_cache = enginecache;
		_recorder = new ScenarioRecorder(this);
		_player = new ScenarioPlayer(this);
		resetProgress();
	}
	
	/**
	 * The scenario recorder is called and prepare the record. 
	 * <p>Record mode is set.
	 */
	public void startRecord()
	{
		/* The state is set to recording mode.											*/
		_cache.setState(CacheStatus.RECORDING);
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
		_cache.setState(CacheStatus.RUNNING);
	}
	
	
	/**
	 * The scenario Player is called and set his scenario.
	 * <p> The state is set on playing mode.
	 * @param path The path to the scenario to be set
	 */
	public void load(final String path)
	{
		_cache.setState(CacheStatus.PLAYING);
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
		_cache.setState(CacheStatus.RUNNING);
		_player.stop();
	}

	
	public EngineCache getCache()
	{
		return _cache;
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
}
