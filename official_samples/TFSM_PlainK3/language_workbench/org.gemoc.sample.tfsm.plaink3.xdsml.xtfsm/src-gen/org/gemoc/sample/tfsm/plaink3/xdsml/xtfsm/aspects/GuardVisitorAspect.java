package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@Aspect(className = Guard.class)
@SuppressWarnings("all")
public abstract class GuardVisitorAspect {
  @Abstract
  public static void visit(final Guard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
     if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspect.visit((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard)_self);
    } else  if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.EventGuardVisitorAspect.visit((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard)_self);
    } else  if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspect._privk3_visit(_self_, (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard)_self);
    } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); };
  }
  
  protected static void fireTransition(final Guard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
    _privk3_fireTransition(_self_, _self);;
  }
  
  protected static int lastStateChangeStepNumber(final Guard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_lastStateChangeStepNumber(_self_, _self);;
    return (int)result;
  }
  
  protected static void saveLastStateChangeStepNumber(final Guard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectContext.getSelf(_self);
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
    final TFSM tfsm = ((TFSM) _eContainer_1);
    return TFSMVisitorAspect.lastStateChangeStepNumber(tfsm);
  }
  
  protected static void _privk3_saveLastStateChangeStepNumber(final GuardVisitorAspectGuardAspectProperties _self_, final Guard _self) {
    EObject _eContainer = _self.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    final TFSM tfsm = ((TFSM) _eContainer_1);
    int _stepNumber = TFSMVisitorAspect.stepNumber(tfsm);
    TFSMVisitorAspect.lastStateChangeStepNumber(tfsm, _stepNumber);
  }
}
