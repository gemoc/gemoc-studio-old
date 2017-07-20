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

import cnrs.luchogie.up.SwingPlotter;
import cnrs.luchogie.up.data.Figure;
import com.google.common.collect.LinkedListMultimap;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Port;
import org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties;
import org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspect;
import org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect;
import org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect;
import org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspect;

@Aspect(className = Agent.class)
@SuppressWarnings("all")
public class AgentAspect extends NamedElementAspect {
  public static void isExecuting(final Agent _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext
			.getSelf(_self);
	_privk3_isExecuting(_self_, _self);
	;
}
  
  public static void stop(final Agent _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext
			.getSelf(_self);
	_privk3_stop(_self_, _self);
	;
}
  
  public static void execute(final Agent _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext
			.getSelf(_self);
	_privk3_execute(_self_, _self);
	;
}
  
  private static SwingPlotter plotter(final Agent _self) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_plotter(_self_, _self);;
    return (cnrs.luchogie.up.SwingPlotter)result;
  }
  
  private static void plotter(final Agent _self, final SwingPlotter plotter) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    _privk3_plotter(_self_, _self,plotter);;
  }
  
  private static JFrame frame(final Agent _self) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_frame(_self_, _self);;
    return (javax.swing.JFrame)result;
  }
  
  private static void frame(final Agent _self, final JFrame frame) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    _privk3_frame(_self_, _self,frame);;
  }
  
  private static Figure figure(final Agent _self) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_figure(_self_, _self);;
    return (cnrs.luchogie.up.data.Figure)result;
  }
  
  private static void figure(final Agent _self, final Figure figure) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    _privk3_figure(_self_, _self,figure);;
  }
  
  private static boolean hasBeenStopped(final Agent _self) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    Object result = null;
    result = _privk3_hasBeenStopped(_self_, _self);;
    return (boolean)result;
  }
  
  private static void hasBeenStopped(final Agent _self, final boolean hasBeenStopped) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext.getSelf(_self);
    _privk3_hasBeenStopped(_self_, _self,hasBeenStopped);;
  }
  
  public static boolean isCurrentlyExecuting(final Agent _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_isCurrentlyExecuting(_self_, _self);
	;
	return (boolean) result;
}
  
  public static void isCurrentlyExecuting(final Agent _self, final boolean isCurrentlyExecuting) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectContext
			.getSelf(_self);
	_privk3_isCurrentlyExecuting(_self_, _self, isCurrentlyExecuting);
	;
}
  
  protected static void _privk3_isExecuting(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    String _name = _self.getName();
    String _plus = (_name + "\n      isExecuting (");
    int _currentExecCycle = _self.getCurrentExecCycle();
    String _plus_1 = (_plus + Integer.valueOf(_currentExecCycle));
    String _plus_2 = (_plus_1 + ")");
    InputOutput.<String>println(_plus_2);
    if (((_self.getCurrentExecCycle() <= _self.getCycles()) && (!AgentAspect.hasBeenStopped(_self)))) {
      int _currentExecCycle_1 = _self.getCurrentExecCycle();
      int _plus_3 = (_currentExecCycle_1 + 1);
      _self.setCurrentExecCycle(_plus_3);
    }
  }
  
  protected static void _privk3_stop(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    String _name = _self.getName();
    String _plus = (_name + "\n      stop(");
    int _currentExecCycle = _self.getCurrentExecCycle();
    String _plus_1 = (_plus + Integer.valueOf(_currentExecCycle));
    String _plus_2 = (_plus_1 + ")");
    InputOutput.<String>println(_plus_2);
    _self.setCurrentExecCycle(0);
    AgentAspect.hasBeenStopped(_self, true);
  }
  
  protected static void _privk3_execute(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    AgentAspect.hasBeenStopped(_self, false);
    String _name = _self.getName();
    String _plus = (_name + "\n      execute (");
    int _currentExecCycle = _self.getCurrentExecCycle();
    String _plus_1 = (_plus + Integer.valueOf(_currentExecCycle));
    String _plus_2 = (_plus_1 + ")");
    InputOutput.<String>println(_plus_2);
    int _currentExecCycle_1 = _self.getCurrentExecCycle();
    String _plus_3 = ("@ : " + Integer.valueOf(_currentExecCycle_1));
    String _plus_4 = (_plus_3 + " sharedMemory:");
    org.gemoc.sample.sigpml.xsigpml.sigpml.System _system = NamedElementAspect.getSystem(_self);
    LinkedListMultimap _sharedMemory = SystemAspect.sharedMemory(_system);
    String _plus_5 = (_plus_4 + _sharedMemory);
    InputOutput.<String>println(_plus_5);
    final ArrayList<String> outputPortNames = CollectionLiterals.<String>newArrayList();
    JFrame _frame = AgentAspect.frame(_self);
    SwingPlotter _plotter = AgentAspect.plotter(_self);
    _frame.setContentPane(_plotter);
    JFrame _frame_1 = AgentAspect.frame(_self);
    _frame_1.setSize(400, 400);
    final Binding binding = new Binding();
    SwingPlotter _plotter_1 = AgentAspect.plotter(_self);
    binding.setVariable("plotter", _plotter_1);
    JFrame _frame_2 = AgentAspect.frame(_self);
    binding.setVariable("frame", _frame_2);
    HWComputationalResource _allocatedTo = _self.getAllocatedTo();
    final int localTime = HWComputationalResourceAspect.currentExecCycle(_allocatedTo);
    binding.setVariable("localTime", Integer.valueOf(localTime));
    Figure _figure = AgentAspect.figure(_self);
    binding.setVariable("figure", _figure);
    EList<Port> _ownedPorts = _self.getOwnedPorts();
    for (final Port p : _ownedPorts) {
      if ((p instanceof InputPort)) {
        final ArrayList<Object> params = CollectionLiterals.<Object>newArrayList();
        int _rate = ((InputPort)p).getRate();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _rate, true);
        for (final Integer i : _doubleDotLessThan) {
          {
            org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_1 = NamedElementAspect.getSystem(_self);
            LinkedListMultimap _sharedMemory_1 = SystemAspect.sharedMemory(_system_1);
            String _plus_6 = ("start for rate params sharedMemory: " + _sharedMemory_1);
            InputOutput.<String>println(_plus_6);
            org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_2 = NamedElementAspect.getSystem(_self);
            LinkedListMultimap _sharedMemory_2 = SystemAspect.sharedMemory(_system_2);
            String _name_1 = ((InputPort)p).getName();
            List _get = _sharedMemory_2.get(_name_1);
            final Object tmp = _get.get(0);
            params.add(tmp);
            org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_3 = NamedElementAspect.getSystem(_self);
            LinkedListMultimap _sharedMemory_3 = SystemAspect.sharedMemory(_system_3);
            String _name_2 = ((InputPort)p).getName();
            _sharedMemory_3.remove(_name_2, tmp);
            org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_4 = NamedElementAspect.getSystem(_self);
            LinkedListMultimap _sharedMemory_4 = SystemAspect.sharedMemory(_system_4);
            String _plus_7 = ("end for rate params sharedMemory: " + _sharedMemory_4);
            InputOutput.<String>println(_plus_7);
          }
        }
        InputOutput.<String>println(("   in params: " + params));
        String _name_1 = ((InputPort)p).getName();
        binding.setVariable(_name_1, params);
      } else {
        String _name_2 = p.getName();
        outputPortNames.add(_name_2);
      }
    }
    EList<Port> _ownedPorts_1 = _self.getOwnedPorts();
    for (final Port p_1 : _ownedPorts_1) {
      if ((p_1 instanceof InputPort)) {
        InputPortAspect.sizeToread(((InputPort)p_1), 0);
      }
    }
    try {
      final ClassLoader ucl = AgentAspect.class.getClassLoader();
      final GroovyShell shell = new GroovyShell(ucl, binding);
      String _code = _self.getCode();
      Object _evaluate = shell.evaluate(_code);
      final Map<String, Object> res = ((Map<String, Object>) _evaluate);
      boolean _containsValue = res.containsValue("figure");
      if (_containsValue) {
        Figure _figure_1 = AgentAspect.figure(_self);
        Object _get = res.get("figure");
        _figure_1.addFigure(((Figure) _get));
      }
      for (final String portName : outputPortNames) {
        org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_1 = NamedElementAspect.getSystem(_self);
        LinkedListMultimap _sharedMemory_1 = SystemAspect.sharedMemory(_system_1);
        Object _get_1 = res.get(portName);
        _sharedMemory_1.put(portName, _get_1);
      }
      org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_2 = NamedElementAspect.getSystem(_self);
      LinkedListMultimap _sharedMemory_2 = SystemAspect.sharedMemory(_system_2);
      String _plus_6 = ("sharedMemory: " + _sharedMemory_2);
      InputOutput.<String>println(_plus_6);
    } catch (final Throwable _t) {
      if (_t instanceof MultipleCompilationErrorsException) {
        final MultipleCompilationErrorsException cnfe = (MultipleCompilationErrorsException)_t;
        String _message = cnfe.getMessage();
        String _plus_7 = ("Failed to call Groovy script" + _message);
        InputOutput.<String>println(_plus_7);
        InputOutput.<String>println("figure not correctly updated");
        InputOutput.<String>println("using default values for system.sharedMemory instead of computed ones");
        for (final String portName_1 : outputPortNames) {
          org.gemoc.sample.sigpml.xsigpml.sigpml.System _system_3 = NamedElementAspect.getSystem(_self);
          LinkedListMultimap _sharedMemory_3 = SystemAspect.sharedMemory(_system_3);
          _sharedMemory_3.put(portName_1, Double.valueOf(0.0));
        }
        cnfe.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected static SwingPlotter _privk3_plotter(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getPlotter") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (cnrs.luchogie.up.SwingPlotter) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.plotter;
  }
  
  protected static void _privk3_plotter(final AgentAspectAgentAspectProperties _self_, final Agent _self, final SwingPlotter plotter) {
    _self_.plotter = plotter; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setPlotter")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, plotter);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static JFrame _privk3_frame(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFrame") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (javax.swing.JFrame) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.frame;
  }
  
  protected static void _privk3_frame(final AgentAspectAgentAspectProperties _self_, final Agent _self, final JFrame frame) {
    _self_.frame = frame; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setFrame")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, frame);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static Figure _privk3_figure(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getFigure") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (cnrs.luchogie.up.data.Figure) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.figure;
  }
  
  protected static void _privk3_figure(final AgentAspectAgentAspectProperties _self_, final Agent _self, final Figure figure) {
    _self_.figure = figure; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setFigure")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, figure);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static boolean _privk3_hasBeenStopped(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getHasBeenStopped") &&
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
    return _self_.hasBeenStopped;
  }
  
  protected static void _privk3_hasBeenStopped(final AgentAspectAgentAspectProperties _self_, final Agent _self, final boolean hasBeenStopped) {
    _self_.hasBeenStopped = hasBeenStopped; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setHasBeenStopped")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, hasBeenStopped);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
  
  protected static boolean _privk3_isCurrentlyExecuting(final AgentAspectAgentAspectProperties _self_, final Agent _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getIsCurrentlyExecuting") &&
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
    return _self_.isCurrentlyExecuting;
  }
  
  protected static void _privk3_isCurrentlyExecuting(final AgentAspectAgentAspectProperties _self_, final Agent _self, final boolean isCurrentlyExecuting) {
    _self_.isCurrentlyExecuting = isCurrentlyExecuting; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setIsCurrentlyExecuting")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, isCurrentlyExecuting);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
