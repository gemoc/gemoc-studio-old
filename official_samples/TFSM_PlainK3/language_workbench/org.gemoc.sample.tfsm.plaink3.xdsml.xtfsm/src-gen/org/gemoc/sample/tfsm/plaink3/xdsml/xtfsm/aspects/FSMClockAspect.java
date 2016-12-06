package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockAspect {
  @Step
  public static Integer ticks(final FSMClock _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    Object result = null;
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		addToResult(_privk3_ticks(_self_, _self));
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"FSMClock","ticks");
    } else {
    	command.execute();
    }
    result = command.getResult();
    ;;
    return (java.lang.Integer)result;
  }
  
  public static Integer numberOfTicks(final FSMClock _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_numberOfTicks(_self_, _self);;
    return (java.lang.Integer)result;
  }
  
  public static void numberOfTicks(final FSMClock _self, final Integer numberOfTicks) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    _privk3_numberOfTicks(_self_, _self,numberOfTicks);;
  }
  
  protected static Integer _privk3_ticks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    Integer _numberOfTicks = FSMClockAspect.numberOfTicks(_self);
    int _plus = ((_numberOfTicks).intValue() + 1);
    FSMClockAspect.numberOfTicks(_self, Integer.valueOf(_plus));
    Class<? extends FSMClock> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus_1 = ("[" + _simpleName);
    String _plus_2 = (_plus_1 + ":");
    String _name = _self.getName();
    String _plus_3 = (_plus_2 + _name);
    String _plus_4 = (_plus_3 + ".ticks()]New number of ticks : ");
    Integer _numberOfTicks_1 = FSMClockAspect.numberOfTicks(_self);
    String _string = _numberOfTicks_1.toString();
    String _plus_5 = (_plus_4 + _string);
    InputOutput.<String>println(_plus_5);
    return FSMClockAspect.numberOfTicks(_self);
  }
  
  protected static Integer _privk3_numberOfTicks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getNumberOfTicks") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.lang.Integer) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.numberOfTicks;
  }
  
  protected static void _privk3_numberOfTicks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self, final Integer numberOfTicks) {
    _self_.numberOfTicks = numberOfTicks; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setNumberOfTicks")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, numberOfTicks);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
