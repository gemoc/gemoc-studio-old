package org.gemoc.sigpmlextended.k3dsa;

import com.google.common.base.Objects;
import com.google.common.collect.LinkedListMultimap;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import sigpmlextended.NamedElement;
import org.gemoc.sigpmlextended.k3dsa.NamedElementAspectNamedElementAspectProperties;
import org.gemoc.sigpmlextended.k3dsa.SystemAspect;

@Aspect(className = NamedElement.class)
@SuppressWarnings("all")
public abstract class NamedElementAspect {
  public static sigpmlextended.System getSystem(final NamedElement _self) {
    _self_ = org.gemoc.sigpmlextended.k3dsa.NamedElementAspectNamedElementAspectContext.getSelf(_self);
    Object result = null;
    result =_privk3_getSystem(_self);
    return (sigpmlextended.System)result;
  }
  
  public static NamedElementAspectNamedElementAspectProperties _self_;
  
  protected static sigpmlextended.System _privk3_getSystem(final NamedElement _self) {
    Resource _eResource = _self.eResource();
    EList<EObject> contents = _eResource.getContents();
    final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
      public Boolean apply(final EObject x) {
        return Boolean.valueOf((x instanceof sigpmlextended.System));
      }
    };
    EObject _findFirst = IterableExtensions.<EObject>findFirst(contents, _function);
    final sigpmlextended.System system = ((sigpmlextended.System) _findFirst);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(system, null));
    if (!_notEquals) {
      _and = false;
    } else {
      LinkedListMultimap _sharedMemory = SystemAspect.sharedMemory(system);
      boolean _equals = Objects.equal(_sharedMemory, null);
      _and = _equals;
    }
    if (_and) {
      LinkedListMultimap<Object, Object> _create = LinkedListMultimap.<Object, Object>create();
      SystemAspect.sharedMemory(system, _create);
    }
    return system;
  }
}
