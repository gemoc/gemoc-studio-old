package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.FSMClockAspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMClock;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final TemporalGuard _self) {
    final org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties _self_ = org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectContext.getSelf(_self);
     if (_self instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard){
    					org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspect._privk3_visit(_self_, (org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard)_self);
    } else  if (_self instanceof org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard){
    					org.gemoc.sample.tfsm.sequential.xtfsm.aspects.GuardVisitorAspect.visit((org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard)_self);
    } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); };
  }
  
  protected static void _privk3_visit(final TemporalGuardVisitorAspectTemporalGuardAspectProperties _self_, final TemporalGuard _self) {
    int _afterDuration = _self.getAfterDuration();
    int _lastStateChangeStepNumber = GuardVisitorAspect.lastStateChangeStepNumber(_self);
    int _plus = (_afterDuration + _lastStateChangeStepNumber);
    FSMClock _onClock = _self.getOnClock();
    Integer _numberOfTicks = FSMClockAspect.numberOfTicks(_onClock);
    boolean _equals = (_plus == (_numberOfTicks).intValue());
    if (_equals) {
      GuardVisitorAspect.fireTransition(_self);
    }
  }
}
