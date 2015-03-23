package org.gemoc.sample.tfsm.purek3.dsa;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor;

@Aspect(className = FSMClock.class)
@SuppressWarnings("all")
public class FSMClockAspect {
  public static String ticks(final FSMClock _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    	    
    	     return _privk3_ticks(_self); 
  }
  
  public static void accept(final FSMClock _self, final IVisitor visitor) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    	    
    	      _privk3_accept(_self,visitor); 
  }
  
  public static FSMClockAspectFSMClockAspectProperties _self_;
  
  public static Integer numberOfTicks(final FSMClock _self) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    	    
    	     return _privk3_numberOfTicks(_self); 
  }
  
  public static void numberOfTicks(final FSMClock _self, final Integer numberOfTicks) {
    _self_ = org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectContext.getSelf(_self);
    	    
    	      _privk3_numberOfTicks(_self,numberOfTicks); 
  }
  
  protected static String _privk3_ticks(final FSMClock _self) {
    String _xblockexpression = null;
    {
      Integer _numberOfTicks = FSMClockAspect.numberOfTicks(_self);
      boolean _equals = Objects.equal(_numberOfTicks, null);
      if (_equals) {
        FSMClockAspect.numberOfTicks(_self, Integer.valueOf(0));
      } else {
        Integer _numberOfTicks_1 = FSMClockAspect.numberOfTicks(_self);
        int _plus = ((_numberOfTicks_1).intValue() + 1);
        FSMClockAspect.numberOfTicks(_self, Integer.valueOf(_plus));
      }
      Class<? extends FSMClock> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus_1 = ("[" + _simpleName);
      String _plus_2 = (_plus_1 + ":");
      String _name = _self.getName();
      String _plus_3 = (_plus_2 + _name);
      String _plus_4 = (_plus_3 + ".ticks()]New number of ticks : ");
      Integer _numberOfTicks_2 = FSMClockAspect.numberOfTicks(_self);
      String _string = _numberOfTicks_2.toString();
      String _plus_5 = (_plus_4 + _string);
      _xblockexpression = InputOutput.<String>println(_plus_5);
    }
    return _xblockexpression;
  }
  
  protected static void _privk3_accept(final FSMClock _self, final IVisitor visitor) {
    visitor.beginVisit(_self);
    visitor.endVisit(_self);
  }
  
  protected static Integer _privk3_numberOfTicks(final FSMClock _self) {
     return org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect._self_.numberOfTicks; 
  }
  
  protected static void _privk3_numberOfTicks(final FSMClock _self, final Integer numberOfTicks) {
    org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect._self_.numberOfTicks = numberOfTicks; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "NumberOfTicks")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, numberOfTicks); 
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
