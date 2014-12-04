package org.gemoc.sample.tfsm.purek3.dsa

import org.gemoc.sample.tfsm.TFSM
import org.gemoc.sample.tfsm.State
import org.gemoc.sample.tfsm.Transition
import org.gemoc.sample.tfsm.TemporalGuard
import org.gemoc.sample.tfsm.EventGuard
import org.gemoc.sample.tfsm.EvaluateGuard
import org.gemoc.sample.tfsm.TimedSystem
import org.gemoc.sample.tfsm.FSMClock

interface IVisitor
{

 	def void beginVisit(TimedSystem system)
 	def void endVisit(TimedSystem system)
	
 	def void beginVisit(TFSM tfsm)
 	def void endVisit(TFSM tfsm)
	
	def void beginVisit(State state)
	def void endVisit(State state)

	def void beginVisit(Transition transition)
	def void endVisit(Transition transition)

	def void beginVisit(TemporalGuard guard)
	def void endVisit(TemporalGuard guard)

	def void beginVisit(EventGuard guard)
	def void endVisit(EventGuard guard)

	def void beginVisit(EvaluateGuard guard)
	def void endVisit(EvaluateGuard guard)

	def void beginVisit(FSMClock clock)
	def void endVisit(FSMClock clock)

}