package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.Step;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionAspectTransitionAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@Aspect(className = Transition.class)
@SuppressWarnings("all")
public class TransitionAspect {
  @Step
  public static void fire(final Transition _self) {
    final org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionAspectTransitionAspectProperties _self_ = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionAspectTransitionAspectContext.getSelf(_self);
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand command = new fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepCommand() {
    	@Override
    	public void execute() {
    		_privk3_fire(_self_, _self);
    	}
    };
    fr.inria.diverse.k3.al.annotationprocessor.stepmanager.IStepManager manager = fr.inria.diverse.k3.al.annotationprocessor.stepmanager.StepManagerRegistry.getInstance().findStepManager(_self);
    if (manager != null) {
    	manager.executeStep(_self,command,"Transition","fire");
    } else {
    	command.execute();
    }
    ;;
  }
  
  protected static void _privk3_fire(final TransitionAspectTransitionAspectProperties _self_, final Transition _self) {
    State _source = _self.getSource();
    TFSM _owningFSM = _source.getOwningFSM();
    State _target = _self.getTarget();
    TFSMAspect.currentState(_owningFSM, _target);
    Class<? extends Transition> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".fire()]Fired ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    String _plus_5 = (_plus_4 + " -> ");
    String _action = _self.getAction();
    String _plus_6 = (_plus_5 + _action);
    InputOutput.<String>println(_plus_6);
  }
}
