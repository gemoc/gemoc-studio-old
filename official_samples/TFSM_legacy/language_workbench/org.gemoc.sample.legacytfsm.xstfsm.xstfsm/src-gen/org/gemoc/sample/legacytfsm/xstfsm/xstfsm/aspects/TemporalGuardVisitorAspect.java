package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final TemporalGuard _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectContext
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
