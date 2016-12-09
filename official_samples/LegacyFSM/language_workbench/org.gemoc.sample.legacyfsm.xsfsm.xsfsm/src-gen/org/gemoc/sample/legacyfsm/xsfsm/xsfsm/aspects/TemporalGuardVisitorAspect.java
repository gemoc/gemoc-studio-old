package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final TemporalGuard _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
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
