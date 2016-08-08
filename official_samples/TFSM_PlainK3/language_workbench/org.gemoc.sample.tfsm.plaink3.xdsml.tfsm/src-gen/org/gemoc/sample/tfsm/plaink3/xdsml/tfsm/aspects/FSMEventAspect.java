package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent;

@Aspect(className = FSMEvent.class)
@SuppressWarnings("all")
public class FSMEventAspect {
  @Step
  public static void trigger(final FSMEvent _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
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
    final org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
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
  
  protected static void _privk3_trigger(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    _self.setIsTriggered(true);
  }
  
  protected static void _privk3_unTrigger(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    _self.setIsTriggered(false);
  }
}
