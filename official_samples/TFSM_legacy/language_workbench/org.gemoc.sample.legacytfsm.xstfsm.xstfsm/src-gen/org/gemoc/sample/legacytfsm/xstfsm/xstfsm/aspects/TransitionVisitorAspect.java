package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectProperties;

@Aspect(className = Transition.class)
@SuppressWarnings("all")
public class TransitionVisitorAspect {
  @Step
  public static void visit(final Transition _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectContext
			.getSelf(_self);
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
		@Override
		public void execute() {
			_privk3_visit(_self_, _self);
		}
	};
	fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry
			.getInstance().findStepManager(_self);
	if (manager != null) {
		manager.executeStep(_self, command, "Transition", "visit");
	} else {
		command.execute();
	}
	;
	;
}
  
  protected static void _privk3_visit(final TransitionVisitorAspectTransitionAspectProperties _self_, final Transition _self) {
    Guard _ownedGuard = _self.getOwnedGuard();
    boolean _notEquals = (!Objects.equal(_ownedGuard, null));
    if (_notEquals) {
      Guard _ownedGuard_1 = _self.getOwnedGuard();
      GuardVisitorAspect.visit(_ownedGuard_1);
    }
  }
}
