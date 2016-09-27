package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;
import fr.inria.diverse.k3.al.annotationprocessor.Main;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.FSMEventAspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TFSMVisitorAspect;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TFSM;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemAspect {
  @Main
  public static void main(final TimedSystem _self) {
    final org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemAspectTimedSystemAspectContext.getSelf(_self);
    _privk3_main(_self_, _self);;
  }
  
  @InitializeModel
  public static void initializeModel(final TimedSystem _self, final EList<String> args) {
    final org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemAspectTimedSystemAspectContext.getSelf(_self);
    _privk3_initializeModel(_self_, _self,args);;
  }
  
  protected static void _privk3_main(final TimedSystemAspectTimedSystemAspectProperties _self_, final TimedSystem _self) {
    EList<TFSM> _tfsms = _self.getTfsms();
    final TFSM tfsm = _tfsms.get(0);
    int i = 0;
    while ((i != 20)) {
      {
        if ((i == 10)) {
          EList<FSMEvent> _localEvents = tfsm.getLocalEvents();
          final Consumer<FSMEvent> _function = (FSMEvent e) -> {
            FSMEventAspect.trigger(e);
          };
          _localEvents.forEach(_function);
        }
        TFSMVisitorAspect.visit(tfsm);
        if ((i == 10)) {
          EList<FSMEvent> _localEvents_1 = tfsm.getLocalEvents();
          final Consumer<FSMEvent> _function_1 = (FSMEvent e) -> {
            FSMEventAspect.unTrigger(e);
          };
          _localEvents_1.forEach(_function_1);
        }
        i++;
      }
    }
    InputOutput.<String>println((("Normal stop after " + Integer.valueOf(i)) + " iterations (set in main)"));
  }
  
  protected static void _privk3_initializeModel(final TimedSystemAspectTimedSystemAspectProperties _self_, final TimedSystem _self, final EList<String> args) {
    EList<TFSM> _tfsms = _self.getTfsms();
    final TFSM tfsm = _tfsms.get(0);
    TFSMAspect.init(tfsm);
  }
}
