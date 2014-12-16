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
import static extension org.gemoc.sample.tfsm.plaink3.dsa.GuardAspect.*
import static extension org.gemoc.sample.tfsm.plaink3.dsa.FSMClockAspect.*
//import static extension org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspect.*
//import static extension org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspect.*
//import static extension org.gemoc.sample.tfsm.purek3.dsa.FSMEventAspect.*
//import static extension org.gemoc.sample.tfsm.purek3.dsa.TimedSystemAspect.*
//import static extension org.gemoc.sample.tfsm.k3dsa.EvaluateGuardAspect.*
//import org.gemoc.sample.tfsm.k3dsa.GroovyRunner
import fr.inria.diverse.k3.al.annotationprocessor.TransactionSupport


@Aspect(className=TimedSystem)
class TimedSystemAspect 
{

	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
 		_self.globalClocks.forEach[ e | e.accept(visitor)]
 		_self.tfsms.forEach[ t | t.accept(visitor)]
		visitor.endVisit(_self)
	}
	
}

@Aspect(className=TFSM, transactionSupport = TransactionSupport.EMF)
class TFSMAspect 
{
	// should be added automatically by the dsa, currently introduced directly in the ecore
	// public State currentState;

	public State currentState

	def public String Init() 
	{
		if (_self.currentState == null) 
		{
			_self.currentState = _self.initialState;
		}
		println("[" + _self.getClass().getSimpleName() + ":" + _self.getName() + ".Init()]Initialized " + _self.name)
	}
		
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
		if (_self.currentState == null)
		{
			_self.Init()
		}
		else
		{
			if (_self.localClock != null)
			{
				_self.localClock.accept(visitor)
			}
			_self.currentState.accept(visitor)			
		}
		visitor.endVisit(_self)
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
	
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
 		visitor.endVisit(_self)
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
	
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
 		_self.outgoingTransitions.forEach[ t | t.accept(visitor)]
		visitor.endVisit(_self)
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
	
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
		if (_self.ownedGuard != null)
		{
	 		_self.ownedGuard.accept(visitor)
		}
		visitor.endVisit(_self)
	}
}

@Aspect(className=Guard)
abstract class GuardAspect 
{
	abstract def public void accept(IVisitor visitor)
}

@Aspect(className=TemporalGuard)
class TemporalGuardAspect extends GuardAspect 
{
	
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
		visitor.endVisit(_self)
	}
	
}

@Aspect(className=EventGuard)
class EventGuardAspect extends GuardAspect 
{
	
	def public void accept(IVisitor visitor)
	{
		visitor.beginVisit(_self)
		visitor.endVisit(_self)
	}
	
}

@Aspect(className=FSMEvent)
class FSMEventAspect 
{
	
	public boolean isTriggered = false
	
}

//@Aspect(className=typeof(EvaluateGuard))
//class EvaluateGuardAspect extends GuardAspect {
//	def public Boolean evaluate() {
//		var Object res;
//		res = GroovyRunner.executeScript(_self.condition, _self)
//
//		return res as Boolean;
//	}
//	
//	def public void accept(Visitor visitor)
//	{
//		visitor.visit(_self)
//	}
//}
