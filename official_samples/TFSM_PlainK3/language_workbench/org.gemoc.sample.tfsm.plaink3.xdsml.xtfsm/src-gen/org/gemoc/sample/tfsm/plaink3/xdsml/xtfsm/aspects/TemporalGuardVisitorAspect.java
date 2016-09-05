package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final TemporalGuard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectContext.getSelf(_self);
     if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspect._privk3_visit(_self_, (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard)_self);
    } else  if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspect.visit((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard)_self);
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
