import 'http://org.gemoc.sigpml.model/1.0'

ECLimport "platform:/resource/org.gemoc.sample.sigpml.moc.lib/MoCLib/SigPML.ccslLib"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib" 
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib" 
 
package sigpml

	context Agent 
	def : startAgent: Event= self.execute()
	def : stopAgent: Event = self.stop()
	def : isExecuting :Event = self.isExecuting()
	
	context InputPort
	def : ratePlusOne : Integer = self.rate+1
	def : read : Event= self.read()
	
	context OutputPort
	def : write : Event= self.write()
	 
	context Place
	def : push :Event = self.push()
	def : pop :Event = self.pop()
	def : sizePlusOne:Integer = self.size+1
	def : delayPlusOne : Integer = self.delay +1
	
	context HWComputationalResource
	def : isExecuting : Event= self.incCycle()
	def : idle: Event= self
	
	context HWStorageResource
	def : isReading : Event= self 
	def : isWriting: Event= self
	
	context Place
	
	inv BoundedPlaces:
		(self.size > 0) implies
		let NwriteInAdvance :Event = Expression DelayFor((self.itsOutputPort.oclAsType(OutputPort)).write, (self.itsOutputPort.oclAsType(OutputPort)).write, self.sizePlusOne) in
		Relation Precedes((self.itsInputPort.oclAsType(InputPort)).read, NwriteInAdvance)
	
 	inv TokenConstraint:
 		let itsDelay : Integer = self.delay in
		Relation Token(
			((self).itsOutputPort.oclAsType(OutputPort)).write,
			((self).itsInputPort.oclAsType(InputPort)).read,
			itsDelay
		)

	inv waitEnoughData:
		let itsInputPortRate : Integer = self.itsInputPort.rate in
		Relation PlaceRate(
			self.itsInputPort.oclAsType(InputPort).read,
			self.push,
			itsInputPortRate,
			self.delayPlusOne
		)
	
	context InputPort
	inv AgentInputConstraint: 
		--it Should be possible to 'let' rate +1 here !!
		let itsRate : Integer = self.rate in
		Relation Input(
			self.owner.oclAsType(Agent).startAgent,
			self.read,
			self.ratePlusOne,
			itsRate
		)
		
	inv portReadInPlace:
		let associatedIPlace: Place = self.owner.owner.ownedPlaces->select(p | (p).itsInputPort = self)->first().oclAsType(Place) in
		Relation Coincides(self.read, (associatedIPlace).pop )

	context OutputPort
	inv AgentOutputConstraint:
		let itsORate : Integer = self.rate in
		Relation Output(
			self.owner.oclAsType(Agent).stopAgent,
			self.write,
			itsORate
		)
		
	inv portWriteInPlace:
		let associatedOPlace: Place = self.owner.owner.ownedPlaces->select(p | (p).itsOutputPort = self)->first().oclAsType(Place) in
		Relation Coincides(self.write, (associatedOPlace).push )
		
	context Agent 
	inv ComputationDelay:
		let itsExecTime : Integer = self.cycles in
		Relation AgentExecution(self.startAgent, self.stopAgent, self.isExecuting, itsExecTime)
		
	inv NonReentrantAgent:
		Relation Alternates(self.startAgent, self.stopAgent)

		
	context HWComputationalResource
	
	
	inv IsExecutingXorIdle:
		Relation Exclusion(self.isExecuting,self.idle)
	
	inv oneAgentAtATime:
		Relation Exclusion(self.allocatedAgents.oclAsType(Agent).isExecuting)
	
	inv ExecutesItsAllocatedAgents:
		let allAgentsExecutions : Event = Expression Union(self.allocatedAgents.oclAsType(Agent).isExecuting) in
		Relation Coincides(self.isExecuting, allAgentsExecutions)
		
	inv NonPreemptiveExecution:
		(self.isUnderPreemptiveManagement) implies
		let allAgentStarts : Event = Expression Union(self.allocatedAgents.oclAsType(Agent).startAgent) in
		let allAgentStops : Event = Expression Union(self.allocatedAgents.oclAsType(Agent).stopAgent) in
		Relation Alternates(allAgentStarts, allAgentStops)
		
	
	
	context HWStorageResource
	inv IsReadingXorWriting:
		Relation Exclusion(self.isReading,self.isWriting)
	
--	inv oneReadAtATime:
--		Relation Exclusion(self.allocatedPlaces.itsInputPort.read)
	inv oneWriteAtATime:
		Relation Exclusion(self.allocatedPlaces.itsOutputPort.oclAsType(OutputPort).write)
	
	inv isReadingAccordingToPortRead:
		let allPortReads : Event = Expression Union(self.allocatedPlaces.itsInputPort.oclAsType(InputPort).read) in
		Relation Coincides(self.isReading, allPortReads)
		
	inv isWritingAccordingToPortWrite:
		let allPortWrites : Event = Expression Union(self.allocatedPlaces.itsOutputPort.oclAsType(OutputPort).write) in
		Relation Coincides(self.isWriting, allPortWrites)
	
endpackage   