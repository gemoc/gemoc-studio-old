package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;

/**
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.StateAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TransitionAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EventGuardAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TimedSystemAspect.
 * import static extension org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EvaluateGuardAspect.
 */
@Aspect(className = TFSM.class)
@SuppressWarnings("all")
public class TFSMAspect extends NamedElementAspect {
  public static String init(final TFSM _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_init(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  public static void changeCurrentState(final TFSM _self, final State newState) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectContext
			.getSelf(_self);
	_privk3_changeCurrentState(_self_, _self, newState);
	;
}
  
  public static State currentState(final TFSM _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_currentState(_self_, _self);
	;
	return (org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State) result;
}
  
  public static void currentState(final TFSM _self, final State currentState) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspectTFSMAspectContext
			.getSelf(_self);
	_privk3_currentState(_self_, _self, currentState);
	;
}
  
  protected static String _privk3_init(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self) {
    String _xblockexpression = null;
    {
      State _currentState = TFSMAspect.currentState(_self);
      boolean _equals = Objects.equal(_currentState, null);
      if (_equals) {
        State _initialState = _self.getInitialState();
        TFSMAspect.currentState(_self, _initialState);
      }
      Class<? extends TFSM> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = ("[" + _simpleName);
      String _plus_1 = (_plus + ":");
      String _name = _self.getName();
      String _plus_2 = (_plus_1 + _name);
      String _plus_3 = (_plus_2 + ".Init()]Initialized ");
      String _name_1 = _self.getName();
      String _plus_4 = (_plus_3 + _name_1);
      _xblockexpression = InputOutput.<String>println(_plus_4);
    }
    return _xblockexpression;
  }
  
  protected static void _privk3_changeCurrentState(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self, final State newState) {
    TFSMAspect.currentState(_self, newState);
  }
  
  protected static State _privk3_currentState(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentState") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.currentState;
  }
  
  protected static void _privk3_currentState(final TFSMAspectTFSMAspectProperties _self_, final TFSM _self, final State currentState) {
    _self_.currentState = currentState; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentState")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentState);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
