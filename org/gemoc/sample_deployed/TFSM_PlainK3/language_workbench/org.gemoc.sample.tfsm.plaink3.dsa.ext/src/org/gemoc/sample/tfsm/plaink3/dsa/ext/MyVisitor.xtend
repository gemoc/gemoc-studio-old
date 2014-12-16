package org.gemoc.sample.tfsm.plaink3.dsa.ext

import static extension org.gemoc.sample.tfsm.plaink3.dsa.StateAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TFSMAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TransitionAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.FSMClockAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.FSMEventAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.GuardAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TemporalGuardAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.EventGuardAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.IVisitor.*
import org.gemoc.sample.tfsm.plaink3.dsa.IVisitor
import org.gemoc.sample.tfsm.Transition
import org.gemoc.sample.tfsm.TFSM
import org.gemoc.sample.tfsm.State
import org.gemoc.sample.tfsm.Guard
import org.gemoc.sample.tfsm.TemporalGuard
import org.gemoc.sample.tfsm.EventGuard
import org.gemoc.sample.tfsm.EvaluateGuard
import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.FSMClock

//import static extension org.gemoc.sample.tfsm.k3dsa.EvaluateGuardAspect.*


public class MyVisitor implements IVisitor {

	private int _stepNumber = 0
	
	private int _lastStateChangeStepNumber = 0
	
	override beginVisit(TFSM tfsm) 
	{
		println()
		println("Step " + _stepNumber + " - current state: " + getCurrentStateName(tfsm))		
	}
	override endVisit(TFSM tfsm) 
	{
 		_stepNumber++
	}
	
	private def String getCurrentStateName(TFSM tfsm)
	{
		var s = "null"
		if (tfsm.currentState != null)
		{
			s = tfsm.currentState.name
		}
		return s
	}
	
	override beginVisit(FSMClock clock) 
	{
		clock.ticks
	}
	override endVisit(FSMClock clock) 
	{
	}
	
		
	override beginVisit(State state) 
	{
		state.onEnter
	}
	override endVisit(State state) 
	{
		state.onLeave
	}
		
	override beginVisit(Transition transition) 
	{
	}
	override endVisit(Transition transition) 
	{
	}
		
	override beginVisit(TemporalGuard guard) 
	{
 		if ((guard.afterDuration + _lastStateChangeStepNumber) == guard.onClock.numberOfTicks)
 		{
			fireTransition(guard)
 		}
	}
	override endVisit(TemporalGuard guard) 
	{
	}
		
	override beginVisit(EventGuard guard) 
	{
 		if (guard.triggeringEvent.isTriggered)
 		{
			fireTransition(guard)
 		}
	}
	override endVisit(EventGuard guard) 
	{
	}

	private def fireTransition(Guard guard)
	{
		val transitionToFire = guard.eContainer as Transition
		println("fire transition " + transitionToFire.name)
		transitionToFire.fire 			
		_lastStateChangeStepNumber = _stepNumber	
	}
		
	override beginVisit(EvaluateGuard guard) 
	{
	}
	override endVisit(EvaluateGuard guard) 
	{
	}
	
	override beginVisit(TimedSystem system) 
	{
	}
	override endVisit(TimedSystem system) 
	{
	}
	
}

