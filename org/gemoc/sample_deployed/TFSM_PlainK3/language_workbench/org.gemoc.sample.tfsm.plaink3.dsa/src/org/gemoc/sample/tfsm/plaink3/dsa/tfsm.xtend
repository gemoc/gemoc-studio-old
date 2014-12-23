package org.gemoc.sample.tfsm.plaink3.dsa

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
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TFSMAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.StateAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.TransitionAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.FSMClockAspect.*
//import org.gemoc.sample.tfsm.k3dsa.GroovyRunner
import fr.inria.diverse.k3.al.annotationprocessor.TransactionSupport


@Aspect(className=TFSM, transactionSupport = TransactionSupport.EMF)
class TFSMAspect 
{
	// should be added automatically by the dsa, currently introduced directly in the ecore
	// public State currentState;

	public State currentState

	def public String init() 
	{
		if (_self.currentState == null) 
		{
			_self.currentState = _self.initialState;
		}
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name)
	}
		
}

@Aspect(className=FSMClock)
class FSMClockAspect
{
	public Integer numberOfTicks = 0;

	// Clock tick
	def public Integer ticks() 
	{
		_self.numberOfTicks = _self.numberOfTicks + 1
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".ticks()]New number of ticks : " + _self.numberOfTicks.toString)
		return _self.numberOfTicks
	}
	
}

@Aspect(className=State)
class StateAspect 
{
	def public String onEnter() 
	{
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onEnter()]Entering " + _self.name)
	}

	def public String onLeave() 
	{
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".onLeave()]Leaving " + _self.name)
	}
}

@Aspect(className=Transition, transactionSupport=TransactionSupport.EMF)
class TransitionAspect 
{	
	def public String fire() 
	{
		_self.source.owningFSM.currentState = _self.target
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".fire()]Fired " + _self.name + " -> " +
			_self.action)
	}
}

@Aspect(className=FSMEvent)
class FSMEventAspect 
{
	
	public boolean isTriggered = false
	
}
