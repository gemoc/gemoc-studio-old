package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;
import fr.inria.diverse.k3.al.annotationprocessor.Main;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMEventAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemAspect {
  @Main
  public static void main(final TimedSystem _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemAspectTimedSystemAspectContext.getSelf(_self);
    _privk3_main(_self_, _self);;
  }
  
  @InitializeModel
  public static void initializeModel(final TimedSystem _self, final EList<String> args) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemAspectTimedSystemAspectContext.getSelf(_self);
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
          final Consumer<FSMEvent> _function = new Consumer<FSMEvent>() {
            @Override
            public void accept(final FSMEvent e) {
              FSMEventAspect.trigger(e);
            }
          };
          _localEvents.forEach(_function);
        }
        TFSMVisitorAspect.visit(tfsm);
        if ((i == 10)) {
          EList<FSMEvent> _localEvents_1 = tfsm.getLocalEvents();
          final Consumer<FSMEvent> _function_1 = new Consumer<FSMEvent>() {
            @Override
            public void accept(final FSMEvent e) {
              FSMEventAspect.unTrigger(e);
            }
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
