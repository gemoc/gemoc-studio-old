package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.StateAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.StateVisitorAspectStateAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateVisitorAspect {
  @Step
  public static void visit(final State _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.StateVisitorAspectStateAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.StateVisitorAspectStateAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_visit(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"State","visit");
    } else {
    	command.execute();
    }
    ;;
  }
  
  protected static void _privk3_visit(final StateVisitorAspectStateAspectProperties _self_, final State _self) {
    StateAspect.onEnter(_self);
    EList<Transition> _outgoingTransitions = _self.getOutgoingTransitions();
    final Consumer<Transition> _function = new Consumer<Transition>() {
      @Override
      public void accept(final Transition t) {
        TransitionVisitorAspect.visit(t);
      }
    };
    _outgoingTransitions.forEach(_function);
    StateAspect.onLeave(_self);
  }
}
