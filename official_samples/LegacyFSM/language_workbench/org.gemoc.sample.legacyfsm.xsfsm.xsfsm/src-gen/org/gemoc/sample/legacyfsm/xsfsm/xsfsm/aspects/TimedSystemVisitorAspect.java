package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemVisitorAspect {
  public static void visit(final TimedSystem _self) {
	final org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectContext
			.getSelf(_self);
	_privk3_visit(_self_, _self);
	;
}
  
  protected static void _privk3_visit(final TimedSystemVisitorAspectTimedSystemAspectProperties _self_, final TimedSystem _self) {
    EList<FSMClock> _globalClocks = _self.getGlobalClocks();
    final Consumer<FSMClock> _function = (FSMClock e) -> {
      FSMClockVisitorAspect.visit(e);
    };
    _globalClocks.forEach(_function);
    EList<TimeFSM> _fsms = _self.getFsms();
    final Consumer<TimeFSM> _function_1 = (TimeFSM t) -> {
      TimeFSMVisitorAspect.visit(t);
    };
    _fsms.forEach(_function_1);
  }
}
