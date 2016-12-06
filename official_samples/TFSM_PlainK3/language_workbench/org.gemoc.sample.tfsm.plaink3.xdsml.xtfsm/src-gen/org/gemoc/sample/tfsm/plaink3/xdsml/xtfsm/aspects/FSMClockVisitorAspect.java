package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockVisitorAspect {
  public static void visit(final FSMClock _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockVisitorAspectFSMClockAspectContext.getSelf(_self);
    _privk3_visit(_self_, _self);;
  }
  
  protected static void _privk3_visit(final FSMClockVisitorAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    FSMClockAspect.ticks(_self);
  }
}
