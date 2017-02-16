package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspectStateAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateAspect extends NamedElementAspect {
  public static String onEnter(final State _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspectStateAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_onEnter(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  public static String onLeave(final State _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspectStateAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_onLeave(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  protected static String _privk3_onEnter(final StateAspectStateAspectProperties _self_, final State _self) {
    String _xblockexpression = null;
    {
      TFSM _owningFSM = _self.getOwningFSM();
      TFSMAspect.currentState(_owningFSM, _self);
      Class<? extends State> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = ("[" + _simpleName);
      String _plus_1 = (_plus + ":");
      String _name = _self.getName();
      String _plus_2 = (_plus_1 + _name);
      String _plus_3 = (_plus_2 + ".onEnter()]Entering ");
      String _name_1 = _self.getName();
      String _plus_4 = (_plus_3 + _name_1);
      _xblockexpression = InputOutput.<String>println(_plus_4);
    }
    return _xblockexpression;
  }
  
  protected static String _privk3_onLeave(final StateAspectStateAspectProperties _self_, final State _self) {
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
}
