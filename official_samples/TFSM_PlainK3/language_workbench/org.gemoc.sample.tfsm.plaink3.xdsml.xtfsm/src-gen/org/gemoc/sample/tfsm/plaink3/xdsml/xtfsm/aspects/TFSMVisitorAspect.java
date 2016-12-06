package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.StateVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;

@Aspect(className = TFSM.class)
@SuppressWarnings("all")
public class TFSMVisitorAspect {
  public static void visit(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    _privk3_visit(_self_, _self);;
  }
  
  private static String getCurrentStateName(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_getCurrentStateName(_self_, _self);;
    return (java.lang.String)result;
  }
  
  public static int stepNumber(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_stepNumber(_self_, _self);;
    return (int)result;
  }
  
  public static void stepNumber(final TFSM _self, final int stepNumber) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    _privk3_stepNumber(_self_, _self,stepNumber);;
  }
  
  public static int lastStateChangeStepNumber(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_lastStateChangeStepNumber(_self_, _self);;
    return (int)result;
  }
  
  public static void lastStateChangeStepNumber(final TFSM _self, final int lastStateChangeStepNumber) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspectTFSMAspectContext.getSelf(_self);
    _privk3_lastStateChangeStepNumber(_self_, _self,lastStateChangeStepNumber);;
  }
  
  protected static void _privk3_visit(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self) {
    InputOutput.println();
    int _stepNumber = TFSMVisitorAspect.stepNumber(_self);
    String _plus = ("Step " + Integer.valueOf(_stepNumber));
    String _plus_1 = (_plus + " - current state: ");
    String _currentStateName = TFSMVisitorAspect.getCurrentStateName(_self);
    String _plus_2 = (_plus_1 + _currentStateName);
    InputOutput.<String>println(_plus_2);
    FSMClock _localClock = _self.getLocalClock();
    boolean _notEquals = (!Objects.equal(_localClock, null));
    if (_notEquals) {
      FSMClock _localClock_1 = _self.getLocalClock();
      FSMClockVisitorAspect.visit(_localClock_1);
    }
    State _currentState = TFSMAspect.currentState(_self);
    StateVisitorAspect.visit(_currentState);
    int _stepNumber_1 = TFSMVisitorAspect.stepNumber(_self);
    int _plus_3 = (_stepNumber_1 + 1);
    TFSMVisitorAspect.stepNumber(_self, _plus_3);
  }
  
  protected static String _privk3_getCurrentStateName(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self) {
    String s = "null";
    State _currentState = TFSMAspect.currentState(_self);
    boolean _notEquals = (!Objects.equal(_currentState, null));
    if (_notEquals) {
      State _currentState_1 = TFSMAspect.currentState(_self);
      String _name = _currentState_1.getName();
      s = _name;
    }
    return s;
  }
  
  protected static int _privk3_stepNumber(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self) {
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
  
  protected static void _privk3_stepNumber(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self, final int stepNumber) {
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
  
  protected static int _privk3_lastStateChangeStepNumber(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self) {
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
  
  protected static void _privk3_lastStateChangeStepNumber(final TFSMVisitorAspectTFSMAspectProperties _self_, final TFSM _self, final int lastStateChangeStepNumber) {
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
