package org.gemoc.execution.engine.io.views.event.scenario;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.io.views.event.EventWrappersCache;

public class ScenarioManager 
{
	private EventWrappersCache cache;
	private List<ScenarioTool> _recorderList;
	private List<ScenarioTool> _playerList;
	private ScenarioRecorder currentRecorder;
	private ScenarioPlayer currentPlayer;
	
	public ScenarioManager()
	{
		_recorderList = new ArrayList<ScenarioTool>();
		_playerList = new ArrayList<ScenarioTool>();
	}
	
	public void startRecord()
	{
		currentRecorder = new ScenarioRecorder(this);
		_recorderList.add(currentRecorder);
		currentRecorder.startRecord();
	}
	
	public void record()
	{
		currentRecorder.record();
	}
	
	public void stopRecord()
	{
		currentRecorder.stopRecord();
		currentRecorder = null;
		return;
	}
	
	public void load(final String path)
	{
		currentPlayer = new ScenarioPlayer(this);
		_playerList.add(currentPlayer);
		currentPlayer.load(path);
	}
	
	public void play()
	{
		currentPlayer.play();
	}
	
	public void stop()
	{
		currentPlayer.stop();
	}

	public void setCache(EventWrappersCache currentEngineCache) 
	{
		this.cache = currentEngineCache;
	}
	
	public EventWrappersCache getWrapperCache()
	{
		return cache;
	}
}
