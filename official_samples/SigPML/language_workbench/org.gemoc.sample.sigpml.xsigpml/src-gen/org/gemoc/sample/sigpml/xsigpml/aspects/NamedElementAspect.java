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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.gemoc.sample.sigpml.xsigpml.sigpml.NamedElement;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedListMultimap;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;

@Aspect(className = NamedElement.class)
@SuppressWarnings("all")
public abstract class NamedElementAspect {
  public static org.gemoc.sample.sigpml.xsigpml.sigpml.System getSystem(final NamedElement _self) {
	final org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspectNamedElementAspectProperties _self_ = org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspectNamedElementAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_getSystem(_self_, _self);
	;
	return (org.gemoc.sample.sigpml.xsigpml.sigpml.System) result;
}
  
  protected static org.gemoc.sample.sigpml.xsigpml.sigpml.System _privk3_getSystem(final NamedElementAspectNamedElementAspectProperties _self_, final NamedElement _self) {
    Resource _eResource = _self.eResource();
    EList<EObject> contents = _eResource.getContents();
    final Function1<EObject, Boolean> _function = (EObject x) -> {
      return Boolean.valueOf((x instanceof org.gemoc.sample.sigpml.xsigpml.sigpml.System));
    };
    EObject _findFirst = IterableExtensions.<EObject>findFirst(contents, _function);
    final org.gemoc.sample.sigpml.xsigpml.sigpml.System system = ((org.gemoc.sample.sigpml.xsigpml.sigpml.System) _findFirst);
    if (((!Objects.equal(system, null)) && Objects.equal(SystemAspect.sharedMemory(system), null))) {
      LinkedListMultimap<Object, Object> _create = LinkedListMultimap.<Object, Object>create();
      SystemAspect.sharedMemory(system, _create);
    }
    return system;
  }
}
