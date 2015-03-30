package org.gemoc.sigpmlextended.k3dsa;

import com.google.common.collect.LinkedListMultimap;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties;

@Aspect(className = sigpmlextended.System.class)
@SuppressWarnings("all")
public class SystemAspect {
  public static LinkedListMultimap sharedMemory(final sigpmlextended.System _self) {
    org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_sharedMemory(_self_, _self);
    return (com.google.common.collect.LinkedListMultimap)result;
  }
  
  public static void sharedMemory(final sigpmlextended.System _self, final LinkedListMultimap sharedMemory) {
    org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties _self_ = org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectContext.getSelf(_self);
    _privk3_sharedMemory(_self_, _self,sharedMemory);
  }
  
  protected static LinkedListMultimap _privk3_sharedMemory(final SystemAspectSystemAspectProperties _self_, final sigpmlextended.System _self) {
     return _self_.sharedMemory; 
  }
  
  protected static void _privk3_sharedMemory(final SystemAspectSystemAspectProperties _self_, final sigpmlextended.System _self, final LinkedListMultimap sharedMemory) {
    _self_.sharedMemory = sharedMemory; try {
    
    			for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    				if (m.getName().equals("set" + "SharedMemory")
    						&& m.getParameterTypes().length == 1) {
    					m.invoke(_self, sharedMemory);
    
    				}
    			}
    		} catch (Exception e) {
    			// Chut !
    		} 
  }
}
