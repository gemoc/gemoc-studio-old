package org.gemoc.sample.tfsm.purek3.dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.Transition;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectProperties;
import org.gemoc.sample.tfsm.purek3.dsa.TransitionAspect;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateAspect {
  public static String onEnter(final State _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectContext.getSelf(_self);
    	    
    	     return _privk3_onEnter(_self); 
  }
  
  public static String onLeave(final State _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectContext.getSelf(_self);
    	    
    	     return _privk3_onLeave(_self); 
  }
  
  public static void accept(final State _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectContext.getSelf(_self);
    	    
    	      _privk3_accept(_self,visitor); 
  }
  
  public static StateAspectStateAspectProperties _self_;
  
  protected static String _privk3_onEnter(final State _self) {
    Class<? extends State> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".onEnter()]Entering ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    return InputOutput.<String>println(_plus_4);
  }
  
  protected static String _privk3_onLeave(final State _self) {
    Class<? extends State> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".onLeave()]Leaving ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    return InputOutput.<String>println(_plus_4);
  }
  
  protected static void _privk3_accept(final State _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    EList<Transition> _outgoingTransitions = _self.getOutgoingTransitions();
    final Consumer<Transition> _function = new Consumer<Transition>() {
      public void accept(final Transition t) {
        TransitionAspect.accept(t, visitor);
      }
    };
    _outgoingTransitions.forEach(_function);
    visitor.endVisit(_self);
  }
}
