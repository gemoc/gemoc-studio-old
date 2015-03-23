package org.gemoc.sample.tfsm.purek3.dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.purek3.dsa.GuardAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspectTemporalGuardAspectProperties;

@Aspect(className = TemporalGuard.class)
@SuppressWarnings("all")
public class TemporalGuardAspect extends GuardAspect {
  public static void accept(final TemporalGuard _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspectTemporalGuardAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.gemoc.sample.tfsm.TemporalGuard){
    	      org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspect._privk3_accept((org.gemoc.sample.tfsm.TemporalGuard)_self,visitor);
    	     } else  if (_self instanceof org.gemoc.sample.tfsm.Guard){
    	      org.gemoc.sample.tfsm.purek3.dsa.GuardAspect._privk3_accept((org.gemoc.sample.tfsm.Guard)_self,visitor);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static TemporalGuardAspectTemporalGuardAspectProperties _self_;
  
  protected static void _privk3_accept(final TemporalGuard _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    visitor.endVisit(_self);
  }
}
