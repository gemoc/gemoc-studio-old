package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@Aspect(className = Transition.class)
@SuppressWarnings("all")
public class TransitionVisitorAspect {
  @Step
  public static void visit(final Transition _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_visit(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"Transition","visit");
    } else {
    	command.execute();
    }
    ;;
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
