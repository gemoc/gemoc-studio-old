package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties;

@Aspect(className = TimedFSM.class)
@SuppressWarnings("all")
public class TimedFSMVisitorAspect {
  public static void visit(final TimedFSM _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
}
  
  private static String getCurrentStateName(final TimedFSM _self) {
    final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_getCurrentStateName(_self_, _self);;
    return (java.lang.String)result;
  }
  
  public static int stepNumber(final TimedFSM _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_stepNumber(_self_, _self);
	;
	return (int) result;
}
  
  public static void stepNumber(final TimedFSM _self, final int stepNumber) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext
			.getSelf(_self);
	_privk3_stepNumber(_self_, _self, stepNumber);
	;
}
  
  public static int lastStateChangeStepNumber(final TimedFSM _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_lastStateChangeStepNumber(_self_, _self);
	;
	return (int) result;
}
  
  public static void lastStateChangeStepNumber(final TimedFSM _self, final int lastStateChangeStepNumber) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectContext
			.getSelf(_self);
	_privk3_lastStateChangeStepNumber(_self_, _self, lastStateChangeStepNumber);
	;
}
  
  protected static void _privk3_visit(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self) {
    InputOutput.println();
    int _stepNumber = TimedFSMVisitorAspect.stepNumber(_self);
    String _plus = ("Step " + Integer.valueOf(_stepNumber));
    String _plus_1 = (_plus + " - current state: ");
    String _currentStateName = TimedFSMVisitorAspect.getCurrentStateName(_self);
    String _plus_2 = (_plus_1 + _currentStateName);
    InputOutput.<String>println(_plus_2);
    FSMClock _localClock = _self.getLocalClock();
    boolean _notEquals = (!Objects.equal(_localClock, null));
    if (_notEquals) {
      FSMClock _localClock_1 = _self.getLocalClock();
      FSMClockVisitorAspect.visit(_localClock_1);
    }
    State _currentState = TimedFSMAspect.currentState(_self);
    StateVisitorAspect.visit(_currentState);
    int _stepNumber_1 = TimedFSMVisitorAspect.stepNumber(_self);
    int _plus_3 = (_stepNumber_1 + 1);
    TimedFSMVisitorAspect.stepNumber(_self, _plus_3);
  }
  
  protected static String _privk3_getCurrentStateName(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self) {
    String s = "null";
    State _currentState = TimedFSMAspect.currentState(_self);
    boolean _notEquals = (!Objects.equal(_currentState, null));
    if (_notEquals) {
      State _currentState_1 = TimedFSMAspect.currentState(_self);
      String _name = _currentState_1.getName();
      s = _name;
    }
    return s;
  }
  
  protected static int _privk3_stepNumber(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getStepNumber") &&
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
    return _self_.stepNumber;
  }
  
  protected static void _privk3_stepNumber(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self, final int stepNumber) {
    _self_.stepNumber = stepNumber; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setStepNumber")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, stepNumber);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static int _privk3_lastStateChangeStepNumber(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getLastStateChangeStepNumber") &&
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
    return _self_.lastStateChangeStepNumber;
  }
  
  protected static void _privk3_lastStateChangeStepNumber(final TimedFSMVisitorAspectTimedFSMAspectProperties _self_, final TimedFSM _self, final int lastStateChangeStepNumber) {
    _self_.lastStateChangeStepNumber = lastStateChangeStepNumber; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setLastStateChangeStepNumber")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, lastStateChangeStepNumber);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
