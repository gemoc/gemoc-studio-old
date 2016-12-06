package org.gemoc.sample.sigpml.xsigpml.aspects;

import org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = OutputPort.class)
@SuppressWarnings("all")
public class OutputPortAspect extends NamedElementAspect {
  public static void write(final OutputPort _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectContext
			.getSelf(_self);
	_privk3_write(_self_, _self);
	;
}
  
  public static int sizeWritten(final OutputPort _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_sizeWritten(_self_, _self);
	;
	return (int) result;
}
  
  public static void sizeWritten(final OutputPort _self, final int sizeWritten) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectContext
			.getSelf(_self);
	_privk3_sizeWritten(_self_, _self, sizeWritten);
	;
}
  
  protected static void _privk3_write(final OutputPortAspectOutputPortAspectProperties _self_, final OutputPort _self) {
    int _sizeWritten = OutputPortAspect.sizeWritten(_self);
    int _plus = (_sizeWritten + 1);
    OutputPortAspect.sizeWritten(_self, _plus);
  }
  
  protected static int _privk3_sizeWritten(final OutputPortAspectOutputPortAspectProperties _self_, final OutputPort _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getSizeWritten") &&
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
    return _self_.sizeWritten;
  }
  
  protected static void _privk3_sizeWritten(final OutputPortAspectOutputPortAspectProperties _self_, final OutputPort _self, final int sizeWritten) {
    _self_.sizeWritten = sizeWritten; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setSizeWritten")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, sizeWritten);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
