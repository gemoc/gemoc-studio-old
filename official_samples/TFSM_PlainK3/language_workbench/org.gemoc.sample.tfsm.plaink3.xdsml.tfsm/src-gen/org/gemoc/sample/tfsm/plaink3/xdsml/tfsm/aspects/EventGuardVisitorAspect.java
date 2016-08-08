package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.GuardVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent;

@Aspect(className = EventGuard.class)
@SuppressWarnings("all")
public class EventGuardVisitorAspect extends GuardVisitorAspect {
  public static void visit(final EventGuard _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.EventGuardVisitorAspectEventGuardAspectContext.getSelf(_self);
     if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.EventGuardVisitorAspect._privk3_visit(_self_, (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard)_self);
    } else  if (_self instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Guard){
    					org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.GuardVisitorAspect.visit((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Guard)_self);
    } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); };
  }
  
  protected static void _privk3_visit(final EventGuardVisitorAspectEventGuardAspectProperties _self_, final EventGuard _self) {
    FSMEvent _triggeringEvent = _self.getTriggeringEvent();
    boolean _isIsTriggered = _triggeringEvent.isIsTriggered();
    if (_isIsTriggered) {
      GuardVisitorAspect.fireTransition(_self);
    }
  }
}
