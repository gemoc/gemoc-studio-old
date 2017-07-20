/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.sigpml.xsigpml.aspects;

import com.google.common.collect.LinkedListMultimap;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Place;
import org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect;
import org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspect;
import org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties;
import org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspect;

@Aspect(className = Place.class)
@SuppressWarnings("all")
public class PlaceAspect extends NamedElementAspect {
  public static void initialize(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	_privk3_initialize(_self_, _self);
	;
}
  
  public static void push(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	_privk3_push(_self_, _self);
	;
}
  
  public static void pop(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	_privk3_pop(_self_, _self);
	;
}
  
  public static EList<Object> fifo(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_fifo(_self_, _self);
	;
	return (org.eclipse.emf.common.util.EList) result;
}
  
  public static void fifo(final Place _self, final EList<Object> fifo) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext.getSelf(_self);
    _privk3_fifo(_self_, _self,fifo);;
  }
  
  public static int currentSize(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_currentSize(_self_, _self);
	;
	return (int) result;
}
  
  public static void currentSize(final Place _self, final int currentSize) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	_privk3_currentSize(_self_, _self, currentSize);
	;
}
  
  public static boolean isInitialized(final Place _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_isInitialized(_self_, _self);
	;
	return (boolean) result;
}
  
  public static void isInitialized(final Place _self, final boolean isInitialized) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspectPlaceAspectContext
			.getSelf(_self);
	_privk3_isInitialized(_self_, _self, isInitialized);
	;
}
  
  protected static void _privk3_initialize(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    String _name = _self.getName();
    String _plus = ("place " + _name);
    String _plus_1 = (_plus + "is initializing");
    InputOutput.<String>println(_plus_1);
    EList<Object> _fifo = PlaceAspect.fifo(_self);
    _fifo.clear();
    int _delay = _self.getDelay();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _delay, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        Object initialObject = null;
        EList<Object> _fifo_1 = PlaceAspect.fifo(_self);
        _fifo_1.add(initialObject);
      }
    }
    EList<Object> _fifo_1 = PlaceAspect.fifo(_self);
    int _size = _fifo_1.size();
    PlaceAspect.currentSize(_self, _size);
  }
  
  protected static void _privk3_push(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    boolean _isInitialized = PlaceAspect.isInitialized(_self);
    boolean _not = (!_isInitialized);
    if (_not) {
      PlaceAspect.initialize(_self);
      PlaceAspect.isInitialized(_self, true);
    }
    OutputPort _itsOutputPort = _self.getItsOutputPort();
    OutputPort _itsOutputPort_1 = _self.getItsOutputPort();
    int _sizeWritten = OutputPortAspect.sizeWritten(_itsOutputPort_1);
    int _minus = (_sizeWritten - 1);
    OutputPortAspect.sizeWritten(_itsOutputPort, _minus);
    String _name = _self.getName();
    String _plus = (_name + "push");
    InputOutput.<String>println(_plus);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory = SystemAspect.sharedMemory(_system);
    String _plus_1 = ("sharedMemory: " + _sharedMemory);
    InputOutput.<String>println(_plus_1);
    EList<Object> fifo_view = PlaceAspect.fifo(_self);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_1 = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory_1 = SystemAspect.sharedMemory(_system_1);
    OutputPort _itsOutputPort_2 = _self.getItsOutputPort();
    String _name_1 = _itsOutputPort_2.getName();
    List _get = _sharedMemory_1.get(_name_1);
    final Object objTowrite = _get.get(0);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_2 = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory_2 = SystemAspect.sharedMemory(_system_2);
    OutputPort _itsOutputPort_3 = _self.getItsOutputPort();
    String _name_2 = _itsOutputPort_3.getName();
    _sharedMemory_2.remove(_name_2, objTowrite);
    EList<Object> _fifo = PlaceAspect.fifo(_self);
    _fifo.add(objTowrite);
    EList<Object> _fifo_1 = PlaceAspect.fifo(_self);
    int _size = _fifo_1.size();
    PlaceAspect.currentSize(_self, _size);
    EList<Object> _fifo_2 = PlaceAspect.fifo(_self);
    fifo_view = _fifo_2;
    InputOutput.<EList<Object>>println(fifo_view);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_3 = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory_3 = SystemAspect.sharedMemory(_system_3);
    String _plus_2 = ("sharedMemory: " + _sharedMemory_3);
    InputOutput.<String>println(_plus_2);
  }
  
  protected static void _privk3_pop(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    boolean _isInitialized = PlaceAspect.isInitialized(_self);
    boolean _not = (!_isInitialized);
    if (_not) {
      PlaceAspect.initialize(_self);
      PlaceAspect.isInitialized(_self, true);
    }
    String _name = _self.getName();
    String _plus = (_name + "pop");
    InputOutput.<String>println(_plus);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory = SystemAspect.sharedMemory(_system);
    String _plus_1 = ("sharedMemory: " + _sharedMemory);
    InputOutput.<String>println(_plus_1);
    EList<Object> _fifo = PlaceAspect.fifo(_self);
    InputOutput.<EList<Object>>println(_fifo);
    EList<Object> _fifo_1 = PlaceAspect.fifo(_self);
    final Object readedObject = _fifo_1.get(0);
    EList<Object> _fifo_2 = PlaceAspect.fifo(_self);
    _fifo_2.remove(0);
    EList<Object> _fifo_3 = PlaceAspect.fifo(_self);
    int _size = _fifo_3.size();
    PlaceAspect.currentSize(_self, _size);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_1 = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory_1 = SystemAspect.sharedMemory(_system_1);
    InputPort _itsInputPort = _self.getItsInputPort();
    String _name_1 = _itsInputPort.getName();
    _sharedMemory_1.put(_name_1, readedObject);
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_2 = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory_2 = SystemAspect.sharedMemory(_system_2);
    String _plus_2 = ("sharedMemory: " + _sharedMemory_2);
    InputOutput.<String>println(_plus_2);
  }
  
  protected static EList<Object> _privk3_fifo(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFifo") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (org.eclipse.emf.common.util.EList) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.fifo;
  }
  
  protected static void _privk3_fifo(final PlaceAspectPlaceAspectProperties _self_, final Place _self, final EList<Object> fifo) {
    _self_.fifo = fifo; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setFifo")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, fifo);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static int _privk3_currentSize(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCurrentSize") &&
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
    return _self_.currentSize;
  }
  
  protected static void _privk3_currentSize(final PlaceAspectPlaceAspectProperties _self_, final Place _self, final int currentSize) {
    _self_.currentSize = currentSize; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setCurrentSize")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, currentSize);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static boolean _privk3_isInitialized(final PlaceAspectPlaceAspectProperties _self_, final Place _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getIsInitialized") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (boolean) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.isInitialized;
  }
  
  protected static void _privk3_isInitialized(final PlaceAspectPlaceAspectProperties _self_, final Place _self, final boolean isInitialized) {
    _self_.isInitialized = isInitialized; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setIsInitialized")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, isInitialized);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
