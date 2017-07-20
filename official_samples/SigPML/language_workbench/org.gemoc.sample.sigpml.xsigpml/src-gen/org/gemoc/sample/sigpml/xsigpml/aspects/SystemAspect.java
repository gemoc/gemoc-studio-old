/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.sigpml.xsigpml.aspects;

import org.eclipse.emf.common.util.EList;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Place;

import com.google.common.collect.LinkedListMultimap;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import fr.inria.diverse.k3.al.annotationprocessor.InitializeModel;

@Aspect(className = org.gemoc.sample.sigpml.xsigpml.sigpml.System.class)
@SuppressWarnings("all")
public class SystemAspect {
  @InitializeModel
  public static void initializeModel(final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self, final EList<String> args) {
    final org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectContext.getSelf(_self);
    _privk3_initializeModel(_self_, _self,args);;
  }
  
  public static LinkedListMultimap sharedMemory(final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_sharedMemory(_self_, _self);
	;
	return (com.google.common.collect.LinkedListMultimap) result;
}
  
  public static void sharedMemory(final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self, final LinkedListMultimap sharedMemory) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectContext
			.getSelf(_self);
	_privk3_sharedMemory(_self_, _self, sharedMemory);
	;
}
  
  protected static void _privk3_initializeModel(final SystemAspectSystemAspectProperties _self_, final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self, final EList<String> args) {
    Application _ownedApplication = _self.getOwnedApplication();
    EList<Place> _ownedPlaces = _ownedApplication.getOwnedPlaces();
    for (final Place place : _ownedPlaces) {
      PlaceAspect.initialize(place);
    }
  }
  
  protected static LinkedListMultimap _privk3_sharedMemory(final SystemAspectSystemAspectProperties _self_, final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getSharedMemory") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (com.google.common.collect.LinkedListMultimap) ret;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.sharedMemory;
  }
  
  protected static void _privk3_sharedMemory(final SystemAspectSystemAspectProperties _self_, final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self, final LinkedListMultimap sharedMemory) {
    _self_.sharedMemory = sharedMemory; try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("setSharedMemory")
    				&& m.getParameterTypes().length == 1) {
    			m.invoke(_self, sharedMemory);
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
  }
}
