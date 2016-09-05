package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent;

@Aspect(className = FSMEvent.class)
@SuppressWarnings("all")
public class FSMEventAspect {
  @Step
  public static void trigger(final FSMEvent _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_trigger(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"FSMEvent","trigger");
    } else {
    	command.execute();
    }
    ;;
  }
  
  @Step
  public static void unTrigger(final FSMEvent _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_unTrigger(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"FSMEvent","unTrigger");
    } else {
    	command.execute();
    }
    ;;
  }
  
  public static boolean isTriggered(final FSMEvent _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_isTriggered(_self_, _self);;
    return (boolean)result;
  }
  
  public static void isTriggered(final FSMEvent _self, final boolean isTriggered) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
    _privk3_isTriggered(_self_, _self,isTriggered);;
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
