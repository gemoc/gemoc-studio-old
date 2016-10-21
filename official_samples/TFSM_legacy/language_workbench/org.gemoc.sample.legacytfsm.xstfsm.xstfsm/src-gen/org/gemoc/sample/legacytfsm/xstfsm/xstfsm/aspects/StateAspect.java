package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspectStateAspectProperties;

@Aspect(className = State.class)
@SuppressWarnings("all")
public class StateAspect {
  public static void onEnter(final State _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspectStateAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_onEnter(_self_, _self);
	;
}
  
  public static void onLeave(final State _self) {
	final org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspectStateAspectProperties _self_ = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspectStateAspectContext
			.getSelf(_self);
	_privk3_onLeave(_self_, _self);
	;
}
  
  protected static void _privk3_onEnter(final StateAspectStateAspectProperties _self_, final State _self) {
    Class<? extends State> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".onEnter()]Entering ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    InputOutput.<String>println(_plus_4);
  }
  
  protected static void _privk3_onLeave(final StateAspectStateAspectProperties _self_, final State _self) {
    Class<? extends State> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".onLeave()]Leaving ");
    String _name_1 = _self.getName();
    String _plus_4 = (_plus_3 + _name_1);
    InputOutput.<String>println(_plus_4);
  }
}
