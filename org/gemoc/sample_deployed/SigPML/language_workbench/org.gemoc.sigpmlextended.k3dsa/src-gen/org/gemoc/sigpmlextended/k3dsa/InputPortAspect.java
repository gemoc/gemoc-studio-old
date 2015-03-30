package org.gemoc.sigpmlextended.k3dsa;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.xtext.xbase.lib.InputOutput;
import sigpmlextended.InputPort;
import org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties;
import org.gemoc.sigpmlextended.k3dsa.NamedElementAspect;

@Aspect(className = InputPort.class)
@SuppressWarnings("all")
public class InputPortAspect extends NamedElementAspect {
  public static int read(final InputPort _self) {
    org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_read(_self_, _self);
    return (int)result;
  }
  
  public static void logSizeToReadWhenZero(final InputPort _self) {
    org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectContext.getSelf(_self);
    _privk3_logSizeToReadWhenZero(_self_, _self);
  }
  
  public static void logSizeToReadWhenNotZero(final InputPort _self) {
    org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectContext.getSelf(_self);
    _privk3_logSizeToReadWhenNotZero(_self_, _self);
  }
  
  public static int sizeToread(final InputPort _self) {
    org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_sizeToread(_self_, _self);
    return (int)result;
  }
  
  public static void sizeToread(final InputPort _self, final int sizeToread) {
    org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectContext.getSelf(_self);
    _privk3_sizeToread(_self_, _self,sizeToread);
  }
  
  protected static int _privk3_read(final InputPortAspectInputPortAspectProperties _self_, final InputPort _self) {
    int _sizeToread = InputPortAspect.sizeToread(_self);
    int _plus = (_sizeToread + 1);
    InputPortAspect.sizeToread(_self, _plus);
    return InputPortAspect.sizeToread(_self);
  }
  
  protected static void _privk3_logSizeToReadWhenZero(final InputPortAspectInputPortAspectProperties _self_, final InputPort _self) {
    InputOutput.<String>println("*** sizeToRead is equal to 0 ***");
  }
  
  protected static void _privk3_logSizeToReadWhenNotZero(final InputPortAspectInputPortAspectProperties _self_, final InputPort _self) {
    int _sizeToread = InputPortAspect.sizeToread(_self);
    String _plus = ("sizeToRead = " + Integer.valueOf(_sizeToread));
    InputOutput.<String>println(_plus);
  }
  
  protected static int _privk3_sizeToread(final InputPortAspectInputPortAspectProperties _self_, final InputPort _self) {
     return _self_.sizeToread; 
  }
  
  protected static void _privk3_sizeToread(final InputPortAspectInputPortAspectProperties _self_, final InputPort _self, final int sizeToread) {
    _self_.sizeToread = sizeToread; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "SizeToread")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, sizeToread);
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
