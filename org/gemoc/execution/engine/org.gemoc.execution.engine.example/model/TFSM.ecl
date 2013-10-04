import 'http://org.gemoc.execution.engine.example.tfsm'

ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib"
ECLimport "platform:/resource/org.gemoc.execution.engine.example/model/TFSMMoC.ccslLib"


package tfsm
	
	context TfsmEvent
		def: occurs : Event(self) = GenericEvent
	
	context TfsmClock
		def: ticks : Event(self.tick()) = GenericEvent
		 
	context Transition
		def: fire : Event(self.fire()) = GenericEvent
	
	context State
		def : entering : Event(self.onEnter()) = StartEvent
		def : leaving : Event(self.onLeave()) = StopEvent
		
	context EvaluateGuard
		def : evaluate : Event (self.evaluate()) = GenericEvent
		def : evaluatedTrue : Event  (self) = GenericEvent
		def : evaluatedFalse : Event (self) = GenericEvent
	
	context Tfsm
		def: start : Event(self) = GenericEvent
		def: stall : Event = GenericEvent
		
	context TfsmEvent
		inv occursWhenSolicitate:
			(self.sollicitingTransitions->size() >0) implies  
			let AllTriggeringOccurrences : Event = Expression Union(self.sollicitingTransitions.fire) in
			Relation FSMEventSendReceive(AllTriggeringOccurrences, self.occurs)
	
	context Transition
	    inv fireWhenRestrueOccursTransition: 
	    	(self.ownedGuard.oclIsKindOf(EvaluateGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() = 0) implies
	    	let restrueOccursAfterOrWhileStateEntering :Event = Expression SampledOn(self.source.entering,self.ownedGuard.oclAsType(EvaluateGuard).evaluatedTrue) in
	    	Relation Coincides(restrueOccursAfterOrWhileStateEntering, self.fire) 
	    
	    inv fireWhenRestrueOccursVariousTransition:
			(self.ownedGuard.oclIsKindOf(EvaluateGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() > 0) implies
			let otherFireFromTheSameState3: Event = Expression Union (self.source.outgoingTransitions->select(t|t <> self).fire) in
		 	Relation EventTransition(self.source.entering,
		 							self.ownedGuard.oclAsType(EvaluateGuard).evaluatedTrue,
		 							otherFireFromTheSameState3,
		 							self.fire
		 	) 
	    
	    -- there is non rule when ocurrs various evaluate transitions
		inv fireWhenEventOccursOneTransition:
			(self.ownedGuard.oclIsKindOf(EventGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() = 0) implies
			let eventOccursAfterOrWhileStateEntering :Event = Expression SampledOn(self.source.entering,self.ownedGuard.oclAsType(EventGuard).triggeringEvent.occurs) in
			Relation Coincides(eventOccursAfterOrWhileStateEntering, self.fire) 
		
		inv fireWhenEventOccursVariousTransition:
			(self.ownedGuard.oclIsKindOf(EventGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() > 0) implies
			let otherFireFromTheSameState2: Event = Expression Union (self.source.outgoingTransitions->select(t|t <> self).fire) in
		 	Relation EventTransition(self.source.entering,
		 							self.ownedGuard.oclAsType(EventGuard).triggeringEvent.occurs,
		 							otherFireFromTheSameState2,
		 							self.fire
		 	) 
		
		inv fireWhenTemporalGuardHoldsVariousTransition:
			(self.ownedGuard.oclIsKindOf(TemporalGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() > 0) implies
			let guardDelay : Integer = self.ownedGuard.oclAsType(TemporalGuard).afterDuration in
			let otherFireFromTheSameState: Event = Expression Union (self.source.outgoingTransitions->select(t|t <> self).fire) in
			Relation TemporalTransition(self.source.entering,
									   self.ownedGuard.oclAsType(TemporalGuard).onClock.ticks,
									   otherFireFromTheSameState,
									   guardDelay,
									   self.fire
			) 
		

		inv fireWhenTemporalGuardHoldsOneTransition:
			(self.ownedGuard.oclIsKindOf(TemporalGuard) and self.source.outgoingTransitions->select(t|t <> self)->size() = 0) implies
			let delay : Integer = self.ownedGuard.oclAsType(TemporalGuard).afterDuration in
			let delayIsExpired_wrt_StateEntering :Event = Expression DelayFor(
															self.source.entering,
															self.owned