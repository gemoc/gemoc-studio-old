package org.gemoc.sample.xsigpml.k3dsa

  

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import sigpml.Application
import sigpml.Block 
import sigpml.Port
import sigpml.InputPort
import sigpml.OutputPort
import sigpml.Connector
import sigpml.NamedElement

  

@Aspect(className=Application)
class ApplicationAspect extends org.gemoc.sample.xsigpml.k3dsa.NamedElementAspect {

		
}
  
  
@Aspect(className=Block)
class BlockAspect extends org.gemoc.sample.xsigpml.k3dsa.NamedElementAspect {

	public int currentExecCycle = 0


	def public void execute() {

		if ( _self.currentExecCycle < _self.cycles )
			_self.currentExecCycle = _self.currentExecCycle + 1
		else 
			_self.currentExecCycle = 0

		println(_self.name + "\n      execute (" + _self.currentExecCycle + ")" )
		
	}

}


@Aspect(className=Connector)
class ConnectorAspect extends org.gemoc.sample.xsigpml.k3dsa.NamedElementAspect {


	def public void push() {

		println( " Push on : " + _self.name + "\n ")
	}

	def public void pop() {

		println( " Pop on : " + _self.name + "\n ")
	}
	
}


@Aspect(className=NamedElement)
abstract class NamedElementAspect {

}



