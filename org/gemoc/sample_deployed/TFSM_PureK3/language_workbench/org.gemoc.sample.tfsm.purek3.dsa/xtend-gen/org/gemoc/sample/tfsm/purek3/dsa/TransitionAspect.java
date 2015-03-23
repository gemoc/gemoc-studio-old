package org.gemoc.sample.tfsm.purek3.dsa;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.Guard;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.Transition;
import org.gemoc.sample.tfsm.purek3.dsa.GuardAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect;
import org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectProperties;

/* @Aspect(className = Transition.class, )
 */@SuppressWarnings("all")
public class TransitionAspect {
  public static String fire(final Transition _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectContext.getSelf(_self);
    	    
    	     return _privk3_fire(_self); 
  }
  
  public static void accept(final Transition _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectContext.getSelf(_self);
    	    
    	      _privk3_accept(_self,visitor); 
  }
  
  public static TransitionAspectTransitionAspectProperties _self_;
  
  protected static String _privk3_fire(final Transition _self) {
    String _xblockexpression = null;
    {
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
      _xblockexpression = InputOutput.<String>println(_plus_6);
    }
    return _xblockexpression;
  }
  
  protected static void _privk3_accept(final Transition _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    Guard _ownedGuard = _self.getOwnedGuard();
    boolean _notEquals = (!Objects.equal(_ownedGuard, null));
    if (_notEquals) {
      Guard _ownedGuard_1 = _self.getOwnedGuard();
      GuardAspect.accept(_ownedGuard_1, visitor);
    }
    visitor.endVisit(_self);
  }
}
