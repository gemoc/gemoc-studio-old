import 'platform:/resource/org.gemoc.sigpmldomain/model/sigpmldomain.ecore'
--import './sigpmldomain.ecore'

ECLimport "platform:/resource/org.gemoc.sample.xSigpml.mocc/mocc/xSigpml.moccml"
--ECLimport "./xSigpml.moccml"
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/kernel.ccslLib" 
ECLimport "platform:/plugin/fr.inria.aoste.timesquare.ccslkernel.model/ccsllibrary/CCSL.ccslLib" 


package sigpml
			  
	context Block 
		def : execute : Event = self.execute()
		    
			  
	context Connector	   
		inv ConnectorComputing: 
			let capacity : Integer = self.oclAsType(Connector).capacity in
		 	let inRate : Integer = self.itsInputPort.oclAsType(Port).rate in
		 	let outRate : Integer = self.itsOutputPort.oclAsType(Port).rate in
		 	let currentSize : Integer = self.oclAsType(Connector).currentSize in
    
		 Relation ConnectorSDF_PAM (
				self.itsOutputPort.oclAsType(OutputPort).owner.oclAsType(Block).execute,
				self.itsInputPort.oclAsType(InputPort).owner.oclAsType(Block).execute, 
				capacity,
				inRate,
				outRate,
				currentSize		  
			)        
			                   
	              
endpackage

