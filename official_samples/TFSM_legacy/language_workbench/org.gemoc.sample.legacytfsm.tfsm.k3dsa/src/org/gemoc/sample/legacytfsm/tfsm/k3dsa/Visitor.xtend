package org.gemoc.sample.legacytfsm.tfsm.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import fr.inria.diverse.k3.al.annotationprocessor.Step

import org.gemoc.sample.legacytfsm.tfsm.TimedFSM
import org.gemoc.sample.legacytfsm.tfsm.State
import org.gemoc.sample.legacytfsm.tfsm.Transition
import org.gemoc.sample.legacytfsm.tfsm.NamedElement
import org.gemoc.sample.legacytfsm.tfsm.Guard
import org.gemoc.sample.legacytfsm.tfsm.TemporalGuard
import org.gemoc.sample.legacytfsm.tfsm.EventGuard
import org.gemoc.sample.legacytfsm.tfsm.FSMEvent
import org.gemoc.sample.legacytfsm.tfsm.FSMClock
import org.gemoc.sample.legacytfsm.tfsm.TimedSystem
import org.gemoc.sample.legacytfsm.tfsm.EvaluateGuard

import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.FSMClockAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.FSMClockVisitorAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.FSMEventAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.GuardVisitorAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.StateAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.StateVisitorAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TimedFSMAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TimedFSMVisitorAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TransitionAspect.*
import static extension org.gemoc.sample.legacytfsm.tfsm.k3dsa.TransitionVisitorAspect.*

@Aspect(className=TimedSystem)
class TimedSystemVisitorAspect {
	def public void visit() {
		_self.globalClocks.forEach[e|e.visit()]
		_self.tfsms.forEach[t|t.visit()]
	}
}

@Aspect(className=TimedFSM)
class TimedFSMVisitorAspect {

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
		val tfsm = _self.eContainer.eContainer as TimedFSM
		return tfsm.lastStateChangeStepNumber
	}

	protected def void saveLastStateChangeStepNumber() {
		val tfsm = _self.eContainer.eContainer as TimedFSM
		tfsm.lastStateChangeStepNumber = tfsm.stepNumber
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
