package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;

@SuppressWarnings("all")
public class StateMachineAspectStateMachineAspectProperties {
  public State currentState;
  
  public EList<String> actionsToProcess;
  
  public String producedString;
  
  public int processedTokens;
}
