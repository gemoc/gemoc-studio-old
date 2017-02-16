package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockAspect extends NamedElementAspect {
  public static String ticks(final FSMClock _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_ticks(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  public static int numberOfTicks(final FSMClock _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_numberOfTicks(_self_, _self);
	;
	return (int) result;
}
  
  public static void numberOfTicks(final FSMClock _self, final int numberOfTicks) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectContext
			.getSelf(_self);
	_privk3_numberOfTicks(_self_, _self, numberOfTicks);
	;
}
  
  protected static String _privk3_ticks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    String _xblockexpression = null;
    {
      int _numberOfTicks = _self.getNumberOfTicks();
      int _plus = (_numberOfTicks + 1);
      _self.setNumberOfTicks(_plus);
      Class<? extends FSMClock> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus_1 = ("[" + _simpleName);
      String _plus_2 = (_plus_1 + ":");
      String _name = _self.getName();
      String _plus_3 = (_plus_2 + _name);
      String _plus_4 = (_plus_3 + ".ticks()]New number of ticks : ");
      int _numberOfTicks_1 = _self.getNumberOfTicks();
      String _string = Integer.valueOf(_numberOfTicks_1).toString();
      String _plus_5 = (_plus_4 + _string);
      _xblockexpression = InputOutput.<String>println(_plus_5);
    }
    return _xblockexpression;
  }
  
  protected static int _privk3_numberOfTicks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getNumberOfTicks") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (int) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.numberOfTicks;
  }
  
  protected static void _privk3_numberOfTicks(final FSMClockAspectFSMClockAspectProperties _self_, final FSMClock _self, final int numberOfTicks) {
    _self_.numberOfTicks = numberOfTicks; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setNumberOfTicks")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, numberOfTicks);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
