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
package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.util.Map;
import org.codehaus.groovy.control.MultipleCompilationErrorsException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EvaluateGuardAspectEvaluateGuardAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EvaluateGuard;

@Aspect(className = EvaluateGuard.class)
@SuppressWarnings("all")
public class EvaluateGuardAspect extends GuardAspect {
  public static boolean evaluate(final EvaluateGuard _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EvaluateGuardAspectEvaluateGuardAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.EvaluateGuardAspectEvaluateGuardAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_evaluate(_self_, _self);
	;
	return (boolean) result;
}
  
  protected static boolean _privk3_evaluate(final EvaluateGuardAspectEvaluateGuardAspectProperties _self_, final EvaluateGuard _self) {
    Object res = null;
    try {
      final Binding binding = new Binding();
      binding.setVariable("_self", _self);
      binding.setVariable("_this", _self);
      final ClassLoader ucl = EvaluateGuardAspect.class.getClassLoader();
      final GroovyShell shell = new GroovyShell(ucl, binding);
      String _condition = _self.getCondition();
      Object _evaluate = shell.evaluate(_condition);
      res = ((Map<String, Object>) _evaluate);
    } catch (final Throwable _t) {
      if (_t instanceof MultipleCompilationErrorsException) {
        final MultipleCompilationErrorsException cnfe = (MultipleCompilationErrorsException)_t;
        String _message = cnfe.getMessage();
        String _plus = ("Failed to call Groovy script" + _message);
        InputOutput.<String>println(_plus);
        cnfe.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return (((Boolean) res)).booleanValue();
  }
}
