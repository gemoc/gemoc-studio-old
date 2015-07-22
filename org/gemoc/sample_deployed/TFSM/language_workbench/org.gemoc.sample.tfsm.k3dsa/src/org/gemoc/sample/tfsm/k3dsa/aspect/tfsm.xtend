package org.gemoc.sample.tfsm.k3dsa.aspect

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import org.gemoc.sample.tfsm.EvaluateGuard
import org.gemoc.sample.tfsm.EventGuard
import org.gemoc.sample.tfsm.FSMClock
import org.gemoc.sample.tfsm.FSMEvent
import org.gemoc.sample.tfsm.Guard
import org.gemoc.sample.tfsm.NamedElement
import org.gemoc.sample.tfsm.State
import org.gemoc.sample.tfsm.TFSM
import org.gemoc.sample.tfsm.TemporalGuard
import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.Transition
import org.gemoc.sample.tfsm.k3dsa.GroovyRunner


import static extension org.gemoc.sample.tfsm.k3dsa.aspect.TFSMAspect.*
/*import static extension org.gemoc.sample.tfsm.k3dsa.aspect.StateAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.TransitionAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.NamedElementAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.GuardAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.TemporalGuardAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.EventGuardAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.FSMEventAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.FSMClockAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.TimedSystemAspect.*
import static extension org.gemoc.sample.tfsm.k3dsa.aspect.EvaluateGuardAspect.*
*/

@Aspect(className=TFSM)
class TFSMAspect extends NamedElementAspect {
	// should be added automatically by the dsa, currently introduced directly in the ecore
	public State currentState;

	def public String init() {
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
		GroovyRunner.executeScript(_self.action, _self);
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
	//public Integer numberOfTicks;
	public int numberOfTicks

	// Clock tick
	def public String ticks() {
		GroovyRunner.executeScript("doTick", _self);

		//if (_self.numberOfTicks == null) {
		//	_self.numberOfTicks = 0
		//} else {
			_self.numberOfTicks = _self.numberOfTicks + 1
		//}
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".ticks()]New number of ticks : " +
			_self.numberOfTicks.toString())
	}
}

@Aspect(className=TimedSystem)
class TimedSystemAspect extends NamedElementAspect {
	def public String init() {
		_self.tfsms.forEach[tfsm | tfsm.currentState = null]
		_self.globalClocks.forEach[globalClock | globalClock.numberOfTicks = 0]
		
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name);
	}
}

@Aspect(className=EvaluateGuard)
class EvaluateGuardAspect extends GuardAspect {
	def public boolean evaluate() {
		var Object res;
		res = GroovyRunner.executeScript(_self.condition, _self)

		return res as Boolean;
	}
}
