package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspect;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemVisitorAspect {
  public static void visit(final TimedSystem _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectContext
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
    EList<TimedFSM> _tfsms = _self.getTfsms();
    final Consumer<TimedFSM> _function_1 = (TimedFSM t) -> {
      TimedFSMVisitorAspect.visit(t);
    };
    _tfsms.forEach(_function_1);
  }
}
