package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectProperties;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspect;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateVisitorAspect {
  @Step
  public static void visit(final State _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
}
  
  protected static void _privk3_visit(final StateVisitorAspectStateAspectProperties _self_, final State _self) {
    StateAspect.onEnter(_self);
    EList<Transition> _outgoingTransitions = _self.getOutgoingTransitions();
    final Consumer<Transition> _function = (Transition t) -> {
      TransitionVisitorAspect.visit(t);
    };
    _outgoingTransitions.forEach(_function);
    StateAspect.onLeave(_self);
  }
}
