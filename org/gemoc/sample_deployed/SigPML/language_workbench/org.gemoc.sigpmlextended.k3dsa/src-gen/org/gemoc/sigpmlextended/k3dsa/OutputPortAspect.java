package org.gemoc.sigpmlextended.k3dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import sigpmlextended.OutputPort;
import org.gemoc.sigpmlextended.k3dsa.NamedElementAspect;
import org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectProperties;

@Aspect(className = OutputPort.class)
@SuppressWarnings("all")
public class OutputPortAspect extends NamedElementAspect {
  public static void write(final OutputPort _self) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectContext.getSelf(_self);
    _privk3_write(_self);
  }
  
  public static OutputPortAspectOutputPortAspectProperties _self_;
  
  public static int sizeWritten(final OutputPort _self) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_sizeWritten(_self);
    return (int)result;
  }
  
  public static void sizeWritten(final OutputPort _self, final int sizeWritten) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectContext.getSelf(_self);
    _privk3_sizeWritten(_self,sizeWritten);
  }
  
  protected static void _privk3_write(final OutputPort _self) {
    int _sizeWritten = OutputPortAspect.sizeWritten(_self);
    int _plus = (_sizeWritten + 1);
    OutputPortAspect.sizeWritten(_self, _plus);
  }
  
  protected static int _privk3_sizeWritten(final OutputPort _self) {
     return org.gemoc.sigpmlextended.k3dsa.OutputPortAspect._self_.sizeWritten; 
  }
  
  protected static void _privk3_sizeWritten(final OutputPort _self, final int sizeWritten) {
    org.gemoc.sigpmlextended.k3dsa.OutputPortAspect._self_.sizeWritten = sizeWritten; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "SizeWritten")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, sizeWritten);
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
