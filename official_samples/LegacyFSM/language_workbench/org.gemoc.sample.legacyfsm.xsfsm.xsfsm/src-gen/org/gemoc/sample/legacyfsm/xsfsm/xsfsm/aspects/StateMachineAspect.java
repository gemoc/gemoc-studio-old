package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;
import fr.inria.diverse.k3.al.annotationprocessor.Main;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.StateMachine;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties;

@Aspect(className = StateMachine.class)
@SuppressWarnings("all")
public class StateMachineAspect {
  @Main
  public static void main(final StateMachine _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	_privk3_main(_self_, _self);
	;
}
  
  @InitializeModel
  public static void initializeModel(final StateMachine _self, final EList<String> args) {
    final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext.getSelf(_self);
    _privk3_initializeModel(_self_, _self,args);;
  }
  
  public static State currentState(final StateMachine _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_currentState(_self_, _self);
	;
	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) result;
}
  
  public static void currentState(final StateMachine _self, final State currentState) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	_privk3_currentState(_self_, _self, currentState);
	;
}
  
  public static EList<String> actionsToProcess(final StateMachine _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_actionsToProcess(_self_, _self);
	;
	return (org.eclipse.emf.common.util.EList) result;
}
  
  public static void actionsToProcess(final StateMachine _self, final EList<String> actionsToProcess) {
    final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext.getSelf(_self);
    _privk3_actionsToProcess(_self_, _self,actionsToProcess);;
  }
  
  public static String producedString(final StateMachine _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_producedString(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  public static void producedString(final StateMachine _self, final String producedString) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext
			.getSelf(_self);
	_privk3_producedString(_self_, _self, producedString);
	;
}
  
  private static int processedTokens(final StateMachine _self) {
    final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_processedTokens(_self_, _self);;
    return (int)result;
  }
  
  private static void processedTokens(final StateMachine _self, final int processedTokens) {
    final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateMachineAspectStateMachineAspectContext.getSelf(_self);
    _privk3_processedTokens(_self_, _self,processedTokens);;
  }
  
  protected static void _privk3_main(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self) {
    try {
      EList<String> _actionsToProcess = StateMachineAspect.actionsToProcess(_self);
      final Procedure2<String, Integer> _function = (String inputToken, Integer counter) -> {
        InputOutput.<String>println(("Reading " + inputToken));
        State _currentState = StateMachineAspect.currentState(_self);
        StateAspect.step(_currentState, inputToken);
        StateMachineAspect.processedTokens(_self, (counter).intValue());
      };
      IterableExtensions.<String>forEach(_actionsToProcess, _function);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception nt = (Exception)_t;
        String _message = nt.getMessage();
        String _plus = ("Stopped due to " + _message);
        InputOutput.<String>println(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    int _processedTokens = StateMachineAspect.processedTokens(_self);
    String _plus_1 = ("processed tokens: " + Integer.valueOf(_processedTokens));
    String _plus_2 = (_plus_1 + "/");
    EList<String> _actionsToProcess_1 = StateMachineAspect.actionsToProcess(_self);
    int _size = _actionsToProcess_1.size();
    String _plus_3 = (_plus_2 + Integer.valueOf(_size));
    InputOutput.<String>println(_plus_3);
    String _producedString = StateMachineAspect.producedString(_self);
    String _plus_4 = ("produced string: " + _producedString);
    InputOutput.<String>println(_plus_4);
  }
  
  protected static void _privk3_initializeModel(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self, final EList<String> args) {
    State _initialState = _self.getInitialState();
    StateMachineAspect.currentState(_self, _initialState);
    EList<String> _actionsToProcess = StateMachineAspect.actionsToProcess(_self);
    _actionsToProcess.addAll(args);
  }
  
  protected static State _privk3_currentState(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentState;
  }
  
  protected static void _privk3_currentState(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self, final State currentState) {
    _self_.currentState = currentState; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentState")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentState);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static EList<String> _privk3_actionsToProcess(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getActionsToProcess") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.eclipse.emf.common.util.EList) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.actionsToProcess;
  }
  
  protected static void _privk3_actionsToProcess(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self, final EList<String> actionsToProcess) {
    _self_.actionsToProcess = actionsToProcess; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setActionsToProcess")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, actionsToProcess);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static String _privk3_producedString(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getProducedString") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.lang.String) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.producedString;
  }
  
  protected static void _privk3_producedString(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self, final String producedString) {
    _self_.producedString = producedString; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setProducedString")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, producedString);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static int _privk3_processedTokens(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getProcessedTokens") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (int) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.processedTokens;
  }
  
  protected static void _privk3_processedTokens(final StateMachineAspectStateMachineAspectProperties _self_, final StateMachine _self, final int processedTokens) {
    _self_.processedTokens = processedTokens; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setProcessedTokens")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, processedTokens);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
