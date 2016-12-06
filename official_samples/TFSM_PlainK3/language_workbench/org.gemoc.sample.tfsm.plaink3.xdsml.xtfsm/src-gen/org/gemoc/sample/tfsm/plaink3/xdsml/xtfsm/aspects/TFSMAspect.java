package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;

@Aspect(className = TFSM.class)
@SuppressWarnings("all")
public class TFSMAspect {
  @Step
  public static void init(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_init(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"TFSM","init");
    } else {
    	command.execute();
    }
    ;;
  }
  
  public static State currentState(final TFSM _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_currentState(_self_, _self);;
    return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State)result;
  }
  
  public static void currentState(final TFSM _self, final State currentState) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectContext.getSelf(_self);
    _privk3_currentState(_self_, _self,currentState);;
  }
  
  protected static void _privk3_init(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self) {
    State _initialState = _self.getInitialState();
    TFSMAspect.currentState(_self, _initialState);
    FSMClock _localClock = _self.getLocalClock();
    FSMClockAspect.numberOfTicks(_localClock, Integer.valueOf(0));
    EList<FSMEvent> _localEvents = _self.getLocalEvents();
    final Consumer<FSMEvent> _function = new Consumer<FSMEvent>() {
      @Override
      public void accept(final FSMEvent e) {
        FSMEventAspect.isTriggered(e, false);
      }
    };
    _localEvents.forEach(_function);
    TFSMVisitorAspect.stepNumber(_self, 0);
    TFSMVisitorAspect.lastStateChangeStepNumber(_self, 0);
    Class<? extends TFSM> _class = _self.getClass();
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
  
  protected static State _privk3_currentState(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentState;
  }
  
  protected static void _privk3_currentState(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self, final State currentState) {
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
