package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMVisitorAspect;

@Aspect(className = TimeFSM.class)
@SuppressWarnings("all")
public class TimeFSMAspect {
  @Step
  public static void init(final TimeFSM _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectContext
			.getSelf(_self);
	_privk3_init(_self_, _self);
	;
}
  
  public static State currentState(final TimeFSM _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_currentState(_self_, _self);
	;
	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State) result;
}
  
  public static void currentState(final TimeFSM _self, final State currentState) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectContext
			.getSelf(_self);
	_privk3_currentState(_self_, _self, currentState);
	;
}
  
  protected static void _privk3_init(final TimeFSMAspectTimeFSMAspectProperties _self_, final TimeFSM _self) {
    State _initialState = _self.getInitialState();
    TimeFSMAspect.currentState(_self, _initialState);
    FSMClock _localClock = _self.getLocalClock();
    FSMClockAspect.numberOfTicks(_localClock, Integer.valueOf(0));
    EList<FSMEvent> _localEvents = _self.getLocalEvents();
    final Consumer<FSMEvent> _function = (FSMEvent e) -> {
      FSMEventAspect.isTriggered(e, false);
    };
    _localEvents.forEach(_function);
    TimeFSMVisitorAspect.stepNumber(_self, 0);
    TimeFSMVisitorAspect.lastStateChangeStepNumber(_self, 0);
    Class<? extends TimeFSM> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".Init()]Initialized ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    InputOutput.<String>println(_plus_4);
  }
  
  protected static State _privk3_currentState(final TimeFSMAspectTimeFSMAspectProperties _self_, final TimeFSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentState;
  }
  
  protected static void _privk3_currentState(final TimeFSMAspectTimeFSMAspectProperties _self_, final TimeFSM _self, final State currentState) {
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
}
