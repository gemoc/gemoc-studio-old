package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent;

@Aspect(className = FSMEvent.class)
@SuppressWarnings("all")
public class FSMEventAspect extends NamedElementAspect {
  public static String occurs(final FSMEvent _self) {
    final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_occurs(_self_, _self);;
    return (java.lang.String)result;
  }
  
  protected static String _privk3_occurs(final FSMEventAspectFSMEventAspectProperties _self_, final FSMEvent _self) {
    Class<? extends FSMEvent> _class = _self.getClass();
    String _simpleName = _class.getSimpleName();
    String _plus = ("[" + _simpleName);
    String _plus_1 = (_plus + ":");
    String _name = _self.getName();
    String _plus_2 = (_plus_1 + _name);
    String _plus_3 = (_plus_2 + ".occurs()]Occured ");
    return InputOutput.<String>println(_plus_3);
  }
}
