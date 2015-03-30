package org.gemoc.sample.tfsm.purek3.dsa;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;
import org.gemoc.sample.tfsm.purek3.dsa.StateAspect;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectProperties;

@Aspect(className = TFSM.class)
@SuppressWarnings("all")
public class TFSMAspect {
  public static String Init(final TFSM _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectContext.getSelf(_self);
    	    
    	     return _privk3_Init(_self); 
  }
  
  public static void accept(final TFSM _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectContext.getSelf(_self);
    	    
    	      _privk3_accept(_self,visitor); 
  }
  
  public static TFSMAspectTFSMAspectProperties _self_;
  
  public static State currentState(final TFSM _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectContext.getSelf(_self);
    	    
    	     return _privk3_currentState(_self); 
  }
  
  public static void currentState(final TFSM _self, final State currentState) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectContext.getSelf(_self);
    	    
    	      _privk3_currentState(_self,currentState); 
  }
  
  protected static String _privk3_Init(final TFSM _self) {
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
  
  protected static void _privk3_accept(final TFSM _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    FSMClock _localClock = _self.getLocalClock();
    boolean _notEquals = (!Objects.equal(_localClock, null));
    if (_notEquals) {
      FSMClock _localClock_1 = _self.getLocalClock();
      FSMClockAspect.accept(_localClock_1, visitor);
    }
    State _currentState = TFSMAspect.currentState(_self);
    StateAspect.accept(_currentState, visitor);
    visitor.endVisit(_self);
  }
  
  protected static State _privk3_currentState(final TFSM _self) {
     return org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect._self_.currentState; 
  }
  
  protected static void _privk3_currentState(final TFSM _self, final State currentState) {
    org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect._self_.currentState = currentState; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "CurrentState")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, currentState); 
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
