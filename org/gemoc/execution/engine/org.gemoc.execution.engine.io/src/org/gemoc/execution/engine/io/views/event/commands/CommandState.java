package org.gemoc.execution.engine.io.views.event.commands;



import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class CommandState extends AbstractSourceProvider {
  public final static String PLAY_STATE = "org.gemoc.execution.engine.io.views.event.commands.PLAY";
  public final static String RECORD_STATE = "org.gemoc.execution.engine.io.views.event.commands.RECORD";
  public final static String ENABLE = "ENABLE";
  public final static String DISABLE = "DISABLE";
  private boolean _playFlag = false;
  private boolean _recordFlag = false;


  @Override
  public void dispose() {
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] { PLAY_STATE,  RECORD_STATE};
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
  

} 