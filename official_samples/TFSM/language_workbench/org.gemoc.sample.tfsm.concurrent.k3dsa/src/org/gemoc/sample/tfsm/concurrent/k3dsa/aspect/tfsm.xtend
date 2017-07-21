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
package org.gemoc.sample.tfsm.concurrent.k3dsa.aspect

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.gemoc.sample.tfsm.concurrent.tfsm.EvaluateGuard
import org.gemoc.sample.tfsm.concurrent.tfsm.EventGuard
import org.gemoc.sample.tfsm.concurrent.tfsm.FSMClock
import org.gemoc.sample.tfsm.concurrent.tfsm.FSMEvent
import org.gemoc.sample.tfsm.concurrent.tfsm.Guard
import org.gemoc.sample.tfsm.concurrent.tfsm.NamedElement
import org.gemoc.sample.tfsm.concurrent.tfsm.State
import org.gemoc.sample.tfsm.concurrent.tfsm.TFSM
import org.gemoc.sample.tfsm.concurrent.tfsm.TemporalGuard
import org.gemoc.sample.tfsm.concurrent.tfsm.TimedSystem
import org.gemoc.sample.tfsm.concurrent.tfsm.Transition
import org.gemoc.sample.tfsm.concurrent.k3dsa.GroovyRunner


import static extension org.gemoc.sample.tfsm.concurrent.k3dsa.aspect.TFSMAspect.*
import groovy.lang.GroovyShell
import java.util.Map
import groovy.lang.Binding


@Aspect(className=TFSM)
class TFSMAspect extends NamedElementAspect {
	// should be added automatically by the dsa, currently introduced directly in the ecore
	public State currentState;

	def public String initialize() {
		if (_self.currentState == null) {

			_self.currentState = _self.initialState;
		}
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
	
	def public void changeCurrentState(State newState)
	{
		_self.currentState = newState
	}
		
}

@Aspect(className=State)
class StateAspect extends NamedElementAspect {
	def public String onEnter() {
		_self.owningFSM.currentState = _self;
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onEnter()]Entering " + _self.name);
		
	}

	def public String onLeave() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onLeave()]Leaving " + _self.name);
	}
}

@Aspect(className=Transition)
class TransitionAspect extends NamedElementAspect {
	def public String fire() {
		if(_self.action!= null && !_self.action.empty){		
			//GroovyRunner.executeScript(_self.action, _self);
			var Object res;
			try {	
				// add variables _self and _this for use in the expression
				val binding = new Binding
				binding.setVariable("_self", _self)
				binding.setVariable("_this", _self)		
				val ucl = EvaluateGuardAspect.classLoader
				val shell = new GroovyShell(ucl, binding)
		
				res = shell.evaluate(_self.action) as Map<String, Object>
		
			} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
				println("Failed to call Groovy script" + cnfe.message)
				cnfe.printStackTrace
			}	
		}
		_self.source.owningFSM.currentState = null
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".fire()]Fired " + _self.name + " -> " +
			_self.action)
	}
}

@Aspect(className=NamedElement)
class NamedElementAspect {
}

@Aspect(className=Guard)
abstract class GuardAspect extends NamedElementAspect {
}

@Aspect(className=TemporalGuard)
class TemporalGuardAspect extends GuardAspect {
}

@Aspect(className=EventGuard)
class EventGuardAspect extends GuardAspect {
}

@Aspect(className=FSMEvent)
class FSMEventAspect extends NamedElementAspect {
	def public String occurs() {
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".occurs()]Occured " )
	}
}

@Aspect(className=FSMClock)
class FSMClockAspect extends NamedElementAspect {
	
	public int numberOfTicks

	// Clock tick
	def public String ticks() {
		_self.numberOfTicks = _self.numberOfTicks + 1
		
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".ticks()]New number of ticks : " +
			_self.numberOfTicks.toString())
	}
}

@Aspect(className=TimedSystem)
class TimedSystemAspect extends NamedElementAspect {
	def public String initialize() {
		_self.tfsms.forEach[tfsm | tfsm.currentState = null]
		_self.globalClocks.forEach[globalClock | globalClock.numberOfTicks = 0]
		
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
}

@Aspect(className=EvaluateGuard)
class EvaluateGuardAspect extends GuardAspect {
	def public boolean evaluate() {
		var Object res;
		try {	
			// add variables _self and _this for use in the expression
			val binding = new Binding
			binding.setVariable("_self", _self)
			binding.setVariable("_this", _self)		
			val ucl = EvaluateGuardAspect.classLoader
			val shell = new GroovyShell(ucl, binding)
	
			res = shell.evaluate(_self.condition) as Map<String, Object>
	
		} catch (org.codehaus.groovy.control.MultipleCompilationErrorsException cnfe) {
			println("Failed to call Groovy script" + cnfe.message)
			cnfe.printStackTrace
		}

		return res as Boolean;
	}
}
