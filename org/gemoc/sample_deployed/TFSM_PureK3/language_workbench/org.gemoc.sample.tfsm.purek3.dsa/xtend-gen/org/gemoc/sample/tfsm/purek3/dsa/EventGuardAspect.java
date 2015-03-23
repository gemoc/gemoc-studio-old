package org.gemoc.sample.tfsm.purek3.dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.EventGuard;
import org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspectEventGuardAspectProperties;
import org.gemoc.sample.tfsm.purek3.dsa.GuardAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;

@Aspect(className = EventGuard.class)
@SuppressWarnings("all")
public class EventGuardAspect extends GuardAspect {
  public static void accept(final EventGuard _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspectEventGuardAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.gemoc.sample.tfsm.EventGuard){
    	      org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspect._privk3_accept((org.gemoc.sample.tfsm.EventGuard)_self,visitor);
    	     } else  if (_self instanceof org.gemoc.sample.tfsm.Guard){
    	      org.gemoc.sample.tfsm.purek3.dsa.GuardAspect._privk3_accept((org.gemoc.sample.tfsm.Guard)_self,visitor);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static EventGuardAspectEventGuardAspectProperties _self_;
  
  protected static void _privk3_accept(final EventGuard _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    visitor.endVisit(_self);
  }
}
