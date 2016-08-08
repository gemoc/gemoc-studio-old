package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockAspect {
  @Step
  public static Integer ticks(final FSMClock _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockAspectFSMClockAspectContext.getSelf(_self);
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
  
  protected static Integer _privk3_ticks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    Integer _numberOfTicks = _self.getNumberOfTicks();
    int _plus = ((_numberOfTicks).intValue() + 1);
    _self.setNumberOfTicks(Integer.valueOf(_plus));
    Class<? extends FSMClock> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus_1 = ("[" + _simpleName);
    String _plus_2 = (_plus_1 + ":");
    String _name = _self.getName();
    String _plus_3 = (_plus_2 + _name);
    String _plus_4 = (_plus_3 + ".ticks()]New number of ticks : ");
    Integer _numberOfTicks_1 = _self.getNumberOfTicks();
    String _string = _numberOfTicks_1.toString();
    String _plus_5 = (_plus_4 + _string);
    InputOutput.<String>println(_plus_5);
    return _self.getNumberOfTicks();
  }
}
