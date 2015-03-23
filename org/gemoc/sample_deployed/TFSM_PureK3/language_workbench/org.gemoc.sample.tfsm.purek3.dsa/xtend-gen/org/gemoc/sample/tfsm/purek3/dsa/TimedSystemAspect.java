package org.gemoc.sample.tfsm.purek3.dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect;
import org.gemoc.sample.tfsm.purek3.dsa.TimedSystemAspectTimedSystemAspectProperties;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemAspect {
  public static void accept(final TimedSystem _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TimedSystemAspectTimedSystemAspectContext.getSelf(_self);
    	    
    	      _privk3_accept(_self,visitor); 
  }
  
  public static TimedSystemAspectTimedSystemAspectProperties _self_;
  
  protected static void _privk3_accept(final TimedSystem _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    EList<FSMClock> _globalClocks = _self.getGlobalClocks();
    final Consumer<FSMClock> _function = new Consumer<FSMClock>() {
      public void accept(final FSMClock e) {
        FSMClockAspect.accept(e, visitor);
      }
    };
    _globalClocks.forEach(_function);
    EList<TFSM> _tfsms = _self.getTfsms();
    final Consumer<TFSM> _function_1 = new Consumer<TFSM>() {
      public void accept(final TFSM t) {
        TFSMAspect.accept(t, visitor);
      }
    };
    _tfsms.forEach(_function_1);
    visitor.endVisit(_self);
  }
}
