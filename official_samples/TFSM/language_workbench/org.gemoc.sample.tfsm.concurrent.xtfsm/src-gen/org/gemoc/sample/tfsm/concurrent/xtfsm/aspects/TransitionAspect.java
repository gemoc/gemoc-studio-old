package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.util.Map;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EvaluateGuardAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TransitionAspectTransitionAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Transition;

@Aspect(className = Transition.class)
@SuppressWarnings("all")
public class TransitionAspect extends NamedElementAspect {
  public static String fire(final Transition _self) {
    final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TransitionAspectTransitionAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TransitionAspectTransitionAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_fire(_self_, _self);;
    return (java.lang.String)result;
  }
  
  protected static String _privk3_fire(final TransitionAspectTransitionAspectProperties _self_, final Transition _self) {
    String _xblockexpression = null;
    {
      boolean _and = false;
      String _action = _self.getAction();
      boolean _notEquals = (!Objects.equal(_action, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _action_1 = _self.getAction();
        boolean _isEmpty = _action_1.isEmpty();
        boolean _not = (!_isEmpty);
        _and = _not;
      }
      if (_and) {
        Object res = null;
        try {
          final Binding binding = new Binding();
          binding.setVariable("_self", _self);
          binding.setVariable("_this", _self);
          final ClassLoader ucl = EvaluateGuardAspect.class.getClassLoader();
          final GroovyShell shell = new GroovyShell(ucl, binding);
          String _action_2 = _self.getAction();
          Object _evaluate = shell.evaluate(_action_2);
          res = ((Map<String, Object>) _evaluate);
        } catch (final Throwable _t) {
          if (_t instanceof MultipleCompilationErrorsException) {
            final MultipleCompilationErrorsException cnfe = (MultipleCompilationErrorsException)_t;
            String _message = cnfe.getMessage();
            String _plus = ("Failed to call Groovy script" + _message);
            InputOutput.<String>println(_plus);
            cnfe.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      State _source = _self.getSource();
      TFSM _owningFSM = _source.getOwningFSM();
      TFSMAspect.currentState(_owningFSM, null);
      Class<? extends Transition> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus_1 = ("[" + _simpleName);
      String _plus_2 = (_plus_1 + ":");
      String _name = _self.getName();
      String _plus_3 = (_plus_2 + _name);
      String _plus_4 = (_plus_3 + ".fire()]Fired ");
      String _name_1 = _self.getName();
      String _plus_5 = (_plus_4 + _name_1);
      String _plus_6 = (_plus_5 + " -> ");
      String _action_3 = _self.getAction();
      String _plus_7 = (_plus_6 + _action_3);
      _xblockexpression = InputOutput.<String>println(_plus_7);
    }
    return _xblockexpression;
  }
}
