package org.gemoc.sample.legacyfsm.fsm.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step

import org.gemoc.sample.legacyfsm.fsm.TimeFSM
import org.gemoc.sample.legacyfsm.fsm.State
import org.gemoc.sample.legacyfsm.fsm.Transition
import org.gemoc.sample.legacyfsm.fsm.NamedElement
import org.gemoc.sample.legacyfsm.fsm.Guard
import org.gemoc.sample.legacyfsm.fsm.TemporalGuard
import org.gemoc.sample.legacyfsm.fsm.EventGuard
import org.gemoc.sample.legacyfsm.fsm.FSMEvent
import org.gemoc.sample.legacyfsm.fsm.FSMClock
import org.gemoc.sample.legacyfsm.fsm.TimedSystem
import org.gemoc.sample.legacyfsm.fsm.EvaluateGuard

import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.FSMClockAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.FSMClockVisitorAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.FSMEventAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.GuardVisitorAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.StateAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.StateVisitorAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.TimeFSMAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.TimeFSMVisitorAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.TransitionAspect.*
import static extension org.gemoc.sample.legacyfsm.fsm.k3dsa.TransitionVisitorAspect.*

@Aspect(className=TimedSystem)
class TimedSystemVisitorAspect {
	def public void visit() {
		_self.globalClocks.forEach[e|e.visit()]
		_self.fsms.forEach[t|t.visit()]
	}
}

@Aspect(className=TimeFSM)
class TimeFSMVisitorAspect {

	public int stepNumber = 0
	public int lastStateChangeStepNumber = 0

	def public void visit() {
		println()
		println("Step " + _self.stepNumber + " - current state: " + _self.getCurrentStateName())
		if(_self.localClock != null) {
			_self.localClock.visit()
		}
		_self.currentState.visit()
		_self.stepNumber = _self.stepNumber + 1
	}

	private def String getCurrentStateName() {
		var s = "null"
		if(_self.currentState != null) {
			s = _self.currentState.name
		}
		return s
	}
}

@Aspect(className=FSMClock)
class FSMClockVisitorAspect {
	def public void visit() {
		_self.ticks
	}
}

@Aspect(className=State)
class StateVisitorAspect {
	@Step
	def public void visit() {
		_self.onEnter
		_self.outgoingTransitions.forEach[t|t.visit()]
		_self.onLeave
	}
}

@Aspect(className=Transition)
class TransitionVisitorAspect {
	@Step
	def public void visit() {
		if(_self.ownedGuard != null) {
			_self.ownedGuard.visit()
		}
	}
}

@Aspect(className=Guard)
abstract class GuardVisitorAspect {
	abstract def public void visit()

	protected def void fireTransition() {
		val transitionToFire = _self.eContainer as Transition
		println("fire transition " + transitionToFire.name)
		transitionToFire.fire
		_self.saveLastStateChangeStepNumber
	}

	protected def int lastStateChangeStepNumber() {
		val fsm = _self.eContainer.eContainer as TimeFSM
		return fsm.lastStateChangeStepNumber
	}

	protected def void saveLastStateChangeStepNumber() {
		val fsm = _self.eContainer.eContainer as TimeFSM
		fsm.lastStateChangeStepNumber = fsm.stepNumber
	}
}

@Aspect(className=TemporalGuard)
class TemporalGuardVisitorAspect extends GuardVisitorAspect {
	def public void visit() {
		if((_self.afterDuration + _self.lastStateChangeStepNumber) == _self.onClock.numberOfTicks) {
			_self.fireTransition()
		}
	}
}

@Aspect(className=EventGuard)
class EventGuardVisitorAspect extends GuardVisitorAspect {
	def public void visit() {
		if(_self.triggeringEvent.isTriggered) {
			_self.fireTransition()
		}
	}
}
