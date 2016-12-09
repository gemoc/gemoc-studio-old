package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMEventAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.GuardVisitorAspect;

@Aspect(className = EventGuard.class)
@SuppressWarnings("all")
public class EventGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final EventGuard _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectContext
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
