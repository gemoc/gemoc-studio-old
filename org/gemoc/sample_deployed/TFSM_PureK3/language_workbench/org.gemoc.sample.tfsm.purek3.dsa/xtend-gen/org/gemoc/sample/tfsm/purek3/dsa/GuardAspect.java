package org.gemoc.sample.tfsm.purek3.dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Abstract;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.Guard;
import org.gemoc.sample.tfsm.purek3.dsa.GuardAspectGuardAspectProperties;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;

@Aspect(className = Guard.class)
@SuppressWarnings("all")
public abstract class GuardAspect {
  @Abstract
  public static void accept(final Guard _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.GuardAspectGuardAspectContext.getSelf(_self);
    	    
    	      if (_self instanceof org.gemoc.sample.tfsm.TemporalGuard){
    	      org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspect._privk3_accept((org.gemoc.sample.tfsm.TemporalGuard)_self,visitor);
    	     } else  if (_self instanceof org.gemoc.sample.tfsm.EventGuard){
    	      org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspect._privk3_accept((org.gemoc.sample.tfsm.EventGuard)_self,visitor);
    	     } else  if (_self instanceof org.gemoc.sample.tfsm.Guard){
    	      org.gemoc.sample.tfsm.purek3.dsa.GuardAspect._privk3_accept((org.gemoc.sample.tfsm.Guard)_self,visitor);
    	     } else  { throw new IllegalArgumentException("Unhandled parameter types: " + java.util.Arrays.<Object>asList(_self).toString()); }
  }
  
  public static GuardAspectGuardAspectProperties _self_;
  
  protected static void _privk3_accept(final Guard _self, final IVisitor visitor) {
    throw new java.lang.RuntimeException("Not implemented");
  }
}
