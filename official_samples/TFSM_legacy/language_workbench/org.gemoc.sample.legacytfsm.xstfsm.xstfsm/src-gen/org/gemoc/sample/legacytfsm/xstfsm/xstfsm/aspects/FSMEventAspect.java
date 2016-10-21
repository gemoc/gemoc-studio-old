package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectProperties;

@Aspect(className = FSMEvent.class)
@SuppressWarnings("all")
public class FSMEventAspect {
  @Step
  public static void trigger(final FSMEvent _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectContext
			.getSelf(_self);
	_privk3_trigger(_self_, _self);
	;
}
  
  @Step
  public static void unTrigger(final FSMEvent _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectContext
			.getSelf(_self);
	_privk3_unTrigger(_self_, _self);
	;
}
  
  public static boolean isTriggered(final FSMEvent _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_isTriggered(_self_, _self);
	;
	return (boolean) result;
}
  
  public static void isTriggered(final FSMEvent _self, final boolean isTriggered) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspectFSMEventAspectContext
			.getSelf(_self);
	_privk3_isTriggered(_self_, _self, isTriggered);
	;
}
  
  protected static void _privk3_trigger(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    FSMEventAspect.isTriggered(_self, true);
  }
  
  protected static void _privk3_unTrigger(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    FSMEventAspect.isTriggered(_self, false);
  }
  
  protected static boolean _privk3_isTriggered(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getIsTriggered") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (boolean) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.isTriggered;
  }
  
  protected static void _privk3_isTriggered(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self, final boolean isTriggered) {
    _self_.isTriggered = isTriggered; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setIsTriggered")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, isTriggered);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
