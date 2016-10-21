package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspect;

@Aspect(className = EventGuard.class)
@SuppressWarnings("all")
public class EventGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final EventGuard _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
}
  
  protected static void _privk3_visit(final EventGuardVisitorAspectEventGuardAspectProperties _self_, final EventGuard _self) {
    FSMEvent _triggeringEvent = _self.getTriggeringEvent();
    boolean _isTriggered = FSMEventAspect.isTriggered(_triggeringEvent);
    if (_isTriggered) {
      GuardVisitorAspect.fireTransition(_self);
    }
  }
}
