package org.gemoc.execution.engine.io.views.event;



import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class RecordState extends AbstractSourceProvider {
  public final static String RECORD_STATE = "STATE.RECORD";
  public final static String ENABLE = "ENABLE";
  public final static String DISABLE = "DISABLE";
  private boolean _enable = false;


  @Override
  public void dispose() {
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] { RECORD_STATE };
  }

  @Override
  public Map<String, String> getCurrentState() {
    Map<String, String> map = new HashMap<String, String>(1);
    String value = _enable ? ENABLE : DISABLE;
    map.put(RECORD_STATE, value);
    return map;
  }

  
  public void toogleEnabled() {
    _enable = !_enable ;
    String value = _enable ? ENABLE : DISABLE;
    fireSourceChanged(ISources.ACTIVE_SHELL, RECORD_STATE, value);
  }

} 