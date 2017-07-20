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
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TimedSystem;

@Aspect(className = TimedSystem.class)
@SuppressWarnings("all")
public class TimedSystemAspect extends NamedElementAspect {
  public static String initialize(final TimedSystem _self) {
	final org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TimedSystemAspectTimedSystemAspectProperties _self_ = org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TimedSystemAspectTimedSystemAspectContext
			.getSelf(_self);
	Object result = null;
	result = _privk3_initialize(_self_, _self);
	;
	return (java.lang.String) result;
}
  
  protected static String _privk3_initialize(final TimedSystemAspectTimedSystemAspectProperties _self_, final TimedSystem _self) {
    String _xblockexpression = null;
    {
      EList<TFSM> _tfsms = _self.getTfsms();
      final Consumer<TFSM> _function = (TFSM tfsm) -> {
        TFSMAspect.currentState(tfsm, null);
      };
      _tfsms.forEach(_function);
      EList<FSMClock> _globalClocks = _self.getGlobalClocks();
      final Consumer<FSMClock> _function_1 = (FSMClock globalClock) -> {
        globalClock.setNumberOfTicks(0);
      };
      _globalClocks.forEach(_function_1);
      Class<? extends TimedSystem> _class = _self.getClass();
      String _simpleName = _class.getSimpleName();
      String _plus = ("[" + _simpleName);
      String _plus_1 = (_plus + ":");
      String _name = _self.getName();
      String _plus_2 = (_plus_1 + _name);
      String _plus_3 = (_plus_2 + ".Init()]Initialized ");
      String _name_1 = _self.getName();
      String _plus_4 = (_plus_3 + _name_1);
      _xblockexpression = InputOutput.<String>println(_plus_4);
    }
    return _xblockexpression;
  }
}
