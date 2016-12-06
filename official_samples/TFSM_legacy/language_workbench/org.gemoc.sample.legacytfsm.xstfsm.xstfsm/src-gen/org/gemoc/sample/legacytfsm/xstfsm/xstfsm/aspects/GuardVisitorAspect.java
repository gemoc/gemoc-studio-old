package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionAspect;

@Aspect(className = Guard.class)
@SuppressWarnings("all")
public abstract class GuardVisitorAspect {
  @Abstract
  public static void visit(final Guard _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectContext
			.getSelf(_self);
	if (_self instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard) {
		org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspect
				.visit((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard) _self);
	} else if (_self instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard) {
		org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspect
				.visit((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard) _self);
	} else if (_self instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard) {
		org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspect._privk3_visit(_self_,
				(org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard) _self);
	} else if (_self instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard) {
		org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspect._privk3_visit(_self_,
				(org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard) _self);
	} else {
		throw new IllegalArgumentException(
				"Unhandled parameter types: " + java.util.Arrays.<Object> asList(_self).toString());
	}
	;
}
  
  protected static void fireTransition(final Guard _self) {
    final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
    _privk3_fireTransition(_self_, _self);;
  }
  
  protected static int lastStateChangeStepNumber(final Guard _self) {
    final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_lastStateChangeStepNumber(_self_, _self);;
    return (int)result;
  }
  
  protected static void saveLastStateChangeStepNumber(final Guard _self) {
    final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
    _privk3_saveLastStateChangeStepNumber(_self_, _self);;
  }
  
  protected static void _privk3_visit(final GuardVisitorAspectGuardAspectProperties _self_, final Guard _self) {
    throw new java.lang.RuntimeException("Not implemented");
  }
  
  protected static void _privk3_fireTransition(final GuardVisitorAspectGuardAspectProperties _self_, final Guard _self) {
    EObject _eContainer = _self.eContainer();
    final Transition transitionToFire = ((Transition) _eContainer);
    String _name = transitionToFire.getName();
    String _plus = ("fire transition " + _name);
    InputOutput.<String>println(_plus);
    TransitionAspect.fire(transitionToFire);
    GuardVisitorAspect.saveLastStateChangeStepNumber(_self);
  }
  
  protected static int _privk3_lastStateChangeStepNumber(final GuardVisitorAspectGuardAspectProperties _self_, final Guard _self) {
    EObject _eContainer = _self.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    final TimeFSM tfsm = ((TimeFSM) _eContainer_1);
    return TimeFSMVisitorAspect.lastStateChangeStepNumber(tfsm);
  }
  
  protected static void _privk3_saveLastStateChangeStepNumber(final GuardVisitorAspectGuardAspectProperties _self_, final Guard _self) {
    EObject _eContainer = _self.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    final TimeFSM tfsm = ((TimeFSM) _eContainer_1);
    int _stepNumber = TimeFSMVisitorAspect.stepNumber(tfsm);
    TimeFSMVisitorAspect.lastStateChangeStepNumber(tfsm, _stepNumber);
  }
}
