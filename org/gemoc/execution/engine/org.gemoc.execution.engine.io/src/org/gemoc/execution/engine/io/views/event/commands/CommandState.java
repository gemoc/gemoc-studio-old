package org.gemoc.execution.engine.io.views.event.commands;



import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class CommandState extends AbstractSourceProvider {
	public final static String ID = "org.gemoc.execution.engine.io.views.event.commands.CommandState";
	public final static String PLAY_STATE = "org.gemoc.execution.engine.io.views.event.commands.PLAY";
	public final static String RECORD_STATE = "org.gemoc.execution.engine.io.views.event.commands.RECORD";
	public final static String INIT_STATE = "org.gemoc.execution.engine.io.views.event.commands.INIT";
	public final static String ENABLE = "ENABLE";
	public final static String DISABLE = "DISABLE";
	private boolean _playFlag = false;
	private boolean _recordFlag = false;


	@Override
	public void dispose() {
	}

	@Override
	public String[] getProvidedSourceNames() {
		return new String[] { ID, PLAY_STATE,  RECORD_STATE, INIT_STATE};
	}

	@Override
	public Map<String, String> getCurrentState() {
		Map<String, String> map = new HashMap<String, String>(2);
		String value = _playFlag ? ENABLE : DISABLE;
		map.put(PLAY_STATE, value);
		value = _recordFlag ? ENABLE : DISABLE;
		map.put(RECORD_STATE, value);
		return map;
	}


	public void togglePlayEnabled() {
		_playFlag = !_playFlag ;
		String value = _playFlag ? ENABLE : DISABLE;
		fireSourceChanged(ISources.ACTIVE_SHELL, PLAY_STATE, value);
	}

	public void toggleRecordEnabled() {
		_recordFlag = !_recordFlag ;
		String value = _recordFlag ? ENABLE : DISABLE;
		fireSourceChanged(ISources.ACTIVE_SHELL, RECORD_STATE, value);
	}
	
	public void setInit() {
		fireSourceChanged(ISources.ACTIVE_SHELL, INIT_STATE, "SET");
	}
	
	public void resetInit() {
		fireSourceChanged(ISources.ACTIVE_SHELL, INIT_STATE, "RESET");
	}

	public void setPlayEnabled(){
		_playFlag = true;
		fireSourceChanged(ISources.ACTIVE_SHELL, PLAY_STATE, "ENABLE");
	}
	
	public void setRecordEnabled(){
		_recordFlag = true;
		fireSourceChanged(ISources.ACTIVE_SHELL, RECORD_STATE, "ENABLE");
	}
	
	public void setPlayDisabled(){
		_playFlag = false;
		fireSourceChanged(ISources.ACTIVE_SHELL, PLAY_STATE, "DISABLE");
	}
	
	public void setRecordDisabled(){
		_playFlag = false;
		fireSourceChanged(ISources.ACTIVE_SHELL, RECORD_STATE, "DISABLE");
	}

} 