package org.gemoc.sample.tfsm.purek3.dsa.ext

import static extension org.gemoc.sample.tfsm.purek3.dsa.StateAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.TransitionAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.GuardAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspect.*
import static extension org.gemoc.sample.tfsm.purek3.dsa.IVisitor.*
import org.gemoc.sample.tfsm.purek3.dsa.IVisitor
import org.gemoc.sample.tfsm.Transition
import org.gemoc.sample.tfsm.TFSM
import org.gemoc.sample.tfsm.State
import org.gemoc.sample.tfsm.TemporalGuard
import org.gemoc.sample.tfsm.EventGuard
import org.gemoc.sample.tfsm.EvaluateGuard
import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.FSMClock

//import static extension org.gemoc.sample.tfsm.k3dsa.EvaluateGuardAspect.*


public class MyVisitor implements IVisitor {

	private int _stepNumber = 0
	
	private int _lastStateChangeStepNumber = 0
	
	private def boolean isFirstExecutionStep()
	{
		return _stepNumber == 0
	}
	
	override beginVisit(TFSM tfsm) 
	{
		println()
		if (isFirstExecutionStep())
		{
			tfsm.Init
		}
		println("Step " + _stepNumber + " - current state: " + tfsm.currentState.name)		
 		Thread.sleep(1000) 		
 		_stepNumber++
	}
	override endVisit(TFSM tfsm) 
	{
	}
	
	override beginVisit(FSMClock clock) 
	{
		clock.ticks
		_stepNumber = clock.numberOfTicks
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
 		if ((guard.afterDuration + _lastStateChangeStepNumber) == _stepNumber)
 		{
 			val transitionToFire = guard.eContainer as Transition
	 		//Thread.sleep(3000) 		
	 		println("fire transition " + transitionToFire.name)
			transitionToFire.fire 			
			_lastStateChangeStepNumber = _stepNumber		
 		}
	}
	override endVisit(TemporalGuard guard) 
	{
	}
		
	override beginVisit(EventGuard guard) 
	{
	}
	override endVisit(EventGuard guard) 
	{
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

