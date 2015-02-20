package org.gemoc.sigpmlextended.k3dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import sigpmlextended.HWComputationalResource;
import org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectProperties;

@Aspect(className = HWComputationalResource.class)
@SuppressWarnings("all")
public class HWComputationalResourceAspect {
  public static void incCycle(final HWComputationalResource _self) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectContext.getSelf(_self);
    _privk3_incCycle(_self);
  }
  
  public static HWComputationalResourceAspectHWComputationalResourceAspectProperties _self_;
  
  public static int currentExecCycle(final HWComputationalResource _self) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_currentExecCycle(_self);
    return (int)result;
  }
  
  public static void currentExecCycle(final HWComputationalResource _self, final int currentExecCycle) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectContext.getSelf(_self);
    _privk3_currentExecCycle(_self,currentExecCycle);
  }
  
  protected static void _privk3_incCycle(final HWComputationalResource _self) {
    int _currentExecCycle = HWComputationalResourceAspect.currentExecCycle(_self);
    int _plus = (_currentExecCycle + 1);
    HWComputationalResourceAspect.currentExecCycle(_self, _plus);
    String _name = _self.getName();
    String _plus_1 = ("time in CPU " + _name);
    String _plus_2 = (_plus_1 + " = ");
    int _currentExecCycle_1 = HWComputationalResourceAspect.currentExecCycle(_self);
    String _plus_3 = (_plus_2 + Integer.valueOf(_currentExecCycle_1));
    InputOutput.<String>println(_plus_3);
  }
  
  protected static int _privk3_currentExecCycle(final HWComputationalResource _self) {
     return org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspect._self_.currentExecCycle; 
  }
  
  protected static void _privk3_currentExecCycle(final HWComputationalResource _self, final int currentExecCycle) {
    org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspect._self_.currentExecCycle = currentExecCycle; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "CurrentExecCycle")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, currentExecCycle);
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
